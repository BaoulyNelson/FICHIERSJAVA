import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMediatheque {

    private Mediatheque mediatheque;
    private List<CategorieClient> categoriesClients;
    private List<Client> clients;
    private List<Document> documents;
    private List<FicheEmprunt> ficheEmprunts;
    private List<Audio> audios;
    private List<Livre> livres;
    private List<Video> videos;



    public GestionMediatheque(Mediatheque mediatheque) {
        this.mediatheque = mediatheque;
        this.categoriesClients = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.audios=new ArrayList<>();
        this.livres=new ArrayList<>();
        this.videos=new ArrayList<>();
        this.ficheEmprunts=new ArrayList<>();


    }

// Méthode pour ajouter un document en demandant la saisie de l'utilisateur
public void afficherMenuGestionDocuments() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ajout d'un document :");

    // Demandez à l'utilisateur de choisir le type de document à ajouter
    System.out.println("Choisissez le type de document à ajouter :");
    System.out.println("1. Audio");
    System.out.println("2. Livre");
    System.out.println("3. Vidéo");

    int choixTypeDocument = scanner.nextInt();

    // Traitez le choix de l'utilisateur et ajoutez le document approprié
    switch (choixTypeDocument) {
        case 1:
            ajouterAudio();
            break;
        case 2:
            ajouterLivre();
            break;
        case 3:
            ajouterVideo();
            break;
        default:
            System.out.println("Choix invalide. Aucun document ajouté.");
    }

    // Fermez le scanner
    scanner.close();
}


    // Méthode pour ajouter une catégorie de client en demandant les informations à l'utilisateur
    public void ajouterCategorieClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout d'une nouvelle catégorie de client :");

        System.out.print("Nombre d'emprunts max : ");
        int nbEmpruntsMax = scanner.nextInt();

        System.out.print("Cotisation : ");
        float cotisation = scanner.nextFloat();

        System.out.print("Coefficient tarif : ");
        float coefTarif = scanner.nextFloat();

        System.out.print("Coefficient durée : ");
        float coefDuree = scanner.nextFloat();

        // Créez une instance de CategorieClient avec les données saisies
        CategorieClient categorieClient = new CategorieClient(nbEmpruntsMax, cotisation, coefTarif, coefDuree);

        // Ajoutez la catégorie de client à la liste des catégories
        categoriesClients.add(categorieClient);

        System.out.println("Catégorie de client ajoutée avec succès !");
        
        // Fermez le scanner
        scanner.close();
    }

    // Méthode pour modifier une catégorie de client
    public void modifierCategorieClient(CategorieClient ancienneCategorie, CategorieClient nouvelleCategorie) {
        int index = categoriesClients.indexOf(ancienneCategorie);
        if (index != -1) {
            categoriesClients.set(index, nouvelleCategorie);
        }
    }

  // Méthode pour supprimer une catégorie de client en demandant la saisie de l'utilisateur
    public void supprimerCategorieClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Suppression d'une catégorie de client :");

        // Affichez la liste des catégories disponibles
        
        afficherCategoriesClients();

        // Demandez à l'utilisateur de saisir le numéro de la catégorie à supprimer
        System.out.print("Saisissez le numéro de la catégorie à supprimer : ");
        int numeroCategorie = scanner.nextInt();

        // Vérifiez si le numéro de catégorie est valide
        if (numeroCategorie >= 0 && numeroCategorie < categoriesClients.size()) {
            // Supprimez la catégorie de client correspondante
            categoriesClients.remove(numeroCategorie);
            System.out.println("Catégorie de client supprimée avec succès !");
        } else {
            System.out.println("Numéro de catégorie invalide. Aucune catégorie supprimée.");
        }

        // Fermez le scanner
        scanner.close();
    }

    // Méthode pour afficher la liste des catégories de clients
