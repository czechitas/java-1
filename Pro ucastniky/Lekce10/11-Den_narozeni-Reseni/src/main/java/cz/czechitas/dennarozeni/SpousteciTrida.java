package cz.czechitas.dennarozeni;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Scanner nacitacRadku = new Scanner(System.in);

        System.out.print("Zadejte den narozeni: ");
        int den = nacitacRadku.nextInt();
        System.out.print("Zadejte mesic narozeni: ");
        int mesic = nacitacRadku.nextInt();
        System.out.print("Zadejte rok narozeni: ");
        int rok = nacitacRadku.nextInt();

        LocalDate datumNarozeni = LocalDate.of(rok, mesic, den);
        DayOfWeek denNarozeni = datumNarozeni.getDayOfWeek();
        System.out.println("Byl to den v tydnu: " + denNarozeni);

        /*
        // Varianta s pouzitim objektu DateTimeFormatter
        System.out.print("Zadejte datum narozeni:");
        String radek = nacitacRadku.nextLine();

        DateTimeFormatter prevadecDatumu = DateTimeFormatter.ofPattern("d.[ ]M.[ ]yyyy");
        LocalDate datumNarozeni = LocalDate.parse(radek, prevadecDatumu);

        System.out.println("Byl to den v tydnu: " + datumNarozeni.getDayOfWeek());

        DateTimeFormatter prevadecDneVTydnu = DateTimeFormatter.ofPattern("EEEE");
        String denNarozeni = prevadecDneVTydnu.format(datumNarozeni);
        System.out.println("Byl to den v tydnu: " + denNarozeni);
        */
    }

}
