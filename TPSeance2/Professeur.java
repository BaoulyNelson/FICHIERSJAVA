import java.util.Scanner;

public class Professeur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du professeur : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom du professeur : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez le sexe du professeur : ");
        String sexe = scanner.nextLine();
        System.out.print("Entrez les cours enseignés par le professeur : ");
        String cours = scanner.nextLine();
        System.out.print("Entrez le nombre d'heures : ");
        int nombreHeures = scanner.nextInt();
        System.out.print("Entrez le prix par heure : ");
        double prixHeure = scanner.nextDouble();

        double salaireBrut = nombreHeures * prixHeure;
        double salaireNet = salaireBrut - (0.02 * salaireBrut);

        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Sexe : " + sexe);
        System.out.println("Cours enseignés : " + cours);
        System.out.println("Salaire brut : " + salaireBrut);
        System.out.println("Salaire net : " + salaireNet);
    }
}
