import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionBacheliers {
    private static ArrayList<Bachelier> bacheliers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void inscrireBachelier() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Age : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        // Génération du numéro de téléphone aléatoire commençant par 509
        String numeroTelephone = "+509" + String.format("%07d", random.nextInt(34623000));
        String matricule = "030000" + String.format("%05d", random.nextInt(3674));

        Bachelier bachelier = new Bachelier(matricule, nom, prenom, numeroTelephone, age);

        // Ajout des matières et de leurs points maximums
        bachelier.ajouterMatiere(new Matiere("Mathématiques", 400));
        bachelier.ajouterMatiere(new Matiere("Philosophie", 400));
        bachelier.ajouterMatiere(new Matiere("Sciences Sociales", 400));
        bachelier.ajouterMatiere(new Matiere("Créole", 200));
        bachelier.ajouterMatiere(new Matiere("Physique", 200));
        bachelier.ajouterMatiere(new Matiere("Chimie", 200));
        bachelier.ajouterMatiere(new Matiere("Anglais", 200));
        bachelier.ajouterMatiere(new Matiere("Espagnol", 200));
        bachelier.ajouterMatiere(new Matiere("Biologie", 200));
        bachelier.ajouterMatiere(new Matiere("Économie", 200));

        bacheliers.add(bachelier);
        System.out.println("Voici la matricule : " + matricule);
        System.out.println("Bachelier inscrit avec succès.");
    }

    public static void enregistrerNotes() {
        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();
        Bachelier bachelier = trouverBachelier(matricule);

        if (bachelier != null) {
            ArrayList<Matiere> matieres = bachelier.getMatieres();

            if (matieres.isEmpty()) {
                System.out.println("Aucune matière à enregistrer.");
            } else {
                for (Matiere matiere : matieres) {
                    System.out.print("Note pour " + matiere.getNom() + " (sur " + matiere.getPointsMax() + ") : ");
                    int note = scanner.nextInt();
                    bachelier.ajouterNote(note);
                }
                System.out.println("Notes enregistrées avec succès.");
            }
        } else {
            System.out.println("Bachelier non trouvé.");
        }
    }

    public static Bachelier trouverBachelier(String matricule) {
        for (Bachelier bachelier : bacheliers) {
            if (bachelier.getMatricule().equals(matricule)) {
                return bachelier;
            }
        }
        return null; // Retourne null si le bachelier n'est pas trouvé
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

    public static void afficherStatut() {
        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();
        Bachelier bachelier = trouverBachelier(matricule);
        scanner.nextLine();

        if (bachelier != null) {
            System.out.print("Entrez votre adresse e-mail pour recevoir le résultat : ");
            String email = scanner.nextLine();
            while (!estEmailValide(email)) {
                System.out.print("L'email n'est pas valide. Réessayez : ");
                email = scanner.nextLine();
            }

            System.out.println("Statut envoyé à " + email + " et enregistré dans le fichier texte.");
            enregistrerResultat(bachelier);
        } else {
            System.out.println("Aucun bachelier trouvé avec ce matricule.");
        }
    }

    public static void enregistrerResultat(Bachelier bachelier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resultats.txt", true))) {
            writer.newLine();
            writer.write("le/la candidat.e " + bachelier.getNom().toUpperCase() + " " + bachelier.getPrenom()
                    + ", identifié.e au numéro d'ordre " + bachelier.getMatricule()
                    + "\nà la session unique des examens du bac :\n\n");
            writer.write("Matricule...: " + bachelier.getMatricule() + "\n");
            writer.write("Nom.........: " + bachelier.getNom() + "\n");
            writer.write("Prenom......: " + bachelier.getPrenom() + "\n");
            writer.write("Telephone...: " + bachelier.getNumeroTelephone() + "\n");
            writer.write("Age.........: " + bachelier.getAge() + " ans\n");

            writer.write("Matières et notes:\n");
            for (int i = 0; i < bachelier.getMatieres().size(); i++) {
                Matiere matiere = bachelier.getMatieres().get(i);
                int note = bachelier.getNotes().get(i);

                writer.write("\tMatière: " + matiere.getNom() + "\n");
                writer.write("\tNote...: " + note + " (sur " + matiere.getPointsMax() + ")\n\n");
            }
            writer.write("\tTotal......: " + bachelier.calculerTotalPoints() + " points sur 2600\n");
            writer.write("\tMoyenne....: " + bachelier.calculerMoyenne() + " sur 10\n");
            writer.write("\tStatut.....: " + bachelier.determinerStatut());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
