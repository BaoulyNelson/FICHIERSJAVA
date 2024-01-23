import java.text.SimpleDateFormat;
import java.util.Date;

public class Commande {
    private static int nextId = 1;

    private int id;
    private double quantiteGallonDiesel;
    private double quantiteGallonGazoline;
    private Date dateCommande;
    private char etat; // N=Nouvelle, P=Passe

    public Commande(double quantiteGallonDiesel, double quantiteGallonGazoline) {
        this.id = nextId++;
        this.quantiteGallonDiesel = quantiteGallonDiesel;
        this.quantiteGallonGazoline = quantiteGallonGazoline;
        this.dateCommande = new Date();
        this.etat = 'N';
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Commande{" +
                "id=" + id +
                ", quantiteGallonDiesel=" + quantiteGallonDiesel +
                ", quantiteGallonGazoline=" + quantiteGallonGazoline +
                ", dateCommande=" + sdf.format(dateCommande) +
                ", etat=" + etat +
                '}';
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Commande.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

}
