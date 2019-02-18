package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.api.*;

import static cz.czechitas.angrybirds.api.Commands.*;

public class Level20 {

    void run() {
        // TODO: Sem vepiste program pro Reda

        while (notFinished()) {
            if (isPathForward()) {
                // ZDE doplnte prikaz
            } else {
                if (isPathRight()) {
                    // ZDE doplnte prikaz
                } else {
                    // ZDE doplnte prikaz
                }
            }
        }

        // Prikazy k pouziti:
        // turnLeft();
        // turnRight();
        // moveForward();
        // while (notFinished()) {
        //     prikazy
        // }
        // if (isPathRight()) {
        //     prikazy
        // } else {
        //     Jinak proved prikazy zde
        // }
        // if (isPathForward()) {
        //     prikazy
        // } else {
        //     Jinak proved prikazy zde
        // }
        // if (isPathLeft()) {
        //     prikazy
        // } else {
        //     Jinak proved prikazy zde
        // }
    }

    //-------------------------------------------------------------------------

    void setupGameBoard() {
        Cell[][] cells = {
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.EMPTY, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX}
        };
        setGameBoardCells(cells);
        setGameBoardChallengeText("Zvládnete vyřešit hádanku přidáním jen 3 příkazů (na místa s komentářem \"ZDE doplnte prikaz\")? Rychle! Prase se už šklebí!");
        setGameBoardBirdPosition(1, 6, BirdOrientation.EAST);
        setGameBoardPigPosition(2, 1);
    }

}
