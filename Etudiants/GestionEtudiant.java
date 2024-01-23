import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestionEtudiant {
    ArrayList<Etudiant> etudiants = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void enregistrerEtudiant() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Prenom: ");
        String prenom = sc.nextLine();
        System.out.print("Niveau: ");
        String niveau = sc.nextLine();
        Etudiant etudiant = new Etudiant(0, nom, prenom, niveau);
        etudiants.add(etudiant);
        System.out.println("etudiant enregistrer dans l'arraylist");
        ecrireDansFichier();
    }

    public void aficher() {
        if (etudiants.isEmpty()) {
            System.out.println("liste vide");
        } else {
            for (Etudiant etudiant : etudiants) {
                System.out.println(etudiant.toString());

            }
        }
    }

    // Méthode pour supprimer un étudiant
    public void supprimer(int code) {

        boolean etudiantTrouve = false;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getCode() == code) {
                etudiants.remove(etudiant);
                ecrireDansFichier();
                etudiantTrouve = true;
                System.out.println("Etudiant avec le code " + code + " supprimé avec succès");
                break;
            }
        }
        if (!etudiantTrouve) {
            System.out.println("Aucun étudiant pour le code " + code);
        }
    }

    public void rechercherEtudiant(int code) {
        boolean etudiantTrouve = false;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getCode() == code) {
                System.out.println(etudiant.toString());
                etudiantTrouve = true;
                break;
            }
        }
        if (!etudiantTrouve) {
            System.out.println("Aucun étudiant avec le code " + code);

        }

    }

// Méthode pour modifier le code d'un étudiant
public void modifier() {
    boolean etudiantTrouve = false;

    System.out.print("Entrer le code de l'étudiant à modifier : ");
    int code = sc.nextInt();

    for (Etudiant etudiant : etudiants) {
        if (etudiant.getCode() == code) {
            int nouveauCode;

            while (true) {
                System.out.print("Entrer le nouveau code à remplacer : ");
                nouveauCode = sc.nextInt();

                if (!existeDeja(nouveauCode)) {
                    etudiant.setCode(nouveauCode);
                    ecrireDansFichier();
                    etudiantTrouve = true;
                    System.out.println("Code " + code + " modifié et remplacé par " + nouveauCode + " avec succès");
                    break;
                } else {
                    System.out.println(nouveauCode + " existe déjà. Réessayez !");
                }
            }

            break;
        }
    }

    if (!etudiantTrouve) {
        System.out.println("Aucun étudiant avec le code " + code);
    }
}

// Méthode pour vérifier si le code existe déjà pour un autre étudiant
private boolean existeDeja(int code) {
    for (Etudiant etudiant : etudiants) {
        if (etudiant.getCode() == code) {
            return true;
        }
    }
    return false;
}

    public void viderArrayList() {
        etudiants.clear();
        ecrireDansFichier();
        System.out.println("Tous les etudiants ont été vidés");
    }

    // Méthode pour écrire les données d'étudiants dans un fichier
    public void ecrireDansFichier() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etudiant.txt"))) {
            for (Etudiant etudiant : etudiants) {
                String ligne = etudiant.toString();
                writer.write(ligne);
        
                writer.newLine(); // Ajouter une nouvelle ligne entre chaque étudiant
            }
            System.out.println("Données d'étudiants écrites dans le fichier avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

}
