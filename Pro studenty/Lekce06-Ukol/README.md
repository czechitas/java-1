Lekce 06 - Úkol 05 - Vlastnosti
-------------------------------

Úkolem je naprogramovat třídu na práci s dnem, měsícem a rokem.
Podobná třída už existuje v Javě, ale my si ji ze cvičných důvodů napíšeme znovu.


### Část 1

Založte nový projekt, stejně jako v hodině:
**Create new project -> User Defined Template -> Java Console App**.
Nazvěte ho `Datum`,
uložte do `JAVATRAINING/Projects/Java-1/Lekce06/Datum`
a base package zvolte `cz.czechitas.kalendar`.

Vytvořte třídu `Datum` tak, aby měla následující složky:

~~~~
Datum
  |
  +-- int rok;
  |
  +-- int mesic;
  |
  +-- int den;
  |
  +-- public String toString()
~~~~

Naprogramujte `toString()` tak,
aby takováto metoda `main(...)` vypisovala následující výstup:

~~~~
public static void main(String[] args) {
    Datum dnesek = new Datum();
    dnesek.rok = 2018;
    dnesek.mesic = 11;
    dnesek.den = 9;
    System.out.println(dnesek);

    Datum letosniVanoce = new Datum();
    letosniVanoce.rok = 2018;
    letosniVanoce.mesic = 12;
    letosniVanoce.den = 24;
    System.out.println(letosniVanoce);

    Datum letosniSilvestr = new Datum();
    letosniSilvestr.rok = 2018;
    letosniSilvestr.mesic = 12;
    letosniSilvestr.den = 31;
    System.out.println(letosniSilvestr);

    if (letosniVanoce.mesic == letosniSilvestr.mesic) {
        System.out.println("Vanoce a Silvestr jsou ve stejnem mesici.");
    } else {
        System.out.println("Vanoce a Silvestr NEJSOU ve stejnem mesici.");
    }

    System.out.println();

    Datum nesmyslnyMesic = new Datum();
    nesmyslnyMesic.rok = 2020;
    nesmyslnyMesic.mesic = 13;
    nesmyslnyMesic.den = 11;
    System.out.println(nesmyslnyMesic);

    Datum nesmyslnyMesic2 = new Datum();
    nesmyslnyMesic2.rok = 2021;
    nesmyslnyMesic2.mesic = -1;
    nesmyslnyMesic2.den = 5;
    System.out.println(nesmyslnyMesic2);

    Datum nesmyslnyDen = new Datum();
    nesmyslnyDen.rok = 2022;
    nesmyslnyDen.mesic = 12;
    nesmyslnyDen.den = 40;
    System.out.println(nesmyslnyDen);

    Datum nesmyslnyDen2 = new Datum();
    nesmyslnyDen2.rok = 2023;
    nesmyslnyDen2.mesic = 3;
    nesmyslnyDen2.den = -2;
    System.out.println(nesmyslnyDen2);
}
~~~~

Výstup:
~~~~
Datum 24. 12. 2018
Datum 31. 12. 2018
Vanoce a Silvestr jsou ve stejnem mesici.

Datum 11. 13. 2020
Datum 5. -1. 2021
Datum 40. 12. 2022
Datum -2. 3. 2023
~~~~



### Část 2

Nelíbí se mi, že se do objektu typu Datum dá vložit neplatná
hodnota dne a měsíce. Řekněme, že platné hodnoty jsou:

- `rok` ....... libovolná hodnota
- `mesic` ..... 1 až 12
- `den` ....... 1 až 31 (vždy, bez ohledu na měsíc)

Přeprogramujte tedy třídu Datum tak, aby všechny proměnné
byly `private` a následně doprogramujte metody podle seznamu:

~~~~
Datum
  |
  +-- private int rok;
  |
  +-- private int mesic;
  |
  +-- private int den;
  |
  +-- public String toString()
  |
  +-- public void setRok(int novaHodnota)
  |
  +-- public void setMesic(int novaHodnota)
  |
  +-- public void setDen(int novaHodnota)
  |
  +-- public int getRok()
  |
  +-- public int getMesic()
  |
  +-- public int getDen()
  |
  +-- public String getNazevMesice()
~~~~

Pozor, settery musejí akceptovat jen platné hodnoty. Pokud se pokusíme vložit neplatnou hodnotu,
setter novou hodnotu neakceptuje a vypíše chybovou hlášku pomocí `System.out.println(...)`.

Pokud by metoda `main(...)` vypadala takto, mohl by výstup být následující:

