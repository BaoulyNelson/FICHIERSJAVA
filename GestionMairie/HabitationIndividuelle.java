public class HabitationIndividuelle extends Habitation {
    private int nombrePieces;
    private boolean presencePiscine;

    public HabitationIndividuelle(int codeIdentification, String nifProprietaire, String typeHabitation,
            String zone, String adresse, double surface, int nombrePieces, boolean presencePiscine) {
        super(codeIdentification, nifProprietaire, typeHabitation, zone, adresse, surface);
        this.nombrePieces = nombrePieces;
        this.presencePiscine = presencePiscine;
    }

    public int getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(int nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public boolean isPresencePiscine() {
        return presencePiscine;
    }

    public void setPresencePiscine(boolean presencePiscine) {
        this.presencePiscine = presencePiscine;
    }

    // Autres méthodes de la classe HabitationIndividuelle

    @Override
    public double calculerImpot() {
        // Logique de calcul des impôts pour une habitation individuelle
        double impotPieces = 500.0 * nombrePieces;
        double impotPiscine = presencePiscine ? 250.0 : 0.0;
        double impotSurface = 100.0 * getSurface();
        return impotPieces + impotPiscine + impotSurface;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHabitationIndividuelle: nombrePieces=" + nombrePieces +" pieces "+ ", presencePiscine="
                + presencePiscine+ "\n";
    }
    
}
