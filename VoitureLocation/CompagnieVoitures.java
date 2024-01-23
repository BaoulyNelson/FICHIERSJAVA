import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class CompagnieVoitures implements GestionCompagnieVoitures {
    Scanner scanner = new Scanner(System.in);
    private HashMap<String, Voiture> voitures;

    public CompagnieVoitures() {
        voitures = new HashMap<>();
        chargerDonneesDepuisFichier();
    }

    private void chargerDonneesDepuisFichier() {
        // Vérifier si le fichier existe, sinon le créer
        File file = new File("voitures.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Vérifier si le tableau a la bonne longueur
                if (data.length == 5) {
                    try {
                        String numero = data[0];
                        String marque = data[1];
                        String modele = data[2];
                        int nombreCylindre = Integer.parseInt(data[3]);
                        double prix = Double.parseDouble(data[4]);

                        Voiture voiture = new Voiture(marque, modele, nombreCylindre, prix);
                        voitures.put(numero, voiture);
                    } catch (NumberFormatException e) {
                        // Gérer une exception de conversion
                        System.err.println("Erreur de conversion lors de la lecture du fichier : " + e.getMessage());
                    }
                } else {
                    // Gérer une ligne incorrecte
                    System.err.println("Format incorrect de la ligne : " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enregistrerVoiture(Voiture voiturre) {
        System.out.print("Marque(toyota,honda,ford,chevrolet,nissan,BMW) : ");
        String marque = scanner.nextLine();
    
        System.out.print("Modèle(Camry,Accord,Focus,Malibu,Pathfinder) : ");
        String modele = scanner.nextLine();
    
        System.out.print("Nombre de cylindres : ");
        int nombreCylindre = scanner.nextInt();
    
        System.out.print("Entrer le Prix : ");
        double prix = scanner.nextDouble();
        
        // Consommer la nouvelle ligne après nextInt()
        scanner.nextLine();
    
        voiturre = new Voiture(marque, modele, nombreCylindre, prix);
        voitures.put(voiturre.getNumero(), voiturre);
        sauvegarderDonneesDansFichier();
        System.out.println("voiture ajoute avec succees");
    
    }
    

    private void sauvegarderDonneesDansFichier() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("voitures.txt"))) {
            for (Voiture voiture : voitures.values()) {
                bw.write("Code: " + voiture.getNumero() + "\n" +
                        "Marque: " + voiture.getMarque() + "\n" +
                        "Modeles: " + voiture.getModele() + "\n" +
                        "Nombre de cylindres: " + voiture.getNombreCylindre() + " cylindres\n" +
                        "Prix: " + voiture.getPrix() + " Gourdes\n");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void afficherToutesVoitures() {
        if(voitures.isEmpty()){
            System.out.println("Liste vide");
        }else{
        for (Voiture voiture : voitures.values()) {
            System.out.println(voiture);
        }
    }
    }

    @Override
    public Voiture rechercherVoitureParCode(String code) {
        System.out.print("Entrez le code de la voiture a rechercher: ");
        String codeRecherche = scanner.next();

        Voiture voitureTrouvee = voitures.get(codeRecherche);

        if (voitureTrouvee != null) {
            System.out.println(voitureTrouvee);
        } else {
            System.out.println("Voiture non trouvée avec le code " + codeRecherche);
        }

        return voitureTrouvee;
    }

    @Override
    public void modifierPrixVoiture(String numero, double nouveauPrix) {
        System.out.print("Entrer le code a modifier: ");
        numero = scanner.next();
        Voiture voiture = voitures.get(numero);
        if (voiture != null) {
            System.out.println("Ancien prix de la voiture avec le code " + numero + " : " + voiture.getPrix());
            System.out.print("Nouveau prix : ");
            // Scanner est maintenant utilisé pour lire uniquement le nouveau prix
            nouveauPrix = scanner.nextDouble();

            voiture.setPrix(nouveauPrix);
            sauvegarderDonneesDansFichier();
            System.out.println("Prix modifié avec succès pour la voiture avec le code " + numero);
        } else {
            System.out.println("Voiture non trouvée avec le code " + numero);
        }
    }
    @Override
    public void supprimerVoitureParCode(String numero) {
        System.out.print("Entrer le code à supprimer : ");
        numero = scanner.next();
        Voiture voiture = voitures.get(numero);
        
        if (voiture != null) {
            // Afficher les informations de la voiture avant de demander la confirmation
            System.out.println("Informations de la voiture à supprimer :");
            System.out.println(voiture);
    
            // Demander confirmation avant de supprimer la voiture
            System.out.print("Voulez-vous vraiment supprimer cette voiture ? (O/N) : ");
            String confirmation = scanner.next();
    
            if (confirmation.equalsIgnoreCase("O")) {
                voitures.remove(numero);
                sauvegarderDonneesDansFichier(); // Mettre à jour le fichier après la suppression
                System.out.println("Voiture supprimée avec succès !");
            } else {
                System.out.println("Suppression annulée.");
            }
        } else {
            System.out.println("Voiture non trouvée avec le code " + numero);
        }
    }
    

}
