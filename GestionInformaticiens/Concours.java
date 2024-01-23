import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Concours {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Candidat> programmationCandidats;
    private ArrayList<Candidat> baseDeDonneesCandidats;
    private ArrayList<Candidat> reseauCandidats;

    public Concours() {
        programmationCandidats = new ArrayList<>();
        baseDeDonneesCandidats = new ArrayList<>();
        reseauCandidats = new ArrayList<>();
    }

    // Méthode pour obtenir la liste de tous les candidats
    public ArrayList<Candidat> getListeTousCandidats() {
        ArrayList<Candidat> tousCandidats = new ArrayList<>();
        tousCandidats.addAll(programmationCandidats);
        tousCandidats.addAll(baseDeDonneesCandidats);
        tousCandidats.addAll(reseauCandidats);
        return tousCandidats;
    }

    private Candidat saisirInformationsCommunes() {

        System.out.print("Entrez le nom complet du candidat : ");
        String nomComplet = scanner.nextLine();

        System.out.print("Entrez le sexe du candidat (M/F) : ");
        char sexe = scanner.nextLine().toUpperCase().charAt(0);

        return new Candidat(nomComplet, sexe);
    }

    private int saisirNoteAvecBorne(String nomNote, int borneMinimale, int borneMaximale) {
        int note;
        do {
            System.out.print("Entrez la note " + nomNote + " du candidat (entre " + borneMinimale + " et "
                    + borneMaximale + ") : ");
            note = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne
        } while (note < borneMinimale || note > borneMaximale);

        return note;
    }

    public void enregistrerCandidatProgrammation() {
        Candidat informationsCommunes = saisirInformationsCommunes();

        int noteMiniProgramme = saisirNoteAvecBorne("Mini Programme", 0, 500);
        int noteQuestion1 = saisirNoteAvecBorne("Question 1", 0, 200);
        int noteQuestion2 = saisirNoteAvecBorne("Question 2", 0, 150);
        int noteQuestion3 = saisirNoteAvecBorne("Question 3", 0, 150);

        Programmation candidat = new Programmation(informationsCommunes.getNomComplet(), informationsCommunes.getSexe(),
                noteMiniProgramme, noteQuestion1, noteQuestion2, noteQuestion3);

        programmationCandidats.add(candidat);
        sauvegarderCandidatDansFichier(candidat, "programmation");
        System.out.println("Informaticien en programmation ajouté");

    }

    public void enregistrerCandidatBaseDeDonnees() {
        Candidat informationsCommunes = saisirInformationsCommunes();

        int noteConception = saisirNoteAvecBorne("Conception", 0, 300);
        int noteQuestion1 = saisirNoteAvecBorne("Question 1", 0, 250);
        int noteQuestion2 = saisirNoteAvecBorne("Question 2", 0, 250);

        BaseDeDonnees candidat = new BaseDeDonnees(informationsCommunes.getNomComplet(), informationsCommunes.getSexe(),
                noteConception, noteQuestion1, noteQuestion2);

        baseDeDonneesCandidats.add(candidat);
        sauvegarderCandidatDansFichier(candidat, "baseDeDonnees");
        System.out.println("Informaticien en baseDeDonnees ajouté");

    }

    public void enregistrerCandidatReseau() {
        Candidat informationsCommunes = saisirInformationsCommunes();

        int noteMiseEnPlace = saisirNoteAvecBorne("Mise en Place", 0, 250);
        int noteQuestion1 = saisirNoteAvecBorne("Question 1", 0, 150);
        int noteQuestion2 = saisirNoteAvecBorne("Question 2", 0, 200);
        int noteQuestion3 = saisirNoteAvecBorne("Question 3", 0, 250);
        int noteQuestion4 = saisirNoteAvecBorne("Question 4", 0, 300);

        Reseau candidat = new Reseau(informationsCommunes.getNomComplet(), informationsCommunes.getSexe(),
                noteMiseEnPlace, noteQuestion1, noteQuestion2, noteQuestion3, noteQuestion4);
        reseauCandidats.add(candidat);
        sauvegarderCandidatDansFichier(candidat, "reseau");
        System.out.println("Informaticien en réseau ajouté");
    }

    private void sauvegarderCandidatDansFichier(Candidat candidat, String domaine) {
        // Lire le contenu existant du fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(domaine + ".txt"))) {
            StringBuilder contenuExist = new StringBuilder();
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                contenuExist.append(ligne).append("\n");
            }

            // Réécrire le fichier en ajoutant le nouveau candidat au début
            try (FileWriter writer = new FileWriter(domaine + ".txt")) {
                writer.write(candidat.toString() + "\n");
                writer.write(contenuExist.toString());
            } catch (IOException e) {
                System.out.println("Erreur lors de l'enregistrement du candidat dans le fichier.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            // Ajouter une vérification et création du fichier s'il n'existe pas
            System.out.println("Le fichier " + domaine + ".txt n'existait pas. mais,je le cree.");
            try {
                new File(domaine + ".txt").createNewFile();
            } catch (IOException ioException) {
                System.out.println("Erreur lors de la création du fichier : " + ioException.getMessage());
            }
            // Réessayer la lecture après la création du fichier
            sauvegarderCandidatDansFichier(candidat, domaine);
        }
    }

    private void afficherCandidatsDomaine(String domaine, List<Candidat> candidats) {
        System.out.println(domaine);
        if (candidats.isEmpty()) {
            System.out.println("Liste vide");
        } else {
            for (Candidat candidat : candidats) {
                System.out.println(candidat.toString());
            }
        }
    }

    public void afficherCandidats() {
        afficherCandidatsDomaine("Candidats en Programmation:", programmationCandidats);
        afficherCandidatsDomaine("Candidats en Base de Données:", baseDeDonneesCandidats);
        afficherCandidatsDomaine("Candidats en Réseau:", reseauCandidats);
    }

    // Méthode auxiliaire pour afficher la liste des candidats
    public void afficherListeCandidats(ArrayList<Candidat> candidats) {
        if (candidats.isEmpty()) {
            System.out.println("Liste vide");
        } else {
            for (Candidat candidat : candidats) {
                System.out.println(candidat.toString());
            }
        }
    }

    // C. Afficher la liste des candidats suivant un domaine saisi par
    // l'utilisateur.
    public void afficherCandidatsParDomaine() {
        System.out.print("Entrez le domaine (PRO, BD, RES) : ");
        String domaine = scanner.nextLine().toUpperCase();

        switch (domaine) {
            case "PRO":
                afficherListeCandidats(programmationCandidats);
                break;
            case "BD":
                afficherListeCandidats(baseDeDonneesCandidats);
                break;
            case "RES":
                afficherListeCandidats(reseauCandidats);
                break;
            default:
                System.out.println("Domaine invalide.");
        }
    }

    // D. Afficher les informations complètes sur le lauréat (plus grande moyenne)
    public void afficherInformationsLaureat() {
        ArrayList<Candidat> tousLesCandidats = new ArrayList<>();
        tousLesCandidats.addAll(programmationCandidats);
        tousLesCandidats.addAll(baseDeDonneesCandidats);
        tousLesCandidats.addAll(reseauCandidats);

        if (!tousLesCandidats.isEmpty()) {
            // Trouver le lauréat avec la plus grande moyenne
            Candidat laureat = tousLesCandidats.get(0);
            for (Candidat candidat : tousLesCandidats) {
                if (candidat.calculerMoyenne() > laureat.calculerMoyenne()) {
                    laureat = candidat;
                }
            }

            // Afficher les informations du lauréat
            System.out.println("Informations du lauréat (plus grande moyenne) :");
            System.out.println(laureat.toString());
        } else {
            System.out.println("Aucun candidat enregistré.");
        }
    }

    // E. Afficher les informations sur les 5 premiers lauréats du concours.
    public void afficherInformationsCinqPremiersLaureats() {
        ArrayList<Candidat> tousLesCandidats = new ArrayList<>();
        tousLesCandidats.addAll(programmationCandidats);
        tousLesCandidats.addAll(baseDeDonneesCandidats);
        tousLesCandidats.addAll(reseauCandidats);
        // Tri des candidats par ordre décroissant de leur moyenne
        tousLesCandidats.sort(Comparator.comparingDouble(Candidat::calculerMoyenne).reversed());
        if (!tousLesCandidats.isEmpty()) {
            // Trouver les 5 premiers lauréats (pas de tri explicite)
            System.out.println("Informations des 5 premiers lauréats :");
            int nombreDeLaureats = Math.min(5, tousLesCandidats.size());
            for (int i = 0; i < nombreDeLaureats; i++) {
                System.out.println(tousLesCandidats.get(i).toString());
            }
        } else {
            System.out.println("Aucun candidat enregistré.");
        }
    }

   // F. Supprimer les 4 derniers candidats du concours en termes de leur moyenne obtenue
public void supprimerQuatreDerniersCandidats() {
        System.out.println("4 moyennes plus fortes seront suppimees");

    ArrayList<Candidat> tousLesCandidats = new ArrayList<>();
    tousLesCandidats.addAll(programmationCandidats);
    tousLesCandidats.addAll(baseDeDonneesCandidats);
    tousLesCandidats.addAll(reseauCandidats);

    if (!tousLesCandidats.isEmpty()) {
        // Trier les candidats par moyenne en ordre décroissant
        Collections.sort(tousLesCandidats, Comparator.comparingDouble(Candidat::calculerMoyenne).reversed());

        // Supprimer les 4 derniers candidats
        int nombreDeCandidatsASupprimer = Math.min(4, tousLesCandidats.size());
        for (int i = 0; i < nombreDeCandidatsASupprimer; i++) {
            String domaine="";
           Candidat candidat= tousLesCandidats.remove(tousLesCandidats.size() - 1);
            sauvegarderCandidatDansFichier(candidat, domaine);

        }

        System.out.println("Les 4 derniers candidats ont été supprimés.");
    } else {
        System.out.println("Aucun candidat enregistré.");
    }
}
// F. Supprimer les 4 derniers candidats du concours en termes de leur moyenne obtenue
public void supprimerQuatreDerniersCandidatsMoyenneBasse() {
    System.out.println("4 moyennes plus faibles seront suppimees");
    ArrayList<Candidat> tousLesCandidats = new ArrayList<>();
    tousLesCandidats.addAll(programmationCandidats);
    tousLesCandidats.addAll(baseDeDonneesCandidats);
    tousLesCandidats.addAll(reseauCandidats);

    if (!tousLesCandidats.isEmpty()) {
        // Trier les candidats par moyenne en ordre croissant
        Collections.sort(tousLesCandidats, Comparator.comparingDouble(Candidat::calculerMoyenne));

        // Supprimer les 4 derniers candidats
        int nombreDeCandidatsASupprimer = Math.min(4, tousLesCandidats.size());
        for (int i = 0; i < nombreDeCandidatsASupprimer; i++) {
         Candidat candidat=   tousLesCandidats.remove(0); // Supprimer le premier candidat (celui avec la plus basse moyenne)
        String domaine="";
         sauvegarderCandidatDansFichier(candidat, domaine);

        }

        System.out.println("Les 4 candidats ayant les plus basses moyennes ont été supprimés.");
    } else {
        System.out.println("Aucun candidat enregistré.");
    }
}


}
