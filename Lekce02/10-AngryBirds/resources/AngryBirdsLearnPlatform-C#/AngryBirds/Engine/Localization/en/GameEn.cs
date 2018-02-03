using System.Dynamic;
using System.Globalization;
using System.Threading;
using AngryBirds.Engine.Implementation;
using AngryBirds.Engine.Interfaces;

namespace AngryBirds.Engine.Localization.en
{
    public class GameEn : IGame
    {
        private Game game;

        public GameEn()
        {
            var gameBoard = new GameBoard();
            game = new Game { GameBoard = gameBoard, AngryBird = new CharacterEn(gameBoard), Pig = new CharacterEn(gameBoard) };
            Texts.Texts.Culture = CultureInfo.CreateSpecificCulture("en-GB");
        }

        public CharacterEn AngryBird => (CharacterEn)game.AngryBird;

        public CharacterEn Pig => (CharacterEn)game.Pig;

        public GameBoard GameBoard
        {
            get { return (GameBoard)game.GameBoard; }
            set { game.GameBoard = value; }
        }

        ICharacter IGame.AngryBird
        {
            get
            {
                return ((IGame)game).AngryBird;
            }

            set
            {
                ((IGame)game).AngryBird = value;
            }
        }

        ICharacter IGame.Pig
        {
            get
            {
                return ((IGame)game).Pig;
            }

            set
            {
                ((IGame)game).Pig = value;
            }
        }

        IGameBoard IGame.GameBoard
        {
            get
            {
                return ((IGame)game).GameBoard;
            }

            set
            {
                ((IGame)game).GameBoard = value;
            }
        }
    }
}