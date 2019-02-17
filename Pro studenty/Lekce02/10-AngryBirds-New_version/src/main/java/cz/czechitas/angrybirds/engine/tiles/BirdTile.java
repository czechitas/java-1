package cz.czechitas.angrybirds.engine.tiles;

import javax.swing.*;
import cz.czechitas.angrybirds.api.*;
import cz.czechitas.angrybirds.engine.util.*;

public class BirdTile extends GenericTile {

    private BirdOrientation orientation;
    private Icon uiRightSprite;
    private Icon uiLeftSprite;
    private Icon uiUpSprite;
    private Icon uiDownSprite;

    public BirdTile() {
        super("AngryBird-down.png");
        orientation = BirdOrientation.SOUTH;
        uiRightSprite = GameUtils.loadSprite("AngryBird-right.png");
        uiLeftSprite = GameUtils.loadSprite("AngryBird-left.png");
        uiUpSprite = GameUtils.loadSprite("AngryBird-up.png");
        uiDownSprite = GameUtils.loadSprite("AngryBird-down.png");
    }

    public void setOrientation(BirdOrientation orientation) {
        this.orientation = orientation;
        if (orientation == BirdOrientation.NORTH) {
            setSprite(uiUpSprite);
        } else if (orientation == BirdOrientation.EAST) {
            setSprite(uiRightSprite);
        } else if (orientation == BirdOrientation.SOUTH) {
            setSprite(uiDownSprite);
        } else if (orientation == BirdOrientation.WEST) {
            setSprite(uiLeftSprite);
        }
    }

    public Coordinates getForwardLook() {
        int x = getX();
        int y = getY();
        if (orientation == BirdOrientation.WEST) {
            x = x - 1;
        }
        if (orientation == BirdOrientation.EAST) {
            x = x + 1;
        }
        if (orientation == BirdOrientation.NORTH) {
            y = y - 1;
        }
        if (orientation == BirdOrientation.SOUTH) {
            y = y + 1;
        }
        return new Coordinates(x, y);
    }

    public Coordinates getRightLook() {
        int x = getX();
        int y = getY();
        if (orientation == BirdOrientation.WEST) {
            y = y - 1;
        }
        if (orientation == BirdOrientation.EAST) {
            y = y + 1;
        }
        if (orientation == BirdOrientation.NORTH) {
            x = x + 1;
        }
        if (orientation == BirdOrientation.SOUTH) {
            x = x - 1;
        }
        return new Coordinates(x, y);
    }

    public Coordinates getLeftLook() {
        int x = getX();
        int y = getY();
        if (orientation == BirdOrientation.WEST) {
            y = y + 1;
        }
        if (orientation == BirdOrientation.EAST) {
            y = y - 1;
        }
        if (orientation == BirdOrientation.NORTH) {
            x = x - 1;
        }
        if (orientation == BirdOrientation.SOUTH) {
            x = x + 1;
        }
        return new Coordinates(x, y);
    }

    public void move() {
        Coordinates lookCoord = getForwardLook();
        setPosition(lookCoord.getX(), lookCoord.getY());
    }

    public void turnLeft() {
        if (orientation == BirdOrientation.WEST) {
            setOrientation(BirdOrientation.SOUTH);
        } else if (orientation == BirdOrientation.SOUTH) {
            setOrientation(BirdOrientation.EAST);
        } else if (orientation == BirdOrientation.EAST) {
            setOrientation(BirdOrientation.NORTH);
        } else if (orientation == BirdOrientation.NORTH) {
            setOrientation(BirdOrientation.WEST);
        }
    }

    public void turnRight() {
        if (orientation == BirdOrientation.WEST) {
            setOrientation(BirdOrientation.NORTH);
        } else if (orientation == BirdOrientation.NORTH) {
            setOrientation(BirdOrientation.EAST);
        } else if (orientation == BirdOrientation.EAST) {
            setOrientation(BirdOrientation.SOUTH);
        } else if (orientation == BirdOrientation.SOUTH) {
            setOrientation(BirdOrientation.WEST);
        }
    }

}
