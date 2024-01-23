import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FormulaireNonGraphique {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom :");
        String nom = scanner.nextLine();

        System.out.print("Prenom :");
        String prenom = scanner.nextLine();

        System.out.print("Niveau :");
        String niveau = scanner.nextLine();

        System.out.print("Age :");
        int age = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le saut de ligne restant


        // Appel à la fonction pour sauvegarder les données dans la base de données
        sauvegarderDonnees(nom, prenom, niveau, age);

        // Fermer le scanner
        scanner.close();
    }

    private static void sauvegarderDonnees(String nom, String prenom, String niveau, int age) {
        String url = "jdbc:mysql://localhost:3306/formulaireJava";
        String utilisateur = "root";
        String motDePasse = "";

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion à la base de données
            Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Préparer la requête SQL pour insérer les données
            String sql = "INSERT INTO formulaire (nom, prenom, niveau, age) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, niveau);
            preparedStatement.setInt(4, age);

            // Exécuter la requête
            preparedStatement.executeUpdate();

            // Fermer les ressources
            preparedStatement.close();
            connection.close();

            System.out.println("Données enregistrées avec succès dans la base de données."+url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
