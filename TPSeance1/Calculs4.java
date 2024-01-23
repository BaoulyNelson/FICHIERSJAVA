import java.util.Scanner;

public class Calculs4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double nombre1 = scanner.nextDouble();
        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();
        System.out.print("Entrez le troisième nombre : ");
        double nombre3 = scanner.nextDouble();

        double somme = nombre1 + nombre2 + nombre3;
        double difference = nombre1 - nombre2 - nombre3;
        double moyenne = (somme + difference) / 2;

        System.out.println("Moyenne arithmétique : " + moyenne);
    }
}
