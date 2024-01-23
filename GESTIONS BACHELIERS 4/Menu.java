import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Bachelier> bacheliers = new ArrayList<Bachelier>();

    private static void entrerNote(String prompt, HashMap<String, Float> matieres, int bareme) {
        float note = 0;
        do {
            System.out.print("Note de " + prompt + "");
            note = sc.nextInt();
        } while (note > bareme || note < 0);
        matieres.put(prompt, note);
    }

    public static void enregistrer() {
        int age;
        String nom, prenom;

        System.out.print("Entrez votre nom: ");
        nom = sc.next().toUpperCase();

        System.out.print("Entrez votre prenom: ");
        prenom = sc.next();

        System.out.print("Entrez votre age: ");
        age = sc.nextInt();

        Bachelier bachelier = new Bachelier(nom, prenom, age);
        entrerNote("Mathematiques (sur 400)....", bachelier.getMatieres(), Bachelier.getBaremeHaut());
        entrerNote("Philosophie (sur 400)......", bachelier.getMatieres(), Bachelier.getBaremeHaut());
        entrerNote("Sciences sociales (sur 400)", bachelier.getMatieres(), Bachelier.getBaremeHaut());

        entrerNote("Creole (sur 200)...........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        entrerNote("Physique (sur 200).........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        entrerNote("Chimie (sur 200)...........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        entrerNote("Anglais (sur 200)..........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        entrerNote("Espagnol (sur 200).........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        entrerNote("Biologie (sur 200).........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        entrerNote("Economie (sur 200).........", bachelier.getMatieres(), Bachelier.getBaremeBas());
        System.out.println("Notes enregistrees avec succès !");
        bachelier.setMoyenne();
        bacheliers.add(bachelier);
        System.out.println("===FIN===");
    }

    private static void ecrire() {
        for (Bachelier bc : bacheliers) {
            try {
                FileWriter monfichier = new FileWriter(
                        String.format("%s %s.txt", bc.getNom().toUpperCase(), bc.getPrenom()));
                monfichier.write("le/la candidat.e " + bc.getNom().toUpperCase() + " " + bc.getPrenom()
                        + ", identifié.e au numéro d'ordre " + bc.getMatricule()
                        + "\nà la session unique des examens du bac :\n\n");
                StringBuffer contenu = new StringBuffer(
                      bc.toString());
                monfichier.write(contenu.toString());
                monfichier.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean estEmailValide(String mail) {
        // Définir un motif regex pour valider l'email
        String motif = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compiler le motif en une instance Pattern
        Pattern pattern = Pattern.compile(motif);

        // Créer un objet Matcher pour le texte donné
        Matcher matcher = pattern.matcher(mail);

        // Vérifier si le motif correspond à l'email
        return matcher.matches();
    }
public static void afficherBacheliers(){
    for (Bachelier bachelier : bacheliers) {
        System.out.println("Entrer cette matricule pour trouver le resultat " +bachelier.getMatricule());
    }
}
    public static void verifierMatricule() {
        int matricule;
        String mail;
        boolean trouve = false;

        System.out.print("Entrez votre adresse mail: ");
        mail = sc.next();
        while (!estEmailValide(mail)) {
            System.out.print("L'email n'est pas valide.Re-essayer svp! ");
            mail = sc.next();
        }
        System.out.print("Entrez le matricule du candidat: ");
        matricule = sc.nextInt();
        for (Bachelier bc : bacheliers) {
            if (matricule == bc.getMatricule()) {
                System.out.println("va consulter le fichier txt");
                       ecrire();
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Matricule introuvable.");
        }
    }

  
    }


