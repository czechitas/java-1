package cz.czechitas.pocitac;

public class SpousteciTrida {

    public static void main(String[] args) {
        Pocitac kamiluvNotebook;
        kamiluvNotebook = new Pocitac();
        System.out.println(kamiluvNotebook.toString());

        kamiluvNotebook.zapniSe();

        Procesor kamiluvProcesor = new Procesor();
        kamiluvProcesor.rychlost = 3_600_000_000L;
        kamiluvProcesor.vyrobce = "Intel";

        Pamet kamilovaPamet = new Pamet();
        kamilovaPamet.kapacita = 32_000_000_000L;

        Disk kamiluvDisk = new Disk();
        kamiluvDisk.kapacita = 1_500_000_000_000L;

        kamiluvNotebook.cpu = kamiluvProcesor;
        kamiluvNotebook.ram = kamilovaPamet;
        kamiluvNotebook.pevnyDisk = kamiluvDisk;

        System.out.println(kamiluvNotebook.toString());

        kamiluvNotebook.zapniSe();
        kamiluvNotebook.vytvorSouborOVelikosti(333_000L);

        kamiluvNotebook.vypniSe();
        kamiluvNotebook.vytvorSouborOVelikosti(200_000L);

        kamiluvNotebook.zapniSe();
        kamiluvNotebook.vytvorSouborOVelikosti(300_000L);
        kamiluvNotebook.vymazSouboryOVelikosti(300_000L);

        kamiluvNotebook.vytvorSouborOVelikosti(200_000_000_000L);

        Disk kamiluvNovyDisk = new Disk();
        kamiluvNovyDisk.kapacita = 100_000_000_000L;
        kamiluvNotebook.druhyDisk = kamiluvNovyDisk;
        System.out.println(kamiluvNotebook.toString());

        kamiluvNotebook.vytvorSouborOVelikosti(200_000_000_000L);
        System.out.println(kamiluvNotebook.toString());
    }

}
