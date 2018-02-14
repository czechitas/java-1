package cz.czechitas.angrybirds;

import javax.swing.*;
import cz.czechitas.angrybirds.engine.*;
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

        JFrame mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

}