private void afficherCategoriesClients() {
    System.out.println("Liste des catégories de clients :");

    for (int i = 0; i < categoriesClients.size(); i++) {
        System.out.println(i + ". " + categoriesClients.get(i));
    }
}

   // Méthode pour inscrire un client en demandant les informations à l'utilisateur
    public void inscrireClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inscription d'un nouveau client :");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();

        System.out.print("Date d'inscription : ");
        String dateInscription = scanner.nextLine();

        System.out.print("Date de renouvellement : ");
        String dateRenouvellement = scanner.nextLine();

        // Vous pouvez ajouter d'autres saisies utilisateur pour les caractéristiques du client

        System.out.print("Catégorie (par exemple, étudiant, adulte) : ");
        String categorie = scanner.nextLine();

        System.out.print("Bloqué (true/false) : ");
        boolean bloque = scanner.nextBoolean();

        // Créez une instance de CategorieClient en fonction de la saisie utilisateur
        CategorieClient categorieClient = new CategorieClient(5, 10.0f, 1.0f, 1.0f);

        // Créez une instance de Client avec les données saisies
        Client client = new Client(nom, prenom, adresse, dateInscription, dateRenouvellement, categorieClient, bloque);

        // Ajoutez le client à la liste des clients
        clients.add(client);

        System.out.println("Client ajouté avec succès !");
        
        // Fermez le scanner
        scanner.close();
    }

    // Méthode pour changer la catégorie d'un client
    public void changerClientCategorie(Client client, CategorieClient nouvelleCategorie) {
        int index = clients.indexOf(client);
        if (index != -1) {
            Client clientExist = clients.get(index);
            clientExist.setCategorie(nouvelleCategorie);
        }
    }

     // Méthode pour afficher les caractéristiques d'un client
     public void afficherCaracteristiquesClient(Client client) {
        System.out.println(client.toString());
    }

  // Méthode pour modifier les caractéristiques d'un client en demandant la saisie de l'utilisateur
  public void modifierCaracteristiquesClient(Client client) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Modification des caractéristiques d'un client :");

    // Affichez les caractéristiques actuelles du client
    System.out.println("Caractéristiques actuelles du client :");
    System.out.println(client.toString());

    // Demandez à l'utilisateur de saisir les nouvelles informations
    System.out.print("Nouvelle adresse : ");
    String nouvelleAdresse = scanner.nextLine();

    System.out.print("Nouvelle date de renouvellement : ");
    String nouvelleDateRenouvellement = scanner.nextLine();

    // Appliquez les modifications
    client.setAdresse(nouvelleAdresse);
    client.setDateRenouvellement(nouvelleDateRenouvellement);

    System.out.println("Caractéristiques du client mises à jour avec succès !");

    // Fermez le scanner
    scanner.close();
}

