package cz.czechitas.angrybirds.engine.gui;

import java.awt.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.tiles.*;
import cz.czechitas.angrybirds.engine.util.*;

public class JGameBoard extends JLayeredPane {

    private JLabel labBackground;
    private JPanel pnlWalls;
    private JTile bird;
    private JTile pig;
    private JTile explosion;

    public JGameBoard() {
        Icon imgBackground = GameUtils.loadSprite("Background.png");
        Dimension gameBoardSize = new Dimension(imgBackground.getIconWidth(), imgBackground.getIconHeight());

        setMinimumSize(gameBoardSize);
        setMaximumSize(gameBoardSize);
        setPreferredSize(gameBoardSize);
        setSize(gameBoardSize);

        labBackground = new JLabel();
        labBackground.setIcon(imgBackground);
        labBackground.setMinimumSize(gameBoardSize);
        labBackground.setPreferredSize(gameBoardSize);
        labBackground.setMaximumSize(gameBoardSize);
        labBackground.setSize(gameBoardSize);
        add(labBackground, Integer.valueOf(0));

        pnlWalls = new JPanel(null);
        pnlWalls.setOpaque(false);
        pnlWalls.setMinimumSize(gameBoardSize);
        pnlWalls.setMaximumSize(gameBoardSize);
        pnlWalls.setPreferredSize(gameBoardSize);
        pnlWalls.setSize(gameBoardSize);
        add(pnlWalls, Integer.valueOf(1));
    }

    public void addTile(JTile tile) {
        if (tile.getNonVisualTile() instanceof BirdTile) {
            bird = tile;
            add(bird, Integer.valueOf(3));
        } else if (tile.getNonVisualTile() instanceof PigTile) {
            pig = tile;
            add(pig, Integer.valueOf(2));
        } else if (tile.getNonVisualTile() instanceof ExplosionTile) {
            explosion = tile;
            add(explosion, Integer.valueOf(4));
        } else {
            pnlWalls.add(tile);
        }
    }

    public void clear() {
        pnlWalls.removeAll();
        if (bird != null) {
            remove(bird);
        }
        if (pig != null) {
            remove(pig);
        }
        if (explosion != null) {
            remove(explosion);
            bird.setVisible(false);
        }
    }
}
