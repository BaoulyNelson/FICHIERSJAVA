import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MaFenetreJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Créer une étiquette (label) avec du texte
        Label label = new Label("Bonjour, JavaFX!");

        // Créer une mise en page (layout) de type StackPane et y ajouter l'étiquette
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // Créer une scène avec la mise en page
        Scene scene = new Scene(root, 300, 200);

        // Définir le titre de la fenêtre
        primaryStage.setTitle("Ma Petite Fenêtre JavaFX");

        // Définir la scène sur la fenêtre principale
        primaryStage.setScene(scene);

        // Afficher la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
