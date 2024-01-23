import java.util.Scanner;
class Augmentation{
	
	
	public static void main(String a[]){
      String nom,prenom,grade,ministere;
      double salaire=0;
      int anciennete=0;
      Scanner sc=new Scanner(System.in);
	  do{
      System.out.print("Nom :");
	  nom=sc.nextLine();
	  }while(nom==null);
	  System.out.print("Prenom :");
	  prenom=sc.nextLine();
	  do{
	  System.out.print("Grade(Licence,Maitrise,Doctorat):");
	  grade=sc.nextLine();
	  }while(!grade.equalsIgnoreCase("Licence") && !grade.equalsIgnoreCase("Maitrise") && !grade.equalsIgnoreCase("Doctorat"));
	  System.out.print("Ministere :");
	  ministere=sc.nextLine();
	  do{
	  System.out.print("Salaire :");
	  salaire=sc.nextDouble();
	  }while(salaire<=0 && salaire>100000);
	    do{
	  System.out.print("Anciennete :");
		anciennete=sc.nextInt();
		}while(anciennete<=0 && anciennete>=5);
	  
	}
	
}