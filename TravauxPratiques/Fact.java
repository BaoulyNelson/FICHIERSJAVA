import java.util.Scanner;

public class Fact{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre entier positif : ");
        int n = scanner.nextInt();
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
            System.out.println("La factorielle de " + n + " est " + fact);
        }
        }
    

