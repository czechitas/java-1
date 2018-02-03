package cz.czechitas.recept.naradi;

import cz.czechitas.recept.suroviny.*;
import cz.czechitas.recept.suroviny.intf.*;

public class PlechNaPeceni {

    private String jmeno;

    private int pocetVajec = 0;
    private int hmotnostMasla = 0;
    private int pocetOvoce = 0;

    private int hmotnostCukru = 0;
    private int hmotnostMouky = 0;
    private int hmotnostPraskuDoPeciva;


    public PlechNaPeceni(String jmeno) {
        this.jmeno = jmeno;
    }


    public void preberObsah(Miska ktereMisky) {
        if (!ktereMisky.isDobreZamichane()) {
            throw new IllegalStateException("Na " + jmeno + " nelze vlozit obsah misky " + ktereMisky.getJmeno() + ", protoze neni dobre zamichana");
        }
        pocetVajec = ktereMisky.getPocetVajec();
        pocetOvoce = ktereMisky.getPocetOvoce();
        hmotnostMasla = ktereMisky.getHmotnostMasla();
        hmotnostCukru = ktereMisky.getHmotnostCukru();
        hmotnostMouky = ktereMisky.getHmotnostMouky();
        hmotnostPraskuDoPeciva = ktereMisky.getHmotnostPraskuDoPeciva();
        ktereMisky.setPocetVajec(0);
        ktereMisky.setPocetOvoce(0);
        ktereMisky.setHmotnostMasla(0);
        ktereMisky.setHmotnostCukru(0);
        ktereMisky.setHmotnostMouky(0);
        ktereMisky.setHmotnostPraskuDoPeciva(0);
        System.out.println(jmeno + " si prebral cely obsah misky " + ktereMisky.getJmeno());

        ElektrickaTrouba trouba = ElektrickaTrouba.getPredehrivanaTrouba();
        if (trouba != null) {
            trouba.setPredehrata(true);
        }
    }


    public void posypKusem(NadobaSKusovouSurovinou ceho) {
        if (!(ceho instanceof Ovoce)) {
            throw new IllegalStateException(jmeno + " si nemuze nalozit jeden kus z " + ceho.getJmeno() + ", protoze by obsah nebyl zamichany");
        }

        boolean uspech = ceho.snizPocet();
        if (uspech) {
            pocetOvoce = pocetOvoce + 1;
            System.out.println(jmeno + " si nalozil jeden kus " + ceho.getJmeno());
        } else {
            System.out.println(jmeno + " si nenalozil zadne " + ceho.getJmeno() + ", protoze uz zadne neni k dispozici");
        }
    }


    public String getJmeno() {
        return jmeno;
    }


    public int getPocetVajec() {
        return pocetVajec;
    }


    public int getPocetOvoce() {
        return pocetOvoce;
    }


    public int getHmotnostMasla() {
        return hmotnostMasla;
    }


    public int getHmotnostCukru() {
        return hmotnostCukru;
    }


    public int getHmotnostMouky() {
        return hmotnostMouky;
    }


    public int getHmotnostPraskuDoPeciva() {
        return hmotnostPraskuDoPeciva;
    }
}
