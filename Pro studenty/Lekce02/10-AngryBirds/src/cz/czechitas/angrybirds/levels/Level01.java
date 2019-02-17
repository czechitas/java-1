package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.engine.*;
import static cz.czechitas.angrybirds.engine.Direction.*;

public class Level01 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // Zkuste treba
        // bird.turnLeft();
        // bird.turnRight();
        // bird.move();
    }

    //-------------------------------------------------------------------------

    public Level01(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(2, 4, RIGHT);
        pig.setPosition(5, 4);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(1, 3);
        gameBoard.setWoodenWall(2, 3);
        gameBoard.setWoodenWall(3, 3);
        gameBoard.setWoodenWall(4, 3);
        gameBoard.setWoodenWall(5, 3);
        gameBoard.setWoodenWall(6, 3);
        gameBoard.setWoodenWall(1, 4);
        gameBoard.setWoodenWall(6, 4);
        gameBoard.setWoodenWall(1, 5);
        gameBoard.setWoodenWall(2, 5);
        gameBoard.setWoodenWall(3, 5);
        gameBoard.setWoodenWall(4, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(6, 5);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "Naprogramujte Angry birda, ať zasáhne prase!";
    }

}
