import java.util.Scanner;

public class MenuUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void afficherMenuPrincipal() {
        System.out.println("Menu principal :");
        System.out.println("1. Inscrire un bachelier");
        System.out.println("2. Enregistrer les notes d'un bachelier");
        System.out.println("3. Afficher le statut d'un bachelier");
        System.out.println("4. Quitter");
        System.out.print("Choix : ");
    }

    // Ajoutez d'autres méthodes pour afficher d'autres menus si nécessaire
}
