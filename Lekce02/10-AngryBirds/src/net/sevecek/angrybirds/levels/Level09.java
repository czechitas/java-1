package net.sevecek.angrybirds.levels;

import net.sevecek.angrybirds.engine.*;
import static net.sevecek.angrybirds.engine.Direction.*;

public class Level09 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // podminka muze byt i treba   bird.canMoveRight()   nebo   bird.canMoveLeft()
        // while (podminka) {
        //     objekt.prikaz();
        // }
        // if (podminka) {
        //     objekt.prikaz();
        // }
    }

    //-------------------------------------------------------------------------

    public Level09(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(5, 2, DOWN);
        pig.setPosition(3, 4);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(4, 1);
        gameBoard.setWoodenWall(5, 1);
        gameBoard.setWoodenWall(6, 1);
        gameBoard.setWoodenWall(4, 2);
        gameBoard.setWoodenWall(6, 2);
        gameBoard.setWoodenWall(4, 3);
        gameBoard.setWoodenWall(6, 3);
        gameBoard.setWoodenWall(4, 4);
        gameBoard.setWoodenWall(6, 4);
        gameBoard.setWoodenWall(4, 5);
        gameBoard.setWoodenWall(6, 5);
        gameBoard.setWoodenWall(6, 6);
        gameBoard.setWoodenWall(6, 7);
        gameBoard.setWoodenWall(5, 7);
        gameBoard.setWoodenWall(4, 7);
        gameBoard.setWoodenWall(3, 7);
        gameBoard.setWoodenWall(2, 7);
        gameBoard.setWoodenWall(1, 7);
        gameBoard.setWoodenWall(0, 7);
        gameBoard.setWoodenWall(0, 6);
        gameBoard.setWoodenWall(0, 5);
        gameBoard.setWoodenWall(0, 4);
        gameBoard.setWoodenWall(0, 3);
        gameBoard.setWoodenWall(1, 3);
        gameBoard.setWoodenWall(2, 3);
        gameBoard.setWoodenWall(3, 3);
        gameBoard.setWoodenWall(3, 5);
        gameBoard.setWoodenWall(2, 5);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se dostat prase pomocí maximálně 4 příkazů.<br/>" +
                "Použijte cyklus 'while'. Objekt bird nabízí metodu<br/>" +
                "canMoveRight(), která otestuje,<br/>" +
                "zda se může pohnout doprava o krok.</html>";
    };
}
