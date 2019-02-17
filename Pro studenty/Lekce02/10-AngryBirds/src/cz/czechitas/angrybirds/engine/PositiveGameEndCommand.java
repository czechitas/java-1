package cz.czechitas.angrybirds.engine;

import javax.swing.*;

public class PositiveGameEndCommand extends AbstractCommand {

    private MainWindow mainWindow;
    private Engine engine;

    public PositiveGameEndCommand(MainWindow mainWindow, Engine engine) {
        this.mainWindow = mainWindow;
        this.engine = engine;
    }

    @Override
    protected void execute() {
        engine.terminate();
        mainWindow.positiveEndExecuted();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("cz/czechitas/angrybirds/images/tick.png"));
        JOptionPane.showMessageDialog(mainWindow,
                "Výborně! Pusťte se do dalšího levelu",
                "Výborně",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }
}
