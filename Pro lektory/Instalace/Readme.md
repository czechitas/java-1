Info o instalaci pro lektory a kouce
====================================

Vsechny programy v instalaci jsou v 1 slozce Java-Training
    - na Windows C:\Java-Training
    - na Macu ~/Java-Training
        - Na Macu je vyjimkou IntelliJ IDEA, ktera se instaluje klasicky, aby byla ve slozce Applications, protoze uzivatele jsou na to zvykli
        - Pro tyto ucely jsem jeji instalacni slozku prejmenoval z IntelliJ IDEA CE.app na IntelliJ IDEA - Community - Java-Training.app


Podminky, podle kterych byla instalacka sestavena (od nejdulezitejsiho po nejmene dulezite):
-------------------------------------------------------------------------------------------
* Instalace musi byt co nejjednodussi (idealne jen rozbaleni zipu nebo jen spusteni Setup.exe)
    Zacatecnikum je uplne jedno, co instaluji. Vetsinou to nechapou a nutit je do slozitych postupu je kontraproduktivni.
* Instalace nesmi rozhodit nic, co uz ma uzivatel nainstalovaneho pro svoji beznou praci (napriklad JDK, jinou verzi IntelliJ IDEA, svuj nastaveny Maven apod.)
* Instalace by se nemela opirat o nic, co by melo byt na pocitaci uz nainstalovano.
* Instalace musi bezet i na 32bit Windows.
    Porad je male procento studentu s 32bit Windows.
* Instalace musi jit zprovoznit bez administratorskych prav.
* Instalace nemuze pouzivat virtualizaci (VMWare, Hyper-V, VirtualBox, Docker, Haxm).
    Porad je male procento studentu bez podpory virtualizace nebo s AMD procesorem.
* Instalace nesmi vyzadovat stahovani dodatecnych souboru (plati predevsim pro Maven repository).
* Instalace je udelana tak, aby se bez dalsiho nastavovani dal spustit cely courseware.
* Projekty by mely minimalizovat navazani na konkretni nastaveni instalacky.
    Pokud se nekdo rozhodne nainstalovat si nutny software sam (v defaultech), aby to jakz-takz slo.


Rozdily proti defaultu
----------------------
Maven
    localRepository nastavena na C:\Java-Training\Libraries nebo ~/Java-Training/Libraries

