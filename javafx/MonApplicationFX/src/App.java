
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("simulation Baouly jodia");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setMaximized(true);

        // Create un layout
        BorderPane bdp = new BorderPane();

        // Donner une couleur a l'arriere-plan
        bdp.setStyle("-fx-background-color: #ffff");

        // Creation des composantes
        Label lbId = new Label("ID");
        Label lbNom = new Label("Nom");
        Label lbPrenom = new Label("Prenom");
        Button lbEnvoyer = new Button("Envoyer");

        // Creation des textfield
        TextField IDField = new TextField();
        IDField.setPromptText("ID");
        TextField nomField = new TextField();
        nomField.setPromptText("nom");
        TextField prenomField = new TextField();
        prenomField.setPromptText("prenom");
        // Creer une scene
        Scene sc = new Scene(bdp);
        stage.setScene(sc);
        stage.setMaximized(false);
       
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(lbId, IDField, lbNom, nomField, lbPrenom, prenomField, lbEnvoyer);

        bdp.setCenter(root);

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
}
