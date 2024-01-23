import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Veuillez entrer votre code PIN (4 chiffres) : ");
            String pin = scanner.nextLine();

            if (estPinValide(pin)) {
                System.out.println("Code PIN valide enregistré avec succès !");
                break;
            } else {
                System.out.println("Le code PIN n'est pas valide. Veuillez réessayer.");
            }
        }
    }

    // Fonction pour vérifier si un code PIN est valide
    public static boolean estPinValide(String pi) {
        // Vérifiez d'abord si la longueur du code PIN est de 4 chiffres
        if (pi.length() != 4) {
            return false;
        }

        // Ensuite, vérifiez si tous les caractères du code PIN sont des chiffres
        for (char c : pi.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Si le code PIN satisfait à toutes les conditions, il est considéré comme valide
        return true;
    }
}
