package cz.czechitas.angrybirds.engine;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;
import java.util.List;
import java.util.logging.*;

public class MainWindow extends JFrame {

    private Engine engine;
    private GameBoard gameBoard;
    private Map<String, AbstractLevel> levels;
    private Map<String, JToggleButton> btnLevels;
    private JButton btnStart;
    private JButton btnPause;
    private JButton btnReset;
    private JPanel pnlLevels;
    private JPanel pnlTop;
    private JPanel pnlNorth;
    private JLabel labInfo;

    public MainWindow() {
        super("AngryBirds");
        initComponents();
    }

    private void initComponents() {
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    onWindowClosing(e);
                }
            });
            setResizable(false);

            JLayeredPane layrBackground = new JLayeredPane();
            layrBackground.setSize(8*50, 8*50);

            ImageIcon imgBackground = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("cz/czechitas/angrybirds/images/Background.png")));
            JLabel labBackground = new JLabel(imgBackground);
            labBackground.setSize(new Dimension(imgBackground.getIconWidth(), imgBackground.getIconHeight()));
            layrBackground.add(labBackground, 1);
            layrBackground.setPreferredSize(labBackground.getSize());

            JGrid panGrid = new JGrid(8, 8);
            panGrid.init(labBackground.getSize());
            layrBackground.add(panGrid, 0);

            pnlTop = new JPanel(new FlowLayout());
            btnStart = new JButton("Start");
            btnStart.addActionListener(this::onStartClicked);
            pnlTop.add(btnStart);

            btnPause = new JButton("Pause");
            btnPause.setEnabled(false);
            btnPause.addActionListener(this::onPauseClicked);
            pnlTop.add(btnPause);

            btnReset = new JButton("Reset");
            btnReset.setEnabled(false);
            btnReset.addActionListener(this::onResetClicked);
            pnlTop.add(btnReset);

            labInfo = new JLabel("<html>Level description</html>");
            Font font = labInfo.getFont();
            Font newFont = font.deriveFont(font.getSize() * 1.5F);
            labInfo.setFont(newFont);
            labInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
            add(labInfo, BorderLayout.SOUTH);

            //-----------------------------------------------------------------

            initializeLevels(panGrid);

            pnlNorth = new JPanel();
            pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
            pnlNorth.add(pnlLevels, BorderLayout.NORTH);
            pnlNorth.add(pnlTop, BorderLayout.NORTH);
            add(pnlNorth, BorderLayout.NORTH);
            add(layrBackground, BorderLayout.CENTER);
            pack();
            setLocationRelativeTo(null);

            btnStart.requestFocus();
            getRootPane().setDefaultButton(btnStart);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeLevels(JGrid panGrid) {
        engine = new Engine(this);
        gameBoard = new GameBoard(this, engine, panGrid);

        levels = new TreeMap<>();
        try {
            String packageName = "cz/czechitas/angrybirds/levels";

            ClassLoader classLoader = getClass().getClassLoader();
            URL classUrl = classLoader.getResource(packageName);
            File levelsFolder = new File(classUrl.toURI());
            String[] classFileNames = levelsFolder.list((dir, name) -> name.endsWith(".class"));
            for (String classFileName : classFileNames) {
                classFileName = classFileName.substring(0, classFileName.length()-".class".length());
                String levelName = classFileName;
                classFileName = packageName + "." + classFileName;
                classFileName = classFileName.replace('/', '.');
                Class<?> levelClass = classLoader.loadClass(classFileName);
                if (AbstractLevel.class.isAssignableFrom(levelClass)) {
                    Constructor<?> constructor = levelClass.getConstructor(GameBoard.class);
                    AbstractLevel level = (AbstractLevel) constructor.newInstance(gameBoard);
                    levels.put(levelName, level);
                }
            }
        } catch (URISyntaxException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        pnlLevels = new JPanel(new FlowLayout());
        pnlLevels.add(new JLabel("Level:"));
        btnLevels = new TreeMap<>();
        for (Map.Entry<String, AbstractLevel> levelEntry : levels.entrySet()) {
            String levelName = levelEntry.getKey();
            JToggleButton btnSingleLevel = new JToggleButton(levelName);
            btnSingleLevel.addActionListener((e) -> onChangeLevelClicked(levelName));
            btnLevels.put(levelName, btnSingleLevel);
            pnlLevels.add(btnSingleLevel);
        }

        String previousLevelName = loadPreviousLevelFromFile();
        if (previousLevelName != null) {
            if (levels.get(previousLevelName) != null) {
                onChangeLevelClicked(previousLevelName);
            }
        }
    }

    private void onChangeLevelClicked(String selectedLevelName) {
        for (Map.Entry<String, JToggleButton> buttonEntry : btnLevels.entrySet()) {
            String levelName = buttonEntry.getKey();
            if (levelName.equals(selectedLevelName)) {
                buttonEntry.getValue().setSelected(true);
            } else {
                buttonEntry.getValue().setSelected(false);
            }
        }
        AbstractLevel program = levels.get(selectedLevelName);
        engine.setProgram(program);
        engine.reset();
        labInfo.setText(program.getInfo());
        pack();
        savePreviousLevelToFile(selectedLevelName);
    }

    private void savePreviousLevelToFile(String levelName) {
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

    private String loadPreviousLevelFromFile() {
        try {
            File file = new File("current-level.txt");
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine().trim();
            return line;
        } catch (NumberFormatException | IOException e) {
            Logger.getAnonymousLogger().warning("Unable to save current level: " + e.getMessage());
            return null;
        }
    }

    private void onStartClicked(ActionEvent e) {
        engine.start();
    }

    private void onPauseClicked(ActionEvent e) {
        engine.pause();
    }

    private void onResetClicked(ActionEvent e) {
        engine.reset();
    }

    private void onWindowClosing(WindowEvent e) {
        engine.terminate();
    }

    //-------------------------------------------------------------------------
    // Callbacks from the Engine

    public void startExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(true);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnPause);
        btnPause.requestFocus();
    }

    public void pauseExecuted() {
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnStart);
        btnStart.requestFocus();
    }

    public void resetExecuted() {
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        getRootPane().setDefaultButton(btnStart);
        btnStart.requestFocus();
    }

    public void endExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnReset);
        btnReset.requestFocus();
    }

    public void positiveEndExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnReset);
        btnReset.requestFocus();
    }
}
