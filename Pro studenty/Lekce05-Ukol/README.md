Úkol 04 - Třídy a objekty
-------------------------

### Část 1

Založte nový projekt, stejně jako v hodině:
**Create new project -> User Defined Template -> Java Console App**.
Nazvěte ho `30-Model_automobilu`,
uložte do `JAVATRAINING/Projects/Java-1/Lekce05/30-Model_automobilu`
a base package zvolte `cz.czechitas.automobil`.

Vytvořte třídy `PalivovaNadrz`, `Motor`, `Automobil` tak,
aby měly následující složky:

~~~~
PalivovaNadrz
  |
  +-- double objemPaliva
  |
  +-- double maxKapacita
  |
  +-- public String toString()
~~~~

~~~~
Motor
  |
  +-- double prumernaSpotreba
  |
  +-- public String toString()
~~~~

~~~~
Automobil
  |
  +-- Motor motor
  |
  +-- PalivovaNadrz nadrz
  |
  +-- public String toString()
~~~~

Do každé třídy naprogramujte `toString()`,
podobně, jak jsme to dělali v hodině.

Pozor, aby `toString()` ve třídě `Automobil` zvládl vypsat
auto i když nebude mít osazený motor nebo nádrž (např. `motor == null`).

V metodě `main(...)` ve `SpousteciTrida` vytvořte
model **svého** automobilu a vyzkoušejte, že vám fungují správně metody
`toString()` u všech tříd.

Mohlo by to vypadat třeba takto:
~~~~
public static void main(String[] args) {
    Automobil modreAuto;
    modreAuto = new Automobil();
    System.out.println(modreAuto.toString());

    Motor osmivalcovyMotor = new Motor();
    osmivalcovyMotor.prumernaSpotreba = 5.0;

    PalivovaNadrz malaNadrz = new PalivovaNadrz();
    malaNadrz.maxKapacita = 55.0;

    Automobil cerveneAuto;
    cerveneAuto = new Automobil();
    cerveneAuto.motor = osmivalcovyMotor;
    cerveneAuto.nadrz = malaNadrz;
    System.out.println(cerveneAuto.toString());
}
~~~~
a výsledek by byl:
~~~~
Automobil []
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 0.0 litry paliva z maxima 55.0 litru]
~~~~




### Část 2

Do třídy `Automobil` navíc naprogramujte tyto složky:
~~~~
Automobil
  |
  +-- boolean jeNastartovany
  |
 ...
predchozi obsah
 ...
  |
  +-- public void nastartujSe()
  |
  +-- public void vypniSe()
~~~~

Metody `nastartujSe()` a `vypniSe()` budou "startovat" a "vypínat" automobil, t.j. nastavovat proměnnou
`jeNastartovany` na správnou hodnotu a vypíší o tom informaci.
Automobil je možno nastartovat jen v případě,
že má motor a nádrž.
Pokud kterákoliv část chybí (např. `motor == null`),
metoda `nastartujSe()` vypíše chybovou hlášku
(klasicky pomocí `System.out.println()`)
a automobil se nenastartuje (nenastaví proměnnou `jeNastartovany` na `true`).
Automobil není možno nastartovat dvakrát. Při takovém pokusu
se opět vypíše chybová hláška.
Automobil je možno vypnout vícekrát, ale opakované volání
metody `vypniSe()` se ignoruje.

V metodě `main(...)` ve `SpousteciTrida` doplňte
volání těchto metod. Vyzkoušejte, že vám fungují správně metody
`toString()` u všech tříd a že automobil jde nastartovat,
jen pokud je správně sestavený.

Pro zjednodušení se chovejme tam, že motor běžící naprázdno (na volnoběh) nespotřebovává žádné palivo.


Příklad metody `main(...)` Kamilova auta:
~~~~
public static void main(String[] args) {
    Automobil modreAuto;
    modreAuto = new Automobil();
    System.out.println(modreAuto.toString());
    modreAuto.nastartujSe();
    System.out.println(modreAuto.toString());

    Motor osmivalcovyMotor = new Motor();
    osmivalcovyMotor.prumernaSpotreba = 5.0;

    PalivovaNadrz malaNadrz = new PalivovaNadrz();
    malaNadrz.maxKapacita = 55.0;

    Automobil cerveneAuto;
    cerveneAuto = new Automobil();
    cerveneAuto.motor = osmivalcovyMotor;
    cerveneAuto.nastartujSe();
    System.out.println(cerveneAuto.toString());

    cerveneAuto.nadrz = malaNadrz;
    cerveneAuto.nastartujSe();
    System.out.println(cerveneAuto.toString());

    cerveneAuto.vypniSe();
    System.out.println(cerveneAuto.toString());
}
~~~~
a výsledek by byl:
~~~~
Automobil []
Automobilu chybi motor. Nelze ho nastartovat.
Automobil []
Automobilu chybi nadrz. Nelze ho nastartovat.
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. ]
Automobil se nastartoval.
Nastartovany automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 0.0 litry paliva z maxima 55.0 litru]
Automobil se vypnul.
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 0.0 litry paliva z maxima 55.0 litru]
~~~~

Nezapomeňte, že je úkolem vytvořit **model svého automobilu**.
Parametry vašeho automobilu budou pravděpodobně **jiné** než
Kamilova auta.



### Část 3

Vylepšete třídu `Automobil` o metodu:
~~~~
Automobil
  |
 ...
predchozi obsah
 ...
  |
  +-- public void natankuj(double objemTankovanehoPaliva)
~~~~

