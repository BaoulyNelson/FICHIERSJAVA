public class Document {

    private String code;
    private String titre;
    private String auteur;
    private String annee;
    private boolean empruntable;
    private Localisation localisation;



    public Document(String code, String titre, String auteur, String annee, boolean empruntable) {
        this.code = code;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.empruntable = empruntable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public boolean isEmpruntable() {
        return empruntable;
    }

    public void setEmpruntable(boolean empruntable) {
        this.empruntable = empruntable;
    }

    // Getter and setter for localisation
public Localisation getLocalisation() {
    return localisation;
}

public void setLocalisation(Localisation localisation) {
    this.localisation = localisation;
}

// Méthode pour localiser le document
public String localiser() {
    return "Salle: " + localisation.getSalle() + ", Rayon: " + localisation.getRayon();
}
    // Méthode pour obtenir la représentation sous forme de chaîne de caractères du document
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Code: ").append(code).append("\n");
        stringBuilder.append("Titre: ").append(titre).append("\n");
        stringBuilder.append("Auteur: ").append(auteur).append("\n");
        stringBuilder.append("Année: ").append(annee).append("\n");
        stringBuilder.append("Empruntable: ").append(empruntable).append("\n");

        return stringBuilder.toString();
    }
}
