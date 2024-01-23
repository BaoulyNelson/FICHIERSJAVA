import static java.lang.System.out;
import java.util.Scanner;
class Condition{
	public static void main(String args[]){
		byte age;
		Scanner sc=new Scanner(System.in);
		out.print("Saisir l'ge de la personne:");
		age=sc.nextByte();
		// tester l'age de la personne
		if(age==0)
		   out.println("Bebe");
        else{
			if(age<=11)
			   out.println("Enfants");
		    else{
				if(age<18)
			    out.println("Adolescents");
			    else{
					if(age<35)
			         out.println("Jeunes");
			        else{
					if(age<=60)
			         out.println("Adultes");
			         else
						out.println("Vieillard");
			 		}
				}
		    
			}
        
		}	   
		
		
		
		}
}