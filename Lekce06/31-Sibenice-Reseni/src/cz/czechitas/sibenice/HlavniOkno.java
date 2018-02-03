package cz.czechitas.sibenice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.org.apache.xpath.internal.axes.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labHadanePismeno;
    JTextField editHadanePismeno;
    JButton btnHadat;
    JLabel labHistorieHadaniTitulek;
    JLabel labHistorieHadani;
    JLabel labUhadnuteSlovoTitulek;
    JLabel labUhadnuteSlovo;
    JLabel labPocetZivotuTitulek;
    JLabel labPocetZivotu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    String tajenka;
    String uhadnutaPismena;
    int pocetZivotu;

    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
        tajenka = "ABRAKADABRA";
        uhadnutaPismena = tajenka.replaceAll(".", "*");
        pocetZivotu = 5;
        obnovObrazovku();
    }

    private void obnovObrazovku() {
        labUhadnuteSlovo.setText(uhadnutaPismena);
        editHadanePismeno.setText("");
        labPocetZivotu.setText(Integer.toString(pocetZivotu));
    }

    private void priStiskuBtnHadat(ActionEvent e) {
        String hadanyText = editHadanePismeno.getText();
        hadanyText = hadanyText.trim();
        hadanyText = hadanyText.toUpperCase();
        if (hadanyText.length() != 1) {
            return;
        }
        char hadanePismeno = hadanyText.charAt(0);

        boolean uhadnutoVTomtoKole = false;
        for (int i = 0; i < tajenka.length(); i++) {
            if (tajenka.charAt(i) == hadanePismeno) {
                uhadnutaPismena = uhadnutaPismena.substring(0, i)
                        + hadanePismeno + uhadnutaPismena.substring(i + 1);
                uhadnutoVTomtoKole = true;
            }
        }

        if (uhadnutoVTomtoKole) {
            if (!tajenka.equals(uhadnutaPismena)) {
                labHistorieHadani.setText("Úspěch!");
            } else {
                labHistorieHadani.setText("Vítězství!");
                editHadanePismeno.setEnabled(false);
            }
        } else {
            pocetZivotu = pocetZivotu - 1;
            if (pocetZivotu > 0) {
                labHistorieHadani.setText("Špatné písmeno!");
            } else {
                labHistorieHadani.setText("Konec hry!");
                editHadanePismeno.setEnabled(false);
            }
        }

        obnovObrazovku();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labHadanePismeno = new JLabel();
        editHadanePismeno = new JTextField();
        btnHadat = new JButton();
        labHistorieHadaniTitulek = new JLabel();
        labHistorieHadani = new JLabel();
        labUhadnuteSlovoTitulek = new JLabel();
        labUhadnuteSlovo = new JLabel();
        labPocetZivotuTitulek = new JLabel();
        labPocetZivotu = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\u0160ibenice");
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
                "[fill]" +
                        "[fill]" +
                        "[grow,fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[grow,fill]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labHadanePismeno ----
        labHadanePismeno.setText("H\u00e1dejte p\u00edsmeno:");
        labHadanePismeno.setHorizontalAlignment(SwingConstants.TRAILING);
        labHadanePismeno.setFont(labHadanePismeno.getFont().deriveFont(labHadanePismeno.getFont().getSize() + 4f));
        contentPane.add(labHadanePismeno, "cell 1 1");

        //---- editHadanePismeno ----
        editHadanePismeno.setColumns(5);
        editHadanePismeno.setFont(editHadanePismeno.getFont().deriveFont(editHadanePismeno.getFont().getSize() + 4f));
        contentPane.add(editHadanePismeno, "cell 2 1");

        //---- btnHadat ----
        btnHadat.setText("H\u00e1dat");
        btnHadat.setFont(btnHadat.getFont().deriveFont(btnHadat.getFont().getSize() + 4f));
        btnHadat.addActionListener(e -> priStiskuBtnHadat(e));
        getRootPane().setDefaultButton(btnHadat);
        contentPane.add(btnHadat, "cell 3 1");

        //---- labHistorieHadaniTitulek ----
        labHistorieHadaniTitulek.setText("Pokus:");
        labHistorieHadaniTitulek.setHorizontalAlignment(SwingConstants.TRAILING);
        labHistorieHadaniTitulek.setFont(labHistorieHadaniTitulek.getFont().deriveFont(labHistorieHadaniTitulek.getFont().getSize() + 4f));
        contentPane.add(labHistorieHadaniTitulek, "cell 1 3");

        //---- labHistorieHadani ----
        labHistorieHadani.setFont(labHistorieHadani.getFont().deriveFont(labHistorieHadani.getFont().getStyle() | Font.BOLD, labHistorieHadani.getFont().getSize() + 4f));
        contentPane.add(labHistorieHadani, "cell 2 3 2 1");

        //---- labUhadnuteSlovoTitulek ----
        labUhadnuteSlovoTitulek.setText("Uh\u00e1dnut\u00e9 slovo:");
        labUhadnuteSlovoTitulek.setHorizontalAlignment(SwingConstants.TRAILING);
        labUhadnuteSlovoTitulek.setFont(labUhadnuteSlovoTitulek.getFont().deriveFont(labUhadnuteSlovoTitulek.getFont().getSize() + 4f));
        contentPane.add(labUhadnuteSlovoTitulek, "cell 1 4");

        //---- labUhadnuteSlovo ----
        labUhadnuteSlovo.setText("TAJNESLOVO");
        labUhadnuteSlovo.setFont(labUhadnuteSlovo.getFont().deriveFont(labUhadnuteSlovo.getFont().getStyle() | Font.BOLD, labUhadnuteSlovo.getFont().getSize() + 4f));
        contentPane.add(labUhadnuteSlovo, "cell 2 4 2 1");

        //---- labPocetZivotuTitulek ----
        labPocetZivotuTitulek.setText("Po\u010det \u017eivot\u016f:");
        labPocetZivotuTitulek.setHorizontalAlignment(SwingConstants.TRAILING);
        labPocetZivotuTitulek.setFont(labPocetZivotuTitulek.getFont().deriveFont(labPocetZivotuTitulek.getFont().getSize() + 4f));
        contentPane.add(labPocetZivotuTitulek, "cell 1 5");

        //---- labPocetZivotu ----
        labPocetZivotu.setText("99");
        labPocetZivotu.setFont(labPocetZivotu.getFont().deriveFont(labPocetZivotu.getFont().getStyle() | Font.BOLD, labPocetZivotu.getFont().getSize() + 4f));
        contentPane.add(labPocetZivotu, "cell 2 5 2 1");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
