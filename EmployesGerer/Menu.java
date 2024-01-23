import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ajouter un Vendeur");
            System.out.println("2. Ajouter un Technicien");
            System.out.println("3. Ajouter une Menagere");
            System.out.println("4. pour afficher tous les Employes");
            System.out.println("5. Quitter");
            System.out.println();

            System.out.print("Choisissez une option :");
            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    Vendeur vendeur = ManipulerEmployes.saisirVendeur();
                    System.out.println();
                    GestionEmploye.enregistrerVendeur(vendeur);
                    System.out.println();
                    break;
                case 2:
                    Technicien technicien = ManipulerEmployes.saisirTechnicien();
                    System.out.println();
                    GestionEmploye.enregistrerTechnicien(technicien);
                    System.out.println();
                    break;
                case 3:
                    Menagere menagere = ManipulerEmployes.saisirMenagere();
                    System.out.println();
                    GestionEmploye.enregistrerMenagere(menagere);
                    System.out.println();
                    break;
                case 4:
                    GestionEmploye.afficherVendeurs();
                    System.out.println();
                    GestionEmploye.afficherTechniciens();
                    System.out.println();
                    GestionEmploye.afficherMenageres();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    System.out.println();

            }
        }
    }
}
