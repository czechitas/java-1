package cz.czechitas.piskvorky;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class HlavniOkno extends JFrame {

    JTable tabDeska;
    JLabel labTitulek;
    JPanel contentPane;
    DefaultTableModel bunky;

    String aktualniHrac;

    private void priKliknutiNaBunku() {
        int radek = getSelectedRow();
        int sloupec = getSelectedColumn();
        if (getCellText(radek, sloupec) == null) {
            // Vymen hodnotu v aktualniHrac
            if (aktualniHrac == "X") {
                aktualniHrac = "O";
            } else {
                aktualniHrac = "X";
            }

            // Vloz dovnitr bunky text z promenne aktualniHrac
            setCellText(aktualniHrac, radek, sloupec);
        }
    }

    //-------------------------------------------------------------------------

    private int getSelectedColumn() {
        return tabDeska.getSelectedColumn();
    }

    private int getSelectedRow() {
        return tabDeska.getSelectedRow();
    }

    private String getCellText(int radek, int sloupec) {
        Object value = bunky.getValueAt(radek, sloupec);
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    private void setCellText(String text, int radek, int sloupec) {
        bunky.setValueAt(text, radek, sloupec);
    }

    //-------------------------------------------------------------------------

    public HlavniOkno() {
        initComponents();
    }

    private void priZmeneVelikosti() {
        int height = tabDeska.getSize().height;
        int rowCount = tabDeska.getRowCount();
        tabDeska.setRowHeight((int) Math.ceil(1.0 * height / rowCount));
    }

    private void priStiskuTlacitkaNaBunce(KeyEvent e) {
        if (e.getKeyChar() == 10) {
            e.consume();
            priKliknutiNaBunku();
            zkontrolujVyhru();
        }
    }

    private void zkontrolujVyhru() {
        String vyherce = null;
        String kamen1;
        String kamen2;
        String kamen3;
        String kamen4;
        String kamen5;

        for (int y = 0; y < tabDeska.getRowCount(); y = y + 1) {
            for (int x = 0; x < tabDeska.getColumnCount() - 4; x = x + 1) {
                kamen1 = (String) bunky.getValueAt(y, x);
                kamen2 = (String) bunky.getValueAt(y, x+1);
                kamen3 = (String) bunky.getValueAt(y, x+2);
                kamen4 = (String) bunky.getValueAt(y, x+3);
                kamen5 = (String) bunky.getValueAt(y, x+4);
                if (kamen1 != null && kamen1.equals(kamen2) && kamen1.equals(kamen3) && kamen1.equals(kamen4) && kamen1.equals(kamen5)) {
                    vyherce = kamen1;
                }
            }
        }
        for (int y = 0; y < tabDeska.getRowCount() - 4; y = y + 1) {
            for (int x = 0; x < tabDeska.getColumnCount(); x = x + 1) {
                kamen1 = (String) bunky.getValueAt(y, x);
                kamen2 = (String) bunky.getValueAt(y+1, x);
                kamen3 = (String) bunky.getValueAt(y+2, x);
                kamen4 = (String) bunky.getValueAt(y+3, x);
                kamen5 = (String) bunky.getValueAt(y+4, x);
                if (kamen1 != null && kamen1.equals(kamen2) && kamen1.equals(kamen3) && kamen1.equals(kamen4) && kamen1.equals(kamen5)) {
                    vyherce = kamen1;
                }
            }
        }
        for (int y = 0; y < tabDeska.getRowCount() - 4; y = y + 1) {
            for (int x = 0; x < tabDeska.getColumnCount() - 4; x = x + 1) {
                kamen1 = (String) bunky.getValueAt(y, x);
                kamen2 = (String) bunky.getValueAt(y+1, x+1);
                kamen3 = (String) bunky.getValueAt(y+2, x+2);
                kamen4 = (String) bunky.getValueAt(y+3, x+3);
                kamen5 = (String) bunky.getValueAt(y+4, x+4);
                if (kamen1 != null && kamen1.equals(kamen2) && kamen1.equals(kamen3) && kamen1.equals(kamen4) && kamen1.equals(kamen5)) {
                    vyherce = kamen1;
                }
            }
        }
        for (int y = 0; y < tabDeska.getRowCount() - 4; y = y + 1) {
            for (int x = 4; x < tabDeska.getColumnCount(); x = x + 1) {
                kamen1 = (String) bunky.getValueAt(y, x);
                kamen2 = (String) bunky.getValueAt(y+1, x-1);
                kamen3 = (String) bunky.getValueAt(y+2, x-2);
                kamen4 = (String) bunky.getValueAt(y+3, x-3);
                kamen5 = (String) bunky.getValueAt(y+4, x-4);
                if (kamen1 != null && kamen1.equals(kamen2) && kamen1.equals(kamen3) && kamen1.equals(kamen4) && kamen1.equals(kamen5)) {
                    vyherce = kamen1;
                }
            }
        }

        if (vyherce != null) {
            JOptionPane.showMessageDialog(this, "Vyhrál hráč " + vyherce, "Konec hry", JOptionPane.INFORMATION_MESSAGE);
            for (int y = 0; y < tabDeska.getRowCount(); y = y + 1) {
                for (int x = 0; x < tabDeska.getColumnCount(); x = x + 1) {
                    tabDeska.setValueAt(null, y, x);
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        tabDeska = new JTable();
        labTitulek = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Piskvorky");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- tabDeska ----
        bunky = new DefaultTableModel(7, 10) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabDeska.setModel(bunky);
        tabDeska.setRowSelectionInterval(0, 0);
        tabDeska.setColumnSelectionInterval(0, 0);

        DefaultTableCellRenderer cellRenderer = (DefaultTableCellRenderer) tabDeska.getCellRenderer(0, 0);
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tabDeska.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabDeska.setRowSelectionAllowed(false);
        tabDeska.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabDeska.setBackground(UIManager.getColor("Label.background"));
        tabDeska.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tabDeska.setFont(tabDeska.getFont().deriveFont(tabDeska.getFont().getStyle() | Font.BOLD, tabDeska.getFont().getSize() + 9f));
        tabDeska.setRowHeight(70);
        tabDeska.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                priKliknutiNaBunku();
                zkontrolujVyhru();
            }
        });
        tabDeska.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                priZmeneVelikosti();
            }
        });
        tabDeska.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                priStiskuTlacitkaNaBunce(e);
            }
        });
        contentPane.add(tabDeska, BorderLayout.CENTER);

        //---- labTitulek ----
        labTitulek.setText("Pi\u0161kvorky");
        labTitulek.setFont(labTitulek.getFont().deriveFont(labTitulek.getFont().getSize() + 10f));
        labTitulek.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labTitulek, BorderLayout.PAGE_START);
//        setSize(400, 300);
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
