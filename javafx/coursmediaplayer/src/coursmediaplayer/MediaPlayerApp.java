
package coursmediaplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaPlayerApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créez un objet MediaPlayer et définissez le média à lire
        //String mediaPath = "chemin/vers/le/media.mp4";
        Media media = new Media("");
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Créez un objet MediaView pour afficher le média
        MediaView mediaView = new MediaView(mediaPlayer);

        // Créez un conteneur pour le MediaView
        StackPane root = new StackPane();
        root.getChildren().add(mediaView);

        // Créez une scène et ajoutez le conteneur
        Scene scene = new Scene(root, 800, 600);

        // Définissez la scène sur la fenêtre principale
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lecteur multimédia");
        primaryStage.show();

        // Lancez la lecture du média
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
