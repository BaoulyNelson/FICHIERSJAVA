import java.util.Scanner;

public class Nombre3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre : ");
        int nombre = scanner.nextInt();

        if (nombre % 5 == 0 && nombre % 7 == 0) {
            System.out.println("Le nombre est divisible par 5 et par 7.");
            System.out.println("10 diviseurs de 5 et de 7 : ");
            for (int i = 1; i <= 10; i++) {
                System.out.println(i * 5 + " et " + i * 7);
            }
        } else if (nombre % 5 == 0) {
            System.out.println("Le nombre est divisible seulement par 5.");
        } else if (nombre % 7 == 0) {
            System.out.println("Le nombre est divisible seulement par 7.");
        } else {
            System.out.println("Le nombre n'est divisible ni par 5 ni par 7.");
        }
    }
}
