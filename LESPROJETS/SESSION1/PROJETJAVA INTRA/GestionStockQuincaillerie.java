import java.util.*;

public class GestionStockQuincaillerie {
   public static Scanner scanner = new Scanner(System.in);
   public void enregistrerProduits() {
    System.out.print("Entrez la taille du tableau de produits : ");
    int n = scanner.nextInt();
    scanner.nextLine(); // Consommer le saut de ligne

    Produit[] produits = new Produit[n];
    
    for (int i = 0; i < n; i++) {
        System.out.println("Saisissez les informations du produit " + (i + 1) + ":");
        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prix unitaire : ");
        double prixUnitaire = scanner.nextDouble();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        
        produits[i] = new Produit(0, categorie, nom, prixUnitaire, quantite);
        scanner.nextLine(); // Consommer le saut de ligne
        System.out.println();
    }
}


    
    public void afficherProduits(Produit[] produits) {
        if (produits != null) {
            System.out.println("Les produits enregistrés sont :");
            for (Produit produit : produits) {
                if (produit != null) {
                    System.out.println(produit.toString());
                }
            }
            System.out.println();
        } else {
            System.out.println("Aucun produit n'a été enregistré.");
        }
    }
    
    public void afficherProduitsParCategorie(Produit[] produits, String categorie) {
        System.out.print("Entrez une catégorie pour afficher les produits : ");
        categorie = scanner.nextLine();
        System.out.println("Les produits de la catégorie " + categorie + " sont :");
        for (Produit produit : produits) {
            if (produit.getCategorie().equalsIgnoreCase(categorie)) {
                System.out.println(produit);
            }
        }
        System.out.println();
    }
    
    public void afficherProduitsAvantEtApres(Produit[] produits, int codeProduit) {
        boolean produitTrouve = false;
        System.out.print("Entrez le code d'un produit pour afficher les produits avant et après : ");
        codeProduit= scanner.nextInt();
        System.out.println("Les produits avant et après le produit avec le code " + codeProduit + " sont :");
        
        for (Produit produit : produits) {
            if (produit.getCode()==(codeProduit)) {
                produitTrouve = true;
            } else if (produitTrouve) {
                System.out.println(produit);
            } else {
                System.out.println("Produit avant : " + produit);
            }
        }
        
        System.out.println();
    }
    
    public void augmenterPrixInferieur60(Produit[] produits) {
        for (Produit produit : produits) {
            if (produit.getPrixUnitaire() < 60) {
                produit.setPrixUnitaire(produit.getPrixUnitaire() * 1.5);
            }
        }
        System.out.println("Les produits après augmentation de prix sont :");
        afficherProduits(produits);
    }
    
    public void diminuerPrixQuantiteEntre500et1000(Produit[] produits, String categorie) {
        System.out.print("Entrez une catégorie pour diminuer le prix des produits dont la quantité est entre 500 et 1000 : ");
         categorie = scanner.nextLine();
        for (Produit produit : produits) {
            if (produit.getCategorie().equalsIgnoreCase(categorie) && produit.getQuantite() >= 500 && produit.getQuantite() <= 1000) {
                produit.setPrixUnitaire(produit.getPrixUnitaire() - 50);
            }
        }
        System.out.println("Les produits après diminution de prix sont :");
        afficherProduits(produits);
    }
    
    public void supprimerProduit(Produit[] produits, int codeProduit) {
        int indexASupprimer = -1;
        System.out.print("Entrez le code d'un produit à supprimer : ");
         codeProduit = scanner.nextInt();
        for (int i = 0; i < produits.length; i++) {
            if (produits[i].getCode()==(codeProduit)) {
                indexASupprimer = i;
                break;
            }
        }
        
        if (indexASupprimer != -1) {
            for (int i = indexASupprimer; i < produits.length - 1; i++) {
                produits[i] = produits[i + 1];
            }
            produits[produits.length - 1] = null;
        }
        System.out.println("Les produits après suppression sont :");
        afficherProduits(produits);
        
    }
}


