package cz.czechitas.kockamyssyr.api;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import net.sevecek.util.*;

public class Gameboard {

    private static Gameboard instance = new Gameboard();

    public static Gameboard getInstance() {
        return instance;
    }

    private Gameboard() {
        explosionSprite = Utils.loadSprite("success.png");
    }

    //-------------------------------------------------------------------------

    private List<Player> allPlayers = new CopyOnWriteArrayList<>();
    private List<Tree> allTrees = new CopyOnWriteArrayList<>();
    private ExecutorService worker = Executors.newCachedThreadPool();
    private Map<Brain, Thread> brainThreads = new ConcurrentHashMap<>();
    private Icon explosionSprite;

    //-------------------------------------------------------------------------

    public int getWidth() {
        return Utils.invokeAndWait(() -> {
            return MainWindow.getInstance().getContentPane().getWidth();
        });
    }

    public int getHeight() {
        return Utils.invokeAndWait(() -> {
            return MainWindow.getInstance().getContentPane().getHeight();
        });
    }

    public Dimension getSize() {
        return Utils.invokeAndWait(() -> {
            return MainWindow.getInstance().getContentPane().getSize();
        });
    }

    //-------------------------------------------------------------------------

    synchronized void addPlayer(Player player) {
        allPlayers.add(player);
    }

    synchronized void removePlayer(Player player) {
        stopMoving(player);
        allPlayers.remove(player);
        player.getSprite().setVisible(false);
        showExplosion(player.getSprite());
        checkWin();
        checkLoose();
    }

    private synchronized void showExplosion(JLabel sprite) {
        worker.execute(() -> {
            JLabel explosionComp = new JLabel(explosionSprite);
            Utils.invokeLater(() -> {
                explosionComp.setSize(explosionSprite.getIconWidth(), explosionSprite.getIconHeight());
                explosionComp.setLocation(sprite.getLocation());
                MainWindow.getInstance().add(explosionComp, "external");
                MainWindow.getInstance().repaint();
            });
            ThreadUtils.sleep(1000L);
            Utils.invokeLater(() -> {
                MainWindow.getInstance().remove(explosionComp);
                MainWindow.getInstance().revalidate();
                MainWindow.getInstance().repaint();
            });
        });
    }

    synchronized void startMoving(Player player) {
        worker.execute(() -> {
            try {
                Brain brain = player.getBrain();
                brainThreads.put(brain, Thread.currentThread());
                if (!Thread.currentThread().isInterrupted()) {
                    brain.controlPlayer(player);
                }
            } catch (CancellationException e) {
                // Cancellation just means stop
            }
        });
    }

    synchronized void stopMoving(Player player) {
        Brain brain = player.getBrain();
        if (brain != null) {
            Thread thread = brainThreads.remove(brain);
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    synchronized void addTree(Tree tree) {
        allTrees.add(tree);
    }

    synchronized void removeTree(Tree tree) {
        allTrees.remove(tree);
    }

    synchronized boolean detectCollisionWithAnyOtherFigure(JLabel sprite) {
        for (Player player : allPlayers) {
            if (Utils.detectCollision(player.getSprite(), sprite)) return true;
        }
        if (detectCollisionWithTrees(sprite)) return true;
        return false;
    }

    synchronized boolean detectCollisionWithTrees(JLabel sprite) {
        for (Tree tree : allTrees) {
            if (Utils.detectCollision(tree.getSprite(), sprite)) return true;
        }
        return false;
    }

    synchronized void detectCollisionBetweenPlayers() {
        for (Player player1 : allPlayers) {
            for (Player player2 : allPlayers) {
                if (player1.equals(player2)) continue;

                if (player1.getType().isCatching(player2.getType()) && Utils.detectCollision(player1.getSprite(), player2.getSprite())) {
                    removePlayer(player2);
                }
            }
        }
    }

    public synchronized void stop() {
        worker.shutdownNow();
        Thread.currentThread().getThreadGroup().interrupt();
    }

    private void checkWin() {
        boolean existPlayerBeingHunted = false;
        for (Player player : allPlayers) {
            if (player.getType() == PlayerType.FOOD) {
                existPlayerBeingHunted = true;
            }
        }

        if (!existPlayerBeingHunted) {
            for (Player player : allPlayers) {
                stopMoving(player);
            }
            showMessage("Congratulations!");
        }
    }

    private void checkLoose() {
        boolean existGoodPlayer = false;
        for (Player player : allPlayers) {
            if (player.getType() == PlayerType.GOOD) {
                existGoodPlayer = true;
            }
        }

        if (!existGoodPlayer) {
            for (Player player : allPlayers) {
                stopMoving(player);
            }
            showMessage("Game Over!");
        }
    }

    private void showMessage(String text) {
        Utils.invokeLater(() -> {
            JLabel message = new JLabel(text);
            Font font = message.getFont().deriveFont(50.0F);
            message.setFont(font);
            Dimension size = message.getPreferredSize();
            Container contentPane = MainWindow.getInstance().getContentPane();
            contentPane.add(message, "pos 50%-" + size.getWidth() / 2 + "px 50%-" + size.getHeight() / 2 + "px");
            contentPane.setComponentZOrder(message, 0);
            message.repaint();
        });
    }
}
