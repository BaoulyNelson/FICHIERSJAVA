import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Concours {
    private static ArrayList<Candidat> candidats = new ArrayList<Candidat>();
    private static Scanner sc = new Scanner(System.in);

    public static void lire() {
        try {
            File[] fichiers = { new File("Programmation.txt"), new File("BDD.txt"), new File("Reseau.txt") };
            Scanner reader = null;
            for (File fichier : fichiers) {
                if (fichier.exists()) {
                    reader = new Scanner(fichier);
                    while (reader.hasNextLine()) {
                        String ligne = reader.nextLine();
                        String tab[] = ligne.split("\\|");
                        int code = Integer.valueOf(tab[0].trim());
                        String nomComplet = tab[1].trim();
                        char sexe = tab[2].trim().charAt(0);
                        String domaine = tab[3].trim();
                        int noteTP = Integer.valueOf(tab[4].trim());
                        int noteQuestion1 = Integer.valueOf(tab[5].trim());
                        int noteQuestion2 = -1;
                        int noteQuestion3 = -1;
                        int noteQuestion4 = -1;
                        switch (domaine) {
                            case "Programmation":
                                noteQuestion2 = Integer.valueOf(tab[6].trim());
                                noteQuestion3 = Integer.valueOf(tab[7].trim());
                                break;
                            case "BDD":
                                noteQuestion2 = Integer.valueOf(tab[6].trim());
                                break;
                            case "Reseau":
                                noteQuestion2 = Integer.valueOf(tab[6].trim());
                                noteQuestion3 = Integer.valueOf(tab[7].trim());
                                noteQuestion4 = Integer.valueOf(tab[8].trim());
                                break;
                        }
                        candidats.add(new Candidat(code, nomComplet, sexe, domaine, noteTP, noteQuestion1,
                                noteQuestion2, noteQuestion3, noteQuestion4));
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enregistrer() {
        Stack<Integer> codes = new Stack<Integer>();
        String nomComplet;
        char sexe;
        String domaine;
        int noteTP = -1;
        int noteQuestion1 = -1;
        int noteQuestion2 = -1;
        int noteQuestion3 = -1;
        int noteQuestion4 = -1;
        int code = new Random().nextInt(1024);
        codes.push(code);
        while (codes.contains(code)) {
            codes.pop();
        }
        codes.push(code);

        System.out.print("Combien de personnes voulez-vous enregistrer?: ");
        int qtePersonnes = sc.nextInt();
        while (qtePersonnes < 3) {
            System.out.print("Au moins,entrer 3 postulants!: ");
            qtePersonnes = sc.nextInt();
        }
        for (int i = 0; i < qtePersonnes; i++) {
            System.out.println("=====Saisie pour la personne " + (i + 1));
            System.out.println();
            System.out.print("Nom complet du participant :");
            sc.nextLine();
            nomComplet = sc.nextLine();
            while (nomComplet.isEmpty()) {
                System.out.print("re-Entrer SVP: ");
                nomComplet = sc.next();
            }
            System.out.print("Entrer le Sexe (M/F): ");
            sexe = sc.next().charAt(0);
            while (sexe != 'M' && sexe != 'F') {
                System.out.print("re-Entrer SVP: ");
                sexe = sc.next().charAt(0);
            }
            System.out.print("Pour quel domaine? Programmation,BDD,Reseau: ");
            domaine = sc.next();
            switch (domaine) {
                case "Programmation":
                    System.out.print("Note du mini-programme sur 500: ");
                    noteTP = sc.nextInt();
                    while (noteTP > 500) {
                        System.out.print("re-entrer svp!: ");
                        noteTP = sc.nextInt();
                    }
                    System.out.print("Note de la question 1 sur 200: ");
                    noteQuestion1 = sc.nextInt();
                    while (noteQuestion1 > 200) {
                        System.out.print("Re-entrer svp : ");
                        noteQuestion1 = sc.nextInt();
                    }
                    System.out.print("Note de la question 2 sur 150: ");
                    noteQuestion2 = sc.nextInt();
                    while (noteQuestion2 > 150) {
                        System.out.print("re-Entrer Svp: ");
                        noteQuestion2 = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.print("Note de la question 3 sur 150: ");
                    noteQuestion3 = sc.nextInt();
                    while (noteQuestion3 > 150) {
                        System.out.print("re-Entrer Svp: ");
                        noteQuestion3 = sc.nextInt();
                    }
                    break;
                case "BDD":
                    System.out.print("Note pour la conception d'une base de donnee sur 300: ");
                    noteTP = sc.nextInt();
                    while (noteTP > 300) {
                        System.out.print("re-Entrer Svp: ");
                        noteTP = sc.nextInt();
                    }
                    System.out.print("Note de la question 1 sur 250: ");
                    noteQuestion1 = sc.nextInt();
                    while (noteQuestion1 > 250) {
                        System.out.print("re-entrer svp: ");
                        noteQuestion1 = sc.nextInt();
                    }
                    System.out.print("Note de la question 2 sur 250: ");
                    noteQuestion2 = sc.nextInt();
                    while (noteQuestion2 > 250) {
                        System.out.print("re-entrer svp: ");
                        noteQuestion2 = sc.nextInt();
                    }
                    break;
                case "Reseau":
                    System.out.print("Note pour la mise en place d'un reseau local sur 250: ");
                    noteTP = sc.nextInt();
                    while (noteTP > 900) {
                        System.out.print("re_Entrer SVP: ");
                        noteTP = sc.nextInt();
                    }
                    System.out.print("Note de la question 1 sur 150: ");
                    noteQuestion1 = sc.nextInt();
                    while (noteQuestion1 > 150) {
                        System.out.print("re_Entrer svp: ");
                        noteQuestion1 = sc.nextInt();
                    }
                    System.out.print("Note de la question 2 sur 200: ");
                    noteQuestion2 = sc.nextInt();
                    while (noteQuestion2 > 200) {
                        System.out.print("re-Entrer svp: ");
                        noteQuestion2 = sc.nextInt();
                    }
                    System.out.print("Note de la question 3 sur 250: ");
                    noteQuestion3 = sc.nextInt();
                    while (noteQuestion3 > 250) {
                        System.out.print("Re-Entrer SVP: ");
                        noteQuestion3 = sc.nextInt();
                    }
                    System.out.print("Note de la question 4 sur 300: ");
                    noteQuestion4 = sc.nextInt();
                    while (noteQuestion4 > 300) {
                        System.out.print("re-Entrer SVP: ");
                        noteQuestion4 = sc.nextInt();
                    }
                    break;
            }
            Candidat temp = new Candidat(new Random().nextInt(100), nomComplet, sexe, domaine, noteTP,
                    noteQuestion1,
                    noteQuestion2, noteQuestion3, noteQuestion4);
            candidats.add(temp);
            temp.ecrire();
            System.out.println("Enregistrement de la personne " + (i + 1) + " effectue avec succes.\n");
        }
    }

    public static void afficherCandidats() {
        System.out.println("===Debut===");
        try {
            File[] fichiers = { new File("Programmation.txt"), new File("BDD.txt"), new File("Reseau.txt") };
            StringBuffer content = new StringBuffer();
            Scanner reader = null;
            for (File fichier : fichiers) {
                if (fichier.exists()) {
                    reader = new Scanner(fichier);
                    while (reader.hasNextLine()) {
                        content.append(reader.nextLine() + "\n");
                    }
                }
            }
            System.out.println(content);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("l'affichage est fait avec succes\n");
    }

    public static void afficherParDomaine() {
        System.out.print("Entrez le domaine(Programmation/Reseau/BDD): ");
        String domaine = sc.nextLine();
        System.out.println();
        try {
            File fichier = new File(domaine + ".txt");
            Scanner reader = new Scanner(fichier);
            while (reader.hasNextLine()) {
                String[] tab = reader.nextLine().split("\\|");
                System.out.println(tab[0] + tab[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Tache effectuee avec succes\n");
    }

    public static void afficherLeLaureat() {
        System.out.println("===affichage des laureats===\n");
        try {
            StringBuffer content = new StringBuffer();
            Scanner reader = null;
            double max = 0;
            File[] fichiers = { new File("Programmation.txt"), new File("BDD.txt"), new File("Reseau.txt") };
            String ligne, maxLigne = null;
            for (File fichier : fichiers) {
                if (fichier.exists()) {
                    reader = new Scanner(fichier);
                    while (reader.hasNextLine()) {
                        ligne = reader.nextLine();
                        String tab[] = ligne.split("\\|");
                        double moyenne = Double.valueOf(tab[tab.length - 1].trim());
                        if (moyenne > max) {
                            max = moyenne;
                            maxLigne = ligne;
                        }
                    }
                }
            }
            System.out.println(content);
            reader.close();
            System.out.println(maxLigne);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Tache effectuee sans echec\n");
    }

    public static void afficherCinq() {
        candidats.removeAll(candidats);
        System.out.println("===affichage des 5 candidats===");
        lire();
        Tris.SelectionDesc(candidats);

        for (int i = 0; i < candidats.size(); i++) {
            if (i == 5) {
                break;
            }
            System.out.println(candidats.get(i).getNomComplet() + " - " + candidats.get(i).getMoyenne());
        }
        System.out.println("Travail effectue avec succes\n");
    }

    public static void supprimerQuatre() {
        String stringProg = "";
        String stringReseau = "";
        String stringBDD = "";

        lire();
        Tris.SelectionAsc(candidats);
        for (int i = 0; i < 4; i++) {
            candidats.remove(candidats.get(0));
        }
        File[] fichiers = { new File("Programmation.txt"), new File("BDD.txt"), new File("Reseau.txt") };
        Scanner reader = null;
        for (File fichier : fichiers) {
            if (fichier.exists()) {
                try {
                    reader = new Scanner(fichier);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while (reader.hasNextLine()) {
                    String ligne = reader.nextLine();
                    for (Candidat candidat : candidats) {
                        if (ligne.contains("Programmation") && candidat.getDomaine().equals("Programmation")) {
                            stringProg += ligne + "\n";
                            break;
                        } else if (ligne.contains("BDD") && candidat.getDomaine().equals("BDD")) {
                            stringBDD += ligne + "\n";
                            break;
                        } else if (ligne.contains("Reseau") && candidat.getDomaine().equals("Reseau")) {
                            stringReseau += ligne + "\n";
                            break;
                        }
                    }
                }
            }
        }

        reader.close();
        System.out.println(stringReseau);
        try {
            FileWriter fichier1 = new FileWriter("Programmation.txt");
            fichier1.write(stringProg);
            fichier1.flush();
            fichier1.close();
            FileWriter fichier2 = new FileWriter("BDD.txt");
            fichier2.write(stringBDD);
            fichier2.flush();
            fichier2.close();
            FileWriter fichier3 = new FileWriter("Reseau.txt");
            fichier3.write(stringReseau);
            fichier3.flush();
            fichier3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("supression effectuee avec succes\n");
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                "\t" + "\t" + "\t" + "\t" + "[=============================== ESIH ===============================]");
        System.out.println("\t" + "\t"
                + "[=============================== ECOLE SUPERIEURE INFOTRONIQUE D'HAITI ===============================]");
        System.out.println("\t" + "\t"
                + " -----------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("\t" + "\t" + "DEVOIR D'INTRA JAVA DE LA DEUXIME SESSION : ");
        System.out.println("\t" + "\t" + "NIVEAU L3                                 : ");
        System.out.println("\t" + "\t" + "NOM DU GROUPE -> (LES INTRÉPIDES)         : ");
        System.out.println("\t" + "\t" + "EXERCICES SUR  RECRUTEMENT DES INFORMATICIENS:");
        System.out.println("\t" + "\t" + "COURS ENSEIGNÉ PAR PROF. Jaures PIERRE    : ");
        System.out.println();
        System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t"
                + "        DEVOIR PREPARÉ PAR UN ENSEMBLE DE PROGRAMMEUR:");
        System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "                NOM     PRENOM");
        System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "                ---     ------");
        System.out.println(
                "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "        1-) [---DORELUS Bersony  ---]:");
        System.out.println(
                "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "        2-) [---JOSEPH  Clavensky---]:");
        System.out.println(
                "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "        3-) [---NELSON  Benito   ---]:");
        System.out.println("");
        int choix;
        do {
            System.out.print("------------------------------------------------------------------------------\n");
            System.out.print("========================================Menu==================================\n");
            System.out.print("------------------------------------------------------------------------------\n");
            System.out.println();
            System.out.print("participants à un concours de recrutement dinformaticien dans une institution:\n");
            System.out.print("--------------------------- Que voulez-vous faire? ---------------------------\n");
            System.out.print("1- Enregistrer un candidat dans son fichier respectif\n");
            System.out.print("2- Afficher tous les candidats du concours sur les 3 domaines\n");
            System.out.print("3- Afficher la liste des candidats suivant un domaine saisi par lutilisateur.\n");
            System.out.print(
                    "4- Afficher les informations completes sur le laureat des laureats\n   (plus grande moyenne obtenue parmi les candidats) du concours.\n");
            System.out.print("5- Afficher les informations sur les 5 premiers laureats du concours.\n");
            System.out.print("6- Supprimer les 4 derniers candidats du concours en termes de leur moyenne obtenu\n");
            System.out.println("7- Pour quitter le programme\n");
            System.out.print("votre choix: ");
            choix = sc.nextInt();
            System.out.println();
            switch (choix) {
                case 1:
                    sc.nextLine();
                    enregistrer();
                    System.out.println();
                    break;
                case 2:
                    afficherCandidats();
                    System.out.println();
                    break;
                case 3:
                    sc.nextLine();
                    afficherParDomaine();
                    System.out.println();
                    break;
                case 4:
                    afficherLeLaureat();
                    System.out.println();
                    break;
                case 5:
                    afficherCinq();
                    System.out.println();
                    break;
                case 6:
                    supprimerQuatre();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("===Fin de programme===\n");
                    break;
                default:
                    System.out.println("l'Option est invalide\n");
                    break;
            }
        } while (choix != 7);
    }
}
