package cz.czechitas.recept.naradi;

import java.text.*;
import cz.czechitas.recept.suroviny.*;
import cz.czechitas.recept.suroviny.intf.*;

public class Miska {

    private String jmeno;

    private int pocetVajec = 0;
    private int pocetOvoce = 0;

    private int hmotnostMasla = 0;
    private NadobaSeSypkouSurovinou nadobaNaMaslo;
    private int hmotnostCukru = 0;
    private NadobaSeSypkouSurovinou nadobaNaCukr;
    private int hmotnostMouky = 0;
    private NadobaSeSypkouSurovinou nadobaNaMouku;
    private int hmotnostPraskuDoPeciva;
    private NadobaSeSypkouSurovinou nadobaNaPrasekDoPeciva;

    private boolean dobreZamichane = true;


    public Miska(String jmeno) {
        this.jmeno = jmeno;
    }


    public void nalozJedenKus(NadobaSKusovouSurovinou ceho) {
        if (ceho instanceof Vajicka) {
            boolean uspech = ceho.snizPocet();
            if (uspech) {
                pocetVajec++;
                dobreZamichane = false;
                System.out.println(jmeno + " si rozklepla a nalozila jedno vejce");
            } else {
                throw new IllegalStateException(jmeno + " si nemuze nalozit jeden kus z " + ceho.getJmeno() + ", protoze uz zadna " + ceho.getJmeno() + " nejsou k dispozici");
            }
        } else if (ceho instanceof Ovoce) {
            boolean uspech = ceho.snizPocet();
            if (uspech) {
                pocetOvoce = pocetOvoce + 1;
                dobreZamichane = false;
                System.out.println(jmeno + " si nalozila jeden kus " + ceho.getJmeno());
            } else {
                throw new IllegalStateException(jmeno + " si nemuze nalozit jeden kus " + ceho.getJmeno() + ", protoze uz zadne " + ceho.getJmeno() + " neni k dispozici");
            }
        } else {
            throw new UnsupportedOperationException("Neznama surovina");
        }
    }


    public void nalozCelyObsah(NadobaSeSypkouSurovinou zCeho) {
        if (zCeho instanceof Maslo) {
            if (zCeho.getHmotnost() <= 0) {
                throw new IllegalStateException(jmeno + " si nemuze nalozit zadne dalsi " + zCeho.getJmeno() + ", protoze uz zadne " + zCeho.getJmeno() + " neni k dispozici");
            }
            nadobaNaMaslo = zCeho;
            hmotnostMasla += nadobaNaMaslo.getHmotnost();
            nadobaNaMaslo.setHmotnost(0);
            dobreZamichane = false;
            System.out.println(jmeno + " si nalozila cele " + zCeho.getJmeno());
        } else if (zCeho instanceof Cukr) {
            if (zCeho.getHmotnost() <= 0) {
                throw new IllegalStateException(jmeno + " si nemuze nalozit zadny obsahu z " + zCeho.getJmeno() + ", protoze uz zadny " + zCeho.getJmeno() + " neni k dispozici");
            }
            nadobaNaCukr = zCeho;
            hmotnostCukru += nadobaNaCukr.getHmotnost();
            nadobaNaCukr.setHmotnost(0);
            dobreZamichane = false;
            System.out.println(jmeno + " si nalozila cely obsah z " + zCeho.getJmeno());
        } else if (zCeho instanceof PrasekDoPeciva) {
            if (zCeho.getHmotnost() <= 0) {
                throw new IllegalStateException(jmeno + " si nemuze nalozit zadny obsahu z " + zCeho.getJmeno() + ", protoze uz zadny " + zCeho.getJmeno() + " neni k dispozici");
            }
            nadobaNaPrasekDoPeciva = zCeho;
            hmotnostPraskuDoPeciva += nadobaNaPrasekDoPeciva.getHmotnost();
            nadobaNaPrasekDoPeciva.setHmotnost(0);
            dobreZamichane = false;
            System.out.println(jmeno + " si nalozila cely obsah z " + zCeho.getJmeno());
        } else if (zCeho instanceof Mouka) {
            if (zCeho.getHmotnost() <= 0) {
                throw new IllegalStateException(jmeno + " si nemuze nalozit zadnou mouku, protoze uz zadna neni k dispozici");
            }
            nadobaNaMouku = zCeho;
            hmotnostMouky += nadobaNaMouku.getHmotnost();
            nadobaNaMouku.setHmotnost(0);
            dobreZamichane = false;
            System.out.println(jmeno + " si nalozila cely obsah z " + zCeho.getJmeno());
        } else {
            throw new UnsupportedOperationException("Neznama surovina");
        }
    }


