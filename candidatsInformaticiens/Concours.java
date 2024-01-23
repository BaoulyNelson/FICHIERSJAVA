import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Concours {
    private ArrayList<ProgrammationCandidat> programmationCandidats;
    private ArrayList<BaseDeDonneesCandidat> baseDeDonneesCandidat;
    private ArrayList<ReseauCandidat> reseauCandidats;
    Scanner scanner = new Scanner(System.in);

    public Concours() {
        programmationCandidats = new ArrayList<>();
        baseDeDonneesCandidat = new ArrayList<>();
        reseauCandidats = new ArrayList<>();

    }

    // Méthode pour enregistrer un candidat en programmation
    public void enregistrerCandidatProgrammation(ProgrammationCandidat candidat) {
        programmationCandidats.add(candidat);
        System.out.println("Candidat programmation enregistré avec succès.");
    }

    // Méthode pour enregistrer un candidat en programmation
    public void enregistrerCandidatBaseDeDonnees(BaseDeDonneesCandidat candidat) {
        baseDeDonneesCandidat.add(candidat);
        System.out.println("Candidat base de donnees enregistré avec succès.");
    }

    // Méthode pour enregistrer le candidat en réseau dans la liste
    private void enregistrerCandidatReseau(ReseauCandidat candidat) {
        reseauCandidats.add(candidat);
        System.out.println("Candidat enregistré avec succès.");
    }

    // Méthode pour collecter les informations communes
    public String collecterInformationsCommunes() {
        System.out.print("Entrez le nom complet du candidat: ");
        String nomComplet = scanner.nextLine();

        System.out.print("Entrez le sexe du candidat (M/F): ");
        String sexe = scanner.nextLine().toUpperCase();

        StringBuilder stringBuilder = new StringBuilder();
        // Concaténation du nom complet et du sexe
        stringBuilder.append(nomComplet).append("\n").append(sexe);
        return stringBuilder.toString();
    }

    // Méthode pour enregistrer un candidat en programmation
    public void enregistrerCandidatProgrammation() {
        System.out.println("Enregistrement d'un candidat en Programmation:");

        String info = collecterInformationsCommunes();
        // Utilisation de StringTokenizer pour extraire le nom complet et le sexe
        StringTokenizer tokenizer = new StringTokenizer(info);
        String nomComplet = tokenizer.nextToken();
        String sexe = tokenizer.nextToken();

        // Contrainte pour la note du mini-programme (entre 0 et 500)
        int noteMiniProgramme;
        do {
            System.out.print("Entrez la note du mini-programme (sur 500): ");
            noteMiniProgramme = scanner.nextInt();
        } while (noteMiniProgramme < 0 || noteMiniProgramme > 500);

        // Contrainte pour la note de la Question 1 (entre 0 et 200)
        int noteQuestion1;
        do {
            System.out.print("Entrez la note de la Question 1 (sur 200): ");
            noteQuestion1 = scanner.nextInt();
        } while (noteQuestion1 < 0 || noteQuestion1 > 200);

        // Contrainte pour la note de la Question 2 (entre 0 et 150)
        int noteQuestion2;
        do {
            System.out.print("Entrez la note de la Question 2 (sur 150): ");
            noteQuestion2 = scanner.nextInt();
        } while (noteQuestion2 < 0 || noteQuestion2 > 150);

        // Contrainte pour la note de la Question 3 (entre 0 et 150)
        int noteQuestion3;
        do {
            System.out.print("Entrez la note de la Question 3 (sur 150): ");
            noteQuestion3 = scanner.nextInt();
        } while (noteQuestion3 < 0 || noteQuestion3 > 150);

        scanner.nextLine(); // Pour consommer le retour à la ligne

        ProgrammationCandidat candidat = new ProgrammationCandidat(nomComplet, sexe,
                noteMiniProgramme, noteQuestion1, noteQuestion2, noteQuestion3);

        enregistrerCandidatProgrammation(candidat);
        ecrireDansFichiers(programmationCandidats, "programmationCandidats.txt");
    }

    // Méthode pour enregistrer un candidat en base de données
    public void enregistrerCandidatBaseDeDonnees() {

        System.out.println("Enregistrement d'un candidat en Base de données:");
        String info = collecterInformationsCommunes();
        // Utilisation de StringTokenizer pour extraire le nom complet et le sexe
        StringTokenizer tokenizer = new StringTokenizer(info);
        String nomComplet = tokenizer.nextToken();
        String sexe = tokenizer.nextToken();

        // Contrainte pour la note de conception d'une base de données (entre 0 et 300)
        int noteConception;
        do {
            System.out.print("Entrez la note pour la conception d'une base de données (sur 300): ");
            noteConception = scanner.nextInt();
        } while (noteConception < 0 || noteConception > 300);

        // Contrainte pour la note de la Question 1 (entre 0 et 250)
        int noteQuestion1;
        do {
            System.out.print("Entrez la note de la Question 1 (sur 250): ");
            noteQuestion1 = scanner.nextInt();
        } while (noteQuestion1 < 0 || noteQuestion1 > 250);

        // Contrainte pour la note de la Question 2 (entre 0 et 250)
        int noteQuestion2;
        do {
            System.out.print("Entrez la note de la Question 2 (sur 250): ");
            noteQuestion2 = scanner.nextInt();
        } while (noteQuestion2 < 0 || noteQuestion2 > 250);

        scanner.nextLine(); // Pour consommer le retour à la ligne

        // Création d'un objet Candidat et ajout à la liste
        BaseDeDonneesCandidat candidat = new BaseDeDonneesCandidat(nomComplet, sexe,
                noteConception, noteQuestion1, noteQuestion2);

        enregistrerCandidatBaseDeDonnees(candidat);
        ecrireDansFichiers(baseDeDonneesCandidat, "baseDeDonneesCandidat.txt");
    }

    // Méthode pour enregistrer un candidat en réseau
    public void enregistrerCandidatReseau() {

        System.out.println("Enregistrement d'un candidat en Réseau:");
        String info = collecterInformationsCommunes();
        // Utilisation de StringTokenizer pour extraire le nom complet et le sexe
        StringTokenizer tokenizer = new StringTokenizer(info);
        String nomComplet = tokenizer.nextToken();
        String sexe = tokenizer.nextToken();
        // Contrainte pour la note de mise en place d'un réseau local (entre 0 et 250)
        int noteMiseEnPlace;
        do {
            System.out.print("Entrez la note pour la mise en place d'un réseau local (sur 250): ");
            noteMiseEnPlace = scanner.nextInt();
        } while (noteMiseEnPlace < 0 || noteMiseEnPlace > 250);

        // Contrainte pour la note de la Question 1 (entre 0 et 150)
        int noteQuestion1;
        do {
            System.out.print("Entrez la note de la Question 1 (sur 150): ");
            noteQuestion1 = scanner.nextInt();
        } while (noteQuestion1 < 0 || noteQuestion1 > 150);

        // Contrainte pour la note de la Question 2 (entre 0 et 200)
        int noteQuestion2;
        do {
            System.out.print("Entrez la note de la Question 2 (sur 200): ");
            noteQuestion2 = scanner.nextInt();
        } while (noteQuestion2 < 0 || noteQuestion2 > 200);

        // Contrainte pour la note de la Question 3 (entre 0 et 250)
        int noteQuestion3;
        do {
            System.out.print("Entrez la note de la Question 3 (sur 250): ");
            noteQuestion3 = scanner.nextInt();
        } while (noteQuestion3 < 0 || noteQuestion3 > 250);

        // Contrainte pour la note de la Question 4 (entre 0 et 300)
        int noteQuestion4;
        do {
            System.out.print("Entrez la note de la Question 4 (sur 300): ");
            noteQuestion4 = scanner.nextInt();
        } while (noteQuestion4 < 0 || noteQuestion4 > 300);

        scanner.nextLine(); // Pour consommer le retour à la ligne

        // Création d'un objet Candidat et ajout à la liste
        ReseauCandidat candidat = new ReseauCandidat(
                nomComplet, sexe, noteMiseEnPlace, noteQuestion1, noteQuestion2, noteQuestion3, noteQuestion4);

        enregistrerCandidatReseau(candidat);
        ecrireDansFichiers(reseauCandidats, "reseauCandidats.txt");
    }

    // Méthode générique pour écrire les données d'une liste de candidats dans un
    // fichier
    private void ecrireDansFichiers(List<? extends Candidat> candidats, String fichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            for (Candidat candidat : candidats) {
                String ligne = candidat.toString();
                writer.write(ligne);
                writer.newLine();
            }
            System.out.println("Données des candidats écrites dans le fichier " + fichier + " avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier " + fichier + " : " + e.getMessage());
        }
    }
    

    // Méthode pour afficher tous les candidats
    public void afficherTousLesCandidats() {
        System.out.println("Liste de tous les candidats:");

        // Afficher les candidats de la programmation
        System.out.println("Candidats en Programmation:");
        afficherCandidats(programmationCandidats);

        // Afficher les candidats de la base de données
        System.out.println("Candidats en Base de données:");
        afficherCandidats(baseDeDonneesCandidat);

        // Afficher les candidats en réseau
        System.out.println("Candidats en Réseau:");
        afficherCandidats(reseauCandidats);

    }

    // Méthode pour afficher une liste de candidats
    private void afficherCandidats(List<? extends Candidat> candidats) {
        for (Candidat candidat : candidats) {
            System.out.println(candidat.toString());
            System.out.println();
        }
    }

    // Méthode pour afficher la liste des candidats suivant un domaine saisi par
    // l'utilisateur
    public void afficherCandidatsDomaine() {
        System.out.print("Entrez le domaine (PRO, BD ou RES):");
        String domaine = scanner.nextLine().toLowerCase();

        switch (domaine) {
            case "pro":
                System.out.println(programmationCandidats.toString());
                break;
            case "bd":
                System.out.println(baseDeDonneesCandidat.toString()); // Assurez-vous que baseDeDonneesCandidat est une
                                                                      // liste ou un objet iterable
                break;
            case "res":
                System.out.println(reseauCandidats.toString());
                break;
            default:
                System.out.println("Domaine non valide.");
        }
    }

    public void afficherLaureatDesLaureats() {
        List<Candidat> tousLesCandidats = new ArrayList<>();
        tousLesCandidats.addAll(programmationCandidats);
        tousLesCandidats.addAll(baseDeDonneesCandidat);
        tousLesCandidats.addAll(reseauCandidats);
    
        if (!tousLesCandidats.isEmpty()) {
            List<Candidat> laureats = trouverLaureats(tousLesCandidats);
            System.out.println("Lauréats des lauréats toutes spécialités confondues:");
            for (Candidat laureat : laureats) {
                System.out.println(laureat.toString());
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("Aucun candidat enregistré.");
        }
    }
    
    private List<Candidat> trouverLaureats(List<Candidat> candidats) {
        double meilleureMoyenne = candidats.stream()
                .mapToDouble(Candidat::calculerMoyenne)
                .max()
                .orElse(0.0);
    
        return candidats.stream()
                .filter(c -> c.calculerMoyenne() == meilleureMoyenne)
                .collect(Collectors.toList());
    }
    

    // Méthode pour afficher les informations sur les 5 premiers lauréats en toutes
    // spécialités
    public void afficherCinqPremiersLaureats() {
        List<Candidat> tousLesCandidats = new ArrayList<>();
        tousLesCandidats.addAll(programmationCandidats);
        tousLesCandidats.addAll(baseDeDonneesCandidat);
        tousLesCandidats.addAll(reseauCandidats);
        // Ajoutez d'autres listes de candidats selon les spécialités

        if (!tousLesCandidats.isEmpty()) {
            List<Candidat> cinqPremiers = trouverCinqPremiers(tousLesCandidats);
            System.out.println("Cinq premiers lauréats en toutes spécialités confondues:");
            for (int i = 0; i < cinqPremiers.size(); i++) {
                System.out.println(cinqPremiers.get(i).toString());
                if (i < cinqPremiers.size() - 1) {
                    System.out.println("--------------------------");
                }
            }
        } else {
            System.out.println("Aucun candidat enregistré.");
        }
    }

    private List<Candidat> trouverCinqPremiers(List<Candidat> candidats) {
        return candidats
                .stream()
                .sorted(Comparator.comparingDouble(Candidat::calculerMoyenne).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    // Méthode pour supprimer les 4 derniers candidats toutes spécialités confondues
    public void supprimerQuatreDerniers() {
        List<Candidat> tousLesCandidats = new ArrayList<>();
        tousLesCandidats.addAll(programmationCandidats);
        tousLesCandidats.addAll(baseDeDonneesCandidat);
        tousLesCandidats.addAll(reseauCandidats);
        // Ajoutez d'autres listes de candidats selon les spécialités

        if (!tousLesCandidats.isEmpty()) {
            supprimerDerniers(tousLesCandidats, 4);
            System.out.println("Quatre derniers candidats supprimés avec succès.");
        } else {
            System.out.println("Aucun candidat enregistré.");
        }
    }

    private void supprimerDerniers(List<Candidat> candidats, int nombre) {
        candidats.sort(Comparator.comparingDouble(Candidat::calculerMoyenne).reversed());
        int taille = candidats.size();
        for (int i = taille - 1; i >= taille - nombre && i >= 0; i--) {
            candidats.remove(i);
            ecrireDansFichiers(candidats, "candidatsSupprimes");
        }
    }
   public void viderArrayList(List<? extends Candidat> listeCandidats, String fichier) {
        // Sauvegarder les candidats dans le fichier avant de vider la liste
    
        // Vider la liste après la sauvegarde
        listeCandidats.clear();
        ecrireDansFichiers(listeCandidats, fichier);
    
        System.out.println("Tous les candidats ont été supprimés de la liste " + fichier + " et le fichier a été mis à jour.");
    }
    
    // public void vider() {
    //     ecrireDansFichiers(programmationCandidats, "programmationCandidats.txt");
    //     ecrireDansFichiers(baseDeDonneesCandidat, "baseDeDonneesCandidat.txt");
    //     ecrireDansFichiers(reseauCandidats, "reseauCandidats.txt");
    //     // Vider les listes après la sauvegarde
    //     programmationCandidats.clear();
    //     baseDeDonneesCandidat.clear();
    //     reseauCandidats.clear();
        
    
    //     System.out.println("Tous les candidats ont été supprimés et le fichier a été mis à jour.");
    // }
    
    
}
