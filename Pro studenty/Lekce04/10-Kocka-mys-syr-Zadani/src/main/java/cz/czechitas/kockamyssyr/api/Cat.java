package cz.czechitas.kockamyssyr.api;

import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import cz.czechitas.kockamyssyr.engine.swing.*;

public class Cat extends FourWayPlayer {

    public Cat(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon rightImage = Utils.loadSprite("cat-right.png");
            Icon leftImage = Utils.loadSprite("cat-left.png");
            Icon downImage = Utils.loadSprite("cat-down.png");
            Icon upImage = Utils.loadSprite("cat-up.png");
            init(leftImage, rightImage, upImage, downImage, x, y, PlayerType.BAD);
        });
        Gameplay.getInstance().addPlayer(this);
    }

}
