import java.util.Scanner;
class BoucleContinue1{
	public static void main(String a[]){
		Scanner sc=new Scanner(System.in);
	  int i=0;
	  int x;
	 do{		  
		 System.out.println("Nombre "+(i+1)+":");
		 x=sc.nextInt();
		 if(x%7==0){
			  System.out.println("continuite de la boucle");
			 continue;
		 }
		 System.out.println(x);
		 i++;
	}while(i<10);
		
		
	}
}
