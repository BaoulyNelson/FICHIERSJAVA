import java.util.Scanner;

public class Matrice12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrice = new int[4][4];

        System.out.println("Saisissez les éléments de la matrice :");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrice avant permutation :");
        afficherMatrice(matrice);

        for (int i = 0; i < 4; i++) {
            int temp = matrice[i][i];
            matrice[i][i] = matrice[i][3 - i];
            matrice[i][3 - i] = temp;
        }

        System.out.println("Matrice après permutation :");
        afficherMatrice(matrice);
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
