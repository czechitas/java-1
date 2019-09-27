package net.sevecek.turtle;

import java.awt.*;
import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle leonardo;
    Turtle donatello;

    public void main(String[] args) {
        Color barva1;
        leonardo = new Turtle();
        leonardo.setLocation(100.0, 300.0);
        barva1 = new Color(24, 162, 224);
        leonardo.setPenColor(barva1);

        donatello = new Turtle();
        donatello.setLocation(500.0, 300.0);
        donatello.setPenColor(new Color(178, 152, 200));

        nakresliTrojuhelnik(90.0);
        nakresliTrojuhelnik(120.0, 50.0, 130.0, Color.RED);
        nakresli3Ctverce(80.0);
    }

    public void nakresliCtverec(double delkaStrany) {
        for (int i = 0; i < 4; i++) {
            donatello.move(delkaStrany);
            donatello.turnRight(90.0);
        }
    }

    public void nakresli3Ctverce(double delkaStrany) {
        nakresliCtverec(delkaStrany);
        nakresliCtverec(delkaStrany * 2.0);
        nakresliCtverec(delkaStrany * 3.0);
    }

    public void nakresliCtverec(double delkaStrany, Color barvaCary) {
        Color puvodniBarva = donatello.getPenColor();
        donatello.setPenColor(barvaCary);
        nakresliCtverec(delkaStrany);
        donatello.setPenColor(puvodniBarva);
    }

    public void nakresliTrojuhelnik(double delkaStrany) {
        leonardo.turnRight(30.0);
        for (int i = 0; i < 3; i++) {
            leonardo.move(delkaStrany);
            leonardo.turnRight(120.0);
        }
        leonardo.turnLeft(30.0);
    }

    public void nakresliSlunicko(int pocetPaprsku, Turtle kresliciZelva) {
        for (int i = 0; i < pocetPaprsku; i++) {
            kresliciZelva.turnLeft(90.0);
            kresliciZelva.move(50.0);
            kresliciZelva.turnRight(180.0);
            kresliciZelva.penUp();
            kresliciZelva.move(50.0);
            kresliciZelva.turnLeft(90.0);
            kresliciZelva.penDown();

            kresliciZelva.move(5.0);
            kresliciZelva.turnRight(360.0/pocetPaprsku);
        }
    }

    public void nakresliTrojuhelnik(double stranaA,
                                    double stranaB,
                                    double stranaC,
                                    Color barva) {
        double uhelA;
        double uhelB;
        double uhelC;
        // https://en.wikipedia.org/wiki/Solution_of_triangles#Three_sides_given_(SSS)
        uhelA = Math.acos((stranaB*stranaB+stranaC*stranaC-stranaA*stranaA)/(2.0*stranaB*stranaC))/(Math.PI/180.0);
        uhelB = Math.acos((stranaA*stranaA+stranaC*stranaC-stranaB*stranaB)/(2.0*stranaA*stranaC))/(Math.PI/180.0);
        uhelC = 180.0 - uhelA - uhelB;

        Color puvodniBarva = leonardo.getPenColor();
        leonardo.setPenColor(barva);

        leonardo.turnRight(90.0-uhelC);
        leonardo.move(stranaA);
        leonardo.turnRight(180.0-uhelB);
        leonardo.move(stranaC);
        leonardo.turnRight(180.0-uhelA);
        leonardo.move(stranaB);
        leonardo.turnRight(90.0);

        leonardo.setPenColor(puvodniBarva);
    }

}
