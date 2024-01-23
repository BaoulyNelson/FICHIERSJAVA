import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammeBac {
    ArrayList<Bachelier> bacheliers = new ArrayList<>();
    ArrayList<ExamenBac> notesBac = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Méthode pour inscrire un bachelier
    public void inscrireBachelier(Scanner scanner, ArrayList<Bachelier> bacheliers) {
        System.out.print("Nom du bachelier : ");
        String nom = scanner.next();
        System.out.print("Prenom du bachelier : ");
        String prenom = scanner.next();
        System.out.print("Age du bachelier : ");
        int age = scanner.nextInt();
        Bachelier bachelier = new Bachelier(nom, prenom, age);
        // Utilisez directement l'objet bachelier pour afficher le matricule
        System.out.println("Matricule du bachelier : " + bachelier.getMatricule());
        bacheliers.add(bachelier);// System.out.println("Bachelier inscrit avec succes !");
        EnregistrementDonnees.sauvegarderDonneesBacheliers(bachelier.getMatricule(), nom, prenom, age,bachelier.getNumeroTelephone());
    }

    // Méthode pour enregistrer les notes du baccalauréat
    public void enregistrerNotesBac(Scanner scanner, ArrayList<Bachelier> bacheliers, ArrayList<ExamenBac> notesBac) {
        System.out.print("Matricule du bachelier : ");
        String matriculeRecherche = scanner.next();

        Bachelier bachelierTrouve = null;

        for (Bachelier bachelier : bacheliers) {
            if (bachelier.getMatricule().equals(matriculeRecherche)) {
                bachelierTrouve = bachelier;
                break;
            }
        }

        if (bachelierTrouve == null) {
            System.out.println("Aucun bachelier trouvé avec ce matricule.");
            return;
        }

        System.out.println(
                "Enregistrement des notes pour " + bachelierTrouve.getNom() + " " + bachelierTrouve.getPrenom() + " :");
        System.out.print("Mathématiques (sur 400 points) : ");
        int mathematiques = scanner.nextInt();
        System.out.print("Philosophie (sur 400 points) : ");
        int philosophie = scanner.nextInt();
        System.out.print("Sciences Sociales (sur 400 points) : ");
        int sciencesSociales = scanner.nextInt();

        int[] autresMatieres = new int[7];
        for (int i = 0; i < 7; i++) {
            System.out.print("Note " + (i + 1) + " (sur 200 points) : ");
            autresMatieres[i] = scanner.nextInt();
        }

        ExamenBac examenBac = new ExamenBac(mathematiques, philosophie, sciencesSociales, autresMatieres);
        notesBac.add(examenBac);
        EnregistrementDonnees.sauvegarderDonneesExamenBac(matriculeRecherche, mathematiques, philosophie,
                sciencesSociales, autresMatieres);
        // System.out.println("Notes du bachelier enregistrées avec succès !");
    }

    // Méthode pour calculer la moyenne et déterminer le statut du bachelier
    public void calculerMoyenneEtStatut(ArrayList<Bachelier> bacheliers, ArrayList<ExamenBac> notesBac) {

        System.out.print("Matricule du bachelier : ");
        String matriculeRecherche = scanner.next();

        Bachelier bachelierTrouve = null;
        ExamenBac examenBac = null;

        // Recherche du bachelier correspondant au matricule
        for (int i = 0; i < bacheliers.size(); i++) {
            Bachelier bachelier = bacheliers.get(i);
            if (bachelier.getMatricule().equals(matriculeRecherche)) {
                bachelierTrouve = bachelier;
                examenBac = notesBac.get(i);
                break;
            }
        }

        if (bachelierTrouve == null) {
            System.out.println("Aucun bachelier trouvé avec cette matricule.");
            return;
        }

        System.out.println("Resultat pour " + bachelierTrouve.getNom() + " " + bachelierTrouve.getPrenom() + ":");

        if (determinerStatut(examenBac).equalsIgnoreCase("Admis")
                || determinerStatut(examenBac).equalsIgnoreCase("Ajourne")
                || determinerStatut(examenBac).equalsIgnoreCase("echoue")) {
            System.out.print("Entrez votre e-mail pour recevoir le résultat : ");
            String email = scanner.next();
            while (!estEmailValide(email)) {
                System.out.print("L'email n'est pas valide.Re-essayer svp! ");
                email = scanner.next();
            }
            System.out.println("Resultat envoye a l'adresse e-mail : " + email);
        }

        // Création d'un fichier texte pour sauvegarder les informations
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resultats.txt", true))) {

            writer.write("le/la candidat.e " + bachelierTrouve.getNom().toUpperCase() + " "
                    + bachelierTrouve.getPrenom() + ", identifié.e au numéro d'ordre " + bachelierTrouve.getMatricule()
                    + "\nà la session unique des examens du bac :\n\n");
            writer.write("Matricule>>>>>>>>>: " + bachelierTrouve.getMatricule() + "\n");
            writer.write("Nom>>>>>>>>>>>>>>>: " + bachelierTrouve.getNom() + "\n");
            writer.write("Prenom>>>>>>>>>>>>: " + bachelierTrouve.getPrenom() + "\n");
            writer.write("Telephone>>>>>>>>>: " + bachelierTrouve.getNumeroTelephone() + "\n");
            writer.write("Age-->>>>>>>>>>>>>: " + bachelierTrouve.getAge() + " ans\n");
            writer.write("Mathématiques>>>>>: " + examenBac.getMathematiques() + "\n");
            writer.write("Philosophie>>>>>>>: " + examenBac.getPhilosophie() + "\n");
            writer.write("Sciences Sociales>: " + examenBac.getSciencesSociales() + "\n");
            String notesText = examenBac.lireNotes();
            writer.write(notesText);
            writer.newLine();
            writer.write("\tTotal : " + examenBac.getTotalPoints() + " points sur 2600 \n");
            writer.write("\tMoyenne : " + examenBac.calculerMoyenneSur10() + " sur 10\n");
            writer.write("\tMention : " + determinerStatut(examenBac) + "\n");
            writer.write("\n");
            EnregistrementDonnees.sauvegarderDonneesResultat(matriculeRecherche, examenBac.getTotalPoints(),
                    examenBac.calculerMoyenneSur10(), ProgrammeBac.determinerStatut(examenBac));
            // System.out.println("Informations sauvegardées dans le fichier ");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des informations.");
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

    private static String determinerStatut(ExamenBac examenBac) {
        int totalPoints = examenBac.getTotalPoints();
        if (totalPoints >= 1300) {
            return "Admis";
        } else if (totalPoints > 1100 && totalPoints < 1300) {
            return "Ajourne";
        } else {
            return "Echoue";
        }
    }

}
