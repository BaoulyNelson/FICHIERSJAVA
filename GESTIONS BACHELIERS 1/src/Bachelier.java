import java.util.Random;

class Bachelier {
    private String matricule;
    private String nom;
    private String prenom;
    private int age;
    private String numeroTelephone;

    public Bachelier(String nom, String prenom,int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age=age;
        this.matricule = generateMatricule();
        this.numeroTelephone = generateNumeroTelephone();
    }

    // Générer aléatoirement un numéro de téléphone commençant par 509
    public String generateNumeroTelephone() {
        Random rand = new Random();
        int randomSuffix = rand.nextInt(90000000) + 10000000; // Génère un numéro à 8 chiffres
        return "+509" + randomSuffix;
    }

     // Méthode pour générer la matricule aléatoire
     public String generateMatricule() {
        Random random = new Random();
        String matricule="030000";
        for (int i = 0; i < 4; i++) {
            matricule += random.nextInt(10);
        }
        return matricule;
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
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

}

