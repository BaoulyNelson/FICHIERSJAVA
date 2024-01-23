

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class Simulations1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bdp = new BorderPane();
        Scene sc = new Scene(bdp, Color.valueOf("#ab4044"));
        stage.setTitle("Simulations composants");

        //
        // creer des Label
        Label lbId = new Label("ID");
        Label lbPrenom = new Label("Prenom");
        Label lbNom = new Label("Nom");

        // creer des TextField
        TextField txtId = new TextField();
        // augmenter le nombre de colonne du TextField
        txtId.setPrefColumnCount(30);
        txtId.setPromptText("saisir l'ID");
        TextField txtNom = new TextField();
        // augmenter le nombre de colonne du TextField
        txtNom.setPrefColumnCount(30);
        // ajouter un placeholder
        txtNom.setPromptText("saisir le nom");
        TextField txtPrenom = new TextField();
        // augmenter le nombre de colonne du TextField
        txtPrenom.setPrefColumnCount(30);
        // ajouter un placeholder
        txtPrenom.setPromptText("saisir le prenom");
        // 1ere facon
        // creer un HBOX
        VBox hb = new VBox(8, lbId, txtId, lbNom, txtNom, lbPrenom, txtPrenom);
        // ajouter le HBox dans le BorderPane
        bdp.setCenter(hb);
        // ajouter un espace entre le HBox et le BorderPane
        hb.setPadding(new Insets(15, 20, 25, 30));
        stage.setMaximized(false);
        // centrer le HB dans la fenetre
        hb.setAlignment(Pos.CENTER);
        stage.setScene(sc);
        
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
