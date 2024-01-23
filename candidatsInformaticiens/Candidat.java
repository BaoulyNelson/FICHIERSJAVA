
public abstract class Candidat {
    private String code;
    private String nomComplet;
    private String sexe;

    // Constructeur
    public Candidat(String nomComplet, String sexe) {
        this.code = genererCode();
        this.nomComplet = nomComplet;
        this.sexe = sexe;
    }

    // Génération aléatoire du code
    protected String genererCode() {
        return null;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getSexe() {
        return sexe;
    }

 // Méthode abstraite pour calculer la moyenne
 public abstract double calculerMoyenne();
 
  public String determinerStatut() {
    // Logique spécifique pour déterminer le statut de tous les candidats 
    double moyenne = calculerMoyenne();

    if (moyenne >= 50.0) {
        return "Admis";
    } else {
        return "Échoué";
    }
}

    // Méthode toString avec StringBuilder
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Code: ").append(code).append("\n");
        stringBuilder.append("Nom Complet: ").append(nomComplet).append("\n");
        stringBuilder.append("Sexe: ").append(sexe);
        return stringBuilder.toString();
    }
    

}
