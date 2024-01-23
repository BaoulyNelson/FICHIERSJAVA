
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimulionsConteneur extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        HBox hb = new HBox(10);
        Scene sc = new Scene(hb);

        hb.getChildren().addAll(new Button("Bouton 1"), new Button("Bouton 2"), new Button("Bouton 3"),
                new Button("Bouton 4"));

        HBox hb2 = new HBox(12, new Label("Label 1"));
        hb.getChildren().add(hb2);

        hb.setAlignment(Pos.CENTER);

        stage.setTitle("Ma 2e Fenetre");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setScene(sc);

        stage.getIcons().add(new Image("FxAPP/Icones/camera.png"));
        stage.show();

    }

}
