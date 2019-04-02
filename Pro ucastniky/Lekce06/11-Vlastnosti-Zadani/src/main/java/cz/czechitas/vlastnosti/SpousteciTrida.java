package cz.czechitas.vlastnosti;

import java.time.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Karta karta1 = new Karta();
        karta1.hodnota = 11;
        karta1.barva = 2;
        System.out.println(karta1);
        //  Karta hodnota spodek, barva listy

        UdalostVKalendari kofola = new UdalostVKalendari();
        kofola.popis = "Jdeme na kofolu";
        kofola.zacatek = LocalTime.of(20, 30);
        kofola.konec = LocalTime.of(23, 0);
        kofola.vypisInfo();
    }

}
