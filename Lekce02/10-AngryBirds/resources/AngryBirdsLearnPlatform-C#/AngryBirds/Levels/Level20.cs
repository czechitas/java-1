using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level20 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn90;
            GameBoard[1, 6] = FieldType.AngryBird;

            GameBoard[1, 5] = FieldType.Path;
            GameBoard[1, 4] = FieldType.Path;

            GameBoard[2, 4] = FieldType.Path;
            GameBoard[3, 4] = FieldType.Path;

            GameBoard[3, 5] = FieldType.Path;

            GameBoard[4, 5] = FieldType.Path;
            GameBoard[5, 5] = FieldType.Path;

            GameBoard[5, 4] = FieldType.Path;
            GameBoard[5, 3] = FieldType.Path;
            GameBoard[5, 2] = FieldType.Path;

            GameBoard[4, 2] = FieldType.Path;
            GameBoard[3, 2] = FieldType.Path;
            GameBoard[2, 2] = FieldType.Path;

            GameBoard[2, 1] = FieldType.Pig;
        }
    }
}