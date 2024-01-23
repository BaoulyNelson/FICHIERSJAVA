import java.text.SimpleDateFormat;
import java.util.Date;

public class Vente {
    private static int nextId = 1;

    private int id;
    private Station station;
    private double quantiteGallonDieselVendu;
    private double quantiteGallonGazolineVendu;
    private Date dateVente;

    public Vente(Station station, double quantiteGallonDieselVendu, double quantiteGallonGazolineVendu) {
        this.id = nextId++;
        this.station = station;
        this.quantiteGallonDieselVendu = quantiteGallonDieselVendu;
        this.quantiteGallonGazolineVendu = quantiteGallonGazolineVendu;
        this.dateVente = new Date();

        // Diminuer la quantité disponible dans la station
        station.vendre(quantiteGallonDieselVendu, quantiteGallonGazolineVendu);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Vente{" +
                "id=" + id +
                ", station=" + station.getNom() +
                ", quantiteGallonDieselVendu=" + quantiteGallonDieselVendu +
                ", quantiteGallonGazolineVendu=" + quantiteGallonGazolineVendu +
                ", dateVente=" + sdf.format(dateVente) +
                '}';
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Vente.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public double getQuantiteGallonDieselVendu() {
        return quantiteGallonDieselVendu;
    }

    public void setQuantiteGallonDieselVendu(double quantiteGallonDieselVendu) {
        this.quantiteGallonDieselVendu = quantiteGallonDieselVendu;
    }

    public double getQuantiteGallonGazolineVendu() {
        return quantiteGallonGazolineVendu;
    }

    public void setQuantiteGallonGazolineVendu(double quantiteGallonGazolineVendu) {
        this.quantiteGallonGazolineVendu = quantiteGallonGazolineVendu;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    
}
