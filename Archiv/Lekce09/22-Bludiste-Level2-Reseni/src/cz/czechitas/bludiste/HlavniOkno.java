package cz.czechitas.bludiste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labZed1;
    JLabel labZed2;
    JLabel labZed3;
    JLabel labZed4;
    JLabel labZed5;
    JLabel labZed6;
    JLabel labZed7;
    JLabel labZed8;
    JLabel labZed9;
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
        pohybujRobotem();
    }

    private void pohybujRobotem() {
        int x = labRobot.getX();
        int y = labRobot.getY();
        int puvodniX = x;
        int puvodniY = y;

        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)) {
            x = x + 5;
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)) {
            x = x - 5;
        }
        if (!zkontrolujPohybRobota(puvodniX, puvodniY, x, y)) {
            x = puvodniX;
            y = puvodniY;
        } else {
            puvodniX = x;
            puvodniY = y;
        }

        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            y = y - 5;
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            y = y + 5;
        }

        zkontrolujPohybRobota(puvodniX, puvodniY, x, y);
    }

    private boolean zkontrolujPohybRobota(int puvodniX, int puvodniY, int x, int y) {
        labRobot.setLocation(x, y);
        if (detekujKolizi(labZed1, labRobot)
             || detekujKolizi(labZed2, labRobot)
             || detekujKolizi(labZed3, labRobot)
             || detekujKolizi(labZed4, labRobot)
             || detekujKolizi(labZed5, labRobot)
             || detekujKolizi(labZed6, labRobot)
             || detekujKolizi(labZed7, labRobot)
             || detekujKolizi(labZed8, labRobot)
             || detekujKolizi(labZed9, labRobot)
                ) {
            labRobot.setLocation(puvodniX, puvodniY);
            return false;
        }
        return true;
    }

    private boolean detekujKolizi(JComponent komponenta1, JComponent komponenta2) {
        int ax = komponenta1.getX();
        int ay = komponenta1.getY();
        int bx = ax + komponenta1.getWidth();
        int by = ay + komponenta1.getHeight();
        int cx = komponenta2.getX();
        int cy = komponenta2.getY();
        int dx = cx + komponenta2.getWidth();
        int dy = cy + komponenta2.getHeight();

        if (bx >= cx && by >= cy
                && ax <= dx && ay <= dy) {
            return true;
        } else {
            return false;
        }
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
        labZed1 = new JLabel();
        labZed2 = new JLabel();
        labZed3 = new JLabel();
        labZed4 = new JLabel();
        labZed5 = new JLabel();
        labZed6 = new JLabel();
        labZed7 = new JLabel();
        labZed8 = new JLabel();
        labZed9 = new JLabel();
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
            "insets 5px,hidemode 3,gap 0px 0px",
            // columns
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]",
            // rows
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]" +
            "[30px:30px:30px,fill]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labZed1 ----
        labZed1.setOpaque(true);
        labZed1.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed1, "cell 0 0 1 20");

        //---- labZed2 ----
        labZed2.setOpaque(true);
        labZed2.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed2, "cell 1 0 17 1");

        //---- labZed3 ----
        labZed3.setOpaque(true);
        labZed3.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed3, "cell 5 1 1 5");

        //---- labZed4 ----
        labZed4.setOpaque(true);
        labZed4.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed4, "cell 18 0 1 20");

        //---- labZed5 ----
        labZed5.setOpaque(true);
        labZed5.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed5, "cell 1 19 17 1");

        //---- labZed6 ----
        labZed6.setOpaque(true);
        labZed6.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed6, "cell 1 9 8 1");

        //---- labZed7 ----
        labZed7.setOpaque(true);
        labZed7.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed7, "cell 9 4 1 6");

        //---- labZed8 ----
        labZed8.setOpaque(true);
        labZed8.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed8, "cell 13 1 1 14");

        //---- labZed9 ----
        labZed9.setOpaque(true);
        labZed9.setBackground(new Color(0, 0, 153));
        contentPane.add(labZed9, "cell 4 14 9 1");

        //---- labRobot ----
        labRobot.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/bludiste/r2d2.png")));
        contentPane.add(labRobot, "pos 50px 50px");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
