package cz.czechitas.pexeso;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    KaretniSluzba karetniSluzba;
    JKarta vybranaKarta1;
    JKarta vybranaKarta2;


    public static final int POCET_PARU_KARET = 4;

    public HlavniOkno() {
        initComponents();
        karetniSluzba = new KaretniSluzba(new KartyJednorozcu(POCET_PARU_KARET));
        vyskladejKarty();
        nastavAkciPriKliknuti();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void nastavAkciPriKliknuti() {
        for (JKarta karta : karetniSluzba.getKarty()) {
            karta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    priKliknutiNaKartu(e, karta);
                }
            });
        }
    }

    private void priKliknutiNaKartu(MouseEvent e, JKarta karta) {
        if (vybranaKarta1 == null) {
            if (karta.jeVidetLic()) {
                return;
            }
            karta.otocLicemNahoru();
            vybranaKarta1 = karta;
        } else if (vybranaKarta2 == null) {
            if (karta.jeVidetLic()) {
                return;
            }
            karta.otocLicemNahoru();
            vybranaKarta2 = karta;
        } else {
            porovnejVybraneKarty();
            karetniSluzba.otocKartyRubemNahoru();
        }
    }

    private void porovnejVybraneKarty() {
        karetniSluzba.nechZmizetKartyPokudJsouStejne(vybranaKarta1, vybranaKarta2);
        if (!karetniSluzba.zbyvajiViditelneKarty()) {
            JOptionPane.showMessageDialog(this, "Gratulujeme! Vyhráli jste!", "Výhra", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void vyskladejKarty() {
        for (int i = 0; i < karetniSluzba.getKarty().size(); i++) {
            int x = (i % 4);
            int y = (i / 4);

            JKarta karta = karetniSluzba.getKarty().get(i);

            String pozice = "cell " + x + " " + y;

            System.err.println(pozice);

            contentPane.add(karta, pozice);
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("10-pexeso");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
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
