package cz.czechitas.kockamyssyr;

import java.util.*;
import cz.czechitas.kockamyssyr.api.*;
import net.sevecek.util.*;

public class HlavniProgram {

    public void main(String[] args) {

        new Tree(400, 200);
        new Tree(400, 200);
        new Tree(400, 200);
        new Tree(400, 200);
        // TODO: Sem vepiste svuj program

        new Cat(50, 100);
        Cat tom = new Cat(100, 100);
        tom.setBrain(new KeyboardBrain());

        new Cheese(200, 200);

        Mouse jerry = new Mouse(600, 200);
        jerry.setBrain(new KeyboardBrain(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D));

        new Meat(200, 500);
    }

}
