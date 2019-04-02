package cz.czechitas.banka;

import java.io.*;
import java.nio.charset.*;
import java.util.concurrent.*;
import net.sevecek.util.*;

public class NormalAccountTest {

    public void testNormalAccount() {
        BeznyUcet account1 = new BeznyUcet(8800.0);
        testOneAccount(account1, 8800.0);

        BeznyUcet account2 = new BeznyUcet(50000.0);
        testOneAccount(account2, 50000.0);

        System.out.println("BeznyUcet: Vsechny testy jsou OK");
    }

    //-------------------------------------------------------------------------

    private void testOneAccount(BeznyUcet account, double initialMoney) {
        initialBalanceShouldBeReportedBack(account, initialMoney);
        negativeAmountShouldNotBeDeposited(account);
        negativeAmountShouldNotBeWithdrawn(account);
        depositShouldIncreaseBalance(account);
        withdrawShouldDecreaseBalance(account);
        withdrawTooBigShouldFail(account);
    }

    private void negativeAmountShouldNotBeDeposited(BeznyUcet account) throws AssertionError {
        try {
            boolean result;
            result = executeAndCaptureConsole(() ->
                    account.vyberPenize(-1000.0)
            );
            assertTrue(!result, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vlozit na " + account.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // This is expected. Negative amount is not allowed to be deposited.
        }
    }

    private void negativeAmountShouldNotBeWithdrawn(BeznyUcet account) throws AssertionError {
        try {
            boolean result = executeAndCaptureConsole(() ->
                    account.vlozPenize(-1000.0)
            );
            assertTrue(!result, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vybrat z objektu " + account.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // This is expected. Negative amount is not allowed to be deposited.
        }
    }

    private void initialBalanceShouldBeReportedBack(BeznyUcet account, double initialMoney) {
        double actualBalance = account.getZustatek();
        assertEquals(initialMoney, actualBalance, account.getClass().getSimpleName() + " byl vytvoren s pocatecni castkou " + initialMoney + ", ale getZustatek() vraci " + actualBalance + ".");
    }

    private void depositShouldIncreaseBalance(BeznyUcet account) {
        double depositAmount = 100.0;
        double initialMoney = account.getZustatek();

        boolean result = account.vlozPenize(depositAmount);

        assertTrue(result, "Vklad na " + account.getClass().getSimpleName() + " ve vysi " + depositAmount + " musi byt proveden.");
        double expectedBalance = initialMoney + depositAmount;
        double actualBalance = account.getZustatek();
        assertEquals(expectedBalance, actualBalance, account.getClass().getSimpleName() + " se zustatkem " + initialMoney + " si uspesne vlozil " + depositAmount + ". Vysledny zustatek by mel byt " + expectedBalance + ", ale byl " + actualBalance + ".");
    }

    private void withdrawShouldDecreaseBalance(BeznyUcet account) {
        double withdrawAmount = 250.0;
        double initialMoney = account.getZustatek();
        if (initialMoney < withdrawAmount) {
            throw new AssertionError(account.getClass().getSimpleName() + " byl vytvoren s prilis malou pocatecni castkou");
        }

        boolean result = account.vyberPenize(withdrawAmount);

        assertTrue(result, account.getClass().getSimpleName() + " se zustatkem  " + initialMoney + " musi povolit vyber castky " + withdrawAmount + ".");
        double expectedBalance = initialMoney - withdrawAmount;
        double actualBalance = account.getZustatek();
        assertEquals(expectedBalance, actualBalance, account.getClass().getSimpleName() + " se zustatkem " + initialMoney + " provedl vyber castky " + withdrawAmount + ". Vysledny zustatek po provedeni vyberu byl " + actualBalance + ", ale mel byt " + expectedBalance + ".");
    }

    private void withdrawTooBigShouldFail(BeznyUcet account) {
        double initialMoney = account.getZustatek();
        double withdrawAmount = Math.abs(initialMoney * 10.0) + 100;

        boolean result = account.vyberPenize(withdrawAmount);

        assertTrue(!result, account.getClass().getSimpleName() + " s pocatecnim zustatkem " + initialMoney + " nesmi povolit vyber " + withdrawAmount + ".");
        double actualBalance = account.getZustatek();
        assertEquals(initialMoney, actualBalance, "Zustatek na uctu musi zustat nezmenen po zamitnutem vyberu " + withdrawAmount + " from " + account.getClass().getSimpleName() + " se zustatkem " + initialMoney + ". Chybny vysledny zustatek ale byl " + actualBalance);
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
