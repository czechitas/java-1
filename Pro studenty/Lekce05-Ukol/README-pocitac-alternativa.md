Lekce 05 - Úkol 04 - Třídy a objekty
-------------------------------------

### Část 1

Založte nový projekt, stejně jako v hodině:
**Create new project -> User Defined Template -> Java Console App**.
Nazvěte ho `20-Model_pocitace`,
uložte do `JAVATRAINING/Projects/Java-1/Lekce05-Ukol/20-Model_pocitace`
a base package zvolte `cz.czechitas.pocitac`.

Vytvořte třídy `Disk`, `Pamet`, `Procesor`, `Pocitac` tak,
aby měly následující složky:

~~~~
Disk
  |
  +-- long kapacita;
  |
  +-- long vyuziteMisto;
  |
  +-- public String toString()
~~~~

~~~~
Pamet
  |
  +-- long kapacita;
  |
  +-- public String toString()
~~~~

~~~~
Procesor
  |
  +-- String vyrobce;
  |
  +-- long rychlost;
  |
  +-- public String toString()
~~~~

~~~~
Pocitac
  |
  +-- boolean jeZapnuty;
  |
  +-- Procesor cpu;
  |
  +-- Pamet ram;
  |
  +-- Disk pevnyDisk;
  |
  +-- public String toString()
  |
  +-- public void zapniSe()
  |
  +-- public void vypniSe()
~~~~

Do každé třídy naprogramujte `toString()`,
podobně, jak jsme to dělali v hodině.

Do třídy `Pocitac` navíc naprogramujte metody `zapniSe()` a `vypniSe()`,
které budou "zapínat" a "vypínat" počítač, t.j. nastavovat proměnnou
`jeZapnuty` na správnou hodnotu a vypíší o tom informaci (klasicky pomocí `System.out.println(...)`).
Počítač je možno zapnout jen v případě,
že má procesor, pamět i disk.
Pokud kterákoliv část chybí (např. `ram == null`),
metoda `zapniSe()` vypíše chybovou hlášku
(pomocí `System.out.println(...)`)
a počítač se nezapne (nenastaví proměnnou `jeZapnuty` na `true`).
Počítač není možno zapnout dvakrát. Při takovém pokusu
opět vypište chybovou hlášku.
Počítač je možno vypnout vícekrát, ale opakované volání
metody `vypniSe()` se ignoruje.

V metodě `main(...)` ve `SpousteciTrida` vytvořte
model **svého** počítače a vyzkoušejte, že vám fungují správně metody
`toString()` u všech tříd a že počítač jde zapnout,
jen pokud je správně sestavený.

Příklad metody `main(...)` Kamilova počítače:

~~~~
public static void main(String[] args) {
    Pocitac kamiluvLaptop;
    kamiluvLaptop = new Pocitac();
    System.out.println(kamiluvLaptop.toString());
    kamiluvLaptop.zapniSe();      // Vypise chybu, protoze pocitac
                                  // nema vsechny povinne soucasti

    Procesor kamiluvProcesor = new Procesor();
    kamiluvProcesor.rychlost = 3_600_000_000L;      // 3.6 GHz
    kamiluvProcesor.vyrobce = "Intel";

    Pamet kamilovaPamet = new Pamet();
    kamilovaPamet.kapacita = 32_000_000_000L;       // 32 GB

    Disk kamiluvDisk = new Disk();
    kamiluvDisk.kapacita = 150_000_000_000L;        // 150 GB

    kamiluvLaptop.cpu = kamiluvProcesor;
    kamiluvLaptop.ram = kamilovaPamet;
    kamiluvLaptop.pevnyDisk = kamiluvDisk;

    System.out.println(kamiluvLaptop.toString());

    kamiluvLaptop.zapniSe();
    kamiluvLaptop.zapniSe();      // Vypise chybu, protoze pocitac uz bezi
    System.out.println(kamiluvLaptop.toString());
    kamiluvLaptop.vypniSe();

    kamiluvLaptop.vypniSe();      // Nevypise chybu, ale nic neprovede,
    kamiluvLaptop.vypniSe();      // protoze pocitac je uz vypnuty
}
~~~~

Nezapomeňte, že je úkolem vytvořit **model svého počítače**.
Parametry vašeho počítače budou pravděpodobně **jiné** než
Kamilova počítače.

Poznámka: Číslo, které končí na `L` znamená, že jde o číslo
typu `long` a nikoliv `int`. Rozdíl je v rozsahu.
`int` pojme čísla od `-2147483648` do `+2147483647`,
což není dostatečné pro kapacitu harddisku ani paměti.
Proto použijte `long`, který zvládne čísla od
`-9223372036854775808` do `+9223372036854775807`.
To už je dostatečné na uchování libovolné současné kapacity harddisku.

Poznámka 2: V zápisu čísla lze kdekoliv mezi číslicemi napsat `_`.
Je to nepovinné a používá se to pro lepší čitelnost.



### Část 2

Vylepšete třídu `Pocitac` o metody:
~~~~
Pocitac
  |
 ...
predchozi obsah
 ...
  |
  +-- public void vytvorSouborOVelikosti(long velikost)
  |
  +-- public void vymazSouboryOVelikosti(long velikost)
~~~~

Metoda `vytvorSouborOVelikosti(long velikost)`
zvýší proměnnou `vyuziteMisto` o `velikost`.
Pokud by se už nově vytvářený soubor na disk nevešel
(`vyuziteMisto > kapacita`), metoda vypíše chybu a
`vyuziteMisto` se nebude měnit.
Metoda `vymazSouboryOVelikosti(long velikost)`
sníží proměnnou `vyuziteMisto` o `velikost`.
`vyuziteMisto` nemůže klesnout pod `0`.
Metody budou fungovat pouze, pokud je počítač zapnutý.

Demonstrujte v `main(...)`, že se metody chovají, jak mají.



### Část 3 - Nepovinná část

Tuto část nemusíte naprogramovat, a přesto vám bude úkol uznán jako splněný. Ale zkuste to :-)

Vylepšete třídu `Pocitac` o druhý disk:
~~~~
Pocitac
  |
 ...
predchozi obsah
 ...
  |
  +-- Disk druhyDisk
~~~~

Opravte metody `vytvorSouborOVelikosti(long velikost)`
a `vymazSouboryOVelikosti(long velikost)` tak,
aby nejprve zabíraly místo na prvním harddisku
a potom na druhém.
Teprve pokud se soubor nedá vytvořit ani na druhém
harddisku, vypíše metoda `vytvorSouborOVelikosti(long velikost)`
chybu.

Pozor, nezapomeňte, že by počítač měl fungovat jak při 2 osazených discích,
tak při i jen 1 osazeném disku (`druhyDisk == null`).

Demonstrujte v `main(...)`, že se metody chovají, jak mají.



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
