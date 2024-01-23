import java.util.Scanner;
public class TestMondial {
    public static void main(String args[]){
        // L'instance de Scanner
        Scanner pratique=new Scanner(System.in);
        int annee=0;
        // Declaration de variable
        System.out.println("[========== Programme permet de determiner s'il y aura de la coupe du monde ou s'il n'y avait pas ==========]");
        do{
            System.out.print("\t"+"Entrer une anne:");
            annee=pratique.nextInt();
               if(annee<1930){
                   System.out.println("-- Rentrer une annee qui n'est pas inferieur a 1930 ---");
               }
            }while(annee<1930);
        System.out.println();
        System.out.println("Entrer une annee");
        annee=pratique.nextInt();
        if(annee % 4 !=0){
            System.out.println("Il  n'a pas eu de la coupe du monde");
        }
        else if (annee % 100 !=0) { 
            System.out.println("Il y a");  
        }

        else {
                System.out.println("Desolee");
            }

        }
           

       

    }
    

