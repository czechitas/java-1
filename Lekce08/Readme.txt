Cil hodiny:
----------
Princip casovace
Vlastnosti vizualnich komponent a okna (contentPane)


Priklady:
--------
Ping Pong
    Dame studentkam obrazek micku, at si ho vlozi na okno.
    Vlozime na okno tlacitko a pri stisku tlacitka nejprve zobrazime JOptionPane (abychom se ujistili, ze to funguje).
    Pak pri stisku tlacitka pohneme mickem vlevo nahoru. Doporucuji uhel 45 stupnu, tedy deltaX i deltaY = 10.

    Vylepseni - odrazeni od stran ContentPane.

    Bonus pro rychlejsi studentky:
        Pomoci sin + cos lze mit volitelny uhel a rychlost micku.

    Vylepseni - automaticky posun micku (Timer):
    Nakonec pridame javax.swing.Timer (Pozor, v Jave je vic Timeru. Je nutne, aby to byl Swing Timer).
    Timer musime vytvorit sami, designer ho vytvorit nedokaze, protoze nema bezparametricky konstruktor.
        Tip: Vlastni tvorba Timeru muze byt klidne provedene v udalosti windowOpened.
        Pozn: Timer je nutne inicializovat s odkazem na jiz naprogramovanou metodu actionPerformed.
            Tip: Doporucuji nechat studentky v generovanem kodu designeru najit, kde a jak se metoda navesuje na stisk tlacitka (addActionListener). Stejny kod se pak pouzije jako parametr constructoru Timeru.
        Tip: Komponentu Timeru lze vlozit na okno pomoci designeru, ale je nutne nastavit v tabulce vlastnosti teto pridane komponenty "Custom Creation Code". Nemyslim, ze to stoji za zmateni studentek. Je to mozne ukazat jako cimrmanovskou zapomenku a zduraznit, ze si to nemaji pamatovat :-)

