public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private String dateInscription;
    private String dateRenouvellement;
    private CategorieClient categorie;
    private boolean bloque;
    
    public Client(String nom, String prenom, String adresse, String dateInscription, String dateRenouvellement,
            CategorieClient categorie, boolean bloque) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateInscription = dateInscription;
        this.dateRenouvellement = dateRenouvellement;
        this.categorie = categorie;
        this.bloque = bloque;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getDateRenouvellement() {
        return dateRenouvellement;
    }

    public void setDateRenouvellement(String dateRenouvellement) {
        this.dateRenouvellement = dateRenouvellement;
    }

    public CategorieClient getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieClient categorie) {
        this.categorie = categorie;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }
// Méthode pour bloquer ou débloquer un client
public void bloquerDebloquerClient(boolean bloquer) {
    this.bloque = bloquer;
}

// Méthode pour autoriser ou interdire un client à emprunter
public void pouvoirEmprunter(boolean peutEmprunter) {
    this.categorie.setNbEmpruntsMax(peutEmprunter ? 5 : 0);
}

// Méthode pour changer l'adresse d'un client
public void changerAdresse(String nouvelleAdresse) {
    this.adresse = nouvelleAdresse;
}


    // Méthode pour obtenir la représentation sous forme de chaîne de caractères du client
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Nom: ").append(nom).append("\n");
        stringBuilder.append("Prénom: ").append(prenom).append("\n");
        stringBuilder.append("Adresse: ").append(adresse).append("\n");
        stringBuilder.append("Date d'inscription: ").append(dateInscription).append("\n");
        stringBuilder.append("Date de renouvellement: ").append(dateRenouvellement).append("\n");
        stringBuilder.append("Catégorie: ").append(categorie).append("\n");
        stringBuilder.append("Bloqué: ").append(bloque).append("\n");

        return stringBuilder.toString();
    }
}
