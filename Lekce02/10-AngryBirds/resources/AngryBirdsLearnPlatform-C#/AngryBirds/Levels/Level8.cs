using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level8 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[2, 6] = FieldType.AngryBird;
            GameBoard[3, 6] = FieldType.Path;
            GameBoard[4, 6] = FieldType.Path;
            GameBoard[5, 6] = FieldType.Path;
            GameBoard[6, 6] = FieldType.Path;
            GameBoard[6, 5] = FieldType.Path;
            GameBoard[6, 4] = FieldType.Path;
            GameBoard[6, 3] = FieldType.Path;
            GameBoard[6, 2] = FieldType.Path;
            GameBoard[6, 1] = FieldType.Pig;
        }
    }
}