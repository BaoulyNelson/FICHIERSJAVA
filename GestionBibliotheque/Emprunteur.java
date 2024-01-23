import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class Emprunteur {
    private String nom;
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Emprunteur(String nom, UUID id) {
        this.nom = nom;
        this.id = id;
    }

    // Ajoutez les getters et les autres méthodes nécessaires ici

    // Exemple de méthode pour générer un nouvel emprunteur avec un ID aléatoire
    public static Emprunteur creerEmprunteur(String nom) {
        UUID id = UUID.randomUUID();
        return new Emprunteur(nom, id);
    }


    // Méthode pour ajouter un emprunteur
    public void ajouterEmprunteur() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("emprunteurs.txt", true))) {
            writer.write(id + "\n" + nom);
            writer.newLine();
            System.out.println("Emprunteur ajouté avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'ajout de l'emprunteur : " + e.getMessage());
        }
    }

 
    // Méthode pour rechercher un emprunteur
    public void rechercherEmprunteur(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("emprunteurs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) == id) {
                    System.out.println("Emprunteur trouvé : " + line);
                    return;
                }
            }
            System.out.println("Emprunteur non trouvé avec l'ID : " + id);
        } catch (IOException e) {
            System.err.println("Erreur lors de la recherche de l'emprunteur : " + e.getMessage());
        }
    }


    // Méthode pour écrire tous les emprunteurs dans le fichier texte
    public static void ecrireEmprunteurs(ArrayList<Emprunteur> emprunteurs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("emprunteurs.txt"))) {
            for (Emprunteur emprunteur : emprunteurs) {
                writer.write(emprunteur.id + "," + emprunteur.nom);
                writer.newLine();
            }
            System.out.println("Données des emprunteurs écrites avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des données des emprunteurs : " + e.getMessage());
        }
    }

    // Méthode pour lire tous les emprunteurs depuis le fichier texte
    public static ArrayList<Emprunteur> lireEmprunteurs() {
        ArrayList<Emprunteur> emprunteurs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("emprunteurs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                UUID id = UUID.fromString(parts[0]);
                String nom = parts[1];
                Emprunteur emprunteur = new Emprunteur(nom, id);
                emprunteurs.add(emprunteur);
            }
            
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des données des emprunteurs : " + e.getMessage());
        }
        return emprunteurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
}

