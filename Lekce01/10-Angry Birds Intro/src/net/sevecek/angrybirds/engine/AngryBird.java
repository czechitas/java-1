package net.sevecek.angrybirds.engine;

import java.util.*;
import javax.swing.*;

public class AngryBird {

    private GameBoard gameBoard;
    private JLabel sprite;
    private Direction direction;
    private ImageIcon uiRightSprite;
    private ImageIcon uiLeftSprite;
    private ImageIcon uiUpSprite;
    private ImageIcon uiDownSprite;

    public AngryBird(BirdType character) {
        gameBoard = GameBoard.getInstance();

        if (character == BirdType.RED) {
            uiRightSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Red-right.png"));
            uiDownSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Red-down.png"));
            uiLeftSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Red-left.png"));
            uiUpSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Red-up.png"));
        } else if (character == BirdType.MATILDA){
            uiRightSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Matilda-right.png"));
            uiDownSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Matilda-down.png"));
            uiLeftSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Matilda-left.png"));
            uiUpSprite = new ImageIcon(this.getClass().getClassLoader().getResource("net/sevecek/angrybirds/images/Matilda-up.png"));
        } else {
            throw new IllegalArgumentException("You must select 1 of the allowed characters " + Arrays.toString(BirdType.values()));
        }

        direction = Direction.RIGHT;
        sprite = new JLabel();
        uiUpdateSprite();

        gameBoard.invokeAndWait(this::uiShow);
    }

    private void uiShow() {
        sprite.setSize(sprite.getPreferredSize());
        gameBoard.add(sprite);
    }

    public void move() {
        gameBoard.invokeAndWait(this::uiMove);
    }

    public void turnLeft() {
        gameBoard.invokeAndWait(this::uiTurnLeft);
    }

    public void turnRight() {
        gameBoard.invokeAndWait(this::uiTurnRight);
    }

    private void uiTurnRight() {
        if (direction == Direction.LEFT) {
            direction = Direction.UP;
        } else if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        }
        uiUpdateSprite();
    }

    private void uiTurnLeft() {
        if (direction == Direction.LEFT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.UP) {
            direction = Direction.LEFT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.UP;
        } else if (direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        }
        uiUpdateSprite();
    }

    private void uiUpdateSprite() {
        if (direction == Direction.LEFT) {
            sprite.setIcon(uiLeftSprite);
        } else if (direction == Direction.UP) {
            sprite.setIcon(uiUpSprite);
        } else if (direction == Direction.RIGHT) {
            sprite.setIcon(uiRightSprite);
        } else if (direction == Direction.DOWN) {
            sprite.setIcon(uiDownSprite);
        }
    }

    private void uiMove() {
        int x = sprite.getLocation().x;
        int y = sprite.getLocation().y;
        if (direction == Direction.RIGHT) {
            x = x + GameBoard.STEP_PIXELS;
        } else if (direction == Direction.UP) {
            y = y - GameBoard.STEP_PIXELS;
        } else if (direction == Direction.DOWN) {
            y = y + GameBoard.STEP_PIXELS;
        } else if (direction == Direction.LEFT) {
            x = x - GameBoard.STEP_PIXELS;
        }
        sprite.setLocation(x, y);
    }
}
