package cz.czechitas.banka;

public class SpousteciTrida {

    public static void main(String[] args) {
        BeznyUcetTest tester1 = new BeznyUcetTest();
        PovolenyDebetTest tester2 = new PovolenyDebetTest();
        SporiciUcetTest tester3 = new SporiciUcetTest();

        tester1.otestujBeznyUcet();
        tester2.otestujPovolenyDebet();
        tester3.otestujSporiciUcet();
    }

}
