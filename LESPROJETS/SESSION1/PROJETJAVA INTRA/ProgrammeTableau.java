import java.util.Scanner;

public class ProgrammeTableau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez la taille du tableau (compris entre 3 et 7) : ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne
        
        if (n < 3 || n > 7) {
            System.out.println("Taille de tableau invalide. Le programme se termine.");
            return;
        }
        
        double[] tableau = new double[n];
        
        // Saisie des éléments du tableau
        for (int i = 0; i < n; i++) {
            System.out.print("Entrez un nombre réel : ");
            tableau[i] = scanner.nextDouble();
            scanner.nextLine(); // Consommer le saut de ligne
        }
        
        System.out.println("Les éléments du tableau sont :");
        afficherTableau(tableau);
        
        System.out.println("Les 3 derniers éléments du tableau en ordre décroissant :");
        afficherDerniersElements(tableau);
        
        System.out.print("Entrez un nombre réel : ");
        double nombre = scanner.nextDouble();
        scanner.nextLine(); // Consommer le saut de ligne
        
        if (nombre > 3) {
            System.out.println("Les 3 premiers nombres avant " + nombre + " sont :");
            afficherTroisPremiersAvant(tableau, nombre);
        }
        
        double plusGrand = trouverPlusGrand(tableau);
        double plusPetit = trouverPlusPetit(tableau);
        
        System.out.println("Le plus grand nombre du tableau est : " + plusGrand);
        System.out.println("Le plus petit nombre du tableau est : " + plusPetit);
        
        scanner.close();
    }
    
    public static void afficherTableau(double[] tableau) {
        for (double nombre : tableau) {
            System.out.println(nombre);
        }
    }
    
    public static void afficherDerniersElements(double[] tableau) {
        int startIndex = Math.max(tableau.length - 3, 0);
        
        for (int i = startIndex; i < tableau.length; i++) {
            System.out.println(tableau[i]);
        }
    }
    
    public static void afficherTroisPremiersAvant(double[] tableau, double nombre) {
        int position = -1;
        
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == nombre) {
                position = i;
                break;
            }
        }
        
        if (position > 3) {
            int startIndex = Math.max(position - 3, 0);
            
            for (int i = startIndex; i < position; i++) {
                System.out.println(tableau[i]);
            }
        }
    }
    
    public static double trouverPlusGrand(double[] tableau) {
        double plusGrand = tableau[0];
        
        for (int i = 1; i < tableau.length; i++) {
            if (tableau[i] > plusGrand) {
                plusGrand = tableau[i];
            }
        }
        
        return plusGrand;
    }
    
    public static double trouverPlusPetit(double[] tableau) {
        double plusPetit = tableau[0];
        
        for (int i = 1; i < tableau.length; i++) {
            if (tableau[i] < plusPetit) {
                plusPetit = tableau[i];
            }
        }
        
        return plusPetit;
    }
}
