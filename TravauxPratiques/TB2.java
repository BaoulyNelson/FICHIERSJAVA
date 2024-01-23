import java.util.Scanner;

public class TB2 {
    public static void main(String args[]) {
        Scanner pratique = new Scanner(System.in);
        int tableau1[] = new int[5];

        // Utiliser une boucle pour saisir les valeurs dans le tableau
        for (int i = 0; i < tableau1.length; i++) {
            System.out.println("Entrer un nombre : ");
            tableau1[i] = pratique.nextInt();
        }

        // Afficher les valeurs du tableau
        System.out.println("Les valeurs dans le tableau sont : ");
        for (int i = 0; i < tableau1.length; i++) {
            System.out.println(tableau1[i]);
        }
    }
}
