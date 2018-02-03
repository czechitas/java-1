package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

public class SpousteciTrida {

    static Turtle zofka;

    public static void main(String[] args) {
        zofka = new Turtle();
        nakresliHvezdicku();
    }

    public static void nakresliHvezdicku() {
        for (int i = 0; i < 8; i++) {
            nakresliPaprsek();
            zofka.turnRight(45.0);
        }
        zofka.turnRight(135.0);
        zofka.penUp();
        zofka.move(70);
        zofka.penDown();
    }

    private static void nakresliPaprsek() {
        zofka.move(50);
        zofka.turnRight(180.0);
        zofka.move(50);
        zofka.turnRight(180.0);
    }

}
