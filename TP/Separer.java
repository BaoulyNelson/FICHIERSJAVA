import java.util.Random;
import java.util.Scanner;

public class Separer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taille;

        System.out.print("Entrer la taille du tableau : ");
        taille = sc.nextInt();

        int[] tableau = new int[taille];
        int[] tPairs = new int[taille]; // Assuming maximum possible size
        int[] tImpairs = new int[taille]; // Assuming maximum possible size

        Random random = new Random();

        // Génération des nombres entrelacés
        for (int i = 0; i < taille; i++) {
            if (random.nextBoolean()) {
                tableau[i] = random.nextInt(50) * 2; // Génère un nombre pair jusqu'à 100
            } else {
                tableau[i] = random.nextInt(50) * 2 + 1; // Génère un nombre impair jusqu'à 99
            }
        }

        int nbPairs = 0;
        int nbImpairs = 0;

        // Séparation des nombres pairs et impairs
        for (int i = 0; i < taille; i++) {
            if (tableau[i] % 2 == 0) {
                tPairs[nbPairs++] = tableau[i];
            } else {
                tImpairs[nbImpairs++] = tableau[i];
            }
        }

        // Affichage des tableaux séparés
        System.out.println("Nombres pairs : ");
        for (int i = 0; i < nbPairs; i++) {
            System.out.print(tPairs[i] + " ");
        }
        System.out.println();

        System.out.println("Nombres impairs : ");
        for (int i = 0; i < nbImpairs; i++) {
            System.out.print(tImpairs[i] + " ");
        }
        System.out.println();
    }
}
