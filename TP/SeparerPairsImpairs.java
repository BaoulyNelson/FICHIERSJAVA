import java.util.Scanner;

public class SeparerPairsImpairs {

    public static void main(String[] args) {
        int taille=5;
        int[] tableau = new int[taille];
        int[] tPairs;
        int[] tImpairs;

        Scanner sc = new Scanner(System.in);
      
        System.out.println("Veuillez saisir " + taille + " valeurs (entrelacez les nombres pairs et impairs) :");

        for (int i = 0; i < taille; i++) {
            tableau[i] = sc.nextInt();
        }

        tPairs = extrairePairs(tableau);
        tImpairs = extraireImpairs(tableau);

        System.out.println("\nContenu du tableau initial :");
        afficherTableau(tableau);

        System.out.println("\nContenu du tableau des nombres pairs :");
        afficherTableau(tPairs);

        System.out.println("\nContenu du tableau des nombres impairs :");
        afficherTableau(tImpairs);
    }

    public static int[] extrairePairs(int[] tableau) {
        int countPairs = 0;

        for (int num : tableau) {
            if (num % 2 == 0) {
                countPairs++;
            }
        }

        int[] tPairs = new int[countPairs];
        int index = 0;

        for (int num : tableau) {
            if (num % 2 == 0) {
                tPairs[index] = num;
                index++;
            }
        }

        return tPairs;
    }

    public static int[] extraireImpairs(int[] tableau) {
        int countImpairs = 0;

        for (int num : tableau) {
            if (num % 2 != 0) {
                countImpairs++;
            }
        }

        int[] tImpairs = new int[countImpairs];
        int index = 0;

        for (int num : tableau) {
            if (num % 2 != 0) {
                tImpairs[index] = num;
                index++;
            }
        }

        return tImpairs;
    }

    public static void afficherTableau(int[] tableau) {
        for (int num : tableau) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
