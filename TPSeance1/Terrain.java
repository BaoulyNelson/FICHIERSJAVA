import java.util.Scanner;

public class Terrain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la longueur du premier rectangle : ");
        double longueur1 = scanner.nextDouble();
        System.out.print("Entrez la largeur du premier rectangle : ");
        double largeur1 = scanner.nextDouble();

        System.out.print("Entrez la longueur du deuxième rectangle : ");
        double longueur2 = scanner.nextDouble();
        System.out.print("Entrez la largeur du deuxième rectangle : ");
        double largeur2 = scanner.nextDouble();

        System.out.print("Entrez le diamètre du premier cercle : ");
        double diametre1 = scanner.nextDouble();

        System.out.print("Entrez le diamètre du deuxième cercle : ");
        double diametre2 = scanner.nextDouble();

        double surfaceRectangle1 = longueur1 * largeur1;
        double surfaceRectangle2 = longueur2 * largeur2;

        double rayon1 = diametre1 / 2;
        double surfaceCercle1 = Math.PI * Math.pow(rayon1, 2);

        double rayon2 = diametre2 / 2;
        double surfaceCercle2 = Math.PI * Math.pow(rayon2, 2);

        double surfaceTotale = surfaceRectangle1 + surfaceRectangle2 + surfaceCercle1 + surfaceCercle2;

        System.out.println("La surface totale du terrain est : " + surfaceTotale);
    }
}
