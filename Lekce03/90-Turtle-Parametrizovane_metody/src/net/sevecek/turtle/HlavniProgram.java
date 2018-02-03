package net.sevecek.turtle;

import java.awt.*;
import java.util.*;
import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle zofka;

    public void run() {
        zofka = new Turtle();
        Color cervenaBarva;
        cervenaBarva = new Color(255, 0, 0);

        zofka.setLocation(100.0, 100.0);
        // Volani metody, do ktere se preda hodnota 10 a objekt, ktery je v promenne cervenaBarva
        nakresliBarevnyRovnostrannyTrojuhelnik(50.0, cervenaBarva);

        zofka.setLocation(300.0, 100.0);
        // Volani metody, do ktere se preda hodnota 15 a nove vytvoreny objekt barvy
        nakresliBarevnyRovnostrannyTrojuhelnik(70.0, new Color(0, 0, 255));
    }

    private void nakresliRovnoramennyTrojuhelnik(double delkaRamene, double uhelMeziRameny) {
        double delkaTretiStrany;
        delkaTretiStrany = vypocitejDelkuTretiStrany(delkaRamene, uhelMeziRameny);

        // Sem vlozte prikazy na kresleni (domaci ukol)
    }

    private double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene
                * Math.sin((uhelMeziRameny * Math.PI / 180) / 2.0))
                * 2.0);
        return tretiStrana;
    }

    private void nakresliBarevnyRovnostrannyTrojuhelnik(double velikostStrany, Color barvaCary) {
        // Zde lze používat proměnnou velikostStrany a barva:
        zofka.setPenColor(barvaCary);
        zofka.move(velikostStrany);
        zofka.turnLeft(120.0);
        zofka.move(velikostStrany);
        zofka.turnLeft(120.0);
        zofka.move(velikostStrany);
        zofka.turnLeft(120.0);
    }

    private Color vygenerujNahodnouBarvu() {
        Random generator;
        int red;
        int green;
        int blue;
        Color nahodnaBarva;

        generator = new Random();
        red = generator.nextInt(256);
        green = generator.nextInt(256);
        blue = generator.nextInt(256);

        nahodnaBarva = new Color(red, green, blue);
        return nahodnaBarva;
    }

}
