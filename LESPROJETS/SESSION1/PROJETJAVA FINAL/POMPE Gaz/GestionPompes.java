import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Station {
    String nom;
    double capaciteGazoline;
    double pourcentageUtilisationGazoline;
    double capaciteDiesel;
    double pourcentageUtilisationDiesel;
    double quantiteGallonDiesel;
    double quantiteGallonGazoline;

    public Station(String nom, double capaciteGazoline, double capaciteDiesel) {
        this.nom = nom;
        this.capaciteGazoline = capaciteGazoline;
        this.pourcentageUtilisationGazoline = 100;
        this.capaciteDiesel = capaciteDiesel;
        this.pourcentageUtilisationDiesel = 100;
        this.quantiteGallonDiesel = 0;
        this.quantiteGallonGazoline = 0;
    }

    // Méthode pour effectuer une vente
    public void vendre(double quantiteDiesel, double quantiteGazoline) {
        if (quantiteDiesel <= quantiteGallonDiesel && quantiteGazoline <= quantiteGallonGazoline) {
            quantiteGallonDiesel -= quantiteDiesel;
            quantiteGallonGazoline -= quantiteGazoline;
            pourcentageUtilisationDiesel = (quantiteGallonDiesel / capaciteDiesel) * 100;
            pourcentageUtilisationGazoline = (quantiteGallonGazoline / capaciteGazoline) * 100;
            System.out.println("Vente effectuée avec succès.");
        } else {
            System.out.println("Stock insuffisant pour effectuer la vente.");
        }
    }

    // Méthode pour approvisionner en carburant
    public void approvisionner(double quantiteDiesel, double quantiteGazoline) {
        quantiteGallonDiesel += quantiteDiesel;
        quantiteGallonGazoline += quantiteGazoline;
        pourcentageUtilisationDiesel = 0;
        pourcentageUtilisationGazoline = 0;
        System.out.println("Approvisionnement effectué avec succès.");
    }

    @Override
    public String toString() {
        return "Station{" +
                "nom='" + nom + '\'' +
                ", pourcentageUtilisationGazoline=" + pourcentageUtilisationGazoline +
                ", pourcentageUtilisationDiesel=" + pourcentageUtilisationDiesel +
                ", quantiteGallonDiesel=" + quantiteGallonDiesel +
                ", quantiteGallonGazoline=" + quantiteGallonGazoline +
                '}';
    }
}

public class GestionPompes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialiser les stations
        ArrayList<Station> stations = new ArrayList<>();
        stations.add(new Station("Tabarre", 5000, 3000));
        stations.add(new Station("Pétion-ville", 6000, 3500));
        stations.add(new Station("Gressier", 4000, 2500));
        stations.add(new Station("Mirebalais", 4500, 2800));

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Enregistrer station");
            System.out.println("2. Modifier quantité de gallon de gazoline et/ou de Diesel d’une station");
            System.out.println("3. Afficher toutes les stations");
            System.out.println("4. Afficher la station ayant le moins de réserve de diesel et/ou gazoline");
            System.out.println("5. Afficher la station ayant le plus de réserve de diesel et/ou gazoline");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Enregistrer station
                    System.out.print("Nom de la station : ");
                    String nomStation = scanner.next();
                    System.out.print("Capacité en gallon de gazoline : ");
                    double capaciteGazoline = scanner.nextDouble();
                    System.out.print("Capacité en gallon de diesel : ");
                    double capaciteDiesel = scanner.nextDouble();
                    stations.add(new Station(nomStation, capaciteGazoline, capaciteDiesel));
                    System.out.println("Station enregistrée avec succès.");
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
                        if (station.nom.equalsIgnoreCase(nomStationModif)) {
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
                    Station stationMinReserve = Collections.min(stations, Comparator.comparingDouble(s -> s.quantiteGallonDiesel + s.quantiteGallonGazoline));
                    System.out.println("Station avec le moins de réserve : " + stationMinReserve);
                    break;

                case 5:
                    // Afficher la station ayant le plus de réserve
                    Station stationMaxReserve = Collections.max(stations, Comparator.comparingDouble(s -> s.quantiteGallonDiesel + s.quantiteGallonGazoline));
                    System.out.println("Station avec le plus de réserve : " + stationMaxReserve);
                    break;

                case 6:
                    // Quitter
                    System.out.println("Merci d'avoir utilisé le système. Au revoir!");
                    System.exit(0);
                    break;


                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        }
    }
}
