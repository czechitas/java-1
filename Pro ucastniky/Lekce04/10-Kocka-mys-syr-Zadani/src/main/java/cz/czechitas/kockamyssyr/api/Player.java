package cz.czechitas.kockamyssyr.api;

import java.awt.*;
import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import net.sevecek.util.*;

public abstract class Player extends Figure {

    private PlayerOrientation orientation;
    private Brain brain;
    private PlayerType type;

    protected Player() {
    }

    @Override
    @Deprecated
    protected void init(Icon picture, int x, int y) {
        throw new AssertionError("This method is inaccessible");
    }

    protected void init(Icon picture, int x, int y, PlayerType playerType) {
        orientation = PlayerOrientation.RIGHT;
        type = playerType;
        super.init(picture, x, y);
    }

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        if (this.brain != null) {
            Gameboard.getInstance().stopMoving(this);
        }
        this.brain = brain;
        Gameboard.getInstance().startMoving(this);
    }

    public PlayerOrientation getOrientation() {
        return orientation;
    }

    protected void setOrientation(PlayerOrientation orientation) {
        this.orientation = orientation;
        repaint();
    }

    public void moveForward() {
        moveForward(10);
    }

    public void moveForward(int pixels) {
        for (int i=0; i<pixels/5; i++) {
            ThreadUtils.sleep(20L);
            Utils.invokeLater(() -> {
                moveForwardInternal();
                repaint();
            });
        }
    }

    void moveForwardInternal() {
        if (!isPossibleToMoveForward()) return;

        JComponent sprite = getSprite();
        Point location = sprite.getLocation();
        if (getOrientation() == PlayerOrientation.RIGHT) {
            location.x += 5;
        }
        if (getOrientation() == PlayerOrientation.LEFT) {
            location.x -= 5;
        }
        if (getOrientation() == PlayerOrientation.UP) {
            location.y -= 5;
        }
        if (getOrientation() == PlayerOrientation.DOWN) {
            location.y += 5;
        }
        sprite.setLocation(location);

        Gameboard.getInstance().detectCollisionBetweenPlayers();
    }

    public void turnLeft() {
        ThreadUtils.sleep(10L);
        Utils.invokeLater(() -> {
            switch (getOrientation()) {
                case UP:
                    setOrientation(PlayerOrientation.LEFT);
                    break;
                case LEFT:
                    setOrientation(PlayerOrientation.DOWN);
                    break;
                case DOWN:
                    setOrientation(PlayerOrientation.RIGHT);
                    break;
                case RIGHT:
                    setOrientation(PlayerOrientation.UP);
                    break;
            }
        });
    }

    public void turnRight() {
        ThreadUtils.sleep(10L);
        Utils.invokeLater(() -> {
            switch (getOrientation()) {
                case UP:
                    setOrientation(PlayerOrientation.RIGHT);
                    break;
                case LEFT:
                    setOrientation(PlayerOrientation.UP);
                    break;
                case DOWN:
                    setOrientation(PlayerOrientation.LEFT);
                    break;
                case RIGHT:
                    setOrientation(PlayerOrientation.DOWN);
                    break;
            }
        });
    }

    public boolean isPossibleToMoveForward() {
        return Utils.invokeAndWait(() -> {
            boolean result = true;

            JLabel sprite = getSprite();
            Point location = sprite.getLocation();
            Point originalLocation = new Point(location);
            if (getOrientation() == PlayerOrientation.RIGHT) {
                location.x += 5;
            }
            if (getOrientation() == PlayerOrientation.LEFT) {
                location.x -= 5;
            }
            if (getOrientation() == PlayerOrientation.UP) {
                location.y -= 5;
            }
            if (getOrientation() == PlayerOrientation.DOWN) {
                location.y += 5;
            }

            if (location.x < 0 || location.y < 0
                    || location.x + sprite.getWidth() > sprite.getParent().getWidth()
                    || location.y + sprite.getHeight() > sprite.getParent().getHeight()) {
                result = false;
            }

            sprite.setLocation(location);
            if (Gameboard.getInstance().detectCollisionWithTrees(sprite)) {
                result = false;
            }
            sprite.setLocation(originalLocation);
            return result;
        }).booleanValue();
    }

    public PlayerType getType() {
        return type;
    }

    @Override
    public void remove() {
        Gameboard.getInstance().removePlayer(this);
        super.remove();
    }
}
