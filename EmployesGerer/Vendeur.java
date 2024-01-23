import java.util.Random;

public class Vendeur extends Employe {
    private int anneesExperience;

    public Vendeur(String nom, String prenom, String sexe, int nombreHeures, double prixParHeure, String poste,
            int anneesExperience) {
        super(genererCode(), nom, prenom, sexe, poste, nombreHeures, prixParHeure);
        this.anneesExperience = anneesExperience;
    }

    private static String genererCode() {
        // Générer un code aléatoire par exemple
        Random random = new Random();
        return "VEND-" + random.nextInt(1000);
    }

    public int getAnneesExperience() {
        return anneesExperience;
    }

    public void setAnneesExperience(int anneesExperience) {
        this.anneesExperience = anneesExperience;
    }

    public double calculerSalaireAugmenteVendeur() {
        double salaireBrut = calculerSalaireBrut();
        double tauxAugmentation = (getAnneesExperience() < 5) ? 0.06 : 0.075;
        return salaireBrut * (1 + tauxAugmentation);
    }

    public double montantAjouterVendeur() {
        double salaireAugmente = calculerSalaireAugmenteVendeur();
        double salaireBrut = calculerSalaireBrut();
        double montantAjoute = salaireAugmente - salaireBrut;
        return montantAjoute;
    }

    public double calculerSalaireNetVendeur() {
        double salaireBrutAugmente = calculerSalaireAugmenteVendeur();
        double deductionFixe = 50.0; // Exemple de déduction fixe
        double salaireNet = salaireBrutAugmente - deductionFixe;
        return salaireNet;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append("Années d'expérience: ").append(anneesExperience).append(" ans\n");
        result.append("Salaire Brut du vendeur est: ").append(calculerSalaireBrut()).append(" Gourdes\n");
        result.append("l'augmentation salariale: ").append(calculerSalaireAugmenteVendeur()).append(" Gourdes\n");
        result.append("on a ajoute: ").append(montantAjouterVendeur()).append(" Gourdes\n");
        result.append("une cotisation fixe (50 Gourdes) sur tous les vendeurs\n");
        result.append("le salaire net du vendeur est: ").append(calculerSalaireNetVendeur()).append(" Gourdes\n");

        return result.toString();
    }

}