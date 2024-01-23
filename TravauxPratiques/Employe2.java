//nomComplet:String, adresse=String,age=short, 
//salaire=double
// importation de la classe Scanner
import java.util.Scanner;

class Employe2{
	public static void main(String a[]){
    // Declaration des variables   
    String nomComplet,adresse;
    short age;
    double salaire;
   	// creation d'une instance de Scanner
     Scanner scanner=new Scanner(System.in);
    System.out.print("Nom complet:");
	// saisir le complet
	nomComplet=scanner.nextLine();
	System.out.print("Adresse:");
	// saisir l'adresse
	adresse=scanner.nextLine();	
	System.out.print("Age:");
	// saisir l'age
	age=scanner.nextShort();
	System.out.print("Salaire:");
	// saisir le salaire
	salaire=scanner.nextDouble();
	
	System.out.println("---------------------Affichage-------------------");
	System.out.println("Nom complet:"+nomComplet);
	System.out.println("Adresse:"+adresse);
	System.out.println("Age:"+age+" an(s)");
	System.out.println("Salaire:"+salaire+" dollar(s)");
	
	
	

	
	
	
	}
}

