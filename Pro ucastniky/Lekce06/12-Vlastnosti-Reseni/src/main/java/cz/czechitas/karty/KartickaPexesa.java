package cz.czechitas.karty;

public class KartickaPexesa {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int nove) {
        if (nove >=0 && nove <= 63) {
            id = nove;
        }
    }

    public int getCislo() {
        return id / 2;
    }

    public String toString() {
        return "Karticka pexesa " + id;
    }

    public boolean equals(Object druhy) {
        KartickaPexesa prvniKarticka = this;
        KartickaPexesa druhaKarticka = (KartickaPexesa) druhy;
        if (prvniKarticka.getCislo() == druhaKarticka.getCislo()) {
            return true;
        } else {
            return false;
        }
    }

}
