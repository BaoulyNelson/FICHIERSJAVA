import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammeBacheliers {

    public static void inscrireBachelier(Scanner scanner, Map<String, Bachelier> bacheliers) {
        System.out.print("Entrez le nom du bachelier: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prénom du bachelier: ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez l'âge du bachelier: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nombre

        // Générer un numéro d'ordre aléatoire
        String numeroOrdre = Bachelier.generateMatricule();
        Bachelier bachelier = new Bachelier(nom, prenom, numeroOrdre, age, 0);
        bachelier.setNumeroOrdre(numeroOrdre);
        bacheliers.put(numeroOrdre, bachelier);
        System.out.println("voila le numero d'ordre "+numeroOrdre);


    }

    public static void enregistrerNotes(Scanner scanner, Map<String, Bachelier> bacheliers) {
        System.out.print("Entrez le numéro d'ordre du bachelier: ");
        String numeroOrdre = scanner.next();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nombre
    
        if (bacheliers.containsKey(numeroOrdre)) {
            Bachelier bachelier = bacheliers.get(numeroOrdre);
    
            System.out.print("Entrez la note en mathématiques (sur 400): ");
            int noteMathematiques = scanner.nextInt();
            
            System.out.print("Entrez la note en philosophie (sur 400): ");
            int notePhilosophie = scanner.nextInt();
    
            System.out.print("Entrez la note en science sociale (sur 400): ");
            int noteSciencesSociales = scanner.nextInt();
    
            int[] notesAutresMatieres = new int[7]; // Tableau pour les autres matières
            for (int i = 0; i < 7; i++) {
                System.out.print("Entrez la note en matière " + (i + 1) + " (sur 200): ");
                notesAutresMatieres[i] = scanner.nextInt();
            }
            scanner.nextLine();
    
            // Mettez à jour les notes du bachelier
            bachelier.setNoteMathematiques(noteMathematiques);
            bachelier.setNotePhilosophie(notePhilosophie);
            bachelier.setNoteSciencesSociales(noteSciencesSociales);
            bachelier.setNotesAutresMatieres(notesAutresMatieres);
    
            System.out.println("Notes enregistrées avec succès !");
        } else {
            System.out.println("Aucun bachelier trouvé avec le numéro d'ordre spécifié.");
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


    public static void verifierStatutBachelier(Scanner scanner, Map<String, Bachelier> bacheliers) {
        System.out.print("Entrez le numéro d'ordre du bachelier à vérifier:");
        String numeroOrdre = scanner.next();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nombre
    
        if (bacheliers.containsKey(numeroOrdre)) {
            Bachelier bachelier = bacheliers.get(numeroOrdre);
    
            int sommeNotes = bachelier.getNoteMathematiques() + bachelier.getNotePhilosophie() + bachelier.getNoteSciencesSociales();
    
            // Ajouter les notes des autres matières à la somme
            int[] notesAutresMatieres = bachelier.getNotesAutresMatieres();
            for (int i = 0; i < notesAutresMatieres.length; i++) {
                sommeNotes += notesAutresMatieres[i];
            }
    
            System.out.print("Entrez l'adresse e-mail pour recevoir le résultat: ");
            String email = scanner.nextLine();
            while (!estEmailValide(email)) {
                System.out.print("L'email n'est pas valide.Re-essayer svp!: ");
                email = scanner.next();
            }
            System.out.println("va voir le resultat de "+bachelier.getNom()+ " "+bachelier.getPrenom()+ " dans le fichier text cree");
    
            // Calcul de la moyenne en fonction du nombre total de matières
            double moyenne = (sommeNotes / 26)*0.1; // Si vous avez 10 matières au total
    
            // Vérification du statut
            String statut;
            if (sommeNotes >= 1100 && sommeNotes < 1300) {
                statut = "ajourne";
            } else if (sommeNotes >= 1300) {
                statut = "admis";
            } else {
                statut = "echoue";
            }
    
            // Enregistrement des résultats dans un fichier texte
            enregistrerResultatDansFichier(bachelier, sommeNotes, moyenne, statut);

        } else {
            System.out.println("Aucun bachelier trouvé avec le numéro d'ordre spécifié.");
        }
    } 


    public static void enregistrerResultatDansFichier(
        Bachelier bachelier, int sommeNotes, double moyenne, String statut) {
    try (FileWriter fileWriter = new FileWriter("resultats_bacheliers.txt", true);
         PrintWriter writer = new PrintWriter(fileWriter)) {
        writer.write("le/la candidat.e "+bachelier.getNom().toUpperCase() + " " + bachelier.getPrenom() + ", identifié.e au numéro d'ordre "+ bachelier.getNumeroOrdre()+ "\nà la session unique des examens du bac :\n\n");
        writer.println("Nom..............: " + bachelier.getNom());
        writer.println("Prenom...........: " + bachelier.getPrenom());
        writer.println("Numero d'ordre...: " + bachelier.getNumeroOrdre());
        writer.println("Age..............: " + bachelier.getAge()+" ans");
        
        writer.println("Notes pour Mathematiques....: " + bachelier.getNoteMathematiques());
        writer.println("Notes pour Philosophie......: " + bachelier.getNotePhilosophie());
        writer.println("Notes pour Sciences Sociales: " + bachelier.getNoteSciencesSociales());

        int[] notesAutresMatieres = bachelier.getNotesAutresMatieres();
        for (int i = 0; i < notesAutresMatieres.length; i++) {
            writer.println("Matiere " + (i + 4) + ": " + notesAutresMatieres[i]);
        }
        writer.println();
        writer.println("\tSomme des notes..: " + sommeNotes + " sur 2600 points");
        writer.println("\tMoyenne: " + moyenne);
        writer.println("\tStatut.: " + statut);
        writer.println();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
