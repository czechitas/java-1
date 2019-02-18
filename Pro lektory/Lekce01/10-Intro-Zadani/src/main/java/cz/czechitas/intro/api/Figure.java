package cz.czechitas.intro.api;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import cz.czechitas.intro.engine.*;
import net.sevecek.util.*;

public abstract class Figure {

    private JLabel sprite;
    private volatile boolean isRemoved;

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

            moveElsewhereIfCollision();
            mainWindowContentPane.repaint();
        });
    }

    private void moveElsewhereIfCollision() {
        Container mainWindowContentPane = MainWindow.getInstance().getContentPane();
        Gameboard gameboard = Gameboard.getInstance();
        int x = sprite.getX();
        int y = sprite.getY();
        int originalX = x;
        int originalY = y;
        while (true) {
            boolean collision = gameboard.detectCollisionWithAnyOtherFigure(sprite);
            if (!collision) return;
            x = x + 1;
            if (x + sprite.getWidth() > mainWindowContentPane.getWidth()) {
                x = originalX;
                sprite.setLocation(x, y);
                break;
            }
            sprite.setLocation(x, y);
        }
        while (true) {
            boolean collision = gameboard.detectCollisionWithAnyOtherFigure(sprite);
            if (!collision) return;
            y = y + 1;
            if (y + sprite.getHeight() > mainWindowContentPane.getHeight()) {
                y = originalY;
                sprite.setLocation(x, y);
                break;
            }
            sprite.setLocation(x, y);
        }

        Random randomGenerator = new Random();
        int attemptCount = 0;
        while (gameboard.detectCollisionWithAnyOtherFigure(sprite)) {
            x = randomGenerator.nextInt(mainWindowContentPane.getWidth() - sprite.getWidth());
            y = randomGenerator.nextInt(mainWindowContentPane.getHeight() - sprite.getHeight());
            sprite.setLocation(x, y);
            attemptCount++;
            if (attemptCount > 1000) {
                throw new ApplicationPublicException("Ani po mnoha pokusech se nepodařilo najít volné místo pro figurku. Plocha je nejspíš plná.");
            }
        }
    }

    protected JLabel getSprite() {
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

    public boolean isRemoved() {
        return isRemoved;
    }

    public void remove() {
        Utils.invokeAndWait(() -> {
            isRemoved = true;
            Container contentPane = MainWindow.getInstance().getContentPane();
            sprite.setVisible(false);
            contentPane.repaint();
        });
    }

}
