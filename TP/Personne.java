import java.util.Scanner;

public class Personne {
    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void presenteToi() {
        System.out.println("Je m'appelle " + prenom + " " + nom + ".");
        System.out.println("J'ai " + age + " ans.");
    }

    public String quelEstTonNom() {
        return nom;
    }

    public int quelEstTonAge() {
        return age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // b. Saisie des informations de la personne
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez votre âge : ");
        int age = scanner.nextInt();

        // Consommer la nouvelle ligne restante dans le buffer
        scanner.nextLine();

        // Création de l'objet Personne
        Personne untel = new Personne(nom, prenom, age);

        // b. Affichage des caractéristiques de la personne
        untel.presenteToi();

        // e. Affichage du nom et de l'âge d'Untel
        System.out.println("Nom : " + untel.quelEstTonNom());
        System.out.println("Âge : " + untel.quelEstTonAge());

        scanner.close();
    }
}
