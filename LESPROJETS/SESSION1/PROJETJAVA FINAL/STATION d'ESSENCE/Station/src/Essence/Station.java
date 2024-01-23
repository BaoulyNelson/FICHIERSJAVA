package Essence;

public class Station {
    private String nom;
    private int capaciteGazoline;
    private int capaciteDiesel;
    private int pourcentageUtilisationGazoline;
    private int pourcentageUtilisationDiesel;
    private int quantiteDieselDisponible;
    private int quantiteGazolineDisponible;
    
    // Constructeur
    public Station(String nom, int capaciteGazoline, int capaciteDiesel) {
        this.nom = nom;
        this.capaciteGazoline = capaciteGazoline;
        this.capaciteDiesel = capaciteDiesel;
        this.pourcentageUtilisationGazoline = 0;
        this.pourcentageUtilisationDiesel = 0;
        this.quantiteDieselDisponible = 0;
        this.quantiteGazolineDisponible = 0;
    }
    public Station (){};
    
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
     * @return the capaciteGazoline
     */
    public int getCapaciteGazoline() {
        return capaciteGazoline;
    }


    /**
     * @param capaciteGazoline the capaciteGazoline to set
     */
    public void setCapaciteGazoline(int capaciteGazoline) {
        this.capaciteGazoline = capaciteGazoline;
    }


    /**
     * @return the capaciteDiesel
     */
    public int getCapaciteDiesel() {
        return capaciteDiesel;
    }


    /**
     * @param capaciteDiesel the capaciteDiesel to set
     */
    public void setCapaciteDiesel(int capaciteDiesel) {
        this.capaciteDiesel = capaciteDiesel;
    }


    /**
     * @return the pourcentageUtilisationGazoline
     */
    public int getPourcentageUtilisationGazoline() {
        return pourcentageUtilisationGazoline;
    }


    /**
     * @param pourcentageUtilisationGazoline the pourcentageUtilisationGazoline to set
     */
    public void setPourcentageUtilisationGazoline(int pourcentageUtilisationGazoline) {
        this.pourcentageUtilisationGazoline = pourcentageUtilisationGazoline;
    }


    /**
     * @return the pourcentageUtilisationDiesel
     */
    public int getPourcentageUtilisationDiesel() {
        return pourcentageUtilisationDiesel;
    }


    /**
     * @param pourcentageUtilisationDiesel the pourcentageUtilisationDiesel to set
     */
    public void setPourcentageUtilisationDiesel(int pourcentageUtilisationDiesel) {
        this.pourcentageUtilisationDiesel = pourcentageUtilisationDiesel;
    }


    /**
     * @return the quantiteDieselDisponible
     */
    public int getQuantiteDieselDisponible() {
        return quantiteDieselDisponible;
    }


    /**
     * @param quantiteDieselDisponible the quantiteDieselDisponible to set
     */
    public void setQuantiteDieselDisponible(int quantiteDieselDisponible) {
        this.quantiteDieselDisponible = quantiteDieselDisponible;
    }


    /**
     * @return the quantiteGazolineDisponible
     */
    public int getQuantiteGazolineDisponible() {
        return quantiteGazolineDisponible;
    }


    /**
     * @param quantiteGazolineDisponible the quantiteGazolineDisponible to set
     */
    public void setQuantiteGazolineDisponible(int quantiteGazolineDisponible) {
        this.quantiteGazolineDisponible = quantiteGazolineDisponible;
    }
    
    // Méthode d'affichage
    public void afficherStation() {
        System.out.println("Nom de la station : " + nom);
        System.out.println("Capacite Gazoline : " + capaciteGazoline);
        // Afficher les autres informations
    }


}
