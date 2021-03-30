package cz.czechitas.intro.api;

import javax.swing.*;

import cz.czechitas.intro.engine.*;
import cz.czechitas.intro.engine.swing.*;

public class Stone extends Figure implements Stackable {

    private Icon stackedImage;

    public Stone(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon image = Utils.loadSprite("stone.png");
            stackedImage = Utils.loadSprite("stone-stacked.png");
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
