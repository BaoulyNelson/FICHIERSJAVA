public class Livre extends Document {

    private int nombrePages;

    public Livre(String code, String titre, String auteur, String annee, boolean empruntable, int nombrePages) {
        super(code, titre, auteur, annee, empruntable);
        this.nombrePages = nombrePages;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères du livre
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()); // Appelle la méthode toString() de la classe parente (Document)
        stringBuilder.append("Nombre de pages: ").append(nombrePages).append("\n");

        return stringBuilder.toString();
    }
}
