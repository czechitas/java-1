package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.api.*;

public class Level01 {

    AngryBird red;
    Pig minionPig;

    public void run() {
        // TODO: Sem vepiste program pro ptaka (red)
/*
        red.turnLeft();
        red.turnRight();
        red.moveForward();

        while (minionPig.notFinished()) {
            // Opakuj prikazy zde
            red.moveForward();
        }

        if (red.isPathForward()) {
            // Proved prikazy zde
        } else {
            // Jinak proved prikazy zde
        }

        if (red.isPathLeft()) {

        }
        if (red.isPathRight()) {

        }
*/
        red.moveForward();
        red.moveForward();
    }

    //-------------------------------------------------------------------------

    public void setupGameBoard() {
        GameBoard gameboard;
        Cell[][] cells = {
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
                {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX}
        };
        gameboard = new GameBoard();
        gameboard.setCells(cells);
        gameboard.setChallengeText("Pomůžeš mi chytit zatracené prase?\nNaprogramuj Redovi v editoru několik příkazů pro pohyb:\n\n    red.moveForward();\n\nPak stiskni \"Start\".");
        red = new AngryBird(3, 2, BirdOrientation.SOUTH);
        minionPig = new Pig(3, 4);
    }

}
