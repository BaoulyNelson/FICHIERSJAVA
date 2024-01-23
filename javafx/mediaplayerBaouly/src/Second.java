
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Second extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.WHITE);

        TextField tf = new TextField();
        Button btn = new Button("Cliquer ici baouly");
        Text text = new Text("Baouly");

        text.setX(200);
        text.setY(300);
        text.setFont(new Font("Informal Roman", 24));
        text.setFill(Color.RED);

        tf.setFont(new Font("Algerian", 11));

        // Utilisez HBox au lieu de VBox pour aligner les éléments horizontalement
        HBox hBox = new HBox(tf, btn);
        hBox.setSpacing(10); // Définir l'espace entre les éléments

        // Ajoutez directement le HBox et le texte au groupe racine (root)
        root.getChildren().addAll(hBox, text);

        // Définir la position du HBox
        hBox.setLayoutX(200);
        hBox.setLayoutY(350);

        stage.setScene(scene);
        stage.setTitle("Saisie");
        stage.setResizable(false); // Désactiver la redimension de la fenêtre
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
