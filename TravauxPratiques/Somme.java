import java.util.Scanner;

public class Somme {

    public static void main(String args[]) {

        Scanner som = new Scanner(System.in);
        System.out.println("Ecrire un nombre");
        int a = som.nextInt();

        System.out.println("Ecrire un autre nombre");
        int b = som.nextInt();

        System.out.println("Ecrire un 3eme nombre");
        int c = som.nextInt();

        // traitement des operations
        if (a == b + c) {
            System.out.println("afficher " + a);
        } else if (b == a + c) {
            System.out.println("afficher " + b);

        } else if (c == b + a) {
            System.out.println("aficher " + c);

        } else {
            System.out.println("pas de solution");

        }

    }

}
