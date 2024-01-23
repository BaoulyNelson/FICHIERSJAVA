import java.util.Scanner;

public class Matrice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes (l) : ");
        int l = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes (c) : ");
        int c = scanner.nextInt();
        int[][] matrice = new int[l][c];

        System.out.println("Saisissez les éléments de la matrice :");

        int nombresPairs = 0;
        int nombresImpairs = 0;
        int nombresPositifs = 0;
        int nombresNegatifs = 0;
        int sommePairs = 0;
        int produitImpairs = 1;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrice[i][j] = scanner.nextInt();
                if (matrice[i][j] % 2 == 0) {
                    nombresPairs++;
                    sommePairs += matrice[i][j];
                } else {
                    nombresImpairs++;
                    produitImpairs *= matrice[i][j];
                }
                if (matrice[i][j] > 0) {
                    nombresPositifs++;
                } else if (matrice[i][j] < 0) {
                    nombresNegatifs++;
                }
            }
        }

        System.out.println("Quantité de nombres pairs : " + nombresPairs);
        System.out.println("Quantité de nombres impairs : " + nombresImpairs);
        System.out.println("Quantité de nombres positifs : " + nombresPositifs);
        System.out.println("Quantité de nombres négatifs : " + nombresNegatifs);
        System.out.println("Somme des nombres pairs : " + sommePairs);
        System.out.println("Produit des nombres impairs : " + produitImpairs);
    }
}
