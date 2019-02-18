Lekce10 - Udalosti
==================

Cil lekce
---------

- Prevod konzolove aplikace na grafickou
- Procvicovani udalosti
- Informacni objekt o udalosti - `ActionEvent` a vlastnost `source`


### Poznamka:

JFormDesigner a ikonky:
JFormDesigner umi nacist obrazky z classpath.
V dialogu vyberu souboru je ale nutno vybrat obrazek ve slozce prelozenych souboru (PROJEKT/target).
Obrazky byste ale meli vkladat do zdrojovych souboru projektu (PROJEKT/src/main/resources).
Aby se prekopirovaly do PROJEKT/target, je nutno projekt prelozit.
Pak se da soubor vybrat v JFormDesigneru (protoze uz je v PROJEKT/target).


Priklady:
---------
-   Den narozeni
    Prevod konzolove aplikace na grafickou

### Kalkulacka
    Predpripraveny design.
    Pridavani cislice na display kalkulacky mackanim virtualnich klaves na obrazovce mysi.
    Lze mit jen 1 osluznou metodu pro vsechna tlacitka a podle `(ActionEvent evt) evt.getSource()` rozhodnout,
    ktere tlacitko se stisklo a bud z `tlacitko.getText()` vyhanout cislici nebo proste velky `if` pro 10 tlacitek.


Videozaznam
-----------

Playlist vsech lekci z kurzu Kamila Sevecka
*   Podzim 2017 (https://www.youtube.com/playlist?list=PLUVJxzuCt9AROpKl3Hu-DvdgQV-xHaoQY) - Lekce 06
*   Podzim 2018 (https://www.youtube.com/playlist?list=PLTCx5oiCrIJ70H8jF9FxPs15e3_m6su80)
