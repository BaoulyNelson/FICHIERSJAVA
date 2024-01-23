import java.util.Scanner;

public class Matrice15 {
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

        int plusGrand = matrice[0][0];
        int plusPetit = matrice[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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

        System.out.print("Entrez un nombre quelconque : ");
        int nombreQuelconque = scanner.nextInt();

        System.out.println("Nombres pairs positifs après le nombre quelconque :");
        boolean nombreQuelconqueTrouve = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nombreQuelconqueTrouve && matrice[i][j] > 0 && matrice[i][j] % 2 == 0) {
                    System.out.print(matrice[i][j] + "\t");
                }
                if (matrice[i][j] == nombreQuelconque) {
                    nombreQuelconqueTrouve = true;
                }
            }
        }
    }
}
