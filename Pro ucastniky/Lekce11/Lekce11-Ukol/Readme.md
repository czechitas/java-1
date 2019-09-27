Úkol 10 - Seriózní desktopová aplikace - Mandala
------------------------------------------------


### Část 1 - Vyplňování místo kreslení

Založte novou okenní aplikaci, která bude podobná Kreslení z hodiny.
Nahrajte do labelu obrázek mandaly a naprogramujte do ní stejnou
funkcionalitu jako jsem měl já na konci hodiny.
Inspirujte se videem z lekce.

Obrázek se dá nahrát pomocí následujícího kódu:

~~~Java
    try {
        // Bud jde vytvorit prazdny obrazek
        // obrazek = new BufferedImage(1920, 1080, BufferedImage.TYPE_4BYTE_ABGR);

        // Nebo nahrat existujici
        File soubor = new File("obrazek1.png");
        obrazek = ImageIO.read(soubor);
        labObrazek.setIcon(new ImageIcon(obrazek));
    } catch (IOException e) {
        throw new ApplicationPublicException(ex, "Nepodařilo se nahrát obrázek mandaly ze souboru " + soubor.getAbsolutePath());
    }
~~~

Všimněte si uvedení **relativní** cesty k souboru (`obrazek1.png`).
Relativní cesta začíná ve složce projektu a operační systém
si ji při dohledávání souboru převede na **absolutní** cestu.
Například pokud projekt je ve Windows ve složce `C:\Java-Training\Projects\Java1\Lekce11\40-Mandala`,
pak výsledná absolutní cesta k souboru bude `C:\Java-Training\Projects\Java1\Lekce11\40-Mandala\obrazek1.png`
nebo pokud je projekt na macOS ve složce `/Users/Kamil/Java-Training/Projects/Java1/Lekce11/40-Mandala`,
bude výsledná absolutní cesta k souboru
`/Users/Kamil/Java-Training/Projects/Java1/Lekce11/40-Mandala/obrazek1.png`.


V materiálech k lekci je zdrojový text metody na vyplnění `BufferedImage`.
Jedná se o soubor `Vyplnovani.txt`.



#### Poznámka:
Dejte pozor, aby <code>labObrazek</code> měl nastavené zarovnání <code>horizontalAlignment</code> na <code>LEFT</code>
a <code>verticalAlignment</code> na <code>TOP</code>.
Tedy aby obrázek mandaly byl vlevo nahoře.
Jinak nebudou souřadnice <code>X</code> a <code>Y</code> z událostního info objektu
<code>MouseEvent e</code> správně odpovídat souřadnicím bodů na
<code>BufferedImage obrazek</code> a po kliknutí na mandalu se vám vyplní
*předem těžko odhadnutelná oblast*.


Ukázkový program by mohl vypadat takto:

![](ukol11-program.png)



### Část 2 - Volba barev

Přidejte na formulář ještě čtvercové labely na výběr barvy malování.
Labely udělejte pevně velké (např. 32x32), nastavte jim
`opaque` na `true` a `background` na zvolenou barvu.
Když uživatel klikne na nějakou barvu, mělo by se vyplňovat
touto barvou.


#### Rady na cestu:

- Připravte si vlastní sadu barev k vyplňování.
Můžete použít <a href="https://color.adobe.com">Adobe KULER</a>.

- V Odevzdávárně je nahrané moje řešení i se zdrojovými texty.
Můžete ho využít, když nebudete vědět kudy kam.
Ale pokud to půjde bez něj, bude to výrazně lepší.


            


### Část 3 - Příprava vlastní mandaly

Vytvořte si vlastní mandalu nebo nějakou najděte na internetu. Je jich tam spousta.
Mandala akorát musí být striktně černo-bílá. Pouze dvě barvy!

Mandala musí být ve formátu **png**, protože tento formát je bezeztrátový.
Nesmí být uložena ve formátu **jpg**. Ten je ztrátový a zničil by ostrost mandaly (*roztřepil* by ji).

Pro příklad vyjděme třeba z této alternativní mandaly:
[ukol11-mandala2.png](ukol11-mandala2.png).
Vypadá sice, že je černobílá, ale ve skutečnosti
má vyhlazené čáry pomocí stupňů šedi.
Tyto stupně šedi je nutné oříznout na striktně černou a bílou.
Například v [Online Image Editoru (Dan's Tools)](https://www.favicon-generator.org/image-editor/)
je funkce Effects -> Black and White...
Po provedení zkontrolujte v Image -> Information..., že počet unikátních barev je skutečně 2.
Není nutné používat zrovna tento nástroj.
Danou operaci umí provádět skoro každý prohlížeč či editor obrázků.

Černo-bílá mandala pak vypadá takto (srovnejte s tou výše):
[ukol11-mandala2-blackwhite.png](ukol11-mandala2-blackwhite.png).
Všimněte si, jak je *zubatá*. To je v pořádku. Hodně to zjednodušuje vyplňovací algoritmus,
protože se nemusí provádět zahlazování vyplňující barvy do obrázku.

Rozumná velikost mandaly je 640x640 bodů, ale můžete použít i jinak velké obrázky.
Vyzkoušejte a uvidíte samy.

V materiálech lekce jsou 2 hotové funkční mandaly.





### Nepovinná část 4 - Vylepšení


Program Mandal jakkoliv vylepšete.
Napadá mě mnoho způsobů, co by ještě appka mohla umět.

Například:

#### Nahrávání a ukládání obrázků

Bylo by fajn přidat klasické menu a do něj volby **uložit** a **otevřít**
libovolný obrázek.
Můžete se inspirujte vzorovým řešením v odevzdávárně.

Metoda na uložení obrázku:
~~~Java
private void ulozObrazek(File soubor) {
    try {
        ImageIO.write(obrazek, "png", soubor);
    } catch (IOException ex) {
        throw new ApplicationPublicException(ex, "Nepodařilo se uložit obrázek mandaly do souboru " + soubor.getAbsolutePath());
    }
}
~~~

Zde je kód, který se uživatele zeptá na jméno souboru
klasickým ukládacím dialogem:

~~~Java
JFileChooser dialog = new JFileChooser(".");

private void ulozitJako() {
    int vysledek = dialog.showSaveDialog(this);
    if (vysledek != JFileChooser.APPROVE_OPTION) {
        return;
    }

    File soubor = dialog.getSelectedFile();
    if (!soubor.getName().contains(".") && !soubor.exists()) {
        soubor = new File(soubor.getParentFile(), soubor.getName() + ".png");
    }
    if (soubor.exists()) {
        int potvrzeni = JOptionPane.showConfirmDialog(this, "Soubor " + soubor.getName() + " už existuje.\nChcete jej přepsat?", "Přepsat soubor?", JOptionPane.YES_NO_OPTION);
        if (potvrzeni == JOptionPane.NO_OPTION) {
            return;
        }
    }
    ulozObrazek(soubor);
}
~~~

            

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
