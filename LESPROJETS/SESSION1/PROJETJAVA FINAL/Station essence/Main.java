import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String carburant="";
        System.out.println();
        Station station = new Station("null", 0.0, 0.0);
        Commande commande = new Commande(0, 0, 0, null, '0');
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        do {
            System.out.println("de 1 a 4,pour toutes les stations\net de 5 a 9 pour la commande\n");
            System.out.println("1 pour enregistrer toutes les stations");
            System.out.println("2 pour modifier quantité de gallon de \ngazoline et/ou de Diesel d'une station");
            System.out.println("3 pour afficher toutes les stations");
            System.out.println("4 afficher la station ayant le plus et le moins de carburant");
            System.out.println("5 commander quantite gazoline");
            System.out.println("6 commander quantite diesel");
            System.out.println("7 afficher pourcentage d'utilisation");
            System.out.println("8 enregistrer commende");
            System.out.println("9 demander une confirmation");
            System.out.print("choix: ");
            choix = sc.nextInt();
            System.out.println();
            switch (choix) {
                case 1:
                    station.enregistrerStation();
                    break;
                case 2:
                    station.modifierQuantiteEssence();
                    break;
                case 3:
                    station.afficherStation();
                    break;
                case 4:
                    station.stationPluspetit("");                 
                    break;
                case 5:
                    commande.calculerQuantiteGazoline(null);
                    break;
                case 6:
                    commande.calculerQuantiteDiesel(null);
                    break;
                case 7:
                    commande.afficherPourcentageUtilisation(null);
                    break;
                case 8:
                    commande.enregistrerCommande();
                    break;
                case 9:
                    commande.demanderConfirmation(null);
                    break;
                case 10:
                    System.out.println("mauvais choix:");
                    break;
                default:
                    break;
            }

        } while (choix < 11);
    }

}
