import java.util.Arrays;
import java.util.Scanner;

public class Matrice13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes (n) : ");
        int n = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes (m) : ");
        int m = scanner.nextInt();
        int[][] matrice = new int[n][m];

        System.out.println("Saisissez les éléments de la matrice :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }

        trierMatriceCroissant(matrice);
        System.out.println("Matrice triée en ordre croissant :");
        afficherMatrice(matrice);

        trierMatriceDecroissant(matrice);
        System.out.println("Matrice triée en ordre décroissant :");
        afficherMatrice(matrice);
    }

    public static void trierMatriceCroissant(int[][] matrice) {
        int[] elements = new int[matrice.length * matrice[0].length];
        int index = 0;

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                elements[index] = matrice[i][j];
                index++;
            }
        }

        Arrays.sort(elements);

        index = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = elements[index];
                index++;
            }
        }
    }

    public static void trierMatriceDecroissant(int[][] matrice) {
        int[] elements = new int[matrice.length * matrice[0].length];
        int index = 0;

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                elements[index] = matrice[i][j];
                index++;
            }
        }

        Arrays.sort(elements);

        index = elements.length - 1;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = elements[index];
                index--;
            }
        }
    }

    public static void afficherMatrice(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
