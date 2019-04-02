package cz.czechitas.angrybirds.api;

public class AngryBird {

    public AngryBird(int x, int y, BirdOrientation orientation) {
        Commands.setGameBoardBirdPosition(x, y, orientation);
    }

    public void moveForward() {
        Commands.moveForward();
    }

    public void turnLeft() {
        Commands.turnLeft();
    }

    public void turnRight() {
        Commands.turnRight();
    }

    public boolean isPathForward() {
        return Commands.isPathForward();
    }

    public boolean isPathLeft() {
        return Commands.isPathLeft();
    }

    public boolean isPathRight() {
        return Commands.isPathRight();
    }
}
