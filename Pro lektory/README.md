Kurz Java 1 - Lektorske poznamky
================================

**TODO: Ke kazde lekci a ke kazde latce dodat odkazy na blogy / clanky, ktere se zabyvaji teorii k dalsimu precteni.**

Pouzity software
----------------

- OpenJDK 8
- Intellij IDEA - Community Edition
- Maven
- MigLayout
- JFormDesigner
    - Czechitas maji nekomercni licenci, pozadejte o ni Kamil �eve�ka nebo lektory z minulych let.
    - JFormDesigner se pouziva jen ve 3 poslednich lekcich a je tedy mozne ho obejit tim, ze predate studentum hotove GUI tridy.
      Pripravili byste je tak ale o radost z toho, ze si to zvladnou udelat cele sami.


Zakladani novych projektu
-------------------------

Pokud budete zakladat nove konzolove nebo desktopove aplikace a vyuzili jste instalaci z javainstall.czechitas.cz,
muzete zalozit novy projekt V IntelliJ IDEA z sablony:

IntelliJ IDEA -> New Project -> User Defined -> Java Console App
IntelliJ IDEA -> New Project -> User Defined -> Java Window App

Vyhoda oproti cistemu mavenovemu projektu je v tom, ze u nej je nutne do pom.xml doplnit pomerne mnoho radek,
aby se nastavila verze Javy a kodovani UTF-8.



Struktura slo�ek projektu
-------------------------

V projektu jsou slo�ky:
- Pro studenty
    ... Zde jsou materi�ly a zad�n� dom�c�ch uloh v takov� form�, kter� lze nahr�t student�m.
- Pro lektory
    ... Zde jsou doplnkov� materi�ly pro lektory, zdroje obr�zk�, docx, pptx atd.
- Archiv (nemusi byt pritomen)
    ... Star�� projekty, kter� byly n�kdy v historii pou�ity, ale v sou�asn� dob� u� se neve�ly do studujn�ho pl�nu.

Materi�ly jsou rozd�leny do lekc� a v lekc�ch jsou projekty o��slov�ny po des�tk�ch, aby se spr�vn� zat��dily ve slo�ce na disku. Jin� v�znam ��slov�n� nem�.

Typicky:
- `10-Zelva-Zadani`
- `11-Zelva-Reseni`
- `20-Kocka-Zadani`
- `21-Kocka-Reseni`
- `31-Objektova_hierarchie-Reseni`
- `40-Banka`

Pokud je p��tomno jen `Reseni` a chyb� `Zadani`, pak se m� dan� projekt za��t �pln� od nuly (nap�. `31-Objektova_hierarchie-Reseni`).
Pokud nen� uvedeno ani `Zadani` ani `Reseni`, pak je to jen demo projekt (nap�. `40-Banka`).



Anglictina vs. cestina
----------------------

Projekty jsou zamerne v cestine. Pro zacatecnika to ma vyhodu v tom, ze ihned vidi, co si muze zvolit sam (ceske nazvy),
a co je zde "z principu Javy" (anglicke nazvy). Tato myslenka se uplatnuje i u get/set metod.
Doporucuju delat to stejne. Mam s tim vyborne zkusenosti.

Mrzi me predpojatost profesionalnich programatoru, kdyz se podivaji na projekty, ktere studenti vytvori, a smahem je odsoudi,
ze jsou k nicemu, protoze jsou v cestine. Projekty jsou cvicne, ale zkusenosti se na nich nabrat daji mozna i lepe,
nez na deset let tazene odporne hydre, co je nasazena v produkci.


Konvence
--------

Snazte se *co nejvic* **dodrzovat konvence**. Zacatecnikum to vstipi lepsi navyky.

Tipy:
* Metody vzdycky nazyvejte rozkazovacim zpusobem
* Metody obsluhujici udalosti vzdycky nazyvejte:
    * `priStisku*BtnVypocitej*` nebo `on*BtnCalculate*Click` pro udalost `actionPerformed` na tlacitko.
    * `priKliknutiNa*LabObrazek*` pro udalost `mouseDown` nad `JLabelem labObrazek`.
    * `priTiknutiCasovace` pro udalost `actionPerformed` `javax.swing.Timeru`.
    * atd.
* Pouzivejte `package` jako v klasickem vyvoji. Napr. `cz.czechitas.nazevprojektu`. Nevkladejte tridy do prazdneho package.
* Existujici projekty maji vzdy `main(...)` v souboru `SpousteciTrida` (alias `Main`). Pouzivejte to take tak nebo si vyberte
  jedno jine pojmenovani pro spousteci tridu a nemente ho.
* Pouzivejte native look and feel ve Swingu. Uzivatele to lepe akceptuji.



Osetrovani chyb
---------------

V GUI aplikacich je pouzita trida `SwingExceptionHandler`, ktera se zaregistruje jako `Thread.defaultUncaughtExceptionHandler`
a zobrazuje elegantni swingove dialogove okno s vypisem chyby na vyjimky (`RuntimeException`),
ktere vypropaguji az do smycky udalosti (a zborti `EventDispatchThread`).
Muzete se na to podivat, ale funguje to celkem bezudrzbove.
Jen je potreba `SwingExceptionHandler` na zacatku aplikace zaregistrovat.
Trida sama pochazi z knihovny **Sevecek.net Utils**, ktera je volne dostupna v Maven Central a zdrojove texty jsou na GitHubu.



Projektove konfiguraky (pom.xml, .idea)
---------------------------------------

Projekty jsou zalozeny na Mavenu (pom.xml).
Obvykle se `PROJEKT/.idea` nesdili pres Git.
Nicmene zde je to zvoleno z praktickych duvodu:
Je treba sdilet spousteci konfiguraci (`PROJEKT/.idea/runConfigurations`), ktera je (minimalne pro projekty z lekci 1-4) nutna,
protoze v techto projektech studenti neprichazeji do styku s metodou `main(...)`. Ta je schovana ve tridach enginu.
Bohuzel, pokud je v mavenovem projektu pritomna slozka `PROJEKT/.idea`, IntelliJ IDEA ho jiz neni ochotna importovat
a musi tam tak byt pritomna *cela* konfigurace pro IntelliJ IDEA.

Dalo by se uvazovat o odstraneni slozek `PROJEKT/.idea` z projektu z lekci 5-12. Pokud o to mate zajem, zalozte Issue na GitHubu.
