import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEntreprise {
        Scanner scanner= new Scanner(System.in);
    private List<Employe> employes;

    public GestionEntreprise() {
        employes = new ArrayList<>();
    }

   

    public void afficherListeEmployes() {
        if (employes.isEmpty()) {
            System.out.println("Aucun employé dans l'entreprise.");
        } else {
            System.out.println("Liste des employés :");
            for (Employe employe : employes) {
                System.out.println(employe.toString());
                 }
        }
    }

    public double calculerMasseSalariale() {
        double masseSalariale = 0.0;
        for (Employe employe : employes) {
            masseSalariale += employe.calculerSalaire();
        }
        System.out.println("La masse salariale de l'entreprise est de : " + masseSalariale);
        return masseSalariale;
    }
    public void ajouterEmploye() {
        System.out.print("Veuillez saisir le nom de l'employé : ");
        String nom = scanner.nextLine();
        System.out.print("Veuillez saisir le prénom de l'employé : ");
        String prenom = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Veuillez saisir le type d'employé\n(1 pour temps partiel, 2 pour temps plein,3 pour contractuel) : ");
        int type = scanner.nextInt();

        if (type == 1) {
            EmployeTempsPartiel employeTempsPartiel = new EmployeTempsPartiel(nom, prenom, 0, 0);
            employeTempsPartiel.saisirDetails();
            employes.add(employeTempsPartiel);
        } else if (type == 2) {
            EmployeTempsPlein employeTempsPlein = new EmployeTempsPlein(nom, prenom,0);
            // Appel de la méthode saisirDetails() pour l'employé temps plein
            employeTempsPlein.saisirDetails();
            employes.add(employeTempsPlein);
        }else if (type==3){
            EmployeContractuel employeContractuel = new EmployeContractuel(nom, prenom, 0,0);
            employeContractuel.saisirDetails();
            employes.add(employeContractuel);  
        } else{
             System.out.print("Type d'employé invalide. L'employé n'a pas été ajouté.");
        }
        sauvegarderDonnees();
    }

  

    public void sauvegarderDonnees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichierDonnees"))) {
            for (Employe employe : employes) {
                writer.write(employe.toString() + "\n");
                writer.write(String.valueOf("Salaire "+employe.calculerSalaire()));
                writer.newLine();
            }
            System.out.println("Données des employés sauvegardées avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données des employés : " + e.getMessage());
        }
    }

    public void chargerDonnees() {
        // Efface les employés existants avant de charger les données
        employes.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("fichierDonnees"))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] donnees = ligne.split(",");
                if (donnees.length == 4) {
                    String typeEmploye = donnees[0];
                    String nom = donnees[1];
                    String prenom = donnees[2];
                    //double salaire = Double.parseDouble(donnees[3]);

                    Employe employe;
                    if (typeEmploye.equalsIgnoreCase("EmployeTempsPartiel\n")) {
                        employe = new EmployeTempsPartiel(nom, prenom, 0,0);
                    } else if (typeEmploye.equalsIgnoreCase("EmployeTempsPlein\n")) {
                        employe = new EmployeTempsPlein(nom, prenom, 0);
                    }else if (typeEmploye.equalsIgnoreCase("EmployeContractuel\n")) {
                         employe = new EmployeContractuel(nom, prenom, 0,0);
                    } 
                     else {
                        continue;  // Ignorer les lignes avec un type d'employé inconnu
                    }

                    employes.add(employe);
                }
            }
            System.out.println("Données des employés chargées avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des données des employés : " + e.getMessage());
        }
    }
}