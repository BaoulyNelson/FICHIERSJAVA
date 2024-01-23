import java.util.Scanner;
class Calculatrice3{
	public static void main(String a[]){
		Scanner sc=new Scanner(System.in);
		// declaration des variables
		 double nombre1,nombre2;
		 char choix;
		 System.out.println("+:Addition");
		 System.out.println("-:Soustraction");
		 System.out.println("*:Multiplication");
		 System.out.println("/:Division");
		 do{
		 System.out.print("Option choisie:");
		 choix=sc.nextLine().charAt(0);
		 }while(choix!='+' && choix!='-' && choix!='*' && choix!='/' );
		 System.out.print("Nombre 1:");
		 nombre1=sc.nextDouble();
		 System.out.print("Nombre 2:");
		 nombre2=sc.nextDouble();
		  // passage de la variable a la methode switch
		 switch(choix){
			  case '+':
			  System.out.println("La somme de "+nombre1+" et de "+nombre2+" est:"+(nombre1+nombre2));
               break;
              case '-':
			  System.out.println("La difference de "+nombre1+" et de "+nombre2+" est:"+(nombre1-nombre2));
               break;	
			  case '*':
			  System.out.println("Le produit de "+nombre1+" et de "+nombre2+" est:"+(nombre1*nombre2));
               break;	
			    case '/':
			  System.out.println("Le quotient de "+nombre1+" et de "+nombre2+" est:"+(nombre1/nombre2));
               break;
              default:
                    System.out.println("Il faut saisir une option du menu !");			  
		  }
		
	}
	
}