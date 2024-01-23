import java.io.*;
import java.util.ArrayList;

public class GestionEmploye {
    private static ArrayList<Vendeur> listeVendeurs = new ArrayList<>();
    private static ArrayList<Technicien> listeTechniciens = new ArrayList<>();
    private static ArrayList<Menagere> listeMenageres = new ArrayList<>();

    // Méthode pour enregistrer un vendeur dans la liste et dans un fichier vendeur.txt
    public static void enregistrerVendeur(Vendeur vendeur) {
        listeVendeurs.add(vendeur);
        enregistrerDansFichier(vendeur, "vendeur.txt");
    }

    // Méthode pour enregistrer un technicien dans la liste et dans un fichier technicien.txt
    public static void enregistrerTechnicien(Technicien technicien) {
        listeTechniciens.add(technicien);
        enregistrerDansFichier(technicien, "technicien.txt");
    }

    // Méthode pour enregistrer une menagere dans la liste et dans un fichier menagere.txt
    public static void enregistrerMenagere(Menagere menagere) {
        listeMenageres.add(menagere);
        enregistrerDansFichier(menagere, "menagere.txt");
    }

    // Méthode générique pour enregistrer un employé dans un fichier spécifique
    private static void enregistrerDansFichier(Employe employe, String fichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier, true))) {
            writer.write(employe.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Méthode pour afficher les informations d'un employé spécifique
    public static void afficherInfosEmploye(Employe employe) {
        System.out.println(employe.toString());
    }

    // Méthode pour afficher tous les vendeurs enregistrés
    public static void afficherVendeurs() {
        for (Vendeur vendeur : listeVendeurs) {
            System.out.println(vendeur.toString());
        }
    }

    // Méthode pour afficher tous les techniciens enregistrés
    public static void afficherTechniciens() {
        for (Technicien technicien : listeTechniciens) {
            System.out.println(technicien.toString());
        }
    }

    // Méthode pour afficher toutes les menageres enregistrées
    public static void afficherMenageres() {
        for (Menagere menagere : listeMenageres) {
            System.out.println(menagere.toString());
        }
    }
}
