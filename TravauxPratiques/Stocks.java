import java.util.Scanner;
import java.util.Random;

class Produit {
	// Les attributs de la classe
	public String nomProd;
	public String catProd;
	public Double prixProd;
	public Double quantProd;
	public String codProd;

	// int n;

	Scanner scanner = new Scanner(System.in);
	Scanner scanner1 = new Scanner(System.in);

	Produit prod[] = new Produit[2];

	void enregistrer() {
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < prod.length; i++) {
			prod[i] = new Produit();

			System.out.print("Nom du produit: ");
			this.prod[i].nomProd = scanner.nextLine();

			System.out.print("Categorie du Produit: ");
			this.prod[i].catProd = scanner.nextLine();
			System.out.print("Prix du produit : ");
			this.prod[i].prixProd = scanner1.nextDouble();

			System.out.print("Quantite de Produits: ");
			this.prod[i].quantProd = scanner1.nextDouble();

			System.out.println("-------------------------------------------------------------------------");

			Random r = new Random();
			this.prod[i].codProd = prod[i].nomProd.substring(0, 1) + prod[i].catProd.substring(0, 1)
					+ r.nextInt(100, 999);
			// this.prod[i].codProd=codProd.toUpperCase();

		}

	}

	void afficher() {

		System.out.println("=======================Affichage des produit==================================;");
		for (int i = 0; i < prod.length; i++) {
			System.out.println("Code       :" + prod[i].codProd);
			System.out.println("Nom Produit:" + prod[i].nomProd);
			System.out.println("Categorie  :" + prod[i].catProd);
			System.out.println("Prix unit  :" + prod[i].prixProd + "gdes");
			System.out.println("Quantite   :" + prod[i].quantProd);
			System.out.println("===================================================");
		}
	}

	public static void main(String[] args) {
		Produit prod[] = new Produit[4];
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.println("Entrer la dimension de gestion des stoks de produits:");

		n = scanner.nextInt();

		Produit pr = new Produit();
		pr.enregistrer();
		pr.afficher();

	}

}