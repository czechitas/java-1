package cz.czechitas.angrybirds.engine;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.*;
import cz.czechitas.angrybirds.api.*;
import cz.czechitas.angrybirds.engine.tiles.*;
import cz.czechitas.angrybirds.engine.util.*;
import net.sevecek.util.*;

public class Game {

    private Map<String, LevelWrapper> levels;
    private String currentLevelName;
    private LevelWrapper currentLevel;

    public static final long STEP_TIMEOUT = 500L;
    private ExecutorService executor;
    private PauseBarrier pauseBarrier;

    private BirdTile bird;
    private PigTile pig;
    private GenericTile explosion;
    private List<GenericTile> walls;
    private String challengeText;

    private VisualListener visualListener;

    //-------------------------------------------------------------------------

    public Game() {
        executor = Executors.newSingleThreadExecutor();
        visualListener = NoOpVisualListener.getInstance();
        pauseBarrier = new PauseBarrier();
        explosion = new ExplosionTile();
        bird = new BirdTile();
        pig = new PigTile();
        walls = new ArrayList<>();

        // Public API hack so that public API can expose public static moveForward(); etc.
        Commands.setGlobalGame(this);
    }

    //-------------------------------------------------------------------------

    public void initializeLevels() {
        levels = findAllLevels();
    }

    private Map<String, LevelWrapper> findAllLevels() {
        try {
            String packageName = this.getClass().getPackage().getName().replace('.', '/');
            int slashPos = packageName.lastIndexOf("/");
            packageName = packageName.substring(0, slashPos) + "/" + "levels";

            ClassLoader classLoader = getClass().getClassLoader();
            URL classUrl = classLoader.getResource(packageName);
            File levelsFolder = new File(classUrl.toURI());
            String[] classFileNames = levelsFolder.list((dir, name) -> name.endsWith(".class"));

            Map<String, LevelWrapper> levels = new TreeMap<>();
            if (classFileNames != null) {
                for (String classFileName : classFileNames) {
                    classFileName = classFileName.substring(0, classFileName.length() - ".class".length());
                    String levelName = classFileName;
                    classFileName = packageName + "." + classFileName;
                    classFileName = classFileName.replace('/', '.');
                    Class<?> levelClass = classLoader.loadClass(classFileName);
                    Object level = levelClass.newInstance();
                    LevelWrapper levelWrapper = new LevelWrapper(level);
                    levels.put(levelName, levelWrapper);
                }
            }
            return levels;
        } catch (URISyntaxException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw ExceptionUtils.rethrowAsUnchecked(ex);
        }
    }

    public Collection<String> getLevelNames() {
        return levels.keySet();
    }

    //-------------------------------------------------------------------------

    public void setVisualListener(VisualListener listener) {
        visualListener = listener;
    }

    public List<GenericTile> getAllTiles() {
        List<GenericTile> tiles = new ArrayList<>(walls.size() + 3);
        tiles.addAll(walls);
        tiles.add(bird);
        tiles.add(pig);
        tiles.add(explosion);
        return tiles;
    }

    //-------------------------------------------------------------------------

    public void initCurrentLevel() {
        String previousLevelName = loadCurrentLevelFromFile();
        changeLevel(previousLevelName);
    }

    private String loadCurrentLevelFromFile() {
        try {
            File file = new File("current-level.txt");
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine().trim();
            return line;
        } catch (NumberFormatException | IOException e) {
            Logger.getAnonymousLogger().warning("Unable to save current level: " + e.getMessage());
            return "non-existent";
        }
    }

    public void changeLevel(String newLevelName) {
        if (currentLevelName != null && currentLevelName.equals(newLevelName)) {
            return;
        }
        if (levels.isEmpty()) {
            throw new ApplicationPublicException("Nebyly nalezeny žádné levely");
        }

        String previousLevelName = currentLevelName;
        LevelWrapper newLevel = levels.get(newLevelName);
        if (newLevel == null) {
            Map.Entry<String, LevelWrapper> levelEntry = levels.entrySet().iterator().next();
            newLevelName = levelEntry.getKey();
            newLevel = levelEntry.getValue();
        }
        currentLevelName = newLevelName;
        currentLevel = newLevel;
        clearPreviousLevel();
        newLevel.doSetupGameBoard();

        if (previousLevelName != null) {
            // If not first time level setup, save change
            saveCurrentLevelToFile(currentLevelName);
        }

        GameUtils.notifyVisualListener(visualListener::levelChanged);
    }

    //-------------------------------------------------------------------------

    public void setChallengeText(String text) {
        challengeText = text;
    }

    public void saveCurrentLevelToFile(String levelName) {
        try {
            File file = new File("current-level.txt");
            file.delete();
            OutputStream outputStream = new FileOutputStream(file, false);
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write(levelName);
            writer.close();
        } catch (IOException e) {
            Logger.getAnonymousLogger().warning("Unable to save current level: " + e.getMessage());
        }
    }

    public String getCurrentLevelName() {
        return currentLevelName;
    }

    public String getChallengeText() {
        return challengeText;
    }

    //-------------------------------------------------------------------------

    public void start() {
        if (pauseBarrier.isLocked()) {
            pauseBarrier.unlock();
        } else {
            executor.execute(this::executeProgramThread);
        }
        GameUtils.notifyVisualListener(visualListener::startExecuted);
    }

    public void pause() {
        pauseBarrier.lock();
        GameUtils.notifyVisualListener(visualListener::pauseExecuted);
    }

    public void reset() {
        terminate();
        pauseBarrier.unlock();
        clearPreviousLevel();
        currentLevel.doSetupGameBoard();
        GameUtils.notifyVisualListener(visualListener::resetExecuted);
    }

