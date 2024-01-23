import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Concours concours = new Concours();

        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
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
                    concours.afficherCandidatsDomaine();
                    System.out.println();
                    break;
                case 5:
                    concours.afficherTousLesCandidats();
                    System.out.println();
                    break;
                case 6:
                    concours.afficherLaureatDesLaureats();
                    System.out.println();
                    break;
                case 7:
                    concours.afficherCinqPremiersLaureats();
                    System.out.println();
                    break;
                case 8:
                    concours.supprimerQuatreDerniers();
                    System.out.println();
                    break;
                    case 9:
                    concours.viderArrayList(null, "");
                    System.out.println();
                    break;
                    case 10:
                    System.out.println("Programme terminé.");
                    System.out.println();
                default:
                    System.out.println("Choix non valide. Réessayez.");
                    System.out.println();
            }
        } while (choix != 10);
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Enregistrer un candidat en Programmation");
        System.out.println("2. Enregistrer un candidat en Base de données");
        System.out.println("3. Enregistrer un candidat en Réseau");
        System.out.println("4. Afficher la liste des candidats suivant un domaine");
        System.out.println("5. Afficher la liste de tous les candidats ");
        System.out.println("6. Afficher les informations complètes sur le lauréat des lauréats");
        System.out.println("7. Afficher les informations sur les 5 premiers lauréats");
        System.out.println("8. Supprimer les 4 derniers candidats en termes de leur moyenne obtenue");
        System.out.println("9. Vider la liste");
        System.out.println("10. Quitter");
        System.out.print("Choix: ");
    }

}
