Cil lekce:
---------
Samostatne psat cykly a podminky v Jave
Instanciovat objekty z existujicich trid
Volat metody na objektech
Umet si rozlozit program do podprogramu (prozatim static metody)


Priklady:
--------

Bludiste AngryBirds - 11 levelu zalozenych na Hour of code (code.org)
Algoritmizaci (cykly a podminky) prekvapive zvladaji i bezni lide,
takze jde spis o to zvyknout si, ze promenne muzou byt nejen
int
double
String
ale i Bird, Pig nebo Gameboard.


Zelva Zofka - Kresleni pomoci zelvy. Inspirovano podobnym programovacim prostredim na Zbrojovacku, ktere samo bylo inspirovano jazykem MiniLogo a Logo.
Zde je super, ze zacinaji uz uplne od nuly - od public static void main(String[] args) a napisi:
new Turtle() a ona se jim zobrazi zelva.

Poznamka:
2 a vice zelvicek
Muzete zkusit i udelat znovu new Turtle() a zobrazi se 2 zelvy.
Pokud by se holky ptaly, jestli by slo udelat, aby kreslily zelvy zaraz a ne po sobe, muzete jim ukazat vlakna (necht si to nepisi, jen se divaji).
Turtle framework je thread-safe i ve vztahu ke Swingu.

    public static void main(String[] args) {
        ExecutorService spoustec = Executors.newCachedThreadPool();
        spoustec.execute(SpousteciTrida::prvniZelva);
        spoustec.execute(SpousteciTrida::druhaZelva);
    }

    public static void prvniZelva() {
    }

    public static void druhaZelva() {
    }

