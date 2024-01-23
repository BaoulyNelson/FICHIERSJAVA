import java.util.Scanner;

public class Employe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de l'employé : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom de l'employé : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez le ministère ou bureau affecté : ");
        String affectation = scanner.nextLine();
        System.out.print("Entrez le grade de l'employé (Licence, Maitrise, Doctorat) : ");
        String grade = scanner.nextLine();
        System.out.print("Entrez le salaire brut de l'employé : ");
        double salaireBrut = scanner.nextDouble();

        double augmentation = 0;

        switch (grade) {
            case "Licence":
                augmentation = 0.05 * salaireBrut;
                break;
            case "Maitrise":
                augmentation = 0.08 * salaireBrut;
                break;
            case "Doctorat":
                augmentation = 0.1 * salaireBrut;
                break;
            default:
                System.out.println("Grade invalide.");
        }

        System.out.print("L'employé a plus de 5 ans dans la fonction publique ? (Oui/Non) : ");
        String anciennete = scanner.next();

        if (anciennete.equalsIgnoreCase("Oui")) {
            augmentation += 0.03 * salaireBrut;
        }

        double salaireAugmente = salaireBrut + augmentation;

        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Ministère ou bureau affecté : " + affectation);
        System.out.println("Grade : " + grade);
        System.out.println("Salaire brut : " + salaireBrut);
        System.out.println("Augmentation : " + augmentation);
        System.out.println("Salaire augmenté : " + salaireAugmente);
    }
}
