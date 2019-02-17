package cz.czechitas.angrybirds.engine;

import java.awt.event.*;
import java.util.concurrent.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.command.*;
import cz.czechitas.angrybirds.engine.gui.*;

public class ExecutionEngine {

    private LevelWrapper program;

    private TransferQueue<AbstractCommand> commandQueue = new LinkedTransferQueue<>();
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Timer timer = new Timer(400, this::consumeCommand);

    private VisualListener visualListener;

    public synchronized void setProgram(LevelWrapper program) {
        this.program = program;
    }

    public synchronized void setVisualListener(VisualListener listener) {
        visualListener = listener;
    }

    public synchronized void start() {
        timer.start();
        addCommand(new StartCommand(visualListener));
        executor.execute(this::executeProgramThread);
    }

    public synchronized void pause() {
        timer.stop();
        addCommand(new PauseCommand(visualListener));
    }

    public synchronized void reset() {
        terminate();
        addCommand(new ResetCommand(program, visualListener));
    }

    public synchronized void terminate() {
        timer.stop();
        commandQueue.clear();
        executor.shutdownNow();
        executor = Executors.newSingleThreadExecutor();
    }

    // Parallel program thread
    private void executeProgramThread() {
        try {
            program.doRun();
            addCommandExclusively(new NullGameEndCommand(this, visualListener));
        } catch (CancellationException e) {
            // This is OK, just finish and swallow the exception
        }
    }

    public synchronized void addCommand(AbstractCommand command) {
        commandQueue.add(command);
    }

    public synchronized void addCommandExclusively(AbstractCommand command) {
        commandQueue.clear();
        commandQueue.add(command);
    }

    public synchronized void addCommandAndWait(AbstractCommand command) {
        if (SwingUtilities.isEventDispatchThread()) {
            throw new AssertionError("Commands must not be enqueued from the event dispatch thread");
        }
        try {
            commandQueue.transfer(command);
        } catch (InterruptedException e) {
            throw new CancellationException();
        }
    }

    // This method will be invoked on the Swing's event dispatch thread
    private void consumeCommand(ActionEvent e) {
        AbstractCommand command = commandQueue.poll();
        if (command != null) {
            command.execute();
        }
    }
}
