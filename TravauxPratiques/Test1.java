
// Premier programme en java
 class Clavens{
    public static void main(String args[]){
        System.out.println();
        System.out.println("======== Bonjour les javaristes =========");
        // Declaration de variable
        int a=50; int b=100;
        double division=(double)a/b;
        double racine=Math.sqrt(b);
        double puissance=Math.pow(b,3);
        System.out.println();
        // Affichage des resultats;

        System.out.println("La somme de" +a+ "+" +b+ " est      : " +(a+b));
        System.out.println("Le produit de" +a+ "*" +b+ " est    : " +(a*b));
        System.out.println("La Division de" +a+ "/" +b+ " est   : " +division);
        System.out.println("La Difference de" +a+ "-" +b+ " est : " +(a-b));
        System.out.println("Le Modulo de" +b+ "%" +a+ " est     : " +(a%b));
        System.out.println("La Racine du second nombre est      : " +racine);
        System.out.println("La Puissance du second nombre est   : " +puissance);
        
    }
}

