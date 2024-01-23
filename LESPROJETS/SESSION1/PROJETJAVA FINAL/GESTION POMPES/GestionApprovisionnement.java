import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GestionApprovisionnement {
    public static void enregistrerApprovisionnement(ArrayList<Station> stations, ArrayList<Approvisionnement> approvisionnements) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enregistrement d'un nouvel approvisionnement ===");
        
        // Afficher les stations disponibles
        System.out.println("Stations disponibles :");
        for (Station station : stations) {
            System.out.println(station.getNom());
        }

        // Demander à l'administrateur de choisir une station
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
            System.out.println("Station non trouvée. Enregistrement d'approvisionnement annulé.");
            return;
        }

        // Demander à l'administrateur de saisir les quantités de gazoline et de diesel
        System.out.print("Quantité de gallon de gazoline à approvisionner : ");
        double quantiteGazoline = scanner.nextDouble();
        System.out.print("Quantité de gallon de diesel à approvisionner : ");
        double quantiteDiesel = scanner.nextDouble();

        // Créer un nouvel approvisionnement et l'ajouter à la liste
        Approvisionnement nouvelApprovisionnement = new Approvisionnement(stationChoisie, quantiteDiesel, quantiteGazoline);
        approvisionnements.add(nouvelApprovisionnement);

        // Demander à l'administrateur de confirmer l'enregistrement de l'approvisionnement
        System.out.print("Voulez-vous enregistrer cet approvisionnement? (O/N): ");
        char confirmation = scanner.next().charAt(0);

        if (confirmation == 'O' || confirmation == 'o') {
            // Lancer le processus de renflouement des stations à partir de la dernière commande passée (Etat=N)
            renflouerStations(stations, approvisionnements);

            System.out.println("Approvisionnement enregistré avec succès.");
        } else {
            System.out.println("Enregistrement d'approvisionnement annulé.");
        }
    }

    public static void afficherTousApprovisionnements(ArrayList<Approvisionnement> approvisionnements) {
        System.out.println("=== Liste de tous les approvisionnements ===");
        for (Approvisionnement approvisionnement : approvisionnements) {
            System.out.println(approvisionnement);
        }
    }

    private static void renflouerStations(ArrayList<Station> stations, ArrayList<Approvisionnement> approvisionnements) {
        // Trier les approvisionnements par date dans l'ordre décroissant
        Collections.sort(approvisionnements, Comparator.comparing(Approvisionnement::getDateApprovisionnement).reversed());

        // Récupérer la dernière commande passée (Etat=N)
        Approvisionnement dernierApprovisionnement = approvisionnements.stream()
                .filter(appro -> appro.getStation().getPourcentageUtilisationGazoline() == 0 && appro.getStation().getPourcentageUtilisationDiesel() == 0)
                .findFirst()
                .orElse(null);

        // Si une dernière commande est trouvée, renflouer les stations
        if (dernierApprovisionnement != null) {
            for (Station station : stations) {
                station.approvisionner(dernierApprovisionnement.getQuantiteGallonDiesel(), dernierApprovisionnement.getQuantiteGallonGazoline());
            }
            System.out.println("Renflouement des stations effectué avec succès.");
        } else {
            System.out.println("Aucune commande passée trouvée. Les stations ne sont pas renflouées.");
        }
    }
}
