import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Pharmacie pharmacie = new Pharmacie();
        Scanner scanner = new Scanner(System.in);
        String choix;

        do {
            System.out.println("\n---- Menu ----");
            System.out.println("a) Ajouter un médicament");
            System.out.println("b) Rechercher un médicament par son nom");
            System.out.println("c) Augmenter la quantité d'un médicament");
            System.out.println("d) Augmenter le prix d'un médicament");
            System.out.println("e) Supprimer un médicament par son nom");
            System.out.println("f) Supprimer un médicament par son code");
            System.out.println("g) Afficher le premier médicament");
            System.out.println("h) Afficher le dernier médicament");
            System.out.println("i) Afficher la position d'un médicament par son nom");
            System.out.println("j) Afficher le médicament avant et après un médicament spécifié");
            System.out.println("q) Quitter");

            System.out.print("Votre choix : ");
            choix = scanner.nextLine();
            System.out.println();

            switch (choix) {
                case "a":
                    System.out.print("Categorie : ");
                    String categorie = scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer le caractère de nouvelle ligne restant
                    System.out.print("Quantité : ");
                    int quantite = scanner.nextInt();
                    scanner.nextLine(); // Consommer le caractère de nouvelle ligne restant
                    System.out.print("Date expiration : ");
                    String dateExpiration = scanner.nextLine();
                    Medicament medicament = new Medicament(categorie, 0, nom, prix, quantite, dateExpiration);
                    pharmacie.ajouterMedicament(medicament);
                    pharmacie.afficherTousMedicaments();
                    System.out.println("mediacement ajoutes avec succes");
                    break;

                case "b":
                    System.out.print("Entrez le nom du médicament à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    boolean existe = pharmacie.rechercherMedicamentParNom(nomRecherche);
                    if (existe) {
                        System.out.println("Le médicament existe dans la pharmacie.");
                    } else {
                        System.out.println("Le médicament n'existe pas dans la pharmacie.");
                    }
                    break;

                case "c":
                    System.out.print("Entrez le nom du médicament à augmenter : ");
                    String augmenterPrixMedicament = scanner.nextLine();
                    System.out.print("nouveau prix:  ");
                    double montantAjoute = scanner.nextDouble();
                    pharmacie.augmenterPrixMedicament(augmenterPrixMedicament, montantAjoute);
                    break;

                case "d":
                    System.out.print("Entrez le nom du médicament à augmenter : ");
                    String augmenterQuantiteMedicament = scanner.nextLine();
                    System.out.print("Nouvelle quantite: ");
                    int quantiteAjoute = scanner.nextInt();
                    pharmacie.augmenterQuantiteMedicament(augmenterQuantiteMedicament, quantiteAjoute);
                    break;

                case "e":
                    System.out.print("Entrez le nom du médicament à supprimer : ");
                    String nomMedicamentASupprimer = scanner.nextLine();
                    pharmacie.supprimerMedicamentParNom(nomMedicamentASupprimer);
                    break;

                case "f":
                    System.out.print("Entrez le code du médicament à supprimer : ");
                    int codeMedicamentASupprimer = scanner.nextInt();
                    scanner.nextLine(); // Consommer le caractère de nouvelle ligne restant
                    pharmacie.supprimerMedicamentParCode(codeMedicamentASupprimer);
                    break;

                case "g":
                    pharmacie.afficherPremierMedicament();
                    break;

                case "h":
                    pharmacie.afficherDernierMedicament();
                    break;

                case "i":
                    System.out.print("Entrez le nom du médicament à rechercher : ");
                    String nomPosition = scanner.nextLine();
                    pharmacie.afficherPositionMedicamentParNom(nomPosition);
                    break;

                // Les autres cas à implémenter...
                case "j":
                    System.out.print("Entrez le nom du médicament : ");
                    String nomMedicamentSaisi = scanner.nextLine(); // Ajout de cette ligne pour consommer le caractère
                    pharmacie.afficherMedicamentAvantEtApres(nomMedicamentSaisi);
                    break;

                case "q":
                    System.out.println("Programme terminé.");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }

        } while (!choix.equalsIgnoreCase("q"));

        scanner.close();
    }
}
