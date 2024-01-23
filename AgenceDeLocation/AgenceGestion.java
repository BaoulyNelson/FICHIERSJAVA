
// AgenceGestion.java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenceGestion {
    private ArrayList<Logement> logements;
    private ArrayList<Personne> personnes;
    private ArrayList<Commune> communes;
    Scanner scanner = new Scanner(System.in);

    public AgenceGestion() {
        this.logements = new ArrayList<>();
        this.personnes = new ArrayList<>();
        this.communes = new ArrayList<>();
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    public void setLogements(ArrayList<Logement> logements) {
        this.logements = logements;
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(ArrayList<Personne> personnes) {
        this.personnes = personnes;
    }

    public ArrayList<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(ArrayList<Commune> communes) {
        this.communes = communes;
    }

    public void ajouterLogement() {

        System.out.println("Ajout d'un nouveau logement :");

        System.out.print("Commune : ");
        String commune = scanner.nextLine();

        System.out.print("Quartier : ");
        String quartier = scanner.nextLine();

        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();

        System.out.print("Superficie : ");
        double superficie = scanner.nextDouble();

        System.out.print("Loyer : ");
        double loyer = scanner.nextDouble();

        System.out.print("Type (maison, studio, T1, T2, etc.) : ");
        String type = scanner.next();

        System.out.print("Charges forfaitaires : ");
        double chargesForfaitaires = scanner.nextDouble();

        Logement nouveauLogement = new Logement(commune, quartier, adresse, superficie, loyer, type,
                chargesForfaitaires);
        logements.add(nouveauLogement);
        sauvegarderLogements();
        System.out.println("Le logement a été ajouté avec succès.");
    }

    public void ajouterPersonne() {
        System.out.println("Ajout d'une nouvelle personne :");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Date de naissance : ");
        String dateNaissance = scanner.nextLine();

        Personne nouvellePersonne = new Personne(nom, prenom, dateNaissance, "");
        personnes.add(nouvellePersonne);
        sauvegarderPersonnes();
        System.out.println("La personne a été ajoutée avec succès.");
    }

    public void ajouterCommune() {
        System.out.println("Ajout d'une nouvelle commune :");

        System.out.print("Nom de la commune : ");
        String nomCommune = scanner.nextLine();

        System.out.print("Nombre d'habitants : ");
        int nombreHabitants = scanner.nextInt();

        System.out.print("Distance à l'agence : ");
        double distanceAgence = scanner.nextDouble();

        Commune nouvelleCommune = new Commune(nomCommune, nombreHabitants, distanceAgence);
        communes.add(nouvelleCommune);
        sauvegarderCommunes();
        System.out.println("La commune a été ajoutée avec succès.");
    }

    public void afficherInformationsLogement() {
        if (logements.isEmpty()) {
            System.out.println("liste logement vide");
        } else {
            for (Logement logement : logements) {
                System.out.println(logement);
            }
        }
    }

    public void afficherInformationsPersonne() {
        if (personnes.isEmpty()) {
            System.out.println("liste personne vide");
        } else {
            for (Personne personne : personnes) {
                System.out.println(personne);
            }
        }
    }

    public void afficherInformationsCommune() {
        if (communes.isEmpty()) {
            System.out.println("liste commune vide");
        } else {
            for (Commune commune : communes) {
                System.out.println(commune);
            }
        }
    }

    public void sauvegarderLogements() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("logements.txt",true))) {
            for (Logement logement : logements) {
                writer.println("Commune: " + logement.getCommune());
                writer.println("Quartier: " + logement.getQuartier());
                writer.println("Adresse: " + logement.getAdresse());
                writer.println("Superficie: " + logement.getSuperficie() + " Km carree");
                writer.println("Loyer: " + logement.getLoyer() + " GOURDES");
                writer.println("Type: " + logement.getType());
                writer.println("Charges Forfaitaires: " + logement.getChargesForfaitaires() + " GOURDES");
                writer.println(); // Ligne vide entre les logements
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sauvegarderPersonnes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("personnes.txt",true))) {
            for (Personne personne : personnes) {
                writer.println("Nom: " + personne.getNom());
                writer.println("Prénom: " + personne.getPrenom());
                writer.println("Date de naissance: " + personne.getDateNaissance());
                writer.println("Numéro de téléphone: " + personne.getNumeroTelephone());
                writer.println(); // Ligne vide entre les personnes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sauvegarderCommunes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("communes.txt",true))) {
            for (Commune commune : communes) {
                writer.println("Nom de la commune: " + commune.getNom());
                writer.println("Nombre d'habitants: " + commune.getNombreHabitants() + " habitants");
                writer.println("Distance à l'agence: " + commune.getDistanceAgence() + " kms");
                writer.println(); // Ligne vide entre les communes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
