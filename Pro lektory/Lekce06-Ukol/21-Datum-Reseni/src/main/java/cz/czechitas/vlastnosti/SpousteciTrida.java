package cz.czechitas.vlastnosti;

public class SpousteciTrida {

/*
    public static void main(String[] args) {
        Datum dnesek = new Datum();
        dnesek.rok = 2018;
        dnesek.mesic = 11;
        dnesek.den = 9;
        System.out.println(dnesek);

        Datum letosniVanoce = new Datum();
        letosniVanoce.rok = 2018;
        letosniVanoce.mesic = 12;
        letosniVanoce.den = 24;
        System.out.println(letosniVanoce);

        Datum letosniSilvestr = new Datum();
        letosniSilvestr.rok = 2018;
        letosniSilvestr.mesic = 12;
        letosniSilvestr.den = 31;
        System.out.println(letosniSilvestr);

        if (letosniVanoce.mesic == letosniSilvestr.mesic) {
            System.out.println("Vanoce a Silvestr jsou ve stejnem mesici.");
        } else {
            System.out.println("Vanoce a Silvestr NEJSOU ve stejnem mesici.");
        }

        System.out.println();

        Datum nesmyslnyMesic = new Datum();
        nesmyslnyMesic.rok = 2020;
        nesmyslnyMesic.mesic = 13;
        nesmyslnyMesic.den = 11;
        System.out.println(nesmyslnyMesic);

        Datum nesmyslnyMesic2 = new Datum();
        nesmyslnyMesic2.rok = 2021;
        nesmyslnyMesic2.mesic = -1;
        nesmyslnyMesic2.den = 5;
        System.out.println(nesmyslnyMesic2);

        Datum nesmyslnyDen = new Datum();
        nesmyslnyDen.rok = 2022;
        nesmyslnyDen.mesic = 12;
        nesmyslnyDen.den = 40;
        System.out.println(nesmyslnyDen);

        Datum nesmyslnyDen2 = new Datum();
        nesmyslnyDen2.rok = 2023;
        nesmyslnyDen2.mesic = 3;
        nesmyslnyDen2.den = -2;
        System.out.println(nesmyslnyDen2);
    }
*/


    public static void main(String[] args) {
        Datum dnesek = new Datum();
        dnesek.setRok(2018);
        dnesek.setMesic(11);
        dnesek.setDen(9);
        System.out.println(dnesek);
        System.out.println("Mesic: " + dnesek.getNazevMesice());

        Datum letosniVanoce = new Datum();
        letosniVanoce.setRok(2018);
        letosniVanoce.setMesic(12);
        letosniVanoce.setDen(24);
        System.out.println(letosniVanoce);

        Datum letosniSilvestr = new Datum();
        letosniSilvestr.setRok(2018);
        letosniSilvestr.setMesic(12);
        letosniSilvestr.setDen(31);
        System.out.println(letosniSilvestr);

        if (letosniVanoce.getMesic() == letosniSilvestr.getMesic()) {
            System.out.println("Vanoce a Silvestr jsou ve stejnem mesici.");
        } else {
            System.out.println("Vanoce a Silvestr NEJSOU ve stejnem mesici.");
        }

        System.out.println();

        Datum nesmyslnyMesic = new Datum();
        nesmyslnyMesic.setRok(2020);
        nesmyslnyMesic.setMesic(13);
        nesmyslnyMesic.setDen(11);
        System.out.println(nesmyslnyMesic);

        Datum nesmyslnyMesic2 = new Datum();
        nesmyslnyMesic2.setRok(2021);
        nesmyslnyMesic2.setMesic(-1);
        nesmyslnyMesic2.setDen(5);
        System.out.println(nesmyslnyMesic2);

        Datum nesmyslnyDen = new Datum();
        nesmyslnyDen.setRok(2022);
        nesmyslnyDen.setMesic(12);
        nesmyslnyDen.setDen(40);
        System.out.println(nesmyslnyDen);

        Datum nesmyslnyDen2 = new Datum();
        nesmyslnyDen2.setRok(2023);
        nesmyslnyDen2.setMesic(3);
        nesmyslnyDen2.setDen(-2);
        System.out.println(nesmyslnyDen2);
    }

}
