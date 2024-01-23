

import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class MainClass extends Application {

    Stage window;
    BorderPane bdp = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        creerForme();
        creerFenetre();

    }

    void creerFenetre() {
        window.setTitle("Fenetre Principale");
        Scene sc = new Scene(bdp);
        window.setScene(sc);
        window.setMaximized(true);
        window.show();
    }

    void creerForme() {
        GridPane gridForm = new GridPane();
        gridForm.setAlignment(Pos.TOP_CENTER);

        gridForm.setPadding(new Insets(20));
        gridForm.setHgap(6);
        gridForm.setVgap(6);

        TextField txtId = new TextField();
        txtId.setText("ESIH-10000");
        txtId.setEditable(false);
        txtId.setPrefColumnCount(20);
        TextField txtNom = new TextField();
        txtNom.setPrefColumnCount(20);
        TextField txtPrenom = new TextField();
        TextField txtLieuNais = new TextField();
        txtPrenom.setPrefColumnCount(20);
        txtLieuNais.setPrefColumnCount(20);
        RadioButton rdMasculin = new RadioButton("Masculin");
        // selectionner la RadioButton masculin par defaut
        rdMasculin.setSelected(true);
        System.out.println("Test:" + rdMasculin.isSelected());
        RadioButton rdFeminin = new RadioButton("Feminin");
        // grouper les RadioButton
        ToggleGroup toggle = new ToggleGroup();
        rdMasculin.setToggleGroup(toggle);
        rdFeminin.setToggleGroup(toggle);

        HBox hboxSexe = new HBox(4, rdMasculin, rdFeminin);
        TextArea txtAdresse = new TextArea();
        txtAdresse.setPrefColumnCount(20);
        txtAdresse.setPrefRowCount(4);
        // creer un ComboBox
        ObservableList<String> discipline = FXCollections.observableArrayList();
        discipline.addAll("Informatique", "Electronique", "Gestion");
        ComboBox<String> cbDiscipline = new ComboBox<String>(discipline);
        cbDiscipline.getSelectionModel().selectFirst();
        DatePicker dateNais = new DatePicker();
        dateNais.setValue(LocalDate.now());
        // ajouter les composants dans le GridPane
        gridForm.add(new Label("ID"), 0, 0);
        gridForm.add(txtId, 1, 0);
        gridForm.add(new Label("Nom"), 0, 1);
        gridForm.add(txtNom, 1, 1);
        gridForm.add(new Label("Prenom"), 0, 2);
        gridForm.add(txtPrenom, 1, 2);
        gridForm.add(new Label("Sexe"), 0, 3);
        gridForm.add(hboxSexe, 1, 3);
        gridForm.add(new Label("Discipline"), 0, 4);
        gridForm.add(cbDiscipline, 1, 4);
        gridForm.add(new Label("Date Naissance"), 0, 5);
        gridForm.add(dateNais, 1, 5);
        gridForm.add(new Label("Lieu Naissance"), 0, 6);
        gridForm.add(txtLieuNais, 1, 6);
        gridForm.add(new Label("Adresse"), 0, 7);
        gridForm.add(txtAdresse, 1, 7);
        // creer des boutons
        Button btSave = new Button("Save");
        Button btDelete = new Button("Delete");
        HBox hbButton = new HBox(5, btSave, btDelete);
        hbButton.setAlignment(Pos.CENTER);
        gridForm.add(hbButton, 1, 8);
        // ajouter le GridPane dans le BorderPane
        bdp.setCenter(gridForm);

    }

}
