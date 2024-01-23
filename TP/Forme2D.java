import java.awt.Color;

public class Forme2D {
    public static void main(String[] args) {
        
    }
    private Color couleur;

    public Forme2D() {
        this.couleur = Color.BLACK;
    }

    public Forme2D(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public double aire() {
        return 0.0;
    }

    public double perimetre() {
        return 0.0;
    }
}

 class Rectangle extends Forme2D {
    private double longueur;
    private double largeur;

    public Rectangle(Color couleur, double longueur, double largeur) {
        super(couleur);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    @Override
    public double aire() {
        return longueur * largeur;
    }

    @Override
    public double perimetre() {
        return 2 * (longueur + largeur);
    }
}

 class Disque extends Forme2D {
    private double rayon;

    public Disque(Color couleur, double rayon) {
        super(couleur);
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    public double diametre() {
        return 2 * rayon;
    }

    @Override
    public double aire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double perimetre() {
        return 2 * Math.PI * rayon;
    }
}
