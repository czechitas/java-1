package cz.czechitas.vlastnosti;

public class Datum {

    private int rok;
    private int mesic;
    private int den;

    public int getRok() {
        return rok;
    }

    public void setRok(int novaHodnota) {
        rok = novaHodnota;
    }

    public int getMesic() {
        return mesic;
    }

    public String getNazevMesice() {
        if (mesic == 1) {
            return "leden";
        } else if (mesic == 2) {
            return "unor";
        } else if (mesic == 3) {
            return "brezen";
        } else if (mesic == 4) {
            return "duben";
        } else if (mesic == 5) {
            return "kveten";
        } else if (mesic == 6) {
            return "cerven";
        } else if (mesic == 7) {
            return "cervenec";
        } else if (mesic == 8) {
            return "srpen";
        } else if (mesic == 9) {
            return "zari";
        } else if (mesic == 10) {
            return "rijen";
        } else if (mesic == 11) {
            return "listopad";
        } else if (mesic == 12) {
            return "prosinec";
        } else {
            return "NEPLATNY_MESIC_" + mesic;
        }
    }

    public void setMesic(int novaHodnota) {
        if (novaHodnota < 1 || novaHodnota > 12) {
            System.out.println("Neplatna hodnota mesice " + novaHodnota);
            return;
        }
        mesic = novaHodnota;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int novaHodnota) {
        if (novaHodnota < 1 || novaHodnota > 31) {
            System.out.println("Neplatna hodnota dne " + novaHodnota);
            return;
        }
        den = novaHodnota;
    }

    @Override
    public String toString() {
        return "Datum " +
                den +
                ". " +
                getNazevMesice() +
                " " +
                rok;
    }
}
