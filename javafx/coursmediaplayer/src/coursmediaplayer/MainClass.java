package coursmediaplayer;

import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainClass extends Application {
  Stage stage;
  BorderPane pane=new BorderPane();
  Media media=null;
  MediaPlayer player=null;
  MediaView view=null;  
  FileChooser chooser=null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        stage=window;
      creerFenetre();
      creerMenu();
      boutonMedia();
      showFenetre();
      
    }
    
    
    void creerFenetre(){
        stage.setTitle("Media Player v1.0");
        Scene sc=new Scene(pane,500,500);
        stage.setScene(sc);
    }
    
    void creerMenu(){
        MenuBar menuBar=new MenuBar();
        Menu fichier=new Menu("Fichier");
        Menu edit=new Menu();
        Label lbEdit=new Label("Edition");
        edit.setGraphic(lbEdit);
        lbEdit.setOnMouseClicked(e->callWindow());
        Menu view=new Menu("Affichage");
        Menu apropos=new Menu("Apropos");
        
        // sous-menus
        MenuItem ouvrir=new MenuItem("Ouvrir media");
        ouvrir.setOnAction(e->ouvrirMedia());
        MenuItem quitter=new MenuItem("Quitter");
        quitter.setOnAction(e->quitterMedia());
        MenuItem maximiser=new MenuItem("Maximiser");
        maximiser.setOnAction(e->maximiser());
        MenuItem pleinEcran=new MenuItem("Plein Ecran");
        pleinEcran.setOnAction(e->pleinEcran());
      
        // ajouter les MenuItem dans les menus
        fichier.getItems().addAll(ouvrir,quitter);
        view.getItems().addAll(maximiser,pleinEcran);
        // ajouter les Menus dans la barre de menu
        menuBar.getMenus().addAll(fichier,edit,view,apropos);
        // ajouter le menuBar dans le top du BorderPane
        pane.setTop(menuBar);
        
    }
    
    void showFenetre(){
        stage.setMaximized(true);
        stage.show();
    }
    
    void boutonMedia(){
        HBox hb=new HBox(10);
        Button btStop=new Button("Stop");
        btStop.setOnAction(e->{
          
           if(btStop.getText().equals("Stop")){
              btStop.setText("Play"); 
              Tooltip t=new Tooltip();
              t.setText("Info bulle");
              btStop.setTooltip(t);
               if(player!=null){
                player.play();
            }
           
           }else{
               btStop.setText("Stop");
                if(player!=null){
                player.stop();
            }
           }
        });
        Button btPause=new Button("Pause");
         btPause.setOnAction(e->{
            if(player!=null){
                player.pause();
            }
        });
        Button btMute=new Button("Mute");
        btMute.setOnAction(e->{
            if(player!=null){
                player.setMute(true);
            }
        });
        hb.getChildren().addAll(btStop,btPause,btMute);
         hb.setPadding(new Insets(10,10,15,10));
        pane.setBottom(hb);
        
        
    }
    private void ouvrirMedia() {
     chooser=new FileChooser();
     chooser.setTitle("Choisir une musique ou une video");
     chooser.getExtensionFilters().addAll(new ExtensionFilter("audio/video","*.mp3","*.mp4","*.flv"));
     File fileselect=chooser.showOpenDialog(stage);
     if(fileselect!=null){
         try {
             media=new Media(fileselect.toURI().toURL().toString());
            // passons le media au mediaplayer
            player=new MediaPlayer(media);
            // jouer le media
            player.setAutoPlay(true);
            player.play();
            // passons le mediaPlayer au mediaView
            view=new MediaView(player);
            // ajouter le MediaView au centre du BorderPane
            pane.setCenter(view);
         } catch (MalformedURLException ex) {
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("Erreur ");
            alert.setContentText(ex.getMessage());
            alert.show();
         }
     }
    }

    private void quitterMedia() {
     // System.exit(0);
      stage.close();
    }

    private void maximiser() {
        stage.setMaximized(true);
    }

    private void pleinEcran() {
      stage.setFullScreen(true);
      stage.setFullScreenExitHint("Pressez CTRL+X pour sortir");
      stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("CTRL+X"));
    }

    private void callWindow() {
        FenetreOnglet ong=new FenetreOnglet();
        ong.initModality(Modality.WINDOW_MODAL);
        ong.initOwner(stage);
        //ong.initStyle(StageStyle.UTILITY);
        ong.showAndWait();
    }
    
    
    
}