import java.util.Scanner;

public class Matrice8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes (n) : ");
        int n = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes (p) : ");
        int p = scanner.nextInt();
        double[][] matrice = new double[n][p];

        System.out.println("Saisissez les éléments de la matrice :");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Le triple de la racine carrée des nombres saisis :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                double resultat = 3 * Math.sqrt(matrice[i][j]);
                System.out.print(resultat + "\t");
            }
            System.out.println();
        }
    }
}
