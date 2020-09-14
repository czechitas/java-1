package cz.czechitas.automobil;

public class Automobil {

    Motor motor;
    PalivovaNadrz nadrz;

    public String toString() {
        String vysledek;
        vysledek = "Automobil [";
        if (motor != null) {
            vysledek += motor.toString();
            vysledek += ". ";
        }
        if (nadrz != null) {
            vysledek += nadrz.toString();
        }
        vysledek += "]";
        return vysledek;
    }
}
