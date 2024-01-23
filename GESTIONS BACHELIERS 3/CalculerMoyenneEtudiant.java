import java.util.Scanner;

public class CalculerMoyenneEtudiant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPoints = 0;

        // Demande à l'utilisateur d'entrer les notes pour les 3 premières matières sur 400 points chacune.
        for (int i = 1; i <= 3; i++) {
            System.out.print("Entrez la note pour la matière " + i + " (sur 400) : ");
            int note = scanner.nextInt();
            totalPoints += note;
        }

        // Demande à l'utilisateur d'entrer les notes pour les 7 autres matières sur 200 points chacune.
        for (int i = 4; i <= 10; i++) {
            System.out.print("Entrez la note pour la matière " + i + " (sur 200) : ");
            int note = scanner.nextInt();
            totalPoints += note;
        }

        // Calcul de la moyenne sur 10.
        double moyenne = ((double) totalPoints / 2600)*10;

        // Affichage de la moyenne.
        System.out.println("La moyenne de l'étudiant est : " + moyenne);
        
        // Fermeture du scanner.
        scanner.close();
    }
}
