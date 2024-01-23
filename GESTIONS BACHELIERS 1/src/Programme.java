import java.util.ArrayList;
import java.util.Scanner;

public class Programme {
   
        public static void main(String[] args) {
            System.out.println();
            ArrayList<Bachelier> bacheliers = new ArrayList<>();
            ArrayList<ExamenBac> notesBac = new ArrayList<>();    
            Scanner scanner = new Scanner(System.in);
            ProgrammeBac programmeBac = new ProgrammeBac();
            
            while (true) {
                System.out.println("Menu :");
                System.out.println("1. Inscrire un bachelier");
                System.out.println("2. Enregistrer les notes d'un bachelier");
                System.out.println("3. Calculer la moyenne et déterminer le statut");
                System.out.println("4. Quitter");
                System.out.print(" choix: ");
    
                int choix = scanner.nextInt();
                System.out.println();
    
                switch (choix) {
                    case 1:
                        programmeBac.inscrireBachelier(scanner, bacheliers);
                        System.out.println();
                        break;
                    case 2:
                        programmeBac.enregistrerNotesBac(scanner, bacheliers, notesBac);
                        System.out.println();
                        break;
                    case 3:
                        programmeBac.calculerMoyenneEtStatut(bacheliers, notesBac);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Programme terminé.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            }
        }
    
}
