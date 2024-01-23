import java.util.Random;
public class Medicament {
    private String categorie;
    private int id;
    private String nom;
    private double prix;
    private int quantite;
    private String dateExpiration;

    public Medicament(String categorie, int id, String nom, double prix, int quantite, String dateExpiration) {
        this.categorie = categorie;
        this.id = new Random().nextInt(100);
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.dateExpiration = dateExpiration;
    }

    /**
     * @return the categorie
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the dateExpiration
     */
    public String getDateExpiration() {
        return dateExpiration;
    }

    /**
     * @param dateExpiration the dateExpiration to set
     */
    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    // Getters et setters pour les champs privés (categorie, id, nom, prix, quantite, dateExpiration)
    // À compléter
}
