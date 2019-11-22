package cz.czechitas.recept.naradi;

public class Mixer {

    private String jmeno;


    public Mixer(String jmeno) {
        this.jmeno = jmeno;
    }


    public void zamichej(Miska kterouMisku) {
        kterouMisku.setDobreZamichane();
        System.out.println(jmeno + " zamichal misku " + kterouMisku.getJmeno());
    }

}
