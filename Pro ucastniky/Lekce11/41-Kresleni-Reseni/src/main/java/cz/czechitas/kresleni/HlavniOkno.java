package cz.czechitas.kresleni;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labTitulek;
    JLabel labObrazek;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;
    BufferedImage obrazek;
    Graphics2D stetec;

    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
        obrazek = new BufferedImage(1920, 1080, BufferedImage.TYPE_4BYTE_ABGR);
        labObrazek.setIcon(new ImageIcon(obrazek));
        stetec = (Graphics2D) obrazek.getGraphics();
        stetec.setColor(new Color(150, 60, 0));
        stetec.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        stetec.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void priKliknutiNaLabObrazek(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        nakresliBod(x, y);
    }

    private void nakresliBod(int x, int y) {
        stetec.drawLine(x, y, x, y);
        labObrazek.repaint(x-5, y-5, x+5, y+5);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labTitulek = new JLabel();
        labObrazek = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreslen\u00ed");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets unrel,hidemode 3",
            // columns
            "[grow,fill]",
            // rows
            "[]" +
            "[grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labTitulek ----
        labTitulek.setText("Pl\u00e1tno:");
        contentPane.add(labTitulek, "cell 0 0");

        //---- labObrazek ----
        labObrazek.setHorizontalAlignment(SwingConstants.LEFT);
        labObrazek.setBorder(new BevelBorder(BevelBorder.LOWERED));
        labObrazek.setVerticalAlignment(SwingConstants.TOP);
        labObrazek.setOpaque(true);
        labObrazek.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                priKliknutiNaLabObrazek(e);
            }
        });
        labObrazek.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                priKliknutiNaLabObrazek(e);
            }
        });
        contentPane.add(labObrazek, "cell 0 1,grow,wmin 400,hmin 300");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
