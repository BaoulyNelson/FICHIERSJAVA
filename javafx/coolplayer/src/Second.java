
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Second extends Application {

    @Override
    public void start(Stage stage) throws Exception {

    
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.WHITE);
        TextField tf = new TextField();
        Button btn = new Button("Click");
        Text text = new Text("Koolitude");

        text.setX(200);
        text.setY(300);
        text.setFont(new Font("Informal Roman", 64));
        text.setFill(Color.RED);
        tf.setFont(new Font("Algerian", 22));
        btn.setLayoutX(300);

        root.getChildren().add(tf);
        root.getChildren().add(btn);
        root.getChildren().add(text);

        stage.setScene(scene);
        stage.setTitle("Entry");
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
