using AngryBirds.Engine.Interfaces;
using AngryBirds.Levels;

namespace AngryBirds.Engine.Localization
{
    public interface IUzivatelemDefinovanaHra : IGame
    {
        Level NactiLevel();

        void PoSpusteni();
    }
}