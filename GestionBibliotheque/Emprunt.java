import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Emprunt {
    private Livre livre;
    private Emprunteur emprunteur;
    private String dateEmprunt;
    private String dateRetourPrevue;

    public Emprunt(Livre livre, Emprunteur emprunteur, String dateEmprunt, String dateRetourPrevue) {
        this.livre = livre;
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(String dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

      // Méthode pour écrire tous les emprunts dans le fichier texte
    public static void ecrireEmprunts(ArrayList<Emprunt> emprunts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("emprunts.txt"))) {
            for (Emprunt emprunt : emprunts) {
                writer.write(
                        emprunt.livre.getId() + "\n" +
                        emprunt.emprunteur.getId() + "\n" +
                        emprunt.dateEmprunt + "\n" +
                        emprunt.dateRetourPrevue
                );
                writer.newLine();
            }
            System.out.println("Données des emprunts écrites avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des données des emprunts : " + e.getMessage());
        }
    }

   
    // Méthode pour lire tous les emprunts depuis le fichier texte
    public static ArrayList<Emprunt> lireEmprunts(ArrayList<Livre> livres, ArrayList<Emprunteur> emprunteurs) {
        ArrayList<Emprunt> emprunts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("emprunts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                UUID livreId = UUID.fromString(parts[0]);
                UUID emprunteurId = UUID.fromString(parts[1]);
                Livre livre = trouverLivreParId(livres, livreId);
                Emprunteur emprunteur = trouverEmprunteurParId(emprunteurs, emprunteurId);
                String dateEmprunt = parts[2];
                String dateRetourPrevue = parts[3];
                Emprunt emprunt = new Emprunt(livre, emprunteur, dateEmprunt, dateRetourPrevue);
                emprunts.add(emprunt);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des données des emprunts : " + e.getMessage());
        }
        return emprunts;
    }

    // Méthode utilitaire pour trouver un livre par ID
    public static Livre trouverLivreParId(ArrayList<Livre> livres, UUID id) {
        for (Livre livre : livres) {
            if (livre.getId().equals(id)) {
                return livre;
            }
        }
        return null;
    }
    
  // Méthode utilitaire pour trouver un emprunteur par ID
    public static Emprunteur trouverEmprunteurParId(ArrayList<Emprunteur> emprunteurs, UUID id) {
        for (Emprunteur emprunteur : emprunteurs) {
            if (emprunteur.getId().equals(id)){
                return emprunteur;
            }
        }
        return null;
    }
}
