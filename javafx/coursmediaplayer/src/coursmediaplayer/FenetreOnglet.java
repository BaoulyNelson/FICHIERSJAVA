package coursmediaplayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FenetreOnglet extends Stage {

    TabPane tbPane = new TabPane();
    BorderPane bdp = new BorderPane();
    TableView<ProduitsModel> tbv = new TableView<ProduitsModel>();
    TextField txtId = new TextField();
    TextField txtNom = new TextField();
    TextField txtPrix = new TextField();
    TextField txtQte = new TextField();
    TextArea txtDesc = new TextArea();
    Button btNew = new Button("New");
    Button btSave = new Button("Save");
    Button btDelete = new Button("Delete");
    Button btPrint = new Button("Print");

    public FenetreOnglet() {
        setTitle("Fenetre a Onglet");
        this.setWidth(700);
        this.setHeight(700);
        Scene sc = new Scene(bdp);
        this.setScene(sc);
        toolbar();
        tabPane();
        tableView();
        this.show();
    }

    void toolbar() {
        ToolBar tlBar = new ToolBar();
        Label lbSearch = new Label("Rechercher");
        TextField txtSearch = new TextField();
        txtSearch.setPrefColumnCount(30);
        txtSearch.setPromptText("Rechercher....");
        tlBar.getItems().addAll(btNew, btSave, btDelete, btPrint, lbSearch, txtSearch);
        bdp.setTop(tlBar);

    }

    void tabPane() {
        tbPane.setSide(Side.LEFT);
        Tab t1 = new Tab("Accueil");
        t1.setClosable(false);
        Tab t2 = new Tab("Produits");
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.TOP_LEFT);
        gp.setPadding(new Insets(10));
        gp.setHgap(10);
        gp.setVgap(10);

        gp.add(new Label("ID"), 0, 0);
        gp.add(txtId, 1, 0);
        gp.add(new Label("Nom"), 0, 1);
        gp.add(txtNom, 1, 1);
        gp.add(new Label("Prix"), 0, 2);
        gp.add(txtPrix, 1, 2);
        gp.add(new Label("Qte"), 0, 3);
        gp.add(txtQte, 1, 3);
        gp.add(new Label("Description"), 0, 4);
        gp.add(txtDesc, 1, 4);

        // ajouter le GridPane dans le Tab 1
        t2.setContent(gp);

        Tab t3 = new Tab("Ventes");
        Tab t4 = new Tab("Rapports");
        // ajouter les Tab dans le TabPane
        tbPane.getTabs().addAll(t1, t2, t3, t4);
        // ajouter le TabPane au centre du BorderPane
        bdp.setLeft(tbPane);

    }

    void tableView() {
        TableColumn<ProduitsModel, String> colId = new TableColumn<ProduitsModel, String>("Id");
        TableColumn<ProduitsModel, String> colNom = new TableColumn<ProduitsModel, String>("Nom");
        TableColumn<ProduitsModel, String> colDesc = new TableColumn<ProduitsModel, String>("Desciption");
        TableColumn<ProduitsModel, String> colPrix = new TableColumn<ProduitsModel, String>("Prix");
        TableColumn<ProduitsModel, String> colQte = new TableColumn<ProduitsModel, String>("Quantite");
        
        // ajouter les colonnes dans le TableView
        tbv.getColumns().add(colId);
        tbv.getColumns().add(colNom);
        tbv.getColumns().add(colPrix);
        tbv.getColumns().add(colQte);
        tbv.getColumns().add(colDesc);

        // remplir les cellules
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        // ajouter les donnees dans le tableau
        tbv.setItems(liste());
        // evenement sur le TableView
        tbv.setOnMouseClicked(e -> tableEvent());
        tbv.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        // ajouter le TableView dans le centre du BorderPane
        bdp.setCenter(tbv);
    }

    ObservableList<ProduitsModel> liste() {
        ObservableList<ProduitsModel> liste = FXCollections.observableArrayList();
        liste.add(new ProduitsModel("1000", "Mais", "Simple", 220, 180));
        liste.add(new ProduitsModel("1001", "Lait", "Alaska", 220, 150));
        liste.add(new ProduitsModel("1002", "Oeuf", "Pays", 98, 130));
        liste.add(new ProduitsModel("1003", "Viande", "Sale", 10, 100));
        liste.add(new ProduitsModel("1004", "Pain", "Rasi", 190, 100));
        liste.add(new ProduitsModel("1006", "Cassave", "Cap", 112, 180));
        return liste;
    }
    

    private void tableEvent() {
        ProduitsModel model = tbv.getSelectionModel().getSelectedItem();
        if (model != null) {
            btSave.setText("Update");
            txtId.setText(model.getId());
            txtNom.setText(model.getNom());
            txtPrix.setText("" + model.getPrix());
            txtQte.setText("" + model.getQuantite());
            txtDesc.setText(model.getDescription());

        }
    }
}
