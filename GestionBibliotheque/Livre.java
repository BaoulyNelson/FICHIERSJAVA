import java.io.*;
import java.util.ArrayList;

import java.util.UUID;

public class Livre {
    private String titre;
    private String auteur;
    private UUID id;

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.id = UUID.randomUUID();
    }
    
        // Méthode pour ajouter un livre
        public void ajouterLivre() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("livres.txt", true))) {
                writer.write(id + "\n" + titre + "\n" + auteur);
                writer.newLine();
                System.out.println("Livre ajouté avec succès.");
            } catch (IOException e) {
                System.err.println("Erreur lors de l'ajout du livre : " + e.getMessage());
            }
        }
    

        // Méthode pour rechercher un livre
        public void rechercherLivre(int id) {
            try (BufferedReader reader = new BufferedReader(new FileReader("livres.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (Integer.parseInt(parts[0]) == id) {
                        System.out.println("Livre trouvé : " + line);
                        return;
                    }
                }
                System.out.println("Livre non trouvé avec l'ID : " + id);
            } catch (IOException e) {
                System.err.println("Erreur lors de la recherche du livre : " + e.getMessage());
            }
        }
    
    

    // Méthode pour écrire tous les livres dans le fichier texte
    public static void ecrireLivres(ArrayList<Livre> livres) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("livres.txt"))) {
            for (Livre livre : livres) {
                writer.write(livre.id + "\n" + livre.titre + "\n" + livre.auteur);
                writer.newLine();
            }
            System.out.println("Données des livres écrites avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des données des livres : " + e.getMessage());
        }
    }

    public static ArrayList<Livre> lireLivres() {
        ArrayList<Livre> livres = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("livres.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String idStr = parts[0].trim(); // Assurez-vous de retirer les espaces autour de l'ID
                String titre = parts[1].trim();
                String auteur = parts[2].trim();
                
                // Convertir la chaîne ID en UUID
                UUID id;
                try {
                    id = UUID.fromString(idStr);
                } catch (IllegalArgumentException e) {
                    System.err.println("Format d'ID invalide : " + idStr);
                    continue; // Ignorer cette ligne et passer à la suivante
                }
    
                Livre livre = new Livre(titre, auteur); // Ajoutez l'ID dans le constructeur du Livre
                livres.add(livre);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des données des livres : " + e.getMessage());
        }
        return livres;
    }
    

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
