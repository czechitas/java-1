package cz.czechitas.pocitac;

import net.sevecek.console.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Pocitac kamiluvNotebook;
        kamiluvNotebook = new Pocitac();
        kamiluvNotebook.vypisInfo();
        kamiluvNotebook.zapniSe();

        Procesor kamiluvProcesor = new Procesor();
        kamiluvProcesor.rychlost = 3_600_000_000L;
        kamiluvProcesor.vyrobce = "Intel";

        Pamet kamilovaPamet = new Pamet();
        kamilovaPamet.kapacita = 32_000_000_000L;

        Disk kamiluvDisk = new Disk();
        kamiluvDisk.kapacita = 150_000_000_000L;

        kamiluvNotebook.cpu = kamiluvProcesor;
        kamiluvNotebook.ram = kamilovaPamet;
        kamiluvNotebook.pevnyDisk = kamiluvDisk;

        kamiluvNotebook.vypisInfo();

        kamiluvNotebook.zapniSe();

        kamiluvNotebook.zapniSe();

        kamiluvNotebook.vypniSe();

        kamiluvNotebook.vypniSe();
    }

}
