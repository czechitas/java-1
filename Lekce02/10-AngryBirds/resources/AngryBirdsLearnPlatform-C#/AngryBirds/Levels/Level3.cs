using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    class Level3 : Level
    {
        protected override void InitBoard()
        {
            AngryBirdTurn = TurnType.Turn0;
            GameBoard[2, 3] = FieldType.AngryBird;
            GameBoard[3, 3] = FieldType.Path;
            GameBoard[4, 3] = FieldType.Path;
            GameBoard[4, 4] = FieldType.Pig;
        }
    }
}