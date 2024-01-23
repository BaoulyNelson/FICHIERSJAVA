import java.util.Scanner;

public class AdditionsMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes des matrices A et B : ");
        int lignes = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes des matrices A et B : ");
        int colonnes = scanner.nextInt();

        int[][] A = new int[lignes][colonnes];
        int[][] B = new int[lignes][colonnes];

        System.out.println("Saisie des éléments de la matrice A :");
        saisirMatrice(scanner, A);
        System.out.println("Saisie des éléments de la matrice B :");
        saisirMatrice(scanner, B);

        int[][] C = additionnerMatrices(A, B);

        double moyennePairsC = calculerMoyennePairs(C);

        System.out.println("Moyenne arithmétique des éléments pairs de C : " + moyennePairsC);

        System.out.println("Éléments impairs de la diagonale principale de C :");
        afficherElementsImpairsDiagonalePrincipale(C);
    }

    private static void saisirMatrice(Scanner scanner, int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print("Entrez l'élément [" + i + "][" + j + "] : ");
                matrice[i][j] = scanner.nextInt();
            }
        }
    }

    private static int[][] additionnerMatrices(int[][] A, int[][] B) {
        int lignes = A.length;
        int colonnes = A[0].length;
        int[][] C = new int[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    private static double calculerMoyennePairs(int[][] matrice) {
        int somme = 0;
        int count = 0;

        for (int[] ligne : matrice) {
            for (int element : ligne) {
                if (element % 2 == 0) {
                    somme += element;
                    count++;
                }
            }
        }

        if (count > 0) {
            return (double) somme / count;
        } else {
            return 0;
        }
    }

    private static void afficherElementsImpairsDiagonalePrincipale(int[][] matrice) {
        int n = matrice.length;

        for (int i = 0; i < n; i++) {
            if (matrice[i][i] % 2 != 0) {
                System.out.print(matrice[i][i] + " ");
            }
        }

        System.out.println();
    }
}