~~~~
public static void main(String[] args) {
    Datum dnesek = new Datum();
    dnesek.setRok(2018);
    dnesek.setMesic(11);
    dnesek.setDen(9);
    System.out.println(dnesek);
    System.out.println("Mesic: " + dnesek.getNazevMesice());

    System.out.println();

    Datum letosniVanoce = new Datum();
    letosniVanoce.setRok(2018);
    letosniVanoce.setMesic(12);
    letosniVanoce.setDen(24);
    System.out.println(letosniVanoce);

    Datum letosniSilvestr = new Datum();
    letosniSilvestr.setRok(2018);
    letosniSilvestr.setMesic(12);
    letosniSilvestr.setDen(31);
    System.out.println(letosniSilvestr);

    if (letosniVanoce.getMesic() == letosniSilvestr.getMesic()) {
        System.out.println("Vanoce a Silvestr jsou ve stejnem mesici.");
    } else {
        System.out.println("Vanoce a Silvestr NEJSOU ve stejnem mesici.");
    }

    System.out.println();

    Datum nesmyslnyMesic = new Datum();
    nesmyslnyMesic.setRok(2020);
    nesmyslnyMesic.setMesic(13);
    nesmyslnyMesic.setDen(11);
    System.out.println(nesmyslnyMesic);

    Datum nesmyslnyMesic2 = new Datum();
    nesmyslnyMesic2.setRok(2021);
    nesmyslnyMesic2.setMesic(-1);
    nesmyslnyMesic2.setDen(5);
    System.out.println(nesmyslnyMesic2);

    Datum nesmyslnyDen = new Datum();
    nesmyslnyDen.setRok(2022);
    nesmyslnyDen.setMesic(12);
    nesmyslnyDen.setDen(40);
    System.out.println(nesmyslnyDen);

    Datum nesmyslnyDen2 = new Datum();
    nesmyslnyDen2.setRok(2023);
    nesmyslnyDen2.setMesic(3);
    nesmyslnyDen2.setDen(-2);
    System.out.println(nesmyslnyDen2);
}
~~~~

Výstup:
~~~~
Datum 9. listopad 2018
Mesic: listopad

Datum 24. prosinec 2018
Datum 31. prosinec 2018
Vanoce a Silvestr jsou ve stejnem mesici.

Neplatna hodnota mesice 13
Datum 11. NEPLATNY_MESIC_0 2020
Neplatna hodnota mesice -1
Datum 5. NEPLATNY_MESIC_0 2021
Neplatna hodnota dne 40
Datum 0. prosinec 2022
Neplatna hodnota dne -2
Datum 0. brezen 2023
~~~~

Všimněte si, že přibyla ještě metoda `getNazevMesice()`,
která vrací textovou reprezantaci místo čísla měsíce.

Také si všimněte, že se změnila metoda `toString()` tak, že se datum vypisuje
pěkně s českým názvem měsíce, nikoliv číslem.
Tedy nikoliv:
~~~~
Datum 24. 12. 2018
~~~~
Ale takto:
~~~~
Datum 24. prosinec 2018
~~~~



### Část 3

Naprogramujte ještě vlastnost `jeVPrestupnemRoce` typu `boolean`, která bude jen pro čtení.

#### Upřesnění
Vlastnost bude `true`, pokud je rok z datumu přestupný, jinak false. Pravidlo přestupnosti roku je jedno z následujících.
* Buď: Přestupný je každý rok dělitelný 4.
* Anebo: "[Přestupný rok je] každý rok, který je bezezbyku dělitelný čtyřmi, avšak s výjimkou celých století, která nejsou beze zbytku dělitelná 400."

  Zdroj: [Wikipedia](https://cs.wikipedia.org/wiki/P%C5%99estupn%C3%BD_rok)

  Takto definované pravidlo je složitější, berte to tedy jako bonusovou úlohu.


#### Jak na to
Do třídy `Datum` je třeba vytvořit metodu:

~~~~
Datum
  |
 ... (původní obsah vynechán)
  |
  +-- public boolean getJeVPrestupnemRoce()
~~~~

Pozor, nepřidávejte žádnou vnitřní proměnnou do třídy `Datum`. Lokální proměnné v metodě `getJeVPrestupnemRoce()`
samozřejmě používat můžete.

#### Výsledek
Všimněte si, že jsme takto vytvořili novou vlastnost bez toho, abychom přidávali vnitřní proměnnou.
Taková vlastnost se někdy nazývá *počítaná vlastnost* (calculated property).



### Část 4 (nepovinná)

Nakonec naprogramujte ještě vlastnost `pocetDniVMesici` typu `int`, která bude opět jen pro čtení.
Počet dní je přesně definován pro každý měsíc konstatně (leden ... 31, březen ... 31, duben ... 30, atd), s výjimkou února (february), který má buď 28 nebo 29 dní,
podle toho, zda je v přestupném roce či nikoliv. Ale to už je hračka, protože vlastnost `jeVPrestupnemRoce`
již máme z minula.


#### Jak na to
Do třídy `Datum` je třeba vytvořit metodu:

~~~~
Datum
  |
 ... (původní obsah vynechán)
  |
  +-- public int getPocetDniVMesici()
~~~~



### Výsledek
Pokud se vám vše podaří, budete mít třídu `Datum`, která má 3 privátní vnitřní proměnné (ale protože jsou privátní, tak to není důležité),
1 klasickou metodu `toString()` a 5 vlastností. Z toho 3 pro čtení i zápis a 2 jen pro čtení.
Všimněte si, že vlastnosti jsou jen myšlená věc na základě přítomnosti správně pojmenovaných metod (get a set).
Tyto gettery a settery se vlastně ani nepovažují za plnoprávné metody. Proto jsem výše napsal, že třída `Datum`
má jen 1 klasickou metodu (a je to `toString()`).



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