IntelliJ IDEA
    Zmeny nutne pro korektni otevreni projektu:
        JDK
            Prednastavene JDK 1.8 z C:\Java-Training\JDK, ovsem pojmenovane "Java SE", ne vychozi "1.8"
            !!! Prodiskutovat, zda nezmenit !!!
        Predkonfigurovane knihovny
            Java EE 7 API
                C:/Java-Training/Libraries/Java EE 7 API/javaee-api-7.0.jar
            MariaDB JDBC Driver
                C:/Java-Training/Libraries/MariaDB JDBC Driver/mariadb-java-client-1.4.5.jar
            Servlet 3.1 API
                C:/Java-Training/Libraries/Servlet 3.1 API/servlet-api-3.1.jar
        Predkonfigurovany JDBC driver "MariaDB" nasmerovany na knihovnu "MariaDB JDBC Driver"
        Predkonfigurovany DataSource nad JDBC driverem "MariaDB" do databaze VideoBoss (ktera je pritomna v instalaci MariaDB)
        Predkonfigurovany App Server
            Tomcat (z C:\Java-Training\Tomcat)
                Projektu, co ho pouzivaji, maji prednastaveny classpath na knihovnu "Servlet 3.1 API"
        Plugins
            Nainstalovany JFormDesigner 6.0.2
        Predkonfigurovany Maven
            Path Macros
                <macro name="JAVATRAINING" value="C:/Java-Training" />
                <macro name="M2_HOME" value="C:/Java-Training/Maven" />
                <macro name="M2_REPOSITORY" value="C:/Java-Training/Libraries" />
                <macro name="M2_USER_HOME" value="C:/Java-Training/User-Config/.m2" />
            V Default projektu
                <option name="mavenHome" value="$M2_HOME$" />
                <option name="userSettingsFile" value="$M2_USER_HOME$/settings.xml" />
                <MavenImportingSettings>
                    <option name="downloadSourcesAutomatically" value="true" />
                </MavenImportingSettings>

    Zmeny nutne pro provoz:
        Updaty IntelliJ IDEA vypnuty (nutne kvuli nerozbiti instalace)
        Vypnuti klavesove zkratky Alt+. (Custom folding) kvuli ceske klavesnici
        Project default
            Exclude *.jfd z resources ... *.jfd je konfiguracni soubor JFormDesigneru
                <entry name="!?*.jfd" />
            Kodovani zasadne UTF-8
            Defaultni JDK na "Java SE"
            Defaultni Run konfigurace (Run Manager)
        Sablony novych projektu pro kurzy
            Czechitas Console App
            Czechitas Window App


    Zmeny z didaktickeho hlediska:
        JFormDesigner 6.0.2
             Nastaveni fields visibility na hodnotu package-local (tedy ani private, ani public)
        Vlastni inspections
        Vlastni codestyle
        Vlastni colors (obarvovani syntaxe)
        Editor
            <option name="ARE_LINE_NUMBERS_SHOWN" value="true" />
            <option name="IS_CAMEL_WORDS" value="true" />
            <option name="SHOW_PARAMETER_NAME_HINTS" value="false" />
                ... zrusi strasne matouci zobrazovani jmen parametru ve zdrojovem textu
            <option name="COMPLETION_CASE_SENSITIVE" value="2" />
                ... naseptavani bez ohledu na velikost pismen
            <option name="ADD_UNAMBIGIOUS_IMPORTS_ON_THE_FLY" value="true" />
                ... automaticke pridavani importu u trid, ktere jsou jednoznacne. Odstrani otravnou modrou bublinu "Alt+Enter to import"
            <EXCLUDED_PACKAGE NAME="java.awt.List" />
            <EXCLUDED_PACKAGE NAME="javax.activation" />
            <EXCLUDED_PACKAGE NAME="javax.swing.tree.RowMapper" />
                ... zakaze nepouzivane tridy, aby nebyl problem s List, DataSource a RowMapper
            <option name="ADD_IMPORTS_ON_PASTE" value="1" />
                ... samo pridava importy pri copy+paste z cizi aplikace, pokud jsou jednoznacne
            <component name="CodeFoldingSettings">
                <option name="COLLAPSE_IMPORTS" value="false" />
                <option name="COLLAPSE_FILE_HEADER" value="false" />
            </component>
                .. zadne collapsovani bloku. pro zacatecniky je to matouci
        Volba po otevreni projektu v IDE:
            <option name="hideEmptyPackages" value="false" />   ... zaridi, ze bude vzdy videt cela slozkova struktura baliku, ne collapsovane baliky cz.czechitas.nazevappky   (z didaktickych duvodu)
        Setter template
            prenastaveny setter tak, aby nebyl
                public void setPropertyName(Typ propertyName)
            ale
                public void setPropertyName(Typ newValue)
            (z didaktickych duvodu)


    Zmeny, ktere preferuji ja sam:
        Live Template
            main nebo psvm pro rozbaleni public static void main()
            Jeste nejake dalsi?
        Vlastni keymap (pridana klavesova zkratka pro zavreni projektu Ctrl+Alt+Shift+F4)
        Prenastaveny editor:
            <option name="IS_VIRTUAL_SPACE" value="true" />
        Ide.general settings
            <option name="confirmExit" value="false" />
            <option name="showTipsOnStartup" value="false" />


V pripade, ze si chcete nainstalovat vlastni instalaci:
------------------------------------------------------
Pozn: Vyrazne to nedoporucuji, protoze je to hodne prace a nebudete mit slucitelne prostredi s tim, co studentky

Minimalni pozadavky na kurz:
1. Nainstalovat JDK 8
2. Nainstalovat IntelliJ IDEA 2016
3. Nastavit v IntelliJ IDEA
    1. JDK pod jmenem "Java SE"
        Po startu IntelliJ IDEA, jeste pred otevreni libovolneho projektu zvolit (dole) Configure -> Project Defaults -> Project Structure -> Odrazka Project -> Project SDK -> New JDK -> Zvolit napr. C:\Program Files\Java\jdk1.8.0_162 -> OK. Dale zvolit Edit -> Name prejmenovat na "Java SE" (bez uvozovek).
    2. Cesty k Mavenu
        Configure -> Settings -> Appearance & Behaviour -> Path Variables -> Pridat (+):
            M2_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2016.3.7\plugins\maven\lib\maven3
            M2_REPOSITORY=$USER_HOME$/.m2/repository
            M2_USER_HOME=$USER_HOME$/.m2

            (Cesta pro M2_HOME se lissi: Bud vlozte cestu k Mavenu, ktery mate nainstalovany nebo pouzijte cestu uvnitr IntelliJ IDEA/plugins/maven/lib/maven3 pro zabudovany Maven)
    3. Nastavit univerzalne UTF-8
    4. Nastavit v Project Defaults polozku Compiler exclude pro priponu *.jfd
4. Nainstalovat JFormDesigner 6.0.2 plugin do IntelliJ IDEA z [JFormDesigner.com](http://www.formdev.com/jformdesigner/)
