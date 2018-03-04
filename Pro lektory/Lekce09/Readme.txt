Cil lekce:
---------
Napsat si vlastni malou hru Pong
Pochopit JKeyboard
Detekce kolizi


Priklady:
--------
Ping Pong s hraci
    V okne vyrobime objekt JKeyboard a ten umoznuje testovat stav klaves
    Na okno polozime dva labely s obrazky hracu
    V obsluze timeru budeme nejen hybat mickem, ale i testovat klavesy a hybat hraci
    Ukazeme studentkam diagram a nechame jim naprogramovat metodu detekujKolizi s touhle signaturou:
    private boolean detekujKolizi(JLabel komponenta1, JLabel komponenta2) {
    }


    Po nejake dobe napovime:
    private boolean detekujKolizi(JLabel komponenta1, JLabel komponenta2) {
        int ax = komponenta1.getX();
        int ay = komponenta1.getY();

        int cx = komponenta2.getX();
        int cy = komponenta2.getY();

        if (neco) {
            return true;
        } else {
            return false;
        }
    }


    Nakonec jim dodame reseni:
    private boolean detekujKolizi(JLabel komponenta1, JLabel komponenta2) {
        int ax = komponenta1.getX();
        int ay = komponenta1.getY();
        int bx = ax + komponenta1.getWidth();
        int by = ay + komponenta1.getHeight();
        int cx = komponenta2.getX();
        int cy = komponenta2.getY();
        int dx = cx + komponenta2.getWidth();
        int dy = cy + komponenta2.getHeight();

        if (ax <= dx && ay <= dy
                && cx <= bx && cy <= by) {
            return true;
        } else {
            return false;
        }
    }


Domaci ukol:
-----------
Pruchod bludistem
    Na plochu okna vlozime obrazek hlavniho hrdiny
        Napr. R2D2
    Na plochu okna vlozime nekolik labelu, obarvime jim pozadi na barvu a nastavime opaque=true (nepruhlednost). Udelame z nich bludiste.
    Cilem je nechat hraci ovladat robota a projit s nim bludistem.
    Je nutne, aby program testoval pri kazdem pohybu kolizi robota a vsech zdi.
    Vitezstvi se pozna vkrocenim na cilovy label (take detekce kolize).

    Mozna rozsireni:
        Otaceni robota - jiny sprite doleva, doprava, nahoru, dolu
        Nutnost nejprve dojit v bludisti ke klici a pak teprve k cilovym dverim
        Priserky
            Samopohybujici se priserky!
            Tresnicky
        Pacman

    Studentky se budou ptat na List<JLabel>, aby mohly v cyklu testovat kolize.
    Na Facebooku pri supportovani domaciho ukolu to lze uvest, ale nerikal bych to vsem. Jen tem, co se ptaji.
    List ukazat az na hodine.
        Pozn: Array neukazovat. Pokud se na pole budou studentky ptat, doporucuju rict, ze v nekterych jazycich, napr. JavaScriptu je pole a seznam to stejne, v Jave je to mirny rozdil a ze seznam je flexibilnejsi a ma se pouzivat. Pole je jen pro implementacni detaily, kdyz je vyzadovan presny rozsah alokace pameti.
