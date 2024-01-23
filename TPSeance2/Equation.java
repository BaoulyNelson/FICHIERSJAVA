import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de a : ");
        double a = scanner.nextDouble();
        System.out.print("Entrez la valeur de b : ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("L'équation admet une infinité de solutions.");
            } else {
                System.out.println("L'équation n'admet pas de solution.");
            }
        } else {
            double solution = -b / a;
            System.out.println("La solution de l'équation est : " + solution);
        }
    }
}
