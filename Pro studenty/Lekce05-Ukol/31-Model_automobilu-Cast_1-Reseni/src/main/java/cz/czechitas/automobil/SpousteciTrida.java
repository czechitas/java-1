package cz.czechitas.automobil;

public class SpousteciTrida {

    public static void main(String[] args) {
        Automobil modreAuto;
        modreAuto = new Automobil();
        System.out.println(modreAuto.toString());

        Motor osmivalcovyMotor = new Motor();
        osmivalcovyMotor.prumernaSpotreba = 5.0;

        PalivovaNadrz malaNadrz = new PalivovaNadrz();
        malaNadrz.maxKapacita = 55.0;

        Automobil cerveneAuto;
        cerveneAuto = new Automobil();
        cerveneAuto.motor = osmivalcovyMotor;
        cerveneAuto.nadrz = malaNadrz;
        System.out.println(cerveneAuto.toString());
    }
}
