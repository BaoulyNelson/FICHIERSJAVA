import java.util.Scanner;

public class Matrice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la valeur de n : ");
        int n = scanner.nextInt();
        double[][] matrice = new double[n][n];

        System.out.println("Saisissez les éléments de la matrice :");

        int positifs = 0;
        int negatifs = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextDouble();
                if (matrice[i][j] > 0) {
                    positifs++;
                } else if (matrice[i][j] < 0) {
                    negatifs++;
                }
            }
        }

        System.out.println("Nombres positifs saisis : " + positifs);
        System.out.println("Nombres négatifs saisis : " + negatifs);
    }
}
 
    

