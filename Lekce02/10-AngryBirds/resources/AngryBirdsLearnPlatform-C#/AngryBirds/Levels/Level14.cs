using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level14 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[3, 6] = FieldType.AngryBird;
            GameBoard[4, 6] = FieldType.Path;
            GameBoard[5, 6] = FieldType.Path;
            GameBoard[5, 5] = FieldType.Path;
            GameBoard[5, 4] = FieldType.Path;
            GameBoard[5, 3] = FieldType.Path;
            GameBoard[5, 2] = FieldType.Path;
            GameBoard[5, 1] = FieldType.Pig;
        }
    }
}