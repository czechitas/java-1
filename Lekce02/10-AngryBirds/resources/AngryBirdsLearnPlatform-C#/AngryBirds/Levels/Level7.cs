using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level7 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[4, 2] = FieldType.AngryBird;
            GameBoard[4, 3] = FieldType.Path;
            GameBoard[4, 4] = FieldType.Path;
            GameBoard[4, 5] = FieldType.Path;
            GameBoard[4, 6] = FieldType.Path;
            GameBoard[4, 7] = FieldType.Pig;
        }
    }
}