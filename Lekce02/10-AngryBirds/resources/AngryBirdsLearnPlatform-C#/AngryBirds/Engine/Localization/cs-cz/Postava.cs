using AngryBirds.Engine.Implementation;
using AngryBirds.Engine.Interfaces;

namespace AngryBirds.Engine.Localization
{
    public class Postava : ICharacter
    {
        private ICharacter character;
        
        public Postava(IGameBoard gameBoard)
        {
            this.character = new Character(gameBoard);
        }
        public void Otoc(Do strana)
        {
            character.Turn((Direction)strana);
        }

        public void PosunoutVpred()
        {
            character.MoveForward();
        }

        event CharacterHandler ICharacter.Moved
        {
            add { character.Moved += value; }
            remove { character.Moved -= value; }
        }

        int ICharacter.PositionX
        {
            get { return character.PositionX; }
            set { character.PositionX = value; }
        }

        int ICharacter.PositionY
        {
            get { return character.PositionY; }
            set { character.PositionY = value; }
        }

        TurnType ICharacter.ActualTurn
        {
            get { return character.ActualTurn; }
            set { character.ActualTurn = value; }
        }

        void ICharacter.MoveForward()
        {
            character.MoveForward();
        }

        void ICharacter.Turn(Direction direction)
        {
            character.Turn(direction);
        }
    }
}