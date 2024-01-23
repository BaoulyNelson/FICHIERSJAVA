import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgrammePrincipal {
    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Map<String, Bachelier> bacheliers = new HashMap<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. inscrire un bachelier");
            System.out.println("2. enregistrer les notes d'un bachelier");
            System.out.println("3. Vérifier le statut d'un bachelier");
            System.out.println("4. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après le nombre
            System.out.println();

            switch (choix) {
                case 1:
                    ProgrammeBacheliers.inscrireBachelier(scanner, bacheliers);
                    System.out.println();
                    break;
                case 2:
                    ProgrammeBacheliers.enregistrerNotes(scanner, bacheliers);
                    System.out.println();
                    break;
                case 3:
                    ProgrammeBacheliers.verifierStatutBachelier(scanner, bacheliers);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }
}
