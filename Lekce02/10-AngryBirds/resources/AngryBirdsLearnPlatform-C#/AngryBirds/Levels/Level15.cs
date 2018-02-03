using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level15 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[2, 2] = FieldType.AngryBird;
            GameBoard[3, 2] = FieldType.Path;
            GameBoard[4, 2] = FieldType.Path;
            GameBoard[5, 2] = FieldType.Path;
            GameBoard[5, 3] = FieldType.Path;
            GameBoard[5, 4] = FieldType.Path;
            GameBoard[5, 5] = FieldType.Path;
            GameBoard[5, 6] = FieldType.Path;
            GameBoard[4, 6] = FieldType.Path;
            GameBoard[3, 6] = FieldType.Path;
            GameBoard[2, 6] = FieldType.Path;
            GameBoard[6, 4] = FieldType.Path;
            GameBoard[1, 6] = FieldType.Pig;
        }
    }
}