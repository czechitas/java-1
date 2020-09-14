package cz.czechitas.pexeso;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Pomocnik {

    /**
     * Metoda nacte radky ze souboru na dane ceste
     *
     * @param soubor soubor ktery chceme cist
     * @return Seznam radku nebo prazdny seznam pokud nastala chyba
     */
    public List<String> nactiRadkySouboru(File soubor) { // Tady jsme oproti 8. lekci upravili parametr
        try {
            Path cesta = soubor.toPath();  // Zjistime cestu k souboru
            List<String> radky = Files.readAllLines(cesta);
            return radky;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    /**
     * Metoda zapise radky do souboru
     * @param radky seznam jednotlivych radku
     * @param soubor soubor ktery chceme zapisovat
     */
    public void zapisRadkyDoSouboru(List<String> radky, File soubor) { // Tady jsme oproti 8. lekci upravili parametr
        String obsah = String.join(System.lineSeparator(), radky); // Zjistime cestu k souboru
        try {
            Path cesta = soubor.toPath();
            Files.write(cesta, obsah.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageIcon nactiIkonku(String soubor) {
        try {
            return new ImageIcon(ImageIO.read(getClass().getResourceAsStream(soubor)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
