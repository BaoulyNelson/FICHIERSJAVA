// importation de la classe Scanner
import java.util.Scanner;

class Employes{
	
	public static void main(String a[]){
     String nomComplet,sexe,adresse;
     short age;
     double salaire;
	 // creation d'une instance de Scanner
	 Scanner sc=new Scanner(System.in);
	 // saisir le nom complet de l'employe
     System.out.print("Nom complet:");
	 // stocker la valeur saisi dans la variable nomComplet
	 nomComplet=sc.nextLine();
	 System.out.print("Sexe(Masculin/Feminin):");
	 // stocker la valeur saisi dans la variable sexe
	 sexe=sc.nextLine();
	 System.out.print("Adresse:");
	 // stocker la valeur saisi dans la variable adresse
	 adresse=sc.nextLine();
	 System.out.print("Age:");
	 // stocker la valeur saisi dans la variable age
	 age=sc.nextShort();
	 System.out.print("Salaire:");
	 // stocker la valeur saisi dans la variable salaire
	 salaire=sc.nextDouble();
	 System.out.println("------------------Affichage--------:");
	  System.out.println("Nom complet:"+nomComplet);
	  System.out.println("Sexe:"+sexe);
	  System.out.println("Adresse:"+adresse);
	  System.out.println("Age:"+age+" an(s)");
	  System.out.println("Salaire:"+salaire+" Gourde(s)");
	}
}