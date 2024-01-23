import java.util.Scanner;

public class ProgrammeMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez la taille de la matrice (comprise entre 2 et 5) : ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne
        
        if (n < 2 || n > 5) {
            System.out.println("Taille de matrice invalide. Le programme se termine.");
            return;
        }
        
        int[][] matrice = new int[n][n];
        
        // Saisie des éléments de la matrice
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Entrez un nombre entier pour la position (" + i + ", " + j + ") : ");
                matrice[i][j] = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne
            }
        }
        
        System.out.println("Les éléments de la matrice sont :");
        afficherMatrice(matrice);
        
        double inverseSommeDiagonaleSec = calculerInverseSommeDiagonaleSec(matrice);
        System.out.println("Le triple de l'inverse de la somme des éléments de la diagonale secondaire est : " + (3 * inverseSommeDiagonaleSec));
        
        permuterDiagonales(matrice);
        System.out.println("La matrice après permutation des diagonales est :");
        afficherMatrice(matrice);
        
        int[] tableau = copierNombresPairsDivisibles(matrice);
        System.out.println("Les nombres saisis dont leur carré est un nombre pair divisible par 2 et 4 sont :");
        afficherTableau(tableau);
        
        int[][] autreMatrice = new int[n][n];
        // Saisie des éléments de l'autre matrice
        System.out.println("Entrez les éléments de l'autre matrice :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Entrez un nombre entier pour la position (" + i + ", " + j + ") : ");
                autreMatrice[i][j] = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne
            }
        }
        
        int[][] sommeMatrices = additionnerMatrices(matrice, autreMatrice);
        System.out.println("La somme des deux matrices est :");
        afficherMatrice(sommeMatrices);
        
        scanner.close();
    }
    
    public static void afficherMatrice(int[][] matrice) {
        int n = matrice.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static double calculerInverseSommeDiagonaleSec(int[][] matrice) {
        int n = matrice.length;
        int somme = 0;
        
        for (int i = 0; i < n; i++) {
            somme += matrice[i][n - i - 1];
        }
        
        return 1.0 / somme;
    }
    
    public static void permuterDiagonales(int[][] matrice) {
        int n = matrice.length;
        
        for (int i = 0; i < n; i++) {
            int temp = matrice[i][i];
            matrice[i][i] = matrice[i][n - i - 1];
            matrice[i][n - i - 1] = temp;
        }
    }
    
    public static int[] copierNombresPairsDivisibles(int[][] matrice) {
        int n = matrice.length;
        int[] tableau = new int[n * n];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nombre = matrice[i][j];
                if (nombre % 2 == 0 && nombre * nombre % 4 == 0) {
                    tableau[index] = nombre;
                    index++;
                }
            }
        }
        
        int[] resultat = new int[index];
        for (int i = 0; i < index; i++) {
            resultat[i] = tableau[i];
        }
        
        return resultat;
    }
    
    public static void afficherTableau(int[] tableau) {
        for (int nombre : tableau) {
            System.out.print(nombre + " ");
        }
        System.out.println();
    }
    
    public static int[][] additionnerMatrices(int[][] matrice1, int[][] matrice2) {
        int n = matrice1.length;
        int[][] somme = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                somme[i][j] = matrice1[i][j] + matrice2[i][j];
            }
        }
        
        return somme;
    }
}
