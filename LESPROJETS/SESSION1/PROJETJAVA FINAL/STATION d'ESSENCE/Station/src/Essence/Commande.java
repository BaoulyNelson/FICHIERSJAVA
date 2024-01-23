package Essence;
import java.util.Random;

public class Commande {
    private int ID;
    private int quantiteDiesel;
    private int quantiteGazoline;
    private String dateCommande;
    private String etat;
    
    // Constructeur
    public Commande(int quantiteDiesel, int quantiteGazoline, String dateCommande,String etat) {
        this.ID = new Random().nextInt(10);
        this.quantiteDiesel = quantiteDiesel;
        this.quantiteGazoline = quantiteGazoline;
        this.dateCommande = dateCommande;
        this.etat = "N";
    }
    /**
     * @return the iD
     */
    public int getID() {
        return ID;
    }

    /**
     * @param iD the iD to set
     */
    public void setID(int iD) {
        ID = iD;
    }

    /**
     * @return the quantiteDiesel
     */
    public int getQuantiteDiesel() {
        return quantiteDiesel;
    }

    /**
     * @param quantiteDiesel the quantiteDiesel to set
     */
    public void setQuantiteDiesel(int quantiteDiesel) {
        this.quantiteDiesel = quantiteDiesel;
    }

    /**
     * @return the quantiteGazoline
     */
    public int getQuantiteGazoline() {
        return quantiteGazoline;
    }

    /**
     * @param quantiteGazoline the quantiteGazoline to set
     */
    public void setQuantiteGazoline(int quantiteGazoline) {
        this.quantiteGazoline = quantiteGazoline;
    }

    /**
     * @return the dateCommande
     */
    public String getDateCommande() {
        return dateCommande;
    }

    /**
     * @param dateCommande the dateCommande to set
     */
    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }
    // Méthode d'affichage
    public void afficherCommande() {
        System.out.println("ID : " + getID());
        System.out.println("Quantité Diesel : " + getQuantiteDiesel());
        // Afficher les autres informations
    }
}
