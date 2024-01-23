import java.util.Scanner;

public class Programme {
    public static void main(String[] args) {
        System.out.println();
        ProgrammeBachelier programme = new ProgrammeBachelier();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Menu :");
            System.out.println("1. Inscrire un bachelier");
            System.out.println("2. Enregistrer les notes d'un bachelier");
            System.out.println("3. Afficher le statut d'un bachelier par matricule");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            System.out.println();

            switch (choix) {
                case 1:
                    programme.inscrireBachelier();
                    System.out.println();
                    break;
                case 2:
                    programme.enregistrerNotes();
                    System.out.println();
                    break;
                case 3:
                    programme.afficherStatutBachelier();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Option invalide.");
                    break;
            }
        } while (choix != 4);
    }

}
