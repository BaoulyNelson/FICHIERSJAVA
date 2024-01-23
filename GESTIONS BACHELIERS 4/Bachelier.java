import java.util.Map;
import java.util.HashMap;

public class Bachelier {
    private int matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private int total = 0;
    private int age;
    private double moyenne;
    private String statut;
    private HashMap<String, Float> matieres = new HashMap<String, Float>();
    private static int baremeHaut = 400;
    private static int baremeBas = 200;

    public Bachelier(String nom, String prenom, int age) {
        // Génération aléatoire de cinq chiffres pour compléter la matricule
        int randomMatricule = (int) (Math.random() * 9000) + 1000;
    
        // Mise à jour du format de la matricule
        this.matricule = Integer.parseInt("030000" + randomMatricule);
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = "+509" + Math.round(Math.random() * Math.pow(10, 8));
        this.age = age;
    }
    
    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getTotal() {
        return total;
    }

    public HashMap<String, Float> getMatieres() {
        return matieres;
    }

    public static int getBaremeHaut() {
        return baremeHaut;
    }

    public static int getBaremeBas() {
        return baremeBas;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public String getStatut() {
        return statut;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    public void setMoyenne() {
        for (Map.Entry<String, Float> matiere : matieres.entrySet()) {
            this.total += matiere.getValue();
        }
        int coefficient = baremeHaut * 3 + baremeBas * 7;
        this.moyenne = ((total * 100) / coefficient) / 10.0;
        if (total >= 1300) {
            this.statut = "Admis";
        } else if (total >= 1100 && total < 1300) {
            this.statut = "Ajourne";
        } else {
            this.statut = "Echoue";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matricule: ").append(matricule).append("\n");
        sb.append("Nom: ").append(nom).append("\n");
        sb.append("Prenom: ").append(prenom).append("\n");
        sb.append("Telephone: ").append(telephone).append("\n");
        sb.append("Age: ").append(age).append(" ans\n");
        sb.append("Matieres:\n");
        for (String matiere : matieres.keySet()) {
            sb.append("- ").append(matiere).append(": ").append(matieres.get(matiere)).append("\n");
        }
        sb.append("\n");
        sb.append("\tTotal: ").append(total).append(" points sur 2600\n");
        sb.append("\tMoyenne: ").append(moyenne).append(" sur 10\n");
        sb.append("\tStatut: ").append(statut).append("\n");

        return sb.toString();
    }

}
