import java.util.Random;

public class ProgrammationCandidat extends Candidat {
    private int noteMiniProgramme;
    private int noteQuestion1;
    private int noteQuestion2;
    private int noteQuestion3;

    public ProgrammationCandidat(String nomComplet, String sexe, int noteMiniProgramme,
            int noteQuestion1, int noteQuestion2, int noteQuestion3) {
        super(nomComplet, sexe);
        this.noteMiniProgramme = noteMiniProgramme;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
        this.noteQuestion3 = noteQuestion3;
    }

    // Getters et setters pour les notes

    @Override
    protected String genererCode() {
        Random random = new Random();
        String alphabet = "PRO-";
        int nombreAleatoire = random.nextInt(1999);
        return alphabet + nombreAleatoire;
    }

    @Override
    public double calculerMoyenne() {
        // Calcul de la moyenne spécifique pour les candidats en programmation
        return ((noteMiniProgramme + noteQuestion1 + noteQuestion2 + noteQuestion3) / 1000.0)*100;
    }

    private int totalPoints() {
        return noteMiniProgramme + noteQuestion1 + noteQuestion2 + noteQuestion3;
    }


    @Override
    public String toString() {
        // Utilisation de StringBuilder pour construire la chaîne de caractères de manière efficace
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        
        stringBuilder.append("\nNote Mini Programme: ").append(noteMiniProgramme)
            .append("\nNote Question 1: ").append(noteQuestion1)
            .append("\nNote Question 2: ").append(noteQuestion2)
            .append("\nNote Question 3: ").append(noteQuestion3)
            .append("\nTotal points: ").append(totalPoints()).append(" sur 1000 points")
            .append("\nMoyenne: ").append(calculerMoyenne()).append(" sur 100")
            .append("\nMention: ").append(determinerStatut()).append("\n");

        return stringBuilder.toString();
    }
}
