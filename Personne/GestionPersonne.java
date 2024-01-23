import java.util.ArrayList;
import java.util.Scanner;

public class GestionPersonne {
    private static ArrayList<Personne> personnes = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void enregistrerPersonne(Personne personne) {
        System.out.println("enregistrement d'une personne");

        System.out.print("Entrez le nom de la personne : ");
        personne.setNom(scanner.nextLine());

        System.out.print("Entrez le prénom de la personne : ");
        personne.setPrenom(scanner.nextLine());

        System.out.print("Entrez l'école de la personne : ");
        personne.setEcole(scanner.nextLine());

        System.out.print("Entrez la matière de la personne : ");
        personne.setMatiere(scanner.nextLine());

        System.out.print("Entrez le professeur de la personne : ");
        personne.setProf(scanner.nextLine());

        System.out.print("Entrez le niveau de la personne : ");
        personne.setNiveau(scanner.nextLine());

        System.out.print("La personne a-t-elle un diplôme ? (true/false) : ");
        personne.setDiplome(scanner.nextBoolean());
        personnes.add(personne);
        System.out.println();
    }

   // Méthode pour afficher les informations d'une personne
   public void afficherInformationsPersonne() {
    System.out.println("Informations sur les personnes enregistrées :");
        for (Personne personne : personnes) {
            System.out.printf("Code : %d\nNom : %s\nPrénom : %s\nÉcole : %s\nMatière : %s\nProfesseur : %s\nNiveau : %s\nDiplôme : %b\n\n",
                    personne.getCode(), personne.getNom(), personne.getPrenom(), personne.getEcole(),
                    personne.getMatiere(), personne.getProf(), personne.getNiveau(), personne.isDiplome());
        }
        System.out.println();
    }


  
    public void rechercherPersonne() {
        // Afficher la liste des codes existants
        System.out.println("Codes des personnes enregistrées : ");
        for (Personne personne : personnes) {
            System.out.println(personne.getCode());
        }

        // Demander à l'utilisateur de saisir le code à rechercher
        System.out.print("Entrez le code de la personne : ");
        int code = scanner.nextInt();
        boolean personneTrouvee = false;

        for (Personne personne : personnes) {
            if (code == personne.getCode()) {
                personneTrouvee = true;
                afficherInformationsPersonne();
                break;
            }
        }

        if (!personneTrouvee) {
            System.out.println("Aucune personne n'a été enregistrée avec le code fourni.");
        }
    }

}
