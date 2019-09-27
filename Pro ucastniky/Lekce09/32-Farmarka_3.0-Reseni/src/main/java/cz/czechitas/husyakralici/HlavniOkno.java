package cz.czechitas.husyakralici;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labHusy;
    JLabel labKralici;
    JLabel labHusySamci;
    JTextField editHusySamci;
    JLabel labKraliciSamci;
    JTextField editKraliciSamci;
    JLabel labHusySamice;
    JTextField editHusySamice;
    JLabel labKraliciSamice;
    JTextField editKraliciSamice;
    JButton btnVypocitat;
    JLabel labCelkemZvirata;
    JLabel labHusyCelkem;
    JTextField editHusyCelkem;
    JLabel labKraliciCelkem;
    JTextField editKraliciCelkem;
    JLabel labPotrebnePotraviny;
    JLabel labHmotnostPsenice;
    JTextField editHmotnostPsenice;
    JLabel labKg1;
    JLabel labHmotnostMrkve;
    JTextField editHmotnostMrkve;
    JLabel labKg2;
    JLabel labRadkyPsenice;
    JTextField editRadkyPsenice;
    JLabel labRadkyMrkve;
    JTextField editRadkyMrkve;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnVypocitat(ActionEvent e) {
        DoubleFormatter prevodnik = new DoubleFormatter("#0.#");
        double husySamci = prevodnik.parse(editHusySamci.getText());
        double husySamice = prevodnik.parse(editHusySamice.getText());
        double kraliciSamci = prevodnik.parse(editKraliciSamci.getText());
        double kraliciSamice = prevodnik.parse(editKraliciSamice.getText());

        double husyCelkem = husySamci + husySamice;
        if (husySamci >= 1.0 && husySamice >= 1.0) {
            husyCelkem = husyCelkem + husySamice * 15.0;
        }
        double kraliciCelkem = kraliciSamci + kraliciSamice;
        if (kraliciSamci >= 1.0 && kraliciSamice >= 1.0) {
            kraliciCelkem = kraliciCelkem + kraliciSamice * 40.0;
        }

        double kgPsenice = 183 * 0.25 * husyCelkem;
        double radkyPsenice = kgPsenice / 2.0;
        double kgMrkve = 183 * 0.5 * kraliciCelkem;
        double radkyMrkve = kgMrkve / 5.0;

        editHusyCelkem.setText(prevodnik.print(husyCelkem));
        editHmotnostPsenice.setText(prevodnik.print(kgPsenice));
        editRadkyPsenice.setText(prevodnik.print(radkyPsenice));

        editKraliciCelkem.setText(prevodnik.print(kraliciCelkem));
        editHmotnostMrkve.setText(prevodnik.print(kgMrkve));
        editRadkyMrkve.setText(prevodnik.print(radkyMrkve));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labHusy = new JLabel();
        labKralici = new JLabel();
        labHusySamci = new JLabel();
        editHusySamci = new JTextField();
        labKraliciSamci = new JLabel();
        editKraliciSamci = new JTextField();
        labHusySamice = new JLabel();
        editHusySamice = new JTextField();
        labKraliciSamice = new JLabel();
        editKraliciSamice = new JTextField();
        btnVypocitat = new JButton();
        labCelkemZvirata = new JLabel();
        labHusyCelkem = new JLabel();
        editHusyCelkem = new JTextField();
        labKraliciCelkem = new JLabel();
        editKraliciCelkem = new JTextField();
        labPotrebnePotraviny = new JLabel();
        labHmotnostPsenice = new JLabel();
        editHmotnostPsenice = new JTextField();
        labKg1 = new JLabel();
        labHmotnostMrkve = new JLabel();
        editHmotnostMrkve = new JTextField();
        labKg2 = new JLabel();
        labRadkyPsenice = new JLabel();
        editRadkyPsenice = new JTextField();
        labRadkyMrkve = new JLabel();
        editRadkyMrkve = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Farm\u00e1\u0159ka");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets unrel,hidemode 3,align center center",
            // columns
            "[fill]" +
            "[grow,fill]" +
            "[fill]para" +
            "[fill]" +
            "[grow,fill]" +
            "[fill]",
            // rows
            "unrel[]unrel" +
            "[]" +
            "[]" +
            "[]para" +
            "[]" +
            "[]para" +
            "[]unrel" +
            "[]" +
            "[]unrel"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labHusy ----
        labHusy.setText("Husy");
        labHusy.setFont(labHusy.getFont().deriveFont(labHusy.getFont().getStyle() | Font.BOLD, labHusy.getFont().getSize() + 8f));
        labHusy.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labHusy, "cell 0 0 3 1");

        //---- labKralici ----
        labKralici.setText("Kr\u00e1l\u00edci");
        labKralici.setFont(labKralici.getFont().deriveFont(labKralici.getFont().getStyle() | Font.BOLD, labKralici.getFont().getSize() + 8f));
        labKralici.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labKralici, "cell 3 0 3 1");

        //---- labHusySamci ----
        labHusySamci.setText("Po\u010det samc\u016f:");
        labHusySamci.setHorizontalAlignment(SwingConstants.TRAILING);
        labHusySamci.setFont(labHusySamci.getFont().deriveFont(labHusySamci.getFont().getSize() + 4f));
        contentPane.add(labHusySamci, "cell 0 1");

        //---- editHusySamci ----
        editHusySamci.setColumns(8);
        editHusySamci.setFont(editHusySamci.getFont().deriveFont(editHusySamci.getFont().getSize() + 4f));
        contentPane.add(editHusySamci, "cell 1 1");

        //---- labKraliciSamci ----
        labKraliciSamci.setText("Po\u010det samc\u016f:");
        labKraliciSamci.setHorizontalAlignment(SwingConstants.TRAILING);
        labKraliciSamci.setFont(labKraliciSamci.getFont().deriveFont(labKraliciSamci.getFont().getSize() + 4f));
        contentPane.add(labKraliciSamci, "cell 3 1");

        //---- editKraliciSamci ----
        editKraliciSamci.setColumns(8);
        editKraliciSamci.setFont(editKraliciSamci.getFont().deriveFont(editKraliciSamci.getFont().getSize() + 4f));
        contentPane.add(editKraliciSamci, "cell 4 1");

        //---- labHusySamice ----
        labHusySamice.setText("Po\u010det samic:");
        labHusySamice.setHorizontalAlignment(SwingConstants.TRAILING);
        labHusySamice.setFont(labHusySamice.getFont().deriveFont(labHusySamice.getFont().getSize() + 4f));
        contentPane.add(labHusySamice, "cell 0 2");

        //---- editHusySamice ----
        editHusySamice.setColumns(8);
        editHusySamice.setFont(editHusySamice.getFont().deriveFont(editHusySamice.getFont().getSize() + 4f));
        contentPane.add(editHusySamice, "cell 1 2");

        //---- labKraliciSamice ----
        labKraliciSamice.setText("Po\u010det samic:");
        labKraliciSamice.setHorizontalAlignment(SwingConstants.TRAILING);
        labKraliciSamice.setFont(labKraliciSamice.getFont().deriveFont(labKraliciSamice.getFont().getSize() + 4f));
        contentPane.add(labKraliciSamice, "cell 3 2");

        //---- editKraliciSamice ----
        editKraliciSamice.setColumns(8);
        editKraliciSamice.setFont(editKraliciSamice.getFont().deriveFont(editKraliciSamice.getFont().getSize() + 4f));
        contentPane.add(editKraliciSamice, "cell 4 2");

        //---- btnVypocitat ----
        btnVypocitat.setText("Vypo\u010d\u00edtat");
        btnVypocitat.setFont(btnVypocitat.getFont().deriveFont(btnVypocitat.getFont().getSize() + 4f));
        btnVypocitat.addActionListener(e -> priStiskuBtnVypocitat(e));
        getRootPane().setDefaultButton(btnVypocitat);
        contentPane.add(btnVypocitat, "cell 0 3 6 1,alignx center,growx 0");

        //---- labCelkemZvirata ----
        labCelkemZvirata.setText("Celkov\u00fd po\u010det po sezon\u011b p\u0159ed zimou");
        labCelkemZvirata.setFont(labCelkemZvirata.getFont().deriveFont(labCelkemZvirata.getFont().getStyle() | Font.BOLD, labCelkemZvirata.getFont().getSize() + 8f));
        contentPane.add(labCelkemZvirata, "cell 0 4 6 1");

        //---- labHusyCelkem ----
        labHusyCelkem.setText("Po\u010det hus:");
        labHusyCelkem.setHorizontalAlignment(SwingConstants.TRAILING);
        labHusyCelkem.setFont(labHusyCelkem.getFont().deriveFont(labHusyCelkem.getFont().getSize() + 4f));
        contentPane.add(labHusyCelkem, "cell 0 5");

        //---- editHusyCelkem ----
        editHusyCelkem.setColumns(8);
        editHusyCelkem.setEditable(false);
        editHusyCelkem.setFont(editHusyCelkem.getFont().deriveFont(editHusyCelkem.getFont().getSize() + 4f));
        contentPane.add(editHusyCelkem, "cell 1 5");

        //---- labKraliciCelkem ----
        labKraliciCelkem.setText("Po\u010det kr\u00e1l\u00edk\u016f:");
        labKraliciCelkem.setHorizontalAlignment(SwingConstants.TRAILING);
        labKraliciCelkem.setFont(labKraliciCelkem.getFont().deriveFont(labKraliciCelkem.getFont().getSize() + 4f));
        contentPane.add(labKraliciCelkem, "cell 3 5");

        //---- editKraliciCelkem ----
        editKraliciCelkem.setColumns(8);
        editKraliciCelkem.setEditable(false);
        editKraliciCelkem.setFont(editKraliciCelkem.getFont().deriveFont(editKraliciCelkem.getFont().getSize() + 4f));
        contentPane.add(editKraliciCelkem, "cell 4 5");

        //---- labPotrebnePotraviny ----
        labPotrebnePotraviny.setText("Pot\u0159ebn\u00e9 potraviny");
        labPotrebnePotraviny.setFont(labPotrebnePotraviny.getFont().deriveFont(labPotrebnePotraviny.getFont().getStyle() | Font.BOLD, labPotrebnePotraviny.getFont().getSize() + 8f));
        contentPane.add(labPotrebnePotraviny, "cell 0 6 3 1");

        //---- labHmotnostPsenice ----
        labHmotnostPsenice.setText("Hmotnost p\u0161enice:");
        labHmotnostPsenice.setHorizontalAlignment(SwingConstants.TRAILING);
        labHmotnostPsenice.setFont(labHmotnostPsenice.getFont().deriveFont(labHmotnostPsenice.getFont().getSize() + 4f));
        contentPane.add(labHmotnostPsenice, "cell 0 7");

        //---- editHmotnostPsenice ----
        editHmotnostPsenice.setColumns(8);
        editHmotnostPsenice.setEditable(false);
        editHmotnostPsenice.setFont(editHmotnostPsenice.getFont().deriveFont(editHmotnostPsenice.getFont().getSize() + 4f));
        contentPane.add(editHmotnostPsenice, "cell 1 7");

        //---- labKg1 ----
        labKg1.setText("kg");
        contentPane.add(labKg1, "cell 2 7");

        //---- labHmotnostMrkve ----
        labHmotnostMrkve.setText("Hmotnost mrkve:");
        labHmotnostMrkve.setHorizontalAlignment(SwingConstants.TRAILING);
        labHmotnostMrkve.setFont(labHmotnostMrkve.getFont().deriveFont(labHmotnostMrkve.getFont().getSize() + 4f));
        contentPane.add(labHmotnostMrkve, "cell 3 7");

        //---- editHmotnostMrkve ----
        editHmotnostMrkve.setColumns(8);
        editHmotnostMrkve.setEditable(false);
        editHmotnostMrkve.setFont(editHmotnostMrkve.getFont().deriveFont(editHmotnostMrkve.getFont().getSize() + 4f));
        contentPane.add(editHmotnostMrkve, "cell 4 7");

        //---- labKg2 ----
        labKg2.setText("kg");
        contentPane.add(labKg2, "cell 5 7");

        //---- labRadkyPsenice ----
        labRadkyPsenice.setText("Po\u010det \u0159\u00e1dk\u016f p\u0161enice:");
        labRadkyPsenice.setHorizontalAlignment(SwingConstants.TRAILING);
        labRadkyPsenice.setFont(labRadkyPsenice.getFont().deriveFont(labRadkyPsenice.getFont().getSize() + 4f));
        contentPane.add(labRadkyPsenice, "cell 0 8");

        //---- editRadkyPsenice ----
        editRadkyPsenice.setColumns(8);
        editRadkyPsenice.setEditable(false);
        editRadkyPsenice.setFont(editRadkyPsenice.getFont().deriveFont(editRadkyPsenice.getFont().getSize() + 4f));
        contentPane.add(editRadkyPsenice, "cell 1 8");

        //---- labRadkyMrkve ----
        labRadkyMrkve.setText("Po\u010det \u0159\u00e1dk\u016f mrkve:");
        labRadkyMrkve.setHorizontalAlignment(SwingConstants.TRAILING);
        labRadkyMrkve.setFont(labRadkyMrkve.getFont().deriveFont(labRadkyMrkve.getFont().getSize() + 4f));
        contentPane.add(labRadkyMrkve, "cell 3 8");

        //---- editRadkyMrkve ----
        editRadkyMrkve.setColumns(8);
        editRadkyMrkve.setEditable(false);
        editRadkyMrkve.setFont(editRadkyMrkve.getFont().deriveFont(editRadkyMrkve.getFont().getSize() + 4f));
        contentPane.add(editRadkyMrkve, "cell 4 8");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
