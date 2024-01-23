import java.util.Scanner;

public class Matrice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de n : ");
        int n = scanner.nextInt();
        int[][] matrice = new int[n][n];

        System.out.println("Saisissez les éléments de la matrice :");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Nombres positifs et pairs saisis :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrice[i][j] > 0 && matrice[i][j] % 2 == 0) {
                    System.out.print(matrice[i][j] + "\t");
                }
            }
        }
    }
}
