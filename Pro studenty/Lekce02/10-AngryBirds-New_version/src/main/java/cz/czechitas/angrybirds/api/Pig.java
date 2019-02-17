package cz.czechitas.angrybirds.api;

import cz.czechitas.angrybirds.engine.*;

public class Pig {

    public Pig(int x, int y) {
        Commands.setGameBoardPigPosition(x, y);
    }

    public boolean notFinished() {
        return Commands.notFinished();
    }
}
