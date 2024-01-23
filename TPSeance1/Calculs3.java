import java.util.Scanner;

public class Calculs3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double nombre1 = scanner.nextDouble();
        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();

        double somme = nombre1 + nombre2;
        double resultat = 1 / (3 * somme);

        System.out.println("L'inverse du triple de la somme est : " + resultat);
    }
}
