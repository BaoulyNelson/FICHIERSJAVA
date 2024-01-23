public class Imprimante extends Produit {
    private String type;
    private int resolution;
    private int vitesseImpression;

    public Imprimante(int numeroReference, String marque, String dateFabrication, double prix,
                      String type, int resolution, int vitesseImpression) {
        super(numeroReference, marque, dateFabrication, prix);
        this.type = type;
        this.resolution = resolution;
        this.vitesseImpression = vitesseImpression;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getVitesseImpression() {
        return vitesseImpression;
    }

    public void setVitesseImpression(int vitesseImpression) {
        this.vitesseImpression = vitesseImpression;
    }

    @Override
    public String toString() {
        return  "\nImprimante:\n" +
               "Type: " + type + "\n" +
               "Résolution: " + resolution + "\n" +
               "Vitesse d'impression: " + vitesseImpression;
    }
    
}
