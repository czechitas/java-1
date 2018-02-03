using AngryBirds.Engine.Interfaces;
using AngryBirds.Levels;

namespace AngryBirds.Engine.Localization
{
    class ConvertorToIUserDefinedGameCZ : IUserDefinedGame
    {
        private readonly IUzivatelemDefinovanaHra hra;

        public ConvertorToIUserDefinedGameCZ(IUzivatelemDefinovanaHra hra)
        {
            this.hra = hra;
        }

        public ICharacter AngryBird
        {
            get { return hra.AngryBird; }
            set { hra.AngryBird = value; }
        }

        public ICharacter Pig
        {
            get { return hra.Pig; }
            set { hra.AngryBird = value; }
        }

        public IGameBoard GameBoard
        {
            get { return hra.GameBoard; }
            set { hra.GameBoard = value; }
        }

        public Level LoadLevel()
        {
            return hra.NactiLevel();
        }

        public void Start()
        {
            hra.PoSpusteni();
        }
    }
}