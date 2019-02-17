package net.sevecek.angrybirds.engine;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class GameBoard {

    public static final long GAME_SPEED = 400L;
    public static final int STEP_PIXELS = 25;
    private static GameBoard instance = new GameBoard();

    public static GameBoard getInstance() {
        return instance;
    }

    //-------------------------------------------------------------------------

    private Random random;
    private JFrame window;

    private GameBoard() {
        random = new Random();
        window = new JFrame("Demo");
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(600, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void add(JLabel sprite) {
        int x = (window.getContentPane().getWidth() - sprite.getWidth()) / 2;
        int y = (window.getContentPane().getHeight() - sprite.getHeight()) / 2;

        sprite.setLocation(x, y);
        window.add(sprite);
        window.repaint();
    }

    public void invokeAndWait(Runnable method) {
        try {
            SwingUtilities.invokeAndWait(method);
            Thread.sleep(GAME_SPEED);
        } catch (InterruptedException e) {
            throw new CancellationException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
