package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.engine.*;
import static cz.czechitas.angrybirds.engine.Direction.*;

public class Level08 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
    }

    //-------------------------------------------------------------------------

    public Level08(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(1, 6, RIGHT);
        pig.setPosition(6, 1);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(0, 7);
        gameBoard.setWoodenWall(1, 7);
        gameBoard.setWoodenWall(2, 7);
        gameBoard.setWoodenWall(3, 7);
        gameBoard.setWoodenWall(0, 6);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(0, 5);
        gameBoard.setWoodenWall(1, 5);
        gameBoard.setWoodenWall(4, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(0, 4);
        gameBoard.setWoodenWall(1, 4);
        gameBoard.setWoodenWall(2, 4);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(6, 4);
        gameBoard.setWoodenWall(0, 3);
        gameBoard.setWoodenWall(1, 3);
        gameBoard.setWoodenWall(2, 3);
        gameBoard.setWoodenWall(3, 3);
        gameBoard.setWoodenWall(6, 3);
        gameBoard.setWoodenWall(7, 3);
        gameBoard.setWoodenWall(0, 2);
        gameBoard.setWoodenWall(1, 2);
        gameBoard.setWoodenWall(2, 2);
        gameBoard.setWoodenWall(3, 2);
        gameBoard.setWoodenWall(4, 2);
        gameBoard.setWoodenWall(7, 2);
        gameBoard.setWoodenWall(0, 1);
        gameBoard.setWoodenWall(1, 1);
        gameBoard.setWoodenWall(2, 1);
        gameBoard.setWoodenWall(3, 1);
        gameBoard.setWoodenWall(4, 1);
        gameBoard.setWoodenWall(5, 1);
        gameBoard.setWoodenWall(7, 1);
        gameBoard.setWoodenWall(0, 0);
        gameBoard.setWoodenWall(1, 0);
        gameBoard.setWoodenWall(2, 0);
        gameBoard.setWoodenWall(3, 0);
        gameBoard.setWoodenWall(4, 0);
        gameBoard.setWoodenWall(5, 0);
        gameBoard.setWoodenWall(6, 0);
        gameBoard.setWoodenWall(7, 0);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se dostat prase pomocí maximálně<br>" +
                "5 příkazů.<br>" +
                "Použijte cyklus 'while'.</html>";
    }
}
