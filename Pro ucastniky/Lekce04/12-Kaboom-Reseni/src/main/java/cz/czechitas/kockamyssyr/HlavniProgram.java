package cz.czechitas.kockamyssyr;

import java.util.*;
import cz.czechitas.kockamyssyr.api.*;
import net.sevecek.util.*;

public class HlavniProgram {

    public void main(String[] args) {
        GameManager gameManager = new GameManager();
        int mysX = ((gameManager.getWidth() / 2) / 50) * 50;
        int mysY = ((gameManager.getHeight() - 49) / 50) * 50;
        Mouse gonzales = new Mouse(mysX, mysY);
        KeyboardBrain ovladacMysi = new KeyboardBrain(KeyCode.SPACE, KeyCode.LEFT, KeyCode.SPACE, KeyCode.RIGHT);
        gonzales.setBrain(ovladacMysi);

        Random randomGenerator = new Random();

        int velikostX = gameManager.getWidth() / 50;
        int syrX = randomGenerator.nextInt(velikostX) * 50;
        Cheese syr = new Cheese(syrX, 0);
        int pocetSyru = 0;
        while (syr != null) {
            Cheese pristiSyr = null;
            if (pocetSyru<4) {
                int pristiSyrX = randomGenerator.nextInt(velikostX) * 50;
                pristiSyr = new Cheese(pristiSyrX, 0);
            }
            syr.turnRight();
            while (syr.getY() < gameManager.getHeight() - 60 && !syr.isRemoved()) {
                syr.moveForward();
            }
            if (!syr.isRemoved()) {
                break;
            }
            syr = pristiSyr;
            pocetSyru++;
        }

        if (syr != null) {
            gonzales.setBrain(null);
            Cat kocka = new Cat(gonzales.getX()-200, mysY);
            kocka.moveForward(400);
        }
    }

}
