package cz.czechitas.kockamyssyr.api;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import cz.czechitas.kockamyssyr.engine.swing.*;
import net.sevecek.util.*;

import static cz.czechitas.kockamyssyr.api.CollisionType.*;

public abstract class Figure {

    private JLabel sprite;
    private volatile boolean isAlive = true;

    protected Figure() {
    }

    protected void init(Icon picture, int x, int y) {
        if (sprite != null) {
            throw new IllegalStateException("Already initialized");
        }
        Utils.invokeAndWait(() -> {
            sprite = new JLabel(picture);
            sprite.setLocation(x, y);
            sprite.setSize(picture.getIconWidth(), picture.getIconHeight());
            Container mainWindowContentPane = MainWindow.getInstance().getContentPane();
            mainWindowContentPane.add(sprite, "external");

            moveElsewhereIfColliding();
            mainWindowContentPane.repaint();
        });
    }

    private void moveElsewhereIfColliding() {
        Container mainWindowContentPane = MainWindow.getInstance().getContentPane();
        Gameplay gameplay = Gameplay.getInstance();
        int x = sprite.getX();
        int y = sprite.getY();
        int originalX = x;
        int originalY = y;
        while (true) {
            CollisionType collisionResult = gameplay.detectCollisionWithAnyOtherFigure(this);
            if (collisionResult == NO_COLLISION) {
                return;
            } else if (collisionResult == STACKABLE_COLLISION) {
                replaceWithStackedImage();
                return;
            } else {
                x = ((x / 50) * 50) + 50;
                if (x + sprite.getWidth() > mainWindowContentPane.getWidth()) {
                    x = originalX;
                    sprite.setLocation(x, y);
                    break;
                }
                sprite.setLocation(x, y);
            }
        }
        while (true) {
            CollisionType collisionResult = gameplay.detectCollisionWithAnyOtherFigure(this);
            if (collisionResult == NO_COLLISION) {
                return;
            } else if (collisionResult == STACKABLE_COLLISION) {
                replaceWithStackedImage();
                return;
            } else {
                y = ((y / 50) * 50) + 50;
                if (y + sprite.getHeight() > mainWindowContentPane.getHeight()) {
                    y = originalY;
                    sprite.setLocation(x, y);
                    break;
                }
                sprite.setLocation(x, y);
            }
        }

        Random randomGenerator = new Random();
        int attemptCount = 0;
        while (true) {
            x = (randomGenerator.nextInt(mainWindowContentPane.getWidth() - sprite.getWidth()) / 50) * 50;
            y = (randomGenerator.nextInt(mainWindowContentPane.getHeight() - sprite.getHeight()) / 50) * 50;
            sprite.setLocation(x, y);
            CollisionType collisionResult = gameplay.detectCollisionWithAnyOtherFigure(this);
            if (collisionResult == NO_COLLISION) {
                return;
            } else if (collisionResult == STACKABLE_COLLISION) {
                replaceWithStackedImage();
                return;
            }
            attemptCount++;
            if (attemptCount > 1000) {
                throw new ApplicationPublicException("We were unable to find a place for the figure even after many attempts. Is the gameboard full?");
            }
        }
    }

    private void replaceWithStackedImage() {
        sprite.getParent().setComponentZOrder(sprite, 1);
        sprite.setIcon(((Stackable) this).getStackableIcon());
    }

    public JLabel getSprite() {
        return sprite;
    }

    protected void repaint() {
        sprite.repaint();
    }

    public int getX() {
        return Utils.invokeAndWait(() -> {
            int x = sprite.getX();
            return x;
        });
    }

    public int getY() {
        return Utils.invokeAndWait(() -> {
            int y = sprite.getY();
            return y;
        });
    }

    public int getWidth() {
        return Utils.invokeAndWait(() -> {
            int width = sprite.getWidth();
            return width;
        });
    }

    public int getHeight() {
        return Utils.invokeAndWait(() -> {
            int height = sprite.getHeight();
            return height;
        });
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void remove() {
        Utils.invokeAndWait(() -> {
            isAlive = false;
            Container contentPane = MainWindow.getInstance().getContentPane();
            sprite.setVisible(false);
            contentPane.repaint();
        });
    }

}
