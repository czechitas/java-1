package cz.czechitas.sibenice;

import javax.swing.*;
import net.sevecek.util.swing.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpousteciTrida::run);
    }

    public static void run() {
        SwingExceptionHandler.install();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Nepodaøilo se nastavit System look and feel pro Swing");
        }

        HlavniOkno okno = new HlavniOkno();
        okno.setVisible(true);
    }

}
