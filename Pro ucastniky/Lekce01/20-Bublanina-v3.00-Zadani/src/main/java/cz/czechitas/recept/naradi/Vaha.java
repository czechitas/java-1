package cz.czechitas.recept.naradi;

public class Vaha {

    private String jmeno;
    private Miska taraNastavenaNaMisku;
    private int hmotnostTary;


    public Vaha(String jmeno) {
        this.jmeno = jmeno;
    }


    public void vynulujSeS(Miska kterouMiskou) {
        taraNastavenaNaMisku = kterouMiskou;
        hmotnostTary = kterouMiskou.getHmotnost();
        System.out.println(jmeno + " se vynulovala s miskou " + kterouMiskou.getJmeno());
    }


    public int zjistiHmotnost(Miska ktereMisky) {
        if (taraNastavenaNaMisku == null) {
            throw new IllegalStateException("Vaha nemuze spravne vazit, protoze neni vynulovana s prazdnou miskou");
        }
        if (!taraNastavenaNaMisku.equals(ktereMisky)) {
            throw new IllegalStateException("Vaha byla vynulovana s jinou miskou, nez kterou vazi");
        }
        int hmotnost = ktereMisky.getHmotnost() - hmotnostTary;
        System.out.println(jmeno + " zvazila misku " + ktereMisky.getJmeno() + ": " + hmotnost + " g");
        return hmotnost;
    }


    public String getJmeno() {
        return jmeno;
    }
}
