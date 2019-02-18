package cz.czechitas.vlastnosti;

public class Disk {

    long kapacita;
    long vyuziteMisto;

    public void vytvorSouborOVelikosti(long velikost) {
            if (vyuziteMisto + velikost < kapacita) {
                vyuziteMisto = vyuziteMisto + velikost;
                System.out.println("Vytvoril se soubor o velikosti " + velikost + " bajtu.");
                System.out.print("    ");
                vypisInfo();
                System.out.println();
            } else {
                System.out.println("Na disku neni dost mista pro vytvoreni souboru " + velikost + ".");
                System.out.print("    ");
                vypisInfo();
                System.out.println();
            }
    }

    public void vymazSouboryOVelikosti(long velikost) {
            if (vyuziteMisto < velikost) {
                velikost = vyuziteMisto;
            }
            vyuziteMisto = vyuziteMisto - velikost;
            System.out.println("Vymazal se soubor o velikosti " + velikost + " bajtu.");
            System.out.print("    ");
            vypisInfo();
            System.out.println();
    }

    public void vypisInfo() {
        System.out.print("Disk: Obsazeno " + vyuziteMisto + " / " + kapacita + " bajtu");
    }
}
