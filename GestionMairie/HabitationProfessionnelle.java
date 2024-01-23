public class HabitationProfessionnelle extends Habitation {
    private double surfaceOccupee;
    private int nombreEmployes;

    public HabitationProfessionnelle(int codeIdentification, String nifProprietaire, String typeHabitation,
            String zone, String adresse, double surface, double surfaceOccupee, int nombreEmployes) {
        super(codeIdentification, nifProprietaire, typeHabitation, zone, adresse, surface);
        this.surfaceOccupee = surfaceOccupee;
        this.nombreEmployes = nombreEmployes;
    }

    public double getSurfaceOccupee() {
        return surfaceOccupee;
    }

    public void setSurfaceOccupee(double surfaceOccupee) {
        this.surfaceOccupee = surfaceOccupee;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }

    // Autres méthodes de la classe HabitationProfessionnelle

    @Override
    public double calculerImpot() {
        // Logique de calcul des impôts pour une habitation professionnelle
        double impotSurface = 150.0 * surfaceOccupee;
        double impotEmployes = Math.ceil(nombreEmployes / 10.0) * 1000.0;
        return impotSurface + impotEmployes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHabitationProfessionnelle: surfaceOccupee=" + surfaceOccupee +" metres carres "+ ", nombreEmployes="
                + nombreEmployes+ " employes\n";
    }
    
}
