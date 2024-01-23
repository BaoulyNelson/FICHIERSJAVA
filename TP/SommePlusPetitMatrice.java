import java.util.Scanner;

public class SommePlusPetitMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes de la matrice : ");
        int lignes = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes de la matrice : ");
        int colonnes = scanner.nextInt();

        int[][] M = new int[lignes][colonnes];

        System.out.println("Saisie des éléments de la matrice :");
        saisirMatrice(scanner, M);

        int sommeDeuxiemeLigne = calculerSommeDeuxiemeLigne(M);
        int plusPetitElement = trouverPlusPetitElement(M);

        System.out.println("Somme des éléments de la deuxième ligne : " + sommeDeuxiemeLigne);
        System.out.println("Plus petit élément de la matrice : " + plusPetitElement);
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

    private static int trouverPlusPetitElement(int[][] matrice) {
        int plusPetit = matrice[0][0];

        for (int[] ligne : matrice) {
            for (int element : ligne) {
                if (element < plusPetit) {
                    plusPetit = element;
                }
            }
        }

        return plusPetit;
    }
}
