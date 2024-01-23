
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainAPP extends Application {

    Stage stage = null;
    BorderPane pane = new BorderPane();
    Media media = null;
    MediaPlayer player = null;
    MediaView view = null;
    FileChooser chooser = null;
    MenuItem ouvrirMedia = new MenuItem("Ouvrir media");
    MenuItem quitter = new MenuItem("Quitter");
    MenuItem maximiser = new MenuItem("Maximiser");
    MenuItem pleinEcran = new MenuItem("Plein Ecran");
    Button btStop = new Button("Stop");
    Button btPause = new Button("Pause");
    Button btMute = new Button("Mute");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        stage = window;
        creerFenetre();
        creerMenu();
        boutonMedia();
        showFenetre();
    }

    void creerFenetre() {
        stage.setTitle("Cool Player v1.0");
        pane.setStyle("-fx-background-color:#176ab3");
        Scene sc = new Scene(pane, 500, 500);
        stage.setScene(sc);
    }

    void creerMenu() {
        MenuBar menuBar = new MenuBar();
        Menu fichier = new Menu("Fichier");
        Menu edition = new Menu("Edition");
        Menu affichage = new Menu("Affichage");
        Menu apropos = new Menu("Apropos");

        ouvrirMedia.setOnAction(e -> ouvrirMedia());
        quitter.setOnAction(e -> quitter());
        maximiser.setOnAction(e -> maximiser());
        pleinEcran.setOnAction(e -> pleinEcran());

        fichier.getItems().addAll(ouvrirMedia, quitter);
        affichage.getItems().addAll(maximiser, pleinEcran);

        menuBar.getMenus().addAll(fichier, edition, affichage, apropos);
        pane.setTop(menuBar);
    }

    void showFenetre() {
        stage.show();
    }

    private void ouvrirMedia() {
        chooser = new FileChooser();
        chooser.setTitle("Choisir audio et/ou Video");
        chooser.getExtensionFilters().addAll(
            new ExtensionFilter("Audio/Video", "*.mp3", "*.mp4", "*.flv", "*.ogg")
        );

        File fileSelect = chooser.showOpenDialog(stage);
        if (fileSelect != null) {
            try {
                media = new Media(fileSelect.toURI().toURL().toString());
                player = new MediaPlayer(media);
                player.setAutoPlay(true);
                view = new MediaView(player);
                player.setOnReady(() -> stage.sizeToScene());
                pane.setCenter(view);
            } catch (MalformedURLException ex) {
                Alert message = new Alert(AlertType.ERROR, "Message:" + ex.getMessage());
                message.show();
            }
        }
    }

    void boutonMedia() {
        HBox hbBouton = new HBox(8);
        btStop.setOnAction(e -> stopMedia());
        btPause.setOnAction(e -> pauseMedia());
        btMute.setOnAction(e -> muteMedia());

        hbBouton.setPadding(new Insets(15, 5, 15, 5));
        hbBouton.getChildren().addAll(btStop, btPause, btMute);
        pane.setBottom(hbBouton);
    }

    private void quitter() {
        stage.close();
    }

    private void maximiser() {
        if (maximiser.getText().equals("Maximiser")) {
            stage.setMaximized(true);
            maximiser.setText("Minimiser");
        } else {
            stage.setMaximized(false);
            maximiser.setText("Maximiser");
        }
    }

    private void pleinEcran() {
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("ESC"));
    }

    private void stopMedia() {
        if (player != null) {
            if (btStop.getText().equals("Stop")) {
                player.stop();
                btStop.setText("Play");
            } else {
                player.play();
                btStop.setText("Stop");
            }
        }
    }

    private void pauseMedia() {
        if (player != null) {
            if (btPause.getText().equals("Pause")) {
                player.pause();
                btPause.setText("Play");
            } else {
                player.play();
                btPause.setText("Pause");
            }
        }
    }

    private void muteMedia() {
        if (player != null) {
            if (btMute.getText().equals("Mute")) {
                player.setMute(true);
                btMute.setText("Unmute");
            } else {
                player.setMute(false);
                btMute.setText("Mute");
            }
        }
    }

}
