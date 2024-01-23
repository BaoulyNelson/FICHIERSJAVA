import java.util.Scanner;

public class ProgrammePrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        int choix;
        do {
            MenuUtils.afficherMenuPrincipal();
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne
            System.out.println();

            switch (choix) {
                case 1:
                    GestionBacheliers.inscrireBachelier();
                    System.out.println();
                    break;
                case 2:
                    GestionBacheliers.enregistrerNotes();
                    System.out.println();
                    break;
                case 3:
                    GestionBacheliers.afficherStatut();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        } while (choix != 4);
    }
}
