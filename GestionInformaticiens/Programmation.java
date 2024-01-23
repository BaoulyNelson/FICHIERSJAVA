import java.util.Random;

public class Programmation extends Candidat {
    private int noteMiniProgramme;
    private int noteQuestion1;
    private int noteQuestion2;
    private int noteQuestion3;

    // Ajout d'un autre constructeur avec les notes spécifiques
    public Programmation(String nomComplet, char sexe, int noteMiniProgramme, int noteQuestion1, int noteQuestion2, int noteQuestion3) {
        super(nomComplet, sexe);
        this.noteMiniProgramme = noteMiniProgramme;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
        this.noteQuestion3 = noteQuestion3;
    }

    // Getters et setters...

    public int getNoteMiniProgramme() {
        return noteMiniProgramme;
    }

    public void setNoteMiniProgramme(int noteMiniProgramme) {
        this.noteMiniProgramme = noteMiniProgramme;
    }

    public int getNoteQuestion1() {
        return noteQuestion1;
    }

    public void setNoteQuestion1(int noteQuestion1) {
        this.noteQuestion1 = noteQuestion1;
    }

    public int getNoteQuestion2() {
        return noteQuestion2;
    }

    public void setNoteQuestion2(int noteQuestion2) {
        this.noteQuestion2 = noteQuestion2;
    }

    public int getNoteQuestion3() {
        return noteQuestion3;
    }

    public void setNoteQuestion3(int noteQuestion3) {
        this.noteQuestion3 = noteQuestion3;
        
    }
    public int calculerTotalPoints() {
        return noteMiniProgramme + noteQuestion1 + noteQuestion2 + noteQuestion3;
    }
    public double calculerMoyenne() {
        // Définir les coefficients des notes
        int coefficientMiniProgramme = 500;
        int coefficientQuestion1 = 200;
        int coefficientQuestion2 = 150;
        int coefficientQuestion3 = 150;
    
        // Calculer la somme pondérée des notes
        double sommePonderee = calculerTotalPoints();
    
        // Calculer la somme des coefficients
        int sommeCoefficients = coefficientMiniProgramme + coefficientQuestion1 + coefficientQuestion2 + coefficientQuestion3;
    
        // Calculer la moyenne basée sur 100
        double moyenne = (sommePonderee / sommeCoefficients) * 100;
    
        // Ajuster la moyenne pour s'assurer qu'elle ne dépasse pas 100
        return Math.min(moyenne, 100);
    }
    
    
    public String getStatutAdmission() {
        int totalPoints = calculerTotalPoints();

        // Vérifier si le candidat est admis ou échoué
        if (totalPoints >= 500) {
            return "Admis";
        } else {
            return "Echoue";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Note Mini Programme: ").append(noteMiniProgramme).append(" sur 500\n");
        sb.append("Note Question 1: ").append(noteQuestion1).append(" sur 200\n");
        sb.append("Note Question 2: ").append(noteQuestion2).append(" sur 150\n");
        sb.append("Note Question 3: ").append(noteQuestion3).append(" sur 150\n");
        sb.append("Total des points: ").append(calculerTotalPoints()).append(" points sur 1000\n");
        sb.append("Moyenne: ").append(calculerMoyenne()).append(" sur 100\n");
        sb.append("Statut d'admission: ").append(getStatutAdmission()).append("\n");  // Ajout de la mention d'admission
       
        return sb.toString();
    }
@Override
    protected String genererCode() {
        Random random = new Random();
        int nombreAleatoire = random.nextInt(9000) + 1000;  // Génère un nombre entre 1000 et 9999
        return "PRO-" + nombreAleatoire;  // Préfixe pour la classe Programmation
    }
}
