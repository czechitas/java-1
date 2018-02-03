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

        // TODO: Sem napiste recept na bublaninu
        cervenaMiska.nalozJedenKus(vajicka);
    }

}
