package cz.czechitas.kockamyssyr.api;

import javax.swing.*;

import cz.czechitas.kockamyssyr.engine.*;
import cz.czechitas.kockamyssyr.engine.swing.*;

public class Tree extends Figure implements Stackable {

    private Icon stackedImage;

    public Tree(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon image = Utils.loadSprite("tree.png");
            stackedImage = Utils.loadSprite("tree-stacked.png");
            init(image, x, y);
        });
        Gameplay.getInstance().addPassiveFigure(this);
    }

    @Override
    public void remove() {
        Gameplay.getInstance().removePassiveFigure(this);
        super.remove();
    }

    @Override
    public Icon getStackableIcon() {
        return stackedImage;
    }
}
