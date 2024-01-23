import java.util.ArrayList;
import java.util.Scanner;

public class GestionCommande{
    public static void enregistrerCommande(ArrayList<Station> stations, ArrayList<Commande> commandes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enregistrement d'une nouvelle commande ===");
        
        // Afficher le pourcentage d'utilisation pour chaque station
        for (Station station : stations) {
            System.out.println(station.getNom() + ":");
            System.out.println("  - Pourcentage d'utilisation Gazoline: " + station.getPourcentageUtilisationGazoline() + "%");
            System.out.println("  - Pourcentage d'utilisation Diesel: " + station.getPourcentageUtilisationDiesel() + "%");
        }

        // Générer et enregistrer automatiquement la nouvelle commande
        double totalGallonsDieselManquants = stations.stream().mapToDouble(s -> s.getCapaciteDiesel() - s.getQuantiteGallonDiesel()).sum();
        double totalGallonsGazolineManquants = stations.stream().mapToDouble(s -> s.getCapaciteGazoline() - s.getQuantiteGallonGazoline()).sum();

        double quantiteGallonDieselCommande = 1.10 * totalGallonsDieselManquants;
        double quantiteGallonGazolineCommande = 1.25 * totalGallonsGazolineManquants;

        Commande nouvelleCommande = new Commande(quantiteGallonDieselCommande, quantiteGallonGazolineCommande);

        // Passer toutes les anciennes commandes à l'état "P"
        for (Commande ancienneCommande : commandes) {
            ancienneCommande.setEtat('P');
        }

        // Afficher la nouvelle commande générée
        System.out.println("Nouvelle commande générée automatiquement:");
        System.out.println(nouvelleCommande);

        // Demander à l'administrateur s'il veut enregistrer la commande
        System.out.print("Voulez-vous enregistrer cette commande? (O/N): ");
        char confirmation = scanner.next().charAt(0);

        if (confirmation == 'O' || confirmation == 'o') {
            commandes.add(nouvelleCommande);
            System.out.println("Commande enregistrée avec succès.");
        } else {
            System.out.println("Enregistrement de commande annulé.");
        }
    }

    public static void afficherToutesCommandes(ArrayList<Commande> commandes) {
        System.out.println("=== Liste de toutes les commandes ===");
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    public static void supprimerCommande(ArrayList<Commande> commandes) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID de la commande à supprimer : ");
        int idCommandeSupprimer = scanner.nextInt();

        for (Commande commande : commandes) {
            if (commande.getId() == idCommandeSupprimer) {
                commandes.remove(commande);
                System.out.println("Commande supprimée avec succès.");
                return;
            }
        }

        System.out.println("Aucune commande trouvée avec l'ID spécifié.");
    }
}
