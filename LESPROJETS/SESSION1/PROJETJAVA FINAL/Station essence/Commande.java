import java.util.ArrayList;
import java.util.Scanner;

public class Commande {
    ArrayList<Station> stations = new ArrayList<Station>();
    ArrayList<Commande>commandes=new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private static int compteurId = 0;
    private int id;
    private double quantiteDiesel;
    private double quantiteGazoline;
    private String dateCommande;
    private char etat;

    public Commande(int id,double quantiteDiesel, double quantiteGazoline,String dateCommande,char etat ) {
        this.id = ++compteurId;
        this.quantiteDiesel = quantiteDiesel;
        this.quantiteGazoline = quantiteGazoline;
        this.dateCommande = dateCommande;
        this.etat = 'N';
    }
    
    
    public int getId() {
        return id;
    }

    public double getQuantiteDiesel() {
        return quantiteDiesel;
    }

    public double getQuantiteGazoline() {
        return quantiteGazoline;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

   
    public  double calculerQuantiteGazoline(ArrayList<Station> stations) {
        double totalGallonsManquants = 0;
        for (Station station : stations) {
            double capaciteGazoline = station.getCapaciteGazoline();
            double gallonsManquants = capaciteGazoline - getQuantiteDisponibleGazoline();
            if (gallonsManquants > 0) {
                totalGallonsManquants += gallonsManquants;
            }
        }
        System.out.println("le nombre de gallon de gazoline manquant est: "+1.25 * totalGallonsManquants);
        return 1.25 * totalGallonsManquants;
    }
    private int getQuantiteDisponibleGazoline() {
        return 0;
    }


    private int getCapaciteGazoline() {
        return 0;
    }


    public double calculerQuantiteDiesel(ArrayList<Station> stations) {
        double totalGallonsManquants = 0;
        for (Station station : stations) {
            double gallonsManquants = station.getCapaciteDiesel() - station.getQuantiteDisponibleDiesel();
            if (gallonsManquants > 0) {
                totalGallonsManquants += gallonsManquants;
            }
        }
        System.out.println("le nombre de gallon de gazoline manquant est: "+1.10 * totalGallonsManquants);
        return 1.10 * totalGallonsManquants;
    }

    public  void afficherPourcentageUtilisation(ArrayList<Station> stations) {
        for (Station station : stations) {
            System.out.println("Pourcentage d'utilisation de " + station.getNom() + ": "
                    + station.getPourcentageUtilisationDiesel() + "% diesel, "
                    + station.getPourcentageUtilisationGazoline() + "% gazoline");
        }
    }

    public void enregistrerCommande() {
        System.out.print("la date commande: ");
        dateCommande=sc.nextLine();
        // Calculer la quantité de gallons manquants de diesel et de gazoline pour toutes les stations
        double totalGallonsManquantsDiesel = 0.0;
        double totalGallonsManquantsGazoline = 0.0;
        for (Station station : stations) {
            double gallonsManquantsDiesel = station.getCapaciteDiesel() - station.getQuantiteDisponibleDiesel();
            double gallonsManquantsGazoline = station.getCapaciteGazoline() - station.getQuantiteDisponibleGazoline();
            if (gallonsManquantsDiesel > 0) {
                totalGallonsManquantsDiesel += gallonsManquantsDiesel;
                System.out.println(totalGallonsManquantsDiesel+ "gallons diesel");
            }
            if (gallonsManquantsGazoline > 0) {
                totalGallonsManquantsGazoline += gallonsManquantsGazoline;
                System.out.println(totalGallonsManquantsGazoline+ "gallons gazolines");
            }
        }
        
        // Calculer la quantité de gallons de diesel et de gazoline pour la nouvelle commande
        double quantiteGallonsDiesel = 1.10 * totalGallonsManquantsDiesel;
        double quantiteGallonsGazoline = 1.25 * totalGallonsManquantsGazoline;
        
        // Créer la nouvelle commande avec les quantités calculées et l'état "Nouvelle"
        Commande nouvelleCommande = new Commande(id++, quantiteGallonsDiesel, quantiteGallonsGazoline, getDateCommande(), 'N');
        
        // Ajouter la nouvelle commande à l'ArrayList de commandes
        commandes.add(nouvelleCommande);
        System.out.println("La commande a été enregistrée avec succès :");
        System.out.println(nouvelleCommande);
    }
    
    public char demanderConfirmation(String message) {
        System.out.print(message + " (o/n) : ");
        char reponse = sc.nextLine().charAt(0);
        while (reponse != 'o' && reponse != 'n') {
            System.out.print("Veuillez répondre par 'o' ou 'n'");
            reponse = sc.nextLine().charAt(0);
        }
        return reponse;
    }
    
    
}
