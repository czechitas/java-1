Cil lekce:
---------
Prvni poradna okenni aplikace.
Zalozit si aplikaci.
Naucit se pracovat s designerem a MigLayoutem.


Poznamky:
--------
V teto hodine jsem zamerne neukazal studentkam, jak si nastavi obsluhu udalosti pri stisku tlacitka nebo kliknuti mysi.
Minule roky jsem to udelal a dopadlo to tak, ze nebyl poradne cas ani na nauceni se prace s designerem, ani na pochopeni, jak funguji udalosti. Takze jsem se poucil a neukazoval programovani.

MigLayout - doporucuji striktne pouzivat vsude pouze MigLayout nebo pozicovani po pixelech (layout=null), napr. v pozdejsich hodinach pri programovani her typu Pongu nebo Bludiste.

Jmenne konvence
    Doporucuji striktne dodrzovat jmenne konvence. Netrvam na techto, ale naucte studentky si udrzovat zdrojovy text usporadany:
    JTextField ... editNazevPrvku
    JButton ...... btnNazevPrvku
    JLabel ....... labNazevPrvku
    obsluha actionPerformed ......... priStiskuNazevTlacitka
    obsluha mouseClicked ............ priKliknutiNaNazevTlacitka
    obsluha keyTyped ................ priZmacnutiKlavesy
    obsluha windowOpened ............ priOtevreniOkna
    obsluha windowClosing ........... priZaviraniOkna
    custom post-initializace okna ... priInicializaciOkna


Priklady:
--------
Desktopova aplikace v Jave bez designeru
    Vysel jsem z sablony User Defined -> Java Console App
    Pozn: Ukazal jsem, ze je tam stejne rozdeleni na SpousteciTridu a HlavniOkno, jak jsme to meli v druhe Zelve Zofce.
    Pozn: Aplikaci jsme programovali spolu - resp. ja jsem psal na projektoru a studentky si ji opisovaly. Nesazejte moc na to, ze si budou neco pamatovat. Jde ale o to, aby ta okenni aplikace, kterou nasledne vytvorime pomoci designeru nebyla uplne jak z jineho sveta.


Desktopova aplikace z sablony User Defined -> Java Desktop App
    Napriklad Pozdrav:
    +---------------------------------------+
    |                      +--------------+ |
    | Zadejte svoje jmeno: |              | |
    |                      +--------------+ |
    |          +===============+            |
    |          |   Pozdravit   |            |
    |          +===============+            |
    +---------------------------------------+

    Pokud studentkam budete chtit ukazat obsluhu udalosti actionPerformed na tlacitku, udelejte to opravdu jen jako ukazku a reknete jim, at si to neopisuji, jen se divaji. V tom pripade to jde udelat rychle a zabavne behem 3-5 minut. Kdyby si to psaly, je to prace na pul hodiny a ztratil by se tim jednoznacny cil hodiny.

Desktopova aplikace
    Prevod jednotek z mil na kilometry
    Vypocet DPH
    Vypocet uroku
    Vypocet hodnoceni v karetni hre
    nebo cokoliv dalsiho se zadavacimi boxiky a tlacitky, kde se pekne ukaze moznost navrhnout si vlastni appku pomoci designeru a MigLayoutu.



Domaci ukol:
-----------
Navrhnout pomoci designeru uzivatelske rozhrani aplikaci typu kalkulacky, textoveho editoru nebo jakekoliv jine trochu slozitejsi aplikace.
    Idealne nechat studentkam vybrat bud takovou, ktera uz existuje, aby s tim ty studentky, ktere nemaji kreativni naladu, nemusely bojovat. A nebo naopak takove appky, kterou by studentky chtely napsat nebo vylepsit.
