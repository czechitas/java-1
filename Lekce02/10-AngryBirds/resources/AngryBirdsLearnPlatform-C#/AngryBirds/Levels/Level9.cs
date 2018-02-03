using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level9 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[2, 5] = FieldType.AngryBird;
            GameBoard[3, 5] = FieldType.Path;
            GameBoard[4, 5] = FieldType.Path;
            GameBoard[4, 4] = FieldType.Path;
            GameBoard[4, 3] = FieldType.Path;
            GameBoard[3, 3] = FieldType.Path;
            GameBoard[2, 3] = FieldType.Pig;
        }
    }
}