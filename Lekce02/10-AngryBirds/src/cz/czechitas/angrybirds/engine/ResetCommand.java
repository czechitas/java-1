package cz.czechitas.angrybirds.engine;

public class ResetCommand extends AbstractCommand {

    private Engine engine;
    private AbstractLevel program;
    private MainWindow mainWindow;

    public ResetCommand(Engine engine, AbstractLevel program, MainWindow mainWindow) {
        this.engine = engine;
        this.program = program;
        this.mainWindow = mainWindow;
    }

    @Override
    protected void execute() {
        program.setupLevel();
        mainWindow.resetExecuted();
    }
}
