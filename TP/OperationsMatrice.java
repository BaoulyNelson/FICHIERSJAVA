import java.util.Scanner;

public class OperationsMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ordre de la matrice carrée A : ");
        int ordre = scanner.nextInt();

        int[][] A = new int[ordre][ordre];

        System.out.println("Saisie des éléments de la matrice A :");
        saisirMatrice(scanner, A);

        int sommeDeuxiemeLigne = calculerSommeDeuxiemeLigne(A);
        int produitTroisiemeLigne = calculerProduitTroisiemeLigne(A);
        int plusGrandElement = trouverPlusGrandElement(A);
        int countPairsDiagonalePrincipale = compterElementsPairsDiagonalePrincipale(A);
        int countPairsDiagonaleSecondaire = compterElementsPairsDiagonaleSecondaire(A);
        int countOccurences = compterOccurences(A, 10);

        System.out.println("Somme des éléments de la deuxième ligne : " + sommeDeuxiemeLigne);
        System.out.println("Produit des éléments de la troisième ligne : " + produitTroisiemeLigne);
        System.out.println("Plus grand élément de la matrice : " + plusGrandElement);
        System.out.println("Nombre d'éléments pairs sur la diagonale principale : " + countPairsDiagonalePrincipale);
        System.out.println("Nombre d'éléments pairs sur la diagonale secondaire : " + countPairsDiagonaleSecondaire);
        System.out.println("Nombre d'occurrences de l'élément 10 dans la matrice : " + countOccurences);
    }

    private static void saisirMatrice(Scanner scanner, int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print("Entrez l'élément [" + i + "][" + j + "] : ");
                matrice[i][j] = scanner.nextInt();
            }
        }
    }

    private static int calculerSommeDeuxiemeLigne(int[][] matrice) {
        int somme = 0;

        for (int element : matrice[1]) {
            somme += element;
        }

        return somme;
    }

    private static int calculerProduitTroisiemeLigne(int[][] matrice) {
        int produit = 1;

        for (int element : matrice[2]) {
            produit *= element;
        }

        return produit;
    }

    private static int trouverPlusGrandElement(int[][] matrice) {
        int plusGrand = matrice[0][0];

        for (int[] ligne : matrice) {
            for (int element : ligne) {
                if (element > plusGrand) {
                    plusGrand = element;
                }
            }
        }

        return plusGrand;
    }

    private static int compterElementsPairsDiagonalePrincipale(int[][] matrice) {
        int count = 0;
        int n = matrice.length;

        for (int i = 0; i < n; i++) {
            if (matrice[i][i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    private static int compterElementsPairsDiagonaleSecondaire(int[][] matrice) {
        int count = 0;
        int n = matrice.length;

        for (int i = 0; i < n; i++) {
            if (matrice[i][n - i - 1] % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    private static int compterOccurences(int[][] matrice, int valeur) {
        int count = 0;

        for (int[] ligne : matrice) {
            for (int element : ligne) {
                if (element == valeur) {
                    count++;
                }
            }
        }

        return count;
    }
}
