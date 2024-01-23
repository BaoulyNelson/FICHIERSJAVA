import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class EnregistrementDonnees {

    public static String URL = "jdbc:mysql://localhost:3306/gestionbacheliers";
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
    
   public static void sauvegarderDonneesBacheliers(String matricule, String nom, String prenom, int age, String numeroTelephone) {
    String sql = "INSERT INTO Bachelier (matricule, nom, prenom, age, numeroTelephone) VALUES (?, ?, ?, ?, ?)";
    sauvegarderDonnees(sql, matricule, nom, prenom, age, numeroTelephone);
    System.out.println("donnees des bacheliers sauvegardees dans la base avec succes");
}

public static void sauvegarderDonneesExamenBac(String matricule, int mathematiques, int philosophie, int sciencesSociales, int[] autresMatieres) {
    String sql = "INSERT INTO ExamenBac (matricule, mathematiques, philosophie, sciencesSociales, autresMatieres) VALUES (?, ?, ?, ?, ?)";
    sauvegarderDonnees(sql, matricule, mathematiques, philosophie, sciencesSociales, Arrays.toString(autresMatieres));
    System.out.println("Notes d'examen enregistrées avec succès !");
}

public static void sauvegarderDonneesResultat(String matricule, int totalPoints, double moyenne, String mention) {
    String sql = "INSERT INTO ResultatsBac (matricule, totalPoints, moyenne, mention) VALUES (?, ?, ?, ?)";
    sauvegarderDonnees(sql, matricule, totalPoints, moyenne, mention);
    System.out.println("resultat publie");
}

}
