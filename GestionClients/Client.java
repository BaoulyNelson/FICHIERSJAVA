import java.util.Random;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private double pourcentageRabais;

    public Client(int id, String nom, String prenom, String email, String adresse,
            double pourcentageRabais) {
        this.id = new Random().nextInt(100);
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = generateTelephone();
        this.email = email;
        this.adresse = adresse;
        this.pourcentageRabais = pourcentageRabais;
    }

    public String generateTelephone() {
        Random random = new Random();
        String numT = random.toString();
        return "+509" + numT;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the pourcentageRabais
     */
    public double getPourcentageRabais() {
        return pourcentageRabais;
    }

    /**
     * @param pourcentageRabais the pourcentageRabais to set
     */
    public void setPourcentageRabais(double pourcentageRabais) {
        this.pourcentageRabais = pourcentageRabais;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client{")
            .append("id=").append(id).append('\'')
            .append(" nom='").append(nom).append('\'')
            .append(" prenom='").append(prenom).append('\'')
            .append(" telephone='").append(telephone).append('\'')
            .append(" email='").append(email).append('\'')
            .append(" adresse='").append(adresse).append('\'')
            .append(" pourcentageRabais=").append(pourcentageRabais)
            .append('}');
        return sb.toString();
    }
    
}
