Lekce 02 - Úkol 02 - Želva Žofka
--------------------------------

### Část 1

Nejprve dodělejte program z hodiny. Konkrétně obrazce domečků a prasátka.
Jako bonus můžete dokreslit prasátku i ocásek.

<img src="img/ukol02-domecek.svg" height="200" />

<img src="img/ukol02-prasatko.svg" width="200" />


### Část 2

Udělejte si kopii projektu **10-Turtle** na **30-Turtle-Ukol**.
Provedete to tak, že jednoduše ve správci souborů
(Tento počítač, Průzkumník, Total Commander, Finder, Commander One ...)
zkopírujete složky **10-Turtle** a přejmenujete ji na **30-Turtle-Ukol**.

Další změny už provádějte jen do **30-Turtle-Ukol**.

Nakreslete několik obrazců podle obrázků níže.
Pro každý obrázek vytvořte metodu a případně uvnitř volejte další
metody.

<img src="img/ukol02-osmiuhelnik.svg" width="100" />

<img src="img/ukol02-kolecko.svg" height="100" />

<img src="img/ukol02-slunicko.svg" height="150" />

Poznámka: Želva neumí kreslit zakřivené čáry.
Kolečko a podobné tvary nakreslíte tak,
že nakreslíte krátkou čáru (třeba 5 pixelů),
potom se otočíte o malý úhel (třeba 20 stupňů)
a toto opakujete n-krát (třeba 18 krát).


### Část 3

Nakreslete kompozici podle obrázku níže.

<img src="img/ukol02-vesnice.svg" height="500" />


### Část 4

Naučte želvu nakreslit písmena, která máte ve jméně, a nakreslete svoje křestní jméno.
V této části se zaměřte na znovupoužitelnost.
Vytvořte tedy pro každé písmeno metodu (např. `nakresliA()`, `nakresliB()`, ...)
a u každého písmene začněte vlevo dole (jakoby na spodní lince písmene) a skončete na vpravo dole (na spodní lince písmene) v místě pro další písmeno (za mezerou).
Pokud si disciplinovaně udržíte tento styl v každé metodě, bude možno písmena skládat za sebe v libovolném pořadí.

Pro ukázku uvažujme písmeno K. Tečkovaně je naznačeno, jak ho bude želva kreslit. Želva je zatím ve výchozí pozici (a písmeno zatím nenakreslila):

<img src="img/ukol02-pismeno-zacatek.svg" height="200" />


Želva písmeno postupně nakreslí a skončí v této pozici:

<img src="img/ukol02-pismeno-konec.svg" height="200" />



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
