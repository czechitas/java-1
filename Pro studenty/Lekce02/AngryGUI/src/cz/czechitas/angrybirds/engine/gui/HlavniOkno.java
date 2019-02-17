package cz.czechitas.angrybirds.engine.gui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JPanel pnlLevels;
    JToggleButton toggleButton1;
    JToggleButton toggleButton2;
    JToggleButton toggleButton3;
    JToggleButton toggleButton4;
    JToggleButton toggleButton5;
    JToggleButton toggleButton6;
    JToggleButton toggleButton7;
    JToggleButton toggleButton8;
    JToggleButton toggleButton9;
    JToggleButton toggleButton10;
    JToggleButton toggleButton11;
    JToggleButton toggleButton12;
    JToggleButton toggleButton13;
    JToggleButton toggleButton14;
    JToggleButton toggleButton15;
    JToggleButton toggleButton16;
    JToggleButton toggleButton17;
    JToggleButton toggleButton18;
    JToggleButton toggleButton19;
    JToggleButton toggleButton20;
    JLabel labChallengeText;
    JLayeredPane pnlGameBoard;
    JPanel pnlStartStop;
    JButton btnStart;
    JButton btnPause;
    JButton btnReset;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
        remove(pnlGameBoard);
        pnlGameBoard = new JGameBoard();
