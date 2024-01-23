import java.util.ArrayList;
import java.util.List;

public class Pharmacie {
    private List<Medicament> medicaments;

    public Pharmacie() {
        medicaments = new ArrayList<>();
    }

    public void ajouterMedicament(Medicament medicament) {
        medicaments.add(medicament);
    }
    public void afficherTousMedicaments() {
        if (!medicaments.isEmpty()) {
            System.out.println("Liste des médicaments dans la pharmacie :");
            for (Medicament medicament : medicaments) {
                System.out.println("Id : " + medicament.getId());
                System.out.println("Catégorie : " + medicament.getCategorie());
                System.out.println("Nom : " + medicament.getNom());
                System.out.println("Prix : " + medicament.getPrix());
                System.out.println("Quantité : " + medicament.getQuantite());
                System.out.println("Date d'expiration : " + medicament.getDateExpiration());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("Aucun médicament dans la pharmacie.");
        }
    }
    

    public boolean rechercherMedicamentParNom(String nom) {
        for (Medicament medicament : medicaments) {
            if (medicament.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    // Autres méthodes à implémenter :
    // - augmenterQuantiteMedicament
    public void augmenterQuantiteMedicament(String nom, int quantiteAjoutee) {
        for (Medicament medicament : medicaments) {
            if (medicament.getNom().equalsIgnoreCase(nom)) {
                int nouvelleQuantite = medicament.getQuantite() + quantiteAjoutee;
                medicament.setQuantite(nouvelleQuantite);
                System.out.println("Quantité du médicament mise à jour.");
                return;
            }
        }
        System.out.println("Le médicament n'existe pas dans la pharmacie.");
    }
    
    // - augmenterPrixMedicament
    public void augmenterPrixMedicament(String nom, double montantAjoute) {
        for (Medicament medicament : medicaments) {
            if (medicament.getNom().equalsIgnoreCase(nom)) {
                double nouveauPrix = medicament.getPrix() + montantAjoute;
                medicament.setPrix(nouveauPrix);
                System.out.println("Prix du médicament mis à jour.");
                return;
            }
        }
        System.out.println("Le médicament n'existe pas dans la pharmacie.");
    }
    
    // - supprimerMedicamentParNom
    public void supprimerMedicamentParNom(String nom) {
        for (Medicament medicament : medicaments) {
            if (medicament.getNom().equalsIgnoreCase(nom)) {
                medicaments.remove(medicament);
                System.out.println("Médicament supprimé : " + medicament.getNom());
                return;
            }
        }
        System.out.println("Le médicament n'existe pas dans la pharmacie.");
    }
    
    // - supprimerMedicamentParCode
    public void supprimerMedicamentParCode(int code) {
        Medicament medicamentASupprimer = null;
        for (Medicament medicament : medicaments) {
            if (medicament.getId() == code) {
                medicamentASupprimer = medicament;
                break;
            }
        }
        if (medicamentASupprimer != null) {
            medicaments.remove(medicamentASupprimer);
            System.out.println("Médicament supprimé : " + medicamentASupprimer.getNom());
        } else {
            System.out.println("Le médicament n'existe pas dans la pharmacie.");
        }
    }
    
    // - afficherPremierMedicament
    public void afficherPremierMedicament() {
        if (!medicaments.isEmpty()) {
            Medicament premierMedicament = medicaments.get(0);
            System.out.println("Premier médicament : " + premierMedicament.getId()+" "+ premierMedicament.getNom());
        } else {
            System.out.println("Aucun médicament dans la pharmacie.");
        }
    }
    
    // - afficherDernierMedicament
    public void afficherDernierMedicament() {
        if (!medicaments.isEmpty()) {
            Medicament dernierMedicament = medicaments.get(medicaments.size() - 1);
            System.out.println("Dernier médicament : " + dernierMedicament.getId()+" "+ dernierMedicament.getNom());
        } else {
            System.out.println("Aucun médicament dans la pharmacie.");
        }
    }
    
    // - afficherPositionMedicamentParNom
    public void afficherPositionMedicamentParNom(String nom) {
        for (int i = 0; i < medicaments.size(); i++) {
            Medicament medicament = medicaments.get(i);
            if (medicament.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Le médicament " + nom + " se trouve à la position " + (i + 1) + " dans la pharmacie.");
                return;
            }
        }
        System.out.println("Le médicament n'existe pas dans la pharmacie.");
    }
    
    // - afficherMedicamentAvantEtApres
    public void afficherMedicamentAvantEtApres(String nom) {
        int index = -1;
        for (int i = 0; i < medicaments.size(); i++) {
            Medicament medicament = medicaments.get(i);
            if (medicament.getNom().equalsIgnoreCase(nom)) {
                index = i;
                break;
            }
        }
    
        if (index != -1) {
            if (index > 0) {
                Medicament medicamentAvant = medicaments.get(index - 1);
                System.out.println("Médicament avant " + nom + " : " + medicamentAvant.getNom());
            } else {
                System.out.println("Pas de médicament avant " + nom + ".");
            }
    
            if (index < medicaments.size() - 1) {
                Medicament medicamentApres = medicaments.get(index + 1);
                System.out.println("Médicament après " + nom + " : " + medicamentApres.getNom());
            } else {
                System.out.println("Pas de médicament après " + nom + ".");
            }
        } else {
            System.out.println("Le médicament n'existe pas dans la pharmacie.");
        }
    }
    
}
