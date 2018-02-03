using AngryBirds.Engine.Implementation;

namespace AngryBirds.Engine.Localization
{
    public class HraciPlocha : GameBoard
    {
        public TypPolicka NaPolickuPod(Postava postava)
        {
            return (TypPolicka)OnField(postava);
        }

        public TypPolicka NaPolickuPred(Postava postava)
        {
            return (TypPolicka)NextField(postava);
        }
    }
}