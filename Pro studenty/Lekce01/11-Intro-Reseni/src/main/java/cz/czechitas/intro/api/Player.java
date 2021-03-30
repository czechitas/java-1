package cz.czechitas.intro.api;

import java.awt.*;
import javax.swing.*;
import cz.czechitas.intro.engine.*;
import cz.czechitas.intro.engine.swing.*;
import net.sevecek.util.*;

import static cz.czechitas.intro.api.CollisionType.*;

public abstract class Player extends Figure {

    private PlayerOrientation orientation;
    private Brain brain;
    private PlayerType type;

    protected Player() {
    }

    @Override
    @Deprecated
    protected void init(Icon picture, int x, int y) {
        throw new UnsupportedOperationException("This method is inaccessible. Use init(Icon picture, int x, int y, PlayerType playerType) instead.");
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
            Gameplay.getInstance().stopMoving(this);
        }
        this.brain = brain;
        Gameplay.getInstance().startMoving(this);
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
        // Align to 5x5 grid
        location.x = location.x - location.x % 5;
        location.y = location.y - location.y % 5;
        sprite.setLocation(location);

        Gameplay.getInstance().detectCollisionBetweenPlayers();
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
            location.x = location.x - location.x % 5;
            location.y = location.y - location.y % 5;

            if (location.x < 0 || location.y < 0
                    || location.x + sprite.getWidth() > sprite.getParent().getWidth()
                    || location.y + sprite.getHeight() > sprite.getParent().getHeight()) {
                return false;
            }

            sprite.setLocation(location);
            boolean result = Gameplay.getInstance().detectCollisionWithPassiveFigures(this) == NO_COLLISION;
            sprite.setLocation(originalLocation);
            return result;
        }).booleanValue();
    }

    public PlayerType getType() {
        return type;
    }

    @Override
    public void remove() {
        Gameplay.getInstance().removePlayer(this);
        super.remove();
    }
}
