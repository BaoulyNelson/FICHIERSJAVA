
// Dans votre classe JavaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainC extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer les boutons
        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");
        Button button3 = new Button("Bouton 3");

        // Appliquer la classe CSS aux boutons
        button1.getStyleClass().add("custom-button");
        button2.getStyleClass().add("custom-button");
        button3.getStyleClass().add("custom-button");

        // Créer la mise en page et ajouter les boutons
        VBox root = new VBox(10);
        root.getChildren().addAll(button1, button2, button3);

        // Créer la scène
        Scene scene = new Scene(root, 400, 300);
        
        // Appliquer la feuille de style CSS à la scène
        scene.getStylesheets().add("path/to/your/stylesheet.css");

        // Configurer la scène principale
        primaryStage.setTitle("Application VLC-like");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
