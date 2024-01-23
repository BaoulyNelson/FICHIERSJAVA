public class Video extends Document {

    private int duree;
    private String mentionLegale;

    public Video(String code, String titre, String auteur, String annee, boolean empruntable, int duree, String mentionLegale) {
        super(code, titre, auteur, annee, empruntable);
        this.duree = duree;
        this.mentionLegale = mentionLegale;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getMentionLegale() {
        return mentionLegale;
    }

    public void setMentionLegale(String mentionLegale) {
        this.mentionLegale = mentionLegale;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères de la vidéo
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()); // Appelle la méthode toString() de la classe parente (Document)
        stringBuilder.append("Durée: ").append(duree).append(" minutes\n");
        stringBuilder.append("Mention légale: ").append(mentionLegale).append("\n");

        return stringBuilder.toString();
    }
}
