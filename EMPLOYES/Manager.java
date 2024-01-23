import java.util.ArrayList;
import java.util.List;

public class Manager extends Employe {
    private List<Employe> employesSousSupervision;

    public Manager(String nom, String prenom) {
        super(nom, prenom);
        employesSousSupervision = new ArrayList<>();
    }

    public void ajouterEmployeSousSupervision(Employe employe) {
        employesSousSupervision.add(employe);
    }

    public void afficherEmployesSousSupervision() {
        if (employesSousSupervision.isEmpty()) {
            System.out.println("Aucun employé sous supervision.");
        } else {
            System.out.println("Employés sous supervision :");
            for (Employe employe : employesSousSupervision) {
                employe.toString();
            }
        }
    }

    @Override
    public double calculerSalaire() {
        // Logique de calcul du salaire pour un manager
        return 0.0;
    }

    // Méthode pour saisir les détails spécifiques à un employé contractuel
    @Override
    public void saisirDetails() {
    }

   // Méthode toString pour afficher les détails de l'employé contractuel
@Override
public String toString() {
    return "managere " + super.toString();
}
}