package net.sevecek.turtle;

import java.awt.*;
import java.util.*;
import java.util.concurrent.*;
import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle zofka;
    Turtle leonardo;

    public void run() {
        zofka = new Turtle();
        leonardo = new Turtle();

        zofka.setLocation(400, 400);
        leonardo.setLocation(100, 150);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            nakresliMasinku(zofka, 160.0, 3, vygenerujNahodnouBarvu());
        });
        executorService.execute(() -> {
            nakresliMasinku(leonardo, 160.0, 8, vygenerujNahodnouBarvu());
        });

        executorService.shutdown();
    }

    private void nakresliMasinku(Turtle zofka, double vyskaMasinky, int penWidth, Color barva) {
        double delkaMotoru = vyskaMasinky * 0.75;
        double vyskaKabiny = delkaMotoru;
        double prumerVelkehoKola = vyskaMasinky / 4;
        double prumerMalehoKola = vyskaMasinky / 8;
        zofka.setPenColor(barva);
        zofka.setPenWidth(penWidth);
        zofka.turnRight(135.0);
        nakresliRovnoramennyTrojuhelnik(zofka, delkaMotoru / 2, 90.0);
        zofka.turnLeft(45.0);
        zofka.move(delkaMotoru / 2);
        zofka.turnLeft(90.0);
        zofka.move(delkaMotoru / 6);
        nakresliObdelnik(zofka, delkaMotoru, delkaMotoru * 0.5);
        nakresliObdelnik(zofka, vyskaMasinky / 2, vyskaKabiny);
        zofka.turnRight(180.0);
        nakresliKruh(zofka, prumerVelkehoKola);
        zofka.turnRight(90.0);
        zofka.move(prumerMalehoKola);
        zofka.turnLeft(90.0);
        zofka.penUp();
        zofka.move(prumerMalehoKola + penWidth);
        zofka.penDown();
        nakresliKruh(zofka, prumerMalehoKola);
        zofka.turnRight(90.0);
        zofka.penUp();
        zofka.move(prumerMalehoKola / 2);
        zofka.turnLeft(90.0);
        zofka.penDown();
        nakresliKruh(zofka, prumerMalehoKola);
        zofka.penUp();
        zofka.turnLeft(90.0);
        zofka.move(delkaMotoru + vyskaMasinky / 2);
        zofka.penDown();
        zofka.turnLeft(90.0);
    }

    private void nakresliRovnoramennyTrojuhelnik(Turtle zofka, double delkaRamene, double uhelMeziRameny) {
        double delkaTretiStrany;
        delkaTretiStrany = vypocitejDelkuTretiStrany(delkaRamene, uhelMeziRameny);
        double uhelRamenoZakladna = (180.0 - uhelMeziRameny) / 2;
        zofka.turnRight(90.0 - uhelRamenoZakladna);
        zofka.move(delkaRamene);
        zofka.turnRight(180.0 - uhelMeziRameny);
        zofka.move(delkaRamene);
        zofka.turnRight(180.0 - uhelRamenoZakladna);
        zofka.move(delkaTretiStrany);
        zofka.turnRight(180.0);
        zofka.penUp();
        zofka.move(delkaTretiStrany);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    

    private void nakresliKruh(Turtle zofka, double polomer) {
        for (int i = 0; i < 36; i++) {
            zofka.turnRight(10.00);
            zofka.move((2 * Math.PI * polomer * 10.0 / 360));
        }
        zofka.turnRight(90.0);
        zofka.penUp();
        zofka.move(polomer * 2);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }

    private void nakresliObdelnik(Turtle zofka, double delkaStranyA, double delkaStranyB) {
        for (int i = 0; i < 2; i++) {
            zofka.move(delkaStranyB);
            zofka.turnRight(90.0);
            zofka.move(delkaStranyA);
            zofka.turnRight(90.0);
        }
        zofka.turnRight(90.0);
        zofka.penUp();
        zofka.move(delkaStranyA);
        zofka.turnLeft(90.0);
        zofka.penDown();
    }


    private double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana = Math.abs((velikostRamene * Math.sin((uhelMeziRameny * Math.PI / 180) / 2.0)) * 2.0);
        return tretiStrana;
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
