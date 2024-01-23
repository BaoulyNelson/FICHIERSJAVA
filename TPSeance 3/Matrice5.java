import java.util.Scanner;

public class Matrice5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de p : ");
        int p = scanner.nextInt();
        int[][] matrice = new int[p][p];

        System.out.println("Saisissez les éléments de la matrice :");

        int pairs = 0;
        int impairs = 0;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
                if (matrice[i][j] > 0 && matrice[i][j] % 2 == 0) {
                    pairs++;
                } else if (matrice[i][j] > 0 && matrice[i][j] % 2 != 0) {
                    impairs++;
                }
            }
        }

        System.out.println("Nombres positifs et pairs saisis : " + pairs);
        System.out.println("Nombres positifs et impairs saisis : " + impairs);
    }
}
