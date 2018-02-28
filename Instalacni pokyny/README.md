Instalační pokyny pro Windows
=============================

Tyto pokyny jsou **výhradně pro Windows**. Instalaci pro macOSu najdete [níže](#macos).
Linux není podporován. Pokud máš Linux, prosím, ozvi se hlavnímu lektorovi (kamil.sevecek@czechitas.cz).

Na kurzu budete potřebovat Javu (JDK) a programátorský editor IntelliJ IDEA (Community Edition).

Následujte tento postup:

1. Kompletní přednastavený archív si můžete stáhnout z tohoto odkazu:
    [Java-Training.7z](http://javabrno.czechitas.cz/install/2018-jaro/install-community/Java-Training.7z).

    Zvolte **Stáhnout odkaz jako...** (**Save Link As...**) do složky **Stažené soubory** (**Downloads**).

	![](win-install-01.png)

1. Klikněte pravým tlačítkem na soubor Java-Training.7z ve složce **Stažené soubory** (**Downloads**).

	![](win-install-06.png)

1. Pokud je možné v kontextové nabídce zvolit **7-Zip -> Otevřít**, vyberte tuto volbu a pokračujte až
    [k bodu rozbalování](#rozbalovani).

	![](win-install-07.png)

1. Pokud tato volba není k dispozici, zkuste ještě na archív dvakrát kliknout. Pokud se objeví následující okno,
    pokračujte také [k bodu rozbalování](#rozbalovani).

	![](win-install-08.png)

1. Pokud se naopak objevila chybová hláška Windows, že soubor nelze otevřít, nemáte nainstalovaný archivační software 7-Zip.

	![](win-install-09.png)

1. Musíte si jej [stáhnout](http://www.7-zip.org/).

	![](win-install-10.png)

1. I tento soubor si stáhněte do složky Stažené soubory.

	![](win-install-12.png)

1. Dvojklikněte na něj a spusťte instalaci.

	![](win-install-13.png)

1. Potvrďte bezpečnostní varování.

	![](win-install-14.png)

1. Potvrďte cílovou instalační složku.

	![](win-install-15.png)

1. Nyní když kliknete pravým tlačítkem myši na archív Java-Training.7z ve složce Stažené soubory (Downloads), můžete
    zvolit 7-Zip -> Otevřít.

	![](win-install-07.png)

1. <a name="rozbalovani"></a>Uvidíte okno jako v bodě 4.

	![](win-install-08.png)

1. Zvolte v záhlaví okna volbu Rozbalit (Extract)

	![](win-install-17.png)

1. Aplikace 7-Zip se vás zeptá, kam chcete archív rozbalit. Zadejte **C:\Java-Training**. Pozor na malá a velká písmena
    a pomlčku.

	Je nezbytně **nutné** rozbalit vše právě do **C:\Java-Training**. V jiné složce (například na ploše nebo ve vaší
	složce Dokumenty) aplikace **nebudou** fungovat.

	Případný dotaz na přepsání existujících souborů potvrďte. Žádný strach, o svoje případné projekty z minula
	nepřijdete.

	![](win-install-18.png)

1. Po dokončení rozbalování otevřete ve správci souborů (ikona Tento počítač) složku
    **C:\Java-Training\IntelliJ-Community**.

	![](win-install-19-community.png)

1. Uchopte soubor IntelliJ-Community.lnk (s ikonkou IntelliJ IDEA) a přetáhněte ho na plochu.

	![](win-install-21-community.png)

1. Tímto zástupcem na ploše můžete spustit editor IntelliJ IDEA.

	![](win-install-24.png)

1. Pokud jste vše udělali správně, můžete zkusit otevřít ukázkovou aplikaci a spustit ji.

	Zvolte Otevřít (Open).

	![](win-install-25.png)

1. Ukázkovou aplikaci najdete ve složce **C:\Java-Training\Projects\DemoApplication**.

	**Pozor!** Nikdy nerozbalujte složky dvojitým kliknutím. Jednotlivé složky je nutné rozklikávat pomocí
	trojúhelníkové šipky před jejich jmény. Až najdete složku **DemoApplication**, potvrďte tlačítkem OK.

	![](win-install-26.png)

1. Otevřením prvního projektu začne IntelliJ IDEA indexovat celou Javu, kterou máte nainstalovanou na počítači. Vydržte,
    dokud nezmizí ukazatel průběhu (může trvat i pár minut). Následně se obarví spouštecí šipka do zelena.

	![](win-install-26B-wait_for_indexing.png)

1. Zvolte vpravo nahoře zelenou šipku Run.

	![](win-install-27.png)

1. Měli byste vidět tuto malinkou aplikaci.

	![](win-install-28.png)

<a name="macos"></a>Instalační pokyny pro macOS
===============================================

Na kurzu budete potřebovat Javu (JDK) a programátorský editor IntelliJ IDEA (Community Edition).

Následujte tento postup:

1. Kompletní přednastavený archív si můžete stáhnout z tohoto odkazu:
    [Java-Training.zip](http://javabrno.czechitas.cz/install/2018-jaro/install-community/Java-Training.zip).
    Soubor se začne stahovat. Průběh lze sledovat například v horním tlačítku Stahování (Downloads).

	![](mac-00_web.png)

1. Až bude soubor stažený, automaticky se rozbalí. Podívejte se do složky **Stažené soubory (Downloads)**. Pokud byste
    ve složce Stažené soubory (Downloads) viděli pouze archiv Java-Training.zip, dvojím kliknutím jej rozbalte.

	![](mac-01_downloads.png)

1. Přesuňte složku **Java-Training** do své domovské složky. Domovská složka je **/Users/VAŠE_UŽIVATELSKÉ_JMÉNO**. Tedy
    například **/Users/student**.

	![](mac-02_unzip.png)

1. Ve složce **Java-Training** uvnitř svého domovského adresáře poklepáním spuťte instalační soubor
    **ideaIC-2016.3.7.dmg** a přetažením nainstalujte IntelliJ IDEA do složky Aplikace (Applications).

	![](mac-03_idea_install.png)

1. Ze složky Aplikace (Applications) poklepáním spusťte editor IntelliJ IDEA.

	![](mac-04_idea_open.png)

1. Potvrďte, že si tuto aplikaci skutečně přejete spustit.

	![](mac-05_idea_open.png)

1. Všechna další okna a dialogy zavřete červeným tlačítkem v levém horním rohu.

	![](mac-06_idea_close_import.png)

	![](mac-07_idea_close_theme.png)

	![](mac-08_idea_close.png)

1. Ve složce Aplikace (Applications) **pravým tlačítkem** klikněte na IntelliJ IDEA a vyberte Zobrazit obsah (Show
    Package Contents).

	![](mac-09_idea_folder_open.png)

1. Nyní se proklikejte do složky **Contents/bin**, poklepáním otevřete konfigurační soubor **idea.properties** a na
    konec přidejte následující dva řádky:

        idea.config.path=~/Java-Training/IntelliJ-Community-Profile/config
        idea.system.path=~/Java-Training/IntelliJ-Community-Profile/system

    **Pozor!** v závislosti na nastavení vašeho systému se soubor může otevřít v jiném textovém editoru. V případě, že
	se soubor nebude chtít otevřít v žádné aplikaci, vyberte TextEdit.

	![](mac-10_idea_community_config_change.png)

1. Uložte změny v konfiguračním souboru.

	![](mac-11_idea_community_config_save.png)

1.  Zkuste si ještě pustit ukázkovou aplikaci, ať ověříte, že máte správně nainstalovanáno.

    Ze složky Aplikace (Applications) poklepáním spusťte editor IntelliJ IDEA.

	![](mac-12_idea_open.png)

1. Zvolte Otevřít (Open).

	![](mac-13_idea_open_project.png)

1. Ukázkovou aplikaci najdete v domovském adresáři ve složce **Java-Training/Projects/DemoApplication**.

    **Pozor!** v závislosti na nastavení vašeho systému může okno výběru složky vypadat jinak. Až najdete složku
	**DemoApplication**, potvrďte tlačítkem Open (Otevřít).

	![](mac-14_idea_open_project_2.png)

1. Otevřením prvního projektu začne IntelliJ IDEA indexovat celou Javu, kterou máte nainstalovanou na počítači. Vydržte,
    dokud nezmizí ukazatel průběhu (může trvat i pár minut). Následně se obarví spouštecí šipka do zelena.

	![](mac-15_idea_wait_for_indexing.png)

1. Zvolte vpravo nahoře zelenou šipku Run.

	![](mac-16_idea_run_project.png)

1. Měli byste vidět tuto malinkou aplikaci.

	![](mac-17_first_application.png)

