import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        GestionCompagnieVoitures gestionCompagnieVoitures = new CompagnieVoitures();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Gestion de la compagnie de location de voitures ---");
            System.out.println("1. Enregistrer une voiture");
            System.out.println("2. Afficher toutes les voitures");
            System.out.println("3. Rechercher une voiture par son code");
            System.out.println("4. Modifier le prix de vente d'une voiture par son code");
            System.out.println("5. Supprimer une voiture par son code");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            System.out.println();

            switch (choix) {
                case 1:
                gestionCompagnieVoitures.enregistrerVoiture(null);
                    break;

                case 2:
                    gestionCompagnieVoitures.afficherToutesVoitures();
                    break;

                case 3:
                gestionCompagnieVoitures.rechercherVoitureParCode("");
                    break;

                case 4:
                gestionCompagnieVoitures.modifierPrixVoiture("", 0);
                    break;

                case 5:
                    gestionCompagnieVoitures.supprimerVoitureParCode("");
                    break;

                case 6:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
