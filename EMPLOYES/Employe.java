public abstract class Employe extends Personne {
    public Employe(String nom, String prenom) {
        super(nom, prenom);
    }

    public abstract double calculerSalaire();
    public abstract void saisirDetails(); // Méthode abstraite


    @Override
    public String toString() {
        return super.toString();
    }
}