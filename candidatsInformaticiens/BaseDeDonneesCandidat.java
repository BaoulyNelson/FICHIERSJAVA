import java.util.Random;

public class BaseDeDonneesCandidat extends Candidat {
    private int noteConception;
    private int noteQuestion1;
    private int noteQuestion2;

    public BaseDeDonneesCandidat(String nomComplet, String sexe, int noteConception,
            int noteQuestion1, int noteQuestion2) {
        super(nomComplet, sexe);
        this.noteConception = noteConception;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
    }

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

    @Override
    protected String genererCode() {
        Random random = new Random();
        String alphabet = "BDD-";
        int nombreAleatoire = random.nextInt(1999);
        StringBuilder sb = new StringBuilder();
        sb.append("").append(alphabet).append(nombreAleatoire);
        return sb.toString();
    }

   // Implémentation de la méthode pour calculer la moyenne en Base de données
   @Override
    public double calculerMoyenne() {
        // Calcul de la moyenne spécifique pour les candidats en programmation
        return ((noteConception + noteQuestion1 + noteQuestion2 ) / 800.0)*100;
    }


private int totalPoints() {
    int totalPoints = getNoteConception() + getNoteQuestion1() + getNoteQuestion2();
    return totalPoints;
}
 

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
    
        stringBuilder.append(super.toString()).append("\n")
                .append("Note Conception: ").append(noteConception).append("\n")
                .append("Note Question 1: ").append(noteQuestion1).append("\n")
                .append("Note Question 2: ").append(noteQuestion2).append("\n")
                .append("Total points: ").append(totalPoints()).append(" sur 800").append("\n")
                .append("Moyenne: ").append(calculerMoyenne()).append(" sur 100").append("\n")
                .append("Mention: ").append(determinerStatut()).append("\n");
    
        return stringBuilder.toString();
    }
    
}
