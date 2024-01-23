package Essence;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionnaireCommandes {
    private ArrayList<Commande> commandes;
    private ArrayList<Station> stations;
    private Scanner scanner;

    public GestionnaireCommandes() {
        commandes = new ArrayList<>();
        stations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void enregistrerCommande() {   
        // Demander à l'utilisateur de choisir une station
        System.out.print("Selectionnez le numero de la station(1 a 4) : ");
        int choixStation = scanner.nextInt();

        
        if (choixStation >= 1 && choixStation <= stations.size()) {
            Station station = stations.get(choixStation - 1);
            
            // Demander à l'utilisateur la quantité de gazoline et de diesel nécessaires
            System.out.print("Quantite de gazoline necessaire (en gallons) : ");
            int quantiteGazoline = scanner.nextInt();
            
            System.out.print("Quantite de diesel necessaire (en gallons) : ");
            int quantiteDiesel = scanner.nextInt();
            
            // Afficher le pourcentage d'utilisation d'essence et de gazoline de la station
            System.out.println("Pourcentage d'utilisation d'essence : " + station.getPourcentageUtilisationGazoline() + "%");
            System.out.println("Pourcentage d'utilisation de gazoline : " + station.getPourcentageUtilisationDiesel() + "%");
            
            // Calculer les quantités de gazoline et de diesel manquantes
            int gazolineManquante = quantiteGazoline - station.getQuantiteGazolineDisponible();
            int dieselManquant = quantiteDiesel - station.getQuantiteDieselDisponible();
            
            // Calculer les quantités de gazoline et de diesel de la commande
            int quantiteGazolineCommande = (int) (1.25 * gazolineManquante);
            int quantiteDieselCommande = (int) (1.10 * dieselManquant);
            
            // Demander à l'utilisateur s'il souhaite enregistrer la commande
            System.out.print("Voulez-vous enregistrer cette commande ? (O/N) : ");
            String choixEnregistrer = scanner.next();
            
            if (choixEnregistrer.equalsIgnoreCase("O")) {
                // Créer et enregistrer la commande dans la liste de commandes
                Commande nouvelleCommande = new Commande(quantiteDieselCommande, quantiteGazolineCommande, "date_commande", "N");
                commandes.add(nouvelleCommande);
                
                // Mettre à jour l'état des anciennes commandes
                for (Commande commande : commandes) {
                    commande.setEtat("P");
                }
                
                System.out.println("La commande a ete enregistree avec succes !");
            } else {
                System.out.println("La commande a ete annulee.");
            }
        } else {
            System.out.println("Choix de station invalide !");
        }
    }
    

    public void afficherCommandes() {
        if (commandes.isEmpty()) {
            System.out.println("Aucune commande enregistree.");
        } else {
            System.out.println("----- LISTE DES COMMANDES -----");
            for (Commande commande : commandes) {
                commande.afficherCommande();
                System.out.println("--------------------");
            }
        }
    }
   
}
