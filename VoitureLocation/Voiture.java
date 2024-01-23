import java.util.Random;

public class Voiture {
    private String numero;
    private String marque;
    private String modele;
    private int nombreCylindre;
    private double prix;
    private static Random random = new Random();

    public Voiture(String marque, String modele, int nombreCylindre, double prix) {
        this.numero = generateCodeVoiture();
        this.marque = marque;
        this.modele = modele;
        this.nombreCylindre = nombreCylindre;
        this.prix = prix;
    }

    public String generateCodeVoiture() {
        // Générer deux lettres aléatoires de l'alphabet français avec StringBuilder
        char premiereLettre = (char) (random.nextInt(26) + 'A');

        // La deuxième lettre est la même que la première
        char deuxiemeLettre = premiereLettre;

        // Ajouter le tiret
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append(premiereLettre);
        codeBuilder.append(deuxiemeLettre);
        codeBuilder.append("-");

        // Ajouter un nombre quelconque (par exemple, entre 1000 et 9999)
        int nombreQuelconque = random.nextInt(99999) ;
        codeBuilder.append(nombreQuelconque);

        return codeBuilder.toString();
    }

    @Override
    public String toString() {
        return "Voiture [\n" +
                "  Numero=" + numero + "\n" +
                "  Marque=" + marque + "\n" +
                "  Modele=" + modele + "\n" +
                "  Nombre de cylindres=" + nombreCylindre + " cylindres\n" +
                "  Prix=" + prix + " Gourdes\n" +
                "]";
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the modele
     */
    public String getModele() {
        return modele;
    }

    /**
     * @param modele the modele to set
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * @return the nombreCylindre
     */
    public int getNombreCylindre() {
        return nombreCylindre;
    }

    /**
     * @param nombreCylindre the nombreCylindre to set
     */
    public void setNombreCylindre(int nombreCylindre) {
        this.nombreCylindre = nombreCylindre;
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
}
