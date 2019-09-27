package cz.czechitas.pexeso;

public class Karticka {

    int hodnota;
    int x;
    int y;
    String stav;

    public boolean isOdebrana() {
        return stav == "odebrana";
    }

    public boolean isRubemNahoru() {
        return stav == "rub";
    }

    public boolean isLicemNahoru() {
        return stav == "lic";
    }

    public void otoc() {
        if (stav == "rub") {
            stav = "lic";
        } else if (stav == "lic") {
            stav = "rub";
        }
    }

    public void odeber() {
        stav = "odebrana";
    }

    public String toString() {
        return "Karticka " + hodnota + ", " + stav;
    }
}
