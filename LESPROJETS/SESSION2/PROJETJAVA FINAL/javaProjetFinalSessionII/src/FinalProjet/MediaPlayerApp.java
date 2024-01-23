/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProjet;

//import java.awt.Color;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MediaPlayerApp extends Application {
private TableView<MediaFile> mediaTable;
private MediaView mediaView;
private MediaPlayer mediaPlayer;
private ProgressBar progressbar;
private BorderPane borderPane;


public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage stage) {
    BorderPane root = new BorderPane();
   Scene scene = new Scene(root, 800, 600);
  root.setStyle("-fx-background-color:black");
//  backgroundImage();


    // Création de la table des médias
    mediaTable = new TableView<>();
    mediaTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    TableColumn<MediaFile, Integer> idColonne = new TableColumn<>("ID");
    idColonne.setCellValueFactory(new PropertyValueFactory<>("id"));
    TableColumn<MediaFile, String> nomColonne = new TableColumn<>("Nom");
    nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
    TableColumn<MediaFile, String> locationColonne = new TableColumn<>("Emplacement");
    locationColonne.setCellValueFactory(new PropertyValueFactory<>("emplacement"));
    mediaTable.getColumns().addAll(idColonne,nomColonne, locationColonne);
      
// Création des boutons de contrôle
Button lecture = new Button("Lecture");
Button arret = new Button("Arret");
Button muet = new Button("Muet");
Button avancer = new Button("Avancer");
Button reculer = new Button("Reculer");
Button precedent = new Button("Precedent");
Button suivant = new Button("Suivant");
Button augmenter = new Button("Augmenter le volume");
Button diminuer = new Button("Diminuer le volume");
Button rejouer = new Button("Rejouer");

// Création de la barre de progression
progressbar = new ProgressBar();
progressbar.setPrefWidth(400);

// Gestionnaire d'événements pour le bouton d'ouverture de média
Button ouvrir = new Button("Ouvrir");
Button playBack = new Button("Playback");
Button audio = new Button("Audio");
Button video = new Button("Video");
Button sousTitre = new Button("Sous titre");
Button outils = new Button("Outils");
Button afficher = new Button("Affichage");
Button help = new Button("help");

// Gestionnaires d'événements pour les boutons de contrôle
lecture.setOnAction (event-> jouerMedia());
arret.setOnAction (event-> arreterMedia());
muet.setOnAction (event-> muetMedia());
avancer.setOnAction (event-> avancerMedia());
reculer.setOnAction (event-> reculerMedia());
precedent.setOnAction (event-> precedentMedia());
suivant.setOnAction (event-> suivantMedia());
augmenter.setOnAction (event-> augmenterVolume());
diminuer.setOnAction (event-> diminuerVolume());
rejouer.setOnAction (event-> rejouerMedia());


playBack.setOnAction (event->rejouerMedia());
// Création de la boîte horizontale pour les boutons de contrôle
HBox controlButtonsBox = new HBox(10, lecture, arret, muet, avancer, reculer, precedent, suivant, augmenter, diminuer, rejouer);
controlButtonsBox.setPadding (new Insets(10));

// Création de la boîte horizontale pour la barre de progression
HBox progressbarBox = new HBox(progressbar);
progressbarBox.setPadding(new Insets(50));

// Ajout de la boîte de la barre de progression en bas de la fenêtre principale
root.setBottom(progressbarBox);

// Création du conteneur pour le MediaView
mediaView  = new MediaView();
mediaView.setFitWidth (640);
mediaView.setFitHeight (360);

// Création de la boîte verticale pour le MediaView et la table des médias
VBox mediaBox = new VBox(10, mediaView, mediaTable);
mediaBox.setPadding (new Insets(10));

// Ajout des composants à la fenêtre principale
root.setCenter (mediaBox);
root.setBottom (controlButtonsBox);

// Configuration du FileChooser pour l'ouverture de fichiers
FileChooser fileChooser = new FileChooser();
FileChooser.ExtensionFilter mediaFilter = new FileChooser.ExtensionFilter("Fichiers multimedias", "*.mp3", "*.mp4", "*.flv", "*.3gp", "*.wma", "*.wav", "*.ogg", "*.wmv");
fileChooser.getExtensionFilters ().add(mediaFilter);


HBox c = new HBox(80, ouvrir, playBack, audio, video, sousTitre, outils, afficher, help);
c.setPadding (new Insets(60));

//pour mettre à jour la valeur de la ProgressBar en fonction de la progression du média en cours de lecture dans la méthode
if (mediaPlayer != null) {
    mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
        if (mediaPlayer.getTotalDuration() != null) {
            double progress = newValue.toMillis() / mediaPlayer.getTotalDuration().toMillis();
            progressbar.setProgress(progress);
        }
    });
}
// Ouvrir media
ouvrir.setOnAction (event-> {
            File file = fileChooser.showOpenDialog(stage);
    if (file != null) {
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        MediaFile mediaFile = new MediaFile(0, file.getName(), file.getAbsolutePath());
        mediaTable.getItems().add(mediaFile);
    }
}
);

// Création de la boîte horizontale pour le bouton d'ouverture de média
HBox openButtonBox = new HBox(ouvrir,playBack,audio,video,sousTitre,outils,afficher,help);
openButtonBox.setPadding (new Insets(10));

// Ajout de la boîte du bouton d'ouverture en haut de la fenêtre principale
root.setTop (openButtonBox);

stage.setScene (scene);
stage.setTitle ("VLC Media Player");
stage.getIcons ().add(new javafx.scene.image.Image("Icone/ImageVlc.png"));
stage.show ();
}

private void jouerMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

private void arreterMedia() {
if (mediaPlayer != null) {
mediaPlayer.stop();
}
}

private void muetMedia() {
if (mediaPlayer != null) {
mediaPlayer.setMute(!mediaPlayer.isMute());
}
}

private void avancerMedia() {
if (mediaPlayer != null) {
mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(10)));
}
    }

    private void reculerMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(javafx.util.Duration.seconds(10)));
        }
    }

    private void precedentMedia() {
        if (mediaPlayer != null) {
            int positionCourant = mediaTable.getSelectionModel().getSelectedIndex();
            if (positionCourant > 0) {
                mediaTable.getSelectionModel().select(positionCourant - 1);
                MediaFile mediaFile = mediaTable.getSelectionModel().getSelectedItem();
                jouerMediaFichier(mediaFile);
            }
        }
    }

    private void suivantMedia() {
        if (mediaPlayer != null) {
            int positionCourant = mediaTable.getSelectionModel().getSelectedIndex();
            if (positionCourant < mediaTable.getItems().size() - 1) {
                mediaTable.getSelectionModel().select(positionCourant + 1);
                MediaFile mediaFile = mediaTable.getSelectionModel().getSelectedItem();
                jouerMediaFichier(mediaFile);
            }
        }
    }

    private void augmenterVolume() {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(Math.min(1.0, mediaPlayer.getVolume() + 0.1));
        }
    }

    private void diminuerVolume() {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(Math.max(0.0, mediaPlayer.getVolume() - 0.1));
        }
    }

    private void rejouerMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(javafx.util.Duration.ZERO);
            mediaPlayer.play();
        }
    }

private void jouerMediaFichier(MediaFile mediaFile) {
        if (mediaFile != null) {
            Media media = new Media(new File(mediaFile.getEmplacement()).toURI().toString());
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();

}
    }

}