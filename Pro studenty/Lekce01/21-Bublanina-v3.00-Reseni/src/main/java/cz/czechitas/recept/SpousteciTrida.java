package cz.czechitas.recept;

import cz.czechitas.recept.naradi.*;
import cz.czechitas.recept.suroviny.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Miska cervenaMiska;
        Miska zlutaMiska;
        Mixer mixer;
        Vaha kuchynskaVaha;
        PlechNaPeceni plech;
        ElektrickaTrouba trouba;
        Vajicka vajicka;

        Ovoce ovoce;
        Maslo maslo125g;
        Mouka pytlikMouky;
        Cukr pytlikCukru;
        PrasekDoPeciva prasekDoPeciva;

        cervenaMiska = new Miska("cervenaMiska");
        zlutaMiska = new Miska("zlutaMiska");
        mixer = new Mixer("mixer");
        kuchynskaVaha = new Vaha("vaha");
        plech = new PlechNaPeceni("plech");
        trouba = new ElektrickaTrouba("trouba");

        vajicka = new Vajicka("vajicka");
        ovoce = new Ovoce("ovoce");
        maslo125g = new Maslo("maslo125g");
        pytlikMouky = new Mouka("pytlikMouky");
        pytlikCukru = new Cukr("pytlikCukru");
        prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

        //---------------------------------------------------------------------

        for (int i = 0; i < 4; i++) {
            cervenaMiska.nalozSiJedenKus(vajicka);
        }

        cervenaMiska.nalozSiCelyObsah(pytlikCukru);
        mixer.zamichej(cervenaMiska);

        // Pridej 125 g masla
        cervenaMiska.nalozSiCelyObsah(maslo125g);
        mixer.zamichej(cervenaMiska);

        kuchynskaVaha.vynulujSeS(zlutaMiska);
        while (kuchynskaVaha.zjistiHmotnost(zlutaMiska) != 250) {
            if (kuchynskaVaha.zjistiHmotnost(zlutaMiska) > 250) {
                zlutaMiska.vylozSiTrochu();
            } else {
                zlutaMiska.nalozSiTrochu(pytlikMouky);
            }
        }
        cervenaMiska.nalozSiObsahJineMisky(zlutaMiska);

        cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);
        mixer.zamichej(cervenaMiska);

        plech.preberSiObsah(cervenaMiska);
        for (int i = 0; i < 50; i = i + 1) {
            plech.posypSeKusem(ovoce);
        }

        trouba.zapniSe(180);
        trouba.nechejPect(5);
        trouba.vlozSiDovnitr(plech);
        trouba.nechejPect(25);
        trouba.vypniSe();
        trouba.vyndejObsahVen();
    }

}
