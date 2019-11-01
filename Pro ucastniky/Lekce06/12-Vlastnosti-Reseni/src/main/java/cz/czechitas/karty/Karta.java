package cz.czechitas.karty;

import java.util.*;

public class Karta {

//    private static final List<String> MOZNE_BARVY =
//            Arrays.asList("listy", "krize", "srdce", "kary");

    private int hodnota;
    private String barva;

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int nova) {
        if (nova >= 2 && nova <= 14) {
            hodnota = nova;
        }
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String nova) {
        if (nova.equals("listy") || nova.equals("krize") || nova.equals("srdce") || nova.equals("kary")) {
            barva = nova;
        }
    }

//    public void setBarva(String nova) {
//        if (MOZNE_BARVY.contains(nova)) {
//            barva = nova;
//        }
//    }

    public String toString() {
        return "Karta " + hodnota + " barvy " + barva;
    }

}
