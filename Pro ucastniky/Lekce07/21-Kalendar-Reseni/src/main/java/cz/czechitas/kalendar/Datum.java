package cz.czechitas.kalendar;

public class Datum {

    int rok;
    int mesic;
    int den;

    public int getPocetDnuVMesici() {
        int pocetDnu;
        if (mesic == 1 || mesic == 3 || mesic == 5 || mesic == 7 || mesic == 8 || mesic == 10 || mesic == 12) {
            pocetDnu = 31;
        } else if (mesic == 4 || mesic == 6 || mesic == 9 || mesic == 11) {
            pocetDnu = 30;
        } else if (mesic == 2 && isPrestupnyRok()) {
            pocetDnu = 29;
        } else if (mesic == 2 && !isPrestupnyRok()) {
            pocetDnu = 28;
        } else {
            throw new IllegalArgumentException("Neplatna hodnota mesice");
        }
        return pocetDnu;
    }

    public boolean isPrestupnyRok() {
        if (rok % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return den + ". " + mesic + ". " + rok;
    }

}
