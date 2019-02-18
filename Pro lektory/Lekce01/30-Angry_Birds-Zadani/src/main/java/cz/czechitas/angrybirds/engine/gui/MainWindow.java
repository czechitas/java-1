package cz.czechitas.angrybirds.engine.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import cz.czechitas.angrybirds.engine.*;
import cz.czechitas.angrybirds.engine.tiles.*;
import cz.czechitas.angrybirds.engine.util.*;
import net.miginfocom.swing.*;

public class MainWindow extends JFrame implements VisualListener {

    private Game game;
    private JPanel contentPane;
    private JPanel pnlLevels;
    private Map<String, JToggleButton> btnLevels;
    private JTextArea labChallengeText;
    private JGameBoard pnlGameBoard;
    private JPanel pnlStartStop;
    private JButton btnStart;
    private JButton btnPause;
    private JButton btnReset;

    public MainWindow(Game game) {
        this.game = game;
    }

    public void init() {
        initVisualComponents();
        game.setVisualListener(this);
        game.initCurrentLevel();
    }

    private void initVisualComponents() {
        pnlLevels = new JPanel();
        labChallengeText = new JTextArea(6, 10);
        pnlGameBoard = new JGameBoard();
        pnlStartStop = new JPanel();
        btnStart = new JButton();
        btnPause = new JButton();
        btnReset = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Code.org - Angry Birds");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onWindowClosing(e);
            }
        });
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel, hidemode 3, align center center",
            // columns
            "[grow,fill]" +
            "[grow,fill]" +
            "[fill]" +
            "[grow,fill]" +
            "[grow,fill]",
            // rows
            "[]" +
            "[]30" +
            "[]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        pnlLevels.setLayout(new MigLayout(
                "hidemode 3,align center top, wrap 10",
                // columns
                "[sizegroup 1,fill]",
                // rows
                "[sizegroup 1]"));

        contentPane.add(pnlLevels, "cell 1 0 3 1");

        //---- labChallengeText ----
        labChallengeText.setText("Zni\u010d to prase!");
        Font font = contentPane.getFont();
        labChallengeText.setFont(font.deriveFont(font.getStyle() | Font.BOLD, font.getSize() + 4f));
//        labChallengeText.setMaximumSize(new Dimension(400, 2000));
        labChallengeText.setLineWrap(true);
        labChallengeText.setWrapStyleWord(true);
        labChallengeText.setBorder(new CompoundBorder(new SoftBevelBorder(BevelBorder.LOWERED), new EmptyBorder(10, 10, 10, 10)));
        labChallengeText.setEditable(false);
        labChallengeText.setOpaque(false);
        contentPane.add(labChallengeText, "cell 1 1 3 1");

        contentPane.add(pnlGameBoard, "cell 2 2");

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
            btnStart.addActionListener(this::onStartClicked);
            pnlStartStop.add(btnStart, "cell 1 0");
            btnStart.requestFocus();
            getRootPane().setDefaultButton(btnStart);

            //---- btnPause ----
            btnPause.setText("Pause");
            btnPause.addActionListener(this::onPauseClicked);
            pnlStartStop.add(btnPause, "cell 2 0");

            //---- btnReset ----
            btnReset.setText("Reset");
            btnReset.addActionListener(this::onResetClicked);
            pnlStartStop.add(btnReset, "cell 3 0");
        }
        contentPane.add(pnlStartStop, "cell 2 3");

        //-----------------------------------------------------------------

        initializeLevels();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeLevels() {
        btnLevels = new TreeMap<>();
        for (String levelName : this.game.getLevelNames()) {
            JToggleButton btnSingleLevel = new JToggleButton(levelName);
            btnSingleLevel.addActionListener((e) -> onChangeLevelClicked(levelName));
            btnSingleLevel.setFocusable(false);
            btnLevels.put(levelName, btnSingleLevel);
            pnlLevels.add(btnSingleLevel);
        }
    }

    //-------------------------------------------------------------------------

    private void onChangeLevelClicked(String selectedLevelName) {
        game.terminate();
        game.changeLevel(selectedLevelName);
    }

    @Override
    public void levelChanged() {
        resetExecuted();
    }

    private void initVisualLevel() {
        pnlGameBoard.clear();
        for (GenericTile tile : game.getAllTiles()) {
            initTile(tile);
        }

        String selectedLevelName = game.getCurrentLevelName();
        for (Map.Entry<String, JToggleButton> buttonEntry : btnLevels.entrySet()) {
            String levelName = buttonEntry.getKey();
            if (levelName.equals(selectedLevelName)) {
                buttonEntry.getValue().setSelected(true);
            } else {
                buttonEntry.getValue().setSelected(false);
            }
        }

        labChallengeText.setText(game.getChallengeText());
        pnlGameBoard.repaint();
        pack();
    }

    private JTile initTile(GenericTile nonVisualTile) {
        JTile visualTile = new JTile(pnlGameBoard, nonVisualTile);
        return visualTile;
    }

    //-------------------------------------------------------------------------

    private void onStartClicked(ActionEvent e) {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        game.start();
    }

    private void onPauseClicked(ActionEvent e) {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        game.pause();
    }

    private void onResetClicked(ActionEvent e) {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        game.reset();
    }

    private void onWindowClosing(WindowEvent e) {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        game.terminate();
    }

    //-------------------------------------------------------------------------
    // Callbacks from the ExecutionEngine

    @Override
    public void startExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(true);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnPause);
        btnPause.requestFocus();
    }

    @Override
    public void pauseExecuted() {
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnStart);
        btnStart.requestFocus();
    }

    @Override
    public void resetExecuted() {
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        getRootPane().setDefaultButton(btnStart);
        btnStart.requestFocus();
        initVisualLevel();
    }

    @Override
    public void negativeEndExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnReset);
        btnReset.requestFocus();
        JOptionPane.showMessageDialog(this,
                "Ale ne...! Angry bird musí strefit prase!",
                "Bohužel",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void nullEndExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnReset);
        btnReset.requestFocus();
        JOptionPane.showMessageDialog(this,
                "Ještě tam nejsme. Angry bird musí strefit prase!",
                "Přihořívá...",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void positiveEndExecuted() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(false);
        btnReset.setEnabled(true);
        getRootPane().setDefaultButton(btnReset);
        btnReset.requestFocus();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("cz/czechitas/angrybirds/images/tick.png"));
        JOptionPane.showMessageDialog(this,
                "Výborně! Pusťte se do dalšího levelu",
                "Výborně",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }

}
