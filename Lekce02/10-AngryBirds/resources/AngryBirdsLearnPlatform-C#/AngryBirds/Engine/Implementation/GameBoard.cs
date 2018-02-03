using AngryBirds.Engine.Interfaces;
using AngryBirds.Engine.Localization;
using AngryBirds.Levels;

namespace AngryBirds.Engine.Implementation
{
    public class GameBoard : IGameBoard
    {
        public Level Level { get; set; }
        public FieldType NextField(ICharacter character)
        {
            int x = character.PositionX;
            int y = character.PositionY;
            switch (character.ActualTurn)
            {
                case TurnType.Turn0:
                    x++;
                    break;
                case TurnType.Turn90:
                    y--;
                    break;
                case TurnType.Turn180:
                    x--;
                    break;
                case TurnType.Turn270:
                    y++;
                    break;
            }

            if (x < 0 || x >= Level.BorderSize ||
                y < 0 || y >= Level.BorderSize)
            {
                return FieldType.Obstacle;
            }
            return Level.GameBoard[x, y];
        }

        public FieldType OnField(ICharacter character)
        {
            return Level.GameBoard[character.PositionX, character.PositionY];
        }
    }
}