    private void clearPreviousLevel() {
        bird.setPosition(-1, -1);
        pig.setPosition(-1, -1);
        explosion.setPosition(-1, -1);
        clearWalls();
        challengeText = "";
    }

    public void terminate() {
        executor.shutdownNow();
        executor = Executors.newSingleThreadExecutor();
    }

    //-------------------------------------------------------------------------

    // Parallel program thread
    private void executeProgramThread() {
        try {
            ThreadUtils.sleep(STEP_TIMEOUT);
            currentLevel.doRun();
            ThreadUtils.sleep(3L * STEP_TIMEOUT);
            GameUtils.notifyVisualListener(visualListener::nullEndExecuted);
        } catch (CancellationException e) {
            // CancellationException is thrown if the program is either:
            // - finished by bird killing pig
            // - finished by bird killing itself
            // - reset (stopped)
            // - MainWindow is closed
            //
            // In all cases, it would be caused by terminate()
            // Handle it by swallowing the exception and terminate
        }
    }

    //- - - - - - - - -

    public void moveBirdForward() {
        pauseBarrier.goThrough();
        uiMoveBird();
        ThreadUtils.sleep(STEP_TIMEOUT);
    }

    public void turnBirdLeft() {
        pauseBarrier.goThrough();
        bird.turnLeft();
        ThreadUtils.sleep(STEP_TIMEOUT);
    }

    public void turnBirdRight() {
        pauseBarrier.goThrough();
        bird.turnRight();
        ThreadUtils.sleep(STEP_TIMEOUT);
    }

    public boolean isBirdPathForward() {
        pauseBarrier.goThrough();
        return uiBirdPathForward();
    }

    public boolean isBirdPathLeft() {
        pauseBarrier.goThrough();
        return uiBirdPathLeft();
    }

    public boolean isBirdPathRight() {
        pauseBarrier.goThrough();
        return uiBirdPathRight();
    }

    //- - - - - - - - -

    private void uiMoveBird() {
        bird.move();
        detectBirdOutOfRange();
        detectCollisionBirdAndPig();
        detectCollisionWithWall();
    }

    private boolean uiBirdPathForward() {
        Coordinates lookCoord = bird.getForwardLook();
        return isWall(lookCoord.getX(), lookCoord.getY());
    }

    private boolean uiBirdPathLeft() {
        Coordinates lookCoord = bird.getLeftLook();
        return isWall(lookCoord.getX(), lookCoord.getY());
    }

    private boolean uiBirdPathRight() {
        Coordinates lookCoord = bird.getRightLook();
        return isWall(lookCoord.getX(), lookCoord.getY());
    }

    private void detectBirdOutOfRange() {
        if (bird.getX() < 0 || bird.getX() >= 8 || bird.getY() < 0 || bird.getY() >= 8) {
            dieBird();
        }
    }

    public void detectCollisionBirdAndPig() {
        if (!notFinished()) {
            explode();
        }
    }

    public boolean notFinished() {
        return bird.getX() != pig.getX() || bird.getY() != pig.getY();
    }

    public void explode() {
        int x = pig.getX();
        int y = pig.getY();
        pig.setPosition(-1, -1);
        bird.setPosition(-1, -1);
        explosion.setPosition(x, y);
        ThreadUtils.sleep(3L * STEP_TIMEOUT);
        terminate();
        GameUtils.notifyVisualListener(visualListener::positiveEndExecuted);
    }

    public void detectCollisionWithWall() {
        for (GenericTile wall : walls) {
            int wallX = wall.getX();
            int wallY = wall.getY();
            if (wallX == bird.getX() && wallY == bird.getY()) {
                dieBird();
            }
        }
    }

    public void dieBird() {
        ThreadUtils.sleep(3L * STEP_TIMEOUT);
        terminate();
        GameUtils.notifyVisualListener(visualListener::negativeEndExecuted);
    }

    public void setWalls(Cell[][] cells) {
        clearWalls();
        int y = 0;
        for (Cell[] cellRow : cells) {
            int x = 0;
            for (Cell cell : cellRow) {
                if (cell == Cell.WOODEN_BOX) {
                    setWall(x, y, "wooden-wall.png");
                } else if (cell == Cell.STONE_BOX) {
                    setWall(x, y, "stone-wall.png");
                } else if (cell == Cell.WOODEN_TRIANGLE) {
                    setWall(x, y, "wooden-triangle.png");
                } else if (cell == Cell.STONE_TRIANGLE) {
                    setWall(x, y, "stone-triangle.png");
                } else if (cell == Cell.GLASS_TRIANGLE) {
                    setWall(x, y, "glass-triangle.png");
                } else if (cell == Cell.TNT) {
                    setWall(x, y, "tnt.png");
                }
                x++;
            }
            y++;
        }
    }

    private void setWall(int x, int y, String spriteName) {
        GenericTile wall = new GenericTile(spriteName);
        wall.setPosition(x, y);
        walls.add(wall);
    }

    private void clearWalls() {
        for (GenericTile wall : walls) {
            wall.setPosition(-1, -1);
        }
        walls.clear();
    }

    private boolean isWall(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return true;
        }
        for (GenericTile wall : walls) {
            int wallX = wall.getX();
            int wallY = wall.getY();
            if (wallX == x && wallY == y) {
                return false;
            }
        }
        return true;
    }

    //-------------------------------------------------------------------------

    public void setBirdPosition(int x, int y, BirdOrientation orientation) {
        bird.setPosition(x, y);
        bird.setOrientation(orientation);
    }

    public void setPigPosition(int x, int y) {
        pig.setPosition(x, y);
    }

}