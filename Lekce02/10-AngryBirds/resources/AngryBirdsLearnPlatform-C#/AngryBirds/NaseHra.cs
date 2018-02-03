using AngryBirds.Engine.Localization;
using AngryBirds.Levels;

namespace AngryBirds
{
    public class NaseHra : Hra, IUzivatelemDefinovanaHra
    {
        public Level NactiLevel()
        {
            return new Level20();
        }

        public void PoSpusteni()
        {
            while (HraciPlocha.NaPolickuPod(AngryBird) != TypPolicka.Prase)
            {
                if (MuzeVpred())
                {
                    AngryBird.PosunoutVpred();
                }
                else
                {
                    if (JeCestaVPravo())
                    {
                        AngryBird.Otoc(Do.Prava);
                    }
                    else
                    {
                        AngryBird.Otoc(Do.Leva);
                    }
                }
            }
        }

        bool MuzeVpred()
        {
            var polickoPred = HraciPlocha.NaPolickuPred(AngryBird);
            return polickoPred == TypPolicka.Cesta || polickoPred == TypPolicka.Prase;
        }

        bool JeCestaVLevo()
        {
            AngryBird.Otoc(Do.Leva);
            var jeTamCesta = MuzeVpred();
            AngryBird.Otoc(Do.Prava);
            return jeTamCesta;
        }

        bool JeCestaVPravo()
        {
            AngryBird.Otoc(Do.Prava);
            var jeTamCesta = MuzeVpred();
            AngryBird.Otoc(Do.Leva);
            return jeTamCesta;
        }
    }
}