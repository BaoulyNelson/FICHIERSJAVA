import java.util.Scanner;

public class ProgrammePrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int choix = 0;
        do {

            System.out.print(
                    "===MENU===\n1- Enregistrer les candidats\n2- Afficher tous les bacheliers\n3- Consulter le fichier d'un candidat\n4- Sortir du programme\n> ");
            choix = sc.nextInt();
            System.out.println();
            switch (choix) {
                case 1:
                    Menu.enregistrer();
                    System.out.println();
                    break;
                case 2:
                    Menu.afficherBacheliers();
                    System.out.println();
                    break;
                case 3:
                    Menu.verifierMatricule();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Fin de programme");
                    break;
                default:
                    System.out.println("Option incorrect!");
                    break;
            }
        } while (choix != 4);
    }

}
