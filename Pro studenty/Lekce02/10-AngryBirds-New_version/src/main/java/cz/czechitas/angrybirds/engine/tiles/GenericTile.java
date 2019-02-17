package cz.czechitas.angrybirds.engine.tiles;

import javax.swing.*;
import cz.czechitas.angrybirds.engine.util.*;

public class GenericTile {

    private int x;
    private int y;
    private Icon sprite;
    private VisualTileListener visualTileListener;

    public GenericTile(String spriteName) {
        x = -1;
        y = -1;
        sprite = GameUtils.loadSprite(spriteName);
        visualTileListener = NoOpVisualListener.getInstance();
    }

    public void setVisualTileListener(VisualTileListener visualTileListener) {
        this.visualTileListener = visualTileListener;
    }

    public Icon getSprite() {
        return sprite;
    }

    protected void setSprite(Icon sprite) {
        this.sprite = sprite;
        GameUtils.notifyVisualListener(() -> visualTileListener.onIconChange(this.sprite));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        int previousX = this.x;
        int previousY = this.y;
        if (x == -1 || y == -1) {
            if (x != -1 || y != -1) throw new AssertionError("X and Y must either be both -1 or none of them");
        }
        this.x = x;
        this.y = y;
        GameUtils.notifyVisualListener(() -> visualTileListener.onLocationChange(previousX, previousY, x, y));
    }
}
