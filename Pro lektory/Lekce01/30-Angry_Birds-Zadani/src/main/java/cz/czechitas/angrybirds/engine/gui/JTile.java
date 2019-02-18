package cz.czechitas.angrybirds.engine.gui;

import java.awt.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.tiles.*;
import net.miginfocom.swing.*;

public class JTile extends JLabel implements VisualTileListener {

    private JGameBoard parent;
    private GenericTile nonVisualTile;

    public JTile(JGameBoard parentGameBoard, GenericTile nonVisualTile) {
        this.parent = parentGameBoard;
        this.nonVisualTile = nonVisualTile;
        nonVisualTile.setVisualTileListener(this);

        setIcon(nonVisualTile.getSprite());
        setSize(nonVisualTile.getSprite().getIconWidth(), nonVisualTile.getSprite().getIconHeight());

        int x = nonVisualTile.getX();
        int y = nonVisualTile.getY();
        if (x == -1 || y == -1) {
            super.setVisible(false);
//            String migConstraint = "pos 0 0";
            setLocation(0, 0);
            parentGameBoard.addTile(this);
        } else {
//            String migConstraint = "cell " + x + " " + y;
//            parent.add(this, migConstraint);
            setLocation(x * 50, y * 50);
            parentGameBoard.addTile(this);
        }
    }

    @Override
    public void onIconChange(Icon sprite) {
        super.setIcon(sprite);
    }

    @Override
    public void onLocationChange(int previousX, int previousY, int x, int y) {
        if (x == -1 || y == -1) {
            super.setVisible(false);
        } else {
            super.setVisible(true);
//            String migConstraint = "cell " + x + " " + y;
//            String migConstraint = "pos " + x*50 + " " + y*50;
//            LayoutManager layout = parent.getLayout();
//            if (layout instanceof MigLayout) {
//                MigLayout migLayout = (MigLayout) layout;
//                migLayout.setComponentConstraints(this, migConstraint);
//            }
            setLocation(x * 50, y * 50);
        }
        parent.revalidate();
    }

    public GenericTile getNonVisualTile() {
        return nonVisualTile;
    }
}
