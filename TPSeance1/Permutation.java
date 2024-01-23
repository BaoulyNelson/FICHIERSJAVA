import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double nombre1 = scanner.nextDouble();
        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();

        System.out.println("Contenu avant permutation :");
        System.out.println("Premier nombre : " + nombre1);
        System.out.println("Deuxième nombre : " + nombre2);

        double temp = nombre1;
        nombre1 = nombre2;
        nombre2 = temp;

        System.out.println("Contenu après permutation :");
        System.out.println("Premier nombre : " + nombre1);
        System.out.println("Deuxième nombre : " + nombre2);
    }
}
