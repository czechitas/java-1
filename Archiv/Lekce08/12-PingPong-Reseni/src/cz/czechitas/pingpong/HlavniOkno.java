package cz.czechitas.pingpong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labMicek;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    int deltaX = -10;
    int deltaY = -10;
    Timer casovac;


    public HlavniOkno() {
        initComponents();
    }

    private void pohybMicku(ActionEvent e) {
        Point poziceMicku = labMicek.getLocation();
        int x = poziceMicku.x;
        int y = poziceMicku.y;

        x = x + deltaX;
        y = y + deltaY;
        if (x < 0) {
            deltaX = -deltaX;
        }
        if (y < 0) {
            deltaY = -deltaY;
        }
        if (x > (contentPane.getWidth() - labMicek.getWidth())) {
            deltaX = -deltaX;
        }
        if (y > (contentPane.getHeight() - labMicek.getHeight())) {
            deltaY = -deltaY;
        }

        poziceMicku.x = x;
        poziceMicku.y = y;
        labMicek.setLocation(poziceMicku);
    }

    private void priOtevreniOkna(WindowEvent evt) {
        casovac = new Timer(50, null);
        casovac.addActionListener(e -> pohybMicku(e));
        casovac.start();
    }

    private void priZaviraniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labMicek = new JLabel();

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
        labMicek.setBounds(new Rectangle(new Point(25, 235), labMicek.getPreferredSize()));

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
        setSize(400, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
