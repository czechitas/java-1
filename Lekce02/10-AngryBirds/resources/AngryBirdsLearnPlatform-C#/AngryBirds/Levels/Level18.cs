using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level18 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[5, 6] = FieldType.AngryBird;

            GameBoard[6, 6] = FieldType.Path;

            GameBoard[6, 5] = FieldType.Path;
            GameBoard[6, 4] = FieldType.Path;
            GameBoard[6, 3] = FieldType.Path;

            GameBoard[5, 3] = FieldType.Path;
            GameBoard[4, 3] = FieldType.Path;
            GameBoard[3, 3] = FieldType.Path;
            GameBoard[2, 3] = FieldType.Path;
            GameBoard[1, 3] = FieldType.Path;

            GameBoard[2, 2] = FieldType.Path;
            GameBoard[3, 4] = FieldType.Path;
            GameBoard[3, 5] = FieldType.Path;

            GameBoard[0, 3] = FieldType.Pig;
        }
    }
}