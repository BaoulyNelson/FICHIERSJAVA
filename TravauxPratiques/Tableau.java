import java.util.Scanner;
public class Tableau{
	
	public static void main(String a[]){
		int tabl[]=new int[10];
		int []tabl2={12,12,12,12,12,12,12,121,21};
		// affectation
		tabl[7]=100;
		System.out.println(tabl[7]);
		System.out.println(tabl2.length);
		Scanner sc=new Scanner(System.in);
		double tableau[]=new double[8];
		
		for(int i=0;i<tableau.length;i++){
		System.out.print("Valeur "+(i+1)+":");
		tableau[i]=sc.nextDouble();
		}
		double somme=0;
			for(int i=0;i<tableau.length;i++){
				if(tableau[i]%2==0){
				somme+=tableau[i];
				}
		System.out.print(tableau[i]+"\t");
		}
	
		
	}
}