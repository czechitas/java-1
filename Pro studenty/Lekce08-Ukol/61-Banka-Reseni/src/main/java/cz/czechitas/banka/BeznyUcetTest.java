package cz.czechitas.banka;

import java.io.*;
import java.nio.charset.*;
import java.util.concurrent.*;
import net.sevecek.util.*;

public class BeznyUcetTest {

    public void otestujBeznyUcet() {
        BeznyUcet ucet1 = new BeznyUcet(8800.0);
        otestujJedenUcet(ucet1, 8800.0);

        BeznyUcet ucet2 = new BeznyUcet(50000.0);
        otestujJedenUcet(ucet2, 50000.0);

        System.out.println("BeznyUcet: Vsechny testy jsou OK");
    }

    //-------------------------------------------------------------------------

    private void otestujJedenUcet(BeznyUcet ucet, double pocatecniZustatek) {
        pocatecniZustatekSeMusiSpravneOhlasit(ucet, pocatecniZustatek);
        zapornaCastkaNesmiBytVlozena(ucet);
        zapornaCastkaNesmiBytVybrana(ucet);
        vkladMusiZvysitZustatek(ucet);
        vyberMusiSnizitZustatek(ucet);
        prilisVysokyVyberMusiSelhat(ucet);
    }

    private void zapornaCastkaNesmiBytVlozena(BeznyUcet ucet) {
        try {
            boolean vysledek = executeAndCaptureConsole(() ->
                    ucet.vyberPenize(-1000.0)
            );
            assertTrue(!vysledek, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vlozit na " + ucet.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // Toto je v poradku. Vyjimka musi nastat pro spravny beh testu.
        }
    }

    private void zapornaCastkaNesmiBytVybrana(BeznyUcet ucet) {
        try {
            boolean vysledek = executeAndCaptureConsole(() ->
                    ucet.vlozPenize(-1000.0)
            );
            assertTrue(!vysledek, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vybrat z objektu " + ucet.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // Toto je v poradku. Vyjimka musi nastat pro spravny beh testu.
        }
    }

    private void pocatecniZustatekSeMusiSpravneOhlasit(BeznyUcet ucet, double pocatecniZustatek) {
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(pocatecniZustatek, skutecnyZustatek, ucet.getClass().getSimpleName() + " byl vytvoren s pocatecni castkou " + pocatecniZustatek + ", ale getZustatek() vraci " + skutecnyZustatek + ".");
    }

    private void vkladMusiZvysitZustatek(BeznyUcet ucet) {
        double vkladanaCastka = 100.0;
        double pocatecniZustatek = ucet.getZustatek();

        boolean vysledek = ucet.vlozPenize(vkladanaCastka);

        assertTrue(vysledek, "Vklad na " + ucet.getClass().getSimpleName() + " ve vysi " + vkladanaCastka + " musi byt proveden.");
        double ocekavanyZustatek = pocatecniZustatek + vkladanaCastka;
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(ocekavanyZustatek, skutecnyZustatek, ucet.getClass().getSimpleName() + " se zustatkem " + pocatecniZustatek + " si uspesne vlozil " + vkladanaCastka + ". Vysledny zustatek by mel byt " + ocekavanyZustatek + ", ale byl " + skutecnyZustatek + ".");
    }

    private void vyberMusiSnizitZustatek(BeznyUcet ucet) {
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

    private void prilisVysokyVyberMusiSelhat(BeznyUcet ucet) {
        double pocatecniZustatek = ucet.getZustatek();
        double vybiranaCastka = Math.abs(pocatecniZustatek * 10.0) + 100;

        boolean vysledek = ucet.vyberPenize(vybiranaCastka);

        assertTrue(!vysledek, ucet.getClass().getSimpleName() + " s pocatecnim zustatkem " + pocatecniZustatek + " nesmi povolit vyber " + vybiranaCastka + ".");
        double skutecnyZustatek = ucet.getZustatek();
        assertEquals(pocatecniZustatek, skutecnyZustatek, "Zustatek na uctu musi zustat nezmenen po zamitnutem vyberu " + vybiranaCastka + " from " + ucet.getClass().getSimpleName() + " se zustatkem " + pocatecniZustatek + ". Chybny vysledny zustatek ale byl " + skutecnyZustatek);
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
