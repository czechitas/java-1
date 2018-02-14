package cz.czechitas.pexeso;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;
    List<JLabel> seznamKaret;
    Icon obrazekRubuKaret;

    public HlavniOkno() {
        initComponents();
    }

    private void inicializujKarty() {
        obrazekRubuKaret = nahrajObrazek("/cz/czechitas/pexeso/obrazky/rub.jpg");

        seznamKaret = new ArrayList<>();
        Icon obrazekLiceKarty = null;
        for (int indexKarty = 0; indexKarty < 16; indexKarty++) {
            if (indexKarty % 2 == 0) {
                String nazevSouboru = "obrazky/" + (indexKarty / 2 + 1) + ".jpg";
                obrazekLiceKarty = nahrajObrazek(nazevSouboru);
            }

            JLabel karta = new JLabel(obrazekLiceKarty);
            String migLayoutPozicovani = vypocitejPozicovaniProMigLayout(indexKarty);
            contentPane.add(karta, migLayoutPozicovani);
            seznamKaret.add(karta);
        }
    }

    private ImageIcon nahrajObrazek(String soubor) {
        try {
            return new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream(soubor)));
        } catch (IOException ex) {
            throw new ApplicationPublicException(ex, "Nepodařilo se nahrát obrázek {0}", soubor);
        }
    }

    private String vypocitejPozicovaniProMigLayout(int indexKarty) {
        int x = (indexKarty % 4) + 1;
        int y = (indexKarty / 4) + 1;
        return "cell " + x + " " + y;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pexeso");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "[grow,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[grow,fill]",
            // rows
            "[grow,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        inicializujKarty();

        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