    public void nalozObsahMisky(Miska ktereMisky) {
        if (ktereMisky.getHmotnost() <= 0) {
            throw new IllegalStateException(jmeno + " si nemuze nalozit zadny obsahu z " + ktereMisky.getJmeno() + ", protoze " + ktereMisky.getJmeno() + " je prazdny");
        }
        pocetVajec += ktereMisky.pocetVajec;
        nadobaNaCukr = ktereMisky.nadobaNaCukr;
        nadobaNaMouku = ktereMisky.nadobaNaMouku;
        hmotnostCukru += ktereMisky.hmotnostCukru;
        hmotnostMouky += ktereMisky.hmotnostMouky;
        ktereMisky.pocetVajec = 0;
        ktereMisky.hmotnostCukru = 0;
        ktereMisky.hmotnostMouky = 0;
        ktereMisky.nadobaNaCukr = null;
        ktereMisky.nadobaNaMouku = null;
        dobreZamichane = dobreZamichane && ktereMisky.dobreZamichane;
        System.out.println(jmeno + " si nalozila cely obsah z " + ktereMisky.getJmeno());
    }


    public void nalozTrochu(NadobaSeSypkouSurovinou zCeho) {
        if (zCeho instanceof Mouka) {
            if (zCeho.getHmotnost() == 0) {
                throw new IllegalStateException(jmeno + " si nemuze nalozit zadny obsahu z " + zCeho.getJmeno() + ", protoze " + zCeho.getJmeno() + " je prazdny");
            } else {
                nadobaNaMouku = zCeho;
                int trocha = vygenerujTrochu(nadobaNaMouku.getHmotnost());
                hmotnostMouky += trocha;
                nadobaNaMouku.setHmotnost(nadobaNaMouku.getHmotnost() - trocha);
                dobreZamichane = false;
                System.out.println(MessageFormat.format("{0} si nalozila zhruba {1} {1,choice,0#gramu|1#gram|1<gramy|5#gramu} z {2}", jmeno, trocha, zCeho.getJmeno()));
            }
        } else {
            throw new UnsupportedOperationException("Neni vhodne nakladat trochu z " + zCeho + ". Nechejte nalozit cely obsah");
        }
    }


    public void vylozTrochu() {
        if (pocetVajec > 0) {
            throw new IllegalStateException(jmeno + " nemuze vylozit trochu rozkleplych vajicek");
        }
        if (hmotnostMasla == 0 && hmotnostCukru == 0 && hmotnostMouky != 0) {
            int trocha = vygenerujTrochu(hmotnostMouky);
            nadobaNaMouku.setHmotnost(nadobaNaMouku.getHmotnost() + trocha);
            hmotnostMouky = hmotnostMouky - trocha;
            System.out.println(jmeno + " vratila trochu mouky do " + nadobaNaMouku.getJmeno());
        } else if (hmotnostMasla == 0 && hmotnostCukru != 0 && hmotnostMouky == 0) {
            int trocha = vygenerujTrochu(hmotnostCukru);
            nadobaNaCukr.setHmotnost(nadobaNaCukr.getHmotnost() + trocha);
            hmotnostCukru = hmotnostCukru - trocha;
            System.out.println(jmeno + " vratila trochu cukru do " + nadobaNaCukr);
        } else if (hmotnostMasla != 0 && hmotnostCukru == 0 && hmotnostMouky == 0) {
            int trocha = vygenerujTrochu(hmotnostMasla);
            nadobaNaMaslo.setHmotnost(nadobaNaMaslo.getHmotnost() + trocha);
            hmotnostMasla = hmotnostMasla - trocha;
            System.out.println(jmeno + " vylozila trochu masla");
        } else {
            throw new IllegalStateException(jmeno + " nemuze vylozit trochu suroviny, protoze je v ni uz smichany obsah vic nez jedne suroviny");
        }
    }


    public static int vygenerujTrochu(int maximalniHmotnost) {
        int trochu;
        do {
            trochu = (int) (Math.random() * 25.0);
        } while (trochu == 0);
        if (trochu > maximalniHmotnost) {
            trochu = maximalniHmotnost;
        }
        return trochu;
    }


    public String getJmeno() {
        return jmeno;
    }


    public int getHmotnost() {
        return pocetVajec * 65 + pocetOvoce * 10 + hmotnostMasla + hmotnostCukru + hmotnostMouky + hmotnostPraskuDoPeciva;
    }


    public void setDobreZamichane() {
        dobreZamichane = true;
    }


    public boolean isDobreZamichane() {
        return dobreZamichane;
    }


    public int getPocetVajec() {
        return pocetVajec;
    }


    public int getHmotnostMasla() {
        return hmotnostMasla;
    }


    public int getPocetOvoce() {
        return pocetOvoce;
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


    public void setPocetVajec(int pocetVajec) {
        this.pocetVajec = pocetVajec;
    }


    public void setHmotnostMasla(int hmotnostMasla) {
        this.hmotnostMasla = hmotnostMasla;
    }


    public void setPocetOvoce(int pocetOvoce) {
        this.pocetOvoce = pocetOvoce;
    }


    public void setHmotnostCukru(int hmotnostCukru) {
        this.hmotnostCukru = hmotnostCukru;
    }


    public void setHmotnostMouky(int hmotnostMouky) {
        this.hmotnostMouky = hmotnostMouky;
    }


    public void setHmotnostPraskuDoPeciva(int hmotnostPraskuDoPeciva) {
        this.hmotnostPraskuDoPeciva = hmotnostPraskuDoPeciva;
    }
}
