package cz.czechitas.pexeso;

import java.awt.image.*;
import javax.swing.*;

public class JKarta extends JLabel {

    int indexKarty;
    Icon obrazekRubuKarty;
    Icon obrazekLiceKarty;
    boolean jeVidetLic;

    public JKarta(int indexKarty, Icon obrazekLiceKarty, Icon obrazekRubuKarty) {
        this.indexKarty = indexKarty;
        this.obrazekLiceKarty = obrazekLiceKarty;
        this.obrazekRubuKarty = obrazekRubuKarty;
        otocRubemNahoru();
    }

    public int getCisloObrazku() {
        return indexKarty / 2;
    }

    public void otocLicemNahoru() {
        jeVidetLic = true;
        this.setIcon(obrazekLiceKarty);
    }

    public void otocRubemNahoru() {
        jeVidetLic = false;
        this.setIcon(obrazekRubuKarty);
    }

    public void nechejZmizet() {
        setVisible(false);
    }

    public void nechejZobrazit() {
        setVisible(true);
    }

    public boolean getJeZobrazena() {
        return isVisible();
    }

    public boolean getJeVidetLic() {
        return jeVidetLic && getJeZobrazena();
    }
}
