// Personne.java

import java.util.Random;

public class Personne {
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String numeroTelephone;

    public Personne(String nom, String prenom, String dateNaissance,String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = genererNumeroTelephone();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
  // Méthode pour générer un numéro de téléphone aléatoire
    private String genererNumeroTelephone() {
        Random random = new Random();
         // Générez les deux premiers chiffres du reste du numéro (3 ou 4)
         int premierChiffre = 3 + random.nextInt(2); // 3 ou 4
         int deuxiemeChiffre = random.nextInt(10);   // n'importe quel chiffre de 0 à 9
  
        // Générez les chiffres aléatoires après le préfixe +509
        String chiffresAleatoires = premierChiffre + "" + deuxiemeChiffre+ String.format("%06d", random.nextInt(1000000));
        return "+509" + chiffresAleatoires;
    }
    @Override
    public String toString() {
        return "Nom: " + nom + "\n" +
               "Prénom: " + prenom + "\n" +
               "Date de naissance: " + dateNaissance + "\n" +
               "Numéro de téléphone: " + numeroTelephone + "\n";
    }
}
