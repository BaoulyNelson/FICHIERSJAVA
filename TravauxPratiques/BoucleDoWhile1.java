class BoucleDoWhile1 {
	public static void main(String a[]) {
		int produit = 1;
		short somme = 0;
		int i = 1;
		do {
			if (i % 2 == 0)
				somme += i;
			else
				produit *= i;
			i++;
		} while (i <= 20);
		System.out.println("La somme est:" + somme);
		System.out.println("Le produit est:" + produit);


	}
}