// Méthode pour renouveler l'inscription d'un client en demandant la saisie de l'utilisateur
public void renouvelerInscriptionClient(Client client) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Renouvellement de l'inscription d'un client :");

    // Affichez les caractéristiques actuelles du client
    System.out.println("Caractéristiques actuelles du client :");
    System.out.println(client.toString());

    // Demandez à l'utilisateur de saisir la nouvelle date de renouvellement
    System.out.print("Nouvelle date de renouvellement : ");
    String nouvelleDateRenouvellement = scanner.nextLine();

    // Appliquez le renouvellement de l'inscription
    client.setDateRenouvellement(nouvelleDateRenouvellement);

    System.out.println("Inscription du client renouvelée avec succès !");

    // Fermez le scanner
    scanner.close();
}

    // Méthode pour résilier un client
    public void resilierClient(Client client) {
        client.setBloque(true);
        System.out.println("client bloque");
    }

 // Méthode pour changer l'adresse d'un client en demandant la saisie de l'utilisateur
 public void changerAdresseClient(Client client) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Changement d'adresse d'un client :");

    // Affichez les caractéristiques actuelles du client
    System.out.println("Caractéristiques actuelles du client :");
    System.out.println(client.toString());

    // Demandez à l'utilisateur de saisir la nouvelle adresse
    System.out.print("Nouvelle adresse : ");
    String nouvelleAdresse = scanner.nextLine();

    // Appliquez le changement d'adresse
    client.setAdresse(nouvelleAdresse);

    System.out.println("Adresse du client changée avec succès !");

    // Fermez le scanner
    scanner.close();
}
    // Méthode pour consulter les emprunts d'un client
    public void consulterEmpruntsClient(Client client) {
        emprunts = client.getFichesEmprunt();
        for (FicheEmprunt emprunt : emprunts) {
            System.out.println(emprunt.toString());
        }
    }

  // Méthode pour ajouter un document audio en demandant la saisie de l'utilisateur
  public void ajouterAudio() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ajout d'un document audio :");

    // Demandez à l'utilisateur de saisir les informations nécessaires
    System.out.print("Code : ");
    String code = scanner.nextLine();

    System.out.print("Titre : ");
    String titre = scanner.nextLine();

    System.out.print("Auteur : ");
    String auteur = scanner.nextLine();

    System.out.print("Année : ");
    String annee = scanner.nextLine();

    System.out.print("Empruntable (true/false) : ");
    boolean empruntable = scanner.nextBoolean();

    scanner.nextLine(); // Pour consommer la nouvelle ligne restante

    System.out.print("Classification : ");
    String classification = scanner.nextLine();

    System.out.print("Mention légale : ");
    String mentionLegale = scanner.nextLine();

    // Créez une instance de Audio avec les données saisies
    Audio audio = new Audio(code, titre, auteur, annee, empruntable, classification);
    audios.add(audio);

    System.out.println("Document audio ajouté avec succès !");

    // Fermez le scanner
    scanner.close();
}
     // Méthode pour ajouter un document livre en demandant la saisie de l'utilisateur
     public void ajouterLivre() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout d'un document livre :");

        // Demandez à l'utilisateur de saisir les informations nécessaires
        System.out.print("Code : ");
        String code = scanner.nextLine();

        System.out.print("Titre : ");
        String titre = scanner.nextLine();

        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();

        System.out.print("Année : ");
        String annee = scanner.nextLine();

        System.out.print("Empruntable (true/false) : ");
        boolean empruntable = scanner.nextBoolean();

        scanner.nextLine(); // Pour consommer la nouvelle ligne restante

        System.out.print("Nombre de pages : ");
        int nombrePages = scanner.nextInt();

        // Créez une instance de Livre avec les données saisies
        Livre livre = new Livre(code, titre, auteur, annee, empruntable, nombrePages);
        
       livres.add(livre);

        System.out.println("Document livre ajouté avec succès !");

        // Fermez le scanner
        scanner.close();
    }

    // Méthode pour ajouter un document vidéo en demandant la saisie de l'utilisateur
    public void ajouterVideo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout d'un document vidéo :");

        // Demandez à l'utilisateur de saisir les informations nécessaires
        System.out.print("Code : ");
        String code = scanner.nextLine();

        System.out.print("Titre : ");
        String titre = scanner.nextLine();

        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();

        System.out.print("Année : ");
        String annee = scanner.nextLine();

        System.out.print("Empruntable (true/false) : ");
        boolean empruntable = scanner.nextBoolean();

        System.out.print("Durée (en minutes) : ");
        int duree = scanner.nextInt();

        scanner.nextLine(); // Pour consommer la nouvelle ligne restante

        System.out.print("Mention légale : ");
        String mentionLegale = scanner.nextLine();

        // Créez une instance de Video avec les données saisies
        Video video = new Video(code, titre, auteur, annee, empruntable, duree, mentionLegale);

        video.setMentionLegale(mentionLegale);
        videos.add(video);
        
       
        System.out.println("Document vidéo ajouté avec succès !");

        // Fermez le scanner
        scanner.close();
    }

    // Méthode pour rendre un document consultable
    public void rendreConsultableDocument(Document document) {
        document.setEmpruntable(true);
    }
     // Méthode pour rendre un document empruntable
     public void rendreEmpruntableDocument(Document document) {
        document.setEmpruntable(true);
    }

    // Méthode pour retirer un document de la médiathèque
    public void retirerDocument(Document document) {
        // Ajoutez la logique pour retirer le document de la médiathèque ou de la liste appropriée
    }

    // Méthode pour emprunter un document
    public void emprunterDocument(Client client, Document document, Date dateEmprunt, Date dateLimite) {
        if (document.isEmpruntable()) {
            FicheEmprunt ficheEmprunt = new FicheEmprunt(dateEmprunt, dateLimite, null);
            client.ajouterFicheEmprunt(ficheEmprunt);
            // Ajoutez la logique pour marquer le document comme emprunté ou ajuster sa disponibilité
        } else {
            System.out.println("Le document n'est pas empruntable.");
        }
    }

    // Méthode pour restituer un document
    public void restituerDocument(Client client, Document document, Date dateRappel) {
        FicheEmprunt ficheEmprunt = client.trouverFicheEmprunt(document);
        if (ficheEmprunt != null) {
            ficheEmprunt.setDateRappel(dateRappel);
            // Ajoutez la logique pour restituer le document ou ajuster sa disponibilité
        } else {
            System.out.println("Le document n'est pas emprunté par ce client.");
        }
    }

    // Méthode pour vérifier si l'emprunt est en retard
    public boolean estEnRetard(FicheEmprunt ficheEmprunt) {
        if (ficheEmprunt.getDateRappel() != null) {
            return true; // Si la date de rappel est définie, l'emprunt est en retard
        } else {
            Date dateActuelle = new Date();
            return dateActuelle.after(ficheEmprunt.getDateLimite());
        }
    }
    // Méthode pour afficher des statistiques
    public void afficherStatistiques() {
        // Ajoutez la logique pour afficher les statistiques de la médiathèque
    }

    // Méthode pour consulter le catalogue de documents
    public void consulterCatalogueDocuments(List<Document> catalogue) {
        for (Document document : catalogue) {
            System.out.println(document.toString());
        }
    }


}
