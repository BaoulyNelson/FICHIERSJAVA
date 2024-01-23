import java.util.Scanner;

class TPCONDITIONS{
    public static void main(String a[]){
        
        // Creation d'une instance de scanner
        Scanner source=new Scanner(System.in);
        int n1,n2;
        // Epace de saisir 
        System.out.println(" =====================ENTRER UN NOMBRE QUELCONQUE =======================: ");
        n1=source.nextInt();
        if(n1>0){
            System.out.println(" Le nombre est " +n1 + "et est positif ======="); 
        }
        else{
            System.out.println(" Ce nombre est negatif ou nul!!! ");
        }
    }
}