using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level6 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[1, 4] = FieldType.AngryBird;
            GameBoard[2, 4] = FieldType.Path;
            GameBoard[3, 4] = FieldType.Path;
            GameBoard[4, 4] = FieldType.Path;
            GameBoard[5, 4] = FieldType.Path;
            GameBoard[6, 4] = FieldType.Pig;
        }
    }
}