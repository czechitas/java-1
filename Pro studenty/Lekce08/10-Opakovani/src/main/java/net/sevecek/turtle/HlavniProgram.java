package net.sevecek.turtle;

import java.awt.*;
import java.util.*;
import net.sevecek.turtle.engine.*;

public class HlavniProgram {


    public void main(String[] args) {
        Turtle zofka;
        zofka = new Turtle();
    }



















    /*
    public void nakresliCtverec(double delkaStrany) {
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90.0);
        }
    }

    public void nakresliRovnostrannyTrojuhelnik(double delkaStrany) {
        zofka.turnRight(30.0);
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(120.0);
        }
        zofka.turnLeft(30.0);
    }

    public void nakresliTrojuhelnik(double stranaA,
                                    double stranaB,
                                    double stranaC,
                                    Color barva) {
        double uhelA;
        double uhelB;
        double uhelC;
        // https://en.wikipedia.org/wiki/Solution_of_triangles#Three_sides_given_(SSS)
        uhelA = vypocitejUhelA(stranaA, stranaB, stranaC);
        uhelB = Math.acos((stranaA*stranaA+stranaC*stranaC-stranaB*stranaB)/(2.0*stranaA*stranaC))/(Math.PI/180.0);
        uhelC = 180.0 - uhelA - uhelB;

        Color puvodniBarva = zofka.getPenColor();
        zofka.setPenColor(barva);

        zofka.turnRight(90.0-uhelC);
        zofka.move(stranaA);
        zofka.turnRight(180.0-uhelB);
        zofka.move(stranaC);
        zofka.turnRight(180.0-uhelA);
        zofka.move(stranaB);
        zofka.turnRight(90.0);

        zofka.setPenColor(puvodniBarva);
    }

    public double vypocitejUhelA(double strA, double strB, double strC) {
        double uhel;
        uhel = Math.acos((strB*strB+strC*strC-strA*strA)/(2.0*strB*strC))/(Math.PI/180.0);
        return uhel;
    }
      */
}
