package cz.czechitas.angrybirds.engine;

import javax.swing.*;

public class NullGameEndCommand extends AbstractCommand {

    private Engine engine;
    private MainWindow mainWindow;

    public NullGameEndCommand(Engine engine, MainWindow mainWindow) {
        super();
        this.engine = engine;
        this.mainWindow = mainWindow;
    }

    @Override
    protected void execute() {
        engine.terminate();
        mainWindow.endExecuted();
        JOptionPane.showMessageDialog(mainWindow,
                "Ještě tam nejsme. Angry bird musí strefit prase!",
                "Přihořívá...",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
