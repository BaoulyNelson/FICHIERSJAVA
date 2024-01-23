
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);
    }
}
