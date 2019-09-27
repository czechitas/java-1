package cz.czechitas.piskvorky;

import javax.swing.*;
import net.sevecek.util.swing.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpousteciTrida::run);
    }

    public static void run() {
        SwingExceptionHandler.install();
        HlavniOkno okno = new HlavniOkno();
        okno.setVisible(true);
    }

}
