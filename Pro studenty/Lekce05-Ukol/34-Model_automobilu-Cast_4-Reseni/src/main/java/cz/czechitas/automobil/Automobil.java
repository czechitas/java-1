package cz.czechitas.automobil;

public class Automobil {

    boolean jeNastartovany;
    Motor motor;
    PalivovaNadrz nadrz;

    public String toString() {
        String vysledek;
        if (jeNastartovany) {
            vysledek = "Nastartovany automobil [";
        } else {
            vysledek = "Automobil [";
        }
        if (motor != null) {
            vysledek += motor.toString();
            vysledek += ". ";
        }
        if (nadrz != null) {
            vysledek += nadrz.toString();
        }
        vysledek += "]";
        return vysledek;
    }

    public void nastartujSe() {
        if (jeNastartovany) {
            System.out.println("Automobil je jiz nastartovany. Nelze ho znovu nastartovat.");
        } else if (motor == null) {
            System.out.println("Automobilu chybi motor. Nelze ho nastartovat.");
        } else if (nadrz == null) {
            System.out.println("Automobilu chybi nadrz. Nelze ho nastartovat.");
        } else if (nadrz.objemPaliva < 0.01) {
            System.out.println("Automobilu ma prazdnou nadrz. Nelze ho nastartovat.");
        } else {
            jeNastartovany = true;
            System.out.println("Automobil se nastartoval.");
        }
    }

    public void vypniSe() {
        if (jeNastartovany) {
            jeNastartovany = false;
            System.out.println("Automobil se vypnul.");
        } else {
            System.out.println("Automobil je jiz vypnuty.");
        }
    }

    public void natankuj(double objemTankovanehoPaliva) {
        if (jeNastartovany) {
            System.out.println("Automobil je nastartovany. Tankovat se musi s vypnutym motorem.");
        } else if (nadrz == null) {
            System.out.println("Automobil nema nadrz. Nelze jej natankovat.");
        } else {
            double volnaKapacita = nadrz.maxKapacita - nadrz.objemPaliva;
            if (objemTankovanehoPaliva > volnaKapacita) {
                System.out.println("Snazite se natankovat vice paliva (" + objemTankovanehoPaliva + " litru) nez se vejde do nadrze (" + volnaKapacita + " litru).");
            } else {
                nadrz.objemPaliva = nadrz.objemPaliva + objemTankovanehoPaliva;
                System.out.println("Natankovali jste " + objemTankovanehoPaliva + " litru paliva.");
            }
        }
    }

    public void odjedVzdalenost(double pocetKilometru) {
        if (!jeNastartovany) {
            System.out.println("Automobil neni nastartovany. Nemuze jet.");
        } else {
            double spotrebaZaJizdu = pocetKilometru * (motor.prumernaSpotreba / 100.0);
            if (spotrebaZaJizdu > nadrz.objemPaliva) {
                System.out.println("Na cestu " + pocetKilometru + " km nema automobil dost paliva.");
            } else {
                nadrz.objemPaliva = nadrz.objemPaliva - spotrebaZaJizdu;
                System.out.println("Automobil ujel " + pocetKilometru + " km.");
            }
        }
    }
}
