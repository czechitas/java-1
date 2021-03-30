package cz.czechitas.intro.api;

import javax.swing.*;
import cz.czechitas.intro.engine.*;
import cz.czechitas.intro.engine.swing.*;

public class Fish extends FourWayPlayer {

    public Fish(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon rightImage = Utils.loadSprite("fish-right.png");
            Icon leftImage = Utils.loadSprite("fish-left.png");
            Icon downImage = Utils.loadSprite("fish-down.png");
            Icon upImage = Utils.loadSprite("fish-up.png");
            init(leftImage, rightImage, upImage, downImage, x, y, PlayerType.GOOD);
        });
        Gameplay.getInstance().addPlayer(this);
    }

}
