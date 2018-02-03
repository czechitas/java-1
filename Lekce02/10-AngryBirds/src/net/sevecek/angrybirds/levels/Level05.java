package net.sevecek.angrybirds.levels;

import net.sevecek.angrybirds.engine.*;
import static net.sevecek.angrybirds.engine.Direction.*;

public class Level05 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
    }

    //-------------------------------------------------------------------------

    public Level05(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(1, 6, RIGHT);
        pig.setPosition(6, 1);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(5, 0);
        gameBoard.setWoodenWall(6, 0);
        gameBoard.setWoodenWall(7, 0);
        gameBoard.setWoodenWall(5, 1);
        gameBoard.setWoodenWall(5, 2);
        gameBoard.setWoodenWall(5, 3);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(7, 1);
        gameBoard.setWoodenWall(7, 2);
        gameBoard.setWoodenWall(7, 3);
        gameBoard.setWoodenWall(7, 4);
        gameBoard.setWoodenWall(7, 5);
        gameBoard.setWoodenWall(7, 6);
        gameBoard.setWoodenWall(0, 5);
        gameBoard.setWoodenWall(1, 5);
        gameBoard.setWoodenWall(2, 5);
        gameBoard.setWoodenWall(3, 5);
        gameBoard.setWoodenWall(4, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(0, 7);
        gameBoard.setWoodenWall(1, 7);
        gameBoard.setWoodenWall(2, 7);
        gameBoard.setWoodenWall(3, 7);
        gameBoard.setWoodenWall(4, 7);
        gameBoard.setWoodenWall(5, 7);
        gameBoard.setWoodenWall(6, 7);
        gameBoard.setWoodenWall(7, 7);
        gameBoard.setWoodenWall(0, 6);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se dostat prase pomocí 2 cyklů.<br>" +
                "Použijte cyklus 'for'</html>";
    }
}
