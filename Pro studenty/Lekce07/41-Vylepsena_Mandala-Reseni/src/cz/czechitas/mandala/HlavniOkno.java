package cz.czechitas.mandala;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.*;
import net.sevecek.util.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JMenuBar menuBar;
    JMenu menuSoubor;
    JMenuItem menuOtevrit;
    JMenuItem menuUlozit;
    JMenuItem menuUlozitJako;
    JMenuItem menuUkoncit;
    JLabel labAktualniBarva;
    JLabel labBarva1;
    JLabel labBarva2;
    JLabel labBarva3;
    JLabel labBarva4;
    JLabel labBarva5;
    JLabel labObrazek;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    BufferedImage obrazekMandaly;
    Color barvaStetce;
    File otevrenySoubor;

    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
        nastavAktualniBarvu(labBarva1);
        nahrajObrazek(null);
    }

    private void priStiskuMenuOtevrit(ActionEvent e) {
        JFileChooser dialog;
        if (otevrenySoubor == null) {
            dialog = new JFileChooser(".");
        } else {
            dialog = new JFileChooser(otevrenySoubor.getParentFile());
        }
        dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        dialog.setMultiSelectionEnabled(false);
        dialog.addChoosableFileFilter(new FileNameExtensionFilter("Obrázky (*.png)", "png"));
        int vysledek = dialog.showOpenDialog(this);
        if (vysledek != JFileChooser.APPROVE_OPTION) {
            return;
        }

        otevrenySoubor = dialog.getSelectedFile();
        nahrajObrazek(otevrenySoubor);
    }

    private void nahrajObrazek(File soubor) {
        if (soubor == null) {
            try {
                obrazekMandaly = ImageIO.read(getClass().getResourceAsStream("/cz/czechitas/mandala/mandala.png"));
            } catch (IOException ex) {
                throw new ApplicationPublicException(ex, "Nepodařilo se nahrát zabudovaný obrázek mandaly");
            }
        } else {
            try {
                obrazekMandaly = ImageIO.read(soubor);
            } catch (IOException ex) {
                throw new ApplicationPublicException(ex, "Nepodařilo se nahrát obrázek mandaly ze souboru " + soubor.getAbsolutePath());
            }
        }
        labObrazek.setIcon(new ImageIcon(obrazekMandaly));
        labObrazek.setPreferredSize(null);
        setMinimumSize(null);
        pack();
        setMinimumSize(getSize());
    }

    private void priStiskuMenuUlozitJako(ActionEvent e) {
        JFileChooser dialog;
        if (otevrenySoubor == null) {
            dialog = new JFileChooser(".");
        } else {
            dialog = new JFileChooser(otevrenySoubor.getParentFile());
        }
        dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        dialog.setMultiSelectionEnabled(false);
        FileFilter pngFilter = new FileNameExtensionFilter("Obrázky (*.png)", "png");
        dialog.addChoosableFileFilter(pngFilter);
        int vysledek = dialog.showSaveDialog(this);
        if (vysledek != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File soubor = dialog.getSelectedFile();
        if (!soubor.getName().contains(".") && !soubor.exists()) {
            soubor = new File(soubor.getParentFile(), soubor.getName() + ".png");
        }
        if (soubor.exists()) {
            int potvrzeni = JOptionPane.showConfirmDialog(this, "Soubor " + soubor.getName() + " už existuje.\nChcete jej přepsat?", "Přepsat soubor?", JOptionPane.YES_NO_OPTION);
            if (potvrzeni == JOptionPane.NO_OPTION) {
                return;
            }
        }
        ulozObrazek(soubor);
        otevrenySoubor = soubor;
    }

    private void ulozObrazek(File soubor) {
        try {
            ImageIO.write(obrazekMandaly, "png", soubor);
        } catch (IOException ex) {
            throw new ApplicationPublicException(ex, "Nepodařilo se uložit obrázek mandaly do souboru " + soubor.getAbsolutePath());
        }
    }

    private void priStiskuMenuUlozit(ActionEvent e) {
        if (otevrenySoubor == null) {
            priStiskuMenuUlozitJako(e);
            return;
        }
        ulozObrazek(otevrenySoubor);
    }

    private void priStiskuMenuUkoncit(ActionEvent e) {
        dispose();
    }

    private void priKliknutiNaBarvy(MouseEvent e) {
        JLabel tlacitkoSBarvou = (JLabel) e.getSource();
        nastavAktualniBarvu(tlacitkoSBarvou);
    }

    private void nastavAktualniBarvu(JLabel tlacitkoSBarvou) {
        barvaStetce = tlacitkoSBarvou.getBackground();
        labBarva1.setText("");
        labBarva2.setText("");
        labBarva3.setText("");
        labBarva4.setText("");
        labBarva5.setText("");
        tlacitkoSBarvou.setText("X");
    }

    private void priKliknutiNaLabObrazek(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        vyplnObrazek(obrazekMandaly, x, y, barvaStetce);
        labObrazek.repaint();
    }

    //-------------------------------------------------------------------------

    /**
     * Vyplni <code>BufferedImage obrazek</code>
     * na pozicich <code>int x</code>, <code>int y</code>
     * barvou <code>Color barva</code>
     */
    public void vyplnObrazek(BufferedImage obrazek, int x, int y, Color barva) {
        if (barva == null) {
            barva = new Color(255, 255, 0);
        }

        if (x < 0 || x >= obrazek.getWidth() || y < 0 || y >= obrazek.getHeight()) {
            return;
        }

        WritableRaster pixely = obrazek.getRaster();
        int[] novyPixel = new int[] {barva.getRed(), barva.getGreen(), barva.getBlue(), barva.getAlpha()};
        int[] staryPixel = new int[] {255, 255, 255, 255};
        staryPixel = pixely.getPixel(x, y, staryPixel);

        // Pokud uz je pocatecni pixel obarven na cilovou barvu, nic nemen
        if (pixelyMajiStejnouBarvu(novyPixel, staryPixel)) {
            return;
        }

        // Zamez prebarveni cerne cary
        int[] cernyPixel = new int[] {0, 0, 0, staryPixel[3]};
        if (pixelyMajiStejnouBarvu(cernyPixel, staryPixel)) {
            return;
        }

        vyplnovaciSmycka(pixely, x, y, novyPixel, staryPixel);
    }

    /**
     * Provede skutecne vyplneni pomoci zasobniku
     */
    private void vyplnovaciSmycka(WritableRaster raster, int x, int y, int[] novaBarva, int[] nahrazovanaBarva) {
        Rectangle rozmery = raster.getBounds();
        int[] aktualniBarva = new int[] {255, 255, 255, 255};

        Deque<Point> zasobnik = new ArrayDeque<>(rozmery.width * rozmery.height);
        zasobnik.push(new Point(x, y));
        while (zasobnik.size() > 0) {
            Point point = zasobnik.pop();
            x = point.x;
            y = point.y;
            if (!pixelyMajiStejnouBarvu(raster.getPixel(x, y, aktualniBarva), nahrazovanaBarva)) {
                continue;
            }

            // Najdi levou zed, po ceste vyplnuj
            int levaZed = x;
            do {
                raster.setPixel(levaZed, y, novaBarva);
                levaZed--;
            }
            while (levaZed >= 0 && pixelyMajiStejnouBarvu(raster.getPixel(levaZed, y, aktualniBarva), nahrazovanaBarva));
            levaZed++;

            // Najdi pravou zed, po ceste vyplnuj
            int pravaZed = x;
            do {
                raster.setPixel(pravaZed, y, novaBarva);
                pravaZed++;
            }
            while (pravaZed < rozmery.width && pixelyMajiStejnouBarvu(raster.getPixel(pravaZed, y, aktualniBarva), nahrazovanaBarva));
            pravaZed--;

            // Pridej na zasobnik body nahore a dole
            for (int i = levaZed; i <= pravaZed; i++) {
                if (y > 0 && pixelyMajiStejnouBarvu(raster.getPixel(i, y - 1, aktualniBarva), nahrazovanaBarva)) {
                    if (!(i > levaZed && i < pravaZed
                            && pixelyMajiStejnouBarvu(raster.getPixel(i - 1, y - 1, aktualniBarva), nahrazovanaBarva)
                            && pixelyMajiStejnouBarvu(raster.getPixel(i + 1, y - 1, aktualniBarva), nahrazovanaBarva))) {
                        zasobnik.add(new Point(i, y - 1));
                    }
                }
                if (y < rozmery.height - 1 && pixelyMajiStejnouBarvu(raster.getPixel(i, y + 1, aktualniBarva), nahrazovanaBarva)) {
                    if (!(i > levaZed && i < pravaZed
                            && pixelyMajiStejnouBarvu(raster.getPixel(i - 1, y + 1, aktualniBarva), nahrazovanaBarva)
                            && pixelyMajiStejnouBarvu(raster.getPixel(i + 1, y + 1, aktualniBarva), nahrazovanaBarva))) {
                        zasobnik.add(new Point(i, y + 1));
                    }
                }
            }
        }
    }

    /**
     * Vrati true pokud RGB hodnoty v polich jsou stejne. Pokud jsou ruzne, vraci false
     */
    private boolean pixelyMajiStejnouBarvu(int[] barva1, int[] barva2) {
        return barva1[0] == barva2[0] && barva1[1] == barva2[1] && barva1[2] == barva2[2];
    }

    //-------------------------------------------------------------------------

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        menuBar = new JMenuBar();
        menuSoubor = new JMenu();
        menuOtevrit = new JMenuItem();
        menuUlozit = new JMenuItem();
        menuUlozitJako = new JMenuItem();
        menuUkoncit = new JMenuItem();
        labAktualniBarva = new JLabel();
        labBarva1 = new JLabel();
        labBarva2 = new JLabel();
        labBarva3 = new JLabel();
        labBarva4 = new JLabel();
        labBarva5 = new JLabel();
        labObrazek = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mandala");
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
                "unrel[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[grow,fill]unrel",
                // rows
                "unrel[]unrel" +
                        "[grow]unrel"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //======== menuBar ========
        {

            //======== menuSoubor ========
            {
                menuSoubor.setText("Soubor");

                //---- menuOtevrit ----
                menuOtevrit.setText("Otev\u0159\u00edt...");
                menuOtevrit.addActionListener(e -> priStiskuMenuOtevrit(e));
                menuSoubor.add(menuOtevrit);
                menuSoubor.addSeparator();

                //---- menuUlozit ----
                menuUlozit.setText("Ulo\u017eit");
                menuUlozit.addActionListener(e -> priStiskuMenuUlozit(e));
                menuSoubor.add(menuUlozit);

                //---- menuUlozitJako ----
                menuUlozitJako.setText("Ulo\u017eit jako...");
                menuUlozitJako.addActionListener(e -> priStiskuMenuUlozitJako(e));
                menuSoubor.add(menuUlozitJako);
                menuSoubor.addSeparator();

                //---- menuUkoncit ----
                menuUkoncit.setText("Ukon\u010dit");
                menuUkoncit.addActionListener(e -> priStiskuMenuUkoncit(e));
                menuSoubor.add(menuUkoncit);
            }
            menuBar.add(menuSoubor);
        }
        setJMenuBar(menuBar);

        //---- labAktualniBarva ----
        labAktualniBarva.setText("Aktu\u00e1ln\u00ed barva:");
        labAktualniBarva.setFont(UIManager.getFont("Menu.font"));
        contentPane.add(labAktualniBarva, "cell 0 0");

        //---- labBarva1 ----
        labBarva1.setBackground(new Color(189, 152, 255));
        labBarva1.setMinimumSize(new Dimension(32, 32));
        labBarva1.setPreferredSize(new Dimension(32, 32));
        labBarva1.setOpaque(true);
        labBarva1.setBorder(new BevelBorder(BevelBorder.RAISED));
        labBarva1.setFont(labBarva1.getFont().deriveFont(20f));
        labBarva1.setHorizontalAlignment(SwingConstants.CENTER);
        labBarva1.setForeground(Color.white);
        labBarva1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiNaBarvy(e);
            }
        });
        contentPane.add(labBarva1, "cell 1 0");

        //---- labBarva2 ----
        labBarva2.setBorder(new BevelBorder(BevelBorder.RAISED));
        labBarva2.setMinimumSize(new Dimension(32, 32));
        labBarva2.setOpaque(true);
        labBarva2.setPreferredSize(new Dimension(32, 32));
        labBarva2.setBackground(new Color(101, 121, 232));
        labBarva2.setHorizontalAlignment(SwingConstants.CENTER);
        labBarva2.setFont(labBarva2.getFont().deriveFont(20f));
        labBarva2.setForeground(Color.white);
        labBarva2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiNaBarvy(e);
            }
        });
        contentPane.add(labBarva2, "cell 2 0");

        //---- labBarva3 ----
        labBarva3.setBackground(new Color(124, 209, 255));
        labBarva3.setOpaque(true);
        labBarva3.setMinimumSize(new Dimension(32, 32));
        labBarva3.setPreferredSize(new Dimension(32, 32));
        labBarva3.setBorder(new BevelBorder(BevelBorder.RAISED));
        labBarva3.setHorizontalAlignment(SwingConstants.CENTER);
        labBarva3.setFont(labBarva3.getFont().deriveFont(20f));
        labBarva3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiNaBarvy(e);
            }
        });
        contentPane.add(labBarva3, "cell 3 0");

        //---- labBarva4 ----
        labBarva4.setPreferredSize(new Dimension(32, 32));
        labBarva4.setBorder(new BevelBorder(BevelBorder.RAISED));
        labBarva4.setOpaque(true);
        labBarva4.setBackground(new Color(176, 232, 223));
        labBarva4.setMinimumSize(new Dimension(32, 32));
        labBarva4.setHorizontalAlignment(SwingConstants.CENTER);
        labBarva4.setFont(labBarva4.getFont().deriveFont(20f));
        labBarva4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiNaBarvy(e);
            }
        });
        contentPane.add(labBarva4, "cell 4 0");

        //---- labBarva5 ----
        labBarva5.setPreferredSize(new Dimension(32, 32));
        labBarva5.setBorder(new BevelBorder(BevelBorder.RAISED));
        labBarva5.setOpaque(true);
        labBarva5.setBackground(new Color(228, 255, 236));
        labBarva5.setMinimumSize(new Dimension(32, 32));
        labBarva5.setHorizontalAlignment(SwingConstants.CENTER);
        labBarva5.setFont(labBarva5.getFont().deriveFont(20f));
        labBarva5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiNaBarvy(e);
            }
        });
        contentPane.add(labBarva5, "cell 5 0");

        //---- labObrazek ----
        labObrazek.setHorizontalAlignment(SwingConstants.CENTER);
        labObrazek.setOpaque(true);
        labObrazek.setBorder(new BevelBorder(BevelBorder.LOWERED));
        labObrazek.setPreferredSize(new Dimension(640, 640));
        labObrazek.setBackground(Color.white);
        labObrazek.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                priKliknutiNaLabObrazek(e);
            }
        });
        contentPane.add(labObrazek, "cell 0 1 7 1,align center center,grow 0 0");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
