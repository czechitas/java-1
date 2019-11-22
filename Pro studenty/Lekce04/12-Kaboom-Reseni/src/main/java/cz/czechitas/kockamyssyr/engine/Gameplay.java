package cz.czechitas.kockamyssyr.engine;

import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import javax.swing.*;
import cz.czechitas.kockamyssyr.api.*;
import cz.czechitas.kockamyssyr.engine.swing.*;
import net.sevecek.util.*;

import static cz.czechitas.kockamyssyr.api.CollisionType.*;
import static cz.czechitas.kockamyssyr.api.PlayerType.*;

public class Gameplay {

    private static Gameplay instance = new Gameplay();

    public static Gameplay getInstance() {
        return instance;
    }

    private Gameplay() {
        explosionSprite = Utils.loadSprite("explosion.png");
        MainWindow.getInstance().addWindowClosingListener(this::stop);
    }

    //-------------------------------------------------------------------------

    private List<Player> allPlayers = new CopyOnWriteArrayList<>();
    private List<Figure> allPassiveFigures = new CopyOnWriteArrayList<>();
    private ExecutorService animationWorker = Executors.newCachedThreadPool();
    private Map<Brain, Future<?>> brainThreads = new ConcurrentHashMap<>();
    private Icon explosionSprite;

    //-------------------------------------------------------------------------

    public synchronized void addPassiveFigure(Figure f) {
        allPassiveFigures.add(f);
    }

    public synchronized void removePassiveFigure(Figure f) {
        allPassiveFigures.remove(f);
    }

    public synchronized void addPlayer(Player player) {
        allPlayers.add(player);
    }

    public synchronized void removePlayer(Player player) {
        stopMoving(player);
        allPlayers.remove(player);
        player.getSprite().setVisible(false);
        showExplosion(player.getSprite());
        if (player.getType() == FOOD) {
            checkMouseWins();
        } else if (player.getType() == GOOD) {
            checkCatWins();
        }
    }

    private synchronized void showExplosion(JLabel sprite) {
        animationWorker.execute(() -> {
            JLabel explosionComp = new JLabel(explosionSprite);
            Utils.invokeLater(() -> {
                explosionComp.setSize(explosionSprite.getIconWidth(), explosionSprite.getIconHeight());
                explosionComp.setLocation(sprite.getLocation());
                MainWindow.getInstance().add(explosionComp, "external");
                MainWindow.getInstance().repaint();
            });
            ThreadUtils.sleep(800L);
            Utils.invokeLater(() -> {
                MainWindow.getInstance().remove(explosionComp);
                MainWindow.getInstance().revalidate();
                MainWindow.getInstance().repaint();
            });
        });
    }

    public synchronized void startMoving(Player player) {
        Brain brain = player.getBrain();
        if (brain == null) return;
        Future<?> task = animationWorker.submit(() -> {
            try {
                brain.controlPlayer(player);
            } catch (CancellationException ex) {
                // Cancellation just means stop
            }
        });
        brainThreads.put(brain, task);
    }

    public synchronized void stopMoving(Player player) {
        Brain brain = player.getBrain();
        if (brain == null) return;
        Future<?> task = brainThreads.remove(brain);
        if (task != null) {
            task.cancel(true);
        }
    }

    public synchronized CollisionType detectCollisionWithAnyOtherFigure(Figure thisFigure) {
        JLabel sprite = thisFigure.getSprite();
        boolean isThisStackable = thisFigure instanceof Stackable;
        for (Player player : allPlayers) {
            if (Utils.detectCollision(player.getSprite(), sprite)) {
                if (isThisStackable && player instanceof Stackable) {
                    return STACKABLE_COLLISION;
                }
                return COLLISION;
            }
        }
        return detectCollisionWithPassiveFigures(thisFigure);
    }

    public synchronized CollisionType detectCollisionWithPassiveFigures(Figure thisFigure) {
        JLabel thisSprite = thisFigure.getSprite();
        boolean isThisStackable = thisFigure instanceof Stackable;
        for (Figure otherFigure : allPassiveFigures) {
            if (Utils.detectCollision(thisSprite, otherFigure.getSprite())) {
                if (isThisStackable && otherFigure instanceof Stackable) {
                    return STACKABLE_COLLISION;
                }
                return COLLISION;
            }
        }
        return NO_COLLISION;
    }

    public synchronized void detectCollisionBetweenPlayers() {
        for (Player player1 : allPlayers) {
            for (Player player2 : allPlayers) {
                if (player1.equals(player2)) continue;

                if (player1.getType().isCatching(player2.getType()) && Utils.detectCollision(player1.getSprite(), player2.getSprite())) {
                    player2.remove();
                }
            }
        }
    }

    private void checkMouseWins() {
        boolean existPlayerBeingHunted = false;
        for (Player player : allPlayers) {
            if (player.getType() == FOOD) {
                existPlayerBeingHunted = true;
            }
        }

        if (!existPlayerBeingHunted) {
            for (Player player : allPlayers) {
                stopMoving(player);
            }
            // TODO
            showMessage("Mouse wins!");
        }
    }

    private void checkCatWins() {
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
            // TODO
            showMessage("Cat wins!");
        }
    }

    private void showMessage(String text) {
        Utils.invokeLater(() -> {
            MainWindow.getInstance().showMessage(text);
        });
    }

    public synchronized void stop() {
        animationWorker.shutdownNow();
        Thread.currentThread().getThreadGroup().interrupt();
    }
}
