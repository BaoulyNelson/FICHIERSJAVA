
public class Station {
    private String nom;
    private double capaciteGazoline;
    private double pourcentageUtilisationGazoline;
    private double capaciteDiesel;
    private double pourcentageUtilisationDiesel;
    private double quantiteGallonDiesel;
    private double quantiteGallonGazoline;

    public Station(String nom, double capaciteGazoline, double capaciteDiesel) {
        this.nom = nom;
        this.capaciteGazoline = capaciteGazoline;
        this.pourcentageUtilisationGazoline = 100;
        this.capaciteDiesel = capaciteDiesel;
        this.pourcentageUtilisationDiesel = 100;
        this.quantiteGallonDiesel = 0;
        this.quantiteGallonGazoline = 0;
    }

  
    public void vendre(double quantiteDiesel, double quantiteGazoline) {
        if (quantiteDiesel <= quantiteGallonDiesel && quantiteGazoline <= quantiteGallonGazoline) {
            quantiteGallonDiesel -= quantiteDiesel;
            quantiteGallonGazoline -= quantiteGazoline;

            mettreAJourPourcentageUtilisation();
            System.out.println("Vente effectuée avec succès à la station " + nom + ".");
        } else {
            System.out.println("La station " + nom + " n'a pas assez de stock pour la vente demandée.");
        }
    }

    public void approvisionner(double quantiteDiesel, double quantiteGazoline) {
        quantiteGallonDiesel += quantiteDiesel;
        quantiteGallonGazoline += quantiteGazoline;

        mettreAJourPourcentageUtilisation();
        System.out.println("Approvisionnement effectué avec succès à la station " + nom + ".");
    }

    private void mettreAJourPourcentageUtilisation() {
        pourcentageUtilisationDiesel = (quantiteGallonDiesel / capaciteDiesel) * 100;
        pourcentageUtilisationGazoline = (quantiteGallonGazoline / capaciteGazoline) * 100;
    }


    @Override
    public String toString() {
        return "Station{" +
                "nom='" + nom + '\'' +
                ", pourcentageUtilisationGazoline=" + pourcentageUtilisationGazoline +
                ", pourcentageUtilisationDiesel=" + pourcentageUtilisationDiesel +
                ", quantiteGallonDiesel=" + quantiteGallonDiesel +
                ", quantiteGallonGazoline=" + quantiteGallonGazoline +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCapaciteGazoline() {
        return capaciteGazoline;
    }

    public void setCapaciteGazoline(double capaciteGazoline) {
        this.capaciteGazoline = capaciteGazoline;
    }

    public double getPourcentageUtilisationGazoline() {
        return pourcentageUtilisationGazoline;
    }

    public void setPourcentageUtilisationGazoline(double pourcentageUtilisationGazoline) {
        this.pourcentageUtilisationGazoline = pourcentageUtilisationGazoline;
    }

    public double getCapaciteDiesel() {
        return capaciteDiesel;
    }

    public void setCapaciteDiesel(double capaciteDiesel) {
        this.capaciteDiesel = capaciteDiesel;
    }

    public double getPourcentageUtilisationDiesel() {
        return pourcentageUtilisationDiesel;
    }

    public void setPourcentageUtilisationDiesel(double pourcentageUtilisationDiesel) {
        this.pourcentageUtilisationDiesel = pourcentageUtilisationDiesel;
    }

    public double getQuantiteGallonDiesel() {
        return quantiteGallonDiesel;
    }

    public void setQuantiteGallonDiesel(double quantiteGallonDiesel) {
        this.quantiteGallonDiesel = quantiteGallonDiesel;
    }

    public double getQuantiteGallonGazoline() {
        return quantiteGallonGazoline;
    }

    public void setQuantiteGallonGazoline(double quantiteGallonGazoline) {
        this.quantiteGallonGazoline = quantiteGallonGazoline;
    }

    // Getters et setters si nécessaire
}
