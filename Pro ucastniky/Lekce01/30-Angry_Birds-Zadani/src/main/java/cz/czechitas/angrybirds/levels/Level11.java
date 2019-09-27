package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.api.*;

import static cz.czechitas.angrybirds.api.Commands.*;

public class Level11 {

    void run() {
        // TODO: Sem vepiste program pro Reda

        // Prikazy k pouziti:
        // turnLeft();
        // turnRight();
        // moveForward();
        // while (notFinished()) {
        //     prikazy
        // }
    }

    //-------------------------------------------------------------------------

    void setupGameBoard() {
        Cell[][] cells = {
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.STONE_TRIANGLE, Cell.WOODEN_BOX},
            {Cell.GLASS_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.STONE_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.GLASS_TRIANGLE, Cell.WOODEN_BOX},
            {Cell.GLASS_TRIANGLE, Cell.WOODEN_BOX, Cell.GLASS_TRIANGLE, Cell.GLASS_TRIANGLE, Cell.STONE_BOX, Cell.STONE_BOX, Cell.STONE_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_TRIANGLE, Cell.STONE_TRIANGLE, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.STONE_BOX, Cell.STONE_BOX, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.STONE_TRIANGLE, Cell.GLASS_TRIANGLE, Cell.EMPTY, Cell.STONE_TRIANGLE, Cell.GLASS_TRIANGLE, Cell.WOODEN_BOX},
            {Cell.WOODEN_BOX, Cell.GLASS_TRIANGLE, Cell.EMPTY, Cell.EMPTY, Cell.EMPTY, Cell.STONE_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_TRIANGLE},
            {Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_TRIANGLE, Cell.STONE_TRIANGLE, Cell.GLASS_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.STONE_BOX},
            {Cell.STONE_BOX, Cell.WOODEN_TRIANGLE, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_BOX, Cell.WOODEN_TRIANGLE}
        };
        setGameBoardCells(cells);
        setGameBoardChallengeText("Dobře, ještě jednou pro procvičení - dokážete vyřešit tento úkol za použití pouze 4 příkazů s cyklem   while ()   ?");
        setGameBoardBirdPosition(2, 5, BirdOrientation.EAST);
        setGameBoardPigPosition(2, 3);
    }

}
