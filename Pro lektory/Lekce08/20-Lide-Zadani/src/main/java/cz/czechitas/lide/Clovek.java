package cz.czechitas.lide;

import java.awt.*;

public class Clovek {

    private String krestniJmeno;
    private String prijmeni;
    private int vek;
    private Color barvaOci;

    public String getKrestniJmeno() {
        return krestniJmeno;
    }

    public void setKrestniJmeno(String newValue) {
        krestniJmeno = newValue;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String newValue) {
        prijmeni = newValue;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int newValue) {
        vek = newValue;
    }

    public Color getBarvaOci() {
        return barvaOci;
    }

    public void setBarvaOci(Color newValue) {
        barvaOci = newValue;
    }

    public void zestarniORok() {
        vek = vek + 1;
    }

    public String toString() {
        return "Clovek "
                + krestniJmeno
                + " " + prijmeni
                + ", vek " + vek
                + ", oci " + barvaOci.toString();
    }

}
