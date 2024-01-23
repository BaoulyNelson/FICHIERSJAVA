


import java.util.Scanner;
class Conditions{
    public static void main(String args[]){
        float a,b;
        Scanner pratique=new Scanner(System.in);
        System.out.println("Entrer un nombre qui est 24");
        a=pratique.nextInt();
        System.out.println("Entrer un autre  nombre qui est 24");
        b=pratique.nextInt();
        // exemple pour une valeur de type booleean
         
         if(a==24 && b==24){
            System.out.println(" Les valeurs sont reelles");
         }
         else{
         System.out.println(" Les valeurs ne sont pas equivalentes");}
        // System.out.println("Cette valeur est :"+a);
    }
}