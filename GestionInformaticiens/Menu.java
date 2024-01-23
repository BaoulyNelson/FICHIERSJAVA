import java.util.Scanner;

public class Menu {
    private Concours concours;
    private Scanner scanner;

    public Menu() {
        concours = new Concours();
        scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Enregistrer un candidat en Programmation");
            System.out.println("2. Enregistrer un candidat en Base de Données");
            System.out.println("3. Enregistrer un candidat en Réseau");
            System.out.println("4. Afficher la liste des candidats par domaine");
            System.out.println("5. Afficher la liste de tous les informaticiens(quelque soit le type)");
            System.out.println("6. Afficher les informations du lauréat");
            System.out.println("7. Afficher les informations des 5 premiers lauréats");
            System.out.println("8. Supprimer les 4 derniers candidats(moyenne plus basse)");
            System.out.println("9. Supprimer les 4 derniers candidats(moyenne plus forte)");
            System.out.println("10. Quitter");
            System.out.print("Choisissez une option : ");
            int choix;
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                continue;
            }
            System.out.println();

            switch (choix) {
                case 1:
                    concours.enregistrerCandidatProgrammation();
                    System.out.println();
                    break;
                case 2:
                    concours.enregistrerCandidatBaseDeDonnees();
                    System.out.println();
                    break;
                case 3:
                    concours.enregistrerCandidatReseau();
                    System.out.println();
                    break;
                case 4:
                    concours.afficherCandidatsParDomaine();
                    System.out.println();
                    break;
                case 5:
                    // Appeler la méthode pour afficher la liste de candidats en passant la liste
                    // directement
                    System.out.println("voici tous les informaticiens");
                    concours.afficherListeCandidats(concours.getListeTousCandidats());
                    System.out.println();
                    break;
                case 6:
                    concours.afficherInformationsLaureat();
                    System.out.println();
                    break;
                case 7:
                    concours.afficherInformationsCinqPremiersLaureats();
                    System.out.println();
                    break;
                case 8:
                    concours.supprimerQuatreDerniersCandidats();
                    System.out.println();
                    break;
                case 9:
                    concours.supprimerQuatreDerniersCandidatsMoyenneBasse();
                    System.out.println();
                    break;
                    case 10:
                    System.out.println("Programme terminé. Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
        Menu menu = new Menu();
        menu.afficherMenu();
    }
}
