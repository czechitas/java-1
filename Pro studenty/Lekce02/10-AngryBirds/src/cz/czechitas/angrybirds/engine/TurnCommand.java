package cz.czechitas.angrybirds.engine;

public class TurnCommand extends AbstractCommand {

    private AngryBird angryBird;
    private TurnDirection turnDirection;

    public TurnCommand(AngryBird angryBird, TurnDirection turnDirection) {
        this.angryBird = angryBird;
        this.turnDirection = turnDirection;
    }

    @Override
    protected void execute() {
        angryBird.uiTurn(turnDirection);
    }
}
