import java.text.SimpleDateFormat;
import java.util.Date;

public class Approvisionnement {
    private static int nextId = 1;

    private int id;
    private Station station;
    private double quantiteGallonDiesel;
    private double quantiteGallonGazoline;
    private Date dateApprovisionnement;

    public Approvisionnement(Station station, double quantiteGallonDiesel, double quantiteGallonGazoline) {
        this.id = nextId++;
        this.station = station;
        this.quantiteGallonDiesel = quantiteGallonDiesel;
        this.quantiteGallonGazoline = quantiteGallonGazoline;
        this.dateApprovisionnement = new Date();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Approvisionnement{" +
                "id=" + id +
                ", station=" + station.getNom() +
                ", quantiteGallonDiesel=" + quantiteGallonDiesel +
                ", quantiteGallonGazoline=" + quantiteGallonGazoline +
                ", dateApprovisionnement=" + sdf.format(dateApprovisionnement) +
                '}';
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Approvisionnement.nextId = nextId;
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

    public double getQuantiteGallonDiesel() {
        return quantiteGallonDiesel;
    }

    public void setQuantiteGallonDiesel(double quantiteGallonDiesel) {
        this.quantiteGallonDiesel = quantiteGallonDiesel;
    }

    public double getQuantiteGallonGazoline() {
        return quantiteGallonGazoline;
    }

    public void setQuantiteGallonGazoline(double quantiteGallonGazoline) {
        this.quantiteGallonGazoline = quantiteGallonGazoline;
    }

    public Date getDateApprovisionnement() {
        return dateApprovisionnement;
    }

    public void setDateApprovisionnement(Date dateApprovisionnement) {
        this.dateApprovisionnement = dateApprovisionnement;
    }

}
