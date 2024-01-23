import java.util.Scanner;

public class Calculs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre : ");
        double nombre = scanner.nextDouble();

        double carre = Math.pow(nombre, 2);
        double cube = Math.pow(nombre, 3);

        System.out.println("Le carré du nombre est : " + carre);
        System.out.println("Le cube du nombre est : " + cube);
    }
}
