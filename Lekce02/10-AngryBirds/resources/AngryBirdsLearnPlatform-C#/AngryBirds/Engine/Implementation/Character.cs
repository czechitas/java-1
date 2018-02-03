using System;
using System.Threading;
using System.Windows;
using System.Windows.Threading;
using AngryBirds.Engine.Interfaces;
using AngryBirds.Engine.Localization.en;

namespace AngryBirds.Engine.Implementation
{
    public class Character : ICharacter
    {
        private readonly IGameBoard gameBoard;
        public event CharacterHandler Moved;

        public Character(IGameBoard gameBoard)
        {
            this.gameBoard = gameBoard;
        }

        public int PositionX { get; set; }
        public int PositionY { get; set; }

        TurnType ICharacter.ActualTurn { get; set; }
        
        public void MoveForward()
        {
            var field = gameBoard.NextField(this);
            if (field != FieldType.Path && field != FieldType.Pig)
            {
                throw new ApplicationException();
            }

            switch (((ICharacter)this).ActualTurn)
            {
                case TurnType.Turn0:
                    PositionX++;
                    break;
                case TurnType.Turn90:
                    PositionY--;
                    break;
                case TurnType.Turn180:
                    PositionX--;
                    break;
                case TurnType.Turn270:
                    PositionY++;
                    break;
            }
            FinishMove();
        }

        private void FinishMove()
        {
            Application.Current.Dispatcher.BeginInvoke(DispatcherPriority.Background, new Action(() => Moved?.Invoke(this)));
            Thread.Sleep(TimeSpan.FromMilliseconds(500));
        }
        
        public void Turn(Direction direction)
        {
            var thisAsICharacter = ((ICharacter) this);
            if (direction == Direction.Left)
            {
                if (thisAsICharacter.ActualTurn == TurnType.Turn270)
                {
                    thisAsICharacter.ActualTurn = TurnType.Turn0;
                }
                else
                {
                    thisAsICharacter.ActualTurn++;
                }
            }
            if (direction == Direction.Right)
            {
                if (thisAsICharacter.ActualTurn == TurnType.Turn0)
                {
                    thisAsICharacter.ActualTurn = TurnType.Turn270;
                }
                else
                {
                    thisAsICharacter.ActualTurn--;
                }
            }
            FinishMove();
        }
    }
}