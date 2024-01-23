import java.util.Scanner;

public class Matrice1 {
    public static void main(String[] args) {
        int[][] matrice = new int[5][3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisissez les éléments de la matrice :");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrice saisie :");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
