package cz.czechitas.karty;

public class SpousteciTrida {

    public static void main(String[] args) {
        Karta mojeTajneEso = new Karta();
//        mojeTajneEso.hodnota = 14;
        mojeTajneEso.setHodnota(14);
        mojeTajneEso.setBarva("srdce");
        mojeTajneEso.setBarva("brokolice");     // Nic neudela, protoze setter "brokolici" zavrhne
        System.out.println(mojeTajneEso.toString());

        KartickaPexesa pex1 = new KartickaPexesa();
        pex1.setId(0);
        pex1.setId(-23);     // Nic neudela, protoze setter -23 zavrhne

        KartickaPexesa pex2 = new KartickaPexesa();
        pex2.setId(1);

        if (pex1.equals(pex2)) {
            System.out.println(pex1 + " a " + pex2 + " jsou dvojice");
        } else {
            System.out.println(pex1 + " a " + pex2 + " nejsou dvojice");
        }
    }

}
