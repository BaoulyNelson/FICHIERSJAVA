public class OrdinateurDeBureau extends Produit {
    private String processeur;
    private int ram;
    private int disqueDur;
    private String systemeExploitation;

    // Caractéristiques spécifiques aux ordinateurs de bureau
    private String carteGraphique;

    public OrdinateurDeBureau(int numeroReference, String marque, String dateFabrication, double prix,
            String processeur, int ram, int disqueDur, String systemeExploitation,
            String carteGraphique) {
        super(numeroReference, marque, dateFabrication, prix);
        this.processeur = processeur;
        this.ram = ram;
        this.disqueDur = disqueDur;
        this.systemeExploitation = systemeExploitation;
        this.carteGraphique = carteGraphique;
    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisqueDur() {
        return disqueDur;
    }

    public void setDisqueDur(int disqueDur) {
        this.disqueDur = disqueDur;
    }

    public String getSystemeExploitation() {
        return systemeExploitation;
    }

    public void setSystemeExploitation(String systemeExploitation) {
        this.systemeExploitation = systemeExploitation;
    }

    public String getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(String carteGraphique) {
        this.carteGraphique = carteGraphique;
    }

    @Override
    public String toString() {
        if (carteGraphique != null) {
            return "\nOrdinateur de bureau:\n" +
                    "Processeur: " + processeur + "\n" +
                    "RAM: " + ram + " Go\n" +
                    "Disque Dur: " + disqueDur + " Go\n" +
                    "Système d'exploitation: " + systemeExploitation + "\n" +
                    "Carte graphique: " + carteGraphique;
        } else {
            return "anyen pa mache";

        }

    }
}
