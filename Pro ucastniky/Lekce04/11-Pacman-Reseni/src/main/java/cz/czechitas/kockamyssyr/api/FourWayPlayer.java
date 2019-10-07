package cz.czechitas.kockamyssyr.api;

import javax.swing.*;
import cz.czechitas.kockamyssyr.engine.swing.*;

public abstract class FourWayPlayer extends Player {

    private Icon leftImage;
    private Icon downImage;
    private Icon upImage;
    private Icon rightImage;

    protected FourWayPlayer() {
    }

    @Override
    @Deprecated
    protected void init(Icon picture, int x, int y, PlayerType playerType) {
        throw new AssertionError("This method is inaccessible");
    }

    protected void init(Icon leftImage, Icon rightImage, Icon upImage, Icon downImage, int x, int y, PlayerType playerType) {
        this.leftImage = leftImage;
        this.downImage = downImage;
        this.upImage = upImage;
        this.rightImage = rightImage;
        super.init(rightImage, x, y, playerType);
    }

    @Override
    public void setOrientation(PlayerOrientation orientation) {
        Utils.invokeAndWait(() -> {
            super.setOrientation(orientation);
            switch (orientation) {
                case UP:
                    getSprite().setIcon(upImage);
                    break;
                case DOWN:
                    getSprite().setIcon(downImage);
                    break;
                case LEFT:
                    getSprite().setIcon(leftImage);
                    break;
                case RIGHT:
                    getSprite().setIcon(rightImage);
                    break;
            }
        });
    }

}
