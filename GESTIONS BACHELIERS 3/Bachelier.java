import java.util.Random;

public class Bachelier {
    //ProgrammeBachelier programmeBachelier=new ProgrammeBachelier();
    private String matricule;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private int age;
    private int[] notes; // Tableau pour stocker les notes des matières

    public Bachelier( String nom, String prenom,int age) {
        this.matricule =generateMatricule();
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone =generateNumeroTelephone();
        this.age=age;
        this.notes = new int[10]; // 10 matières
    }

    // Méthode pour enregistrer les notes d'une matière
    public void enregistrerNote(int matiereIndex, int note) {
        notes[matiereIndex] = note;
    }

    public String lireNotes() {
        StringBuilder notesText = new StringBuilder();
        for (int i = 0; i < notes.length; i++) {
            notesText.append("Matiere ").append(i + 1).append("...:").append(notes[i]).append("\n");
        }
        return notesText.toString();
    }
    
   // Méthode pour calculer la moyenne
   public double calculerMoyenne() {
    // Calcul du total des points pour chaque matière
    int totalPoints = notes[0] + notes[1] + notes[2] + notes[3] + notes[4] + notes[5] + notes[6] + notes[7] + notes[8] + notes[9];

    // Calcul de la moyenne pondérée
    double moyenne = (notes[0] / 400.0) * 400 + (notes[1] / 400.0) * 400 + (notes[2] / 400.0) * 400
            + (notes[3] / 200.0) * 200 + (notes[4] / 200.0) * 200 + (notes[5] / 200.0) * 200
            + (notes[6] / 200.0) * 200 + (notes[7] / 200.0) * 200 + (notes[8] / 200.0) * 200 + (notes[9] / 200.0) * 200;

    // La moyenne est le total des points divisé par 2600 et multiplié par 10 pour obtenir une échelle de 0 à 10
    return (moyenne / 2600.0) * 10;
}


public int calculerTotalPoints() {
    int totalPoints = 0;
    for (int note : notes) {
        totalPoints += note;
    }
    return totalPoints;
}

        // Méthode pour générer le numéro de téléphone aléatoire
        public static String generateNumeroTelephone() {
            Random random = new Random();
            String numero = "+509";
            for (int i = 0; i < 8; i++) {
                numero += random.nextInt(10);
            }
            return numero;
        }
    
         // Méthode pour générer le numéro de téléphone aléatoire
         public static String generateMatricule() {
            Random random = new Random();
            String matricule="030000";
            for (int i = 0; i < 4; i++) {
                matricule += random.nextInt(10);
            }
            return matricule;
        }
    

    /**
     * @return the matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricule to set
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the numeroTelephone
     */
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    /**
     * @param numeroTelephone the numeroTelephone to set
     */
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    /**
     * @return the notes
     */
    public int[] getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(int[] notes) {
        this.notes = notes;
    }
     /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

}
