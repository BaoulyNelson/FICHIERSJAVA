import java.util.Scanner;
class Tableau4{
	public static void main(String a[]){
		Scanner scanner=new Scanner(System.in);
		int n;
		 do{
		 System.out.print("Taille du tableau:");
		 n=scanner.nextInt();
		 }while(n<5 || n>10);
		int tab[]=new int[n];
		for(int i=0;i<n;i++){
			System.out.print("Valeur "+(i+1)+":");
			tab[i]=scanner.nextInt();
		}
		int somme=0;
		for(int i=0;i<n;i++){
			if(tab[i]%2==0){
				somme+=tab[i];
			}
		System.out.print(tab[i]+"\t");
		}
		System.out.println("");
		System.out.println(somme);
		
	}
}