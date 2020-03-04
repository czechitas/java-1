package cz.czechitas.recept.suroviny.intf;

public abstract class AbstractNadobaSKusovouSurovinou implements NadobaSKusovouSurovinou {

    protected String jmeno;
    protected int pocet;


    public AbstractNadobaSKusovouSurovinou(String jmeno, int pocetKusu) {
        this.jmeno = jmeno;
        this.pocet = pocetKusu;
    }


    @Override
    public String getJmeno() {
        return jmeno;
    }


    @Override
    public boolean snizPocet() {
        if (pocet <= 0) {
            return false;
        }
        pocet--;
        return true;
    }

}
