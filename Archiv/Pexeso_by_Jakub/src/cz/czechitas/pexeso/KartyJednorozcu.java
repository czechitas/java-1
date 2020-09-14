package cz.czechitas.pexeso;

import java.util.*;
import javax.swing.*;

public class KartyJednorozcu implements BalicekKaret {

    private List<JKarta> karty;
    private Pomocnik honzik;

    public static final int POCET_OBRAZKU = 80;

    public KartyJednorozcu(int pocetParu) {
        honzik = new Pomocnik();
        karty = vygenerujSeznam(pocetParu);
    }

    private List<JKarta> vygenerujSeznam(int pocetParu) {
        List<JKarta> karty = new ArrayList<>();

        for (int i = 0; i < pocetParu; i ++) {
            int cisloObrazku = nahodneCisloObrazku(pocetParu, i);
            JKarta prvni = vytvorKartu(cisloObrazku);
            JKarta druha = vytvorKartu(cisloObrazku);

            karty.add(prvni);
            karty.add(druha);
        }

        Collections.shuffle(karty);

        return karty;
    }

    private int nahodneCisloObrazku(int pocetParu, int posun) {
        Random random = new Random();
        return random.nextInt(POCET_OBRAZKU - pocetParu) + posun;
    }

    private JKarta vytvorKartu(int cisloObrazku) {
        ImageIcon lic = honzik.nactiIkonku("/cz/czechitas/pexeso/unicorns/" + cisloObrazku + ".jpg");
        ImageIcon rub = honzik.nactiIkonku("/cz/czechitas/pexeso/unicorns/logo.jpg");

        JKarta karta = new JKarta(cisloObrazku, lic, rub);
        karta.otocRubemNahoru();

        return karta;
    }

    public List<JKarta> getKarty(){
        return karty;
    }

}
