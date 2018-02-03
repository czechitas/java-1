using AngryBirds.Engine.Localization.en;

namespace AngryBirds.Engine.Interfaces
{
    public interface ICharacter
    {
        event CharacterHandler Moved;
        int PositionX { get; set; }
        int PositionY { get; set; }
        TurnType ActualTurn { get; set; }
        void MoveForward();
        void Turn(Direction direction);
    }
}