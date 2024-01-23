import java.util.Scanner;

public class Matrice7 {
    public static void main(String[] args) {
        double[][] matrice = new double[4][4];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisissez les éléments de la matrice :");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextDouble();
            }
        }

        double plusGrand = matrice[0][0];
        double plusPetit = matrice[0][0];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrice[i][j] > plusGrand) {
                    plusGrand = matrice[i][j];
                }
                if (matrice[i][j] < plusPetit) {
                    plusPetit = matrice[i][j];
                }
            }
        }

        System.out.println("Le plus grand nombre saisi est : " + plusGrand);
        System.out.println("Le plus petit nombre saisi est : " + plusPetit);
    }
}
