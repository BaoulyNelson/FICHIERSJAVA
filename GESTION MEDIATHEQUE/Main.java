import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.afficherMenuPrincipal();
    }
}

 class Menu {

    private GestionMediatheque gestionMediatheque;  // Assurez-vous d'avoir une instance de GestionMediatheque

    public Menu() {
        // Initialisez votre instance de GestionMediatheque ici
        gestionMediatheque = new GestionMediatheque(new Mediatheque("Nom de la mediatheque"));  // Remplacez par votre logique
    }

    public void afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Gestion des Clients");
            System.out.println("2. Gestion des Documents");
            System.out.println("3. Statistiques");
            System.out.println("0. Quitter");
            System.out.print("Veuillez choisir une option : ");
            
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherMenuGestionClients();
                    break;
                case 2:
                gestionMediatheque.afficherMenuGestionDocuments();
                    break;
                case 3:
                    gestionMediatheque.afficherStatistiques();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }

        } while (choix != 0);

        scanner.close();
    }

    private void afficherMenuGestionClients() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nGestion des Clients");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Modifier un client");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Afficher les caractéristiques d'un client");
            System.out.println("0. Retour au menu principal");
            System.out.print("Veuillez choisir une option : ");
            
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                gestionMediatheque.inscrireClient();
                    // Appeler la méthode pour ajouter un client
                    break;
                case 2:
                    // Appeler la méthode pour modifier un client
                    gestionMediatheque.modifierCaracteristiquesClient(null);
                    break;
                case 3:
                gestionMediatheque.supprimerCategorieClient();
                    // Appeler la méthode pour supprimer un client
                    break;
                case 4:
                gestionMediatheque.afficherCaracteristiquesClient(null);
                    // Appeler la méthode pour afficher les caractéristiques d'un client
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }

        } while (choix != 0);

        scanner.close();
    }

  
}
