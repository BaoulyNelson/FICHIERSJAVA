

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class SimulatiOns extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Creer un Layout
        BorderPane bd = new BorderPane();
        bd.setStyle("-fx-background-color:blue");

        // creer un scene
        Scene sc = new Scene(bd);
        //
        stage.setTitle("Ma 2e Fenetre");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setScene(sc);

        // stage.setMaximized(true);
        // stage.setFullScreen(true);
        // stage.setFullScreenExitHint("CTRL+X pour sortir");
        // stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("CTRL+X"));
        stage.getIcons().add(new Image("FxAPP/Icones/camera.png"));
        stage.show();

    }

}
