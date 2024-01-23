import java.util.Scanner;
public class Etudiant {
private String Nom;
private String Prenom;
private String Niveau;
private int Age;

public Etudiant(String nom,String prenom,String niveau, int age){
this.Nom=nom;
this.Prenom=prenom;
this.Niveau=niveau;
this.Age=age;
}

public static void afficher_Element() {
System.out.println("Nom " )     ;  
System.out.println("Prenom " )  ;  
System.out.println("Niveau " )  ;  
System.out.println("Age " )     ;  
}
//creation de l'objet 
public static void main(String[]args) {
    Scanner sc=new Scanner(System.in);
System.out.println("ENTRER Nom " ) ;  
String Nom=sc.nextLine();
System.out.println("ENTRER Prenom " ) ; 
String Prenom=sc.nextLine();
System.out.println("ENTRER Niveau " ) ; 
String Niveau=sc.nextLine();
System.out.println("ENTRER Age " ) ; 
String Age=sc.nextLine(); 
//Etudiant etudiant= new Etudiant("Nelson","Baouly","L3",24);
 afficher_Element();
}
}
