import java.util.Scanner;

public class Equation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de a : ");
        double a = scanner.nextDouble();
        System.out.print("Entrez la valeur de b : ");
        double b = scanner.nextDouble();
        System.out.print("Entrez la valeur de c : ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Ce n'est pas une équation du second degré.");
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Deux solutions réelles distinctes : x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Une solution réelle double : x = " + x);
        } else {
            double reel = -b / (2 * a);
            double imaginaire = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Deux solutions complexes conjugées :");
            System.out.println("x1 = " + reel + " + " + imaginaire + "i");
            System.out.println("x2 = " + reel + " - " + imaginaire + "i");
        }
    }
}
