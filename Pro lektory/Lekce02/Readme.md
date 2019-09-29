Lekce 02 - Metody
=================

Cil lekce
---------

- Samostatne psat cykly a podminky v Jave
- Instanciovat objekty z existujicich trid
- Volat metod na objektech
- Umet si rozlozit program do podprogramu - metody
- Spravne zavorky, odsazeni, zarovnani (Ctrl+Alt+L)


Videozaznam
-----------

Playlist vsech lekci z kurzu Kamila Ševeèka
*   Podzim 2019 (https://www.youtube.com/playlist?list=PLTCx5oiCrIJ7tIik1OiuPmGwt4OOqomrR)
*   Podzim 2018 (https://www.youtube.com/playlist?list=PLTCx5oiCrIJ70H8jF9FxPs15e3_m6su80)
*   Podzim 2017 (https://www.youtube.com/playlist?list=PLUVJxzuCt9AROpKl3Hu-DvdgQV-xHaoQY)


Priklady
--------

### Zelva Zofka

Kresleni pomoci zelvy. Inspirovano podobnym programovacim prostredim na Zbrojovacku, ktere samo bylo inspirovano jazykem MiniLogo a Logo.

Zde je super, ze studentky zacinaji uz uplne od nuly - od `main(...)`. Kdyz napisi:
`new Turtle()` a ona se jim zobrazi zelva.

V hodine doporucuji nejprve ukazat, jak se nakresli hvezdicka. Tim se demonstruje pouziti metod.
Dale spolu se studentkami doporucuji vytvorit metody na ctverec a rovnostranny trojuhelnik.
Jako samostatnou praci muzou studentky zkusit domecek a prasatko.


#### Poznamky

*   Pozor, samotny engine ma SpousteciTridu, kterou studentky nevidi a ktera ma `public static void main(String[] args)`.
    Nicmene studentky edituji tridu HlavniProgram, kde je uz jen `public void main(String[] args)`.
    Je to proto, abychom se vyhnuli klicovemu slovu `static`.

*   2 a vice zelvicek
    Pokud udelate 2x new Turtle(), zobrazi se 2 zelvy.
    Pokud by se studentky ptaly, jestli by slo udelat, aby kreslily zelvy soucasne, tedy nikoliv po sobe,
    muzete jim ukazat vlakna (necht si to nepisi, jen se divaji).
    Turtle framework je thread-safe v vztahu k main() i ve vztahu ke Swingu.
    ~~~Java
    public void main(String[] args) {
        ExecutorService spoustec = Executors.newCachedThreadPool();
        spoustec.execute(this::pohybujPrvniZelvou);
        spoustec.execute(this::pohybujDruhouZelvou);
    }

    public void pohybujPrvniZelvou() {
    }

    public void pohybujDruhouZelvou() {
    }
    ~~~
