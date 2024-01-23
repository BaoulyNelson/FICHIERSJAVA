package Essence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        // Création des objets
        GestionnaireStations gestionnaireStations = new GestionnaireStations();
        GestionnaireCommandes gestionnaireCommandes = new GestionnaireCommandes();
        
        // Scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Variable pour stocker le choix de l'utilisateur
        int choix;
        
        // Menu principal
        do {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Enregistrer une station");
            System.out.println("2. Modifier la quantite de gazoline d'une station");
            System.out.println("3. Afficher toutes les stations");
            System.out.println("4. Enregistrer une commande");
            System.out.println("5. Afficher toutes les commandes");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            System.out.println();
            switch (choix) {
                case 1:
                    // Enregistrer une station
                    gestionnaireStations.enregistrerStation();
                    break;
                case 2:
                    // Modifier la quantité de gazoline d'une station
                    gestionnaireStations.modifierQuantiteGazoline();
                    break;
                case 3:
                    // Afficher toutes les stations
                    gestionnaireStations.afficherStations();
                    break;
                case 4:
                    // Enregistrer une commande
                    gestionnaireCommandes.enregistrerCommande();
                    break;  
                case 5:
                    // Afficher toutes les commandes
                    gestionnaireCommandes.afficherCommandes();
                    break;
                case 6:
                    // Quitter le programme
                    System.out.println("Programme termine !");
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
            
            System.out.println();
        } while (choix != 6);
        
        // Fermer le scanner
        scanner.close();
    }
}
