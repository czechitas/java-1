package cz.czechitas.kockamyssyr.api;

import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import cz.czechitas.kockamyssyr.engine.swing.*;

public class Meat extends Player {

    public Meat(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon image = Utils.loadSprite("meat.png");
            init(image, x, y, PlayerType.FOOD);
        });
        Gameplay.getInstance().addPlayer(this);
    }

}
