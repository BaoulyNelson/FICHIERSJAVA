import java.util.Random;

class Bachelier {
    private String nom;
    private String prenom;
    private String numeroOrdre;
    private int age;
    private int numeroTelephone;
    public static String numeroRandom;
    public static String numeroRandomOrdre;

    public int noteMathematiques;
    public int notePhilosophie;
    public int noteSciencesSociales;
    public int[] notesAutresMatieres;

    public Bachelier(String nom, String prenom, String numeroOrdre, int age, int numeroTelephone) {
        Random random = new Random();
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = random.nextInt(90000000) + 10000000;
        numeroRandom= "+509" + Integer.toString(numeroTelephone);
        this.numeroOrdre = generateMatricule();
        this.age = age;
    }

   
      // Constructeur de la classe Bachelier
      public Bachelier(int noteMathematiques, int notePhilosophie, int noteSciencesSociales, int[] notesAutresMatieres) {
        // Initialisez les autres attributs ici
        this.noteMathematiques = noteMathematiques;
        this.notePhilosophie = notePhilosophie;
        this.noteSciencesSociales = noteSciencesSociales;
        
        // Initialisez le tableau des notes des autres matières
        this.notesAutresMatieres= notesAutresMatieres;
    }
    // Méthode pour générer la matricule aléatoire
    public static String generateMatricule() {
        Random random = new Random();
        String matricule="030000";
        for (int i = 0; i < 4; i++) {
            matricule += random.nextInt(10);
        }
        return matricule;
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
     * @return the numeroOrdre
     */
    public String getNumeroOrdre() {
        return numeroOrdre;
    }

    /**
     * @param numeroOrdre the numeroOrdre to set
     */
    public void setNumeroOrdre(String numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }

    /**
     * @return the dateNaissance
     */
    public int getAge() {
        return age;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the numeroTelephone
     */
    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    /**
     * @param numeroTelephone the numeroTelephone to set
     */
    public void setNumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    /**
     * @return the numeroRandom
     */
    public static String getNumeroRandom() {
        return numeroRandom;
    }

    /**
     * @param numeroRandom the numeroRandom to set
     */
    public static void setNumeroRandom(String numeroRandom) {
        Bachelier.numeroRandom = numeroRandom;
    }

    /**
     * @return the noteMathematiques
     */
    public int getNoteMathematiques() {
        return noteMathematiques;
    }

    /**
     * @param noteMathematiques the noteMathematiques to set
     */
    public void setNoteMathematiques(int noteMathematiques) {
        this.noteMathematiques = noteMathematiques;
    }

    /**
     * @return the notePhilosophie
     */
    public int getNotePhilosophie() {
        return notePhilosophie;
    }

    /**
     * @param notePhilosophie the notePhilosophie to set
     */
    public void setNotePhilosophie(int notePhilosophie) {
        this.notePhilosophie = notePhilosophie;
    }

    /**
     * @return the noteSciencesSociales
     */
    public int getNoteSciencesSociales() {
        return noteSciencesSociales;
    }

    /**
     * @param noteSciencesSociales the noteSciencesSociales to set
     */
    public void setNoteSciencesSociales(int noteSciencesSociales) {
        this.noteSciencesSociales = noteSciencesSociales;
    }

    /**
     * @return the notesAutresMatieres
     */
    public int [] getNotesAutresMatieres() {
        return notesAutresMatieres;
    }

    /**
     * @param notesAutresMatieres the notesAutresMatieres to set
     */
    public void setNotesAutresMatieres(int []notesAutresMatieres) {
        this.notesAutresMatieres = notesAutresMatieres;
    }

  
}
