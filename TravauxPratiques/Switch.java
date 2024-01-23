import java.util.Scanner;
import java.lang.System;
class Switch{
    public static void main(String args[])
    {
        int jour;
      // iNstance dela classe scanner
      Scanner pratique=new Scanner(System.in);
      System.out.println();
      System.out.println(" ------------------ Entrer le numero du jour de la semaine -------------------");
      System.out.println(" ------------------ 1 pour Dimanche ------------------- ");
      System.out.println(" ------------------ 2 pour Lundi ---------------------- ");
      System.out.println(" ------------------ 3 pour Mardi ---------------------- ");
      System.out.println(" ------------------ 4 pour Mercredi ------------------- ");
      System.out.println(" ------------------ 5 pour Jeudi ---------------------- ");
      System.out.println(" ------------------ 6 pour Vendredi ------------------- ");
      System.out.println(" ------------------ 7 pour Samedi --------------------- ");

      jour=pratique.nextInt();

      switch(jour){
        case(1):
        System.out.println(" ====== Le premier jour est: Dimanche ======= ");
        break;

        case(2):
        System.out.println(" ===== Le deuxieme jour est: Lundi ========== ");
        break;

        case(3):
        System.out.println(" ===== La troisieme jour est: Mardi ========= ");
        break;

        case(4):
        System.out.println(" ===== La quatrieme jour est Mercredi ======= ");
        break;

        case(5):
        System.out.println(" ===== Le cinquieme jour est Jeudi ========== ");
        break;  

        case(6):
        System.out.println(" ===== Le sixieme jour est Vendredi ========= ");
        break;

        case(7):
        System.out.println(" ===== Le Septieme jour est Samedi ========= ");
        break;

        default:
        System.out.println(" ------------- Ce numero ne correspond pas avec les jours de la semaine ---------------");        

      }


    }}