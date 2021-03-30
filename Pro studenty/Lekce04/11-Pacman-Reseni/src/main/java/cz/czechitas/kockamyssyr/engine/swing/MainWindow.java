package cz.czechitas.kockamyssyr.engine.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.swing.*;

public class MainWindow extends JFrame {

    public static final String WINDOW_TITLE = "Game Engine";
    private static MainWindow instance;
    private MigLayout migLayoutManager;
    private JPanel contentPane;
    private JKeyboard keyboard;
    private JLabel message;

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
        contentPane = (JPanel) getContentPane();
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
        String columnConstraints = "";
        for (int i = 0; i < 20; i++) {
            columnConstraints += singleCell;
        }

        migLayoutManager = new MigLayout(
                "insets 0,hidemode 3,gap 0px",
                // columns
                columnConstraints,
                // rows
                rowConstraints);
        contentPane.setLayout(migLayoutManager);
        contentPane = (JPanel) this.getContentPane();
        contentPane.setBackground(this.getBackground());

        message = new JLabel();
        Font font = message.getFont().deriveFont(50.0F);
        message.setFont(font);
        contentPane.add(message, "pos 50% 50%");
        contentPane.setComponentZOrder(message, 0);

        keyboard = new JKeyboard();

        pack();
        setLocationRelativeTo(null);
    }

    private void onWindowResized(ComponentEvent evt) {
        setTitle(WINDOW_TITLE + " [Size: " + contentPane.getWidth() + " x " + contentPane.getHeight() + "]");
    }

    public void addWindowClosingListener(Runnable listener) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                listener.run();
            }
        });
    }

    public JKeyboard getKeyboard() {
        return keyboard;
    }

    public void showMessage(String text) {
        message.setText(text);
        Dimension size = message.getPreferredSize();
        migLayoutManager.setComponentConstraints(message, "pos 50%-" + size.getWidth() / 2.0 + "px 50%-" + size.getHeight() / 2.0 + "px");
        migLayoutManager.invalidateLayout(contentPane);
        repaint();
    }

//    public void updateSpriteLocation(JLabel sprite) {
//        migLayoutManager.setComponentConstraints(sprite, "pos " + sprite.getX() + " " + sprite.getY());
//        contentPane.revalidate();
//    }
}
