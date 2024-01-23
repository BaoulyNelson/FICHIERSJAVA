import java.util.Scanner;

public class ChampRequis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userValue;

        do {
            System.out.print("Entrez un nombre (requis) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ce n'est pas un nombre. Veuillez réessayer: ");
                scanner.next();
            }
            userValue = scanner.nextInt();
        } while (userValue == -1); // -1 indique une absence de données

        System.out.println("Vous avez entré : " + userValue);
    }
}
