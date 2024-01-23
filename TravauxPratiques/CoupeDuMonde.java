import java.util.Scanner;

public class CoupeDuMonde {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez une année : ");
        int annee = sc.nextInt();

        if (annee < 1930) {
            System.out.println("La première Coupe du Monde a eu lieu en 1930.");
        } else if ((annee - 1930) % 4 == 0) {
            System.out.println("Il y a eu une Coupe du Monde en " + annee + ".");
        } else {
            int prochaineAnnee = ((annee - 1930) / 4 + 1) * 4 + 1930;
            System.out.println("Il n'y a pas eu de Coupe du Monde en " + annee + ".");
            System.out.println("La prochaine Coupe du Monde aura lieu en " + prochaineAnnee + ".");
        }
    }
}
