import java.util.Scanner;

public class Calculs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double nombre1 = scanner.nextDouble();
        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();

        double somme = nombre1 + nombre2;
        double produit = nombre1 * nombre2;
        double difference = nombre1 - nombre2;
        double quotient = nombre1 / nombre2;

        System.out.println("Somme : " + somme);
        System.out.println("Produit : " + produit);
        System.out.println("Différence : " + difference);
        System.out.println("Quotient : " + quotient);
    }
}
