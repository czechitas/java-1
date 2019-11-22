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
    MigLayout migLayoutManager;
    BufferedImage obrazek;
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
                obrazek = ImageIO.read(getClass().getResourceAsStream("/cz/czechitas/mandala/mandala.png"));
            } catch (IOException ex) {
                throw new ApplicationPublicException(ex, "Nepodařilo se nahrát zabudovaný obrázek mandaly");
            }
        } else {
            try {
                obrazek = ImageIO.read(soubor);
            } catch (IOException ex) {
                throw new ApplicationPublicException(ex, "Nepodařilo se nahrát obrázek mandaly ze souboru " + soubor.getAbsolutePath());
            }
        }
        labObrazek.setIcon(new ImageIcon(obrazek));
        labObrazek.setMinimumSize(new Dimension(obrazek.getWidth(), obrazek.getHeight()));
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
            ImageIO.write(obrazek, "png", soubor);
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
        vyplnObrazek(x, y);
        labObrazek.repaint();
    }

    public void vyplnObrazek(int x, int y) {
        if (barvaStetce == null) {
            barvaStetce = new Color(255, 255, 0);
        }

        if (x < 0 || x >= obrazek.getWidth() || y < 0 || y >= obrazek.getHeight()) {
            return;
        }

        WritableRaster pixely = obrazek.getRaster();
        int[] novyPixel = new int[] {barvaStetce.getRed(), barvaStetce.getGreen(), barvaStetce.getBlue(), barvaStetce.getAlpha()};
        int[] staryPixel = new int[] {255, 255, 255, 255};
        staryPixel = pixely.getPixel(x, y, staryPixel);

        // Pokud uz je pocatecni pixel obarven na cilovou barvu, nic nemen
        if (isEqualRgb(novyPixel, staryPixel)) {
            return;
        }

        // Zamez prebarveni cerne cary
        int[] cernyPixel = new int[] {0, 0, 0, staryPixel[3]};
        if (isEqualRgb(cernyPixel, staryPixel)) {
            return;
        }

        floodLoop(pixely, x, y, novyPixel, staryPixel);
    }

    // Recursively fills surrounding pixels of the old color
    private void floodLoop(WritableRaster raster, int x, int y, int[] newColor, int[] originalColor) {
        Rectangle bounds = raster.getBounds();
        int[] currentColor = new int[] {255, 255, 255, 255};

        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(x, y));
        while (stack.size() > 0) {
            Point point = stack.pop();
            x = point.x;
            y = point.y;

            // finds the left side, filling along the way
            int fillL = x;
            do {
                raster.setPixel(fillL, y, newColor);
                fillL--;
            } while (fillL >= 0 && isEqualRgb(raster.getPixel(fillL, y, currentColor), originalColor));
            fillL++;

            // find the right right side, filling along the way
            int fillR = x;
            do {
                raster.setPixel(fillR, y, newColor);
                fillR++;
            }
            while (fillR < bounds.width - 1 && isEqualRgb(raster.getPixel(fillR, y, currentColor), originalColor));
            fillR--;

            // checks if applicable up or down
            for (int i = fillL; i <= fillR; i++) {
                if (y > 0 && isEqualRgb(raster.getPixel(i, y - 1, currentColor), originalColor)) {
                    stack.add(new Point(i, y - 1));
                }
                if (y < bounds.height - 1 && isEqualRgb(raster.getPixel(i, y + 1, currentColor), originalColor)) {
                    stack.add(new Point(i, y + 1));
                }
            }
        }
    }

    // Returns true if RGB arrays are equivalent, false otherwise
    private boolean isEqualRgb(int[] color1, int[] color2) {
        // Could use Arrays.equals(int[], int[]), but this is probably a little faster...
        return color1[0] == color2[0] && color1[1] == color2[1] && color1[2] == color2[2] && color1[3] == color2[3];
    }

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
            "insets 0,hidemode 3",
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
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

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
            public void mouseClicked(MouseEvent e) {
                priKliknutiNaLabObrazek(e);
            }
        });
        contentPane.add(labObrazek, "cell 0 1 7 1,align center center,grow 0 0");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
