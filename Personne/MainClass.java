
public class MainClass {
    public static void main(String[] args) {
        System.out.println();

        while (true) {
            
        
        // Créer une instance de Personne
        Personne personne = new Personne("", "", "", "", "", "", false);

        // Créer une instance de GestionPersonne
        GestionPersonne gestionPersonne = new GestionPersonne();

        // Appeler la méthode enregistrerPersonne avec l'instance de Personne
        gestionPersonne.enregistrerPersonne(personne);

        // Appeler la méthode afficherInformationsPersonne avec l'instance de Personne
        //gestionPersonne.afficherInformationsPersonne();
        gestionPersonne.rechercherPersonne();

    }
}
}
