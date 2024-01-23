
public  class Candidat {
    private String code;
    private String nomComplet;
    private char sexe;

    public Candidat(String nomComplet, char sexe) {
        this.code = genererCode();
        this.nomComplet = nomComplet;
        this.sexe = sexe;
    }

    protected  String genererCode(){
        return "";
    };

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==Candidat==\n");
        sb.append("code: ").append(code).append("\n");
        sb.append("nomComplet: ").append(nomComplet).append("\n");
        sb.append("sexe: ").append(sexe).append("");
        return sb.toString();
    }

    public double calculerMoyenne() {
        return 0.0;
    }
   
}