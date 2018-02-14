package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.engine.*;
import static cz.czechitas.angrybirds.engine.Direction.*;

public class Level06 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // Cyklus for je mozne vnorit do druheho cyklu
        // for (int pocitadlo1 = 0; pocitadlo1 < 333; pocitadlo1++) {
        //     for (int pocitadlo2 = 0; pocitadlo2 < 333; pocitadlo2++) {
        //         // prikazy
        //     }
        // }
    }

    //-------------------------------------------------------------------------

    public Level06(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(2, 3, UP);
        pig.setPosition(2, 5);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(1, 2);
        gameBoard.setWoodenWall(2, 2);
        gameBoard.setWoodenWall(3, 2);
        gameBoard.setWoodenWall(4, 2);
        gameBoard.setWoodenWall(5, 2);
        gameBoard.setWoodenWall(1, 3);
        gameBoard.setWoodenWall(5, 3);
        gameBoard.setWoodenWall(1, 4);
        gameBoard.setWoodenWall(2, 4);
        gameBoard.setWoodenWall(3, 4);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(1, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(1, 6);
        gameBoard.setWoodenWall(2, 6);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(5, 6);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "Snažte se dostat prase pomocí maximálně 4 příkazů";
    }
}
