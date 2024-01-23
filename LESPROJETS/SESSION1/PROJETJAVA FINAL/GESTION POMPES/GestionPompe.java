import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GestionPompe {
    public static void main(String[] args) {
    System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Initialiser les stations
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Commande> commandes = new ArrayList<>();
        ArrayList<Approvisionnement> approvisionnements = new ArrayList<>();
        ArrayList<Vente> ventes = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Enregistrer station");
            System.out.println("2. Modifier quantité de gallon de gazoline et/ou de Diesel d'une station");
            System.out.println("3. Afficher toutes les stations");
            System.out.println("4. Afficher la station ayant le moins de réserve de diesel et/ou gazoline");
            System.out.println("5. Afficher la station ayant le plus de réserve de diesel et/ou gazoline");
            System.out.println("6. Enregistrer commande");
            System.out.println("7. Afficher toutes les commandes");
            System.out.println("8. Supprimer une commande par l’administrateur");
            System.out.println("9. Lancer approvisionnement");
            System.out.println("10.Afficher tous les approvisionnements");
            System.out.println("11. Enregistrer vente");
            System.out.println("12. Afficher toutes les ventes");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            System.out.println();

            switch (choix) {
                case 1:
                // Enregistrer stations
                String[] nomsStations = {"Tabarre", "Gressier", "Mirebalais", "Petionville"};
                for (String nomStation : nomsStations) {
                    System.out.println("\nEnregistrement de la station : " + nomStation);
                    System.out.print("Capacité en gallon de gazoline : ");
                    double capaciteGazoline = scanner.nextDouble();
                    System.out.print("Capacité en gallon de diesel : ");
                    double capaciteDiesel = scanner.nextDouble();
                    stations.add(new Station(nomStation, capaciteGazoline, capaciteDiesel));
                }
                System.out.println("Stations enregistrées avec succès.");
                break;

                case 2:
                    // Modifier quantité de gallon
                    System.out.print("Nom de la station : ");
                    String nomStationModif = scanner.next();
                    System.out.print("Quantité de gallon de gazoline à ajouter/retirer : ");
                    double quantiteGazolineModif = scanner.nextDouble();
                    System.out.print("Quantité de gallon de diesel à ajouter/retirer : ");
                    double quantiteDieselModif = scanner.nextDouble();

                    for (Station station : stations) {
                        if (station.getNom().equalsIgnoreCase(nomStationModif)) {
                            station.approvisionner(quantiteDieselModif, quantiteGazolineModif);
                            break;
                        }
                    }
                    break;

                case 3:
                    // Afficher toutes les stations
                    for (Station station : stations) {
                        System.out.println(station);
                    }
                    break;

                case 4:
                    // Afficher la station ayant le moins de réserve
                    Station stationMinReserve = Collections.min(stations, Comparator
                            .comparingDouble(s -> s.getQuantiteGallonDiesel() + s.getQuantiteGallonGazoline()));
                    System.out.println("Station avec le moins de réserve : " + stationMinReserve);
                    break;

                case 5:
                    // Afficher la station ayant le plus de réserve
                    Station stationMaxReserve = Collections.max(stations, Comparator
                            .comparingDouble(s -> s.getQuantiteGallonDiesel() + s.getQuantiteGallonGazoline()));
                    System.out.println("Station avec le plus de réserve : " + stationMaxReserve);
                    break;

                case 6:
                    // Enregistrer commande
                    GestionCommande.enregistrerCommande(stations, commandes);
                    break;

                case 7:
                    // Afficher toutes les commandes
                    GestionCommande.afficherToutesCommandes(commandes);
                    break;

                case 8:
                    // Supprimer une commande par l’administrateur
                    GestionCommande.supprimerCommande(commandes);
                    break;
                case 9:
                    // Lancer approvisionnement
                    GestionApprovisionnement.enregistrerApprovisionnement(stations, approvisionnements);
                    break;

                case 10:
                    // Afficher tous les approvisionnements
                    GestionApprovisionnement.afficherTousApprovisionnements(approvisionnements);
                    break;

                case 11:
                    // Enregistrer vente
                    GestionVente.enregistrerVente(stations, ventes);
                    break;

                case 12:
                    // Afficher toutes les ventes
                    GestionVente.afficherToutesVentes(ventes);
                    break;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        }
    }
}
