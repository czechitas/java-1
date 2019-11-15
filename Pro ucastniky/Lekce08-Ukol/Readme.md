Úkol 06 - Bankovní účty
-----------------------

Vyjděte z předpřipraveného projektu **60-Banka-Zadani**
zde: [Java-Training--Projects--Java-1--Lekce08-Ukol.zip](../../data/2019-podzim/java1/Java-Training--Projects--Java-1--Lekce08-Ukol.zip).



### Část 1

Vytvořte třídu `BeznyUcet` podle následujícího schématu:

~~~~
public class BeznyUcet
  |
  +-- private double zustatek
  |
  +-- public BeznyUcet(double pocatecniCastka)
  |
  +-- public double getZustatek()
  |
  +-- public boolean vyberPenize(double castka)
  |
  +-- public boolean vlozPenize(double castka)
~~~~

Poznámky ke třídě:

- `BeznyUcet` má 1 vnitřní proměnnou `zustatek`.

- Dále má 1 konstruktor (`public BeznyUcet(double pocatecniCastka)`), který přijímá počáteční hodnotu zůstatku.
    Tedy vlastně počáteční vklad.

- Metoda `getZustatek()` vrací hodnotu `zustatku`.

    Pozor: Nevypisuje nic na obrazovku. Je to opravdu jen *getter*.

- Metoda `vyberPenize(...)` odečte od zůstatku částku, která
    přijde jako vstupní parametr metody a vrátí `true`.

    Pokud by byla metod zavolána se zápornou částkou,
    vypište chybovou hlášku, neměňte zůstatek a vraťte `false`.

    V případě, že jen není dostatek peněz na účtu pro výběr,
    chybovou hlášku nevypisujte, ale zůstatek také neměňte
    a vraťte `false`.

- Metoda `vlozPenize(...)` k zůstatku peníze naopak přičte
    a vrátí `true`, což znamená, že se operace povedla.

    Ani tato metoda neakceptuje zápornou hodnotu částky.
    V případě záporné částky tedy vypište chybovou
    hlášku, zůstatek neměňte a vraťte `false`.


Abyste ověřili, že máte program správně,
odkomentujte ve třídě `SpousteciTrida` volání první metody
`tester1.otestujBeznyUcet()` a celou třídu `BeznyUcetTest`.
V případě, že bude vše fungovat správně, vypíše se:
~~~~
BeznyUcet: Vsechny testy jsou OK
~~~~



### Část 2

Rozšiřte třídu `BeznyUcet` o funkcionalitu *povoleného přečerpání účtu*
(tzv. *povolený debet* nebo *kontokorent*).

Se zůstatkem tedy bude možné jít do záporu, ale jen do určité výše.
Ta se dá nastavit v konstruktoru
`public BeznyUcet(double pocatecniCastka, double limitCerpani)`,
konkrétně parametr `limitCerpani`.
To znamená, že metoda `getZustatek()` může vracet záporné hodnoty.
Např. kdybychom vytvořili objekt `new BeznyUcet(1000.0, 5000.0)`,
pak by z něj šlo vybrat až 6000 korun a po výběru by byl zůstatek
-5000.

U účtů s povoleným přečerpáním je vhodné vědět i
použitelný zůstatek, což je součet *zůstatku* a *limitu precerpani*.
Pokud bychom např. vytvořili objekt `new BeznyUcet(800.0, 6000.0)`,
pak metoda `getZustatek()` by vracela **800** korun,
zatímco metoda `getPouzitelnyZustatek()` by vracela **6800** korun.
Opravte samozřejmě metodu `vyberPenize(...)` tak,
aby umožňovala jít *"do záporu"* až do výše povoleného *limitu
přečerpání*.

~~~~
public class BeznyUcet
  |
  +-- private double zustatek
  |
  +-- private double limitPrecerpani
  |
  +-- public BeznyUcet(double pocatecniCastka)
  |
  +-- public BeznyUcet(double pocatecniCastka, double pocatecniLimitPrecerpani)
  |
  +-- public double getZustatek()
  |
  +-- public double getLimitPrecerpani()
  |
  +-- public double getPouzitelnyZustatek()
  |
  +-- public boolean vyberPenize(double castka)
  |
  +-- public boolean vlozPenize(double castka)
~~~~

Abyste ověřili, že máte program správně,
odkomentujte ve třídě `SpousteciTrida` volání druhé metody
`tester2.otestujPovolenyDebet()` a celou třídu `PovolenyDebetTest`.
V případě, že bude vše fungovat správně, vypíše se:
~~~~
BeznyUcet + Precerpani: Vsechny testy jsou OK
~~~~



### Část 3 - Dobrovolná část

Tato část je dobrovolná.
Pokud by pro vás byl úkol už příliš rozsáhlý, smíte ji vynechat.
Nicméně je velmi doporučeno zpracovat i ji.

Vytvořte třídu `SporiciUcet`,
která bude představovat sesterskou třídu k `BeznyUcet`.
Nebude umožňovat jít do záporu (*povolené přečerpání účtu*),
ale naopak bude evidovat *úrokovou míru* (procenta) a umožní
jednou ročně bance vložit vypočtený úrok (peníze) na účet
pomocí metody `vypocitejRocniUrokAVlozHoNaUcet()`.
Metoda si sama vypočítá
úrok (peníze) z úrokové míry (procent). Pro zjednodušení tak, že se vezme
aktuální zůstatek a z něj se vypočítá úrok podle aktuální úrokové míry.
Např. pokud vytvoříme objekt `new SporiciUcet(1000.0, 0.05)`,
tedy s počátečním zůstatkem **1000** korun a úrokem **5%**,
po zavolání metody `vypocitejRocniUrokAVlozHoNaUcet()` bude zůstatek
roven **1050** korun.
Metoda `vypocitejRocniUrokAVlozHoNaUcet()` musí pro účely připsání
úroku použít metodu `vlozPenize(...)`.


~~~~
public class SporiciUcet
  |
  +-- private double zustatek
  |
  +-- private double urokovaMira
  |
  +-- public SporiciUcet(double pocatecniCastka)
  |
  +-- public SporiciUcet(double pocatecniCastka, double pocatecniUrokovaMira)
  |
  +-- public double getZustatek()
  |
  +-- public double getUrokovaMira()
  |
  +-- public boolean vlozPenize(double castka)
  |
  +-- public boolean vyberPenize(double castka)
  |
  +-- public void vypocitejRocniUrokAVlozHoNaUcet()
~~~~

Abyste ověřili, že máte program správně,
odkomentujte ve třídě `SpousteciTrida` volání třetí metody
`tester3.otestujSporiciUcet()` a celou třídu `SporiciUcetTest`.
V případě, že bude vše fungovat správně, vypíše se:
~~~~
SporiciUcet: Vsechny testy jsou OK
~~~~



### Testovací třídy

Metoda `main(...)` hotového programu by tedy měla vypadat takto:

~~~~
public static void main(String[] args) {
    BeznyUcetTest tester1 = new BeznyUcetTest();
    PovolenyDebetTest tester2 = new PovolenyDebetTest();
    SporiciUcetTest tester3 = new SporiciUcetTest();

    tester1.otestujBeznyUcet();
    tester2.otestujPovolenyDebet();
    tester3.otestujSporiciUcet();
}
~~~~

Pokud vám všechny testovací metody projdou, nakonec se 2x vypíše
`Vsechny testy jsou OK` (nebo 3x v případě splnění i nepovinné části).
Pak můžete úkol odevzdat.



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
