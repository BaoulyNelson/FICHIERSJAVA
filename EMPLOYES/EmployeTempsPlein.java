import java.util.Scanner;

public class EmployeTempsPlein extends Employe {
    private double salaireMensuelFixe;

    public EmployeTempsPlein(String nom, String prenom, double salaireMensuelFixe) {
        super(nom, prenom);
        this.salaireMensuelFixe = salaireMensuelFixe;
    }

    @Override
    public double calculerSalaire() {
        // Logique de calcul du salaire pour un employé à temps plein
        return salaireMensuelFixe;
    }

    @Override
public void saisirDetails() {
    Scanner scanner = new Scanner(System.in);
            System.out.print("Salaire mensuel fixe: ");
            this.salaireMensuelFixe = scanner.nextDouble();
       
    }

   // Méthode toString pour afficher les détails de l'employé contractuel
@Override
public String toString() {
    return "Employé Temps plein\n" + super.toString() +
           "\nSalaire MensuelFixe : " + this.salaireMensuelFixe;
}
}