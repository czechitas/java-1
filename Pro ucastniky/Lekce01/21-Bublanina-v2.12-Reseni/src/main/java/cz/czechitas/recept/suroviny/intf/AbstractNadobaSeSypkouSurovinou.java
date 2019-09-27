package cz.czechitas.recept.suroviny.intf;

public abstract class AbstractNadobaSeSypkouSurovinou implements NadobaSeSypkouSurovinou {

    private String jmeno;
    private int hmotnost;


    public AbstractNadobaSeSypkouSurovinou(String jmeno, int hmotnost) {
        this.jmeno = jmeno;
        this.hmotnost = hmotnost;
    }


    @Override
    public String getJmeno() {
        return jmeno;
    }


    @Override
    public int getHmotnost() {
        return hmotnost;
    }


    @Override
    public void setHmotnost(int hmotnost) {
        this.hmotnost = hmotnost;
    }
}
