public class Scanners extends Produit {
    private int resolution;

    public Scanners(int numeroReference, String marque, String dateFabrication, double prix, int resolution) {
        super(numeroReference, marque, dateFabrication, prix);
        this.resolution = resolution;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    @Override
public String toString() {
    return "\nScanner:\n" +
           "Résolution: " + resolution;
}

}
