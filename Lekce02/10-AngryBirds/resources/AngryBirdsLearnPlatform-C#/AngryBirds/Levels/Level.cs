using AngryBirds.Engine;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Levels
{
    public abstract class Level
    {
        public static int BorderSize = 8;
        public FieldType[,] GameBoard { get; set; }

        public TurnType AngryBirdTurn { get; set; }

        protected Level()
        {
            GameBoard = new FieldType[BorderSize, BorderSize];
            for (int x = 0; x < Level.BorderSize; x++)
            {
                for (int y = 0; y < Level.BorderSize; y++)
                {
                    GameBoard[x, y] = FieldType.Obstacle;
                }
            }
            InitBoard();
        }

        protected abstract void InitBoard();
    }
}