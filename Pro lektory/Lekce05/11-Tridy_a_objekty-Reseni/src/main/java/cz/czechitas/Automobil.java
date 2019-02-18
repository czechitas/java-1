package cz.czechitas;

import java.awt.*;

public class Automobil {

    String znacka;
    Color barva;
    int pocetCestujicich;

    public void vypisSe() {
        System.out.println("Auto "
                + znacka + ", "
                + barva + ", lidi "
                + pocetCestujicich);
    }

    public void nechejNastoupitCloveka() {
        if (pocetCestujicich < 5) {
            pocetCestujicich = pocetCestujicich + 1;
        } else {
            System.out.println("Vice cestujicich se do auta nevejde");
        }
    }

}
