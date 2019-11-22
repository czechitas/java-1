package cz.czechitas.kockamyssyr;

import java.util.*;
import cz.czechitas.kockamyssyr.api.*;
import net.sevecek.util.*;

public class HlavniProgram {

    public void main(String[] args) {
        // Položte pár stromů na herní plochu. Třeba takhle:
        new Tree(0, 50);
        new Tree(250, 0);
        new Tree(550, 50);
        new Tree(550, 250);
        new Tree(550, 350);
        new Tree(150, 550);
        new Tree(200, 550);

        /*
        // Naprogramujte kočku tak, aby obešla digitální ležatou osmičku od kraje okna ke kraji.
        Cat sylvester = new Cat(50, 50);
        sylvester.moveForward(500);
        sylvester.turnRight();
        sylvester.moveForward(400);
        sylvester.turnLeft();
        sylvester.moveForward(500);
        sylvester.turnLeft();
        sylvester.moveForward(400);
        sylvester.turnLeft();
        sylvester.moveForward(500);
        sylvester.turnLeft();
        sylvester.moveForward(400);
        sylvester.turnRight();
        sylvester.moveForward(500);
        sylvester.turnRight();
        sylvester.moveForward(400);
        sylvester.turnRight();
        */

        // Vytvořte bludiště ze stromů.
        for (int i=0; i<8; i++) {
            new Tree(100, 100 + i*50);
        }
        for (int i=0; i<8; i++) {
            new Tree(150 + i*50, 100);
        }
        for (int i=0; i<10; i++) {
            new Tree(300 + i*50, 300);
        }
        for (int i=0; i<10; i++) {
            new Tree(250 + i*50, 450);
        }
        new Tree(350, 200);
        new Tree(350, 150);
        for (int i=0; i<4; i++) {
            new Tree(700, i*50);
        }
        for (int i=0; i<3; i++) {
            new Tree(750, 400 + i*50);
        }


        // Naprogramujte myš tak, aby se ovládala pomocí šipek na klávesnici.
        Mouse jerry;
        KeyboardBrain ovladacMysi;
        jerry = new Mouse(100, 100);
        ovladacMysi = new KeyboardBrain();
        jerry.setBrain(ovladacMysi);

        // Vytvořte 5 sýrů na náhodných pozicích,
        // položte je do bludiště z minula a nechejte myš ovládat klávesnicí.
        // Uvidíte, že až myš sesbírá všechny sýry, hra ohlásí vítězství.
        Random generatorNahodnychCisel = new Random();
        for (int i = 0; i < 5; i++) {
            int x;
            int y;
            x = generatorNahodnychCisel.nextInt(900);
            y = generatorNahodnychCisel.nextInt(550);
            new Cheese(x, y);
        }

        /*
        // Hra kočka proti myši pro dva hráče.
        // Kočka honí pomocí kláves W, A, S, D, myš utíká pomocí šipek.
        // Když dříve sežere kočka myš, myš prohrála. Když myš dříve
        // sežere všechny sýry, vyhrála myš.

        // Do programu přidejte kočku. Nechejte myš ovládat šipkami na klávesnici,
        // zatímco kočku pomocí W, A, S, D.
        Cat tom;
        KeyboardBrain ovladacKocky;
        tom = new Cat(600, 400);
        ovladacKocky = new KeyboardBrain(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D);
        tom.setBrain(ovladacKocky);
        */

        // Hra kočka proti myši pro jednoho hráče.
        // Kočka honí myš - pohybuje se náhodně.
        // Když dříve sežere kočka myš, myš prohrála. Když myš dříve
        // sežere všechny sýry, vyhrála myš.

        // Vytvořte kočce Brain tak, aby se pohybovala náhodně, místo kláves W, A, S, D.
        // Zeptejte se lektora, jak můžete nejsnadněji naprogramovat vlastní Brain.
        Cat tom;
        tom = new Cat(250, 250);
        tom.setBrain(it -> {
            while (true) {
                while (tom.isPossibleToMoveForward()) {
                    tom.moveForward();
                }
                int nahodnySmer = generatorNahodnychCisel.nextInt(2);
                if (nahodnySmer == 0) {
                    tom.turnLeft();
                } else {
                    tom.turnRight();
                }
            }
        });

    }

}
