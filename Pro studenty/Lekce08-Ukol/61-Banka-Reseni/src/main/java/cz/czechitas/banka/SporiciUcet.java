package cz.czechitas.banka;

public class SporiciUcet {

    private double zustatek;
    private double urokovaMira;

    public SporiciUcet(double pocatecniCastka) {
        zustatek = pocatecniCastka;
    }

    public SporiciUcet(double pocatecniCastka, double pocatecniUrokovaMira) {
        zustatek = pocatecniCastka;
        urokovaMira = pocatecniUrokovaMira;
    }

    public double getZustatek() {
        return zustatek;
    }

    public double getUrokovaMira() {
        return urokovaMira;
    }

    public boolean vlozPenize(double castka) {
        if (castka < 0.0) {
            System.out.println("Nelze vlozit negativni castku (" + castka + ")");
            return false;
        }
        this.zustatek = this.zustatek + castka;
        return true;
    }

    public boolean vyberPenize(double castka) {
        if (castka < 0.0) {
            System.out.println("Nelze vybrat negativni castku (" + castka + ")");
            return false;
        }
        if (zustatek < castka) {
            return false;
        }
        zustatek = zustatek - castka;
        return true;
    }

    public void vypocitejRocniUrokAVlozHoNaUcet() {
        vlozPenize(urokovaMira * zustatek);
    }

}
