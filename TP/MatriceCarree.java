import java.util.Scanner;

public class MatriceCarree {
    public static void main(String[] args) {
        int[][] M = new int[3][3];
        Scanner scanner = new Scanner(System.in);

        // Saisie des éléments de la matrice
        System.out.println("Saisie des éléments de la matrice :");
        saisirMatrice(scanner, M);

        // Affichage des éléments de la matrice
        System.out.println("Matrice :");
        afficherMatrice(M);

        // Calcul de la somme des éléments de la diagonale principale
        int sommeDiagonalePrincipale = calculerSommeDiagonalePrincipale(M);
        System.out.println("Somme des éléments de la diagonale principale : " + sommeDiagonalePrincipale);

        // Calcul du produit des éléments de la diagonale secondaire
        int produitDiagonaleSecondaire = calculerProduitDiagonaleSecondaire(M);
        System.out.println("Produit des éléments de la diagonale secondaire : " + produitDiagonaleSecondaire);

        // Recherche du plus petit et du plus grand élément de la matrice
        int plusPetitElement = trouverPlusPetitElement(M);
        int plusGrandElement = trouverPlusGrandElement(M);
        System.out.println("Plus petit élément de la matrice : " + plusPetitElement);
        System.out.println("Plus grand élément de la matrice : " + plusGrandElement);

        // Calcul du nombre d'éléments pairs de la première ligne
        int nombreElementsPairsPremiereLigne = compterElementsPairsPremiereLigne(M);
        System.out.println("Nombre d'éléments pairs dans la première ligne : " + nombreElementsPairsPremiereLigne);

        // Calcul du nombre d'éléments impairs de la dernière colonne
        int nombreElementsImpairsDerniereColonne = compterElementsImpairsDerniereColonne(M);
        System.out.println("Nombre d'éléments impairs dans la dernière colonne : " + nombreElementsImpairsDerniereColonne);

        // Vérification de l'existence de l'élément 5 dans la matrice et comptage des occurrences
        boolean existeElement5 = verifierExistenceElement(M, 5);
        int nombreOccurrencesElement5 = compterOccurrencesElement(M, 5);
        System.out.println("L'élément 5 existe dans la matrice : " + existeElement5);
        System.out.println("Nombre d'occurrences de l'élément 5 dans la matrice : " + nombreOccurrencesElement5);

        // Comparaison de la somme des éléments pairs et impairs
        int sommeElementsPairs = calculerSommeElementsPairs(M);
        int sommeElementsImpairs = calculerSommeElementsImpairs(M);
        System.out.println("Somme des éléments pairs : " + sommeElementsPairs);
        System.out.println("Somme des éléments impairs : " + sommeElementsImpairs);
        System.out.println("Comparaison de la somme des éléments pairs et impairs : " + comparerSommeElementsPairsImpairs(sommeElementsPairs, sommeElementsImpairs));
    }

    private static void saisirMatrice(Scanner scanner, int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print("Entrez l'élément [" + i + "][" + j + "] : ");
                matrice[i][j] = scanner.nextInt();
            }
        }
    }

    private static void afficherMatrice(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int calculerSommeDiagonalePrincipale(int[][] matrice) {
        int somme = 0;
        for (int i = 0; i < matrice.length; i++) {
            somme += matrice[i][i];
        }
        return somme;
    }

    private static int calculerProduitDiagonaleSecondaire(int[][] matrice) {
        int produit = 1;
        for (int i = 0; i < matrice.length; i++) {
            produit *= matrice[i][matrice.length - i - 1];
        }
        return produit;
    }

    private static int trouverPlusPetitElement(int[][] matrice) {
        int plusPetit = matrice[0][0];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] < plusPetit) {
                    plusPetit = matrice[i][j];
                }
            }
        }
        return plusPetit;
    }

    private static int trouverPlusGrandElement(int[][] matrice) {
        int plusGrand = matrice[0][0];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] > plusGrand) {
                    plusGrand = matrice[i][j];
                }
            }
        }
        return plusGrand;
    }

    private static int compterElementsPairsPremiereLigne(int[][] matrice) {
        int count = 0;
        for (int j = 0; j < matrice[0].length; j++) {
            if (matrice[0][j] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int compterElementsImpairsDerniereColonne(int[][] matrice) {
        int count = 0;
        for (int i = 0; i < matrice.length; i++) {
            if (matrice[i][matrice[i].length - 1] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    private static boolean verifierExistenceElement(int[][] matrice, int element) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == element) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int compterOccurrencesElement(int[][] matrice, int element) {
        int count = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == element) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int calculerSommeElementsPairs(int[][] matrice) {
        int somme = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] % 2 == 0) {
                    somme += matrice[i][j];
                }
            }
        }
        return somme;
    }

    private static int calculerSommeElementsImpairs(int[][] matrice) {
        int somme = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] % 2 != 0) {
                    somme += matrice[i][j];
                }
            }
        }
        return somme;
    }

    private static String comparerSommeElementsPairsImpairs(int sommeElementsPairs, int sommeElementsImpairs) {
        if (sommeElementsPairs > sommeElementsImpairs) {
            return "La somme des éléments pairs est supérieure à la somme des éléments impairs.";
        } else if (sommeElementsPairs < sommeElementsImpairs) {
            return "La somme des éléments impairs est supérieure à la somme des éléments pairs.";
        } else {
            return "La somme des éléments pairs est égale à la somme des éléments impairs.";
        }
    }
}
