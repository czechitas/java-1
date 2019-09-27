package cz.czechitas.recept.naradi;

public class ElektrickaTrouba {

    private static ThreadLocal<ElektrickaTrouba> predehrivanaTrouba = new ThreadLocal<>();

    private String jmeno;
    private int teplota;
    private boolean jePredehrata;
    private PlechNaPeceni plechUvnitr;
    private int dobaPeceni;

    public ElektrickaTrouba(String jmeno) {
        this.jmeno = jmeno;
    }


    public void zapniSe(int naJakouTeplotu) {
        System.out.println(jmeno + " se zapnula na teplotu " + naJakouTeplotu);
        teplota = naJakouTeplotu;
        predehrivanaTrouba.set(this);
    }


    public void vlozSiDovnitr(PlechNaPeceni co) {
        if (co.getHmotnostCukru() < 180) {
            throw new IllegalStateException("Testo na plechu nema dostatek cukru (pouze " + co.getHmotnostCukru() + " g)");
        }
        if (co.getHmotnostCukru() > 220) {
            throw new IllegalStateException("Testo na plechu ma prebytek cukru (" + co.getHmotnostCukru() + " g)");
        }
        if (co.getHmotnostMouky() < 230) {
            throw new IllegalStateException("Testo na plechu nema dostatek mouky (pouze " + co.getHmotnostMouky() + " g)");
        }
        if (co.getHmotnostMouky() > 270) {
            throw new IllegalStateException("Testo na plechu ma prebytek mouky (" + co.getHmotnostMouky() + " g)");
        }
        if (co.getHmotnostPraskuDoPeciva() < 25) {
            throw new IllegalStateException("Testo na plechu nema dostatek prasku do peciva (pouze " + co.getHmotnostPraskuDoPeciva() + " g)");
        }
        if (co.getHmotnostPraskuDoPeciva() > 25) {
            throw new IllegalStateException("Testo na plechu ma prebytek prasku do peciva (" + co.getHmotnostPraskuDoPeciva() + " g)");
        }
        if (co.getHmotnostMasla() < 125) {
            throw new IllegalStateException("Testo na plechu nema dostatek masla (" + co.getHmotnostMasla() + " g)");
        }
        if (co.getHmotnostMasla() > 125) {
            throw new IllegalStateException("Testo na plechu ma prebytek masla (" + co.getHmotnostMasla() + " g)");
        }
        if (co.getPocetOvoce() < 40) {
            throw new IllegalStateException("Testo na plechu nema dostatek ovoce (" + co.getPocetOvoce() + " ks)");
        }
        if (co.getPocetOvoce() > 80) {
            throw new IllegalStateException("Testo na plechu ma prebytek ovoce (" + co.getPocetOvoce() + " ks)");
        }
        if (co.getPocetVajec() < 4) {
            throw new IllegalStateException("Testo na plechu nema dostatek vajec (" + co.getPocetVajec() + " ks)");
        }
        if (co.getPocetVajec() > 4) {
            throw new IllegalStateException("Testo na plechu ma prebytek vajec (" + co.getPocetVajec() + " ks)");
        }
        plechUvnitr = co;
        dobaPeceni = 0;
        System.out.println(jmeno + " si vlozila dovnitr " + co.getJmeno());
    }


    public void nechejPect(int kolikMinut) {
        if (teplota != 180) {
            throw new IllegalStateException(jmeno + " nema spravne nastavenu teplotu");
        }
        if (plechUvnitr == null) {
            System.out.println(jmeno + " se nahriva " + kolikMinut + " minut");
            jePredehrata = true;
        } else {
            if (!jePredehrata) {
                throw new IllegalStateException("Bublanina nebude upecena rovnomerne, protoze " + jmeno + " neni predehrata");
            }
            System.out.println(jmeno + " pece " + kolikMinut + " minut testo na plechu");
            dobaPeceni = dobaPeceni + kolikMinut;
        }
    }


    public void vypniSe() {
        if (dobaPeceni < 25) {
            throw new IllegalStateException(jmeno + " byla vypnuta predcasne, bublanina neni dopecena");
        }
        if (dobaPeceni > 25) {
            throw new IllegalStateException(jmeno + " byla vypnuta moc pozde, bublanina se pripalila");
        }
        teplota = 0;
        System.out.println(jmeno + " se vypnula");
    }


    public void vyndejObsahVen() {
        if (dobaPeceni < 25) {
            throw new IllegalStateException(plechUvnitr.getJmeno() + " byl vyndan predcasne, bublanina neni dopecena");
        }
        if (dobaPeceni > 25) {
            throw new IllegalStateException(plechUvnitr.getJmeno() + " byl vyndan moc pozde, bublanina se pripalila");
        }
        if (teplota > 0) {
            System.out.println("POZOR! " + jmeno + " porad pece, nezapomente ji vypnout");
        }
        System.out.println(plechUvnitr.getJmeno() + " byl vyndan a bublanina je hotova :-)");
    }

    //-------------------------------------------------------------------------

    public static ElektrickaTrouba getPredehrivanaTrouba() {
        return predehrivanaTrouba.get();
    }


    public boolean isPredehrata() {
        return jePredehrata;
    }


    public void setPredehrata(boolean jePredehrata) {
        this.jePredehrata = jePredehrata;
    }
}
