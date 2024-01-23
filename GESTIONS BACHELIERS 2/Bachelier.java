import java.util.ArrayList;

public class Bachelier {
    private String matricule;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private int age;
   
    private ArrayList<Matiere> matieres;
    private ArrayList<Integer> notes;

    public Bachelier(String matricule, String nom, String prenom, String numeroTelephone,int age) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.age=age;
        this.matieres = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    public void ajouterMatiere(Matiere matiere) {
        matieres.add(matiere);
    }

    public void ajouterNote(int note) {
        notes.add(note);
    }

    
    public double calculerMoyenne() {
        int totalPoints = calculerTotalPoints();
        int totalMaxPoints = calculerTotalMaxPoints();

        if (totalMaxPoints == 0) {
            return 0.0; // Évitez la division par zéro en retournant 0 si totalMaxPoints est nul.
        }

        // Calcul de la moyenne en pourcentage
        double moyenne = (double) totalPoints / totalMaxPoints * 10;
        return moyenne;
    }

    public int calculerTotalMaxPoints() {
        int totalMaxPoints = 0;
        for (Matiere matiere : matieres) {
            totalMaxPoints += matiere.getPointsMax();
        }
        return totalMaxPoints;
    }
    
    public int calculerTotalPoints() {
        int totalPoints = 0;
        for (int i = 0; i < matieres.size(); i++) {
            totalPoints += notes.get(i);
        }
        return totalPoints;
    }
    public String determinerStatut() {
        int totalPoints = calculerTotalPoints();

        if (totalPoints >= 1300) {
            return "Admis";
        } else if (totalPoints > 1100 && totalPoints < 1300) {
            return "Ajourne";
        } else {
            return "Echoue";
        }
    }
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public ArrayList<Matiere> getMatieres() {
        return matieres;
    }

    public ArrayList<Integer> getNotes() {
        return notes;
    }
     /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

}
