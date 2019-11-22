package cz.czechitas.objekty;

import java.awt.*;

public class Usecka {

    Point bodA;
    Point bodB;

    public String toString() {
        return "Usecka od " + bodA + " do " + bodB;
    }

    public double vypocitejDelku() {
        int stranaA = bodB.x - bodA.x;
        int stranaB = bodB.y - bodA.y;
        return Math.sqrt(stranaA*stranaA + stranaB*stranaB);
    }

}
