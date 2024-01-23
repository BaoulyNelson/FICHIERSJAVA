import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FoireGastronomique {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Foire Gastronomique ---");
            System.out.println("1. Ajouter un Fruit");
            System.out.println("2. Rechercher un Fruit");
            System.out.println("3. Modifier le nom d'un Fruit");
            System.out.println("4. Supprimer un Fruit");
            System.out.println("5. Afficher le premier Fruit");
            System.out.println("6. Afficher le dernier Fruit");
            System.out.println("7. Afficher la position d'un Fruit");
            System.out.println("8. Afficher le Fruit précédent et suivant");
            System.out.println("9. Afficher les Fruits en ordre croissant");
            System.out.println("10. Afficher les Fruits en ordre décroissant");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Lire le saut de ligne restant

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom du Fruit : ");
                    String fruit = scanner.nextLine();
                    fruits.add(fruit);
                    break;

                case 2:
                    System.out.print("Entrez le nom du Fruit à rechercher : ");
                    String fruitRecherche = scanner.nextLine();
                    if (fruits.contains(fruitRecherche)) {
                        System.out.println("Le Fruit \"" + fruitRecherche + "\" existe dans la collection.");
                    } else {
                        System.out.println("Le Fruit \"" + fruitRecherche + "\" n'existe pas dans la collection.");
                    }
                    break;

                case 3:
                    System.out.print("Entrez la position du Fruit à modifier : ");
                    int positionModif = scanner.nextInt();
                    scanner.nextLine(); // Lire le saut de ligne restant
                    if (positionModif >= 0 && positionModif < fruits.size()) {
                        System.out.print("Entrez le nouveau nom du Fruit : ");
                        String nouveauNom = scanner.nextLine();
                        fruits.set(positionModif, nouveauNom);
                        System.out.println("Le nom du Fruit a été modifié avec succès.");
                    } else {
                        System.out.println("Position invalide !");
                    }
                    break;

                case 4:
                    System.out.println("1. Supprimer par nom");
                    System.out.println("2. Supprimer par position");
                    System.out.print("Choix : ");
                    int choixSuppression = scanner.nextInt();
                    scanner.nextLine(); // Lire le saut de ligne restant

                    if (choixSuppression == 1) {
                        System.out.print("Entrez le nom du Fruit à supprimer : ");
                        String nomSuppression = scanner.nextLine();
                        if (fruits.remove(nomSuppression)) {
                            System.out.println("Le Fruit \"" + nomSuppression + "\" a été supprimé de la collection.");
                        } else {
                            System.out.println("Le Fruit \"" + nomSuppression + "\" n'existe pas dans la collection.");
                        }
                    } else if (choixSuppression == 2) {
                        System.out.print("Entrez la position du Fruit à supprimer : ");
                        int positionSuppression = scanner.nextInt();
                        scanner.nextLine(); // Lire le saut de ligne restant
                        if (positionSuppression >= 0 && positionSuppression < fruits.size()) {
                            String fruitSupprime = fruits.remove(positionSuppression);
                            System.out.println("Le Fruit \"" + fruitSupprime + "\" a été supprimé de la collection.");
                        } else {
                            System.out.println("Position invalide !");
                        }
                    } else {
                        System.out.println("Choix invalide !");
                    }
                    break;

                case 5:
                    if (!fruits.isEmpty()) {
                        System.out.println("Le premier Fruit est : " + fruits.get(0));
                    } else {
                        System.out.println("La collection est vide !");
                    }
                    break;

                case 6:
                    if (!fruits.isEmpty()) {
                        System.out.println("Le dernier Fruit est : " + fruits.get(fruits.size() - 1));
                    } else {
                        System.out.println("La collection est vide !");
                    }
                    break;

                case 7:
                    System.out.print("Entrez le nom du Fruit à chercher sa position : ");
                    String nomCherchePosition = scanner.nextLine();
                    int position = fruits.indexOf(nomCherchePosition);
                    if (position != -1) {
                        System.out.println("Le Fruit \"" + nomCherchePosition + "\" est à la position : " + position);
                    } else {
                        System.out.println("Le Fruit \"" + nomCherchePosition + "\" n'existe pas dans la collection.");
                    }
                    break;

                case 8:
                    System.out.print("Entrez le nom du Fruit : ");
                    String nomFruit = scanner.nextLine();
                    int indexFruit = fruits.indexOf(nomFruit);
                    if (indexFruit != -1) {
                        if (indexFruit > 0) {
                            System.out.println("Le Fruit précédent est : " + fruits.get(indexFruit - 1));
                        }
                        if (indexFruit < fruits.size() - 1) {
                            System.out.println("Le Fruit suivant est : " + fruits.get(indexFruit + 1));
                        }
                    } else {
                        System.out.println("Le Fruit \"" + nomFruit + "\" n'existe pas dans la collection.");
                    }
                    break;

                case 9:
                    Collections.sort(fruits);
                    System.out.println("Les Fruits en ordre croissant : " + fruits);
                    break;

                case 10:
                    Collections.sort(fruits, Collections.reverseOrder());
                    System.out.println("Les Fruits en ordre décroissant : " + fruits);
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }
}
