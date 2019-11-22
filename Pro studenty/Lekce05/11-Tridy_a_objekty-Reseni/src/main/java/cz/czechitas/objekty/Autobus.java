package cz.czechitas.objekty;

import java.awt.*;

public class Autobus {

    int cisloLinky;
    Color barva;
    int poradoveCislo;
    int pocetCestujicich;

    public String toString() {
        return "Autobusik " + cisloLinky + "-" + poradoveCislo
                + ", cestujicich: " + pocetCestujicich;
    }

    public void nechejNastoupit() {
        pocetCestujicich = pocetCestujicich + 1;
    }

    public void nechejVystoupit() {
        if (pocetCestujicich > 0) {
            pocetCestujicich--;
        }
    }

    public void nechejVystoupitVsechny() {
        while (pocetCestujicich > 0) {
            nechejVystoupit();
        }
    }
}
