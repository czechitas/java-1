using System.Dynamic;
using System.Globalization;
using System.Threading;
using AngryBirds.Engine.Implementation;
using AngryBirds.Engine.Interfaces;

namespace AngryBirds.Engine.Localization
{
    public class Hra : IGame
    {
        private Game game;

        public Hra()
        {
            var gameBoard = new HraciPlocha();
            game = new Game { GameBoard = gameBoard, AngryBird = new Postava(gameBoard), Pig = new Postava(gameBoard)};
            Texts.Texts.Culture = CultureInfo.CreateSpecificCulture("cs-CZ");
        }
        
        public Postava AngryBird => (Postava)game.AngryBird;

        public Postava Prase => (Postava)game.Pig;

        public HraciPlocha HraciPlocha => (HraciPlocha)game.GameBoard;
        
        ICharacter IGame.AngryBird
        {
            get { return game.AngryBird; }
            set { game.AngryBird = value; }
        }

        IGameBoard IGame.GameBoard
        {
            get { return game.GameBoard; }
            set { game.GameBoard = value; }
        }

        ICharacter IGame.Pig
        {
            get { return game.Pig; }
            set { game.Pig = value; }
        }
    }
}