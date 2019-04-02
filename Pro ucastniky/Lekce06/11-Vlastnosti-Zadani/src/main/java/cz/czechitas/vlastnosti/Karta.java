package cz.czechitas.vlastnosti;

public class Karta {

    int hodnota;
    int barva;

    public String toString() {
        String vysledek = "Karta hodnota ";
        if (hodnota >= 7 && hodnota <= 10) {
            vysledek = vysledek + hodnota;
        } else if (hodnota == 11) {
            vysledek = vysledek + "spodek";
        } else if (hodnota == 12) {
            vysledek = vysledek + "svrsek";
        } else if (hodnota == 13) {
            vysledek = vysledek + "kral";
        } else if (hodnota == 14) {
            vysledek = vysledek + "eso";
        } else {
            vysledek = vysledek + "neznama";
        }

        vysledek = vysledek + ", barva ";
        if (barva == 1) {
            vysledek = vysledek + "kule";
        } else if (barva == 2) {
            vysledek = vysledek + "listy";
        } else if (barva == 3) {
            vysledek = vysledek + "srdce";
        } else if (barva == 4) {
            vysledek = vysledek + "zaludy";
        } else {
            vysledek = vysledek + "neznama";
        }
        return vysledek;
    }

}
