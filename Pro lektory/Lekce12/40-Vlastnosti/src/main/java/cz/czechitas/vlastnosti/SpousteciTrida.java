package cz.czechitas.vlastnosti;

public class SpousteciTrida {

    public static void main(String[] args) {
        Karta karta1 = new Karta();
        karta1.setHodnota(7);
        karta1.setBarva(2);
        System.out.println(karta1);
        //  Karta[hodnota 7, barva listy]

        Karta karta2 = new Karta();
        karta2.setHodnota(13);
        karta2.setBarva(4);
        System.out.println(karta2);
        //  Karta[hodnota kral, barva zaludy]

        if (karta1.getBarva() == karta2.getBarva() || karta1.getHodnota() == karta2.getHodnota()) {
            System.out.println("Karty se daji polozit na sebe");
        } else {
            System.out.println("Karty se nedaji polozit na sebe");
        }

    }

}
