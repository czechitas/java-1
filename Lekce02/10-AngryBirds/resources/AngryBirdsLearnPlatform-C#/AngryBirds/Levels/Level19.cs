using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level19 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[1, 2] = FieldType.AngryBird;

            GameBoard[2, 2] = FieldType.Path;
            GameBoard[3, 2] = FieldType.Path;
            GameBoard[4, 2] = FieldType.Path;
            GameBoard[5, 2] = FieldType.Path;
            GameBoard[6, 2] = FieldType.Path;

            GameBoard[6, 3] = FieldType.Path;
            GameBoard[6, 4] = FieldType.Path;
            GameBoard[6, 5] = FieldType.Path;
            GameBoard[6, 6] = FieldType.Path;

            GameBoard[5, 6] = FieldType.Path;
            GameBoard[4, 6] = FieldType.Path;
            GameBoard[3, 6] = FieldType.Path;


            GameBoard[1, 6] = FieldType.Path;
            GameBoard[2, 5] = FieldType.Path;
            GameBoard[5, 5] = FieldType.Path;
            GameBoard[2, 3] = FieldType.Path;
            GameBoard[4, 1] = FieldType.Path;

            GameBoard[2, 6] = FieldType.Pig;
        }
    }
}