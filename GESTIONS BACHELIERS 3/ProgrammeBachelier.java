import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgrammeBachelier {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Bachelier> bacheliers = new ArrayList<>();
    Bachelier bachelier = new Bachelier(null, null, 0);

    public void inscrireBachelier() {
        System.out.print("Entrez le nom du bachelier : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prenom du bachelier : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez l'age du bachelier : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nombre

        Bachelier bachelier = new Bachelier(nom, prenom, age);
        // Générer un numéro d'ordre aléatoire

        bacheliers.add(bachelier);
        System.out.println("Bachelier inscrit avec succes !");
        System.out.println("Matricule : " + bachelier.getMatricule());
        // System.out.println("Numero de telephone : " +
        // bachelier.getNumeroTelephone());
    }

    public Bachelier trouverBachelierEtVerifierInformations(String matricule) {
        for (Bachelier bachelier : bacheliers) {
            if (bachelier.getMatricule().equalsIgnoreCase(matricule)) {
                return bachelier;
            }
        }
        return null; // Aucun bachelier trouvé avec ce matricule
    }

    public void enregistrerNotes() {
        System.out.println("Enregistrement des notes :");
        System.out.print("Entrez la matricule du bachelier : ");
        String matricule = scanner.nextLine();
        // Recherche du bachelier par matricule
        Bachelier bachelier = trouverBachelierEtVerifierInformations(matricule);
        if (bachelier != null) {
            // Demande à l'utilisateur d'entrer les notes pour les 3 premières matières sur
            // 400 points chacune.
            for (int i = 0; i <= 9; i++) {
                System.out.print("Entrez la note pour la matière " + (i + 1) + " : ");
                int note = scanner.nextInt();
                bachelier.enregistrerNote(i, note);
            }
            System.out.println("Notes enregistrees avec succès !");
        } else {
            System.out.println("Aucun bachelier trouvé avec cette matricule.");
        }
    }

    public static boolean estEmailValide(String email) {
        // Définir un motif regex pour valider l'email
        String motif = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compiler le motif en une instance Pattern
        Pattern pattern = Pattern.compile(motif);

        // Créer un objet Matcher pour le texte donné
        Matcher matcher = pattern.matcher(email);

        // Vérifier si le motif correspond à l'email
        return matcher.matches();
    }
// Méthode pour enregistrer le résultat d'un bachelier dans un fichier
public void enregistrerResultat(Bachelier bachelier) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("resultats.txt", true))) {
        writer.write("le/la candidat.e " + bachelier.getNom().toUpperCase() + " " + bachelier.getPrenom()
                + ", identifié.e au numéro d'ordre " + bachelier.getMatricule()
                + "\nà la session unique des examens du bac :\n\n");
        writer.write("Matricule...: " + bachelier.getMatricule() + "\n");
        writer.write("Nom.........: " + bachelier.getNom() + "\n");
        writer.write("Prenom......: " + bachelier.getPrenom() + "\n");
        writer.write("Telephone...: " + bachelier.getNumeroTelephone() + "\n");
        writer.write("Age.........: " + bachelier.getAge() + " ans\n");
        String notesText = bachelier.lireNotes();
        writer.write(notesText);
        writer.write("\n");
        int totalPoints = bachelier.calculerTotalPoints();
        double moyenne = bachelier.calculerMoyenne();
        writer.write("\tTotal : " +totalPoints + " points sur 2600\n");
        writer.write("\tMoyenne : " + moyenne + " sur 10\n");
        writer.write("\tMention : " + determinerStatut(bachelier) + "\n");
        
        writer.write("\n");
    } catch (IOException e) {
        e.printStackTrace();
    }
}



public void afficherStatutBachelier() {
    scanner.nextLine();
    System.out.print("Entrez la matricule du bachelier : ");
    String matricule = scanner.nextLine();
    // Recherche du bachelier par matricule, nom et prénom
    Bachelier bachelier = trouverBachelierEtVerifierInformations(matricule);

    if (bachelier != null) {
        String statut = determinerStatut(bachelier);

        if (statut.equalsIgnoreCase("admis") || statut.equalsIgnoreCase("ajourne")
                || statut.equalsIgnoreCase("echoue")) {
            // Demander l'e-mail si le bachelier
            System.out.print("Entrez votre e-mail pour recevoir le résultat : ");
            String email = scanner.nextLine();
            while (!estEmailValide(email)) {
                System.out.print("L'email n'est pas valide. Re-essayer svp! : ");
                email = scanner.nextLine();
            }
            enregistrerResultat(bachelier);
            System.out.println("Veuillez consulter le résultat dans le fichier texte.");
        }
    } else {
        System.out.println("Aucun bachelier trouvé avec cette matricule.");
    }
}

// Méthode pour déterminer le statut
public String determinerStatut(Bachelier bachelier) {
    double totalPoints = bachelier.calculerTotalPoints();
    if (totalPoints >= 1300) {
        return "admis";
    } else if (totalPoints >= 1100 && totalPoints < 1300) {
        return "ajourne";
    } else {
        return "echoue";
    }
}

}
