package cz.czechitas.angrybirds.engine;

import javax.swing.*;

public class NegativeGameEndCommand extends AbstractCommand {

    private MainWindow mainWindow;
    private Engine engine;

    public NegativeGameEndCommand(MainWindow mainWindow, Engine engine) {
        this.mainWindow = mainWindow;
        this.engine = engine;
    }

    @Override
    protected void execute() {
        engine.terminate();
        mainWindow.endExecuted();
        JOptionPane.showMessageDialog(mainWindow,
                "Ale ne...! Angry bird musí strefit prase!",
                "Bohužel",
                JOptionPane.ERROR_MESSAGE);
    }
}
