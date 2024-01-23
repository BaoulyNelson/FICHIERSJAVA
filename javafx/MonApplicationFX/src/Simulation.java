
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Simulation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("simulation Baouly jodia ");
        stage.setWidth(500);
        stage.setHeight(500);

        // Create un layout
        BorderPane bdp = new BorderPane();

        // Donner une couleur a l'arriere-plan
        bdp.setStyle("-fx-background-color: #a56091");
        // Creation des composantes
        // Label lbId = new Label("ID");
        // Label lbNom = new Label("Nom");
        // Label lbPrenom = new Label("Prenom");
        // Button lbEnvoyer = new Button("Envoyer");

        // Creation des textfield
        TextField IDField = new TextField();
        IDField.setPromptText("ID");
        TextField nomField = new TextField();
        nomField.setPromptText("nom");
        TextField prenomField = new TextField();
        prenomField.setPromptText("prenom");
        Button EnvoyerField = new Button("Envoyer");

        // Creer une scene
        Scene sc = new Scene(bdp);
        stage.setScene(sc);
        stage.setMaximized(false);
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(IDField, nomField, prenomField, EnvoyerField);

        bdp.setCenter(root);
        System.out.println("ID d'utilisateur : " + IDField);
        System.out.println("nom d'utilisateur: " + nomField);
        System.out.println("Prenom d'utilisateur: " + prenomField);

        stage.show();
    }
}
