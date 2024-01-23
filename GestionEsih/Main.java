import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        TreeSet<Personne> dossierESIH = new TreeSet<>();
        GestionnairePersonnel gestionnairePersonnel = new GestionnairePersonnel();
        Scanner scanner = new Scanner(System.in);
        String choix;

        do {
            System.out.println("\n---- Menu ----");
            System.out.println("a) Ajouter une Personne");
            System.out.println("b) Rechercher une Personne par son code");
            System.out.println("c) Modifier une Personne par son code");
            System.out.println("d) Supprimer une Personne par son nom ou son code");
            System.out.println("e) Afficher la première Personne");
            System.out.println("f) Afficher l'avant-dernière Personne");
            System.out.println("g) Afficher la Personne avant et après une Personne saisie");
            System.out.println("h) Afficher la dernière Personne");
            System.out.println("i) Afficher la position d'une Personne par son code");
            System.out.println("j) Afficher les Personnes en Ordre Croissant de nom");
            System.out.println("k) Afficher les Personnes en Ordre Décroissant de nom");
            System.out.println("l) Supprimer tous les éléments de la collection");
            System.out.println("q) Quitter");

            System.out.print("Votre choix : ");
            choix = scanner.nextLine();
        System.out.println();

            switch (choix) {
                case "a":
                    gestionnairePersonnel.ajouterPersonne(dossierESIH, scanner);
                    break;

                case "b":
                    System.out.print("Entrez le code de la Personne à rechercher : ");
                    int codeRecherche = scanner.nextInt();
                    gestionnairePersonnel.rechercherPersonneParCode(dossierESIH, codeRecherche);
                    break;

                case "c":
                    System.out.print("Entrez le code de la Personne à modifier : ");
                    int codeModification = scanner.nextInt();
                    gestionnairePersonnel.modifierPersonneParCode(dossierESIH, scanner, codeModification);
                    break;

                case "d":
                    System.out.print("Entrez le nom ou le code de la Personne à supprimer : ");
                    int supprimerParNomOuCode = 0;
                    if (scanner.hasNextInt()) {
                        supprimerParNomOuCode = scanner.nextInt();
                        gestionnairePersonnel.supprimerPersonne(dossierESIH, supprimerParNomOuCode,null);
                    } else {
                        scanner.nextLine(); // Consommer l'entrée invalide (non-entier) pour éviter une boucle infinie
                        String nomSupprimer = scanner.nextLine();
                        gestionnairePersonnel.supprimerPersonne(dossierESIH, 0,nomSupprimer);
                    }
                    break;

                case "e":
                    gestionnairePersonnel.afficherPremierePersonne(dossierESIH);
                    break;

                case "f":
                    gestionnairePersonnel.afficherAvantDernierePersonne(dossierESIH);
                    break;

                case "g":
                    System.out.print("Entrez le code de la Personne saisie : ");
                    int saisie = scanner.nextInt();
                    gestionnairePersonnel.afficherAvantEtApresPersonne(dossierESIH, saisie);
                    break;

                case "h":
                    gestionnairePersonnel.afficherDernierePersonne(dossierESIH);
                    break;

                case "i":
                    System.out.print("Entrez le code de la Personne à rechercher : ");
                    int codePosition = scanner.nextInt();
                    gestionnairePersonnel.afficherPositionPersonne(null, codePosition);
                    break;

                case "j":
                    gestionnairePersonnel.afficherPersonnesOrdreCroissant(dossierESIH);
                    break;

                case "k":
                    gestionnairePersonnel.afficherPersonnesOrdreDecroissant(dossierESIH);
                    break;

                case "l":
                    gestionnairePersonnel.supprimerToutesPersonnes(dossierESIH);
                    break;

                case "q":
                    System.out.println("Programme terminé.");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }

        } while (!choix.equalsIgnoreCase("q"));
    }

}
