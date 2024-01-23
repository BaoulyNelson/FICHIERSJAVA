import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    ArrayList<Habitation> habitations = new ArrayList<>();
    HabitationIndividuelle habitationIndividuelle = new HabitationIndividuelle(0, null, null, null, null, 0, 0, false);
    HabitationProfessionnelle habitationProfessionnelle = new HabitationProfessionnelle(0, null, null, null, null, 0,
            0, 0);

    Scanner scanner = new Scanner(System.in);

    public void infosHabitationIndividuelle() {
        System.out.println("=== Ajout d'une habitation individuelle ===");
        System.out.print("Entrer la Zone : ");
        habitationIndividuelle.setZone(scanner.nextLine());
        System.out.print("Entrer l'Adresse : ");
        habitationIndividuelle.setAdresse(scanner.nextLine());
        System.out.print("Entrer la Surface : ");
        habitationIndividuelle.setSurface(scanner.nextDouble());
        System.out.print("Entrer le Nombre de pièces : ");
        habitationIndividuelle.setNombrePieces(scanner.nextInt());
        scanner.nextLine(); // Pour consommer le retour à la ligne
        System.out.print("Présence d'une piscine (true/false) : ");
        habitationIndividuelle.setPresencePiscine(scanner.nextBoolean());
        scanner.nextLine(); // Pour consommer le retour à la ligne
        String nifProprietaire="005-443-"+habitationIndividuelle.getZone().substring(0, 1)+habitationIndividuelle.getCodeIdentification();
        habitationIndividuelle = new HabitationIndividuelle(
                0, nifProprietaire, "Individuelle",
                habitationIndividuelle.getZone(), habitationIndividuelle.getAdresse(), habitationIndividuelle.getSurface(), habitationIndividuelle.getNombrePieces(),
                habitationIndividuelle.isPresencePiscine());
        habitations.add(habitationIndividuelle);
        System.out.println("Habitation individuelle ajoutée !\n");
    }

    public void infosHabitationProfessionnelle() {
        System.out.println("=== Ajout d'une habitation professionnelle ===");
        System.out.print("Entrer la Zone : ");
        habitationProfessionnelle.setZone( scanner.nextLine());
        System.out.print("Entrer l'Adresse : ");
        habitationProfessionnelle.setAdresse( scanner.nextLine());
        System.out.print("Entrer la Surface : ");
        habitationProfessionnelle.setSurface( scanner.nextDouble());
        System.out.print("Entrer la Surface occupée : ");
        habitationProfessionnelle.setSurfaceOccupee( scanner.nextDouble());
        System.out.print("Entrer le Nombre d'employés : ");
        habitationProfessionnelle.setNombreEmployes( scanner.nextInt());
        scanner.nextLine(); // Pour consommer le retour à la ligne
        String nifProprietaire="009-813-"+habitationProfessionnelle.getZone().substring(0, 1)+habitationIndividuelle.getCodeIdentification();
         habitationProfessionnelle = new HabitationProfessionnelle(
                0, nifProprietaire, "Professionnelle",
                habitationProfessionnelle.getZone(), habitationProfessionnelle.getAdresse(), habitationProfessionnelle.getSurface(),
                habitationProfessionnelle.getSurfaceOccupee(), habitationProfessionnelle.getNombreEmployes());
        habitations.add(habitationProfessionnelle);
        System.out.println("Habitation professionnelle ajoutée !\n");

    }

    public void afficherHabitations() {
        System.out.println("=== Liste des habitations ===");
        for (Habitation habitation : habitations) {
            System.out.println(habitation.toString());
        }
    }

    public void calculerImpot() {
        System.out.println("=== Calcul des impôts ===");
        for (Habitation habitation : habitations) {
            double impot = habitation.calculerImpot();
            System.out.println("Impôt pour code " + habitation.getCodeIdentification() + " : " + impot + " Gourdes");
        }
    }

}
