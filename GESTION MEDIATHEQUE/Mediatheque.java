public class Mediatheque {

    private String nom;

    public Mediatheque(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères de la médiathèque
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nom de la médiathèque: ").append(nom).append("\n");

        return stringBuilder.toString();
    }
}