Metoda `natankuj(double objemTankovanehoPaliva)`
zvýší proměnnou `objemPaliva` v nádrži o `objemTankovanehoPaliva`.
Pokud by se tolik tankovaného paliva do nádrže nevešlo
(`objemTankovanehoPaliva > maxKapacita - objemPaliva`), metoda vypíše chybu a
`objemPaliva` se nebude měnit.
Pokud by v autě vůbec nebyla nádrž, metoda opět vypíše chybu.
Metoda navíc musí fungovat pouze, pokud není automobil nastartovaný.
Do nastartovaného automobilu se nesmí tankovat a v takovém případě musí metoda
vypsat chybu a nepřijmout tankované palivo.

Pozor, když už umíme automobil natankovat, je třeba, aby metoda `nastartujSe()` nastartovala automobil pouze, pokud je v nádrži alespoň nějaké množství paliva. Např. více než 0.01 litru.

Stále chápejme běh motoru naprázdno (na volnoběh) tak, že nespotřebovává žádné palivo. Tedy nějaké palivo v nádrži být musí, ale pokud auto nastartujeme, nebude žádné palivo ubývat.


Metoda `main(...)` by mohla vypadat například takto:
~~~~
public static void main(String[] args) {
    Automobil modreAuto;
    modreAuto = new Automobil();
    System.out.println(modreAuto.toString());
    modreAuto.nastartujSe();
    System.out.println(modreAuto.toString());

    Motor osmivalcovyMotor = new Motor();
    osmivalcovyMotor.prumernaSpotreba = 5.0;

    PalivovaNadrz malaNadrz = new PalivovaNadrz();
    malaNadrz.maxKapacita = 55.0;

    Automobil cerveneAuto;
    cerveneAuto = new Automobil();
    cerveneAuto.motor = osmivalcovyMotor;
    cerveneAuto.nastartujSe();
    System.out.println(cerveneAuto.toString());

    cerveneAuto.nadrz = malaNadrz;
    cerveneAuto.nastartujSe();
    System.out.println(cerveneAuto.toString());

    cerveneAuto.vypniSe();
    System.out.println(cerveneAuto.toString());

    cerveneAuto.nastartujSe();

    cerveneAuto.natankuj(33.0);
    cerveneAuto.nastartujSe();
    System.out.println(cerveneAuto.toString());

    cerveneAuto.vypniSe();
    cerveneAuto.natankuj(30.0);
    System.out.println(cerveneAuto.toString());

    cerveneAuto.nastartujSe();
    cerveneAuto.natankuj(20.0);
}
~~~~
a výsledek by byl:
~~~~
Automobil []
Automobilu chybi motor. Nelze ho nastartovat.
Automobil []
Automobilu chybi nadrz. Nelze ho nastartovat.
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. ]
Automobilu ma prazdnou nadrz. Nelze ho nastartovat.
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 0.0 litry paliva z maxima 55.0 litru]
Automobil je jiz vypnuty.
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 0.0 litry paliva z maxima 55.0 litru]
Automobilu ma prazdnou nadrz. Nelze ho nastartovat.
Natankovali jste 33.0 litru paliva.
Automobil se nastartoval.
Nastartovany automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 33.0 litry paliva z maxima 55.0 litru]
Automobil se vypnul.
Snazite se natankovat vice paliva (30.0 litru) nez se vejde do nadrze (22.0 litru).
Automobil [Motor: prumerna spotreba: 5.0 litru / 100 km. Nadrz naplnena 33.0 litry paliva z maxima 55.0 litru]
Automobil se nastartoval.
Automobil je nastartovany. Tankovat se musi s vypnutym motorem.
~~~~



### Část 4

Naprogramujte do třídy `Automobil` ještě metodu `odjedVzdalenost(double pocetKilometru)`.
Metoda sníží objem paliva v nádrži podle ujetých kilometrů.
Nezapomeňte, že průměrná spotřeba se počítá v litrech na 100 km.
Např. máte-li průměrnou spotřebu 5 litrů na 100 km a ujedete 150 km,
pak spotřebujete z nádrže 7.5 litrů paliva.

Odjet vzdálenost samozřejmě půjde pouze, pokud bude automobil nastartovaný a pokud bude mít dostatek paliva. V opačném případě vypište příslušnou chybovou hlášku a žádné palivo nespotřebovávejte.

Demonstrujte v `main(...)`, že se `odjedVzdalenost(...)` chová, jak má.



### Odevzdání domácího úkolu

Nejprve appku/appky zbavte přeložených spustitelných souborů.
Zařídíte to tak, že v IntelliJ IDEA vpravo zvolíte
Maven Projects -> Lifecycle -> Clean.
Úspěch se projeví tak, že v projektové složce zmizí
podsložka `target`.
Následně složku s projektem
zabalte pomocí 7-Zipu pod jménem `Ukol-CISLO-Vase_Jmeno.7z`.
(Případně lze použít prostý zip, například na Macu).
Takto vytvořený archív nahrajte na Google Drive do Odevzdávárny.

Pokud byste chtěli odevzdat revizi úkolu (např. po opravě),
zabalte ji a nahrajte ji na stejný Google Drive znovu,
jen tentokrát se jménem `Ukol-CISLO-Vase_Jmeno-verze2.7z`.

Termín odevzdání je dva dny před další lekcí, nejpozději 23:59.
Tedy pokud je další lekce ve čtvrtek, termín je úterý 23:59.
Pokud úkol nebo revizi odevzdáte později,
prosím pošlete svému opravujícímu kouči/lektorovi email nebo zprávu přes FB.