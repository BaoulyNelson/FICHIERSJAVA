public class Employe {
    private String code;
    private String nom;
    private String prenom;
    private String sexe;
    private String poste;
    private int nombreHeures;
    private double prixParHeure;


    public Employe(String code, String nom, String prenom, String sexe, String poste, int nombreHeures, double prixParHeure) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.poste = poste;
        this.nombreHeures = nombreHeures;
        this.prixParHeure = prixParHeure;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getNombreHeures() {
        return nombreHeures;
    }

    public void setNombreHeures(int nombreHeures) {
        this.nombreHeures = nombreHeures;
    }

    public double getPrixParHeure() {
        return prixParHeure;
    }

    public void setPrixParHeure(double prixParHeure) {
        this.prixParHeure = prixParHeure;
    }
 
    
    public double calculerSalaireBrut() {
        return nombreHeures * prixParHeure;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Code: ").append(code).append("\n");
        result.append("Nom: ").append(nom).append("\n");
        result.append("Prenom: ").append(prenom).append("\n");
        result.append("Sexe: ").append(sexe).append("\n");
        result.append("Poste: ").append(poste).append("\n");
        result.append("Nombre d'heures: ").append(nombreHeures).append(" heures\n");
        result.append("Prix par heure: ").append(prixParHeure).append(" Gourdes\n");
    
        return result.toString();
    }
    

}
