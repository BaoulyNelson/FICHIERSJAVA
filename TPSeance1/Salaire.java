import java.util.Scanner;

public class Salaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du professeur : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom du professeur : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez le nombre d'heures : ");
        double nbHeures = scanner.nextDouble();
        System.out.print("Entrez le prix par heure : ");
        double prixHeure = scanner.nextDouble();
        System.out.print("Entrez le pourcentage d'augmentation : ");
        double pourcentageAugmentation = scanner.nextDouble();

        double salaireBrut = nbHeures * prixHeure;
        double taxe = 0.02 * salaireBrut;
        double salaireNetAvant = salaireBrut - taxe;
        double augmentation = pourcentageAugmentation / 100 * salaireNetAvant;
        double salaireNetApres = salaireNetAvant + augmentation;

        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Salaire brut : " + salaireBrut);
        System.out.println("Salaire net avant augmentation : " + salaireNetAvant);
        System.out.println("Salaire net après augmentation : " + salaireNetApres);
        System.out.println("Montant augmenté : " + augmentation);
    }
}
