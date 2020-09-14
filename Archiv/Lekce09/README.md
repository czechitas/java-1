Lekce 09
========

Ping Pong a Bludiště
--------------------

### Osnova

1. Oživení Ping Pongu z minula
1. Přidání labelu reprezentujícího hráče
1. Událost KeyListener.keyPressed
1. Kolize objektů (dvou labelů) na obrazovce
1. Bludiště

### Videozáznam

Na YouTube se můžete podívat na [záznam z lekce](https://www.youtube.com/watch?v=QybpXg5PAXo),
případně si prohlédnout [celý playlist](https://www.youtube.com/playlist?list=PLUVJxzuCt9AROpKl3Hu-DvdgQV-xHaoQY).

Úkol 09 - Ping Pong a Bludiště
------------------------------

Cílem domácího úkolu je dokončit aplikace z hodiny.

### Část 1 - Ping Pong

V hodině jsme programovali Pong (naši verzi první počítačové hry na světě, 1972, wikipedia).

Dokončete Pong tak, aby uměl např. tyto věci: (toto je pouze seznam návrhů, který je doporučený).

* Hráči se ovládají pomocí W/S a šipky nahoru/dolů.
* Míček se odráží od horní a dolní stěny, ale ne od bočních změn.
* Míček se odráží od hráčů (s použitím kolize objektů).
* Pokud hráč nezachytí míček a uteče mu za okraj, protihráč dostane bod.
* Pokud se míček pohybuje s úhlem a rychlostí (ne napevno 45°), můžete složit hráče z více labelů (horní část, střední
  část a spodní část) a měnit odrazový úhel podle části, do které míček narazil.
* S přibývajícími body můžete míček zrychlovat.

Poznámka: Klávesy mají čísla, ale místo konkrétních čísel je doporučeno používat předpřipravené konstanty:

    if (kodKlavesy == 38) {
        // pohyb nahoru
    }

    // Lepší verze:
    if (kodKlavesy == KeyEvent.VK_UP) {
        // pohyb nahoru
    }

### Část 2 - Bludiště

Aplikace, ve které ovládáte robota a úkolem je projít bludiště. I zde je seznam nápadů, které by appka mohla mít. Není
zdaleka úplný ani povinný.

Pár tipů:

* Nejprve napište pohyb robota pomocí šipek v prázném okně.
* Potom přidejte bludiště.
* Při pohybu robota (priStiskuKlavesy) posuňte robota, testujte kolizi s každou zdí a pokud ke kolizi dojde, prostě
  vrátíte robota na původní polohu před pohybem.
* Nakonec udělejte test toho, že robot dorazil do cíle v bludišti. Například tak, že cílové místo bude také label,
  akorát průhledný. Tzv. nášlapný kámen. V tomto případě testujte kolizi s tímto nášlapným kamenem.

### Odevzdání domácího úkolu

Domácí úkol (složky s projekty) zabalte pomocí 7-Zipu pod jménem **Ukol09-Vase_Jmeno.7z**. (Případně lze použít prostý
zip, například na Macu). Takto vytvořený archív nahrajte na Google Drive do složky Ukol09.

Vytvořte snímek obrazovky spuštěného programu a pochlubte se s ním v galerii na Facebooku.

Pokud byste chtěli odevzdat revizi úkolu (např. po opravě), zabalte ji a nahrajte ji na stejný Google Drive znovu, jen
tentokrát se jménem **Ukol09-Vase_Jmeno-verze2.7z**.
