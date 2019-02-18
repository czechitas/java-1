package cz.czechitas.kalendar;

public class SpousteciTrida {

    public static void main(String[] args) {
        Datum dnesek = new Datum();
        dnesek.rok = 2018;
        dnesek.mesic = 11;
        dnesek.den = 15;

        System.out.println(dnesek);
        System.out.println(dnesek.getPocetDnuVMesici());
    }

}
