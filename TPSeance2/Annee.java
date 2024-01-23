import java.util.Scanner;

public class Annee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez une année : ");
        int annee = scanner.nextInt();

        if (annee % 4 == 0 && !(annee % 100 == 0) || annee % 400 == 0) {
            System.out.println("L'année est bissextile.");
        } else {
            System.out.println("L'année n'est pas bissextile.");
        }
    }
}
