package cz.czechitas.angrybirds.engine;

import java.awt.event.*;
import java.util.concurrent.*;
import javax.swing.Timer;

public class Engine {

    private AbstractLevel program;
    private MainWindow mainWindow;

    private TransferQueue<AbstractCommand> commandQueue = new LinkedTransferQueue<>();
    private ExecutorService executor;
    private Timer timer = new Timer(500, this::consumeCommand);

    public Engine(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setProgram(AbstractLevel program) {
        this.program = program;
        program.setupLevel();
    }

    public void start() {
        new StartCommand(this, mainWindow).execute();
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
            executor.execute(this::runProgram);
        }
        timer.start();
    }

    public void pause() {
        timer.stop();
        new PauseCommand(this, mainWindow).execute();
    }

    public void reset() {
        terminate();
        new ResetCommand(this, program, mainWindow).execute();
    }

    public void terminate() {
        timer.stop();
        commandQueue.clear();
        if (executor != null) {
            executor.shutdownNow();
            executor = null;
        }
    }

    // Parallel program thread
    private void runProgram() {
        try {
            program.run();
            addCommand(new NullGameEndCommand(this, mainWindow));
        } catch (CancellationException e) {
            // This is OK, just finish and swallow the exception
        }
    }

    // Parallel program thread
    public void addCommand(AbstractCommand command) {
        try {
            commandQueue.transfer(command);
        } catch (InterruptedException e) {
            throw new CancellationException();
        }
    }

    public void consumeCommand(ActionEvent e) {
        AbstractCommand command = commandQueue.poll();
        if (command != null) {
            command.execute();
        }
    }

}
