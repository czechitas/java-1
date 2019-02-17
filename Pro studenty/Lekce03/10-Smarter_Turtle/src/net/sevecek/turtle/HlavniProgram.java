package net.sevecek.turtle;

import java.awt.*;
import java.util.*;
import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle zofka;

    public void run() {
        Color barva1;
        Color barva2;

        zofka = new Turtle();
        zofka.setPenWidth(3);

        barva1 = vygenerujNahodnouBarvu();
        barva2 = new Color(255, 50, 56);

        zofka.setPenColor(barva1);
        nakresliPismenoA();
        zofka.setPenColor(barva2);
//        nastavZofceNahodnouBarvu();
        nakresliPismenoH();
        zofka.setPenColor(barva1);
//        nastavZofceNahodnouBarvu();
        nakresliPismenoO();
        zofka.setPenColor(barva2);
        nakresliPismenoJ();
        nakresliCarku();
        nakresliMezeru();
        zofka.setPenColor(barva1);
        nakresliPismenoT();
        zofka.setPenColor(barva2);
        nakresliPismenoA();
        zofka.setPenColor(barva1);
        nakresliPismenoD();
        zofka.setPenColor(barva2);
        nakresliPismenoY();
        nakresliMezeru();
        zofka.setPenColor(barva1);
        nakresliPismenoA();
        zofka.setPenColor(barva2);
        nakresliPismenoD();
        zofka.setPenColor(barva1);
        nakresliPismenoA();
    }

    private Color vygenerujNahodnouBarvu() {
        Random generator;
        int red;
        int green;
        int blue;
        Color nahodnaBarva;

        generator = new Random();
        red = generator.nextInt(256);
        green = generator.nextInt(256);
        blue = generator.nextInt(256);

        nahodnaBarva = new Color(red, green, blue);
        return nahodnaBarva;
//        zofka.setPenColor(nahodnaBarva);
    }

    private void nakresliPismenoY() {
        zofka.penUp();
        zofka.turnRight(90.0);
        zofka.move(25.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
        zofka.move(77.0);
        zofka.turnLeft(45.0);
        zofka.move(35.0);
        zofka.penUp();
        zofka.turnRight(180.0);
        zofka.move(35.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
        zofka.move(35.0);
        zofka.penUp();
        zofka.turnLeft(180.0);
        zofka.move(35.0);
        zofka.turnLeft(45.0);
        zofka.move(77.0);
        zofka.turnLeft(90.0);
        zofka.move(35.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliPismenoD() {
        zofka.move(100.0);
        zofka.turnRight(90.0);
        zofka.move(37.0);
        zofka.turnRight(45.0);
        zofka.move(17.0);
        zofka.turnRight(45.0);
        zofka.move(77.0);
        zofka.turnRight(45.0);
        zofka.move(17.0);
        zofka.turnRight(45.0);
        zofka.move(37.0);
        zofka.penUp();
        zofka.turnRight(180.0);
        zofka.move(60.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliPismenoT() {
        zofka.penUp();
        zofka.turnRight(90.0);
        zofka.move(25.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
        zofka.move(100.0);
        zofka.turnLeft(90.0);
        zofka.move(25.0);
        zofka.turnRight(180.0);
        zofka.move(50.0);
        zofka.penUp();
        zofka.turnRight(90.0);
        zofka.move(100.0);
        zofka.turnLeft(90.0);
        zofka.move(10.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliMezeru() {
        zofka.penUp();
        zofka.turnRight(90.0);
        zofka.move(50.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliCarku() {
        zofka.turnLeft(135.0);
        zofka.move(10.0);
        zofka.penUp();
        zofka.turnRight(180.0);
        zofka.move(10.0);
        zofka.turnRight(45.0);
        zofka.move(10.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliPismenoJ() {
        zofka.penUp();
        zofka.move(12.0);
        zofka.penDown();
        zofka.turnRight(135.0);
        zofka.move(17.0);
        zofka.turnLeft(45.0);
        zofka.move(25.0);
        zofka.turnLeft(45.0);
        zofka.move(17.0);
        zofka.turnLeft(45.0);
        zofka.move(89.0);
        zofka.turnLeft(90.0);
        zofka.move(50.0);
        zofka.penUp();
        zofka.turnLeft(90.0);
        zofka.move(100.0);
        zofka.turnLeft(90.0);
        zofka.move(60.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliPismenoO() {
        zofka.penUp();
        zofka.move(10);
        zofka.penDown();
        zofka.move(77.0);
        zofka.turnRight(45.0);
        zofka.move(17.0);
        zofka.turnRight(45.0);
        zofka.move(25.0);
        zofka.turnRight(45.0);
        zofka.move(17.0);
        zofka.turnRight(45.0);
        zofka.move(77.0);
        zofka.turnRight(45.0);
        zofka.move(17.0);
        zofka.turnRight(45.0);
        zofka.move(25.0);
        zofka.turnRight(45.0);
        zofka.move(17.0);
        zofka.turnRight(180.0);
        zofka.penUp();
        zofka.move(17.0);
        zofka.turnLeft(45.0);
        zofka.move(50.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliPismenoH() {
        zofka.move(100.0);
        zofka.turnLeft(180.0);
        zofka.move(50.0);
        zofka.turnLeft(90.0);
        zofka.move(50.0);
        zofka.turnLeft(90.0);
        zofka.move(50.0);
        zofka.turnLeft(180.0);
        zofka.move(100.0);
        zofka.penUp();
        zofka.turnLeft(90.0);
        zofka.move(10.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliPismenoA() {
        zofka.turnRight(20.0);
        zofka.move(105.0);
        zofka.turnRight(140.0);
        zofka.move(105.0);
        zofka.turnLeft(180.0);
        zofka.penUp();
        zofka.move(30.0);
        zofka.penDown();
        zofka.turnLeft(70.0);
        zofka.move(48.0);
        zofka.penUp();
        zofka.turnLeft(180.0);
        zofka.move(48.0);
        zofka.turnRight(70.0);
        zofka.move(30.0);
        zofka.turnLeft(70.0);
        zofka.move(10.0);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }
    
    
}
