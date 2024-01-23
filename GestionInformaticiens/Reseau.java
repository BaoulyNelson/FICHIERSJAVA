import java.util.Random;

public class Reseau extends Candidat {
    private int noteMiseEnPlace;
    private int noteQuestion1;
    private int noteQuestion2;
    private int noteQuestion3;
    private int noteQuestion4;

    // Ajout d'un autre constructeur avec les notes spécifiques
    public Reseau(String nomComplet, char sexe, int noteMiseEnPlace, int noteQuestion1, int noteQuestion2, int noteQuestion3, int noteQuestion4) {
        super(nomComplet, sexe);
        this.noteMiseEnPlace = noteMiseEnPlace;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
        this.noteQuestion3 = noteQuestion3;
        this.noteQuestion4 = noteQuestion4;
    }

    // Getters et setters...

    public int getNoteMiseEnPlace() {
        return noteMiseEnPlace;
    }

    public void setNoteMiseEnPlace(int noteMiseEnPlace) {
        this.noteMiseEnPlace = noteMiseEnPlace;
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

    public int getNoteQuestion4() {
        return noteQuestion4;
    }

    public void setNoteQuestion4(int noteQuestion4) {
        this.noteQuestion4 = noteQuestion4;
    }

    public int calculerTotalPoints() {
        return noteMiseEnPlace + noteQuestion1 + noteQuestion2 + noteQuestion3 + noteQuestion4;
    }

    public double calculerMoyenne() {
        // Définir les coefficients des notes
        int coefficientMiseEnPlace = 250;
        int coefficientQuestion1 = 150;
        int coefficientQuestion2 = 200;
        int coefficientQuestion3 = 250;
        int coefficientQuestion4 = 300;
    
        // Calculer la somme pondérée des notes
        double sommePonderee =calculerTotalPoints();
        // Calculer la somme des coefficients
        int sommeCoefficients = coefficientMiseEnPlace + coefficientQuestion1 + coefficientQuestion2 + coefficientQuestion3 + coefficientQuestion4;
    
        // Calculer la moyenne basée sur 100
        return (sommePonderee / sommeCoefficients) * 100;
    }
    
    public String getStatutAdmission() {
        int totalPoints = calculerTotalPoints();

        // Vérifier si le candidat est admis ou échoué
        if (totalPoints >= 575) {
            return "Admis";
        } else {
            return "Echoue";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Note Mise en Place: ").append(noteMiseEnPlace).append(" sur 250\n");
        sb.append("Note Question 1: ").append(noteQuestion1).append(" sur 150\n");
        sb.append("Note Question 2: ").append(noteQuestion2).append(" sur 200\n");
        sb.append("Note Question 3: ").append(noteQuestion3).append(" sur 250\n");
        sb.append("Note Question 4: ").append(noteQuestion4).append(" sur 300\n");
        sb.append("Total des points: ").append(calculerTotalPoints()).append(" points sur 1150\n");
        sb.append("Moyenne: ").append(calculerMoyenne()).append(" sur 100\n");
        sb.append("Statut d'admission: ").append(getStatutAdmission()).append("\n");  // Ajout de la mention d'admission
        
        return sb.toString();
    }

    @Override
    protected String genererCode() {
        Random random = new Random();
        int nombreAleatoire = random.nextInt(9000) + 1000;
        return "RES-" + nombreAleatoire;
    }
}
