package cz.czechitas.banka;

import java.io.*;
import java.nio.charset.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import net.sevecek.util.*;

public class SporiciUcetTest {

    public void otestujSporiciUcet() {
        SporiciUcet ucet5 = new SporiciUcet(5000.0);
        otestujJedenSporiciUcet(ucet5, 5000.0);

        SporiciUcet ucet6 = new SporiciUcet(10000.0, 0.05);
        otestujJedenSporiciUcet(ucet6, 10000.0);

        SporiciUcet account7 = new SporiciUcet(10000.0, 0.06);
        otestujJedenSporiciUcet(account7, 10000.0, 0.06);

        SporiciUcet account8 = new SporiciUcet(20000.0);
        otestujJedenSporiciUcet(account8, 20000.0, 0.0);

        System.out.println("SporiciUcet: Vsechny testy jsou OK");
    }

    //-------------------------------------------------------------------------

    private void otestujJedenSporiciUcet(SporiciUcet ucet, double pocatecniZustatek) {
        pocatecniZustatekSeMusiSpravneOhlasit(ucet, pocatecniZustatek);
        zapornaCastkaNesmiBytVybrana(ucet);
        zapornaCastkaNesmiBytVlozena(ucet);
        vkladMusiZvysitZustatek(ucet);
        vyberMusiSnizitZustatek(ucet);
        prilisVysokyVyberMusiSelhat(ucet);
    }

