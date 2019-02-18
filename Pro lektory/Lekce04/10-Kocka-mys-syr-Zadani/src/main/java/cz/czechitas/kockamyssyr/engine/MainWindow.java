package cz.czechitas.kockamyssyr.engine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cz.czechitas.kockamyssyr.api.*;
import net.miginfocom.swing.*;
import net.sevecek.util.swing.*;

public class MainWindow extends JFrame {

    public static final String WINDOW_TITLE = "Game Engine";
    private static MainWindow instance;
    private MigLayout migLayoutManager;
    private JPanel contentPane;
    private JKeyboard keyboard;

    public synchronized static MainWindow getInstance() {
        if (instance == null) {
            SwingExceptionHandler.install();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                System.err.println("Unable to set platform look and feel for Swing");
            }
            instance = new MainWindow(WINDOW_TITLE);
            instance.setVisible(true);
        }
        return instance;
    }

    private MainWindow(String title) {
        super(title);
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onWindowClosing(e);
            }
        });
        contentPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                onWindowResized(e);
            }
        });

        String singleCell = "[50px:50px:50px,fill]";
        String rowConstraints = "";
        for (int i = 0; i < 12; i++) {
            rowConstraints += singleCell;
        }
        String colConstraints = "";
        for (int i = 0; i < 20; i++) {
            colConstraints += singleCell;
        }

        this.migLayoutManager = new MigLayout(
                "insets rel,hidemode 3,gap 0px",
                // columns
                colConstraints,
                // rows
                rowConstraints);
        contentPane.setLayout(migLayoutManager);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        keyboard = new JKeyboard();

        pack();
        setLocationRelativeTo(null);
    }

    private void onWindowResized(ComponentEvent evt) {
        setTitle(WINDOW_TITLE + " [Size: " + contentPane.getWidth() + " x " + contentPane.getHeight() + "]");
    }

    private void onWindowClosing(WindowEvent evt) {
        Gameboard.getInstance().stop();
    }

    public JKeyboard getKeyboard() {
        return keyboard;
    }

//    public void externFromMigLayout(JLabel sprite) {
//        migLayoutManager.setComponentConstraints(sprite, "external");
//    }

    public void updateSpriteLocation(JLabel sprite) {
        migLayoutManager.setComponentConstraints(sprite, "pos " + sprite.getX() + " " + sprite.getY());
        contentPane.revalidate();
    }
}
