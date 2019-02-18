package cz.czechitas.intro.api;

import javax.swing.*;
import cz.czechitas.intro.engine.*;

public class AngryRed extends FourWayPlayer {

    public AngryRed(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon rightImage = Utils.loadSprite("Red-right.png");
            Icon leftImage = Utils.loadSprite("Red-left.png");
            Icon downImage = Utils.loadSprite("Red-down.png");
            Icon upImage = Utils.loadSprite("Red-up.png");
            init(leftImage, rightImage, upImage, downImage, x, y, PlayerType.BAD);
        });
        Gameboard.getInstance().addPlayer(this);
    }

}
