import java.text.SimpleDateFormat;
import java.util.Date;

public class FicheEmprunt {

    private Date dateEmprunt;
    private Date dateLimite;
    private Date dateRappel;

    public FicheEmprunt(Date dateEmprunt, Date dateLimite, Date dateRappel) {
        this.dateEmprunt = dateEmprunt;
        this.dateLimite = dateLimite;
        this.dateRappel = dateRappel;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Date getDateRappel() {
        return dateRappel;
    }

    public void setDateRappel(Date dateRappel) {
        this.dateRappel = dateRappel;
    }
// Méthode pour calculer le tarif
public float calculerTarif() {
    // Ajoutez la logique pour calculer le tarif en fonction des dates d'emprunt et de retour
    return 0.0f; // Remplacez 0.0f par le calcul réel du tarif
}

// Méthode pour vérifier si l'emprunt est en retard
public boolean estEnRetard() {
    if (dateRappel != null) {
        return true; // Si la date de rappel est définie, l'emprunt est en retard
    } else {
        Date dateActuelle = new Date();
        return dateActuelle.after(dateLimite);
    }
}

    // Méthode pour obtenir la représentation sous forme de chaîne de caractères de la fiche d'emprunt
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Date d'emprunt: ").append(dateFormat.format(dateEmprunt)).append("\n");
        stringBuilder.append("Date limite: ").append(dateFormat.format(dateLimite)).append("\n");
        stringBuilder.append("Date de rappel: ").append(dateFormat.format(dateRappel)).append("\n");

        return stringBuilder.toString();
    }
}
