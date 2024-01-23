import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NomsAleatoires {
    public static void main(String[] args) {
        // Créer une liste de noms
        List<String> listeNoms = new ArrayList<>();
        listeNoms.add("Antoinette");
        listeNoms.add("Bazelais");
        listeNoms.add("Benito");
        listeNoms.add("Baouly");
        listeNoms.add("Antonia");
        listeNoms.add("Antony");
        listeNoms.add("Eva");

        // Mélanger la liste de manière aléatoire
        Collections.shuffle(listeNoms);
        Collections.reverse(listeNoms);
        Collections.reverseOrder();

        // Afficher les noms mélangés
        System.out.println("Noms mélangés de manière aléatoire :");
        for (String nom : listeNoms) {
            System.out.println(nom);
        }
    }
}
