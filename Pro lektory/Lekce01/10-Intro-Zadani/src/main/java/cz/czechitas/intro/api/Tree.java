package cz.czechitas.intro.api;

import javax.swing.*;
import cz.czechitas.intro.engine.*;

public class Tree extends Figure {

    public Tree(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon image = Utils.loadSprite("Tree.png");
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
