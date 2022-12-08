package praxefx;

import DBase.PracticeDataAccessor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import praxe.Practice;
import praxe.User;


/**
 * FXML Controller class
 *
 * @author Zakhar Fedorov
 */
public class FXMLUzivatelVyhledatPraxeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonSpatky;
    
    @FXML
    private ListView<String> ListViewPraxe;

    @FXML
    private TableView<Practice> TableView;

    @FXML
    private TableColumn<Practice, Integer> IDstudentColumn;

    @FXML
    private TableColumn<Practice, Integer> IDucitelColumn;

    @FXML
    private TableColumn<Practice, String> MistoColumn;

    @FXML
    private TableColumn<Practice, String> PopisColumn;

    @FXML
    private TableColumn<Practice, String> PozadavkyColumn;

    @FXML
    private TableColumn<Practice, String> TemaColumn;

    @FXML
    private TableColumn<Practice, String> ZamereniColumn;

    @FXML
    private TableColumn<Practice, String> emailColumn;

    @FXML
    private TableColumn<Practice, String> lnameColumn;

    @FXML
    private TableColumn<Practice, String> nameColumn;

    @FXML
    private TableColumn<Practice, Integer> stavColumn;

    @FXML
    void initialize() {
        PracticeDataAccessor dao = new PracticeDataAccessor();
        ObservableList<Practice> pr = null;
        User u = FXMLUzivatelVstupController.getNewUser();
        try {
            pr = FXCollections.observableArrayList(dao.findAllWhereStudentStateOne());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLFirmaVyhledatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PozadavkyColumn.setCellValueFactory(new PropertyValueFactory<>("requirement"));
        TemaColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
        ZamereniColumn.setCellValueFactory(new PropertyValueFactory<>("orientation"));
        MistoColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        stavColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
        
        TableView.setItems(pr);
        TableView.setOnMouseClicked(event ->{
            ListViewPraxe.getItems().clear();
            
            Practice newPractice = TableView.getSelectionModel().getSelectedItem();
            ListViewPraxe.getItems().add("Tema: "+newPractice.getTopic());
            ListViewPraxe.getItems().add("Popis: " +newPractice.getDescription());
            ListViewPraxe.getItems().add("Pozadavky: " +newPractice.getRequirement());
            ListViewPraxe.getItems().add("Zamereni: " +newPractice.getOrientation());
            ListViewPraxe.getItems().add("Mesto: " +newPractice.getCity());
            ListViewPraxe.getItems().add("Firma: " +newPractice.getFirm_name());
            ListViewPraxe.getItems().add("Kontaktni_Osoba: "+newPractice.getConsult_first_name() + " " + newPractice.getConsult_last_name() + "   Email: " + newPractice.getConsult_email());
            ListViewPraxe.getItems().add("ID_Student: "+newPractice.getStudent_id() + "  ID_Ucitel: " + newPractice.getTeacher_id());
            ListViewPraxe.getItems().add("Stav: " +newPractice.getState());
            ListViewPraxe.getItems().add("Rok: " +newPractice.getYear());
            
        });
        
        ButtonSpatky.setOnAction(event ->{
        ButtonSpatky.getScene().getWindow().hide();

        });
    }
}