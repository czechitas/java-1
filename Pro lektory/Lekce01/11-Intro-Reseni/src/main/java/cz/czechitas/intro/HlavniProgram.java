package cz.czechitas.intro;

import cz.czechitas.intro.api.*;
import net.sevecek.util.*;

public class HlavniProgram {

    public void main(String[] args) {

        AngryRed rudak;

        rudak = new AngryRed(50, 50);

        new AngryMatilda(780, 450);

        new Tree(400, 50);


        for (int i=0; i<5; i++) {
            rudak.moveForward();
        }
        while (rudak.isPossibleToMoveForward()) {
            rudak.moveForward();
        }

    }

}
