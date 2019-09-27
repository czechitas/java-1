package cz.czechitas;

import java.awt.*;

public class Usecka {

    Point zacatek;
    Point konec;

    public void vypisSe() {
        System.out.print("Usecka [");
        System.out.print(zacatek.x);
        System.out.print(", ");
        System.out.print(zacatek.y);
        System.out.print("] -> [");
        System.out.print(konec.x);
        System.out.print(", ");
        System.out.print(konec.y);
        System.out.println("]");
    }

}
