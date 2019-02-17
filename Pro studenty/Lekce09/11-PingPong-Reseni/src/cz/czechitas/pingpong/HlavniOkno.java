package cz.czechitas.pingpong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labMicek;
    JLabel labLevyHrac;
    JLabel labPravyHrac;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    int deltaX = -10;
    int deltaY = -10;
    Timer casovac;
    JKeyboard klavesnice;

    public HlavniOkno() {
        initComponents();
    }

    private void priTiknutiCasovace(ActionEvent e) {
        pohybHraci();
        pohybMicku();
    }

    private void pohybHraci() {
        int levyHracX = labLevyHrac.getX();
        int levyHracY = labLevyHrac.getY();
        if (klavesnice.isKeyDown(KeyEvent.VK_W)) {
            levyHracY = levyHracY - 10;
            if (levyHracY < 0) {
                levyHracY = 0;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_S)) {
            levyHracY = levyHracY + 10;
            if (levyHracY+labLevyHrac.getHeight() > contentPane.getHeight()) {
                levyHracY = contentPane.getHeight() - labLevyHrac.getHeight();
            }
        }
        labLevyHrac.setLocation(levyHracX, levyHracY);

        int pravyHracX = labPravyHrac.getX();
        int pravyHracY = labPravyHrac.getY();
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            pravyHracY = pravyHracY - 10;
            if (pravyHracY < 0) {
                pravyHracY = 0;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            pravyHracY = pravyHracY + 10;
            if (pravyHracY+labPravyHrac.getHeight() > contentPane.getHeight()) {
                pravyHracY = contentPane.getHeight() - labPravyHrac.getHeight();
            }
        }
        labPravyHrac.setLocation(pravyHracX, pravyHracY);
    }

    private void pohybMicku() {
        int x = labMicek.getX();
        int y = labMicek.getY();

        x = x + deltaX;
        y = y + deltaY;
        if (y < 0) {
            deltaY = -deltaY;
        }
        if (y+labMicek.getHeight() > contentPane.getHeight()) {
            deltaY = -deltaY;
        }
        if (detekujKolizi(labLevyHrac, labMicek)) {
            deltaX = Math.abs(deltaX);
        }
        if (detekujKolizi(labPravyHrac, labMicek)) {
            deltaX = -Math.abs(deltaX);
        }
        if (x + labMicek.getWidth() < 0 || x > contentPane.getWidth()) {
            x = contentPane.getWidth() / 2 - labMicek.getWidth() / 2;
            y = contentPane.getHeight() / 2 - labMicek.getHeight() / 2;
            deltaX = -deltaX;
        }

        labMicek.setLocation(x, y);
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
        klavesnice = new JKeyboard();
        casovac = new Timer(50, it -> priTiknutiCasovace(it));
        casovac.start();
    }

    private void priZaviraniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labMicek = new JLabel();
        labLevyHrac = new JLabel();
        labPravyHrac = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PingPong");
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
        contentPane.setLayout(null);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labMicek ----
        labMicek.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pingpong/micek.png")));
        contentPane.add(labMicek);
        labMicek.setBounds(new Rectangle(new Point(160, 145), labMicek.getPreferredSize()));

        //---- labLevyHrac ----
        labLevyHrac.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pingpong/levy-hrac.png")));
        contentPane.add(labLevyHrac);
        labLevyHrac.setBounds(new Rectangle(new Point(35, 130), labLevyHrac.getPreferredSize()));

        //---- labPravyHrac ----
        labPravyHrac.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pingpong/pravy-hrac.png")));
        contentPane.add(labPravyHrac);
        labPravyHrac.setBounds(new Rectangle(new Point(640, 130), labPravyHrac.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(713, 466);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
