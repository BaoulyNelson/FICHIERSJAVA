import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class JeuDeRoulette {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> scores = chargerScores();

        while (true) {
            System.out.println("Bienvenue à la Roulette!");
            System.out.print("Entrez votre pseudo (sans espaces et en minuscules) ou 'K' pour quitter: ");
            String pseudo = scanner.nextLine().trim();

            if (pseudo.equalsIgnoreCase("K")) {
                break;
            }

            int minPlage = 0;
            int maxPlage = 100;
            int numeroSecret = ThreadLocalRandom.current().nextInt(minPlage, maxPlage + 1);
            int tentatives = maxPlage / 3; // Nombre d'essais, par exemple, 30 essais pour un intervalle de 0-100

            System.out.println("Bienvenue, " + pseudo + "! Devinez le numéro secret entre " + minPlage + " et " + maxPlage + ".");

            while (tentatives > 0) {
                System.out.print("Entrez un nombre: ");
                int choixUtilisateur = scanner.nextInt();

                if (choixUtilisateur < minPlage || choixUtilisateur > maxPlage) {
                    System.out.println("Nombre en dehors de l'intervalle.");
                } else if (choixUtilisateur < numeroSecret) {
                    System.out.println("Trop bas. Il vous reste " + tentatives + " essais.");
                } else if (choixUtilisateur > numeroSecret) {
                    System.out.println("Trop élevé. Il vous reste " + tentatives + " essais.");
                } else {
                    int score = tentatives * 30;
                    System.out.println("BRAVO! Le numéro secret était " + numeroSecret + ". Votre score est " + score);
                    mettreAJourScore(pseudo, scores, score);
                    break;
                }

                tentatives--;
            }

            if (tentatives <= 0) {
                System.out.println("Vous avez perdu. Le numéro secret était " + numeroSecret + ".");
            }
        }

        sauvegarderScores(scores);
        System.out.println("Au revoir!");
    }

    private static HashMap<String, Integer> chargerScores() {
        try {
            FileInputStream fis = new FileInputStream("scores.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String, Integer> scores = (HashMap<String, Integer>) ois.readObject();
            ois.close();
            fis.close();
            return scores;
        } catch (Exception e) {
            return new HashMap<String, Integer>();
        }
    }

    private static void sauvegarderScores(HashMap<String, Integer> scores) {
        try {
            FileOutputStream fos = new FileOutputStream("scores.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(scores);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mettreAJourScore(String pseudo, HashMap<String, Integer> scores, int nouveauScore) {
        if (scores.containsKey(pseudo)) {
            int ancienScore = scores.get(pseudo);
            int scoreTotal = ancienScore + nouveauScore;
            scores.put(pseudo, scoreTotal);
        } else {
            scores.put(pseudo, nouveauScore);
        }
    }
}
