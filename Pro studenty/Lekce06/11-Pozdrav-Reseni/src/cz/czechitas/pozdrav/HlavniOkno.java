package cz.czechitas.pozdrav;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labJmeno;
    JTextField editJmeno;
    JButton btnPozdravit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnPozdravit(ActionEvent e) {
        String zprava = "Ahoj, zdraví ";

        String jmeno = editJmeno.getText();
        zprava = zprava + jmeno;

        JOptionPane.showMessageDialog(this, zprava);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labJmeno = new JLabel();
        editJmeno = new JTextField();
        btnPozdravit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pozdrav");
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
            "[grow]" +
            "[fill]" +
            "[grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labJmeno ----
        labJmeno.setText("Jm\u00e9no:");
        labJmeno.setFont(labJmeno.getFont().deriveFont(labJmeno.getFont().getSize() + 4f));
        contentPane.add(labJmeno, "cell 1 1");

        //---- editJmeno ----
        editJmeno.setColumns(20);
        editJmeno.setFont(editJmeno.getFont().deriveFont(editJmeno.getFont().getSize() + 4f));
        contentPane.add(editJmeno, "cell 2 1");

        //---- btnPozdravit ----
        btnPozdravit.setText("Pozdravit");
        btnPozdravit.setFont(btnPozdravit.getFont().deriveFont(btnPozdravit.getFont().getSize() + 4f));
        btnPozdravit.addActionListener(e -> priStiskuBtnPozdravit(e));
        contentPane.add(btnPozdravit, "cell 3 1");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
