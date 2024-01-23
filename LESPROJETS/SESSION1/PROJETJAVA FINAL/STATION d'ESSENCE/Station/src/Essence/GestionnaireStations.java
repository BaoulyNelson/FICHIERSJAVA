package Essence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class GestionnaireStations {
    Station station;
    private ArrayList<Station> stations;
    private Scanner scanner;

    public GestionnaireStations() {
        stations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void enregistrerStation() {
        String nom = "";
        while (true) {
            System.out.print("Nom de la station (Tabarre, Petionville, Gressier ou Mirebalais) : ");
            nom = scanner.nextLine();
            
            if (nom.equalsIgnoreCase("Tabarre") || nom.equalsIgnoreCase("Petionville") || nom.equalsIgnoreCase("Gressier") || nom.equalsIgnoreCase("Mirebalais")) {
                break; // Sortir de la boucle si le nom est valide
            } else {
                System.out.println("Nom de station invalide ! Veuillez saisir l'un des noms suivants : Tabarre, Petionville, Gressier, Mirebalais");
            }
        }
        
        System.out.print("Capacite en gazoline (en gallons) : ");
        int capaciteGazoline = scanner.nextInt();
        System.out.print("Capacite en diesel (en gallons) : ");
        int capaciteDiesel = scanner.nextInt();
        
        // Vider la ligne vide restante dans le scanner
        scanner.nextLine();
        
        Station nouvelleStation = new Station(nom, capaciteGazoline, capaciteDiesel);
        stations.add(nouvelleStation);
        
        System.out.println("La station a ete enregistree avec succes !");
    }
    

    public void modifierQuantiteGazoline() {
        afficherStations();
        System.out.print("Selectionnez le numero de la station a modifier : ");
        int choix = scanner.nextInt();

        if (choix >= 1 && choix <= stations.size()) {
            Station station = stations.get(choix - 1);

            System.out.print("Nouvelle quantite de gazoline (en gallons) : ");
            int nouvelleQuantite = scanner.nextInt();
            station.setQuantiteGazolineDisponible(nouvelleQuantite);

            System.out.println("La quantite de gazoline a ete modifiee avec succes !");
        } else {
            System.out.println("Choix invalide !");
        }
    }

    public void afficherStations() {
        if (stations.isEmpty()) {
            System.out.println("Aucune station enregistree.");
        } else {
            System.out.println("----- LISTE DES STATIONS -----");
            for (int i = 0; i < stations.size(); i++) {
                Station station = stations.get(i);
                System.out.print((i + 1) + ". " + station.getNom()+" avec ");
                System.out.println(" "+station.getCapaciteDiesel()+" Gallons gazolines "+station.getCapaciteGazoline()+" et Gallons diesel ");
            }
        }
    }
   
    public void afficherStationPlusDeReserveGazoline() {
        if (stations.isEmpty()) {
            System.out.println("Aucune station enregistree.");
        } else {
            Station stationMaxGazoline = stations.stream()
                    .max(Comparator.comparingInt(Station::getQuantiteGazolineDisponible))
                    .orElse(null);

            if (stationMaxGazoline != null) {
                System.out.println("----- STATION AVEC LE PLUS DE ReSERVE DE GAZOLINE -----");
                System.out.println("Nom : " + stationMaxGazoline.getNom());
                System.out.println("Quantite de gazoline disponible : " + stationMaxGazoline.getQuantiteGazolineDisponible() + " gallons");
            } else {
                System.out.println("Aucune station avec de la reserve de gazoline enregistre.");
            }
        }
    }
    public void afficherStationPlusDeReserveDiesel() {
        if (stations.isEmpty()) {
            System.out.println("Aucune station enregistre.");
        } else {
            Station stationMaxDiesel = stations.stream()
                    .max(Comparator.comparingInt(Station::getQuantiteDieselDisponible))
                    .orElse(null);

            if (stationMaxDiesel != null) {
                System.out.println("----- STATION AVEC LE PLUS DE RÉSERVE DE DIESEL -----");
                System.out.println("Nom : " + stationMaxDiesel.getNom());
                System.out.println("Quantite de diesel disponible : " + stationMaxDiesel.getQuantiteDieselDisponible() + " gallons");
            } else {
                System.out.println("Aucune station avec de la reserve de diesel enregistre.");
            }
        }
    }

    public void afficherStationMoinsDeReserveGazoline() {
        if (stations.isEmpty()) {
            System.out.println("Aucune station enregistrée.");
        } else {
            Station stationMinGazoline = stations.stream()
                    .min(Comparator.comparingInt(Station::getQuantiteGazolineDisponible))
                    .orElse(null);

            if (stationMinGazoline != null) {
                System.out.println("----- STATION AVEC LE MOINS DE RESERVE DE GAZOLINE -----");
                System.out.println("Nom : " + stationMinGazoline.getNom());
                System.out.println("Quantite de gazoline disponible : " + stationMinGazoline.getQuantiteGazolineDisponible() + " gallons");
            } else {
                System.out.println("Aucune station avec de la réserve de gazoline enregistre.");
            }
        }
    }
    
    public void afficherStationMoinsDeReserveDiesel() {
        if (stations.isEmpty()) {
            System.out.println("Aucune station enregistre.");
        } else {
            Station stationMinDiesel = stations.stream()
                    .min(Comparator.comparingInt(Station::getQuantiteDieselDisponible))
                    .orElse(null);

            if (stationMinDiesel != null) {
                System.out.println("----- STATION AVEC LE MOINS DE RESERVE DE DIESEL -----");
                System.out.println("Nom : " + stationMinDiesel.getNom());
                System.out.println("Quantite de diesel disponible : " + stationMinDiesel.getQuantiteDieselDisponible() + " gallons");
            } else {
                System.out.println("Aucune station avec de la reserve de diesel enregistre.");
            }
        }
    }
}
