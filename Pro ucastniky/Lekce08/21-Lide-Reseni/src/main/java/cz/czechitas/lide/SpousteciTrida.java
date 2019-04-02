package cz.czechitas.lide;

import java.awt.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Clovek lektor = new Clovek("Kamil", "Sevecek", 37, new Color(0, 255, 0));
        System.out.println(lektor);

        lektor.zestarniORok();
        System.out.println(lektor);

        Clovek studentka = new Clovek("Hermione", "Granger", 39, new Color(102, 17, 13));
        System.out.println(studentka);
    }

}
