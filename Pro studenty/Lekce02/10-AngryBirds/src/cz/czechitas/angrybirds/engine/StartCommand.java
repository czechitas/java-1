package cz.czechitas.angrybirds.engine;

public class StartCommand extends AbstractCommand {

    private Engine engine;
    private MainWindow mainWindow;

    public StartCommand(Engine engine, MainWindow mainWindow) {
        this.engine = engine;
        this.mainWindow = mainWindow;
    }

    @Override
    protected void execute() {
        mainWindow.startExecuted();
    }
}
