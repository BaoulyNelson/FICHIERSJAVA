

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AutoIncrement extends Application {

    private int currentID = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Auto Increment ID Example");

        VBox root = new VBox(10);
        Button generateButton = new Button("Generate ID");
        generateButton.setOnAction(event -> {
            int generatedID = generateID();
            System.out.println("Generated ID: " + generatedID);
        });

        root.getChildren().add(generateButton);

        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.show();
    }

    private int generateID() {
        int generatedID = currentID;
        currentID++;
        return generatedID;
    }
}
