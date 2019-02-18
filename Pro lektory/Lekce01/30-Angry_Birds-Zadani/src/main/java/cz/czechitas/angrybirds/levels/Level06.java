package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.api.*;

import static cz.czechitas.angrybirds.api.Commands.*;

public class Level06 {

    void run() {
        // TODO: Sem vepiste program pro Reda

        // Priklad pouziti cyklu:
        for (int count = 0; count < 4; count++) {
            // Jakekoliv prikazy z minula, napriklad:
            turnLeft();
        }


        // Prikazy k pouziti:
        // turnLeft();
        // turnRight();
        // moveForward();
        // for (int count = 0; count < 3; count++) {
        //     prikazy
        // }
    }

    //-------------------------------------------------------------------------

    void setupGameBoard() {
        Cell[][] cells = {
            {Cell.STONE_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_TRIANGLE, Cell.WOODEN_BOX, Cell.STONE_BOX, Cell.STONE_BOX, Cell.STONE_TRIANGLE, Cell.GLASS_TRIANGLE},
            {Cell.WOODEN_BOX, Cell.WOODEN_TRIANGLE, Cell.WOODEN_BOX, Cell.STONE_TRIANGLE, Cell.STONE_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.GLASS_TRIANGLE, Cell.STONE_TRIANGLE, Cell.WOODEN_TRIANGLE, Cell.STONE_BOX, Cell.WOODEN_TRIANGLE, Cell.WOODEN_TRIANGLE, Cell.STONE_BOX},
            {Cell.WOODEN_TRIANGLE, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.GLASS_TRIANGLE},
            {Cell.WOODEN_BOX, Cell.STONE_TRIANGLE, Cell.STONE_BOX, Cell.STONE_TRIANGLE, Cell.STONE_BOX, Cell.STONE_BOX, Cell.STONE_TRIANGLE, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.STONE_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX},
            {Cell.STONE_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.STONE_TRIANGLE, Cell.WOODEN_BOX, Cell.STONE_BOX, Cell.STONE_BOX, Cell.WOODEN_BOX}
        };
        setGameBoardCells(cells);
        setGameBoardChallengeText("Existuje způsob, jak se mohu dostat k zelenému praseti za použití pouze 2 příkazů. Přijdete na něj?");
        setGameBoardBirdPosition(1, 4, BirdOrientation.EAST);
        setGameBoardPigPosition(6, 4);
    }

}
