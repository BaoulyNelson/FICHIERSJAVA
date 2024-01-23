import java.util.Scanner;

public class Matrice9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrice = new int[3][3];
        int[] nombresPairs = new int[9];
        int indexPairs = 0;

        System.out.println("Saisissez les éléments de la matrice :");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
                if (matrice[i][j] % 2 == 0) {
                    nombresPairs[indexPairs] = matrice[i][j];
                    indexPairs++;
                }
            }
        }

        System.out.println("Matrice saisie :");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Nombres pairs :");
        for (int i = 0; i < indexPairs; i++) {
            System.out.print(nombresPairs[i] + "\t");
        }
    }
}
