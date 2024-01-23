import java.util.Scanner;

public class EmployeTempsPartiel extends Employe {
    private double salaireHoraire;
    private int heuresTravailHebdo;

    public EmployeTempsPartiel(String nom, String prenom, double salaireHoraire, int heuresTravailHebdo) {
        super(nom, prenom);
        this.salaireHoraire = salaireHoraire;
        this.heuresTravailHebdo = heuresTravailHebdo;
    }

    @Override
    public double calculerSalaire() {
        // Logique de calcul du salaire pour un employé à temps partiel
        return salaireHoraire * heuresTravailHebdo;
    }

  
    @Override
    public void saisirDetails() {
        Scanner scanner = new Scanner(System.in);
    
        // Saisie du salaire horaire
                System.out.print("Salaire horaire: ");
                this.salaireHoraire = scanner.nextDouble();
        // Saisie des heures travaillées hebdomadaires
                System.out.print("Heures travaillées hebdo: ");
                this.heuresTravailHebdo = scanner.nextInt();
           }
    

    // Méthode toString pour afficher les détails de l'employé contractuel
@Override
public String toString() {
    return "Employé temps partiel\n" + super.toString() +
           "\nSalaire Horaire : " + this.salaireHoraire +
           "\nHeures de Travail Hebdo : " + this.heuresTravailHebdo;
}
}

