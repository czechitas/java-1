package cz.czechitas.automobil;

public class SpousteciTrida {

    public static void main(String[] args) {
        Automobil modreAuto;
        modreAuto = new Automobil();
        System.out.println(modreAuto.toString());
        modreAuto.nastartujSe();
        System.out.println(modreAuto.toString());

        Motor osmivalcovyMotor = new Motor();
        osmivalcovyMotor.prumernaSpotreba = 5.0;

        PalivovaNadrz malaNadrz = new PalivovaNadrz();
        malaNadrz.maxKapacita = 55.0;

        Automobil cerveneAuto;
        cerveneAuto = new Automobil();
        cerveneAuto.motor = osmivalcovyMotor;
        cerveneAuto.nastartujSe();
        System.out.println(cerveneAuto.toString());

        cerveneAuto.nadrz = malaNadrz;
        cerveneAuto.nastartujSe();
        System.out.println(cerveneAuto.toString());

        cerveneAuto.vypniSe();
        System.out.println(cerveneAuto.toString());

        cerveneAuto.nastartujSe();

        cerveneAuto.natankuj(33.0);
        cerveneAuto.nastartujSe();
        System.out.println(cerveneAuto.toString());

        cerveneAuto.vypniSe();
        cerveneAuto.natankuj(30.0);
        System.out.println(cerveneAuto.toString());

        cerveneAuto.nastartujSe();
        cerveneAuto.natankuj(20.0);

        cerveneAuto.odjedVzdalenost(500.0);
        System.out.println(cerveneAuto.toString());

        cerveneAuto.odjedVzdalenost(100.0);
        System.out.println(cerveneAuto.toString());

        cerveneAuto.odjedVzdalenost(100.0);
        System.out.println(cerveneAuto.toString());
    }
}
