import java.util.Scanner;

public class MainClass1 {
    public static void main(String[] args) {
        System.out.println();
         Scanner scanner = new Scanner(System.in);
        Test test=new Test();

        int choix = 0;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Ajouter une habitation individuelle");
            System.out.println("2. Ajouter une habitation professionnelle");
            System.out.println("3. Afficher les habitations");
            System.out.println("4. Calculer les impôts");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            System.out.println();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                 test.infosHabitationIndividuelle();
                    break;
                case 2:
                test.infosHabitationProfessionnelle();
                     break;
                case 3:
                test.afficherHabitations();
                    break;                 
                case 4:
                    test.calculerImpot();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 5);
    }
}
