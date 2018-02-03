package cz.czechitas.desktopapp;

import java.awt.*;
import javax.swing.*;

public class HlavniOkno extends JFrame {

    public HlavniOkno() throws HeadlessException {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        //this.setLocation(100, 150);
        this.setLocationRelativeTo(null);
    }
}
