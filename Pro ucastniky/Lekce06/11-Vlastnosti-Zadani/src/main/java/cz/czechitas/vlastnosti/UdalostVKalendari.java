package cz.czechitas.vlastnosti;

import java.time.*;

public class UdalostVKalendari {

    String popis;
    LocalTime zacatek;
    LocalTime konec;

    public void vypisInfo() {
        System.out.print("Udalost["+popis+" od ");
        System.out.print(zacatek);
        System.out.print(" do ");
        System.out.print(konec);
        System.out.println("]");

    }

}
