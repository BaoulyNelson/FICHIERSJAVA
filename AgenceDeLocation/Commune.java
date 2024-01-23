// Commune.java
public class Commune {
    private String nom;
    private int nombreHabitants;
    private double distanceAgence;

    public Commune(String nom, int nombreHabitants, double distanceAgence) {
        this.nom = nom;
        this.nombreHabitants = nombreHabitants;
        this.distanceAgence = distanceAgence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreHabitants() {
        return nombreHabitants;
    }

    public void setNombreHabitants(int nombreHabitants) {
        this.nombreHabitants = nombreHabitants;
    }

    public double getDistanceAgence() {
        return distanceAgence;
    }

    public void setDistanceAgence(double distanceAgence) {
        this.distanceAgence = distanceAgence;
    }
    @Override
    public String toString() {
        return "Nom de la commune: " + nom + "\n" +
               "Nombre d'habitants: " + nombreHabitants + " habitants\n" +
               "Distance à l'agence: " + distanceAgence + " Kms\n";
    }
}
