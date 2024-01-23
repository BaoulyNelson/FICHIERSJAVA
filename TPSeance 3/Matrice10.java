import java.util.Scanner;

public class Matrice10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de n (comprise entre 2 et 9) : ");
        int n = scanner.nextInt();

        int[][] matrice1 = new int[n][n];
        int[][] matrice2 = new int[n][n];
        int[][] sommeMatrices = new int[n][n];

        System.out.println("Saisissez les éléments de la première matrice :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Saisissez les éléments de la deuxième matrice :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrice 1 :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrice1[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Matrice 2 :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrice2[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Somme des deux matrices :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sommeMatrices[i][j] = matrice1[i][j] + matrice2[i][j];
                System.out.print(sommeMatrices[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
