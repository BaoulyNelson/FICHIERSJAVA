import java.util.Random;

public class BaseDeDonnees extends Candidat {
    private int noteConception;
    private int noteQuestion1;
    private int noteQuestion2;

    // Ajout d'un autre constructeur avec les notes spécifiques
    public BaseDeDonnees(String nomComplet, char sexe, int noteConception, int noteQuestion1, int noteQuestion2) {
        super(nomComplet, sexe);
        this.noteConception = noteConception;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
    }

    // Getters et setters...

    public int getNoteConception() {
        return noteConception;
    }

    public void setNoteConception(int noteConception) {
        this.noteConception = noteConception;
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

    public int calculerTotalPoints() {
        return noteConception + noteQuestion1 + noteQuestion2;
    }

    public double calculerMoyenne() {
        // Définir les coefficients des notes
        int coefficientConception = 300;
        int coefficientQuestion1 = 250;
        int coefficientQuestion2 = 250;
    
        // Calculer la somme pondérée des notes
        double sommePonderee = calculerTotalPoints();
    
        // Calculer la somme des coefficients
        int sommeCoefficients = coefficientConception + coefficientQuestion1 + coefficientQuestion2;
    
        // Calculer la moyenne basée sur 100
        return (sommePonderee / sommeCoefficients) * 100;
    }
    
    public String getStatutAdmission() {
        int totalPoints = calculerTotalPoints();

        // Vérifier si le candidat est admis ou échoué
        if (totalPoints >= 400) {
            return "Admis";
        } else {
            return "Echoue";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Note Conception: ").append(noteConception).append(" sur 300\n");
        sb.append("Note Question 1: ").append(noteQuestion1).append(" sur 250\n");
        sb.append("Note Question 2: ").append(noteQuestion2).append(" sur 250\n");
        sb.append("Total des points: ").append(calculerTotalPoints()).append(" points sur 800\n");
        sb.append("Moyenne: ").append(calculerMoyenne()).append(" sur 100\n");
        sb.append("Statut d'admission: ").append(getStatutAdmission()).append("\n");  // Ajout de la mention d'admission
    
        return sb.toString();
    }

    @Override
    protected String genererCode() {
        Random random = new Random();
        int nombreAleatoire = random.nextInt(9000) + 1000;
        return "BDD-" + nombreAleatoire;
    }
}
