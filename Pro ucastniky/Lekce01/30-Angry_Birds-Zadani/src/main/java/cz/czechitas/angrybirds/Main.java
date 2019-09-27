package cz.czechitas.angrybirds;

import java.text.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.*;
import cz.czechitas.angrybirds.engine.gui.*;
import cz.czechitas.angrybirds.engine.util.*;
import net.sevecek.util.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::run);
    }

    public static void run() {
        SwingExceptionHandler.install();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Nepodařilo se nastavit System look and feel pro Swing");
        }

        Game game = new Game();
        game.initializeLevels();

        MainWindow mainWindow = new MainWindow(game);
        mainWindow.init();
    }

}
