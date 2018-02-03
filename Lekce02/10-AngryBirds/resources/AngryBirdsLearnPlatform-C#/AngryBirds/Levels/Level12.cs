using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level12 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[0, 7] = FieldType.AngryBird;
            GameBoard[1, 7] = FieldType.Path;
            GameBoard[1, 6] = FieldType.Path;
            GameBoard[2, 6] = FieldType.Path;
            GameBoard[2, 5] = FieldType.Path;
            GameBoard[3, 5] = FieldType.Path;
            GameBoard[3, 4] = FieldType.Path;
            GameBoard[4, 4] = FieldType.Path;
            GameBoard[4, 3] = FieldType.Path;
            GameBoard[5, 3] = FieldType.Path;
            GameBoard[5, 2] = FieldType.Path;
            GameBoard[6, 2] = FieldType.Path;
            GameBoard[6, 1] = FieldType.Pig;
        }
    }
}