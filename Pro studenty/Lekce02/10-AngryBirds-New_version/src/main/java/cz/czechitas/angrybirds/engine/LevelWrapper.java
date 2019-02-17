package cz.czechitas.angrybirds.engine;

import java.lang.reflect.*;
import java.util.concurrent.*;
import net.sevecek.util.*;

public class LevelWrapper {

    private Object level;
    private Method setupGameBoardMethod;
    private Method runMethod;

    public LevelWrapper(Object level) {
        this.level = level;
        Class<?> levelClass = level.getClass();
        try {
            setupGameBoardMethod = levelClass.getDeclaredMethod("setupGameBoard");
            if (!setupGameBoardMethod.isAccessible()) {
                setupGameBoardMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException e) {
            try {
                levelClass.getDeclaredMethod("run");
            } catch (NoSuchMethodException e1) {
                throw new ApplicationPublicException(e, "Ve třídě {0} chybí metody:\n\n    void run() '{'\n        // Prikazy\n    '}'\n\n    void setupGameBoard() '{'\n        // Prikazy\n    '}'", levelClass.getSimpleName());
            }
            throw new ApplicationPublicException(e, "Ve třídě {0} chybí metoda:\n\n    void setupGameBoard() '{'\n        // Prikazy\n    '}'", levelClass.getSimpleName());
        }
        try {
            runMethod = levelClass.getDeclaredMethod("run");
            if (!runMethod.isAccessible()) {
                runMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException e) {
            throw new ApplicationPublicException(e, "Ve třídě {0} chybí metoda:\n\n    void run() '{'\n        // Prikazy\n    '}'", levelClass.getSimpleName());
        }
    }

    public void doSetupGameBoard() {
        try {
            setupGameBoardMethod.invoke(level);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw ExceptionUtils.rethrowAsUnchecked(ex);
        }
    }

    public void doRun() {
        try {
            runMethod.invoke(level);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw ExceptionUtils.rethrowAsUnchecked(ex);
        }
    }

}
