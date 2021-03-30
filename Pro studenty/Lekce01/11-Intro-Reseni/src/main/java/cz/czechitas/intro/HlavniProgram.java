package cz.czechitas.intro;

import cz.czechitas.intro.api.*;
import net.sevecek.util.*;

public class HlavniProgram {

    public void main(String[] args) {
        new Stone(200, 150);

        Fish rybka;
        rybka = new Fish(50, 50);
        for (int i=0; i<4; i++) {
            rybka.moveForward(250);
            rybka.turnRight();
        }
    }

}
