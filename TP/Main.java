import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> mots = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // a. Saisir des mots jusqu'à ce que l'utilisateur entre le mot "Fin"
        String mot;
        do {
            System.out.print("Veuillez saisir un mot (ou 'Fin' pour terminer) : ");
            mot = scanner.nextLine();

            if (!mot.equalsIgnoreCase("Fin")) {
                mots.add(mot);
            }
        } while (!mot.equalsIgnoreCase("Fin"));

        if (mots.isEmpty()) {
            System.out.println("Aucun mot saisi.");
        } else {
            // b. Afficher le premier mot dans l'ordre alphabétique
            Collections.sort(mots);
            System.out.println("Le premier mot dans l'ordre alphabétique : " + mots.get(0));

            // c. Afficher le dernier mot dans l'ordre alphabétique
            System.out.println("Le dernier mot dans l'ordre alphabétique : " + mots.get(mots.size() - 1));
        }

        scanner.close();
    }
}
