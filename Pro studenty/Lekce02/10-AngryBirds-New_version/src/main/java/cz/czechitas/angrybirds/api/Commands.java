package cz.czechitas.angrybirds.api;

import cz.czechitas.angrybirds.engine.*;

public class Commands {

    private static Game game;

    public static void setGlobalGame(Game game) {
        Commands.game = game;
    }

    public static void moveForward() {
        game.moveBirdForward();
    }

    public static void turnLeft() {
        game.turnBirdLeft();
    }

    public static void turnRight() {
        game.turnBirdRight();
    }

    public static boolean isPathForward() {
        return game.isBirdPathForward();
    }

    public static boolean isPathLeft() {
        return game.isBirdPathLeft();
    }

    public static boolean isPathRight() {
        return game.isBirdPathRight();
    }

    public static boolean notFinished() {
        return game.notFinished();
    }

    public static void setGameBoardCells(Cell[][] cells) {
        game.setWalls(cells);
    }

    public static void setGameBoardChallengeText(String text) {
        game.setChallengeText(text);
    }

    public static void setGameBoardBirdPosition(int x, int y, BirdOrientation orientation) {
        game.setBirdPosition(x, y, orientation);
    }

    public static void setGameBoardPigPosition(int x, int y) {
        game.setPigPosition(x, y);
    }

}
