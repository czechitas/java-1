package cz.czechitas;

import java.awt.*;

public class Trojuhelnik {

    Point bodA;
    Point bodB;
    Point bodC;

    public void vypisSe() {
        System.out.print("Trojuhelnik [");
        System.out.print(bodA.x);
        System.out.print(", ");
        System.out.print(bodA.y);
        System.out.print("], [");
        System.out.print(bodB.x);
        System.out.print(", ");
        System.out.print(bodB.y);
        System.out.print("], [");
        System.out.print(bodC.x);
        System.out.print(", ");
        System.out.print(bodC.y);
        System.out.print("]");
    }

}
