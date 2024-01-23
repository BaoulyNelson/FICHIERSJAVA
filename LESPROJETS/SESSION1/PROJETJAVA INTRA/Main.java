import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("\t"+"\t"+"\t"+"\t"+"[=============================== ESIH ===============================]");
        System.out.println("\t"+"\t"+"[=============================== ECOLE SUPERIEURE INFOTRONIQUE D'HAITI ===============================]");
        System.out.println("\t"+"\t"+" -----------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("\t"+"\t"+"DEVOIR D'INTRA JAVA DE LA PREMIERE SESSION: ");
        System.out.println("\t"+"\t"+"NIVEAU L3                                 : ");
        System.out.println("\t"+"\t"+"NON DU GROUPE -> (LES INTRÉPIDES)           : ");
        System.out.println("\t"+"\t"+"TROIS (3) EXERCICES SUR LES TABLEAUX      : ");
        System.out.println("\t"+"\t"+"COURS ENSEIGNE PAR PROF. Jaures PIERRE    :  ");
        System.out.println();
        System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        DEVOIR PREPARE PAR UN ENSEMBLE DE PROGRAMMEUR:");
        System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"                NOM     PRENOM");
        System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"                ---     ------");
        System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        1-) [---DORELUS Bersony  ---]:");
        System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        2-) [---JOSEPH  Clavensky---]:");
        System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        3-) [---NELSON  Benito   ---]:");
        GestionStockQuincaillerie gestionStockQuincaillerie=new GestionStockQuincaillerie();
        Scanner scanner = new Scanner(System.in);
        String categorie="";
        int codeProduit=0;
        int choix = 0;
        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Enregistrer des produits");
            System.out.println("2. Afficher tous les produits");
            System.out.println("3. Afficher les produits par catégorie");
            System.out.println("4. Afficher les produits avant et après un produit");
            System.out.println("5. Augmenter le prix des produits inférieurs à 60 Gourdes");
            System.out.println("6. Diminuer le prix des produits d'une catégorie avec quantité entre 500 et 1000");
            System.out.println("7. Supprimer un produit");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            System.out.println();
            switch (choix) {
                case 1:
                gestionStockQuincaillerie.enregistrerProduits();
                    break;
                case 2:
                gestionStockQuincaillerie.afficherProduits(null);
                    break;
                case 3:
                gestionStockQuincaillerie.afficherProduitsParCategorie(null,categorie);
                    break;
                case 4:
                gestionStockQuincaillerie.afficherProduitsAvantEtApres(null,codeProduit);
                    break;
                case 5:
                gestionStockQuincaillerie.augmenterPrixInferieur60(null);
                    break;
                case 6:
                gestionStockQuincaillerie.diminuerPrixQuantiteEntre500et1000(null,categorie);
                    break;
                case 7:
                gestionStockQuincaillerie.supprimerProduit(null,codeProduit);
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix < 8);
    }
}
