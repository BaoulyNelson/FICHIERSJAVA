import java.util.Scanner;

public class Exercice1 {
    public static void main(String[] args) {
        // a. Demander la saisie d'une phrase
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir une phrase : ");
        String phrase = scanner.nextLine();

        // b. Afficher la phrase en majuscules
        String phraseMajuscules = phrase.toUpperCase();
        System.out.println("Phrase en majuscules : " + phraseMajuscules);

        // c. Compter le nombre de 'a' dans la phrase et transformer les 'a' en '*'
        int compteurA = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == 'a') {
                compteurA++;
                
            }
        }
        System.out.println("il ya "+compteurA +" a dans cette phrases");

        if (compteurA > 0) {
            String phraseModifiee = phrase.replace('a', '*');
            System.out.println("Phrase modifiée : " + phraseModifiee);
        } else {
            System.out.println("Il n'y a pas de 'a' dans la phrase.");
        }

        // d. Tester si une séquence de caractères saisie se trouve entre le cinquième et le douzième caractère
        System.out.print("Veuillez saisir une séquence de caractères à rechercher : ");
        String sequence = scanner.nextLine();

        if (phrase.length() >= 12) {
            String sousPhrase = phrase.substring(4, 12);
            if (sousPhrase.contains(sequence)) {
                System.out.println("La séquence " + sequence + " se trouve entre le cinquième et le douzième caractère.");
            } else {
                System.out.println("La séquence " + sequence + " ne se trouve pas entre le cinquième et le douzième caractère.");
            }
        } else {
            System.out.println("La phrase est trop courte pour effectuer la recherche.");
        }

        scanner.close();
    }
}
