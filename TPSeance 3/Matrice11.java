import java.util.Scanner;

public class Matrice11 {
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

        int trace = 0;
        int sommeDiagonaleSecondaire = 0;

        for (int i = 0; i < 4; i++) {
            trace += matrice[i][i];
            sommeDiagonaleSecondaire += matrice[i][3 - i];
        }

        System.out.println("Trace de la matrice : " + trace);
        System.out.println("Somme des éléments sur la diagonale secondaire : " + sommeDiagonaleSecondaire);
    }
}
