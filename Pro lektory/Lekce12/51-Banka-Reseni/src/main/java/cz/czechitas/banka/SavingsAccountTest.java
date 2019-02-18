package cz.czechitas.banka;

import java.io.*;
import java.nio.charset.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import net.sevecek.util.*;

public class SavingsAccountTest {

    public void testSavingsAccount() {
        SporiciUcet account5 = new SporiciUcet(5000.0);
        testOneAccount(account5, 5000.0);

        SporiciUcet account6 = new SporiciUcet(10000.0, 0.05);
        testOneAccount(account6, 10000.0);

        SporiciUcet account7 = new SporiciUcet(10000.0, 0.06);
        testOneSavingsAccount(account7, 10000.0, 0.06);

        SporiciUcet account8 = new SporiciUcet(20000.0);
        testOneSavingsAccount(account8, 20000.0, 0.0);

        System.out.println("SporiciUcet: Vsechny testy jsou OK");
    }

    //-------------------------------------------------------------------------

    private void testOneAccount(SporiciUcet account, double initialMoney) {
        initialBalanceShouldBeReportedBack(account, initialMoney);
        negativeAmountShouldNotBeWithdrawn(account);
        negativeAmountShouldNotBeDeposited(account);
        depositShouldIncreaseBalance(account);
        withdrawShouldDecreaseBalance(account);
        withdrawTooBigShouldFail(account);
    }

    private void negativeAmountShouldNotBeWithdrawn(SporiciUcet account) throws AssertionError {
        try {
            boolean result = executeAndCaptureConsole(() ->
                    account.vyberPenize(-1000.0)
            );
            assertTrue(!result, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vybrat z objektu " + account.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // This is expected. Negative amount is not allowed to be deposited.
        }
    }

    private void negativeAmountShouldNotBeDeposited(SporiciUcet account) throws AssertionError {
        try {
            boolean result = executeAndCaptureConsole(() ->
                    account.vlozPenize(-1000.0)
            );
            assertTrue(!result, "Zaporna castka, napriklad " + (-1000)
                    + ", nesmi byt povolena vlozit na " + account.getClass().getSimpleName() + ".");
        } catch (IllegalArgumentException ex) {
            // This is expected. Negative amount is not allowed to be deposited.
        }
    }

    private void initialBalanceShouldBeReportedBack(SporiciUcet account, double initialMoney) {
        double actualBalance = account.getZustatek();
        assertEquals(initialMoney, actualBalance, account.getClass().getSimpleName() + " byl vytvoren s pocatecni castkou " + initialMoney + ", ale getZustatek() vraci " + actualBalance + ".");
    }

    private void depositShouldIncreaseBalance(SporiciUcet account) {
        double depositAmount = 100.0;
        double initialMoney = account.getZustatek();

        boolean result = account.vlozPenize(depositAmount);

        assertTrue(result, "Vklad na " + account.getClass().getSimpleName() + " ve vysi " + depositAmount + " musi byt proveden.");
        double expectedBalance = initialMoney + depositAmount;
        double actualBalance = account.getZustatek();
        assertEquals(expectedBalance, actualBalance, account.getClass().getSimpleName() + " se zustatkem " + initialMoney + " si uspesne vlozil " + depositAmount + ". Vysledny zustatek by mel byt " + expectedBalance + ", ale byl " + actualBalance + ".");
    }

    private void withdrawShouldDecreaseBalance(SporiciUcet account) {
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

    private void withdrawTooBigShouldFail(SporiciUcet account) {
        double initialMoney = account.getZustatek();
        double withdrawAmount = Math.abs(initialMoney * 10.0) + 100;

        boolean result = account.vyberPenize(withdrawAmount);

        assertTrue(!result, account.getClass().getSimpleName() + " s pocatecnim zustatkem " + initialMoney + " nesmi povolit vyber " + withdrawAmount + ".");
        double actualBalance = account.getZustatek();
        assertEquals(initialMoney, actualBalance, "Zustatek na uctu musi zustat nezmenen po zamitnutem vyberu " + withdrawAmount + " from " + account.getClass().getSimpleName() + " se zustatkem " + initialMoney + ". Chybny vysledny zustatek ale byl " + actualBalance);
    }

    //-------------------------------------------------------------------------

    private void testOneSavingsAccount(SporiciUcet account, double balance, double interestRate) {
        if (interestRate < 0.0 || interestRate > 1.0) {
            throw new AssertionError(String.format("Neplatna urokova mira %f", interestRate));
        }
        assertEquals(interestRate, account.getUrokovaMira(), "Urokova mira predana do konstruktoru (" + interestRate + ") musi byt ve stejne vysi vracena metodou getUrokovaMira(), ale misto toho bylo vraceno " + account.getUrokovaMira() + ".");
        assertEquals(balance, account.getZustatek(), "Pocatecni castka predana do konstruktoru (" + balance + ") musi byt ve stejne vysi vracena metodou getZustatek(), ale misto toho bylo vraceno " + account.getZustatek() + ".");

        addInterest_should_calculate_balance(account, balance, interestRate);

        add3TimesInterest_should_calculate_balance_correctly(account, balance, interestRate);

        addYearlyInterest_should_use_deposit_instead_of_setBalance();
    }

    private void addInterest_should_calculate_balance(SporiciUcet account, double balance, double interestRate) {
        account.vypocitejRocniUrokAVlozHoNaUcet();

        double expectedBalance = balance * (1.0 + interestRate);
        assertEquals(expectedBalance, account.getZustatek(), "Zustatek po pridani rocniho uroku byl " + account.getZustatek() + ", ale mel byt " + expectedBalance + " (" + balance + " + " + interestRate * 100.0 + " %)");
    }

    private void add3TimesInterest_should_calculate_balance_correctly(SporiciUcet account, double balance, double interestRate) {
        account.vypocitejRocniUrokAVlozHoNaUcet();
        account.vypocitejRocniUrokAVlozHoNaUcet();

        double expectedBalance = balance * (1.0 + interestRate) * (1.0 + interestRate) * (1.0 + interestRate);
        double actualBalance = account.getZustatek();
        assertEquals(expectedBalance, actualBalance, "Zustatek po pridani 3x rocniho uroku byl " + actualBalance + ", ale mel byt " + expectedBalance + " (" + balance + " + (" + interestRate * 100.0 + " % ^^ 3))");
    }

    private void addYearlyInterest_should_use_deposit_instead_of_setBalance() {
        AtomicBoolean depositWasUsed = new AtomicBoolean(false);
        SporiciUcet account = new SporiciUcet(10000.0, 0.05) {
            @Override
            public boolean vlozPenize(double amount) {
                depositWasUsed.set(true);
                return super.vlozPenize(amount);
            }
        };

        account.vypocitejRocniUrokAVlozHoNaUcet();

        assertEquals(10500.0, account.getZustatek(), "Rocni urok neni spravne vypocitan. Puvodni zustatek byl 10000, urokova mira je 5%. Vysledny zustatek ma byt 10000 + 5% = 10500, ale byl " + account.getZustatek() + ".");
        assertTrue(depositWasUsed.get(), "vypocitejRocniUrokAVlozHoNaUcet() nepouziva metodu vlozPenize(), ale mel by. Misto toho pravdepodobne meni primo vnitrni promennou, coz neni vhodne.");
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
