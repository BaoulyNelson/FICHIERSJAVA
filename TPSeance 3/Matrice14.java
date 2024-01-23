import java.util.Scanner;

public class Matrice14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de n (comprise entre 3 et 4) : ");
        int n = scanner.nextInt();

        int[][] matrice1 = new int[n][n];
        int[][] matrice2 = new int[n][n];
        int[][] produit = new int[n][n];

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    produit[i][j] += matrice1[i][k] * matrice2[k][j];
                }
            }
        }

        System.out.println("Produit des deux matrices :");
        afficherMatrice(produit);
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
