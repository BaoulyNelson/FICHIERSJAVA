
public interface GestionCompagnieVoitures {
    void enregistrerVoiture(Voiture voiture);
    void afficherToutesVoitures();
    Voiture rechercherVoitureParCode(String numero);
    void modifierPrixVoiture(String numero, double nouveauPrix);
    void supprimerVoitureParCode(String numero);
}
