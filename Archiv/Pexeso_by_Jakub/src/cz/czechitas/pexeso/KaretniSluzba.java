package cz.czechitas.pexeso;

import java.util.*;

public class KaretniSluzba {
    private Pomocnik honzik;
    private BalicekKaret seznam;

    public KaretniSluzba(BalicekKaret seznam) {
        this.seznam = seznam;
        honzik = new Pomocnik();
    }

    public boolean zbyvajiViditelneKarty() {
        for (JKarta karta : seznam.getKarty()) {
            if (karta.isVisible()) {
                return true;
            }
        }
        return false;
    }


    public void otocKartyRubemNahoru() {
        for (JKarta karta : seznam.getKarty()) {
            karta.otocRubemNahoru();
        }
    }

    public List<JKarta> getKarty() {
        return seznam.getKarty();
    }

    public void nechZmizetKartyPokudJsouStejne(JKarta prvni, JKarta druha) {
        if (prvni.equals(druha)) {
            prvni.nechZmizet();
            druha.nechZmizet();
        }
    }
}
