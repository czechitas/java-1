package cz.czechitas.angrybirds.engine;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class GameBoard {

    private MainWindow mainWindow;
    private Engine engine;
    private JGrid uiGrid;
    private AngryBird bird;
    private Pig pig;
    private GenericTile explosion;
    private List<GenericTile> walls;

    public GameBoard(MainWindow mainWindow, Engine engine, JGrid uiGrid) {
        this.mainWindow = mainWindow;
        this.engine = engine;
        this.uiGrid = uiGrid;
        this.bird = new AngryBird(engine, this);
        this.pig = new Pig(this);
        this.explosion = new GenericTile(this, "explosion.png");
        walls = new ArrayList<>();
    }

    public void detectCollisionWithPig() {
        if (pig.getX() == bird.getX() && pig.getY() == bird.getY()) {
            explode();
        }
    }

    public void explode() {
        int x = pig.getX();
        int y = pig.getY();
        pig.setPosition(-1, -1);
        bird.setPosition(-1, -1);
        explosion.setPosition(x, y);

        // TODO: Fix repaint
        forceRepaint();

        new PositiveGameEndCommand(this.mainWindow, engine).execute();
    }

    public void forceRepaint() {
        JRootPane rootPane = uiGrid.getRootPane();
        if (rootPane != null) {
            Container mainWindow = rootPane.getParent();
            if (mainWindow != null) {
                Dimension size = mainWindow.getSize();
                size.height = size.height + 1;
                mainWindow.setSize(size);
                size.height = size.height - 1;
                mainWindow.setSize(size);
            }
        }
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

    public boolean birdGetsPig() {
        return bird.getX() == pig.getX() && bird.getY() == pig.getY();
    }

    public void dieBird() {
        new NegativeGameEndCommand(mainWindow, engine).execute();
    }

    public JGrid getUIGrid() {
        return uiGrid;
    }

    public AngryBird getBird() {
        return bird;
    }

    public void setAngryBird(AngryBird angryBird) {
        this.bird = angryBird;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }

    public Pig getPig() {
        return pig;
    }

    public void clearWalls() {
        for (GenericTile wall : walls) {
            wall.setPosition(-1, -1);
        }
        walls.clear();
    }

    public void setWoodenWall(int x, int y) {
        GenericTile wall = new GenericTile(this, "wooden-wall.png");
        wall.setPosition(x, y);
        walls.add(wall);
    }

    public void reset() {
        explosion.setPosition(-1, -1);
    }

    public boolean isWall(int x, int y) {
        for (GenericTile wall : walls) {
            int wallX = wall.getX();
            int wallY = wall.getY();
            if (wallX == x && wallY == y) {
                return false;
            }
        }
        return true;
    }

}