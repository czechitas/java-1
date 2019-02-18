package cz.czechitas.intro.api;

import javax.swing.*;
import cz.czechitas.intro.engine.*;

public class AngryMatilda extends FourWayPlayer {

    public AngryMatilda(int x, int y) {
        Utils.invokeAndWait(() -> {
            Icon rightImage = Utils.loadSprite("Matilda-right.png");
            Icon leftImage = Utils.loadSprite("Matilda-left.png");
            Icon downImage = Utils.loadSprite("Matilda-down.png");
            Icon upImage = Utils.loadSprite("Matilda-up.png");
            init(leftImage, rightImage, upImage, downImage, x, y, PlayerType.GOOD);
        });
        Gameboard.getInstance().addPlayer(this);
    }

}
