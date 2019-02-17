package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.engine.*;

import static cz.czechitas.angrybirds.engine.Direction.*;

public class Level11 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda

        // Muzete vyuzit
        //        bird.turnLeft();
        //        bird.turnRight();
        //        bird.move();
        //        if (bird.canMoveForward()) {
        //            objekt.prikaz();
        //        } else {
        //            objekt.prikaz();
        //        }
        //        while (!gameBoard.birdGetsPig()) {
        //            objekt.prikaz();
        //        }
    }

    //-------------------------------------------------------------------------

    public Level11(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(1, 6, DOWN);
        pig.setPosition(2, 1);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(0, 7);
        gameBoard.setWoodenWall(0, 6);
        gameBoard.setWoodenWall(0, 5);
        gameBoard.setWoodenWall(0, 4);
        gameBoard.setWoodenWall(0, 3);
        gameBoard.setWoodenWall(1, 3);
        gameBoard.setWoodenWall(2, 3);
        gameBoard.setWoodenWall(3, 3);
        gameBoard.setWoodenWall(4, 3);
        gameBoard.setWoodenWall(4, 4);
        gameBoard.setWoodenWall(1, 7);
        gameBoard.setWoodenWall(2, 7);
        gameBoard.setWoodenWall(2, 6);
        gameBoard.setWoodenWall(2, 5);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(5, 6);
        gameBoard.setWoodenWall(6, 6);
        gameBoard.setWoodenWall(7, 6);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(5, 3);
        gameBoard.setWoodenWall(7, 5);
        gameBoard.setWoodenWall(7, 4);
        gameBoard.setWoodenWall(7, 3);
        gameBoard.setWoodenWall(7, 2);
        gameBoard.setWoodenWall(7, 1);
        gameBoard.setWoodenWall(6, 1);
        gameBoard.setWoodenWall(5, 1);
        gameBoard.setWoodenWall(4, 1);
        gameBoard.setWoodenWall(3, 1);
        gameBoard.setWoodenWall(3, 0);
        gameBoard.setWoodenWall(2, 0);
        gameBoard.setWoodenWall(1, 0);
        gameBoard.setWoodenWall(1, 1);
        gameBoard.setWoodenWall(1, 2);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se napsat co nejobecnější program,<br>" +
                "který dokáže dostat prase v obecném bludišti.</html>";
    }

    ;
}
