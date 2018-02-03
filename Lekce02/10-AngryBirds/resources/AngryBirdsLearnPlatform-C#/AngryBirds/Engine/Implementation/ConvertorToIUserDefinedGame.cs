using AngryBirds.Engine.Interfaces;
using AngryBirds.Engine.Localization;

namespace AngryBirds.Engine.Implementation
{
    static class ConvertorToIUserDefinedGame
    {
        public static IUserDefinedGame Convert(IUserDefinedGame item)
        {
            return item;
        }

        public static IUserDefinedGame Convert(IUzivatelemDefinovanaHra item)
        {
            return new ConvertorToIUserDefinedGameCZ(item);
        }
    }
}