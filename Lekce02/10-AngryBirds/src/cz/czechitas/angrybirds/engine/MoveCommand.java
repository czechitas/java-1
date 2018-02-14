package cz.czechitas.angrybirds.engine;

public class MoveCommand extends AbstractCommand {

    private AngryBird character;

    public MoveCommand(AngryBird character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.uiMove();
    }
}
