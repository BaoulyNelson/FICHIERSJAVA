import java.util.ArrayList;
import java.util.Scanner;

public class Station {
    ArrayList<Station> stations = new ArrayList<Station>();
    Scanner sc = new Scanner(System.in);
    private String nom;

    private double capaciteGazoline;
    private double pourcentageUtilisationGazoline;
    private double capaciteDiesel;
    private double pourcentageUtilisationDiesel;
    private double quantiteDisponibleDiesel;
    private double quantiteDisponibleGazoline;

    public Station(String nom, double capaciteGazoline, double capaciteDiesel) {
        this.nom = nom;
        this.capaciteGazoline = capaciteGazoline;
        this.capaciteDiesel = capaciteDiesel;
        this.pourcentageUtilisationGazoline = 100.0;
        this.pourcentageUtilisationDiesel = 100.0;
        this.quantiteDisponibleGazoline = 0.0;
        this.quantiteDisponibleDiesel = 0.0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCapaciteGazoline() {
        return capaciteGazoline;
    }

    public void setCapaciteGazoline(double capaciteGazoline) {
        this.capaciteGazoline = capaciteGazoline;

    }

    public double getPourcentageUtilisationGazoline() {
        return pourcentageUtilisationGazoline;
    }

    public double getCapaciteDiesel() {
        return capaciteDiesel;
    }

    public double getPourcentageUtilisationDiesel() {
        return pourcentageUtilisationDiesel;
    }

    public double getQuantiteDisponibleDiesel() {
        return quantiteDisponibleDiesel;
    }

    public double getQuantiteDisponibleGazoline() {
        return quantiteDisponibleGazoline;
    }

    public void setQuantiteDisponibleDiesel(double quantiteDisponibleDiesel) {

    }

    public void setQuantiteDisponibleGazoline(double quantiteDisponibleGazoline) {

    }

    public void enregistrerStation() {
        System.out.println("NOM-->Tabarre,Mirebalais,PetionVille,Gressier");
        for(int i=0;i<4;i++){
            System.out.print("Nom de la station " + (i + 1) + ": ");
            nom = sc.nextLine();

            while (!nom.equalsIgnoreCase("Tabarre") && !nom.equalsIgnoreCase("Petionville")
                    && !nom.equalsIgnoreCase("Gressier") && !nom.equalsIgnoreCase("Mirebalais")) {
                System.err.print("Nom de la station invalide. Veuillez réessayer: ");
                nom = sc.nextLine();
            }

            System.out.print("Capacite gazoline: ");
            capaciteGazoline = sc.nextDouble();
            System.out.print("Capacite de diesel: ");
            capaciteDiesel = sc.nextDouble();
            sc.nextLine(); // Pour consommer le retour à la ligne restant

            if (nom.equalsIgnoreCase("Tabarre")) {
                Station tabarre = new Station(nom, capaciteGazoline, capaciteDiesel);
                stations.add(tabarre);
                System.out.println("station tabarre ajoutee\n");
            } else if (nom.equalsIgnoreCase("Petionville")) {
                Station petionville = new Station(nom, capaciteGazoline, capaciteDiesel);
                stations.add(petionville);
                System.out.println("station petionville ajoutee\n");
            } else if (nom.equalsIgnoreCase("Gressier")) {
                Station gressier = new Station(nom, capaciteGazoline, capaciteDiesel);
                stations.add(gressier);
                System.out.println("station gressier ajoutee\n");
            } else if (nom.equalsIgnoreCase("Mirebalais")) {
                Station mirebalais = new Station(nom, capaciteGazoline, capaciteDiesel);
                stations.add(mirebalais);
                System.out.println("station mirebalais ajoutee\n");
            }
        }

        System.out.println("Nombre total de stations : " + stations.size());
        System.out.println("Toutes les " +stations.size()+ "stations ont été ajoutées avec succes\n");
    }

    // methode pour modifier station
    public void modifierQuantiteEssence() {
        int i = 0;
        for (Station station : stations) {
            double capaciteGazoline = station.getCapaciteGazoline();
            System.out.print("Quantite de gazoline disponible station " + (i + 1) + ": ");
            quantiteDisponibleGazoline = sc.nextDouble();
            System.out.print("Quantite de diesel disponible " + (i + 1) + ": ");
            quantiteDisponibleDiesel = sc.nextDouble();
            System.out.println();

            // Vérifier que la capacité de gazoline et la quantité disponible sont
            // différentes de zéro avant de les diviser
            if (capaciteGazoline != 0) {
                this.pourcentageUtilisationGazoline = (quantiteDisponibleGazoline / station.getCapaciteGazoline())
                        * 100.0;
                System.out.println("La quantite de gazoline disponible pour station " + (i + 1) + " est: "
                        + quantiteDisponibleGazoline + " gallons\n"
                        + "et le pourcentage est: " + pourcentageUtilisationGazoline + " %\n");
            } else {
                System.out.println("La capacité de gazoline est " + (i + 1) + " " + station.getCapaciteGazoline());
            }

            // Vérifier que la capacité de diesel et la quantité disponible sont différentes
            // de zéro avant de les diviser
            if (capaciteDiesel != 0) {
                this.pourcentageUtilisationDiesel = (quantiteDisponibleDiesel / station.getCapaciteDiesel()) * 100.0;
                System.out.println("La quantite de diesel disponible pour station " + (i + 1) + " est: "
                        + quantiteDisponibleDiesel + " gallons\n"
                        + "et le pourcentage est: " + pourcentageUtilisationDiesel + " %\n");
            } else {
                System.out.println("La capacité de diesel est: " + (i + 1) + " " + station.getCapaciteDiesel());
            }
            i++;
        }
        System.out.println("Quantite de carburants des " + stations.size() +" stations sont mises a jours");
        System.out.println();
    }

    // Afficher toutes les stations
    public void afficherStation() {
        System.out.println("Nombre total de stations : " + stations.size());
        for (Station station : stations) {
            System.out.printf("Nom Station: %s\nCapacite Gazoline: %2f\nCapacite Diesel: %2f\n", station.getNom(),
                    station.getCapaciteGazoline(), station.getCapaciteDiesel());
            System.out.println();
        }
    }

    public void trouverQuantiteMinMax() {
        System.out.print("Entrez le type de carburant (gazoline ou diesel) : ");
        String carburant = sc.next();
        while (!carburant.equalsIgnoreCase("gazoline") && !carburant.equalsIgnoreCase("diesel")) {
            System.out.print("Type de carburant invalide.\nVeuillez entrer gazoline ou diesel : ");
            carburant = sc.nextLine();
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
    
        for (Station station : stations) {
            if (carburant.equalsIgnoreCase("gazoline")) {
                station.quantiteDisponibleGazoline=quantiteDisponibleGazoline;
                if (station.quantiteDisponibleGazoline < min) {
                    min = station.quantiteDisponibleGazoline;
                    System.out.printf("La plus petite quantité de %s est : %.2f gallons\n", carburant, min);
                    System.out.println();
                }
                if (station.quantiteDisponibleGazoline > max) {
                    max = station.quantiteDisponibleGazoline;
                    System.out.printf("La plus grande quantité de %s est : %.2f gallons\n", carburant, max);
                    System.out.println();
                }
            } else if (carburant.equalsIgnoreCase("diesel")) {
                station.quantiteDisponibleDiesel=quantiteDisponibleDiesel;
                if (station.quantiteDisponibleDiesel < min) {
                    min = station.quantiteDisponibleDiesel;
                    System.out.printf("La plus petite quantité de %s est : %.2f gallons\n", carburant, min);
                    System.out.println();
                }
                if (station.quantiteDisponibleDiesel > max) {
                    max = station.quantiteDisponibleDiesel;
                    System.out.printf("La plus grande quantité de %s est : %.2f gallons\n", carburant, max);
                    System.out.println();
                }
            }
        }
        System.out.println("Quantite de carburants des : " + stations.size() + " sont mises a jours");
    }
    public void stationPluspetit(String carburant) {
        System.out.print("Entrez le type de carburant (gazoline ou diesel) : ");
         carburant = sc.next();
        while (!carburant.equalsIgnoreCase("gazoline") && !carburant.equalsIgnoreCase("diesel")) {
            System.out.print("Type de carburant invalide.\nVeuillez entrer gazoline ou diesel : ");
            carburant = sc.nextLine();
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (Station station : stations) {
            if (carburant.equalsIgnoreCase("gazoline")) {
                if (station.getQuantiteDisponibleGazoline() > 0) {
                    double quantiteDisponibleGazoline = station.getQuantiteDisponibleGazoline();
                    if (quantiteDisponibleGazoline < min) {
                        min = quantiteDisponibleGazoline;
                    } else if (quantiteDisponibleGazoline > max) {
                        max = quantiteDisponibleGazoline;
                    }
                }
            } else if (carburant.equalsIgnoreCase("diesel")) {
                if (station.getQuantiteDisponibleDiesel() > 0) {
                    double quantiteDisponibleDiesel = station.getQuantiteDisponibleDiesel();
                    if (quantiteDisponibleDiesel < min) {
                        min = quantiteDisponibleDiesel;
                    } else if (quantiteDisponibleDiesel > max) {
                        max = quantiteDisponibleDiesel;
                    }
                }
            }
        }
        System.out.printf("La station ayant la plus petite quantité de %s est %s avec %.2f gallons\n", carburant, getNom(), min);
        System.out.printf("La station ayant la plus grande quantité de %s est : %s avec %.2f gallons\n", carburant,getNom(), max);
      
    }        
    
}
