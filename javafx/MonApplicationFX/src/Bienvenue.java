

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Bienvenue extends Application {
//---------------------------------------------
@Override
public void start(Stage premierStage) {
premierStage.setTitle("My First JavaFX App");
BorderPane root = new BorderPane();
Button btnHello = new Button("Hello World");
root.setCenter(btnHello);
Scene scene = new Scene(root, 250, 100);
premierStage.setScene(scene);
premierStage.show();
}
//---------------------------------------------
public static void main(String[] args) {
launch(args);
}
}