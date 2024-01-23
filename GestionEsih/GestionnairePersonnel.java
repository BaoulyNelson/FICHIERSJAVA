import java.util.Scanner;
import java.util.TreeSet;

public class GestionnairePersonnel {
    public Personne infosCommune() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez le sexe : ");
        String sexe = scanner.nextLine();

        System.out.print("Entrez l'adresse : ");
        String adresse = scanner.nextLine();

        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();

        System.out.print("Entrez la date de naissance : ");
        String dateNaissance = scanner.nextLine();

        System.out.print("Entrez le lieu de naissance : ");
        String lieuNaissance = scanner.nextLine();

        return new Personne(nom, prenom, sexe, adresse, email, dateNaissance, lieuNaissance);
    }

    TreeSet<Personne> dossierESIH = new TreeSet<>((p1, p2) -> p1.getNom().compareToIgnoreCase(p2.getNom()));

    public void ajouterPersonne(TreeSet<Personne> dossierESIH, Scanner scanner) {
        Personne personne = infosCommune();
        dossierESIH.add(personne);
    }


    public void afficherPersonnes() {
        for (Personne personne : dossierESIH) {
            System.out.println(personne.toString());
        }
    }

    public void rechercherPersonneParCode(TreeSet<Personne> dossierESIH, int codeRecherche) {
        for (Personne personne : dossierESIH) {
            if (personne.getCode() == (codeRecherche)) {
                System.out.println("Personne trouvee : " + personne.getNom() + " " + personne.getPrenom());
                return;
            }
        }
        System.out.println("Personne non trouvee.");
    }

    public void modifierPersonneParCode(TreeSet<Personne> dossierESIH, Scanner scanner, int codeModification) {
        Personne personneAModifier = null;
    
        // Recherche de la personne correspondant au code fourni
        for (Personne personne : dossierESIH) {
            if (personne.getCode() == codeModification) {
                personneAModifier = personne;
                break;
            }
        }
    
        // Vérification si la personne a été trouvée ou non
        if (personneAModifier != null) {
            System.out.println("Que voulez-vous modifier pour cette personne ?");
            System.out.println("1. Nom");
            System.out.println("2. Prénom");
            // Ajoutez d'autres options pour les autres attributs...
    
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après le nombre saisi
    
            switch (choix) {
                case 1:
                    System.out.print("Entrez le nouveau nom : ");
                    personneAModifier.setNom(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Entrez le nouveau prénom : ");
                    personneAModifier.setPrenom(scanner.nextLine());
                    break;
                // Ajoutez des cas pour les autres attributs
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
    
            System.out.println("Personne modifiée : " + personneAModifier);
        } else {
            System.out.println("Personne non trouvée.");
        }
    }
    

    public void supprimerPersonne(TreeSet<Personne> dossierESIH, int supprimerParNomOuCode, String n) {
        for (Personne personne : dossierESIH) {
            if (personne.getCode() == supprimerParNomOuCode
                    || personne.getNom().equals(Integer.toString(supprimerParNomOuCode))) {
                dossierESIH.remove(personne);
                System.out.println("Personne supprimee : " + personne.getNom() + " " + personne.getPrenom());
                return;
            }
        }
        System.out.println("Personne non trouvee.");
    }

    public void afficherPremierePersonne(TreeSet<Personne> dossierESIH) {
        if (!dossierESIH.isEmpty()) {
            Personne premierePersonne = dossierESIH.first();
            System.out.println("Premiere personne : " + premierePersonne.getCode() + " " + premierePersonne.getNom()
                    + " " + premierePersonne.getPrenom());
        } else {
            System.out.println("La collection est vide.");
        }
    }

    public void afficherAvantDernierePersonne(TreeSet<Personne> dossierESIH) {
        if (!dossierESIH.isEmpty() && dossierESIH.size() >= 2) {
            Personne avantDernierePersonne = (Personne) dossierESIH.toArray()[dossierESIH.size() - 2];
            System.out.println("Avant-derniere personne : " + avantDernierePersonne.getCode() + " "
                    + avantDernierePersonne.getNom() + " "
                    + avantDernierePersonne.getPrenom());
        } else {
            System.out.println("La collection ne contient pas suffisamment de personnes.");
        }
    }

    public void afficherAvantEtApresPersonne(TreeSet<Personne> dossierESIH, int codePersonneSaisie) {
        boolean trouve = false;
        Personne avantPersonne = null;
        Personne apresPersonne = null;

        for (Personne personne : dossierESIH) {
            if (personne.getCode() == (codePersonneSaisie)) {
                trouve = true;
                break;
            }
            avantPersonne = personne;
        }

        if (trouve) {
            for (Personne personne : dossierESIH.tailSet(avantPersonne, false)) {
                apresPersonne = personne;
                break;
            }

            System.out.println("Personne avant " + codePersonneSaisie + " : " + avantPersonne.getNom() + " "
                    + avantPersonne.getPrenom());
            System.out.println("Personne apres " + codePersonneSaisie + " : " + apresPersonne.getNom() + " "
                    + apresPersonne.getPrenom());
        } else {
            System.out.println("Personne non trouvee.");
        }
    }

    public void afficherDernierePersonne(TreeSet<Personne> dossierESIH) {
        if (!dossierESIH.isEmpty()) {
            Personne dernierePersonne = dossierESIH.last();
            System.out.println("Derniere personne : " + dernierePersonne.getCode() + " " + dernierePersonne.getNom()
                    + " " + dernierePersonne.getPrenom());
        } else {
            System.out.println("La collection est vide.");
        }
    }

    public void afficherPositionPersonne(TreeSet<Personne> dossierESIH, int codePosition) {
        int position = 0;
        boolean trouve = false;

        for (Personne personne : dossierESIH) {
            if (personne.getCode() == (codePosition)) {
                trouve = true;
                break;
            }
            position++;
        }

        if (trouve) {
            System.out.println("La personne se trouve a la position " + position + ".");
        } else {
            System.out.println("Personne non trouvee.");
        }
    }

    public void afficherPersonnesOrdreCroissant(TreeSet<Personne> dossierESIH) {
        System.out.println("Personnes en Ordre Croissant de nom :");
        for (Personne personne : dossierESIH) {
            System.out.println(+personne.getCode() + " " + personne.getNom() + " " + personne.getPrenom());
        }
    }

    public void afficherPersonnesOrdreDecroissant(TreeSet<Personne> dossierESIH) {
        System.out.println("Personnes en Ordre Decroissant de nom :");
        for (Personne personne : dossierESIH.descendingSet()) {
            System.out.println(personne.getCode() + " " + personne.getNom() + " " + personne.getPrenom());
        }
    }

    public void supprimerToutesPersonnes(TreeSet<Personne> dossierESIH) {
        dossierESIH.clear();
        System.out.println("Toutes les personnes ont été supprimées.");
    }

}
