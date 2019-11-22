package cz.czechitas.vlastnosti;

public class Karta {

    private int hodnota;
    private int barva;

    public void setHodnota(int novaHodnota) {
        if (novaHodnota < 7 || novaHodnota > 14) {
            System.out.println("Neplatna hodnota " + novaHodnota);
            return;
        }
        hodnota = novaHodnota;
    }

    public void setBarva(int newValue) {
        if (newValue < 1 || newValue > 4) {
            System.out.println("Neplatna barva karty " + newValue);
            return;
        }
        barva = newValue;
    }

    public int getHodnota() {
        return hodnota;
    }

    public int getBarva() {
        return barva;
    }

    public String toString() {
        String vysledek = "Karta[hodnota ";
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
        vysledek = vysledek + "]";
        return vysledek;
    }

}
