public class CategorieClient {

    private int nbEmpruntsMax;
    private float cotisation;
    private float coefTarif;
    private float coefDuree;

    public CategorieClient(int nbEmpruntsMax, float cotisation, float coefTarif, float coefDuree) {
        this.nbEmpruntsMax = nbEmpruntsMax;
        this.cotisation = cotisation;
        this.coefTarif = coefTarif;
        this.coefDuree = coefDuree;
    }

    public int getNbEmpruntsMax() {
        return nbEmpruntsMax;
    }

    public void setNbEmpruntsMax(int nbEmpruntsMax) {
        this.nbEmpruntsMax = nbEmpruntsMax;
    }

    public float getCotisation() {
        return cotisation;
    }

    public void setCotisation(float cotisation) {
        this.cotisation = cotisation;
    }

    public float getCoefTarif() {
        return coefTarif;
    }

    public void setCoefTarif(float coefTarif) {
        this.coefTarif = coefTarif;
    }

    public float getCoefDuree() {
        return coefDuree;
    }

    public void setCoefDuree(float coefDuree) {
        this.coefDuree = coefDuree;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères de la catégorie client
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Nombre d'emprunts max: ").append(nbEmpruntsMax).append("\n");
        stringBuilder.append("Cotisation: ").append(cotisation).append("\n");
        stringBuilder.append("Coefficient tarif: ").append(coefTarif).append("\n");
        stringBuilder.append("Coefficient durée: ").append(coefDuree).append("\n");

        return stringBuilder.toString();
    }
}
