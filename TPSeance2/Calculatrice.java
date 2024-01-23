import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double nombre1 = scanner.nextDouble();
        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();
        System.out.print("Entrez l'opérateur (+, -, *, /) : ");
        char operateur = scanner.next().charAt(0);

        double resultat = 0;

        switch (operateur) {
            case '+':
                resultat = nombre1 + nombre2;
                break;
            case '-':
                resultat = nombre1 - nombre2;
                break;
            case '*':
                resultat = nombre1 * nombre2;
                break;
            case '/':
                resultat = nombre1 / nombre2;
                break;
            default:
                System.out.println("Opérateur invalide.");
        }

        System.out.println("Résultat : " + resultat);
    }
}
