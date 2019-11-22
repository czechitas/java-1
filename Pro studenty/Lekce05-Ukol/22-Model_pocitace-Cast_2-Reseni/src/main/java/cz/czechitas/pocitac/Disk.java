package cz.czechitas.pocitac;

public class Disk {

    long kapacita;
    long vyuziteMisto;

    public String toString() {
        return "Disk: Obsazeno " + vyuziteMisto + " / " + kapacita + " bajtu";
    }
}
