import java.util.Scanner;

public class Matrice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes (l) : ");
        int l = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes (c) : ");
        int c = scanner.nextInt();
        int[][] matrice = new int[l][c];

        System.out.println("Saisissez les éléments de la matrice :");

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Nombres négatifs et impairs saisis :");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (matrice[i][j] < 0 && matrice[i][j] % 2 != 0) {
                    System.out.print(matrice[i][j] + "\t");
                }
            }
        }
    }
}
