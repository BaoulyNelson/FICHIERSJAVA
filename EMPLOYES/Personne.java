// Classe de base représentant une personne
public class Personne {
    private String nom;
    private String prenom;

    // Constructeur
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Accesseurs (getters)
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    // Mutateurs (setters)
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  // Méthode toString pour afficher les détails de la personne
@Override
public String toString() {
    return "Nom: " + nom + "\nPrénom: " + prenom;
}

}
