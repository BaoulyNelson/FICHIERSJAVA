public class OrdinateurPortable extends Produit {
    private String processeur;
    private int ram;
    private int disqueDur;
    private String systemeExploitation;

    // Caractéristiques spécifiques aux ordinateurs portables
    private String typeEcran;
    private double tailleEcran;

    public OrdinateurPortable(int numeroReference, String marque, String dateFabrication, double prix,
            String processeur, int ram, int disqueDur, String systemeExploitation,
            String typeEcran, double tailleEcran) {
        super(numeroReference, marque, dateFabrication, prix);
        this.processeur = processeur;
        this.ram = ram;
        this.disqueDur = disqueDur;
        this.systemeExploitation = systemeExploitation;
        this.typeEcran = typeEcran;
        this.tailleEcran = tailleEcran;
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

    public String getTypeEcran() {
        return typeEcran;
    }

    public void setTypeEcran(String typeEcran) {
        this.typeEcran = typeEcran;
    }

    public double getTailleEcran() {
        return tailleEcran;
    }

    public void setTailleEcran(double tailleEcran) {
        this.tailleEcran = tailleEcran;
    }

    @Override
    public String toString() {
        if (typeEcran != null) {
            return "\nOrdinateur Portable:\n" +
                    "Processeur: " + processeur + "\n" +
                    "RAM: " + ram + " Go\n" +
                    "Disque Dur: " + disqueDur + " Go\n" +
                    "Système d'exploitation: " + systemeExploitation + "\n" +
                    "Type d'écran: " + typeEcran + "\n" +
                    "Taille d'écran: " + tailleEcran + " pouces";
        } else {
            return "anyen pa mache";

        }

    }
}
