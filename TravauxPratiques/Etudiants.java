import java.util.Scanner;
import java.util.Random;

class Etudiants{
 public String nom;
 public String prenom;
 public String sexe;
 public String adresse;
 public String code;
 
 Etudiants etud[]=new Etudiants[3];
 Scanner scanner=new Scanner(System.in);
 
 void enregistrer(){
	 Etudiants et=new Etudiants();
   for(int i=0;i<etud.length;i++){
	   etud[i]=new Etudiants();
  do{
	  
   System.out.print("Nom:");
   etud[i].nom=scanner.nextLine();
  }while(etud[i].nom.isEmpty());
   do{
    System.out.print("Prenom:");
   etud[i].prenom=scanner.nextLine();
   }while(etud[i].prenom.isEmpty());
   do{
   System.out.print("Sexe(Masculin ou Feminin):");
   etud[i].sexe=scanner.nextLine();
   }while(!etud[i].sexe.equals("Masculin") && !etud[i].sexe.equals("Feminin"));
   System.out.print("Adresse:");
   etud[i].adresse=scanner.nextLine();
   Random r=new Random();
   String code=etud[i].nom.substring(0,1)+etud[i].prenom.substring(0,1)
   +"-"+r.nextInt(100,999);
   etud[i].code=code.toUpperCase();
   System.out.println("------------------------------------------------");
   }
 }

   // affichage des etudiants du tableau
 void afficher(){
	  for(int i=0;i<etud.length;i++){
		System.out.println("Code    :"+etud[i].code);
		System.out.println("Nom    :"+etud[i].nom);
		System.out.println("Prenom    :"+etud[i].prenom);
		System.out.println("Sexe    :"+etud[i].sexe);
		System.out.println("Adresse    :"+etud[i].adresse);
		System.out.println("--------------------------------------------------");
	  }
		}
public static void main(String a[]){
	Etudiants et=new Etudiants();
	et.enregistrer();
	et.afficher();
 }
}