// importation du package Scanner
import java.util.Scanner;

class TP{
    public static void main(String a[]){
        // programme concue pour calculer et afficher le caree d'un nombre et le cube d'1 nombre
        // double nombre=0;
        double carree;
        double cubique;
        // Creation d'une instance de scanner
        Scanner source=new Scanner(System.in);
        // Epace de saisir 
        System.out.println("Entrer un nombre quelconque: ");
        // Stockage de la valeur
        carree=source.nextDouble();
        // cubique=source.nextDouble();
        cubique=Math.pow(carree,3);
        carree=(carree)*(carree);
        
        // Afficher
        System.out.println("Le caree de ce nombre est: " +carree);
        System.out.println("Le cube  de ce nombre est: " +cubique);

    }
}