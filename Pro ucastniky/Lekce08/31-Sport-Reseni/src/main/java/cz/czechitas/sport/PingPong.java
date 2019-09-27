package cz.czechitas.sport;

public class PingPong {

    private Hrac hrac1;
    private Hrac hrac2;
    private boolean probiha;

    public PingPong(Hrac hrac1, Hrac hrac2) {
        this.hrac1 = hrac1;
        this.hrac2 = hrac2;
        this.probiha = true;
    }

    public void pridejBodHraci1() {
        if (!probiha) {
            return;
        }
        hrac1.pridejBody(1);
        if (hrac1.getPocetBodu() >= 11) {
            probiha = false;
        }
    }

    public void pridejBodHraci2() {
        if (!probiha) {
            return;
        }
        hrac2.pridejBody(1);
        if (hrac2.getPocetBodu() >= 11) {
            probiha = false;
        }
    }

    public boolean isProbiha() {
        return probiha;
    }

    public Hrac vyhravajiciHrac() {
        if (hrac1.getPocetBodu() >= 11) {
            return hrac1;
        } else if (hrac2.getPocetBodu() >= 11) {
            return hrac2;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (probiha) {
            return "PingPong probiha. " +
                    "Hrac1: " + hrac1 +
                    ", hrac2: " + hrac2;
        } else {
            return "PingPong vyhral hrac "
                    + vyhravajiciHrac();
        }

    }
}
