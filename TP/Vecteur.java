import java.util.Arrays;
import java.util.Scanner;

public class Vecteur {
    private static int[] elements;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la taille du vecteur (entre 3 et 10) : ");
        n = scanner.nextInt();
        elements = new int[n];

        int choix = 0;

        while (choix != 8) {
            afficherMenu();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    saisirElements(scanner);
                    break;
                case 2:
                    afficherElementsCroissant();
                    break;
                case 3:
                    afficherElementsDecroissant();
                    break;
                case 4:
                    afficherPlusPetitElement();
                    break;
                case 5:
                    afficherPlusGrandElement();
                    break;
                case 6:
                    afficherSommeElementsPairs();
                    break;
                case 7:
                    afficherMoyenneElementsPositifs();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
            System.out.println();
        }
    }

    private static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Saisir des éléments");
        System.out.println("2. Afficher les éléments saisis par ordre croissant");
        System.out.println("3. Afficher les éléments saisis par ordre décroissant");
        System.out.println("4. Afficher le plus petit élément");
        System.out.println("5. Afficher le plus grand élément");
        System.out.println("6. Afficher la somme des éléments pairs de l'ensemble");
        System.out.println("7. Afficher la moyenne arithmétique des éléments positifs");
        System.out.println("8. Quitter");
    }

    private static void saisirElements(Scanner scanner) {
        System.out.println("Saisie des éléments :");
        for (int i = 0; i < n; i++) {
            System.out.print("Entrez l'élément " + (i + 1) + " : ");
            elements[i] = scanner.nextInt();
        }
        System.out.println("Les éléments ont été saisis avec succès.");
    }

    private static void afficherElementsCroissant() {
        int[] elementsTri = Arrays.copyOf(elements, n);
        Arrays.sort(elementsTri);
        System.out.println("Les éléments saisis par ordre croissant : " + Arrays.toString(elementsTri));
    }

    private static void afficherElementsDecroissant() {
        int[] elementsTri = Arrays.copyOf(elements, n);
        Arrays.sort(elementsTri);
        for (int i = 0; i < n / 2; i++) {
            int temp = elementsTri[i];
            elementsTri[i] = elementsTri[n - i - 1];
            elementsTri[n - i - 1] = temp;
        }
        System.out.println("Les éléments saisis par ordre décroissant : " + Arrays.toString(elementsTri));
    }

    private static void afficherPlusPetitElement() {
        int plusPetit = elements[0];
        for (int i = 1; i < n; i++) {
            if (elements[i] < plusPetit) {
                plusPetit = elements[i];
            }
        }
        System.out.println("Le plus petit élément : " + plusPetit);
    }

    private static void afficherPlusGrandElement() {
        int plusGrand = elements[0];
        for (int i = 1; i < n; i++) {
            if (elements[i] > plusGrand) {
                plusGrand = elements[i];
            }
        }
        System.out.println("Le plus grand élément : " + plusGrand);
    }

    private static void afficherSommeElementsPairs() {
        int somme = 0;
        for (int i = 0; i < n; i++) {
            if (elements[i] % 2 == 0) {
                somme += elements[i];
            }
        }
        System.out.println("La somme des éléments pairs de l'ensemble : " + somme);
    }

    private static void afficherMoyenneElementsPositifs() {
        int sommePositifs = 0;
        int countPositifs = 0;
        for (int i = 0; i < n; i++) {
            if (elements[i] > 0) {
                sommePositifs += elements[i];
                countPositifs++;
            }
        }
        if (countPositifs > 0) {
            double moyenne = (double) sommePositifs / countPositifs;
            System.out.println("La moyenne arithmétique des éléments positifs : " + moyenne);
        } else {
            System.out.println("Il n'y a pas d'éléments positifs.");
        }
    }
}
