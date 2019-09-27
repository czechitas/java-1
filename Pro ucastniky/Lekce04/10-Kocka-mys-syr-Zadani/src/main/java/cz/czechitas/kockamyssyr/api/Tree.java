package cz.czechitas.kockamyssyr.api;

import javax.swing.*;

import cz.czechitas.kockamyssyr.engine.*;

public class Tree extends Figure {

    public Tree(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon image = Utils.loadSprite("tree_shadow_1.png");
            init(image, x, y);
        });
        Gameboard.getInstance().addTree(this);
    }

    @Override
    public void remove() {
        Gameboard.getInstance().removeTree(this);
        super.remove();
    }
}
