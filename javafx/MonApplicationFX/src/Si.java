
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class Si extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Creer un Layout
        HBox hb = new HBox(10);
        // centrer le HBOx
        Scene sc = new Scene(hb);
        hb.setAlignment(Pos.CENTER);
        Label lbUser = new Label("User Name:");
        Label lbPwd = new Label("Password:");
        TextField txtUser = new TextField();
        txtUser.setPromptText("User name");
        txtUser.setPrefColumnCount(30);
        PasswordField txtPwd = new PasswordField();
        txtPwd.setPromptText("Password");
        txtPwd.setPrefColumnCount(30);
        Button btConnect = new Button("Connecter");
        // ajouter les composants dans le HBOX
        hb.getChildren().addAll(lbUser, txtUser, lbPwd, txtPwd, btConnect);
        stage.setTitle("Espace de connexion");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.centerOnScreen();
        // stage.setResizable(false);
        stage.setScene(sc);

        // stage.setMaximized(true);
        // stage.setFullScreen(true);
        // stage.setFullScreenExitHint("CTRL+X pour sortir");
        // stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("CTRL+X"));

        stage.getIcons().add(new Image("FxAPP/Icones/camera.png"));
        stage.show();

    }

}
