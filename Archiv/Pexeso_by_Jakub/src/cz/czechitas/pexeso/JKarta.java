package cz.czechitas.pexeso;

import java.util.*;
import javax.swing.*;

public class JKarta extends JLabel {

    private int cisloObrazku;
    private Icon obrazekLic;
    private Icon obrazekRub;
    private boolean licemNahoru;

    public JKarta(int cisloObrazku, Icon obrazekLic, Icon obrazekRub) {
        this.cisloObrazku = cisloObrazku;
        this.obrazekLic = obrazekLic;
        this.obrazekRub = obrazekRub;

        this.setVisible(true);
    }

    public int getCisloObrazku() {
        return cisloObrazku;
    }

    public void otocLicemNahoru() {
        licemNahoru = true;
        this.setIcon(obrazekLic);
    }

    public void otocRubemNahoru() {
        licemNahoru = false;
        this.setIcon(obrazekRub);
    }

    public boolean jeVidetLic() {
        return licemNahoru && isVisible();
    }

    public void nechZmizet() {
        this.setVisible(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JKarta)) return false;
        JKarta karta = (JKarta) o;
        return getCisloObrazku() == karta.getCisloObrazku();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCisloObrazku());
    }
}
