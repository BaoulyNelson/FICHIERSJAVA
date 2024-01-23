import java.util.Random;

class Produit {
    private int code;
    private String categorie;
    private String nom;
    private double prixUnitaire;
    private int quantite;
    
    public Produit(int code, String categorie, String nom, double prixUnitaire, int quantite) {
        this.code = new Random().nextInt(100);
        this.categorie = categorie;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getCategorie() {
        return categorie;
    }
    
    public String getNom() {
        return nom;
    }
    
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    
    public int getQuantite() {
        return quantite;
    }
    
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public String toString() {
        return "Code: " + code + ", Catégorie: " + categorie + ", Nom: " + nom + ", Prix unitaire: " + prixUnitaire + ", Quantité: " + quantite;
    }
}
