package cz.czechitas.angrybirds.engine;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class GenericTile {

    private int x = -1;
    private int y = -1;
    private JLabel uiSpriteHolder;
    private ImageIcon uiSprite;
    private GameBoard gameBoard;

    public GenericTile(GameBoard gameBoard, String spriteName) {
        this.gameBoard = gameBoard;
        if (spriteName != null) {
            String uiSpriteFilename = "cz/czechitas/angrybirds/images/" + spriteName;
            ClassLoader loader = this.getClass().getClassLoader();
            try (InputStream stream = loader.getResourceAsStream(uiSpriteFilename)) {
                uiSprite = new ImageIcon(ImageIO.read(stream));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            uiSpriteHolder = new JLabel(uiSprite);
        } else {
            uiSpriteHolder = new JLabel();
        }
    }

    public void setSprite(Icon sprite) {
        uiSpriteHolder.setIcon(sprite);
    }

    public void setPosition(int x, int y) {
        if (this.x != -1) {
            gameBoard.getUIGrid().clearCell(this.x, this.y);
        }
        this.x = x;
        this.y = y;
        if (x != -1) {
            gameBoard.getUIGrid().setCell(x, y, uiSpriteHolder);
        }
        repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        setPosition(x, getY());
    }

    public void setY(int y) {
        setPosition(getX(), y);
    }

    public void repaint() {
        gameBoard.getUIGrid().repaint();
    }
}
