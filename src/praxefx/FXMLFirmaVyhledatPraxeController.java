package praxefx;

import DBase2.PracticeDataAccessor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import praxe.Firms;
import praxe.Practice;

public class FXMLFirmaVyhledatPraxeController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonSpatky;
    
    @FXML
    private Button ButtonCopyPraxe;
    
    @FXML
    private Button ButtonHodnoceni;
    
    @FXML
    private TableView<Practice> TableView;
    
    @FXML
    private ListView<String> ListViewPraxe;

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
    
    private static Practice selectedPractice;
    
    public static Practice getPractice_(){
        return selectedPractice;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PracticeDataAccessor dao = new PracticeDataAccessor();
        ObservableList<Practice> pr = null;
        Firms f = FXMLFirmaVstupController.getNewFirms();
        try {
            pr = FXCollections.observableArrayList(dao.findAllWhereFirm(f.getName()));
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
            
            ButtonCopyPraxe.setDisable(true);
            ButtonHodnoceni.setDisable(true);
            
            selectedPractice = TableView.getSelectionModel().getSelectedItem();
            ListViewPraxe.getItems().add("Tema: "+selectedPractice.getTopic());
            ListViewPraxe.getItems().add("Popis: " +selectedPractice.getDescription());
            ListViewPraxe.getItems().add("Pozadavky: " +selectedPractice.getRequirement());
            ListViewPraxe.getItems().add("Zamereni: " +selectedPractice.getOrientation());
            ListViewPraxe.getItems().add("Mesto: " +selectedPractice.getCity());
            ListViewPraxe.getItems().add("Firma: " +selectedPractice.getFirm_name());
            ListViewPraxe.getItems().add("Kontaktni_Osoba: "+selectedPractice.getConsult_first_name() + " " + selectedPractice.getConsult_last_name() + "   Email: " + selectedPractice.getConsult_email());
            ListViewPraxe.getItems().add("ID_Student: "+selectedPractice.getStudent_id() + "  ID_Ucitel: " + selectedPractice.getTeacher_id());
            ListViewPraxe.getItems().add("Stav: " +selectedPractice.getState());
            ListViewPraxe.getItems().add("Rok: " +selectedPractice.getYear());
            
            if(selectedPractice.getState() == 2){
                ButtonHodnoceni.setDisable(false);
            }
            if(TableView.getSelectionModel() != null){
                ButtonCopyPraxe.setDisable(false);
            }
        });
        
        ButtonCopyPraxe.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLFirmaKopiePraxe.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLUzivatelVstupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            
            ObservableList<Practice> pr2 = null;

            try {
                pr2 = FXCollections.observableArrayList(dao.findAllWhereFirm(f.getName()));
            } catch (SQLException ex) {
                Logger.getLogger(FXMLFirmaVyhledatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
            }


            PozadavkyColumn.setCellValueFactory(new PropertyValueFactory<>("requirement"));
            TemaColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
            ZamereniColumn.setCellValueFactory(new PropertyValueFactory<>("orientation"));
            MistoColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            stavColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

            TableView.setItems(pr2);
        });
        
        ButtonHodnoceni.setOnAction(event ->{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLFirmaHodnoceniPraxe.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLUzivatelVstupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            
            ObservableList<Practice> pr2 = null;

            try {
                pr2 = FXCollections.observableArrayList(dao.findAllWhereFirm(f.getName()));
            } catch (SQLException ex) {
                Logger.getLogger(FXMLFirmaVyhledatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
            }


            PozadavkyColumn.setCellValueFactory(new PropertyValueFactory<>("requirement"));
            TemaColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
            ZamereniColumn.setCellValueFactory(new PropertyValueFactory<>("orientation"));
            MistoColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            stavColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

            TableView.setItems(pr2);
        });
        
        ButtonSpatky.setOnAction(event ->{
            ButtonSpatky.getScene().getWindow().hide();
            
        });
    }    
    
}
