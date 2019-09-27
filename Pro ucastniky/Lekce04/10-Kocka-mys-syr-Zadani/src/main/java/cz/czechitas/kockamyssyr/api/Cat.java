package cz.czechitas.kockamyssyr.api;

import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;

public class Cat extends FourWayPlayer {

    public Cat(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon rightImage = Utils.loadSprite("cat3-right.png");
            Icon leftImage = Utils.loadSprite("cat3-left.png");
            Icon downImage = Utils.loadSprite("cat3-down.png");
            Icon upImage = Utils.loadSprite("cat3-up.png");
            init(leftImage, rightImage, upImage, downImage, x, y, PlayerType.BAD);
        });
        Gameboard.getInstance().addPlayer(this);
    }

}
