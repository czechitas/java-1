package cz.czechitas.kockamyssyr;

import java.util.*;
import cz.czechitas.kockamyssyr.api.*;
import net.sevecek.util.*;

public class HlavniProgram {

    public void main(String[] args) {

        new Tree(400, 200);
        // TODO: Sem vepiste svuj program

    }

}

































        /*
            // Ukazky pouziti trid Cheese, Mouse, Cat, Tree, Brain, KeyboardBrain
        Mouse jerry;
        jerry = new Mouse(50, 50);

        new Tree(200, 300);

        new Cheese(350, 150);
        new Cheese(250, 150);

        Brain mozekMysi;
        mozekMysi = new KeyboardBrain(
                KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D);
        mozekMysi = new KeyboardBrain();
        jerry.setBrain(mozekMysi);

        // Vytvorime objekt kocky a projdeme s ni pismeno L
        Cat tom;
        tom = new Cat(0, 0);
        tom.turnRight();
        tom.moveForward(250);
        tom.turnLeft();
        tom.moveForward(100);
         */


        /*
        // Dalsi hratky s enginem
                for (int x = 5; x < 9; x++) {
            new Tree(x*50, 200);
        }
        new Tree(0, 0);
        new Tree(10, 0);
        new Tree(250, 250);
        new Tree(260, 250);
        new Tree(300, 250);
        new Tree(350, 250);
        new Tree(400, 250);

        new Cheese(200, 100);
        new Cheese(0, 0);
        new Cheese(800, 550);

        Mouse jerry;
        Mouse mickey;
        jerry = new Mouse(500, 100);
        mickey = jerry;
        jerry.turnLeft();
        mickey.turnRight();
        mickey.turnRight();
        mickey.turnRight();

        Brain ovladacMysi;
        ovladacMysi = new KeyboardBrain();
        jerry.setBrain(ovladacMysi);

        Random generatorNahodnychCisel;
        generatorNahodnychCisel = new Random();
        int nahodnyRadek;
        nahodnyRadek = generatorNahodnychCisel.nextInt(600);
        int nahodnySloupec;
        nahodnySloupec = generatorNahodnychCisel.nextInt(150);
        Cat tom = new Cat(nahodnySloupec, nahodnyRadek);

        tom.moveForward();

        tom.setBrain( it -> {
            tom.moveForward();
            tom.moveForward();
            tom.moveForward();
            tom.moveForward();
            tom.moveForward();
            tom.moveForward();
            tom.moveForward();
        });

        ThreadUtils.sleep(100L);

        tom.remove();
         */