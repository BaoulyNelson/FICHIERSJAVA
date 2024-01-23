import java.util.Scanner;

public class EmployeContractuel extends Employe {
    private double tauxHoraire;
    private int heuresTravaillees;

    // Constructeur
    public EmployeContractuel(String nom, String prenom, double tauxHoraire, int heuresTravaillees) {
        // Appel du constructeur de la classe parente (Employe)
        super(nom, prenom);

        // Initialisez les attributs spécifiques à un employé contractuel
        this.tauxHoraire = 0.0;
        this.heuresTravaillees = 0;
    }

    // Implémentation de la méthode pour calculer le salaire
    @Override
    public double calculerSalaire() {
        // Logique de calcul du salaire pour un employé contractuel
        return tauxHoraire * heuresTravaillees;
    }

    @Override
    public void saisirDetails() {
        Scanner scanner = new Scanner(System.in);

        // Saisie du taux horaire
        System.out.print("Taux horaire : ");
        this.tauxHoraire = scanner.nextDouble();
        // Saisie des heures travaillées
        System.out.print("Heures travaillées : ");
        this.heuresTravaillees = scanner.nextInt();
         }

    // Méthode toString pour afficher les détails de l'employé contractuel
    @Override
    public String toString() {
        return "Employé contractuel\n" + super.toString() +
                "\nTaux horaire : " + this.tauxHoraire +
                "\nHeures travaillées : " + this.heuresTravaillees;
    }
}
