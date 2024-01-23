// importation de la classe Scanner
import java.util.Scanner;

public class Informations{
	public static void main(String a[]){
	 String nomComplet,adresse;
     double salaire;
     int age;
     // Creation d'une instance de Scanner
	 Scanner sc=new Scanner(System.in);
	 System.out.print("Nom complet:");
	 // Saisir le nom avec la methode nextLine
	 nomComplet=sc.nextLine();
	 System.out.print("Adresse:");
	 // Saisir l'adresse avec la methode nextLine
	 adresse=sc.nextLine();
	 System.out.print("Salaire:");
	 // Saisir le salaire avec la methode nextDouble
	 salaire=sc.nextDouble();
	 System.out.print("Age:");
	 // Saisir l'age avec la methode nextInt
	 age=sc.nextInt();
	 System.out.println("----------------Affichage-----------");
	 System.out.println("Nom complet:"+nomComplet);
	 System.out.println("Adresse    :"+adresse);
	 System.out.println("Salaire    :"+salaire+" Gourde(s)");
	 System.out.println("Age        :"+age+" an(s)");	
	}
	
}