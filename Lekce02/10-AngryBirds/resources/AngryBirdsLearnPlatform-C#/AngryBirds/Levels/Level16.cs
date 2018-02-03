using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level16 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn180;

            GameBoard[6, 1] = FieldType.AngryBird;

            GameBoard[5, 1] = FieldType.Path;
            GameBoard[4, 1] = FieldType.Path;
            GameBoard[3, 1] = FieldType.Path;
            GameBoard[2, 1] = FieldType.Path;
            GameBoard[1, 1] = FieldType.Path;

            GameBoard[1, 2] = FieldType.Path;
            GameBoard[1, 3] = FieldType.Path;
            GameBoard[1, 4] = FieldType.Path;
            GameBoard[1, 5] = FieldType.Path;
            GameBoard[1, 6] = FieldType.Path;

            GameBoard[2, 6] = FieldType.Path;
            GameBoard[3, 6] = FieldType.Path;
            GameBoard[4, 6] = FieldType.Path;
            GameBoard[5, 6] = FieldType.Path;
            GameBoard[6, 6] = FieldType.Path;

            GameBoard[6, 5] = FieldType.Path;
            GameBoard[6, 4] = FieldType.Path;

            GameBoard[5, 4] = FieldType.Path;

            GameBoard[4, 4] = FieldType.Pig;
        }
    }
}