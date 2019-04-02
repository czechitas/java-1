package cz.czechitas.husyakralici;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labHusy;
    JTextField editHusy;
    JLabel labKralici;
    JTextField editKralici;
    JButton btnVypocitat;
    JLabel labHlavy;
    JTextField editHlavy;
    JLabel labNohy;
    JTextField editNohy;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnVypocitat(ActionEvent e) {
        String husyText = editHusy.getText();
        int pocetHus = Integer.parseInt(husyText);
        String kraliciText = editKralici.getText();
        int pocetKraliku = Integer.parseInt(kraliciText);

        int pocetHlav = pocetHus + pocetKraliku;
        int pocetNohou = pocetHus * 2 + pocetKraliku * 4;

        String hlavyText = Integer.toString(pocetHlav);
        editHlavy.setText(hlavyText);
        String nohyText = Integer.toString(pocetNohou);
        editNohy.setText(nohyText);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labHusy = new JLabel();
        editHusy = new JTextField();
        labKralici = new JLabel();
        editKralici = new JTextField();
        btnVypocitat = new JButton();
        labHlavy = new JLabel();
        editHlavy = new JTextField();
        labNohy = new JLabel();
        editNohy = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Husy a kr\u00e1l\u00edci");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "para[fill]" +
            "[grow,fill]para",
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

        //---- labHusy ----
        labHusy.setText("Po\u010det hus:");
        labHusy.setHorizontalAlignment(SwingConstants.TRAILING);
        labHusy.setFont(labHusy.getFont().deriveFont(labHusy.getFont().getSize() + 4f));
        contentPane.add(labHusy, "cell 0 1");

        //---- editHusy ----
        editHusy.setColumns(10);
        editHusy.setFont(editHusy.getFont().deriveFont(editHusy.getFont().getSize() + 4f));
        contentPane.add(editHusy, "cell 1 1");

        //---- labKralici ----
        labKralici.setText("Po\u010det kr\u00e1l\u00edk\u016f:");
        labKralici.setHorizontalAlignment(SwingConstants.TRAILING);
        labKralici.setFont(labKralici.getFont().deriveFont(labKralici.getFont().getSize() + 4f));
        contentPane.add(labKralici, "cell 0 2");

        //---- editKralici ----
        editKralici.setColumns(10);
        editKralici.setFont(editKralici.getFont().deriveFont(editKralici.getFont().getSize() + 4f));
        contentPane.add(editKralici, "cell 1 2");

        //---- btnVypocitat ----
        btnVypocitat.setText("Vypo\u010d\u00edtat");
        btnVypocitat.setFont(btnVypocitat.getFont().deriveFont(btnVypocitat.getFont().getSize() + 4f));
        btnVypocitat.addActionListener(e -> priStiskuBtnVypocitat(e));
        getRootPane().setDefaultButton(btnVypocitat);
        contentPane.add(btnVypocitat, "cell 0 3 2 1,alignx center,growx 0");

        //---- labHlavy ----
        labHlavy.setText("Po\u010det hlav:");
        labHlavy.setHorizontalAlignment(SwingConstants.TRAILING);
        labHlavy.setFont(labHlavy.getFont().deriveFont(labHlavy.getFont().getSize() + 4f));
        contentPane.add(labHlavy, "cell 0 4");

        //---- editHlavy ----
        editHlavy.setEditable(false);
        editHlavy.setColumns(10);
        editHlavy.setFont(editHlavy.getFont().deriveFont(editHlavy.getFont().getSize() + 4f));
        contentPane.add(editHlavy, "cell 1 4");

        //---- labNohy ----
        labNohy.setText("Po\u010det nohou:");
        labNohy.setHorizontalAlignment(SwingConstants.TRAILING);
        labNohy.setFont(labNohy.getFont().deriveFont(labNohy.getFont().getSize() + 4f));
        contentPane.add(labNohy, "cell 0 5");

        //---- editNohy ----
        editNohy.setEditable(false);
        editNohy.setColumns(10);
        editNohy.setFont(editNohy.getFont().deriveFont(editNohy.getFont().getSize() + 4f));
        contentPane.add(editNohy, "cell 1 5");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
