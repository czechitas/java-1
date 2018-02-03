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
    List<JKarta> seznamKaret;
    JKarta zvolenaKarta1;
    JKarta zvolenaKarta2;

    public HlavniOkno() {
        initComponents();
    }

    private void inicializujKarty() {
        vytvorKarty();
        zamichejKarty();
    }

    private void vytvorKarty() {
        Icon obrazekRubuKaret = nahrajObrazek("/cz/czechitas/pexeso/obrazky/rub.jpg");

        seznamKaret = new ArrayList<>();
        Icon obrazekLiceKarty = null;
        for (int indexKarty = 0; indexKarty < 16; indexKarty++) {
            if (indexKarty % 2 == 0) {
                String nazevSouboru = "/cz/czechitas/pexeso/obrazky/" + (indexKarty / 2 + 1) + ".jpg";
                obrazekLiceKarty = nahrajObrazek(nazevSouboru);
            }

            JKarta karta = new JKarta(indexKarty, obrazekLiceKarty, obrazekRubuKaret);
            String migLayoutPozicovani = vypocitejPozicovaniProMigLayout(indexKarty);
            contentPane.add(karta, migLayoutPozicovani);
            seznamKaret.add(karta);
        }

        for (JKarta karta : seznamKaret) {
            karta.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    priKliknutiNaKartu(e, karta);
                }
            });
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

    private void zamichejKarty() {
        Random generatorNahodnychCisel = new Random();
        for (int i = 0; i < 1000; i++) {
            int indexPrvniKarty = generatorNahodnychCisel.nextInt(seznamKaret.size());
            int indexDruheKarty = generatorNahodnychCisel.nextInt(seznamKaret.size());
            prohodKarty(indexPrvniKarty, indexDruheKarty);
        }

        for (int i = 0; i < seznamKaret.size(); i++) {
            JKarta karta = seznamKaret.get(i);
            migLayoutManager.setComponentConstraints(karta, vypocitejPozicovaniProMigLayout(i));
        }
    }

    private void prohodKarty(int indexPrvniKarty, int indexDruheKarty) {
        JKarta prvniKarta = seznamKaret.get(indexPrvniKarty);
        JKarta druhaKarta = seznamKaret.get(indexDruheKarty);
        seznamKaret.set(indexDruheKarty, prvniKarta);
        seznamKaret.set(indexPrvniKarty, druhaKarta);
    }

    private void priKliknutiNaKartu(MouseEvent e, JKarta karta) {
        if (zvolenaKarta1 == null) {
            if (karta.getJeVidetLic()) {
                return;
            }
            zvolenaKarta1 = karta;
            karta.otocLicemNahoru();
        } else if (zvolenaKarta2 == null) {
            if (karta.getJeVidetLic()) {
                return;
            }
            zvolenaKarta2 = karta;
            karta.otocLicemNahoru();
        } else {
            vyhodnotUhodnotiDvojice(zvolenaKarta1, zvolenaKarta2);
            otocVsechnyKartickyRubemNahoru();
        }

//        if (karta.getJeVidetLic()) {
//            karta.otocRubemNahoru();
//        } else {
//            karta.otocLicemNahoru();
//        }
    }

    public void otocVsechnyKartickyRubemNahoru() {
        for (JKarta karta : seznamKaret) {
            karta.otocRubemNahoru();
        }
        zvolenaKarta1 = null;
        zvolenaKarta2 = null;
    }

    private void vyhodnotUhodnotiDvojice(JKarta karta1, JKarta karta2) {
        if (karta1.getCisloObrazku() == karta2.getCisloObrazku()) {
            karta1.nechejZmizet();
            karta2.nechejZmizet();

            if (!zbyvajiNejakeKarticky()) {
                JOptionPane.showMessageDialog(this, "Gratulujeme! Vyhráli jste!", "Výhra", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private boolean zbyvajiNejakeKarticky() {
        for (JKarta aktualniKarta : seznamKaret) {
            if (aktualniKarta.getJeZobrazena()) {
                return true;
            }
        }
        return false;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pexeso");
        setBackground(new Color(240, 240, 240));
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
