public class Audio extends Document {

    private String classification;

    public Audio(String code, String titre, String auteur, String annee, boolean empruntable, String classification) {
        super(code, titre, auteur, annee, empruntable);
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères de l'audio
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()); // Appelle la méthode toString() de la classe parente (Document)
        stringBuilder.append("Classification: ").append(classification).append("\n");

        return stringBuilder.toString();
    }
}
