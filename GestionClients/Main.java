import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionClients gestionClients = new GestionClients();
        String choix;

        do {
            System.out.println("\n---- Menu ----");
            System.out.println("a) Ajouter un client");
            System.out.println("b) Rechercher un client par son nom");
            System.out.println("c) Modifier le téléphone d'un client");
            System.out.println("d) Modifier le pourcentage de rabais d'un client");
            System.out.println("e) Supprimer un client par son nom");
            System.out.println("f) Supprimer un client par son code");
            System.out.println("g) Afficher le premier client");
            System.out.println("h) Afficher le dernier client");
            System.out.println("i) Afficher les clients par ordre croissant de nom");
            System.out.println("j) Afficher les clients par ordre décroissant de nom");
            System.out.println("k) Afficher le client avant et après un client spécifié");
            System.out.println("q) Quitter");

            System.out.print("Votre choix : ");
            choix = scanner.nextLine();

            switch (choix) {
                case "a":
                    gestionClients.ajouterClient(null);
                    break;
                case "b":
                gestionClients.rechercherClientParNom("");
                    break;
                case "c":
                gestionClients.modifierTelephoneClient(0, "choix");
                    break;
                case "d":
                gestionClients.modifierPourcentageRabaisClient(0, 0);
                    break;
                case "e":
                gestionClients.supprimerClientParNom("");
                    break;
                case "f":
                gestionClients.supprimerClientParCode(0);
                    break;
                case "g":
                    gestionClients.afficherPremierClient();
                    break;
                case "h":
                    gestionClients.afficherDernierClient();
                    break;
                case "i":
                    gestionClients.afficherClientsOrdreCroissant();
                    break;
                case "j":
                    gestionClients.afficherClientsOrdreDecroissant();
                    break;
                case "k":
                gestionClients.afficherClientAvantEtApres(null);
                    break;
                case "q":
                    System.out.println("Programme terminé.");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        } while (!choix.equalsIgnoreCase("q"));
    }

}
