
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Simulations2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bdp = new BorderPane();
        Scene sc = new Scene(bdp, Color.valueOf("#ab4044"));
        stage.setTitle("Simulations GRidPane");

        // Créer des Labels
        Label lbId = new Label("ID");
        Label lbPrenom = new Label("Prenom");
        Label lbNom = new Label("Nom");

        // Créer des TextFields
        TextField txtId = new TextField("Jean");
        // Augmenter le nombre de colonnes du TextField
        txtId.setPrefColumnCount(30);
        TextField txtNom = new TextField();
        // Augmenter le nombre de colonnes du TextField
        txtNom.setPrefColumnCount(30);
        // Ajouter un placeholder
        txtNom.setPromptText("saisir le nom");
        TextField txtPrenom = new TextField();
        // Augmenter le nombre de colonnes du TextField
        txtPrenom.setPrefColumnCount(30);
        // Ajouter un placeholder
        txtPrenom.setPromptText("saisir le prenom");

        // Créer un GridPane
        GridPane gp = new GridPane();
        // Ajouter les composants dans le GridPane
        Label lbTitre = new Label("Titre");
        gp.add(lbTitre, 1, 0, 4, 1);
        gp.add(lbId, 0, 1);
        gp.add(txtId, 1, 1);
        gp.add(lbNom, 0, 2);
        gp.add(txtNom, 1, 2);
        gp.add(lbPrenom, 0, 3);
        gp.add(txtPrenom, 1, 3);
        gp.add(new Button("Valider"), 1, 5);
        gp.setHgap(8);
        gp.setVgap(8);

        // Ajouter le GridPane dans le BorderPane
        bdp.setCenter(gp);
        // Ajouter un espacement entre le GridPane et le BorderPane
        gp.setPadding(new Insets(15, 20, 25, 30));
        stage.setMaximized(true);
        // Centrer le GridPane dans la fenêtre
        gp.setAlignment(Pos.CENTER);

        stage.setScene(sc);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
