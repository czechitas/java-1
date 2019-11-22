package cz.czechitas.objekty;

import java.awt.*;
import javax.swing.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        /*
        System.out.println("Zdravim, pozemstani! Zavedte me ke svemu vudci");

        int mujVek = 38;
        System.out.println(mujVek);

        Point bodVProstredkuObrazovky = new Point();
        bodVProstredkuObrazovky.x = 683;   // 960
        bodVProstredkuObrazovky.y = 384;   // 540

        Point bodVlevoNahore = new Point();
        bodVlevoNahore.x = 0;
        bodVlevoNahore.y = 0;

        System.out.println(bodVProstredkuObrazovky);
        System.out.println(bodVlevoNahore);

        JFrame okno = new JFrame();
        okno.setLocation(bodVProstredkuObrazovky);
        okno.setVisible(true);

        Dimension rozmeryOkna = new Dimension();
        rozmeryOkna.width = 400;
        rozmeryOkna.height = 400;
        okno.setSize(rozmeryOkna);
        */

        /*
        Autobus busCoJezdiDoLisne = new Autobus();
        busCoJezdiDoLisne.cisloLinky = 78;
        busCoJezdiDoLisne.barva = new Color(201, 32, 31);
        busCoJezdiDoLisne.poradoveCislo = 1;

        Autobus okruzniAutobus = new Autobus();
        okruzniAutobus.cisloLinky = 84;
        okruzniAutobus.barva = new Color(201, 32, 31);
        okruzniAutobus.poradoveCislo = 5;

//        String text = okruzniAutobus.toString();
//        System.out.println(text);

        okruzniAutobus.nechejNastoupit();
        okruzniAutobus.nechejNastoupit();
        okruzniAutobus.nechejNastoupit();
        okruzniAutobus.nechejNastoupit();
        System.out.println(okruzniAutobus.toString());
        okruzniAutobus.nechejVystoupit();
        okruzniAutobus.nechejVystoupit();
        okruzniAutobus.nechejVystoupit();
        okruzniAutobus.nechejVystoupit();
        okruzniAutobus.nechejVystoupit();
        System.out.println(okruzniAutobus.toString());

        busCoJezdiDoLisne.nechejNastoupit();
        busCoJezdiDoLisne.nechejNastoupit();
        busCoJezdiDoLisne.nechejNastoupit();
        busCoJezdiDoLisne.nechejNastoupit();
        System.out.println(busCoJezdiDoLisne.toString());
        */


        /*
        Point levyBod = new Point();
        levyBod.x = 10;
        levyBod.y = 20;

        Point pravyBod = new Point();
        pravyBod.x = 60;
        pravyBod.y = 50;

        Usecka mojeCara = new Usecka();
        mojeCara.bodA = levyBod;
        mojeCara.bodB = pravyBod;
        System.out.println(mojeCara.toString());
        System.out.println(mojeCara.vypocitejDelku());
        */

/*
        Usecka mojeCara = new Usecka();
        mojeCara.bodA = new Point();
        mojeCara.bodA.x = 11;
        mojeCara.bodA.y = 21;
        mojeCara.bodB = new Point();
        mojeCara.bodB.x = 61;
        mojeCara.bodB.y = 51;
*/

/*
        Usecka mojeCara = new Usecka();
        mojeCara.bodA.x = 11;
        mojeCara.bodA.y = 21;
        mojeCara.bodB.x = 61;
        mojeCara.bodB.y = 51;
*/


        Point mujBod1 = new Point();
        mujBod1.x = 10;
        mujBod1.y = 10;

        Point mujBod2 = new Point();
        mujBod2.x = 10;
        mujBod2.y = 15;

        Point mujBod3 = new Point();
        mujBod3.x = 22;
        mujBod3.y = 10;

        Trojuhelnik mujTroj1 = new Trojuhelnik();
        mujTroj1.bodA = mujBod1;
        mujTroj1.bodB = mujBod2;
        mujTroj1.bodC = mujBod3;
        System.out.println(mujTroj1.toString());
        System.out.println(mujTroj1.vypocitejObsah());

    }

}
