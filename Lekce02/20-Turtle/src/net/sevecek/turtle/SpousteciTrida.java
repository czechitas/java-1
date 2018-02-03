package net.sevecek.turtle;

import java.awt.*;
import net.sevecek.turtle.engine.*;

public class SpousteciTrida {

    static Turtle zofka;

    public static void main(String[] args) {
        Color cervenaBarva;

        zofka = new Turtle();
        zofka.setPenWidth(10);

        nakresliOsmiuhelnik();

        cervenaBarva = new Color(255, 0, 0);
        zofka.setPenColor(cervenaBarva);
        nakresliOsmiuhelnik();
    }

    private static void nakresliOsmiuhelnik() {
        for (int i = 0; i < 8; i = i + 1) {
            zofka.move(50);
            zofka.turnLeft(45.0);
        }
    }
}
