import java.util.Scanner;

public class ManipulerEmployes {
    private static Scanner scanner = new Scanner(System.in);

    private static String saisirChaine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int saisirEntier(String message) {
        System.out.print(message);
        int entier = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
        return entier;
    }

    private static double saisirDouble(String message) {
        System.out.print(message);
        double valeur = scanner.nextDouble();
        scanner.nextLine(); // Consommer la nouvelle ligne
        return valeur;
    }

    private static Employe saisirDonneesCommunes() {
        String nom = saisirChaine("Entrez le nom: ");
        String prenom = saisirChaine("Entrez le prénom: ");
        String sexe = saisirChaine("Entrez le sexe: ");
        String poste = saisirChaine("Entrez le poste: ");
        int nombreHeures = saisirEntier("Entrez le nombre d'heures travaillées par mois: ");
        double prixParHeure = saisirDouble("Entrez le prix par heure: ");
        String code="";
        return new Employe(code, nom, prenom, sexe, poste, nombreHeures, prixParHeure);
    }

    public static Vendeur saisirVendeur() {
        Employe employeCommun = saisirDonneesCommunes();
        int anneesExperience = saisirEntier("Entrez le nombre d'années d'expérience du vendeur: ");
        return new Vendeur(employeCommun.getNom(), employeCommun.getPrenom(), employeCommun.getSexe(),
                employeCommun.getNombreHeures(), employeCommun.getPrixParHeure(), employeCommun.getPoste(),
                anneesExperience);
    }

    public static Technicien saisirTechnicien() {
        Employe employeCommun = saisirDonneesCommunes();

        boolean diplome = saisirEntier("Le technicien a-t-il un diplôme ? (1 pour true, 0 pour false)") == 1;
        int anneesExperience = saisirEntier("Entrez le nombre d'années d'expérience du technicien: ");

        return new Technicien(employeCommun.getNom(), employeCommun.getPrenom(), employeCommun.getSexe(),
                employeCommun.getPoste(),
                employeCommun.getNombreHeures(), employeCommun.getPrixParHeure(), diplome, anneesExperience);
    }

    public static Menagere saisirMenagere() {
        Employe employeCommun = saisirDonneesCommunes();

        return new Menagere(employeCommun.getNom(), employeCommun.getPrenom(), employeCommun.getSexe(),
                employeCommun.getPoste(),
                employeCommun.getNombreHeures(), employeCommun.getPrixParHeure());
    }
}
