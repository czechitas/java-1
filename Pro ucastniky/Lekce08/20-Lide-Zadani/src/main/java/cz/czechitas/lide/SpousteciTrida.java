package cz.czechitas.lide;

import java.awt.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        lektor.setKrestniJmeno("Kamil");
        lektor.setPrijmeni("Sevecek");
        lektor.setVek(36);
        lektor.setBarvaOci(new Color(0, 170, 0));

        System.out.println(lektor);

        lektor.zestarniORok();
        System.out.println(lektor);

        Clovek studentka = new Clovek();
        studentka.krestniJmeno = "Hermiona";
        studentka.prijmeni = "Grangerova";
        studentka.vek = 39;
        studentka.barvaOci = new Color(102, 17, 13);

        System.out.println(studentka);
    }

}
