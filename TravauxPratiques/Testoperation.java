//  Donner le choix de l’opération.
import java.util.Scanner;
import java.lang.System;

class Testoperation{
    public static void main(String args[]){

 System.out.println(""); 
 System.out.println(" ========= Bonjour ce petit programme vous permez d'effectuer des operations en choix ==========");

    float a,b,touche;
    
    Scanner pratique=new Scanner(System.in);
        System.out.print("Entrer le premier nombre svp -> ");
    a=pratique.nextFloat();
        System.out.print("Entrer le second nombre svp  -> ");
    b=pratique.nextFloat();

    System.out.println(""); 
    System.out.println("Tapez  un chiffre dans ce menu pour effectuer une operation sur ces 2 nombres :");
    
    System.out.println("   ===== 1 Pour la multiplication =====");
    System.out.println("   ===== 2 Pour l'addition        =====");
    System.out.println("   ===== 3 Pour la soustraction   =====");
    System.out.println("   ===== 4 Pour la division       =====");
    System.out.println("   =============== 10 Pour l'ensemble des operations ================");
    touche=pratique.nextFloat();

    if(touche==1){
        System.out.println(" === La multiplication de ces deux nombres est: ===== "+(a*b));
    }

    else if(touche==2){
        System.out.println(" === L'addition de ces deux nombres est: ===== "+(a+b));
    }   
                                      
    else if(touche==3){
         System.out.println(" === La soustraction de ces deux nombres est: ===== "+(a-b));
    } 
                

    else if(touche==4){
         System.out.println(" === La division de ces deux nombres est: ===== "+(a/b));
    }

    else if(touche==10){
         System.out.println(" ===== La multiplication de ces deux nombres est: ======= "+(a*b));
         System.out.println(" ===== L'addition de ces deux nombres est:        ======= "+(a+b));
         System.out.println(" ===== La soustraction de ces deux nombres est:   ======= "+(a-b));
         System.out.println(" ===== La division de ces deux nombres est:       ======= "+(a/b));
    }

    else{
        System.out.println(" ===== Aucune operation pour ce choix  =========");
        }

}  }