    private void zapornaCastkaNesmiBytVlozena(SporiciUcet ucet) {
        try {
            boolean vysledek = executeAndCaptureConsole(() ->
                    ucet.vlozPenize(-1000.0)
            );
            assertTrue(!vysledek, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vlozit na " + ucet.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // Toto je v poradku. Vyjimka musi nastat pro spravny beh testu.
        }
    }

    private void zapornaCastkaNesmiBytVybrana(SporiciUcet ucet) {
        try {
            boolean vysledek = executeAndCaptureConsole(() ->
                    ucet.vyberPenize(-1000.0)
            );
            assertTrue(!vysledek, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vybrat z objektu " + ucet.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // Toto je v poradku. Vyjimka musi nastat pro spravny beh testu.
        }
    }

    private void pocatecniZustatekSeMusiSpravneOhlasit(SporiciUcet ucet, double pocatecniZustatek) {
        double skutecniZustatek = ucet.getZustatek();
        assertEquals(pocatecniZustatek, skutecniZustatek, ucet.getClass().getSimpleName() + " byl vytvoren s pocatecni castkou " + pocatecniZustatek + ", ale getZustatek() vraci " + skutecniZustatek + ".");
    }

    private void vkladMusiZvysitZustatek(SporiciUcet ucet) {
        double vkladanaCastka = 100.0;
        double pocatecniZustatek = ucet.getZustatek();

        boolean vysledek = ucet.vlozPenize(vkladanaCastka);

        assertTrue(vysledek, "Vklad na " + ucet.getClass().getSimpleName() + " ve vysi " + vkladanaCastka + " musi byt proveden.");
        double ocekavanyZustatek = pocatecniZustatek + vkladanaCastka;
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(ocekavanyZustatek, skutecnyZustatek, ucet.getClass().getSimpleName() + " se zustatkem " + pocatecniZustatek + " si uspesne vlozil " + vkladanaCastka + ". Vysledny zustatek by mel byt " + ocekavanyZustatek + ", ale byl " + skutecnyZustatek + ".");
    }

    private void vyberMusiSnizitZustatek(SporiciUcet ucet) {
        double vybiranaCastka = 250.0;
        double pocatecniZustatek = ucet.getZustatek();
        if (pocatecniZustatek < vybiranaCastka) {
            throw new AssertionError(ucet.getClass().getSimpleName() + " byl vytvoren s prilis malou pocatecni castkou");
        }

        boolean vysledek = ucet.vyberPenize(vybiranaCastka);

        assertTrue(vysledek, ucet.getClass().getSimpleName() + " se zustatkem  " + pocatecniZustatek + " musi povolit vyber castky " + vybiranaCastka + ".");
        double ocekavanyZustatek = pocatecniZustatek - vybiranaCastka;
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(ocekavanyZustatek, skutecnyZustatek, ucet.getClass().getSimpleName() + " se zustatkem " + pocatecniZustatek + " provedl vyber castky " + vybiranaCastka + ". Vysledny zustatek po provedeni vyberu byl " + skutecnyZustatek + ", ale mel byt " + ocekavanyZustatek + ".");
    }

    private void prilisVysokyVyberMusiSelhat(SporiciUcet ucet) {
        double pocatecniZustatek = ucet.getZustatek();
        double vybiranaCastka = Math.abs(pocatecniZustatek * 10.0) + 100;

        boolean vysledek = ucet.vyberPenize(vybiranaCastka);

        assertTrue(!vysledek, ucet.getClass().getSimpleName() + " s pocatecnim zustatkem " + pocatecniZustatek + " nesmi povolit vyber " + vybiranaCastka + ".");
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(pocatecniZustatek, skutecnyZustatek, "Zustatek na uctu musi zustat nezmenen po zamitnutem vyberu " + vybiranaCastka + " from " + ucet.getClass().getSimpleName() + " se zustatkem " + pocatecniZustatek + ". Chybny vysledny zustatek ale byl " + skutecnyZustatek);
    }

    //-------------------------------------------------------------------------

    private void otestujJedenSporiciUcet(SporiciUcet ucet, double zustatek, double urokovaMira) {
        if (urokovaMira < 0.0 || urokovaMira > 1.0) {
            throw new AssertionError("Neplatna urokova mira " + urokovaMira);
        }
        assertEquals(urokovaMira, ucet.getUrokovaMira(), "Urokova mira predana do konstruktoru (" + urokovaMira + ") musi byt ve stejne vysi vracena metodou getUrokovaMira(), ale misto toho bylo vraceno " + ucet.getUrokovaMira() + ".");
        assertEquals(zustatek, ucet.getZustatek(), "Pocatecni castka predana do konstruktoru (" + zustatek + ") musi byt ve stejne vysi vracena metodou getZustatek(), ale misto toho bylo vraceno " + ucet.getZustatek() + ".");

        pridaniUrokuMusiSpravneZvysitZustatek(ucet, zustatek, urokovaMira);

        pridaniUrokuTrikratMusiSpravneZvysitZustatek(ucet, zustatek, urokovaMira);

        pridaniUrokuMusiVlozitPenizeMistoPrimeZmenyZustatku();
    }

    private void pridaniUrokuMusiSpravneZvysitZustatek(SporiciUcet ucet, double zustatek, double urokovaMira) {
        ucet.vypocitejRocniUrokAVlozHoNaUcet();

        double ocekavanyZustatek = zustatek * (1.0 + urokovaMira);
        assertEquals(ocekavanyZustatek, ucet.getZustatek(), "Zustatek po pridani rocniho uroku byl " + ucet.getZustatek() + ", ale mel byt " + ocekavanyZustatek + " (" + zustatek + " + " + urokovaMira * 100.0 + " %)");
    }

    private void pridaniUrokuTrikratMusiSpravneZvysitZustatek(SporiciUcet ucet, double zustatek, double urokovaMira) {
        ucet.vypocitejRocniUrokAVlozHoNaUcet();
        ucet.vypocitejRocniUrokAVlozHoNaUcet();

        double ocekavanyZustatek = zustatek * (1.0 + urokovaMira) * (1.0 + urokovaMira) * (1.0 + urokovaMira);
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(ocekavanyZustatek, skutecnyZustatek, "Zustatek po pridani 3x rocniho uroku byl " + skutecnyZustatek + ", ale mel byt " + ocekavanyZustatek + " (" + zustatek + " + (" + urokovaMira * 100.0 + " % ^^ 3))");
    }

    private void pridaniUrokuMusiVlozitPenizeMistoPrimeZmenyZustatku() {
        AtomicBoolean vkladBylPouzit = new AtomicBoolean(false);
        SporiciUcet ucet = new SporiciUcet(10000.0, 0.05) {
            @Override
            public boolean vlozPenize(double castka) {
                vkladBylPouzit.set(true);
                return super.vlozPenize(castka);
            }
        };

        ucet.vypocitejRocniUrokAVlozHoNaUcet();

        assertEquals(10500.0, ucet.getZustatek(), "Rocni urok neni spravne vypocitan. Puvodni zustatek byl 10000, urokova mira je 5%. Vysledny zustatek ma byt 10000 + 5% = 10500, ale byl " + ucet.getZustatek() + ".");
        assertTrue(vkladBylPouzit.get(), "vypocitejRocniUrokAVlozHoNaUcet() nepouziva metodu vlozPenize(), ale mel by. Misto toho pravdepodobne meni primo vnitrni promennou, coz neni vhodne.");
    }

    //-------------------------------------------------------------------------

    private void assertTrue(boolean actualValue, String errorMessage) {
        if (!actualValue) {
            throw new AssertionError(errorMessage);
        }
    }

    private void assertEquals(double expectedValue, double actualValue, String errorMessage) {
        if (expectedValue != actualValue) {
            throw new AssertionError(errorMessage);
        }
    }

    private boolean executeAndCaptureConsole(Callable<Boolean> method) {
        boolean result;
        PrintStream backup = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {

            result = method.call();

            capturedConsoleOutput = new String(out.toByteArray(), Charset.defaultCharset());
        } catch (Exception ex) {
            throw ExceptionUtils.rethrowAsUnchecked(ex);
        } finally {
            System.setOut(backup);
        }
        return result;
    }

    private String capturedConsoleOutput;

}
