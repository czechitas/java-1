package net.sevecek.angrybirds.levels;

import net.sevecek.angrybirds.engine.*;
import static net.sevecek.angrybirds.engine.Direction.*;

public class Level02 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // Uz jste zkusili?
        // bird.turnLeft();
        // bird.turnRight();
        // bird.move();
    }

    //-------------------------------------------------------------------------

    public Level02(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(2, 3, RIGHT);
        pig.setPosition(4, 5);
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
        gameBoard.setWoodenWall(3, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(5, 6);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "Použijte příkazy jako bird.turnLeft();";
    }
}
