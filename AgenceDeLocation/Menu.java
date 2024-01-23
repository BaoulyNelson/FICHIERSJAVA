
// AgenceGestion.java
import java.util.Scanner;

public class Menu {

    public void afficherMenu() {
        AgenceGestion agenceGestion = new AgenceGestion();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("1. Ajouter un logement");
            System.out.println("2. Ajouter une personne");
            System.out.println("3. Ajouter une commune");
            System.out.println("4. Afficher les informations");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            System.out.println();

            switch (choix) {
                case 1:
                    agenceGestion.ajouterLogement();
                    System.out.println();
                    agenceGestion.afficherInformationsLogement();
                    // Demander à l'utilisateur d'entrer les informations du logement et appeler la
                    // méthode ajouterLogement
                    break;
                case 2:
                    agenceGestion.ajouterPersonne();
                    System.out.println();
                    agenceGestion.afficherInformationsPersonne();
                    // Demander à l'utilisateur d'entrer les informations de la personne et appeler
                    // la méthode ajouterPersonne
                    break;
                case 3:
                    agenceGestion.ajouterCommune();
                    System.out.println();
                    agenceGestion.afficherInformationsCommune();
                    // Demander à l'utilisateur d'entrer les informations de la commune et appeler
                    // la méthode ajouterCommune
                    break;
                case 4:
                    // Afficher les informations, l'historique, etc.
                    break;
                case 5:
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }

        } while (choix != 5);
    }

    // ...
}
