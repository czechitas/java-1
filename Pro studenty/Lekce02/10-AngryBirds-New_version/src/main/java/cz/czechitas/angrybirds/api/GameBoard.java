package cz.czechitas.angrybirds.api;

public class GameBoard {

    public GameBoard() {
    }

    public GameBoard(Cell[][] cells, String challengeText) {
        Commands.setGameBoardCells(cells);
        Commands.setGameBoardChallengeText(challengeText);
    }

    public void setCells(Cell[][] cells) {
        Commands.setGameBoardCells(cells);
    }

    public void setChallengeText(String text) {
        Commands.setGameBoardChallengeText(text);
    }

}
