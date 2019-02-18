package net.sevecek.turtle.engine;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.reflect.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import net.sevecek.util.*;
import net.sevecek.util.swing.*;

public class Board {

    private static Board instance = new Board();
    private static Collection<Thread> threads = new HashSet<>();
    private final JLabel visualPaintingComponent;
    private final JPanel centerPanel;
    private final JPanel topPanel;
    private double speed = 1.0;
    private double rotationSpeed = 1.0;
    private boolean shouldPause;

    public static Board getInstance(Thread thread) {
        threads.add(thread);
        return instance;
    }

    //-------------------------------------------------------------------------

    private JFrame window;
    private BufferedImage painting;

    private Board() {
        SwingExceptionHandler.install();
        
        window = new JFrame("Turtle");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        painting = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_4BYTE_ABGR);
        visualPaintingComponent = new JLabel(new ImageIcon(painting));
        visualPaintingComponent.setHorizontalAlignment(SwingConstants.LEFT);
        visualPaintingComponent.setVerticalAlignment(SwingConstants.TOP);
        visualPaintingComponent.setLocation(0, 0);
        visualPaintingComponent.setSize(visualPaintingComponent.getPreferredSize());

        centerPanel = new JPanel(null, false);
        centerPanel.add(visualPaintingComponent);

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPauseButtonClick(e);
            }
        });
        pauseButton.setFocusPainted(false);
        JLabel speedLabel = new JLabel("Speed:");
        JSlider speedSlider = new JSlider(-100, 100, 0);
        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onSpeedSliderChange(speedSlider);
            }
        });
        topPanel.add(pauseButton);
        topPanel.add(new JLabel("       "));
        topPanel.add(speedLabel);
        topPanel.add(speedSlider);
        window.add(topPanel, BorderLayout.NORTH);

        window.add(centerPanel, BorderLayout.CENTER);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onWindowClosing();
            }
        });
        window.setSize((int) (screenSize.width * 0.7), (int) (screenSize.height*0.7));
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public boolean getShouldPause() {
        return shouldPause;
    }

    private void onPauseButtonClick(ActionEvent evt) {
        shouldPause = !shouldPause;
    }

    private void onSpeedSliderChange(JSlider sldSpeed) {
        int sliderValue = sldSpeed.getValue();
        if (sliderValue < 0) {
            speed = 1.0 / (sliderValue / -40.0);
        } else if (sliderValue > 0) {
            speed = 1.0 * (sliderValue / 1.0);
        } else {
            speed = 1.0;
        }
    }

    private void onWindowClosing() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        window.dispose();
    }

    public void add(JLabel sprite) {
        centerPanel.add(sprite);
    }

    public static void invokeAndWait(Runnable method) {
        try {
            SwingUtilities.invokeAndWait(method);
        } catch (InterruptedException | InvocationTargetException e) {
            throw ExceptionUtils.rethrowAsUnchecked(e);
        }
    }

    public BufferedImage getPainting() {
        return painting;
    }

    public void repaint() {
        visualPaintingComponent.repaint();
    }

    public Dimension getSize() {
        return window.getContentPane().getSize();
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double newValue) {
        this.speed = newValue;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }
}
