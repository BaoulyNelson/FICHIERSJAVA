public class Matiere {
    private String nom;
    private int pointsMax;

    public Matiere(String nom, int pointsMax) {
        this.nom = nom;
        this.pointsMax = pointsMax;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsMax() {
        return pointsMax;
    }
}
