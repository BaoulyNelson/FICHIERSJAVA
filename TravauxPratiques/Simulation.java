import java.util.Scanner;
class Simulation{
   public static void main(String a[]){
	   int val=100;
	   /*System.out.println(val);
	   System.out.println(++val);//101
	   System.out.println(val);//101
	   System.out.println(val++);//101
	   System.out.println(++val);//103
	   String res=val>=100?"100":"Autre";
	   System.out.println(res);*/
	   
	   Scanner sc=new Scanner(System.in);
	   byte age;
	   System.out.print("Entrer l'age de la personne:");
	   age=sc.nextByte();
	   if(age>=18){
		 System.out.println("Majeur");
	     
	   }else{
		 System.out.println("Mineur");
	       
	   }
		   
	   
	   
	   
	   
	   
	   
   }
}