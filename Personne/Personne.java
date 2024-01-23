import java.util.Random;

public class Personne{

    private int code;
    private String nom;
    private String prenom;
    private String ecole;
    private String matiere;
    private String prof;
    private String niveau;
    private boolean diplome;

    public Personne(String nom, String prenom, String ecole, String matiere, String prof, String niveau,
            boolean diplome) {
        this.code = Integer.parseInt(Integer.toString(new Random().nextInt(100)));
        this.nom = nom;
        this.prenom = prenom;
        this.ecole = ecole;
        this.matiere = matiere;
        this.prof = prof;
        this.niveau = niveau;
        this.diplome = diplome;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getNiveau() {
        return niveau;
    }


    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public boolean isDiplome() {
        return diplome;
    }

    public void setDiplome(boolean diplome) {
        this.diplome = diplome;
    }
}