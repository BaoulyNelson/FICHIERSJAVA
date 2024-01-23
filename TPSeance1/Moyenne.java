import java.util.Scanner;

public class Moyenne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la note en mathématiques : ");
        double math = scanner.nextDouble();
        System.out.print("Entrez la note en physique : ");
        double physique = scanner.nextDouble();
        System.out.print("Entrez la note en HTML/CSS : ");
        double htmlCss = scanner.nextDouble();
        System.out.print("Entrez la note en base de données : ");
        double bdd = scanner.nextDouble();

        double moyenne = (math + physique + htmlCss + (bdd / 100) * 300) / 4;

        System.out.println("La moyenne de l'étudiant est : " + moyenne);
    }
}
