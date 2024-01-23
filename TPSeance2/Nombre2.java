import java.util.Scanner;

public class Nombre2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre : ");
        int nombre = scanner.nextInt();

        if (nombre % 2 == 0) {
            System.out.println("Le nombre est pair.");
        } else {
            System.out.println("Le nombre est impair.");
        }

        if (nombre < 0) {
            System.out.println("La valeur absolue du nombre est : " + Math.abs(nombre));
        } else if (nombre > 0) {
            System.out.println("La racine carrée du nombre est : " + Math.sqrt(nombre));
        }
    }
}
