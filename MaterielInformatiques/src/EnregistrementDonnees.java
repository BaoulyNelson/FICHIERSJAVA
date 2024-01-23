import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnregistrementDonnees {

    public static String URL = "jdbc:mysql://localhost:3306/materielInformatique";
    static String UTILISATEUR = "root";
    static String MOT_DE_PASSE = "";

    public static Connection etablirConnexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
    }

    public static void fermerRessources(Connection connexion, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            // Gérer l'exception (logger ou relancer)
            e.printStackTrace();
        }

        try {
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException e) {
            // Gérer l'exception (logger ou relancer)
            e.printStackTrace();
        }
    }

    public static void sauvegarderDonnees(String sql, Object... parametres) {
        try (Connection connexion = etablirConnexion();
             PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
    
            for (int i = 0; i < parametres.length; i++) {
                preparedStatement.setObject(i + 1, parametres[i]);
            }
    
            preparedStatement.executeUpdate();
    
            System.out.println("Données enregistrées avec succès.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void sauvegarderDonneesProduit(int numeroReference, String marque, String dateFabrication, double prix) {
        String sql = "INSERT INTO Produit (numeroReference, marque, dateFabrication, prix) VALUES (?, ?, ?, ?)";
        sauvegarderDonnees(sql, numeroReference, marque, dateFabrication, prix);
    }
    
    public static void sauvegarderDonneesOrdinateurDeBureau(int numeroReference, String marque, String dateFabrication, double prix,
    String processeur, int ram, int disqueDur, String systemeExploitation,
    String carteGraphique) {
        String sql = "INSERT INTO OrdinateurDeBureau (numeroReference, marque, dateFabrication, prix, processeur, ram, disqueDur, systemeExploitation, carteGraphique) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        sauvegarderDonnees(sql, numeroReference, marque, dateFabrication, prix, processeur, ram, disqueDur, systemeExploitation, carteGraphique);
        System.out.println("Ordinateur de bureau enregistré avec succès !");
    }

    public static void sauvegarderDonneesOrdinateurPortable(int numeroReference, String marque, String dateFabrication, double prix,
    String processeur, int ram, int disqueDur, String systemeExploitation,
    String typeEcran, double tailleEcran) {
        String sql = "INSERT INTO OrdinateurPortable (numeroReference, marque, dateFabrication, prix, processeur, ram, disqueDur, systemeExploitation, typeEcran, tailleEcran) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        sauvegarderDonnees(sql, numeroReference, marque, dateFabrication, prix, processeur, ram, disqueDur, systemeExploitation, typeEcran, tailleEcran);
        System.out.println("Ordinateur portable enregistré avec succès !");

    }

   
    public static void sauvegarderDonneesImprimante(int numeroReference, String marque, String dateFabrication, double prix, String type, int resolution, int vitesseImpression) {
        String sql = "INSERT INTO Imprimante (numeroReference, marque, dateFabrication, prix, type, resolution, vitesseImpression) VALUES (?, ?, ?, ?, ?, ?, ?)";
        sauvegarderDonnees(sql, numeroReference, marque, dateFabrication, prix, type, resolution, vitesseImpression);
        System.out.println("imprimante enregistré avec succès !");

    }

     public static void sauvegarderDonneesScanners(int numeroReference, String marque, String dateFabrication, double prix, int resolution) {
        String sql = "INSERT INTO Scanners (numeroReference, marque, dateFabrication, prix, resolution) VALUES (?, ?, ?, ?, ?)";
        sauvegarderDonnees(sql, numeroReference, marque, dateFabrication, prix, resolution);
        System.out.println("scanners enregistré avec succès !");

    }
    //System.out.println("fin des enregistrements des produits !\n");
}
