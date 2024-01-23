public class Localisation {

    private String salle;
    private String rayon;

    public Localisation(String salle, String rayon) {
        this.salle = salle;
        this.rayon = rayon;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères de la localisation
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Salle: ").append(salle).append("\n");
        stringBuilder.append("Rayon: ").append(rayon).append("\n");

        return stringBuilder.toString();
    }
}
