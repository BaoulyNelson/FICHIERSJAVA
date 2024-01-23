import java.util.Scanner;
class Calculatrice{
	
	public static void main(String a[]){
	 Scanner sc=new Scanner(System.in);
	 double nombre1,nombre2;
	 char choix;
	  System.out.println("+:Addition");
	  System.out.println("-:Soustration");
	  System.out.println("*:Multiplication");
	  System.out.println("/:Division");
	  System.out.print("Operation a effectuer:");
	  choix=sc.nextLine().charAt(0);
	  System.out.print("Nombre 1:");
	  nombre1=sc.nextDouble();
	  System.out.print("Nombre 2:");
	  nombre2=sc.nextDouble();
	 switch(choix){
		  case '+':
		  System.out.println("La somme de "+nombre1+" et de "+nombre2+" est egale a:"+(nombre1+nombre2));
		  break;
		  case '-':
		  System.out.println("La difference entre "+nombre1+" et de "+nombre2+" est egale a:"+(nombre1-nombre2));
		  break;
		  case '*':
		  System.out.println("Le produit de "+nombre1+" et de "+nombre2+" est egal a:"+(nombre1*nombre2));
		  break;
		  case '/':
		  System.out.println("Le quotient de "+nombre1+" et de "+nombre2+" est egal a:"+(nombre1/nombre2));
		  break;
		  default:
		  System.out.println("Il faut saisir une option du menu");
		  break;
	  }
		
	}
}