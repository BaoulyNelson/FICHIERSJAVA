import java.util.ArrayList;
import java.util.Scanner;

public class GestionVente{
    public static void enregistrerVente(ArrayList<Station> stations, ArrayList<Vente> ventes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enregistrement d'une nouvelle vente ===");
        
        // Afficher les stations disponibles
        System.out.println("Stations disponibles :");
        for (Station station : stations) {
            System.out.println(station.getNom());
        }

        // Demander à l'utilisateur de choisir une station
        System.out.print("Choisissez une station : ");
        String nomStation = scanner.next();

        // Rechercher la station choisie dans la liste des stations
        Station stationChoisie = null;
        for (Station station : stations) {
            if (station.getNom().equalsIgnoreCase(nomStation)) {
                stationChoisie = station;
                break;
            }
        }

        // Vérifier si la station a été trouvée
        if (stationChoisie == null) {
            System.out.println("Station non trouvée. Enregistrement de vente annulé.");
            return;
        }

        // Demander à l'utilisateur de saisir les quantités de gazoline et de diesel vendues
        System.out.print("Quantité de gallon de gazoline vendue : ");
        double quantiteGazolineVendu = scanner.nextDouble();
        System.out.print("Quantité de gallon de diesel vendue : ");
        double quantiteDieselVendu = scanner.nextDouble();

        // Créer une nouvelle vente et l'ajouter à la liste
        Vente nouvelleVente = new Vente(stationChoisie, quantiteDieselVendu, quantiteGazolineVendu);
        ventes.add(nouvelleVente);

        System.out.println("Vente enregistrée avec succès.");
    }

    public static void afficherToutesVentes(ArrayList<Vente> ventes) {
        System.out.println("=== Liste de toutes les ventes ===");
        for (Vente vente : ventes) {
            System.out.println(vente);
        }
    }
}
