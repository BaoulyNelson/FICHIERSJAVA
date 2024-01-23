import java.util.Scanner;
public class Tableau2{
	
	public static void main(String a[]){
		int tabl[][]=new int[3][4];
		int [][]tabl2={
			          {3,3,3,3,3},
					  {3,35,0,5,35},
					  {2,2,2,2,2},
					  {2,4,3,3,3},
		            };
		// affectation
		tabl2[1][2]=100;
		System.out.println(tabl[1][2]);
		System.out.println(tabl2.length);
		System.out.println(tabl2[0].length);
	    System.out.println(+(tabl2.length*tabl2[0].length));
		
		Scanner sc=new Scanner(System.in);
		double tableau[][]=new double[2][3];
		
		for(int i=0;i<tableau.length;i++){
			for(int j=0;j<tableau[i].length;j++){
		
		System.out.print("Valeur ["+(i+1)+","+(j+1)+"]:");
		tableau[i][j]=sc.nextDouble();
		}
		}
			for(int i=0;i<tableau.length;i++){
				for(int j=0;j<tableau[i].length;j++){
		System.out.print(tableau[i][j]+"\t");
		}
		System.out.println("");
	    }
		
	}
}