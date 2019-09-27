package cz.czechitas.sport;

public class Hrac {

    private String jmeno;
    private int pocetBodu;

    public Hrac(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getPocetBodu() {
        return pocetBodu;
    }

    public void pridejBody(int kolik) {
        pocetBodu = pocetBodu + kolik;
    }

    @Override
    public String toString() {
        return "Hrac " +
                jmeno +
                ", pocet bodu " + pocetBodu;
    }
}
