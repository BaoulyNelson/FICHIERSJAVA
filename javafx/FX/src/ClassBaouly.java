
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
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ClassBaouly extends Application {

    private Stage stage;
    private BorderPane pane = new BorderPane();
    private Media media = null;
    private MediaPlayer player = null;
    private MediaView view = null;
    private FileChooser chooser = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        stage = window;
        createWindow();
        createMenu();
        createMediaControls();
        showWindow();
    }

    private void createWindow() {
        stage.setTitle("Media Player v1.0");
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
    }

    private void createMenu() {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Fichier");
        Menu editMenu = new Menu("Edition");
        Menu viewMenu = new Menu("Affichage");
        Menu aboutMenu = new Menu("Apropos");

        MenuItem openMenuItem = new MenuItem("Ouvrir média");
        openMenuItem.setOnAction(e -> openMedia());
        MenuItem quitMenuItem = new MenuItem("Quitter");
        quitMenuItem.setOnAction(e -> quitMedia());
        MenuItem maximizeMenuItem = new MenuItem("Maximiser");
        maximizeMenuItem.setOnAction(e -> maximize());
        MenuItem fullScreenMenuItem = new MenuItem("Plein écran");
        fullScreenMenuItem.setOnAction(e -> fullScreen());

        fileMenu.getItems().addAll(openMenuItem, quitMenuItem);
        viewMenu.getItems().addAll(maximizeMenuItem, fullScreenMenuItem);
        menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu, aboutMenu);
        pane.setTop(menuBar);
    }

    private void showWindow() {
        stage.show();
    }

    private void createMediaControls() {
        HBox mediaControls = new HBox(10);
        Button stopButton = new Button("Stop");
        stopButton.setOnAction(e -> {
            if (stopButton.getText().equals("Stop")) {
                stopButton.setText("Play");
                Tooltip t = new Tooltip();
                t.setText("Info bulle");
                stopButton.setTooltip(t);
                if (player != null) {
                    player.play();
                }
            } else {
                stopButton.setText("Stop");
                if (player != null) {
                    player.stop();
                }
            }
        });
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> {
            if (player != null) {
                player.pause();
            }
        });
        Button muteButton = new Button("Mute");
        muteButton.setOnAction(e -> {
            if (player != null) {
                player.setMute(true);
            }
        });
        mediaControls.getChildren().addAll(stopButton, pauseButton, muteButton);
        mediaControls.setPadding(new Insets(10, 10, 15, 10));
        pane.setBottom(mediaControls);
    }

    private void openMedia() {
        chooser = new FileChooser();
        chooser.setTitle("Choisir une musique ou une video");
        chooser.getExtensionFilters().addAll(
                new ExtensionFilter("Audio/Video", "*.mp3", "*.mp4", "*.flv")
        );
        File fileselect = chooser.showOpenDialog(stage);
        if (fileselect != null) {
            try {
                media = new Media(fileselect.toURI().toURL().toString());
                player = new MediaPlayer(media);
                player.setAutoPlay(true);
                player.play();
                view = new MediaView(player);
                pane.setCenter(view);
            } catch (MalformedURLException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
    }

    private void quitMedia() {
        stage.close();
    }

    private void maximize() {
        stage.setMaximized(true);
    }

    private void fullScreen() {
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Pressez CTRL+X pour sortir");
        stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("CTRL+X"));
    }
}
