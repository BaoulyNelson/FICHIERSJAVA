// Logement.java
import java.util.Date;

public class Logement {
    private String commune;
    private String quartier;
    private String adresse;
    private double superficie;
    private double loyer;
    private String type;
    private double chargesForfaitaires;

    public Logement(String commune, String quartier, String adresse, double superficie, double loyer, String type, double chargesForfaitaires) {
        this.commune = commune;
        this.quartier = quartier;
        this.adresse = adresse;
        this.superficie = superficie;
        this.loyer = loyer;
        this.type = type;
        this.chargesForfaitaires = chargesForfaitaires;
    }

    // Getters et Setters
    // ...

    public void louer(String signataire, Date dateDebut, Date dateFin) {
        // Enregistrez les informations relatives à la location
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getChargesForfaitaires() {
        return chargesForfaitaires;
    }

    public void setChargesForfaitaires(double chargesForfaitaires) {
        this.chargesForfaitaires = chargesForfaitaires;
    }
    @Override
    public String toString() {
        return "Commune: " + commune + "\n" +
               "Quartier: " + quartier + "\n" +
               "Adresse: " + adresse + "\n" +
               "Superficie: " + superficie + " Km carree\n" +
               "Loyer: " + loyer + " GOURDES\n" +
               "Type: " + type + "\n" +
               "Charges Forfaitaires: " + chargesForfaitaires + " GOURDES\n";
    }
}
