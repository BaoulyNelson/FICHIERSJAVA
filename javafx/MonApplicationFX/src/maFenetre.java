

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class maFenetre extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Scene sc = new Scene(pane, Color.valueOf("white"));

        stage.setTitle("Baouly,ici c'est ta premiere fenetre");
        stage.setWidth(500);
        stage.setHeight(500);

        // stage.setOpacity(0.8);
        // Mode fullScreen
        stage.setFullScreen(false);
        stage.setFullScreenExitHint("Pressez CTRL +X pour sortir");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("CTRL+X"));
        stage.getIcons().add(new Image("FxAPP/Icones/camera.png"));
        // set la scene du Stage
        stage.setScene(sc);

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
        root.getChildren().addAll(nomField, prenomField, ageField, passwordField, envoyer);

        // Création de la scène
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.show();

    }

}
