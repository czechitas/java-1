package cz.czechitas.intro.engine.swing;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import javax.imageio.*;
import javax.swing.*;
import net.sevecek.util.*;

public class Utils {

    public static final String SPRITE_FOLDER = "images/";
    private static Map<String, Icon> spriteCache = new HashMap<>();

    public synchronized static Icon loadSprite(String spriteName) {
        Icon sprite = spriteCache.get(spriteName);
        if (sprite != null) {
            return sprite;
        }

        String spriteFilename = SPRITE_FOLDER + spriteName;
        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(spriteFilename)) {
            if (stream == null) {
                throw new IllegalArgumentException("Unable to find file classpath:/" + spriteName);
            }
            sprite = new ImageIcon(ImageIO.read(stream));
            spriteCache.put(spriteName, sprite);
            return sprite;
        } catch (IOException ex) {
            throw new IllegalArgumentException("Unable to find file classpath:/" + spriteName);
        }
    }

    public static <RESULT> RESULT invokeAndWait(Callable<RESULT> code) {
        if (Thread.currentThread().isInterrupted()) {
            throw new CancellationException();
        }
        Utils.Holder<RESULT> result = new Utils.Holder<>();
        if (!SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(() -> {
                    try {
                        result.value = code.call();
                    } catch (Exception e) {
                        throw ExceptionUtils.rethrowAsUnchecked(e);
                    }
                });
            } catch (InterruptedException e) {
                throw new CancellationException();
            } catch (InvocationTargetException e) {
                throw ExceptionUtils.rethrowAsUnchecked(e);
            }
        } else {
            try {
                result.value = code.call();
            } catch (Exception e) {
                throw ExceptionUtils.rethrowAsUnchecked(e);
            }
        }
        return result.value;
    }

    public static void invokeAndWait(Runnable code) {
        if (Thread.currentThread().isInterrupted()) {
            throw new CancellationException();
        }
        if (!SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(code);
            } catch (Exception e) {
                throw ExceptionUtils.rethrowAsUnchecked(e);
            }
        } else {
            code.run();
        }
    }

    public static void invokeLater(Runnable code) {
        invokeAndWait(code);
//        if (Thread.currentThread().isInterrupted()) {
//            throw new CancellationException();
//        }
//        if (!SwingUtilities.isEventDispatchThread()) {
//            SwingUtilities.invokeLater(code);
//        } else {
//            code.run();
//        }
    }

    public static boolean detectCollision(JComponent component1, JComponent component2) {
        if (component1.equals(component2)) return false;

        int ax = component1.getX();
        int ay = component1.getY();
        int bx = component1.getX() + component1.getWidth();
        int by = component1.getY() + component1.getHeight();
        int cx = component2.getX();
        int cy = component2.getY();
        int dx = component2.getX() + component2.getWidth();
        int dy = component2.getY() + component2.getHeight();

        if (bx > cx && by > cy
                && ax < dx && ay < dy) {
            return true;
        } else {
            return false;
        }
    }

    //-------------------------------------------------------------------------

    private static class Holder<T> {

        T value;

    }
}
