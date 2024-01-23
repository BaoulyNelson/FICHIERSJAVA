import java.util.Scanner;

public class Supermache {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du premier produit : ");
        String nomProduit1 = scanner.nextLine();
        System.out.print("Entrez le prix unitaire du premier produit : ");
        double prixProduit1 = scanner.nextDouble();
        System.out.print("Entrez la quantité achetée du premier produit : ");
        int quantiteProduit1 = scanner.nextInt();

        System.out.print("Entrez le nom du deuxième produit : ");
        scanner.nextLine(); // Lire la nouvelle ligne après la saisie de quantiteProduit1
        String nomProduit2 = scanner.nextLine();
        System.out.print("Entrez le prix unitaire du deuxième produit : ");
        double prixProduit2 = scanner.nextDouble();
        System.out.print("Entrez la quantité achetée du deuxième produit : ");
        int quantiteProduit2 = scanner.nextInt();

        double montantTotal = (prixProduit1 * quantiteProduit1) + (prixProduit2 * quantiteProduit2);
        double rabais = 0.055 * montantTotal;
        double montantFinal = montantTotal - rabais;

        System.out.println("Montant total de l'achat : " + montantTotal);
        System.out.println("Rabais : " + rabais);
        System.out.println("Montant final à payer : " + montantFinal);
    }
}
