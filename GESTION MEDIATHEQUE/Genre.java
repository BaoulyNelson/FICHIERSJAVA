public class Genre {

    private String nom;
    private int nbEmprunts;

    public Genre(String nom, int nbEmprunts) {
        this.nom = nom;
        this.nbEmprunts = nbEmprunts;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbEmprunts() {
        return nbEmprunts;
    }

    public void setNbEmprunts(int nbEmprunts) {
        this.nbEmprunts = nbEmprunts;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères du genre
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nom: ").append(nom).append("\n");
        stringBuilder.append("Nombre d'emprunts: ").append(nbEmprunts).append("\n");

        return stringBuilder.toString();
    }
}
