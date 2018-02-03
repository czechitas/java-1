using AngryBirds.Levels;

namespace AngryBirds.Engine.Interfaces
{
    public interface IGameBoard
    {
        Level Level { get; set; }
        FieldType NextField(ICharacter character);
        FieldType OnField(ICharacter character);
    }
}