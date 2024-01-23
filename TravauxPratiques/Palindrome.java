import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez une chaîne de caractères : ");
        String chaine = sc.nextLine();

        String inverse = new StringBuilder(chaine).reverse().toString();

        if (chaine.equals(inverse)) {
            System.out.println(chaine + " est un palindrome.");
        } else {
            System.out.println(chaine + " n'est pas un palindrome.");
        }
    }
}
