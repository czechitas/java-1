Angry birds C# learning platform
=========

This project is based on https://hourofcode.com, especially https://studio.code.org/hoc/1. This project helps students and people who want to try programming for the first time to learn in their native language (currently English and Czech. Feel free to add support for your language - translation pull requests will be highly appreciated)

From a programming point of view it is not an exampl of good code and definitely it is not clean code nor does not use best practices. The code was created specifically to ease the work for the students when using it to provide a clean syntax for them.

**What can students learn using this learning platform:**
* Creating programs in C#, composing function calls
* Cycles (for, while, do while, foreach)
* Conditions (if, switch)
* Writing custom functions

**The idea**
The students write their code only in one file. They create a class inherited from the Game class in the platform and implement IUserDefinedGame interface. This interface contains only two methods - LoadLevel() and Start(). Students then write their own code within these two methods. There are twenty levels waiting for them, from the simplest ones where they only need to go forward all the way to levels using "complex logic" and encouraging students to use their own methods.

**How it looks**
Here is an example of the solution for level 5:

    public class OurGame : Game, IUserDefinedGame
    {
        public Level LoadLevel()
        {
            return new Level5();
        }

        public void Start()
        {
            AngryBird.Turn(To.Right);
            AngryBird.MoveForward();
            AngryBird.Turn(To.Left);
            for (int i = 1; i <= 3; i++)
            {
                AngryBird.MoveForward();
            }
            AngryBird.Turn(To.Left);
            AngryBird.MoveForward();
        }
    }

Level 20:

    public class OurGame : Game, IUserDefinedGame
    {
        public Level LoadLevel()
        {
            return new Level20();
        }

        public void Start()
        {
            while (GameBoard.OnField(AngryBird) != FieldType.Pig)
            {
                if (IsPathForward())
                {
                    AngryBird.MoveForward();
                }
                else
                {
                    if (IsPathRight())
                    {
                        AngryBird.Turn(To.Right);
                    }
                    else
                    {
                        AngryBird.Turn(To.Left);
                    }
                }
            }
        }

        bool IsPathForward()
        {
            var nextField = GameBoard.NextField(AngryBird);
            return nextField == FieldType.Path || nextField == FieldType.Pig;
        }

        bool IsPathLeft()
        {
            AngryBird.Turn(To.Left);
            var isThereWay = IsPathForward();
            AngryBird.Turn(To.Right);
            return isThereWay;
        }

        bool IsPathRight()
        {
            AngryBird.Turn(To.Right);
            var isThereWay = IsPathForward();
            AngryBird.Turn(To.Left);
            return isThereWay;
        }
    }

And the same level, but in another language (Czech):

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

I know that's not a good idea to have a code in the national language, if it is not English :-). I personally dislike this practice. But while teaching people programming from scratch me and my colleagues often encountered some problems with using English. So if you need to teach people whose native language is not English and you do not want to deal with the language barrier while trying to explain the programming principles - give this platform a try and bring more people to programming a little bit easier :)

More levels will be added in the future. Please feel free to submit requests for translations into other languages 
