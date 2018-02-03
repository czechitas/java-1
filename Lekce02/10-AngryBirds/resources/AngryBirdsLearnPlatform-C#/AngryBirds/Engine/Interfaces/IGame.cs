namespace AngryBirds.Engine.Interfaces
{
    public interface IGame
    {
        ICharacter AngryBird { get; set; }
        ICharacter Pig { get; set; }
        IGameBoard GameBoard { get; set; }
    }
}