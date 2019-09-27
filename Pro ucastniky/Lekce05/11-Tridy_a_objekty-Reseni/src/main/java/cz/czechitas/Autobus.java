package cz.czechitas;

import java.awt.*;

public class Autobus {

    String vyrobniCislo;
    Color barva;
    int pocetSedicichLidi;
    int pocetStojicichLidi;

    public void vypisSe() {
        System.out.println("Autobus "
                + vyrobniCislo + ", "
                + barva + ", sedicich "
                + pocetSedicichLidi
                + ", stojicich "
                + pocetStojicichLidi);
    }

}
