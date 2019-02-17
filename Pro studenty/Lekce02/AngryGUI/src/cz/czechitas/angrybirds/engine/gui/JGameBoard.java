package cz.czechitas.angrybirds.engine.gui;

import java.awt.*;
import javax.swing.*;

public class JGameBoard extends JLayeredPane {

    private JLabel background;
    private JPanel pnlwalls;
    private JLabel bird;
    private JLabel pig;
    private JLabel explosion;

    public JGameBoard() {
        setMinimumSize(new Dimension(400, 400));
        setMaximumSize(new Dimension(400, 400));
        setPreferredSize(new Dimension(400, 400));
        setSize(new Dimension(400, 400));
        background = new JLabel();
        background.setBackground(Color.RED);
        background.setOpaque(true);
        background.setLocation(50, 100);
        background.setMinimumSize(new Dimension(400, 400));
        background.setPreferredSize(new Dimension(400, 400));
        background.setMaximumSize(new Dimension(400, 400));
        background.setSize(new Dimension(400, 400));
        add(background, Integer.valueOf(0));
        pnlwalls = new JPanel(null);
        pnlwalls.setOpaque(false);
    }
}
