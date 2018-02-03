using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level13 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[1, 1] = FieldType.AngryBird;
            GameBoard[1, 2] = FieldType.Path;
            GameBoard[2, 2] = FieldType.Path;
            GameBoard[2, 3] = FieldType.Path;
            GameBoard[3, 3] = FieldType.Path;
            GameBoard[3, 4] = FieldType.Path;
            GameBoard[4, 4] = FieldType.Path;
            GameBoard[4, 5] = FieldType.Path;
            GameBoard[5, 5] = FieldType.Path;
            GameBoard[5, 6] = FieldType.Path;
            GameBoard[6, 6] = FieldType.Pig;
        }
    }
}