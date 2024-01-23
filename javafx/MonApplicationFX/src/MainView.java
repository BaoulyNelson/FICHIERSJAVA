

import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class MainView extends Application {
  Stage stage;
  BorderPane pane = new BorderPane();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage window) throws Exception {
    stage = window;
    creerFormulaire();
    creerFenetre();
  }

  void creerFenetre() {
    stage.setTitle("Fenetre principale");
     stage.getIcons().add(new Image("FxAPP/Icones/camera.png"));
    stage.setMaximized(true);
    Scene sc = new Scene(pane);
    stage.setScene(sc);
    stage.show();
  }

  void creerFormulaire() {
    GridPane grid = new GridPane();
    TextField txtId = new TextField();
    // txtId.setTooltip();
    txtId.setText("ESIH-101001");
    System.out.println("Test:" + txtId.getText());
    txtId.setEditable(false);
    txtId.setPrefColumnCount(25);
    TextField txtNom = new TextField();
    txtNom.setPrefColumnCount(25);
    TextField txtPrenom = new TextField();
    txtPrenom.setPrefColumnCount(25);
    RadioButton rdMasculin = new RadioButton("Masculin");
    rdMasculin.setSelected(true);
    RadioButton rdFeminin = new RadioButton("Feminin");
    
    // grouper les RadioButton
    ToggleGroup group = new ToggleGroup();
    rdMasculin.setToggleGroup(group);
    rdFeminin.setToggleGroup(group);

    // discipline dans un ComboBox
    ObservableList<String> discipline = FXCollections.observableArrayList();
    discipline.addAll("Informatiques", "Gestion", "Economie");
    ComboBox<String> cbDiscipline = new ComboBox<>(discipline);
    cbDiscipline.getSelectionModel().selectFirst();
    System.out.println("Combo:" + cbDiscipline.getSelectionModel().getSelectedItem());
    // date de naissance
    DatePicker txtDateNais = new DatePicker();
    txtDateNais.setValue(LocalDate.now());
    TextField txtLieuNais = new TextField();
    txtLieuNais.setPrefColumnCount(25);

    // adresse
    TextArea txtAdresse = new TextArea();
    txtAdresse.setPrefColumnCount(25);
    txtAdresse.setPrefRowCount(5);
    // ajouter les composants dans le GridPane
    grid.add(new Label("ID"), 0, 0);
    grid.add(txtId, 1, 0);
    grid.add(new Label("Nom"), 0, 1);
    grid.add(txtNom, 1, 1);
    grid.add(new Label("Prenom"), 0, 2);
    grid.add(txtPrenom, 1, 2);
    grid.add(new Label("Sexe"), 0, 3);
    HBox hbSexe = new HBox(5, rdMasculin, rdFeminin);
    grid.add(hbSexe, 1, 3);
    grid.add(new Label("Discipline"), 0, 4);
    grid.add(cbDiscipline, 1, 4);
    grid.add(new Label("Date Naissance"), 0, 5);
    grid.add(txtDateNais, 1, 5);
    grid.add(new Label("Adresse"), 0, 6);
    grid.add(txtAdresse, 1, 6);
    // creer des boutons
    Button btEnregistrer = new Button("Enregistrer");
    Button btSupprimer = new Button("Supprimer");
    HBox hbButton = new HBox(5, btEnregistrer, btSupprimer);
    grid.add(hbButton, 1, 7);
    // ajouter des marges
    grid.setPadding(new Insets(20));
    grid.setHgap(8);
    grid.setVgap(8);

    // ajouter le GridPane dans le BorderPane
    pane.setLeft(grid);
  }

}
