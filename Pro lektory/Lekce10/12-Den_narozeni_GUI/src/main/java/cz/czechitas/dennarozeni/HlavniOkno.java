package cz.czechitas.dennarozeni;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labNadpis;
    JLabel labDen;
    JTextField editDen;
    JLabel labMesic;
    JTextField editMesic;
    JLabel labRok;
    JTextField editRok;
    JButton btnVypocitat;
    JLabel labVysledek;
    JTextField editVysledek;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnVypocitat(ActionEvent e) {
        int den = Integer.parseInt(editDen.getText());
        int mesic = Integer.parseInt(editMesic.getText());
        int rok = Integer.parseInt(editRok.getText());

        LocalDate datumNarozeni = LocalDate.of(rok, mesic, den);
        DayOfWeek denNarozeni = datumNarozeni.getDayOfWeek();

        DateTimeFormatter prevodnik = DateTimeFormatter.ofPattern("EEEE");
        String denNarozeniText = prevodnik.format(datumNarozeni);
        editVysledek.setText( denNarozeniText );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labNadpis = new JLabel();
        labDen = new JLabel();
        editDen = new JTextField();
        labMesic = new JLabel();
        editMesic = new JTextField();
        labRok = new JLabel();
        editRok = new JTextField();
        btnVypocitat = new JButton();
        labVysledek = new JLabel();
        editVysledek = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Den narozen\u00ed");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
            // columns
            "[fill]" +
            "[grow,fill]" +
            "[fill]",
            // rows
            "[fill]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labNadpis ----
        labNadpis.setText("V\u00fdpo\u010det dne va\u0161eho narozen\u00ed");
        labNadpis.setFont(labNadpis.getFont().deriveFont(labNadpis.getFont().getStyle() | Font.BOLD, labNadpis.getFont().getSize() + 7f));
        contentPane.add(labNadpis, "cell 0 0 3 1");

        //---- labDen ----
        labDen.setText("Den narozen\u00ed:");
        labDen.setHorizontalAlignment(SwingConstants.TRAILING);
        contentPane.add(labDen, "cell 0 1");

        //---- editDen ----
        editDen.setColumns(10);
        contentPane.add(editDen, "cell 1 1");

        //---- labMesic ----
        labMesic.setText("M\u011bs\u00edc narozen\u00ed:");
        labMesic.setHorizontalAlignment(SwingConstants.TRAILING);
        contentPane.add(labMesic, "cell 0 2");

        //---- editMesic ----
        editMesic.setColumns(10);
        contentPane.add(editMesic, "cell 1 2");

        //---- labRok ----
        labRok.setText("Rok narozen\u00ed:");
        labRok.setHorizontalAlignment(SwingConstants.TRAILING);
        contentPane.add(labRok, "cell 0 3");

        //---- editRok ----
        editRok.setColumns(10);
        contentPane.add(editRok, "cell 1 3");

        //---- btnVypocitat ----
        btnVypocitat.setText("Zjistit den narozen\u00ed");
        btnVypocitat.addActionListener(e -> priStiskuBtnVypocitat(e));
        contentPane.add(btnVypocitat, "cell 0 4 3 1,alignx center,growx 0");

        //---- labVysledek ----
        labVysledek.setText("Narodili jste se v den:");
        labVysledek.setHorizontalAlignment(SwingConstants.TRAILING);
        contentPane.add(labVysledek, "cell 0 5");

        //---- editVysledek ----
        editVysledek.setColumns(15);
        editVysledek.setEditable(false);
        editVysledek.setText("----");
        contentPane.add(editVysledek, "cell 1 5");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
