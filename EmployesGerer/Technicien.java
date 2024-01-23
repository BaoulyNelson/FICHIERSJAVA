import java.util.Random;

public class Technicien extends Employe {
    private boolean diplome;
    private int anneesExperience;

    public Technicien(String nom, String prenom, String sexe, String poste, int nombreHeures, double prixParHeure,
            boolean diplome, int anneesExperience) {
        super(genererCode(), nom, prenom, sexe, poste, nombreHeures, prixParHeure);
        this.diplome = diplome;
        this.anneesExperience = anneesExperience;
    }

    private static String genererCode() {
        // Générer un code aléatoire par exemple
        Random random = new Random();
        return "TECH-" + random.nextInt(1000);
    }

    public boolean isDiplome() {
        return diplome;
    }

    public int getAnneesExperience() {
        return anneesExperience;
    }

    public void setDiplome(boolean diplome) {
        this.diplome = diplome;
    }

    public void setAnneesExperience(int anneesExperience) {
        this.anneesExperience = anneesExperience;
    }

    // Méthode pour calculer le salaire augmenté du technicien
    public double calculerSalaireAugmenteTechnicien() {
        double salaireBrut = calculerSalaireBrut();
        double tauxAugmentation = (isDiplome() && getAnneesExperience() >= 5) ? 0.08 : 0.0;
        return salaireBrut * (1 + tauxAugmentation);
    }

    public double montantAjouterTechnicien() {
        double salaireAugmente = calculerSalaireAugmenteTechnicien();
        double salaireBrut = calculerSalaireBrut();
        double montantAjoute = salaireAugmente - salaireBrut;
        return montantAjoute;
    }

    public double calculerSalaireNetTechnicien() {
        double salaireBrutAugmente = calculerSalaireAugmenteTechnicien();
        double deductionFixe = 50.0; // Exemple de déduction fixe
        double salaireNet = salaireBrutAugmente - deductionFixe;
        return salaireNet;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append("Années d'expérience: ").append(anneesExperience).append(" ans\n");
        result.append("Diplôme: ").append(diplome ? "Oui" : "Non").append("\n");
        result.append("Salaire Brut du technicien est: ").append(calculerSalaireBrut()).append(" Gourdes\n");
        result.append("l'augmentation salariale: ").append(calculerSalaireAugmenteTechnicien()).append(" Gourdes\n");
        result.append("on a ajoute: ").append(montantAjouterTechnicien()).append(" Gourdes\n");
        result.append("une cotisation fixe (50 Gourdes) sur tous les techniciens\n");
        result.append("le salaire net du technicien est: ").append(calculerSalaireNetTechnicien()).append(" Gourdes\n");

        return result.toString();
    }

}
