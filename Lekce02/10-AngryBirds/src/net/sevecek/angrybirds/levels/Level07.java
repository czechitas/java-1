package net.sevecek.angrybirds.levels;

import net.sevecek.angrybirds.engine.*;
import static net.sevecek.angrybirds.engine.Direction.*;

public class Level07 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // while (podminka) {
        //     prikazy k opakovani
        // }
        //
        // podminka muze byt treba   !gameBoard.birdGetsPig()
        //                              vykricnik znamena zapor (negace)
        // nebo                      bird.canMoveForward()
        // nebo treba                bird.getX() == 5
        // podminky se daji i skladat, treba:
        //                           bird.getX() > 0 && bird.getY() > 0
        //                                  && znamena spojku A
        //                                  || znamena spojku NEBO
    }

    //-------------------------------------------------------------------------

    public Level07(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(4, 2, DOWN);
        pig.setPosition(4, 5);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(3, 1);
        gameBoard.setWoodenWall(3, 2);
        gameBoard.setWoodenWall(3, 3);
        gameBoard.setWoodenWall(3, 4);
        gameBoard.setWoodenWall(3, 5);
        gameBoard.setWoodenWall(3, 6);
        gameBoard.setWoodenWall(4, 1);
        gameBoard.setWoodenWall(4, 6);
        gameBoard.setWoodenWall(5, 1);
        gameBoard.setWoodenWall(5, 2);
        gameBoard.setWoodenWall(5, 3);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(5, 5);
        gameBoard.setWoodenWall(5, 6);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se dostat prase pomocí maximálně 2 příkazů.<br>" +
                "Použijte cyklus 'while'.<br>" +
                "Objekt bird nabízí metodu canMoveForward(),<br>" +
                "která otestuje, zda se může pohnout dopředu o krok.</html>";
    }
}
