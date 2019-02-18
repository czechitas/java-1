package cz.czechitas.demooken;

import javax.swing.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpousteciTrida::run);
    }

    public static void run() {
        HlavniOkno okno = new HlavniOkno();
        okno.setVisible(true);
    }

}
