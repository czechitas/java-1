package net.sevecek.angrybirds.levels;

import net.sevecek.angrybirds.engine.*;
import static net.sevecek.angrybirds.engine.Direction.*;

public class Level04 extends AbstractLevel {

    GameBoard gameBoard;
    AngryBird bird;
    Pig pig;

    public void run() {
        // TODO: Sem vepiste program pro Angry birda
        // for (int pocitadlo = 0; pocitadlo < 666; pocitadlo++) {
        //     prikazy k opakovani, treba
        //     bird.turnLeft();
        // }
    }

    //-------------------------------------------------------------------------

    public Level04(GameBoard gb) {
        gameBoard = gb;
        bird = gameBoard.getBird();
        pig = gameBoard.getPig();
    }

    public void setupLevel() {
        gameBoard.reset();
        bird.setState(1, 3, RIGHT);
        pig.setPosition(6, 3);
        gameBoard.clearWalls();
        gameBoard.setWoodenWall(0, 2);
        gameBoard.setWoodenWall(1, 2);
        gameBoard.setWoodenWall(2, 2);
        gameBoard.setWoodenWall(3, 2);
        gameBoard.setWoodenWall(4, 2);
        gameBoard.setWoodenWall(5, 2);
        gameBoard.setWoodenWall(6, 2);
        gameBoard.setWoodenWall(7, 2);
        gameBoard.setWoodenWall(0, 3);
        gameBoard.setWoodenWall(7, 3);
        gameBoard.setWoodenWall(0, 4);
        gameBoard.setWoodenWall(1, 4);
        gameBoard.setWoodenWall(2, 4);
        gameBoard.setWoodenWall(3, 4);
        gameBoard.setWoodenWall(4, 4);
        gameBoard.setWoodenWall(5, 4);
        gameBoard.setWoodenWall(6, 4);
        gameBoard.setWoodenWall(7, 4);
        gameBoard.forceRepaint();
    }

    public String getInfo() {
        return "<html>Snažte se dostat prase jen pomocí 2 příkazů.<br>" +
                "Použijte cyklus 'for'</html>";
    }
}
