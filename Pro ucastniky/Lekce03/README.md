Lekce 03
========

Žofka a parametrizované metody
------------------------------

### Videozáznam

Na YouTube se můžete podívat na [záznam z lekce](https://www.youtube.com/watch?v=M4LFfZ3EERI),
případně si prohlédnout [celý playlist](https://www.youtube.com/playlist?list=PLTCx5oiCrIJ70H8jF9FxPs15e3_m6su80).

Úkol - Metody s parametrem
--------------------------

### Část 1

Nejprve si okopírujte projekt **30-Turtle-Param_metody** na **40-Turtle-Param_ukol**.
Vymažte z něj všechny původní metody a ponechejte si jen prázdný `main(...)`.

Nyní vytvořte metody na kreslení základních tvarů (s pevnými velikostmi stran):
Rovnoramenného trojúhelníku, čtverce, obdelníku a kolečka.


### Část 2

Pro další práci bude třeba, aby základní tvary měly volitelné velikosti stran,
tedy aby se jejich velikost dala nastavit.
Připravíme metody tak, aby přijímaly vstupní parametr(y).
Pro zopakování je níže vidět ukázka metody **nakresliRovnostrannyTrojuhelnik()**,
která přijímá jako vstupní parametr **velikostStrany** typu **double**.
Navenek je potřeba metodu zavolat s nějakou
hodnotou, uvnitř metody se **velikostStrany** chová jako proměnná
(proto musí mít definovaný typ, např. **double**).

~~~Java
Turtle zofka;

public void main(String[] args) {
    zofka = new Turtle();

    zofka.setLocation(100.0, 100.0);
    // Volani metody, do ktere se preda hodnota 50.0
    nakresliRovnostrannyTrojuhelnik(50.0);

    zofka.setLocation(300.0, 100.0);
    // Volani metody, do ktere se preda hodnota 70.0
    nakresliRovnostrannyTrojuhelnik(70.0);
}

public void nakresliRovnostrannyTrojuhelnik(double velikostStrany) {
    // Zde lze používat proměnnou velikostStrany.
    // Jeji hodnota je takova, s jakou byla metoda zavolana
    // napr.
    zofka.move(velikostStrany);
    zofka.turnLeft(120.0);
    zofka.move(velikostStrany);
    zofka.turnLeft(120.0);
    zofka.move(velikostStrany);
    zofka.turnLeft(120.0);
}
~~~

Metoda může přijímat i více parametrů za sebou (oddělujeme čárkou):

~~~Java
Turtle zofka;

public void main(String[] args) {
    zofka = new Turtle();

    Color cervenaBarva;
    cervenaBarva = new Color(255, 0, 0);

    zofka.setLocation(100.0, 100.0);
    // Volani metody, do ktere se preda hodnota 50.0 a objekt, ktery je v promenne cervenaBarva
    nakresliBarevnyRovnostrannyTrojuhelnik(50.0, cervenaBarva);

    zofka.setLocation(300.0, 100.0);
    // Volani metody, do ktere se preda hodnota 70.0 a in-line vytvoreny objekt barvy
    nakresliBarevnyRovnostrannyTrojuhelnik(70.0, new Color(0, 127, 255));
}

public void nakresliBarevnyRovnostrannyTrojuhelnik(double velikostStrany, Color barvaCary) {
    // Zde lze používat proměnnou velikostStrany a barva:
    zofka.setPenColor(barvaCary);
    zofka.move(velikostStrany);
    zofka.turnLeft(120.0);
    zofka.move(velikostStrany);
    zofka.turnLeft(120.0);
    zofka.move(velikostStrany);
    zofka.turnLeft(120.0);
}
~~~

Vytvořte tedy parametrizované metody na kreslení
rovnoramenného trojuhelníku, čtverce, obdelníku a kolečka.
Metody by měly přijímat
jako vstupní parametr velikost strany (typu `double`).
V případě trojúhelníku ještě úhel mezi rameny.
V případě obdelníku budou nutné dva parametry (strana A, strana B).
V případě kolečka se bude předávat velikost kolečka
(zda to bude poloměr, průměr nebo nějaká jiná charakteristika, nechám na vás).

Pokud chcete, jako bonus můžou metody přijímat i barvu kreslení. Není to ale povinné.

Pokud byste chtěli vypočítat, jak má být dlouhá
třetí strana rovnoramenného trojúhelníku, pokud znáte délku ramene
a úhel mezi rameny,
ušetřím vás googlení analytické geometrie.
Zde je metoda, která délku třetí strany vypočítá.
V hodině jsme si neukazovali, jak vypadá metoda, která vrací nějaký výstup.
V tomto případě jde o kombinaci jak vstupních parametrů, tak výstupu.

~~~Java
public void main(String[] args) {
    double stranaC;

    stranaC = vypocitejDelkuTretiStrany(100.0, 90.0);
    System.out.println("Strana A je 100.0, strana B je 100.0, uhel mezi nimi je 90.0°.");
    System.out.println("Pak je strana C dlouha " + stranaC);
}

public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
    double tretiStrana;
    tretiStrana = Math.abs((velikostRamene
            * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0))
            * 2.0);
    return tretiStrana;
}
~~~



### Část 3

Pomocí výše odladěných metod nakreslete následující obrázky - zmrzlinu, sněhuláka a mašinku.

<img src="ukol03-zmrzlina.svg" width="100" />

<img src="ukol03-snehulak.svg" height="300" />

<img src="ukol03-lokomotiva.svg" height="150" />



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
