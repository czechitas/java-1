package cz.czechitas.objekty;

import java.awt.*;

public class Trojuhelnik {

    Point bodA;
    Point bodB;
    Point bodC;

    public String toString() {
        return "Trojuhelnik bodA=" + bodA + ", bodB=" + bodB + ", bodC=" + bodC;
    }

    public double vypocitejObsah() {
        double obsah = Math.abs(
                (bodA.x * (bodB.y - bodC.y)
                + bodB.x*(bodC.y-bodA.y)
                + bodC.x*(bodA.y - bodB.y)) / 2.0);
        return obsah;
    }

}
