using AngryBirds.Levels;

namespace AngryBirds.Engine.Interfaces
{
    public interface IUserDefinedGame : IGame
    {
        Level LoadLevel();
        void Start();
    }
}