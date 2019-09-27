package cz.czechitas.angrybirds.engine;

import javax.swing.*;

public interface VisualListener {

    void levelChanged();

    void startExecuted();

    void pauseExecuted();

    void resetExecuted();

    void nullEndExecuted();

    void negativeEndExecuted();

    void positiveEndExecuted();

}
