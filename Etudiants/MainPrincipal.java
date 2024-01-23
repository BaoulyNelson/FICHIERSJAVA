import java.util.Scanner;

public class MainPrincipal {
    public static void main(String[] args) {
        int choix;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        GestionEtudiant gestionEtudiant = new GestionEtudiant();
        do {
            System.out.println("1. Enregistrer un étudiant");
            System.out.println("2. Afficher les étudiants");
            System.out.println("3. Modifier un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Rechercher un étudiant");
            System.out.println("6. Vider la liste des étudiants");
            System.out.println("7. choix invalide");

            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            System.out.println();
            switch (choix) {
                case 1:
                    gestionEtudiant.enregistrerEtudiant();
                    System.out.println();
                    break;
                case 2:
                    gestionEtudiant.aficher();
                    System.out.println();
                    break;
                case 3:
                    // System.out.print("entrer le code actuel a modifier: ");
                    int code;
                    gestionEtudiant.modifier();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("entrer le code actuel a supprimer: ");
                    code = sc.nextInt();
                    gestionEtudiant.supprimer(code);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("entrer le code a rechercher: ");
                    code = sc.nextInt();
                    gestionEtudiant.rechercherEtudiant(code);
                    System.out.println();
                    break;
                case 6:
                    gestionEtudiant.viderArrayList();
                    System.out.println();
                    break;
                default:
                    System.out.println("choix invalide");
                    System.out.println();
                    //System.out.println("desole de te voir partir");
                    break;
            }

        } while (choix != 7);
        sc.close();
    }

}
