import java.util.Random;

public class Produit {
    private int numeroReference;
    private String marque;
    private String dateFabrication;
    private double prix;

    public Produit(int numeroReference, String marque, String dateFabrication, double prix) {
        this.numeroReference = new Random().nextInt(100);
        this.marque = marque;
        this.dateFabrication = dateFabrication;
        this.prix = prix;
    }

    public int getNumeroReference() {
        return numeroReference;
    }

    public void setNumeroReference(int numeroReference) {
        this.numeroReference = numeroReference;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(String dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
public String toString() {
    return "Numero de reference: " + numeroReference + "\n" +
           "Marque: " + marque + "\n" + 
           "Date de fabrication: " + dateFabrication + "\n"+
           "Prix: " + prix+ " Gourdes";
}

}
