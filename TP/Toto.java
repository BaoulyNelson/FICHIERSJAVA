import java.util.Scanner;

public class Toto {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Baouly baouly = new Baouly();
        baouly.compterChaine();
        baouly.compterRedondance();
    }

    static class Baouly {
        public String compterChaine() {
            int compteur = 0;
            System.out.print("Entrer une chaîne : ");
            String chaine = sc.nextLine();

            for (int i = 0; i < chaine.length(); i++) {
                // Utiliser equals pour comparer les chaînes
                if (!Character.isWhitespace(chaine.charAt(i))) {
                    compteur++;
                }
            }
            return "Cette chaîne a " + compteur+ "caractères non vides.";
        }

        public void compterRedondance() {
            String chaine = compterChaine();
            int compteur = 1;
        
            for (int i = 0; i < chaine.length() - 1; i++) {
                if (chaine.charAt(i) == chaine.charAt(i + 1)) {
                    compteur++;
                } else {
                    if (compteur > 1) {
                        System.out.println(" " + chaine.charAt(i) + "' se répète " + compteur + " fois.");
                    }
                    compteur = 1;
                }
            }
        
            if (compteur > 1) {
                System.out.println(" " + chaine.charAt(chaine.length() - 1) + " se répète " + compteur + " fois.");
            }
        }
    }        

}
