import java.util.Scanner;

public class Menu {
    public void afficherMenu() {
        GestionEntreprise gestionEntreprise = new GestionEntreprise();
        Scanner scanner = new Scanner(System.in);

        int choix = 0;
        do{
            System.out.println("Menu :");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Afficher la liste des employés");
            System.out.println("3. Calculer la masse salariale");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            System.out.println();

            switch (choix) {
                case 1:
                    gestionEntreprise.ajouterEmploye();
                    System.out.println();
                    break;
                case 2:
                    gestionEntreprise.afficherListeEmployes();
                    System.out.println();
                    break;
                case 3:
                    gestionEntreprise.calculerMasseSalariale();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
          }  while (choix != 4) ;

        

        scanner.close(); // Fermer le scanner une fois terminé
    }


}