import java.util.Scanner;
class Tableau6{
	public static void main(String a[]){
		Scanner sc=new Scanner(System.in);
		int ligne,colonne;
		do{
		System.out.print("Nombre de ligne:");
		ligne=sc.nextInt();
		}while(ligne<=0 || ligne>3);
		do{
		System.out.print("Nombre de colonne:");
		colonne=sc.nextInt();
		}while(colonne<=0 || colonne>4);
		
		double tb[][]=new double[ligne][colonne];
		for(int i=0;i<ligne;i++){
			for(int j=0;j<colonne;j++){
				System.out.print("Valeur["+(i+1)+","+(j+1)+"]:");
				 tb[i][j]=sc.nextDouble();
			}
		}
		for(int i=0;i<ligne;i++){
			for(int j=0;j<colonne;j++){
				System.out.print(tb[i][j]+"\t");
			}
		System.out.println("");
			
			
		}
	}
}