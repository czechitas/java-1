package cz.czechitas.banka;

public class BeznyUcet {

    private double zustatek;
    private double limitPrecerpani;

    public BeznyUcet(double pocatecniCastka) {
        zustatek = pocatecniCastka;
    }

    public BeznyUcet(double pocatecniCastka, double pocatecniLimitPrecerpani) {
        zustatek = pocatecniCastka;
        limitPrecerpani = pocatecniLimitPrecerpani;
    }

    public double getZustatek() {
        return zustatek;
    }

    public double getLimitPrecerpani() {
        return limitPrecerpani;
    }

    public double getPouzitelnyZustatek() {
        return zustatek + limitPrecerpani;
    }

    public boolean vlozPenize(double castka) {
        if (castka < 0.0) {
            System.out.println("Nelze vlozit negativni castku (" + castka + ")");
            return false;
        }
        zustatek = zustatek + castka;
        return true;
    }

    public boolean vyberPenize(double castka) {
        if (castka < 0.0) {
            System.out.println("Nelze vybrat negativni castku (" + castka + ")");
            return false;
        }
        if (getPouzitelnyZustatek() < castka) {
            return false;
        }
        zustatek = zustatek - castka;
        return true;
    }

}
