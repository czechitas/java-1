Lekce 03
========

Metody II a želva Žofka
-----------------------

### Osnova

1. Ladění programu, krokování
1. Refaktoring želvy, aby se nepoužívalo klíčové slovo static
1. Kreslení pozdravu
1. Metoda vracející hodnotu (náhodnou barvu)

### Videozáznam

Na YouTube se můžete podívat na [záznam z lekce](https://www.youtube.com/watch?v=yUa4Aq46DQI),
případně si prohlédnout [celý playlist](https://www.youtube.com/playlist?list=PLUVJxzuCt9AROpKl3Hu-DvdgQV-xHaoQY).

Úkol - Metody se vstupními hodnotami
------------------------------------

### Část 1

Nejprve vytvořte metody na kreslení základních tvarů: Rovnoramenného trojúhelníku, čtverce, obdelníku a kolečka.

### Část 2

Budeme potřebovat, aby základní tvary neměly velikosti stran napevno, ale aby se jejich velikost dala nastavit. Upravíme
metody tak, aby přijímaly tzv. vstupní parametry. Níže je vidět ukázka metody **nakresliRovnostrannyTrojuhelnik()**,
která přijímá jako vstupní parametr **velikostStrany** typu **double**. Navenek je potřeba metodu zavolat s nějakou
hodnotou, uvnitř metody se **velikostStrany** chová jako proměnná (proto musí mít definovaný typ, např. **double**).

    public void run() {
        zofka.setLocation(100.0, 100.0);
        // Volani metody, do ktere se preda hodnota 10
        nakresliRovnostrannyTrojuhelnik(50.0);
        zofka.setLocation(300.0, 100.0);
        // Volani metody, do ktere se preda hodnota 15
        nakresliRovnostrannyTrojuhelnik(70.0);
    }

    public void nakresliRovnostrannyTrojuhelnik(double velikostStrany) {
        // Zde lze používat proměnnou velikostStrany.
        // Jeji hodnota je podle toho, jak byla metoda zavolana
        // napr.
        zofka.move(velikostStrany);
        zofka.turnLeft(120.0);
        zofka.move(velikostStrany);
        zofka.turnLeft(120.0);
        zofka.move(velikostStrany);
        zofka.turnLeft(120.0);
    }

Metoda může přijímat i více parametrů za sebou (oddělujeme čárkou):

    public void run() {
        Color cervenaBarva;
        cervenaBarva = new Color(255, 0, 0);

        zofka.setLocation(100.0, 100.0);
        // Volani metody, do ktere se preda hodnota 10 a objekt, ktery je v promenne cervenaBarva
        nakresliBarevnyRovnostrannyTrojuhelnik(50.0, cervenaBarva);

        zofka.setLocation(300.0, 100.0);
        // Volani metody, do ktere se preda hodnota 15 a nove vytvoreny objekt barvy
        nakresliBarevnyRovnostrannyTrojuhelnik(70.0, new Color(0, 0, 255));
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

Parametrizujte metody na kreslení rovnoramenného trojuhelníku, čtverce, obdelníku a kolečka. Metody by měly přijímat
jako vstupní parametr velikost strany (typu double). V případě trojúhelníku ještě úhel mezi rameny. V případě obdelníku
budou nutné dva parametry (strana A, strana B). V případě kolečka se bude předávat velikost kolečka (způsob nechám na
vás).

Pokud chcete, jako bonus můžou metody přijímat i barvu kreslení. Není to ale povinné.

Pokud byste chtěli vypočítat, jak má být dlouhá třetí strana rovnoramenného trojúhelníku, pokud znáte délku ramene a
úhel mezi rameny, ušetřím vás googlení analytické geometrie. Zde je metoda, která délku třetí strany vypočítá. V hodině
jsme si ukazovali, jak vypadá metoda, která vrací nějaký výstup. V tomto případě jde o kombinaci jak vstupních
parametrů, tak výstupu.

    public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene
                * Math.sin((uhelMeziRameny * Math.PI / 180) / 2.0))
                * 2.0);
        return tretiStrana;
    }

### Část 3

Pomocí metod výše nakreslete následující obrázky (zmrzlinu, sněhuláka a mašinku).

<img src="ukol03-zmrzlina.svg" width="100" />

<img src="ukol03-snehulak.svg" height="300" />

<img src="ukol03-lokomotiva.svg" height="150" />

### Odevzdání domácího úkolu

Domácí úkol (složku s projektem **90-Turtle-Parametrizovane_metody**) zabalte pomocí 7-Zipu pod jménem
**Ukol03-Vase_Jmeno.7z**. (Případně lze použít prostý zip, například na Macu). Takto vytvořený archív nahrajte na Google
Drive do složky Ukol03.

Vytvořte snímek obrazovky spuštěného programu a pochlubte se s ním v galerii na Facebooku.

Pokud byste chtěli odevzdat revizi úkolu (např. po opravě), zabalte ji a nahrajte ji na stejný Google Drive znovu, jen
tentokrát se jménem **Ukol03-Vase_Jmeno-verze2.7z**.
