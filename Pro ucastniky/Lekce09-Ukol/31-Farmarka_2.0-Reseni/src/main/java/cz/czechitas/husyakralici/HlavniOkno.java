package cz.czechitas.husyakralici;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labNadpis;
    JLabel labHusy;
    JTextField editHusy;
    JLabel labKralici;
    JTextField editKralici;
    JButton btnVypocitat;
    JLabel labPotrebnePotraviny;
    JLabel labHmotnostPsenice;
    JTextField editHmotnostPsenice;
    JLabel labKg1;
    JLabel labRadkyPsenice;
    JTextField editRadkyPsenice;
    JLabel labHmotnostMrkve;
    JTextField editHmotnostMrkve;
    JLabel labKg2;
    JLabel labRadkyMrkve;
    JTextField editRadkyMrkve;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnVypocitat(ActionEvent e) {
        int husy = Integer.parseInt(editHusy.getText());
        int kralici = Integer.parseInt(editKralici.getText());

        double kgPsenice = 183.0 * 0.25 * husy;
        double radkyPsenice = kgPsenice / 2.0;
        double kgMrkve = 183.0 * 0.5 * kralici;
        double radkyMrkve = kgMrkve / 5.0;

        editHmotnostPsenice.setText(Double.toString(kgPsenice));
        editRadkyPsenice.setText(Double.toString(radkyPsenice));

        editHmotnostMrkve.setText(Double.toString(kgMrkve));
        editRadkyMrkve.setText(Double.toString(radkyMrkve));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labNadpis = new JLabel();
        labHusy = new JLabel();
        editHusy = new JTextField();
        labKralici = new JLabel();
        editKralici = new JTextField();
        btnVypocitat = new JButton();
        labPotrebnePotraviny = new JLabel();
        labHmotnostPsenice = new JLabel();
        editHmotnostPsenice = new JTextField();
        labKg1 = new JLabel();
        labRadkyPsenice = new JLabel();
        editRadkyPsenice = new JTextField();
        labHmotnostMrkve = new JLabel();
        editHmotnostMrkve = new JTextField();
        labKg2 = new JLabel();
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
            "[fill]",
            // rows
            "[fill]unrel" +
            "[]" +
            "[]" +
            "[]para" +
            "[]unrel" +
            "[]" +
            "[]unrel" +
            "[]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labNadpis ----
        labNadpis.setText("Husy a kr\u00e1l\u00edci");
        labNadpis.setFont(labNadpis.getFont().deriveFont(labNadpis.getFont().getStyle() | Font.BOLD, labNadpis.getFont().getSize() + 8f));
        contentPane.add(labNadpis, "cell 0 0 3 1");

        //---- labHusy ----
        labHusy.setText("Po\u010det hus:");
        labHusy.setHorizontalAlignment(SwingConstants.TRAILING);
        labHusy.setFont(labHusy.getFont().deriveFont(labHusy.getFont().getSize() + 4f));
        contentPane.add(labHusy, "cell 0 1");

        //---- editHusy ----
        editHusy.setColumns(8);
        editHusy.setFont(editHusy.getFont().deriveFont(editHusy.getFont().getSize() + 4f));
        contentPane.add(editHusy, "cell 1 1");

        //---- labKralici ----
        labKralici.setText("po\u010det kr\u00e1l\u00edk\u016f:");
        labKralici.setHorizontalAlignment(SwingConstants.TRAILING);
        labKralici.setFont(labKralici.getFont().deriveFont(labKralici.getFont().getSize() + 4f));
        contentPane.add(labKralici, "cell 0 2");

        //---- editKralici ----
        editKralici.setColumns(8);
        editKralici.setFont(editKralici.getFont().deriveFont(editKralici.getFont().getSize() + 4f));
        contentPane.add(editKralici, "cell 1 2");

        //---- btnVypocitat ----
        btnVypocitat.setText("Vypo\u010d\u00edtat");
        btnVypocitat.setFont(btnVypocitat.getFont().deriveFont(btnVypocitat.getFont().getSize() + 4f));
        btnVypocitat.addActionListener(e -> priStiskuBtnVypocitat(e));
        getRootPane().setDefaultButton(btnVypocitat);
        contentPane.add(btnVypocitat, "cell 0 3 3 1,alignx center,growx 0");

        //---- labPotrebnePotraviny ----
        labPotrebnePotraviny.setText("Pot\u0159ebn\u00e9 potraviny");
        labPotrebnePotraviny.setFont(labPotrebnePotraviny.getFont().deriveFont(labPotrebnePotraviny.getFont().getStyle() | Font.BOLD, labPotrebnePotraviny.getFont().getSize() + 8f));
        contentPane.add(labPotrebnePotraviny, "cell 0 4 3 1");

        //---- labHmotnostPsenice ----
        labHmotnostPsenice.setText("Hmotnost p\u0161enice:");
        labHmotnostPsenice.setHorizontalAlignment(SwingConstants.TRAILING);
        labHmotnostPsenice.setFont(labHmotnostPsenice.getFont().deriveFont(labHmotnostPsenice.getFont().getSize() + 4f));
        contentPane.add(labHmotnostPsenice, "cell 0 5");

        //---- editHmotnostPsenice ----
        editHmotnostPsenice.setColumns(8);
        editHmotnostPsenice.setEditable(false);
        editHmotnostPsenice.setFont(editHmotnostPsenice.getFont().deriveFont(editHmotnostPsenice.getFont().getSize() + 4f));
        contentPane.add(editHmotnostPsenice, "cell 1 5");

        //---- labKg1 ----
        labKg1.setText("kg");
        contentPane.add(labKg1, "cell 2 5");

        //---- labRadkyPsenice ----
        labRadkyPsenice.setText("Po\u010det \u0159\u00e1dk\u016f p\u0161enice:");
        labRadkyPsenice.setHorizontalAlignment(SwingConstants.TRAILING);
        labRadkyPsenice.setFont(labRadkyPsenice.getFont().deriveFont(labRadkyPsenice.getFont().getSize() + 4f));
        contentPane.add(labRadkyPsenice, "cell 0 6");

        //---- editRadkyPsenice ----
        editRadkyPsenice.setColumns(8);
        editRadkyPsenice.setEditable(false);
        editRadkyPsenice.setFont(editRadkyPsenice.getFont().deriveFont(editRadkyPsenice.getFont().getSize() + 4f));
        contentPane.add(editRadkyPsenice, "cell 1 6");

        //---- labHmotnostMrkve ----
        labHmotnostMrkve.setText("Hmotnost mrkve:");
        labHmotnostMrkve.setHorizontalAlignment(SwingConstants.TRAILING);
        labHmotnostMrkve.setFont(labHmotnostMrkve.getFont().deriveFont(labHmotnostMrkve.getFont().getSize() + 4f));
        contentPane.add(labHmotnostMrkve, "cell 0 7");

        //---- editHmotnostMrkve ----
        editHmotnostMrkve.setColumns(8);
        editHmotnostMrkve.setEditable(false);
        editHmotnostMrkve.setFont(editHmotnostMrkve.getFont().deriveFont(editHmotnostMrkve.getFont().getSize() + 4f));
        contentPane.add(editHmotnostMrkve, "cell 1 7");

        //---- labKg2 ----
        labKg2.setText("kg");
        contentPane.add(labKg2, "cell 2 7");

        //---- labRadkyMrkve ----
        labRadkyMrkve.setText("Po\u010det \u0159\u00e1dk\u016f mrkve:");
        labRadkyMrkve.setHorizontalAlignment(SwingConstants.TRAILING);
        labRadkyMrkve.setFont(labRadkyMrkve.getFont().deriveFont(labRadkyMrkve.getFont().getSize() + 4f));
        contentPane.add(labRadkyMrkve, "cell 0 8");

        //---- editRadkyMrkve ----
        editRadkyMrkve.setColumns(8);
        editRadkyMrkve.setEditable(false);
        editRadkyMrkve.setFont(editRadkyMrkve.getFont().deriveFont(editRadkyMrkve.getFont().getSize() + 4f));
        contentPane.add(editRadkyMrkve, "cell 1 8");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
