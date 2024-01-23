import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Formulaire extends JFrame {
    private JTextField nomField, prenomField, niveauField, ageField;
    private JButton validerButton;

    public Formulaire() {
        setTitle("Formulaire etudiant");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nomField = new JTextField(20);
        prenomField = new JTextField(20);
        niveauField = new JTextField(20);
        ageField = new JTextField(20);

        validerButton = new JButton("Valider");

        validerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sauvegarderDonnees(); // Appel de la méthode pour sauvegarder les données
            }
        });

        // Utilisation d'un layout manager pour organiser les composants
        setLayout(new java.awt.GridLayout(6, 2));
        add(new JLabel("Nom:"));
        add(nomField);
        add(new JLabel("Prénom:"));
        add(prenomField);
        add(new JLabel("Niveau:"));
        add(niveauField);
        add(new JLabel("Âge:"));
        add(ageField);
        add(validerButton);

        setVisible(true);
    }
    private void sauvegarderDonnees() {
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/formulaireJava";
            String utilisateur = "root";
            String motDePasse = "";
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Préparer la requête SQL
            String sql = "INSERT INTO etudiant (nom, prenom, niveau, age) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);

            // Récupérer les valeurs depuis les champs du formulaire
            preparedStatement.setString(1, nomField.getText());
            preparedStatement.setString(2, prenomField.getText());
            preparedStatement.setString(3, niveauField.getText());
            preparedStatement.setString(4, ageField.getText());

            // Exécuter la requête d'insertion
            preparedStatement.executeUpdate();

            // Fermer les ressources
            preparedStatement.close();
            connexion.close();

            JOptionPane.showMessageDialog(null, "Données enregistrées avec succès dans la base de données.");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement des données dans la base de données.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Formulaire();
            }
        });
    }
}
