package cz.czechitas.vlastnosti;

import java.time.*;

public class UdalostVKalendari {

    private String popis;
    private LocalTime zacatek;
    private LocalTime konec;

    public String getPopis() {
        return popis;
    }

    public void setPopis(String newValue) {
        popis = newValue;
    }

    public LocalTime getZacatek() {
        return zacatek;
    }

    public LocalTime getKonec() {
        return konec;
    }

    public void setZacatek(LocalTime newValue) {
        zacatek = newValue;
    }

    public void setKonec(LocalTime newValue) {
        konec = newValue;
    }

    public Duration getDelka() {
        Duration delka = Duration.between(zacatek, konec);
        return delka;
    }

}
