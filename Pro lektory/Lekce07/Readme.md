Lekce 6
=======

Cil lekce:
---------
- Vyuzit vstupni parametr ActionEvent v metode obsluhy udalosti
- Dalsi druhy udalosti
    - MouseListener
    - WindowListener
    - Dalsi...

**Pozn:** *JFormDesigner a ikonka v labelu ("sprite"):
JFormDesigner umi nacist obrazky z classpath. V dialogu vyberu souboru je ale nutno vybrat obrazek ve slozce prelozenych souboru (PROJEKT/target). Navic, kdyz vkopirujete soubory do projektu (PROJEKT/src), je nutno projekt prelozit, aby se soubory daly vybrat v JFormDesigneru (byly v PROJEKT/target).*


Priklady:
--------

### Kalkulacka
Pridavani cislice na display kalkulacky mackanim virtualnich klaves na obrazovce mysi.
Lze mit jen 1 osluznou metodu pro vsechna tlacitka a podle (ActionEvent evt) evt.getSource() rozhodnout, ktere tlacitko se stisklo a bud z tlacitko.getText() vyhanout cislici nebo proste velky IF pro 10 tlacitek.

### Kresleni
Na JLabel polozime Icon ve forme BufferedImage, coz je pametova bitmapa.
Pomoci MouseListeneru nastavenemu na tento JLabel pri mousePressed a mouseDragged ze vstupniho parametru MouseEvent evt zjistime pozici mysi a nakreslime na tom danem miste do BufferedImage bod. Doporucuju vychozi cervenou barvu a velikost bodu 5 pixelu.
Je to vyborne rozsiritelne, studentky si muzou dodat komponenty na vymenu barvy a dalsi.

Na konci hodiny, poslednich 10 minut:
Jen ukazka Mandaly - nenechat studentky, aby si to opisovaly, at se jen divaji:
- Ten BufferedImage lze nahrat ze souboru pri windowOpened. Ukazat jak.
- Pri kliknuti neni nutne jen kreslit bod. Co treba vyplnit zvolenou barvou? A mame... relaxacni mandaly!


Domaci ukol:
-----------
### Mandaly
At si studentky pripravi svoji mandalu a samy modifikuji program kresleni na Mandalu.
V zadani domaciho ukolu dodame metodu na vyplneni obrazku z bodu [X, Y] barvou a metodu na nahrani konkretniho obrazku do BufferedImage.

**Pozor:** *Dodany algoritmus na vyplnovani obrazku pracuje jen prebarvenim zdrojove barvy, je tedy potreba, aby obrazky mandal byly jen cerna a bila. Ale pozor, zdrojovy obrazek musi mit 16M barev, jinak by ho neslo vymalovavat ruznymi barvami.*

Konverze barevne hloubky lze provest napr. v IrfanView.
Pro studentky, co nejsou graficky kreativni, lze dodat ukazkovy obrazek mandaly, ktery mohou pouzit.
Na webu existuje nekolik online grafickych editoru.

