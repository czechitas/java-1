package cz.czechitas.pocitac;

public class Disk {

    long kapacita;
    long vyuziteMisto;

    public void vypisInfo() {
        System.out.print("Disk: Obsazeno " + vyuziteMisto + " / " + kapacita + " bajtu");
    }
}
