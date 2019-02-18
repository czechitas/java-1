package cz.czechitas.recept;

import cz.czechitas.recept.naradi.*;
import cz.czechitas.recept.suroviny.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Miska cervenaMiska = new Miska("cervenaMiska");
        Miska zlutaMiska = new Miska("zlutaMiska");
        Mixer mixer = new Mixer("mixer");
        Vaha kuchynskaVaha = new Vaha("vaha");
        PlechNaPeceni plech = new PlechNaPeceni("plech");
        ElektrickaTrouba trouba = new ElektrickaTrouba("trouba");
        Vajicka vajicka = new Vajicka("vajicka");
        Ovoce ovoce = new Ovoce("ovoce");
        Maslo maslo125g = new Maslo("maslo125g");
        Mouka pytlikMouky = new Mouka("pytlikMouky");
        Cukr pytlikCukru = new Cukr("pytlikCukru");
        PrasekDoPeciva prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

        //---------------------------------------------------------------------

        for (int i = 0; i < 4; i++) {
            cervenaMiska.nalozJedenKus(vajicka);
        }

        cervenaMiska.nalozCelyObsah(pytlikCukru);
        mixer.zamichej(cervenaMiska);

        // Pridej 125 g masla
        cervenaMiska.nalozCelyObsah(maslo125g);
        mixer.zamichej(cervenaMiska);

        kuchynskaVaha.vynulujSeS(zlutaMiska);
        while (kuchynskaVaha.zjistiHmotnost(zlutaMiska) != 250) {
            if (kuchynskaVaha.zjistiHmotnost(zlutaMiska) > 250) {
                zlutaMiska.vylozTrochu();
            } else {
                zlutaMiska.nalozTrochu(pytlikMouky);
            }
        }
        cervenaMiska.nalozObsahMisky(zlutaMiska);

        cervenaMiska.nalozCelyObsah(prasekDoPeciva);
        mixer.zamichej(cervenaMiska);

        plech.preberObsah(cervenaMiska);
        for (int i = 0; i < 50; i = i + 1) {
            plech.posypKusem(ovoce);
        }

        trouba.zapniSe(180);
        trouba.nechejPect(5);
        trouba.vlozSiDovnitr(plech);
        trouba.nechejPect(25);
        trouba.vypniSe();
        trouba.vyndejObsahVen();
    }

}
