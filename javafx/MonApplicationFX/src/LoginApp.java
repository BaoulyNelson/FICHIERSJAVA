
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage) {
        
        // Création des composants
        TextField nomField = new TextField();
        nomField.setPromptText("Nom");
        TextField prenomField = new TextField();
        prenomField.setPromptText("prenom");
        TextField ageField = new TextField();
        ageField.setPromptText("ex: 20");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("mot de passe");
        Button envoyer = new Button("Envoyer");

        // Gestionnaire d'événement pour le bouton Envoyer
        envoyer.setOnAction(e -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            int age = Integer.parseInt(ageField.getText());
            String password = passwordField.getText();

            System.out.println("Nom d'utilisateur : " + nom);
            System.out.println("Prenom d'utilisateur: " + prenom);
            System.out.println("L'age d'utilisateur: " + age);
            System.out.println("Mot de passe : " + password);
        });

        // Création du conteneur
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(nomField, prenomField, ageField,passwordField, envoyer);

        // Création de la scène
        Scene scene = new Scene(root, 200, 200);

        // Configuration de la fenêtre principale
        stage.setTitle("Application de connexion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
