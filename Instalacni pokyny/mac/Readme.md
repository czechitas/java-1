<a id="macos">Instalační pokyny pro macOS</a>
=============================================

Tyto pokyny jsou **výhradně pro macOS**.
Instalaci pro Windows najdete [zde](../win/Readme.md).

Linux **není** podporován. Pokud byste měly Linux, byl by to problém, 
se kterým je nutno ozvat se lektorovi.

Pokud už jste instalaci na Java kurz někdy prováděly,
nejspíš máte v `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/Projects`
projekty z minula. Doporučujeme vám je zazálohovat například do `Documents`
a po dokončení instalace je přesunout zpět do složky
`/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/Previous-Projects`.

Pokud by kterýkoliv program,
který si nainstalujete v rámci této instalace,
nabízel update, prosím odmítněte to.
Programy jsou přesně vybrané, aby spolu fungovaly, a jsou předkonfigurované.
Updatované verze by ztratily konfiguraci a materiály z kurzu by nešly spustit.


<a id="detailni">Detailní postup:</a>
-------------------------------------

Zkušené uživatelky mohou přeskočit k krátkému [popisu](#kratky), ale doporučujeme to nedělat a držet se tohoto obrázkového návodu. 

1. Kompletní přednastavený archív si stáhněte z tohoto odkazu:
    [Java-Training.zip](http://javabrno.czechitas.cz/install/2018-jaro/install-community/Java-Training.zip).
    Soubor se začne stahovat. Průběh lze sledovat například v horním tlačítku Stahování (Downloads).

	![](img/screenshot01.png)

2. 	![](img/screenshot02.png)

3. 	![](img/screenshot03.png)

4. 	![](img/screenshot04.png)

5. 	![](img/screenshot05.png)

6. 	![](img/screenshot06.png)

7. 	Soubor `Java-Traning.zip` rozbalte dvojklinutím.
    ![](img/screenshot07.png)

8. 	![](img/screenshot08.png)

9. 	![](img/screenshot09.png)

10. ![](img/screenshot10.png)

11. ![](img/screenshot11.png)

12. ![](img/screenshot12.png)

13. Přetáhněte složku `Java-Training` do `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO`
    (složka Home, česky Domov).
     Při přetahování podržte klávesu Option (Alt),
     aby v případě už existující starší verze `Java-Training` v cílové složce
     nabídl *Finder* sloučení složek (**Merge**).
     
    ![](img/screenshot13.png)

14. Pokud na vás vyskočí tento dialog,
    znamená to, že už jste měly předchozí instalaci na kurz.
    Zvolte **Merge**, abyste nepřisly o vaše předchozí projekty
    (složku `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/Projects`).
    Případně můžete přetahování zrušit, složku s projekty si přesunout
    (například do Documents) a zopakovat předchozí krok.
    
    Pokud se tento dialog neobjevil, předchozí instalaci jste neměly
    a můžete tento krok ignorovat.
    
    ![](img/screenshot14.png)

15. ![](img/screenshot15.png)

16. Nainstalujte aplikaci `IntelliJ IDEA - Community - Java-Training`
    spuštěním `ideaIC-2016.3.7.1.dmg`
    
    ![](img/screenshot16.png)

17. ![](img/screenshot17.png)

18. ![](img/screenshot18.png)

19. ![](img/screenshot19.png)

20. ![](img/screenshot20.png)

21. Aplikaci `IntelliJ IDEA - Community - Java-Training`
    je nutné spustit, aby se jí zkontrolovat digitální podpis.
    Ihned po spuštění ji zase zavřete.
    
    ![](img/screenshot21.png)

22. ![](img/screenshot22.png)

23. ![](img/screenshot23.png)

24. ![](img/screenshot24.png)

25. Digitální podpis aplikace byl zkontrolován.
    Aplikaci ihned zavřete odmítnutím podmínek JetBrains Privacy Policy
    nebo prostě červeným zavíracím tlačítkem.  
    
    ![](img/screenshot25.png)

26. ![](img/screenshot26.png)

27. Před skutečným spuštěním IntelliJ IDEA je nutné jí přenastavit
    umístění konfiguračních souborů v `idea.properties`.
    
    ![](img/screenshot27.png)

28. Klikněte pravým tlačítkem na idea.properties a vyberte Open With -> Other

    ![](img/screenshot28.png)

29. ![](img/screenshot29.png)

30. Sem budeme dopisovat konfiguraci

    ![](img/screenshot30.png)

31. Přidejte do souboru idea.properties tyto řádky:
    ~~~~
    idea.config.path=~/Java-Training/User-Config/IntelliJ-Community/config
    idea.plugins.path=~/Java-Training/User-Config/IntelliJ-Community/config/plugins
    idea.system.path=~/Java-Training/User-Config/IntelliJ-Community/system
    idea.log.path=~/Java-Training/User-Config/IntelliJ-Community/system/log
    ~~~~
    
    ![](img/screenshot31.png)

32. ![](img/screenshot32.png)

33. ![](img/screenshot33.png)

34. ![](img/screenshot34.png)

35. Odpojete (Eject) instalační médium `IntelliJ Community - Java-Training` (`ideaIC-2016.3.7.1.dmg`).

    ![](img/screenshot35.png)

36. Virtuální disk zmizí jak z *Finderu*, tak z plochy

    ![](img/screenshot36.png)

37. Nyní již můžete IntelliJ IDEA - Community - Java-Training 
    normálně spustit.
    
    ![](img/screenshot37.png)

38. ![](img/screenshot38.png)

39. ![](img/screenshot39.png)

40. Tentokrát přijměte podmínky JetBrains.

    ![](img/screenshot40.png)

41. ![](img/screenshot41.png)

42. Před otevřením projektů je potřeba změnit nastavení cest pro Maven v IntelliJ IDEA.

    ![](img/screenshot42.png)

43. ![](img/screenshot43.png)

43. ![](img/screenshot44.png)

43. Změňte `$USER_HOME$` na cestu k vaší uživatelské složce 
    `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO`.
 
    ![](img/screenshot45.png)

43. Tuto hodnotu můžete vidět v horním záznamu `MAVEN_REPOSITORY`. 
    Podobně jako na obrázku. Jen tam nebude `student`.

    ![](img/screenshot46.png)
    
43. ![](img/screenshot47.png)

43. ![](img/screenshot48.png)

43. Stejným způsobem opravte i ostatní `$USER_HOME$`

    ![](img/screenshot49.png)

43. Změny potvrďte

    ![](img/screenshot50.png)

42. Otevřete Demo Application.

    ![](img/screenshot51.png)

43. ![](img/screenshot52.png)

44. ![](img/screenshot53.png)

45. Počkejte, než IntelliJ IDEA po prvním spuštění naindexuje Javu.
    Může to trvat několik minut.

    ![](img/screenshot54.png)

46. ![](img/screenshot55.png)

47. Správně nastavená IntelliJ IDEA obarvuje zdrojový text v Main.java do modrofialova stejně,
    jak je vidět v prostředku na obrázku:
    ![](img/screenshot56.png)
    
    Pokud naopak zůstal zdrojový text povětšinou černý, je to chyba.
    Buď zkuste provést pokyny ještě jednou nebo to nechte tak
    a pomůžeme vám osobně na lekci.

48. Nakonec spusťte ukázkovou aplikaci

    ![](img/screenshot57.png)

49. Pokud vidíte tento nápis, instalace je hotová. 

    ![](img/screenshot58.png)


### Úklid dočasných souborů 
Po instalaci je nepovinně možno vymazat dočasné soubory, aby nezabíraly místo.

50. ![](img/screenshot59.png)

51. Smažte instalační medium `ideaIC-2016.3.7.1.dmg`.
    
    ![](img/screenshot60.png)

52. ![](img/screenshot61.png)

53. ![](img/screenshot62.png)

54. Smažte arcvhív `Java-Training.zip` a složku `Java-Training` v `Downloads`.

    ![](img/screenshot63.png)

55. ![](img/screenshot64.png)

56. ![](img/screenshot65.png)


### A to je vše. Tešíme se na vás na akci.



<a id="kratky">Krátký popis (pouze pro zkušené):</a>
----------------------------------------------------
Tento popis je jen pro experty a dokumentuje slovně, co se provádí během instalace.
Doporučujeme tento popis nepoužít a postupovat podle obrázků [výše](#detailni).

Na kurzu budete potřebovat Javu (JDK) a programátorský editor IntelliJ IDEA (Community Edition).
**Neinstalujte** si je **ručně**, stáhněte si předpřiravený archív.

1.  Stáhněte si [Java-Training.zip](http://javabrno.czechitas.cz/install/2018-jaro/install-community/Java-Training.zip).
   
2.  Pokud už jste někdy instalaci na Java kurzy prováděly, zazálohujte si složku
    `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/Projects` (například do Documents),
    abyste o starší projekty nepřisly.
   

2.  Vybalte obsah `Java-Training.zip` do `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training`.

    Pozor! Pokud už jste někdy instalaci na Java kurz prováděly, 
    nenahrazujte celou složku Java-Training novou verzí.
    (*Nedělejte Replace*.)
    Složky nechejte sloučit. (Původní soubory přepsat novými.)
    *Finder* toto neumí správně, takže předpokládám
    použití nějakého rozumného programu typu *Commander One* nebo *Midnight Commander*.

    Pro kontrolu správného umístění zkontrolujte, že máte přítomnu tuto složku:
    `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/Projects/DemoApplication`.
   
3.  Připojte instalační medium `ideaIC-2016.3.7.1.dmg`
    (které najdete v `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/ideaIC-2016.3.7.1.dmg`)
    a nainstalujte z něj aplikaci `IntelliJ IDEA - Community - Java-Training`.
   
4.  Spusťte tuto aplikaci, aby se zkontroloval její digitální podpis a ihned ji zavřete.
    Před skutečným používáním je totiž potřeba jí nastavit nové umístění konfiguračních souborů.
   
5.  Ve složce `/Applications` vstupte do složky
    `IntelliJ IDEA - Community - Java-Training.app` (Show package contents)
   
6.  <a id="config">Přidejte</a> do
    `/Applications/IntelliJ IDEA - Community - Java-Training.app/Contents/bin/idea.properties`
    tyto řádky:
    ~~~~
    idea.config.path=~/Java-Training/User-Config/IntelliJ-Community/config
    idea.plugins.path=~/Java-Training/User-Config/IntelliJ-Community/config/plugins
    idea.system.path=~/Java-Training/User-Config/IntelliJ-Community/system
    idea.log.path=~/Java-Training/User-Config/IntelliJ-Community/system/log
    ~~~~
    Změníte tím složku s konfiguračními soubory pro IntelliJ IDEA.
    Je nutné nastavit právě tyto konfigurační soubory,
    jinak by nešly otevírat materiály z kurzu.

7.  Spusťte `IntelliJ IDEA - Community - Java-Training` a přenastavte cesty k Mavenu:

    Configure -> Preferences -> Appearance & Behaviour -> Path Variables
    ~~~~
    M2_HOME                $USER_HOME/Maven
    M2_REPOSITORY          $USER_HOME/Libraries
    M2_USER_HOME           $USER_HOME/User-Config/.m2
    ~~~~
    Změňte zástupný znak `$USER_HOME$` na `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO`.
    Toto umístění je specifické pro váš počítač, proto je nutné to udělat ručně.
     
    Pokud byste zde neviděly klíče `M2_HOME`, `M2_REPOSITORY` ani `M2_USER_HOME`
    nejspíš jste nenastavily správně cesty ke konfiguračním souborům IntelliJ IDEA
    (viz [tento bod](#config)).

8.  Otevřete ukázkový projekt v
    `/Users/VAŠE_UŽIVATELSKÉ_JMÉNO/Java-Training/Projects/DemoApplication`.

9.  Po otevření se začne indexovat JDK, což bude pár minut trvat.

10. Až se to dokončí, zdrojový text v `Main.java` musí být převážně modrofialový.

    Pokud by byl naopak převážně černý, byl by to problém.
    Nejspíš byste totiž nenastavily správně cesty ke konfiguračním souborům IntelliJ IDEA
    (viz [tento bod](#config)).

11. Vpravo nahoře zezelená šipka pro spuštění ukázkového projektu, tak jej spusťte.
