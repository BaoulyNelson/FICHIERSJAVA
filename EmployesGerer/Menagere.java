import java.util.Random;

public class Menagere extends Employe {

    public Menagere(String nom, String prenom, String sexe, String poste, int nombreHeures, double prixParHeure) {
        super(genererCode(), nom, prenom, sexe, poste, nombreHeures, prixParHeure);
    }

    private static String genererCode() {
        // Générer un code aléatoire par exemple
        Random random = new Random();
        return "MEN-" + random.nextInt(1000);
    }

    // Méthode pour calculer le salaire net de la ménagère
    public double calculerSalaireAugementeMenagere() {
        double salaireBrut = calculerSalaireBrut();
        double tauxAugmentation = 0.03;
        double salaireAugmente = salaireBrut * (1 + tauxAugmentation);
        return salaireAugmente;
    }

    public double montantAjouterMenagere() {
        double salaireAugmente = calculerSalaireAugementeMenagere();
        double salaireBrut = calculerSalaireBrut();
        double montantAjoute = salaireAugmente - salaireBrut;
        return montantAjoute;
    }

    public double calculerSalaireNetMenagere() {
        double salaireBrutAugmente = calculerSalaireAugementeMenagere();
        double deductionFixe = 50.0; // Exemple de déduction fixe
        double salaireNet = salaireBrutAugmente - deductionFixe;
        return salaireNet;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append("Salaire Brut du menagere est: ").append(calculerSalaireBrut()).append(" Gourdes\n");
        result.append("l'augmentation salariale est: ").append(calculerSalaireAugementeMenagere()).append(" Gourdes\n");
        result.append("on a ajoute: ").append(montantAjouterMenagere()).append(" Gourdes\n");
        result.append("une cotisation fixe (50 Gourdes) sur tous les menageres\n");
        result.append("le salaire net du menagere est: ").append(calculerSalaireNetMenagere()).append(" Gourdes\n");

        return result.toString();
    }

}
