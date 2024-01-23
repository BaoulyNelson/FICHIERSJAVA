
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import java.io.File;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.control.Slider;
import javafx.util.Duration;

public class MP3Test extends Application {

    ListView<String> box = new ListView<String>();
    String selectedDirectoryPath;
    Slider progressIndicator = new Slider();
    //progressIndicator.setMin(0);

    public void playMusic() {
        File fichier = new File(selectedDirectoryPath + "/" + box.getSelectionModel().getSelectedItem());
        Media media = new Media(fichier.toURI().toString());
        MediaPlayer md = new MediaPlayer(media);
        md.setOnReady(() -> {
            Duration duration = md.getMedia().getDuration();
            progressIndicator.setMax(duration.toSeconds());
            md.setVolume(100);
            md.setStopTime(duration);
            md.play();
            md.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                progressIndicator.setValue(newValue.toSeconds());
                md.play();
            });
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        File[] fichiers;
        int WinWidth = 500;
        int WinHeight = 300;
        DirectoryChooser dc = new DirectoryChooser();
        dc.setInitialDirectory(new File("C:\\Users\\Nelson Baouly\\Music>"));
        File selectedDirectory = dc.showDialog(stage);
        selectedDirectoryPath = selectedDirectory.getAbsolutePath();
        fichiers = selectedDirectory.listFiles();

        box.setPrefWidth(WinWidth);
        VBox outerBox = new VBox();
        HBox controls = new HBox();
        ScrollPane dpane = new ScrollPane(box);
        dpane.setPrefWidth(WinWidth);
        dpane.setPrefHeight(WinHeight);

        Button play = new Button("Play");
        play.setOnAction(e -> playMusic());
        Button pause = new Button("Pause");
        Button stop = new Button("Stop");
        controls.getChildren().add(play);
        controls.getChildren().add(pause);
        controls.getChildren().add(stop);

        outerBox.getChildren().add(dpane);
        outerBox.getChildren().add(progressIndicator);
        outerBox.getChildren().add(controls);
        Scene scene = new Scene(outerBox, 500, 300, Color.AZURE);

        for (File file : fichiers) {
            box.getItems().add(file.getName());

        }

        stage.setTitle("Kool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