//        add(pnlGameBoard, "cell 2 1,width 400:400:400,height 400:400:400");
        add(pnlGameBoard, "cell 2 1");
        pack();
        revalidate();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        pnlLevels = new JPanel();
        toggleButton1 = new JToggleButton();
        toggleButton2 = new JToggleButton();
        toggleButton3 = new JToggleButton();
        toggleButton4 = new JToggleButton();
        toggleButton5 = new JToggleButton();
        toggleButton6 = new JToggleButton();
        toggleButton7 = new JToggleButton();
        toggleButton8 = new JToggleButton();
        toggleButton9 = new JToggleButton();
        toggleButton10 = new JToggleButton();
        toggleButton11 = new JToggleButton();
        toggleButton12 = new JToggleButton();
        toggleButton13 = new JToggleButton();
        toggleButton14 = new JToggleButton();
        toggleButton15 = new JToggleButton();
        toggleButton16 = new JToggleButton();
        toggleButton17 = new JToggleButton();
        toggleButton18 = new JToggleButton();
        toggleButton19 = new JToggleButton();
        toggleButton20 = new JToggleButton();
        labChallengeText = new JLabel();
        pnlGameBoard = new JLayeredPane();
        pnlStartStop = new JPanel();
        btnStart = new JButton();
        btnPause = new JButton();
        btnReset = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Code.org - Angry Birds");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3,align center center",
            // columns
            "[grow,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[grow,fill]",
            // rows
            "[]" +
            "[]para" +
            "[]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //======== pnlLevels ========
        {
            pnlLevels.setBackground(new Color(255, 51, 153));
            pnlLevels.setLayout(new MigLayout(
                "hidemode 3,align center top",
                // columns
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]",
                // rows
                "[sizegroup 1]" +
                "[sizegroup 1]" +
                "[sizegroup 1]" +
                "[sizegroup 1]"));

            //---- toggleButton1 ----
            toggleButton1.setText("Level01");
            toggleButton1.setFocusable(false);
            pnlLevels.add(toggleButton1, "cell 0 0");

            //---- toggleButton2 ----
            toggleButton2.setText("Level02");
            toggleButton2.setFocusable(false);
            pnlLevels.add(toggleButton2, "cell 1 0");

            //---- toggleButton3 ----
            toggleButton3.setText("Level03");
            toggleButton3.setFocusable(false);
            pnlLevels.add(toggleButton3, "cell 2 0");

            //---- toggleButton4 ----
            toggleButton4.setText("Level04");
            toggleButton4.setFocusable(false);
            pnlLevels.add(toggleButton4, "cell 3 0");

            //---- toggleButton5 ----
            toggleButton5.setText("Level05");
            toggleButton5.setFocusable(false);
            pnlLevels.add(toggleButton5, "cell 4 0");

            //---- toggleButton6 ----
            toggleButton6.setText("Level04");
            toggleButton6.setFocusable(false);
            pnlLevels.add(toggleButton6, "cell 0 1");

            //---- toggleButton7 ----
            toggleButton7.setText("Level04");
            toggleButton7.setFocusable(false);
            pnlLevels.add(toggleButton7, "cell 1 1");

            //---- toggleButton8 ----
            toggleButton8.setText("Level04");
            toggleButton8.setFocusable(false);
            pnlLevels.add(toggleButton8, "cell 2 1");

            //---- toggleButton9 ----
            toggleButton9.setText("Level04");
            toggleButton9.setFocusable(false);
            pnlLevels.add(toggleButton9, "cell 3 1");

            //---- toggleButton10 ----
            toggleButton10.setText("Level10");
            toggleButton10.setFocusable(false);
            pnlLevels.add(toggleButton10, "cell 4 1");

            //---- toggleButton11 ----
            toggleButton11.setText("Level04");
            toggleButton11.setFocusable(false);
            pnlLevels.add(toggleButton11, "cell 0 2");

            //---- toggleButton12 ----
            toggleButton12.setText("Level04");
            toggleButton12.setFocusable(false);
            pnlLevels.add(toggleButton12, "cell 1 2");

            //---- toggleButton13 ----
            toggleButton13.setText("Level04");
            toggleButton13.setFocusable(false);
            pnlLevels.add(toggleButton13, "cell 2 2");

            //---- toggleButton14 ----
            toggleButton14.setText("Level04");
            toggleButton14.setFocusable(false);
            pnlLevels.add(toggleButton14, "cell 3 2");

            //---- toggleButton15 ----
            toggleButton15.setText("Level15");
            toggleButton15.setFocusable(false);
            pnlLevels.add(toggleButton15, "cell 4 2");

            //---- toggleButton16 ----
            toggleButton16.setText("Level04");
            toggleButton16.setFocusable(false);
            pnlLevels.add(toggleButton16, "cell 0 3");

            //---- toggleButton17 ----
            toggleButton17.setText("Level04");
            toggleButton17.setFocusable(false);
            pnlLevels.add(toggleButton17, "cell 1 3");

            //---- toggleButton18 ----
            toggleButton18.setText("Level04");
            toggleButton18.setFocusable(false);
            pnlLevels.add(toggleButton18, "cell 2 3");

            //---- toggleButton19 ----
            toggleButton19.setText("Level04");
            toggleButton19.setFocusable(false);
            pnlLevels.add(toggleButton19, "cell 3 3");

            //---- toggleButton20 ----
            toggleButton20.setText("Level20");
            toggleButton20.setFocusable(false);
            pnlLevels.add(toggleButton20, "cell 4 3");
        }
        contentPane.add(pnlLevels, "cell 1 0 3 1");

        //---- labChallengeText ----
        labChallengeText.setText("text");
        contentPane.add(labChallengeText, "pad 0,cell 2 1");

        //======== pnlGameBoard ========
        {
            pnlGameBoard.setBackground(new Color(51, 255, 102));
            pnlGameBoard.setOpaque(true);
        }
        contentPane.add(pnlGameBoard, "cell 2 2,width 400:400:400,height 400:400:400");

        //======== pnlStartStop ========
        {
            pnlStartStop.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow,fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]" +
                "[grow,fill]",
                // rows
                "[]"));

            //---- btnStart ----
            btnStart.setText("Start");
            pnlStartStop.add(btnStart, "cell 1 0");

            //---- btnPause ----
            btnPause.setText("Pause");
            pnlStartStop.add(btnPause, "cell 2 0");

            //---- btnReset ----
            btnReset.setText("Reset");
            pnlStartStop.add(btnReset, "cell 3 0");
        }
        contentPane.add(pnlStartStop, "cell 2 3");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
