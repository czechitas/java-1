package cz.czechitas.angrybirds.levels;

import cz.czechitas.angrybirds.engine.*;
import static cz.czechitas.angrybirds.engine.Direction.*;

public class Level03 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // Program bude podobny jako minule
        // Pozor ale, angry bird je otoceny nahoru
    }

    //-------------------------------------------------------------------------

    public Level03(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(1, 5, UP);
        pig.setPosition(5, 2);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(0, 1);
        gameBoard.setWoodenWall(1, 1);
        gameBoard.setWoodenWall(2, 1);
        gameBoard.setWoodenWall(3, 1);
        gameBoard.setWoodenWall(4, 1);
        gameBoard.setWoodenWall(5, 1);
        gameBoard.setWoodenWall(6, 1);
        gameBoard.setWoodenWall(0, 2);
        gameBoard.setWoodenWall(1, 2);
        gameBoard.setWoodenWall(2, 2);
        gameBoard.setWoodenWall(6, 2);
        gameBoard.setWoodenWall(0, 3);
        gameBoard.setWoodenWall(1, 3);
        gameBoard.setWoodenWall(2, 3);
        gameBoard.setWoodenWall(4, 3);
        gameBoard.setWoodenWall(5, 3);
        gameBoard.setWoodenWall(6, 3);
        gameBoard.setWoodenWall(0, 4);
        gameBoard.setWoodenWall(1, 4);
        gameBoard.setWoodenWall(2, 4);
        gameBoard.setWoodenWall(4, 4);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(6, 4);
        gameBoard.setWoodenWall(0, 5);
        gameBoard.setWoodenWall(4, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(6, 5);
        gameBoard.setWoodenWall(0, 6);
        gameBoard.setWoodenWall(1, 6);
        gameBoard.setWoodenWall(2, 6);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(5, 6);
        gameBoard.setWoodenWall(6, 6);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "A ještě jednou pro procvičení. Zasáhněte prase!";
    }
}
