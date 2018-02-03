using AngryBirds.Engine;
using AngryBirds.Engine.Implementation;
using AngryBirds.Engine.Interfaces;
using AngryBirds.Engine.Localization;
using AngryBirds.Engine.Localization.en;
using AngryBirds.Levels;

namespace AngryBirds
{
    public class OurGame : GameEn, IUserDefinedGame
    {
        public Level LoadLevel()
        {
            return new Level2();
        }

        public void Start()
        {
            while (GameBoard.OnField(AngryBird) != FieldType.Pig)
            {
                if (IsPathForward())
                {
                    AngryBird.MoveForward();
                }
                else
                {
                    if (IsPathRight())
                    {
                        AngryBird.Turn(To.Right);
                    }
                    else
                    {
                        AngryBird.Turn(To.Left);
                    }
                }
            }
        }

        bool IsPathForward()
        {
            var nextField = GameBoard.NextField(AngryBird);
            return nextField == FieldType.Path || nextField == FieldType.Pig;
        }

        bool IsPathLeft()
        {
            AngryBird.Turn(To.Left);
            var isThereWay = IsPathForward();
            AngryBird.Turn(To.Right);
            return isThereWay;
        }

        bool IsPathRight()
        {
            AngryBird.Turn(To.Right);
            var isThereWay = IsPathForward();
            AngryBird.Turn(To.Left);
            return isThereWay;
        }
    }
}