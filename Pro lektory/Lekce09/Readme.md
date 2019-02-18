Lekce09 - Graficke aplikace a udalosti
======================================

Cil lekce
---------

- Swing
- Vytvoreni JFrame a JLabel primo v main()
- Refaktoring na SpousteciTrida + HlavniOkno
- Graficky designer a MigLayout
- Naucit se cist, co designer generuje
- Udalosti


Videozaznam
-----------

Playlist vsech lekci z kurzu Kamila Sevecka
*   Podzim 2017 (https://www.youtube.com/playlist?list=PLUVJxzuCt9AROpKl3Hu-DvdgQV-xHaoQY) -> Lekce 05
*   Podzim 2018 (https://www.youtube.com/playlist?list=PLTCx5oiCrIJ70H8jF9FxPs15e3_m6su80)


Poznamky:
--------
MigLayout - doporucuji striktne pouzivat vsude pouze MigLayout nebo pozicovani po pixelech (layout=null).

### Jmenne konvence
Doporucuji striktne dodrzovat jmenne konvence. Netrvam na techto, ale naucte studentky si udrzovat zdrojovy text usporadany:

- **JTextField** ... editNazevPrvku
- **JButton** ...... btnNazevPrvku
- **JLabel** ....... labNazevPrvku
- **obsluha actionPerformed** ......... priStiskuNazevTlacitka
- **obsluha mouseClicked** ............ priKliknutiNaNazevTlacitka
- **obsluha keyTyped** ................ priZmacnutiKlavesy
- **obsluha windowOpened** ............ priOtevreniOkna
- **obsluha windowClosing** ........... priZaviraniOkna
- **custom post-initializace okna** ... priInicializaciOkna


Priklady:
--------
### Desktopova aplikace v Jave bez designeru
    Vysel jsem z sablony User Defined -> Java Console App
    Pozn: Ukazal jsem, ze je tam stejne rozdeleni na SpousteciTridu a HlavniOkno, jak jsme to meli v druhe Zelve Zofce.
    Pozn: Aplikaci jsme programovali spolu - resp. ja jsem psal na projektoru a studentky si ji opisovaly. Nesazejte moc na to, ze si budou neco pamatovat. Jde ale o to, aby ta okenni aplikace, kterou nasledne vytvorime pomoci designeru nebyla uplne jak z jineho sveta.


### Desktopova aplikace z sablony User Defined -> Java Desktop App

Napriklad Pozdrav:
```
    +---------------------------------------+
    |                      +--------------+ |
    | Zadejte svoje jmeno: |              | |
    |                      +--------------+ |
    |          +===============+            |
    |          |   Pozdravit   |            |
    |          +===============+            |
    +---------------------------------------+
```
Pokud studentkam budete chtit ukazat obsluhu udalosti actionPerformed na tlacitku, udelejte to opravdu jen jako ukazku a reknete jim, at si to neopisuji, jen se divaji. V tom pripade to jde udelat rychle a zabavne behem 3-5 minut. Kdyby si to psaly, je to prace na pul hodiny a ztratil by se tim jednoznacny cil hodiny.

### Desktopova aplikace
-  Prevod jednotek z mil na kilometry
-  Vypocet DPH
-  nebo cokoliv dalsiho se zadavacimi boxiky a tlacitky, kde se pekne ukaze moznost navrhnout si vlastni appku pomoci designeru a MigLayoutu.
