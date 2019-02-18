package cz.czechitas.pexeso;

public class SpousteciTrida {

    public static void main(String[] args) {
        Karticka prvni = new Karticka();
        prvni.hodnota = 32;
        prvni.x = 0;
        prvni.y = 0;
        prvni.stav = "rub";     // nebo "lic"    nebo  "odebrana"
        System.out.println(prvni);
        System.out.println(prvni.isOdebrana());
        System.out.println(prvni.isRubemNahoru());
        System.out.println(prvni.isLicemNahoru());

        // Bonus:
        prvni.otoc();
        System.out.println(prvni);
        System.out.println(prvni.isRubemNahoru());
        prvni.otoc();
        System.out.println(prvni);
        System.out.println(prvni.isRubemNahoru());
        prvni.otoc();
        System.out.println(prvni);
        System.out.println(prvni.isRubemNahoru());
        prvni.odeber();
        System.out.println(prvni);
    }

}
