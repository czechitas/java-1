package net.sevecek.angrybirds.levels;

import net.sevecek.angrybirds.engine.*;
import static net.sevecek.angrybirds.engine.Direction.*;

public class Level10 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // while (podminka) {
        //     objekt.prikaz();
        // }
        // if (podminka) {
        //     objekt.prikaz();
        // }
        //
        // "podminka" muze vypadat treba takto:
        //     bird.canMoveRight()
        //     bird.canMoveLeft()
        //     bird.canMoveForward()
    }

    //-------------------------------------------------------------------------

    public Level10(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(5, 6, UP);
        pig.setPosition(0, 3);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(0, 2);
        gameBoard.setWoodenWall(1, 2);
        gameBoard.setWoodenWall(1, 1);
        gameBoard.setWoodenWall(2, 1);
        gameBoard.setWoodenWall(3, 1);
        gameBoard.setWoodenWall(3, 2);
        gameBoard.setWoodenWall(4, 2);
        gameBoard.setWoodenWall(5, 2);
        gameBoard.setWoodenWall(6, 2);
        gameBoard.setWoodenWall(7, 2);
        gameBoard.setWoodenWall(7, 3);
        gameBoard.setWoodenWall(7, 4);
        gameBoard.setWoodenWall(7, 5);
        gameBoard.setWoodenWall(7, 6);
        gameBoard.setWoodenWall(7, 7);
        gameBoard.setWoodenWall(6, 7);
        gameBoard.setWoodenWall(5, 7);
        gameBoard.setWoodenWall(4, 7);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(4, 5);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(4, 4);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(2, 6);
        gameBoard.setWoodenWall(2, 5);
        gameBoard.setWoodenWall(2, 4);
        gameBoard.setWoodenWall(1, 4);
        gameBoard.setWoodenWall(0, 4);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se dostat prase pomocí maximálně 4 příkazů.<br>" +
                "Použijte cyklus 'while' a podmíněný příkaz 'if'.<br>" +
                "Objekt bird nabízí metodu canMoveLeft(),<br>" +
                "která otestuje, zda se může pohnout doleva o krok.</html>";
    }
}
