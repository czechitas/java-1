package cz.czechitas.bludiste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labRobot;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;
    Timer casovac;
    JKeyboard klavesnice;

    public HlavniOkno() {
        initComponents();
    }

    private void priTiknutiCasovace(ActionEvent e) {
        int x = labRobot.getX();
        int y = labRobot.getY();

        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)) {
            x = x + 5;
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)) {
            x = x - 5;
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            y = y - 5;
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            y = y + 5;
        }

        labRobot.setLocation(x, y);
    }

    private void priOtevreniOkna(WindowEvent e) {
        migLayoutManager.setComponentConstraints(labRobot, "external");
        klavesnice = new JKeyboard();
        casovac = new Timer(20, it -> priTiknutiCasovace(it));
        casovac.start();
    }

    private void priZaviraniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labRobot = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bludiste");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                priZaviraniOkna(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "[fill]",
            // rows
            "[fill]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labRobot ----
        labRobot.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/bludiste/r2d2.png")));
        contentPane.add(labRobot, "pos 50px 50px");
        setSize(400, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
