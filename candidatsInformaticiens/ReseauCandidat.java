import java.util.Random;

public class ReseauCandidat extends Candidat {
    private int noteMiseEnPlace;
    private int noteQuestion1;
    private int noteQuestion2;
    private int noteQuestion3;
    private int noteQuestion4;

    public ReseauCandidat(String nomComplet, String sexe, int noteMiseEnPlace,
            int noteQuestion1, int noteQuestion2, int noteQuestion3, int noteQuestion4) {
        super(nomComplet, sexe);
        this.noteMiseEnPlace = noteMiseEnPlace;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
        this.noteQuestion3 = noteQuestion3;
        this.noteQuestion4 = noteQuestion4;
    }

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

    @Override
    protected String genererCode() {
        Random random = new Random();
        String alphabet = "RES-";
        int nombreAleatoire = random.nextInt(1999);
        StringBuilder sb = new StringBuilder();
        sb.append("").append(alphabet).append(nombreAleatoire);
        return sb.toString();
    }

   // Implémentation de la méthode pour calculer la moyenne en Réseau
   @Override
    public double calculerMoyenne() {
        // Calcul de la moyenne spécifique pour les candidats en programmation
        return ((noteMiseEnPlace + noteQuestion1 + noteQuestion2 + noteQuestion3 +noteQuestion4) / 1150.0)*100;
    }


private int totalPoints() {
    int totalPoints = getNoteMiseEnPlace() + getNoteQuestion1() + getNoteQuestion2() +
                      getNoteQuestion3() + getNoteQuestion4();
    return totalPoints;
}

   
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString()).append("\n")
                .append("Note Mise en Place: ").append(noteMiseEnPlace).append("\n")
                .append("Note Question 1: ").append(noteQuestion1).append("\n")
                .append("Note Question 2: ").append(noteQuestion2).append("\n")
                .append("Note Question 3: ").append(noteQuestion3).append("\n")
                .append("Note Question 4: ").append(noteQuestion4).append("\n")
                .append("Total points: ").append(totalPoints()).append(" sur 1150 points").append("\n")
                .append("Moyenne: ").append(calculerMoyenne()).append(" sur 100").append("\n")
                .append("Mention: ").append(determinerStatut()).append("\n");

        return stringBuilder.toString();
    }

}
