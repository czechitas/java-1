package cz.czechitas;

import java.awt.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        System.out.println("Zdravim, pozemstani! Zavedte me ke svemu vudci");


        Color barvaTextu;
        barvaTextu = new Color(255, 50, 50);

        System.out.println(barvaTextu);

        Point pevnyBod = new Point(100, 200);
        System.out.println(pevnyBod);

        Autobus busNaLince78;
        busNaLince78 = new Autobus();
        busNaLince78.vyrobniCislo = "AX123456";
        busNaLince78.barva = new Color(123, 122, 23);
        busNaLince78.barva = barvaTextu;
        busNaLince78.pocetSedicichLidi = 10;
        busNaLince78.pocetStojicichLidi = 5;



        Usecka jednaUsecka = new Usecka();
        jednaUsecka.zacatek = new Point(20, 10);
        jednaUsecka.konec = new Point(60, 40);

        System.out.println(jednaUsecka.zacatek.x);
        System.out.println(jednaUsecka.konec.y);
        jednaUsecka.vypisSe();

        Trojuhelnik mujTrojuhelnik1 = new Trojuhelnik();
        mujTrojuhelnik1.bodA = new Point(10, 10);
        mujTrojuhelnik1.bodB = new Point(10, 40);
        mujTrojuhelnik1.bodC = new Point(40, 10);
        mujTrojuhelnik1.vypisSe();

        System.out.println();

        Automobil trabant;
        trabant = new Automobil();
        trabant.znacka = "0B3 34-56";
        trabant.barva = new Color(0, 255, 0);
        trabant.vypisSe();
        for (int i = 0; i < 8; i++) {
            trabant.nechejNastoupitCloveka();
            trabant.vypisSe();
        }
    }

}
