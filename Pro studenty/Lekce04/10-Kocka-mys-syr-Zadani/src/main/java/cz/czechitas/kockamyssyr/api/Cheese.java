package cz.czechitas.kockamyssyr.api;

import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import cz.czechitas.kockamyssyr.engine.swing.*;

public class Cheese extends Player {

    public Cheese(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon image = Utils.loadSprite("cheese.png");
            init(image, x, y, PlayerType.FOOD);
        });
        Gameplay.getInstance().addPlayer(this);
    }

}
