using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level1 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn270;
            GameBoard[3, 2] = FieldType.AngryBird;
            GameBoard[3, 3] = FieldType.Path;
            GameBoard[3, 4] = FieldType.Pig;
        }
    }
}