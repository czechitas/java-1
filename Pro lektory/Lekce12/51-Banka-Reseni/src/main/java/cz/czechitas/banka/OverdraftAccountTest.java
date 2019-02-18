package cz.czechitas.banka;

import java.io.*;
import java.nio.charset.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import net.sevecek.util.*;

public class OverdraftAccountTest {

    public void testOverdraftAccount() {
        BeznyUcet account3 = new BeznyUcet(6600.0);
        testOneCheckingAccount(account3, 6600.0, 0.0, 6400.0, 20000.0);

        BeznyUcet account4 = new BeznyUcet(60000.0, 10000.0);
        testOneCheckingAccount(account4, 60000.0, 10000.0, 65000.0, 20000.0);

        System.out.println("BeznyUcet + Overdraft: Vsechny testy jsou OK");
    }

    //-------------------------------------------------------------------------

    private void testOneCheckingAccount(BeznyUcet account, double balance, double maxOverdraft, double withdrawAmount1, double withdrawAmount2) {
        assertEquals(maxOverdraft, account.getLimitPrecerpani(), "Limit precerpani predany do konstruktoru neni spravne vracen zpet. Metoda getLimitPrecerpani() by mela vracet " + maxOverdraft + ", ale vraci " + account.getLimitPrecerpani());
        assertEquals(balance, account.getZustatek(), "Pocatecni castka predana do konstruktoru (" + balance + ") by mela byl vracena zpet pomoci getZustatek(), ale tato metoda vraci " + account.getZustatek());
        assertEquals(balance + maxOverdraft, account.getPouzitelnyZustatek(), "Pouzitelny zustatek na uctu by mel byt " + (balance + maxOverdraft) + ", ale getPouzitelnyZustatek() vraci " + account.getPouzitelnyZustatek());

        depositShouldIncreaseBalanceAndUsableBalance(account, balance, maxOverdraft);

        withdrawShouldDecreaseBalanceAndUsableBalance(account, balance + 1000.0, maxOverdraft, withdrawAmount1);

        withdrawToMuchShouldFail(account, balance + 1000.0 - withdrawAmount1, maxOverdraft, withdrawAmount2);
    }

    private void depositShouldIncreaseBalanceAndUsableBalance(BeznyUcet account, double balance, double maxOverdraft) {
        boolean result = account.vlozPenize(1000.0);

        assertTrue(result, account.getClass().getSimpleName() + " nepovolil vklad " + 1000.0);
        assertEquals(maxOverdraft, account.getLimitPrecerpani(), "Limit precerpani uctu " + maxOverdraft + " se nesmi zmenit po vkladu " + 1000.0 + ", ale zmenil se na " + account.getLimitPrecerpani());
        assertEquals(balance + 1000.0, account.getZustatek(), "Zustatek " + balance + " se musi zvysit jen o vkladanou castku " + 1000.0 + " na " + (balance + 1000.0) + ", ale misto toho je " + account.getZustatek());
        assertEquals(balance + maxOverdraft + 1000.0, account.getPouzitelnyZustatek(), "Pouzitelny zustatek " + (balance + maxOverdraft) + " se musi zvysit o castku " + 1000.0 + " na " + (balance + maxOverdraft + 1000.0) + ", ale misto toho je " + account.getPouzitelnyZustatek());
    }

    private void withdrawShouldDecreaseBalanceAndUsableBalance(BeznyUcet account, double balance, double maxOverdraft, double withdrawAmount1) {
        boolean result = account.vyberPenize(withdrawAmount1);

        assertTrue(result, account.getClass().getSimpleName() + " zamitl vyber " + withdrawAmount1);
        assertEquals(maxOverdraft, account.getLimitPrecerpani(), "Limit precerpani " + maxOverdraft + " se nesmi zmenit po vyberu " + 1000.0 + ", ale zmenil se na " + account.getLimitPrecerpani());
        assertEquals(balance - withdrawAmount1, account.getZustatek(), "Zustatek " + balance + " se musi snizit o vybranou castku " + withdrawAmount1 + " na " + (balance - withdrawAmount1) + ", ale misto toho je " + account.getZustatek());
        assertEquals(balance + maxOverdraft - withdrawAmount1, account.getPouzitelnyZustatek(), "Pouzitelny zustatek " + (balance + maxOverdraft) + " se musi snizit o vybranou castku " + withdrawAmount1 + " na " + (balance + maxOverdraft - withdrawAmount1) + ", ale misto toho je " + account.getPouzitelnyZustatek());
    }

    private void withdrawToMuchShouldFail(BeznyUcet account, double balance, double maxOverdraft, double withdrawAmount) {
        boolean result = account.vyberPenize(withdrawAmount);

        assertTrue(!result, account.getClass().getSimpleName() + " nezamitl prilis velky vyber " + withdrawAmount);
        assertEquals(maxOverdraft, account.getLimitPrecerpani(), "Limit precerpani " + maxOverdraft + " musi zustat stejny bez ohlednu na to, zda probehl vyber nebo ne, ale zmenil se na " + account.getLimitPrecerpani());
        assertEquals(balance, account.getZustatek(), "Zustatek " + balance + " se nesmi zmenit po zamitnutem vyberu castky " + withdrawAmount + ", ale zmenil se na " + account.getZustatek());
        assertEquals(balance + maxOverdraft, account.getPouzitelnyZustatek(), "Pouzitelny zustatek " + (balance + maxOverdraft) + " se nesmi zmenit po zamitnutem vyberu castky " + withdrawAmount + ", ale zmenil se na " + account.getPouzitelnyZustatek());
    }

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

}
