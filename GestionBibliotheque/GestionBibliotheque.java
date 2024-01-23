import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class GestionBibliotheque {
    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        // Charger les données existantes depuis les fichiers texte
        ArrayList<Livre> livres = Livre.lireLivres();
        ArrayList<Emprunteur> emprunteurs = Emprunteur.lireEmprunteurs();
        ArrayList<Emprunt> emprunts = Emprunt.lireEmprunts(livres, emprunteurs);

        int choix;
        do {
            System.out.println("Menu Principal");
            System.out.println("1. Gérer les Livres");
            System.out.println("2. Gérer les Emprunteurs");
            System.out.println("3. Gérer les Emprunts");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    gererLivres(livres);
                    System.out.println();
                    break;
                case 2:
                    gererEmprunteurs(emprunteurs);
                    System.out.println();
                    break;
                case 3:
                    gererEmprunts(emprunts, livres, emprunteurs);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);

        // Sauvegarder les données dans les fichiers texte avant de quitter
        Livre.ecrireLivres(livres);
        Emprunteur.ecrireEmprunteurs(emprunteurs);
        Emprunt.ecrireEmprunts(emprunts);
    }

    private static void gererLivres(ArrayList<Livre> livres) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Gestion des Livres");
            System.out.println("1. Ajouter un Livre");
            System.out.println("2. Supprimer un Livre");
            System.out.println("3. Rechercher un Livre");
            System.out.println("4. Retour au Menu Principal");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Titre du livre : ");
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    String titre = scanner.nextLine();
                    System.out.print("Auteur du livre : ");
                    String auteur = scanner.nextLine();
                    Livre nouveauLivre = new Livre(titre, auteur);
                    livres.add(nouveauLivre);
                    Livre.ecrireLivres(livres);
                    System.out.println("Livre ajouté avec succès.");

                    System.out.println();

                    break;
                case 2:
                    System.out.print("ID du livre à supprimer : ");
                    String idSupprimerLivre = scanner.next();

                    // Convertir la chaîne ID en UUID
                    UUID idLivreASupprimer;
                    try {
                        idLivreASupprimer = UUID.fromString(idSupprimerLivre);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'ID invalide.");
                        break;
                    }

                    livres.removeIf(livre -> livre.getId().equals(idLivreASupprimer));
                    Livre.ecrireLivres(livres);
                    System.out.println("Livre supprimé avec succès.");
                    System.out.println();

                    break;

                case 3:
                    System.out.print("ID du livre à rechercher : ");
                    String idRechercherLivre = scanner.next();

                    // Convertir la chaîne ID en UUID
                    UUID idLivreARechercher;
                    try {
                        idLivreARechercher = UUID.fromString(idRechercherLivre);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'ID invalide.");
                        break;
                    }

                    boolean livreTrouve = false;
                    for (Livre livre : Livre.lireLivres()) {
                        if (livre.getId().equals(idLivreARechercher)) {
                            System.out.println("Livre trouvé : " + livre.getTitre() + " par " + livre.getAuteur());
                            livreTrouve = true;
                            break;
                        }
                    }

                    if (!livreTrouve) {
                        System.out.println("Aucun livre trouvé avec l'ID spécifié.");
                    }
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Retour au Menu Principal.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);
    }

    private static void gererEmprunteurs(ArrayList<Emprunteur> emprunteurs) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Gestion des Emprunteurs");
            System.out.println("1. Ajouter un Emprunteur");
            System.out.println("2. Supprimer un Emprunteur");
            System.out.println("3. Rechercher un Emprunteur");
            System.out.println("4. Retour au Menu Principal");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'emprunteur : ");
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    String nomEmprunteur = scanner.nextLine();
                    Emprunteur nouvelEmprunteur = new Emprunteur(nomEmprunteur, null);
                    emprunteurs.add(nouvelEmprunteur);
                    Emprunteur.ecrireEmprunteurs(emprunteurs);
                    System.out.println("Emprunteur ajouté avec succès.");
                    System.out.println();

                    break;
                case 2:
                    System.out.print("ID de l'emprunteur à supprimer : ");
                    String idSupprimerEmprunteur = scanner.next();

                    // Convertir la chaîne ID en UUID
                    UUID idEmprunteurASupprimer;
                    try {
                        idEmprunteurASupprimer = UUID.fromString(idSupprimerEmprunteur);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'ID invalide.");
                        break;
                    }

                    emprunteurs.removeIf(emprunteur -> emprunteur.getId().equals(idEmprunteurASupprimer));
                    Emprunteur.ecrireEmprunteurs(emprunteurs);
                    System.out.println("Emprunteur supprimé avec succès.");
                    System.out.println();

                    break;

                case 3:
                    System.out.print("ID de l'emprunteur à rechercher : ");
                    String idRechercherEmprunteur = scanner.next();

                    // Convertir la chaîne ID en UUID
                    UUID idEmprunteurARechercher;
                    try {
                        idEmprunteurARechercher = UUID.fromString(idRechercherEmprunteur);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'ID invalide.");
                        break;
                    }

                    boolean emprunteurTrouve = false;
                    for (Emprunteur emprunteur : Emprunteur.lireEmprunteurs()) {
                        if (emprunteur.getId().equals(idEmprunteurARechercher)) {
                            System.out.println("Emprunteur trouvé : " + emprunteur.getNom());
                            emprunteurTrouve = true;
                            break;
                        }
                    }

                    if (!emprunteurTrouve) {
                        System.out.println("Aucun emprunteur trouvé avec l'ID spécifié.");
                    }
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Retour au Menu Principal.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);
    }

    private static void gererEmprunts(ArrayList<Emprunt> emprunts, ArrayList<Livre> livres,
            ArrayList<Emprunteur> emprunteurs) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Gestion des Emprunts");
            System.out.println("1. Emprunter un Livre");
            System.out.println("2. Retourner un Livre");
            System.out.println("3. Retour au Menu Principal");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("ID du livre à emprunter : ");
                    String idEmprunterLivre = scanner.next();

                    // Convertir la chaîne ID du livre en UUID
                    UUID idLivreEmprunter;
                    try {
                        idLivreEmprunter = UUID.fromString(idEmprunterLivre);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'ID du livre invalide.");
                        break;
                    }

                    Livre livreEmprunter = Emprunt.trouverLivreParId(livres, idLivreEmprunter);
                    if (livreEmprunter != null) {
                        System.out.print("ID de l'emprunteur : ");
                        String idEmprunteur = scanner.next();

                        // Convertir la chaîne ID de l'emprunteur en UUID
                        UUID idEmprunteurEmprunt;
                        try {
                            idEmprunteurEmprunt = UUID.fromString(idEmprunteur);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Format d'ID de l'emprunteur invalide.");
                            break;
                        }

                        Emprunteur emprunteur = Emprunt.trouverEmprunteurParId(emprunteurs, idEmprunteurEmprunt);
                        if (emprunteur != null) {
                            System.out.print("Date d'emprunt (format YYYY-MM-DD) : ");
                            scanner.nextLine(); // Consommer la nouvelle ligne
                            String dateEmprunt = scanner.nextLine();
                            System.out.print("Date de retour prévue (format YYYY-MM-DD) : ");
                            String dateRetourPrevue = scanner.nextLine();
                            Emprunt nouvelEmprunt = new Emprunt(livreEmprunter, emprunteur, dateEmprunt,
                                    dateRetourPrevue);
                            emprunts.add(nouvelEmprunt);
                            Emprunt.ecrireEmprunts(emprunts);
                            System.out.println("Livre emprunté avec succès.");
                        } else {
                            System.out.println("Emprunteur non trouvé avec l'ID : " + idEmprunteur);
                        }
                    } else {
                        System.out.println("Livre non trouvé avec l'ID : " + idEmprunterLivre);
                    }
                    System.out.println();

                    break;

                case 2:
                    System.out.print("ID du livre à retourner : ");
                    String idRetournerLivre = scanner.next();

                    // Convertir la chaîne ID du livre en UUID
                    UUID idLivreRetourner;
                    try {
                        idLivreRetourner = UUID.fromString(idRetournerLivre);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'ID du livre invalide.");
                        break;
                    }

                    Emprunt empruntRetourner = trouverEmpruntParLivreId(emprunts, idLivreRetourner);
                    if (empruntRetourner != null) {
                        emprunts.remove(empruntRetourner);
                        Emprunt.ecrireEmprunts(emprunts);
                        System.out.println("Livre retourné avec succès.");
                    } else {
                        System.out.println("Emprunt non trouvé pour le livre avec l'ID : " + idRetournerLivre);
                    }
                    System.out.println();

                    break;

                case 3:
                    System.out.println("Retour au Menu Principal.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 3);
    }

    private static Emprunt trouverEmpruntParLivreId(ArrayList<Emprunt> emprunts, UUID livreId) {
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getLivre().getId().equals(livreId)) {
                return emprunt;
            }
        }
        return null;
    }

}
