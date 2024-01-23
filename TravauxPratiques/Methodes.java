import java.util.Scanner;
public class Methodes {
    // Ici on va parler de methode: Une methode c'st un nom qu'on donne a une fonction en POO

    /* NB: methode yo dwe kreye endedan klas lan, pa andedan fonksyon main nan.
         Wap jus rele methode lan andedan  fonksyon main nan */
    
    // Creation de ma premiere methode appeller Bienvenue qui reourne rien.
    public static void Bienvenue(){
    // Instance de la classe Scanner
    Scanner s=new Scanner(System.in);
     String nom; int age;
        System.out.println("Entrer votre nom");
        nom=s.nextLine();
        // Saisir l'age
     do{
        System.out.println("Entrer votre age");
        age=s.nextInt();
        if(age<18 || age>40){
            System.out.println("Re-entrer afin d'etre eligible");
        }
     }while(age<18 || age>40);
     System.out.println("Vous etes: "+nom+ ","+"Vous avez: "+age);
    }

    // Nou pral kreye yon methode ki genyen yon tip de retou
    public static  int Bienvenue2(){
        return 20;
    }
    // Parammettre pou yon methode: koman pou nou bay yon methode ki pap retounen anyen parammettre!
    public static void methodeparamettre(String message){
        System.out.println("Bonjour le monde");
    }
    // Parammettre pou yon methode: koman pou nou bay yon methode ki ap retounen parammettre!
    public static String methodeparammettre_retour(String message){// Nou kreye methode lan nou toubali parammettre lan
        System.out.println(message);

        return message;
    }
    public static void main(String args[]){
        // int valeur;
        // System.out.println(Bienvenue2());
        Bienvenue(); // isia nou rele methode lan pou li kpb afiche pou nou sa nou t dil fe a.
        Bienvenue2(); // isia nou rele dezyem methode lan, li gen tip de retou.
        methodeparamettre("Bonjour");
        String messageBienvenue=methodeparammettre_retour("message");
        // mw kape nan 20:12 minit

        

    }
    
}
