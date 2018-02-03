package net.sevecek.angrybirds;

import javax.swing.*;
import net.sevecek.angrybirds.engine.*;
import net.sevecek.util.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showWindow);
    }

    private static void showWindow() {
        SwingExceptionHandler.install();
        JFrame mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

}
