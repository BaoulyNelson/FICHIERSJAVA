import java.util.Random;

public class Habitation {
    private int codeIdentification;
    private String nifProprietaire;
    private String typeHabitation;
    private String zone;
    private String adresse;
    private double surface;

    public Habitation(int codeIdentification, String nifProprietaire, String typeHabitation, String zone,
            String adresse, double surface) {
        this.codeIdentification = new Random().nextInt(100);
        this.nifProprietaire = nifProprietaire;
        this.typeHabitation = typeHabitation;
        this.zone = zone;
        this.adresse = adresse;
        this.surface = surface;
    }

    public int getCodeIdentification() {
        return codeIdentification;
    }

    public void setCodeIdentification(int codeIdentification) {
        this.codeIdentification = codeIdentification;
    }

    public String getNifProprietaire() {
        return nifProprietaire;
    }

    public void setNifProprietaire(String nifProprietaire) {
        this.nifProprietaire = nifProprietaire;
    }

    public String getTypeHabitation() {
        return typeHabitation;
    }

    public void setTypeHabitation(String typeHabitation) {
        this.typeHabitation = typeHabitation;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    // Autres méthodes de la classe Habitation

    public double calculerImpot() {
        // Logique de calcul des impôts pour une habitation générique
        return 0.0;
    }

    @Override
    public String toString() {
        return "Habitation [\n"
                + "codeIdentification=" + codeIdentification + ",\n"
                + "nifProprietaire=" + nifProprietaire + ",\n"
                + "typeHabitation=" + typeHabitation + ",\n"
                + "zone=" + zone + ",\n"
                + "adresse=" + adresse + ",\n"
                + "surface=" + surface + "\n"
                + "]";
    }
    
}
