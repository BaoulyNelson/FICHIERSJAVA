import java.util.Random;

public class Personne implements Comparable<Personne> {
    private int code;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private int telephone;
    private String email;
    private String dateNaissance;
    private String lieuNaissance;

    public Personne(String nom, String prenom, String sexe, String adresse,
                    String email, String dateNaissance, String lieuNaissance) {
        this.code = new Random().nextInt(100);
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = new Random().nextInt(98765432);
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    // Getters et setters (non inclus pour plus de concision)

    @Override
    public int compareTo(Personne autrePersonne) {
        return this.nom.compareTo(autrePersonne.nom);
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
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
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
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
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
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
     * @return the dateNaissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the lieuNaissance
     */
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * @param lieuNaissance the lieuNaissance to set
     */
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Code: ").append(code).append("\n")
              .append("Nom: ").append(nom).append("\n")
              .append("Prénom: ").append(prenom).append("\n")
              .append("Sexe: ").append(sexe).append("\n")
              .append("Adresse: ").append(adresse).append("\n")
              .append("Téléphone: ").append(telephone).append("\n")
              .append("Email: ").append(email).append("\n")
              .append("Date de Naissance: ").append(dateNaissance).append("\n")
              .append("Lieu de Naissance: ").append(lieuNaissance).append("\n");
        return result.toString();
    }
}
    
    
