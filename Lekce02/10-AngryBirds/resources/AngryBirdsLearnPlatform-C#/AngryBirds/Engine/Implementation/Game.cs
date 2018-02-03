using System;
using System.Windows;
using System.Windows.Threading;
using AngryBirds.Engine.Interfaces;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Engine.Implementation
{
    public class Game : IGame
    {
        public Game()
        {
            GameBoard = new GameBoard();
            AngryBird = new Character(GameBoard);
            Pig = new Character(GameBoard);
        }

        public ICharacter AngryBird { get; set; }
        public ICharacter Pig { get; set; }

        public IGameBoard GameBoard { get; set; }
    }
}