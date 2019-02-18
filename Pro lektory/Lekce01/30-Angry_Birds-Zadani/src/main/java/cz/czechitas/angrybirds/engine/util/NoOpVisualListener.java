package cz.czechitas.angrybirds.engine.util;

import javax.swing.*;
import cz.czechitas.angrybirds.engine.*;
import cz.czechitas.angrybirds.engine.tiles.*;

public class NoOpVisualListener implements VisualListener, VisualTileListener {

    private static NoOpVisualListener instance = new NoOpVisualListener();

    public static NoOpVisualListener getInstance() {
        return instance;
    }

    private NoOpVisualListener() {
    }

    @Override
    public void levelChanged() {
    }

    @Override
    public void startExecuted() {
    }

    @Override
    public void pauseExecuted() {
    }

    @Override
    public void resetExecuted() {
    }

    @Override
    public void nullEndExecuted() {
    }

    @Override
    public void negativeEndExecuted() {
    }

    @Override
    public void positiveEndExecuted() {
    }

    @Override
    public void onIconChange(Icon sprite) {
    }

    @Override
    public void onLocationChange(int previousX, int previousY, int x, int y) {
    }
}
