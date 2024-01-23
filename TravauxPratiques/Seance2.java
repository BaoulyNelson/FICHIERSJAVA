// Action de saisir par l'utilisateur avec la methode scanner
import java.util.Scanner;
class Clavensky{
    public static void main(String args[]){
    System.out.println("======= INFORMATIONS CONCUES POUR UN EMPLOYE ========");
    // Declaration de l'ensemble des variables.

     String  nomComplet, sexe, adresse;
     short age;
     double salaire;

    // Creation d'une instance de scanner
    Scanner sc=new Scanner(System.in);
    // saisir nom
    System.out.print("SAISIR TON NOM COMPLET        : ");
    // Espace de stockage ppour le nom.
    nomComplet=sc.nextLine();
    // Saisir le sexe de l'employee
    System.out.print("ENTRER VOTRE SEXE (Masc / Fem): ");
    //Espace de stockage pour le nom
    sexe=sc.nextLine();
    // Saisir votre adresse
    System.out.print("VOTRE ADRESSE SVP             : ");
    //Espace de stockage pour l'adresse
    adresse=sc.nextLine();
    // Saisir votre age svp
    System.out.print("ENTRER VOTRE AGE SVP          : ");
    // Espace de stockage pour l'age;
    age=sc.nextShort();
    // Saisir le salaire de l'employee
    System.out.print("ENTRER VOTRE SALAIRE ICI      : ");
    // Esppace de stockage du salaire de l'employee.
    salaire=sc.nextDouble();

    // affichage du resultat

    System.out.println(" ___________________ VOICI LE RESULTAT OBTENU __________________ ");
    System.out.println("Le nom Complet est          : " +nomComplet);
    System.out.println("le sexe est(Masc / Fem) est : " +sexe);
    System.out.println("L'adresse de l'employee est : " +adresse);
    System.out.println("L'age de l'employee est     : " +age+ "An(s)");
    System.out.println("Le salaire de lemployee est : " +salaire+ "Gourdes");


    }
}