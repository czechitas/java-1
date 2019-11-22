package cz.czechitas.kockamyssyr.api;

import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.*;
import cz.czechitas.kockamyssyr.engine.swing.*;

public class Mouse extends FourWayPlayer {

    public Mouse(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon rightImage = Utils.loadSprite("mouse-right.png");
            Icon leftImage = Utils.loadSprite("mouse-left.png");
            Icon downImage = Utils.loadSprite("mouse-down.png");
            Icon upImage = Utils.loadSprite("mouse-up.png");
            init(leftImage, rightImage, upImage, downImage, x, y, PlayerType.GOOD);
        });
        Gameplay.getInstance().addPlayer(this);
    }

}
