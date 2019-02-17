package cz.czechitas.angrybirds.engine;

public class PauseCommand extends AbstractCommand {

    private Engine engine;
    private MainWindow mainWindow;

    public PauseCommand(Engine engine, MainWindow mainWindow) {
        this.engine = engine;
        this.mainWindow = mainWindow;
    }

    @Override
    protected void execute() {
        mainWindow.pauseExecuted();
    }
}
