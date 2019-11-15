package cz.czechitas.banka;

public class PovolenyDebetTest {

    public void otestujPovolenyDebet() {
        BeznyUcet ucet3 = new BeznyUcet(6600.0);
        otestujJedenBeznyUcetSDebetem(ucet3, 6600.0, 0.0, 6400.0, 20000.0);

        BeznyUcet ucet4 = new BeznyUcet(60000.0, 10000.0);
        otestujJedenBeznyUcetSDebetem(ucet4, 60000.0, 10000.0, 65000.0, 20000.0);

        System.out.println("BeznyUcet + Precerpani: Vsechny testy jsou OK");
    }

    //-------------------------------------------------------------------------

    private void otestujJedenBeznyUcetSDebetem(BeznyUcet account, double balance, double maxOverdraft, double withdrawAmount1, double withdrawAmount2) {
        assertEquals(maxOverdraft, account.getLimitPrecerpani(), "Limit precerpani predany do konstruktoru neni spravne vracen zpet. Metoda getLimitPrecerpani() by mela vracet " + maxOverdraft + ", ale vraci " + account.getLimitPrecerpani());
        assertEquals(balance, account.getZustatek(), "Pocatecni castka predana do konstruktoru (" + balance + ") by mela byl vracena zpet pomoci getZustatek(), ale tato metoda vraci " + account.getZustatek());
        assertEquals(balance + maxOverdraft, account.getPouzitelnyZustatek(), "Pouzitelny zustatek na uctu by mel byt " + (balance + maxOverdraft) + ", ale getPouzitelnyZustatek() vraci " + account.getPouzitelnyZustatek());

        vkladMusiZvysitZustatekIPouzitelnyZustatek(account, balance, maxOverdraft);

        vyberMusiSnizitZustatekIPouzitelnyZustatek(account, balance + 1000.0, maxOverdraft, withdrawAmount1);

        prilisVysokyVyberMusiSelhat(account, balance + 1000.0 - withdrawAmount1, maxOverdraft, withdrawAmount2);
    }

    private void vkladMusiZvysitZustatekIPouzitelnyZustatek(BeznyUcet ucet, double zustatek, double maxDebet) {
        boolean vysledek = ucet.vlozPenize(1000.0);

        assertTrue(vysledek, ucet.getClass().getSimpleName() + " nepovolil vklad " + 1000.0);
        assertEquals(maxDebet, ucet.getLimitPrecerpani(), "Limit precerpani uctu " + maxDebet + " se nesmi zmenit po vkladu " + 1000.0 + ", ale zmenil se na " + ucet.getLimitPrecerpani());
        assertEquals(zustatek + 1000.0, ucet.getZustatek(), "Zustatek " + zustatek + " se musi zvysit jen o vkladanou castku " + 1000.0 + " na " + (zustatek + 1000.0) + ", ale misto toho je " + ucet.getZustatek());
        assertEquals(zustatek + maxDebet + 1000.0, ucet.getPouzitelnyZustatek(), "Pouzitelny zustatek " + (zustatek + maxDebet) + " se musi zvysit o castku " + 1000.0 + " na " + (zustatek + maxDebet + 1000.0) + ", ale misto toho je " + ucet.getPouzitelnyZustatek());
    }

    private void vyberMusiSnizitZustatekIPouzitelnyZustatek(BeznyUcet ucet, double zustatek, double maxDebet, double vybiranaCastka) {
        boolean vysledek = ucet.vyberPenize(vybiranaCastka);

        assertTrue(vysledek, ucet.getClass().getSimpleName() + " zamitl vyber " + vybiranaCastka);
        assertEquals(maxDebet, ucet.getLimitPrecerpani(), "Limit precerpani " + maxDebet + " se nesmi zmenit po vyberu " + 1000.0 + ", ale zmenil se na " + ucet.getLimitPrecerpani());
        assertEquals(zustatek - vybiranaCastka, ucet.getZustatek(), "Zustatek " + zustatek + " se musi snizit o vybranou castku " + vybiranaCastka + " na " + (zustatek - vybiranaCastka) + ", ale misto toho je " + ucet.getZustatek());
        assertEquals(zustatek + maxDebet - vybiranaCastka, ucet.getPouzitelnyZustatek(), "Pouzitelny zustatek " + (zustatek + maxDebet) + " se musi snizit o vybranou castku " + vybiranaCastka + " na " + (zustatek + maxDebet - vybiranaCastka) + ", ale misto toho je " + ucet.getPouzitelnyZustatek());
    }

    private void prilisVysokyVyberMusiSelhat(BeznyUcet ucet, double zustatek, double maxDebet, double vybiranaCastka) {
        boolean vysledek = ucet.vyberPenize(vybiranaCastka);

        assertTrue(!vysledek, ucet.getClass().getSimpleName() + " nezamitl prilis velky vyber " + vybiranaCastka);
        assertEquals(maxDebet, ucet.getLimitPrecerpani(), "Limit precerpani " + maxDebet + " musi zustat stejny bez ohlednu na to, zda probehl vyber nebo ne, ale zmenil se na " + ucet.getLimitPrecerpani());
        assertEquals(zustatek, ucet.getZustatek(), "Zustatek " + zustatek + " se nesmi zmenit po zamitnutem vyberu castky " + vybiranaCastka + ", ale zmenil se na " + ucet.getZustatek());
        assertEquals(zustatek + maxDebet, ucet.getPouzitelnyZustatek(), "Pouzitelny zustatek " + (zustatek + maxDebet) + " se nesmi zmenit po zamitnutem vyberu castky " + vybiranaCastka + ", ale zmenil se na " + ucet.getPouzitelnyZustatek());
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
