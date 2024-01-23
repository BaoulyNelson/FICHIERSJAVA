import java.util.Scanner;

public class Generateur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la force électromotrice : ");
        double forceElectromotrice = scanner.nextDouble();
        System.out.print("Entrez la résistance intérieure : ");
        double resistanceInterieure = scanner.nextDouble();
        System.out.print("Entrez l'intensité : ");
        double intensite = scanner.nextDouble();

        double puissance = Math.pow(intensite, 2) * (forceElectromotrice - (resistanceInterieure * intensite));

        System.out.println("La puissance disponible est : " + puissance);
    }
}
