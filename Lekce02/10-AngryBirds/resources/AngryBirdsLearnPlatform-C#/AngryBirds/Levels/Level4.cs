using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level4 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[2, 4] = FieldType.AngryBird;
            GameBoard[3, 4] = FieldType.Path;
            GameBoard[3, 3] = FieldType.Path;
            GameBoard[4, 3] = FieldType.Pig;
        }
    }
}