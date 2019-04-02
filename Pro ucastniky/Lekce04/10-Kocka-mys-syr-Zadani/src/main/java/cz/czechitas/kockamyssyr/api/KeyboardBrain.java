package cz.czechitas.kockamyssyr.api;

import cz.czechitas.kockamyssyr.engine.*;
import net.sevecek.util.*;
import net.sevecek.util.swing.*;

public class KeyboardBrain implements Brain {

    private int keyCodeLeft;
    private int keyCodeUp;
    private int keyCodeRight;
    private int keyCodeDown;

    public KeyboardBrain() {
        this(KeyCode.UP, KeyCode.LEFT, KeyCode.DOWN, KeyCode.RIGHT);
    }

    public KeyboardBrain(KeyCode keyCodeUp, KeyCode keyCodeLeft, KeyCode keyCodeDown, KeyCode keyCodeRight) {
        this.keyCodeLeft = keyCodeLeft.getKeyEventVkCode();
        this.keyCodeUp = keyCodeUp.getKeyEventVkCode();
        this.keyCodeRight = keyCodeRight.getKeyEventVkCode();
        this.keyCodeDown = keyCodeDown.getKeyEventVkCode();
    }

    @Override
    public void controlPlayer(Player player) {
        while (true) {
            ThreadUtils.sleep(20L);
            Utils.invokeLater(() -> {
                JKeyboard keyboard = MainWindow.getInstance().getKeyboard();
                if (keyboard.isKeyDown(keyCodeUp)) {
                    player.setOrientation(PlayerOrientation.UP);
                    player.moveForwardInternal();
                }
                if (keyboard.isKeyDown(keyCodeDown)) {
                    player.setOrientation(PlayerOrientation.DOWN);
                    player.moveForwardInternal();
                }
                if (keyboard.isKeyDown(keyCodeLeft)) {
                    player.setOrientation(PlayerOrientation.LEFT);
                    player.moveForwardInternal();
                }
                if (keyboard.isKeyDown(keyCodeRight)) {
                    player.setOrientation(PlayerOrientation.RIGHT);
                    player.moveForwardInternal();
                }
                player.getSprite().repaint();
            });
        }
    }

    public int getKeyCodeLeft() {
        return keyCodeLeft;
    }

    public int getKeyCodeUp() {
        return keyCodeUp;
    }

    public int getKeyCodeRight() {
        return keyCodeRight;
    }

    public int getKeyCodeDown() {
        return keyCodeDown;
    }
}
