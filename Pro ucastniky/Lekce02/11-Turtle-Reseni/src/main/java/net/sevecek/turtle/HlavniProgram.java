package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle zofka;

    public void main(String[] args) {
        zofka = new Turtle();

        // nakresliHvezdicku()

        zofka.penUp();
        zofka.turnRight(180.0);
        zofka.move(200.0);
        zofka.turnLeft(180.0);
        zofka.penDown();

        this.nakresliDomecek();

        zofka.penUp();
        zofka.turnLeft(90.0);
        zofka.move(200.0);
        zofka.turnRight(90.0);
        zofka.penDown();

        this.nakresliPrasatko();
    }

    public void nakresliPrasatko() {
        zofka.turnLeft(90.0);
        this.nakresliDomecek();
        this.nakresliNozky();
        zofka.move(150.0);
        this.nakresliNozky();
    }

    public void nakresliNozky() {
        zofka.turnLeft(45.0);
        zofka.move(40.0);
        zofka.turnRight(180.0);
        zofka.move(40.0);
        zofka.turnRight(90.0);
        zofka.move(40.0);
        zofka.turnRight(180.0);
        zofka.move(40.0);
        zofka.turnLeft(45.0);
    }


    public void nakresliDomecek() {
        for (int i = 0; i < 4; i++) {
            zofka.move(150.0);
            zofka.turnRight(90.0);
        }

        zofka.penUp();
        zofka.move(150.0);
        zofka.penDown();

        zofka.turnRight(30.0);
        zofka.move(150.0);
        zofka.turnRight(120.0);
        zofka.move(150.0);

        zofka.turnRight(30.0);
        zofka.penUp();
        zofka.move(150.0);
        zofka.turnRight(90.0);
        zofka.move(150.0);
        zofka.turnRight(90.0);
        zofka.penDown();
    }

    public void nakresliHvezdicku() {
        for (int i = 0; i < 8; i++) {
            nakresliPaprsek();
            zofka.turnRight(45.0);
        }
        zofka.turnRight(135.0);
        zofka.penUp();
        zofka.move(70);
        zofka.penDown();
    }

    public void nakresliPaprsek() {
        zofka.move(50);
        zofka.turnRight(180.0);
        zofka.move(50);
        zofka.turnRight(180.0);
    }
}
