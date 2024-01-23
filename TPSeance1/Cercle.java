import java.util.Scanner;

public class Cercle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le diamètre du cercle : ");
        double diametre = scanner.nextDouble();

        double rayon = diametre / 2;
        double surface = Math.PI * Math.pow(rayon, 2);

        System.out.println("La surface du cercle est : " + surface);
    }
}
