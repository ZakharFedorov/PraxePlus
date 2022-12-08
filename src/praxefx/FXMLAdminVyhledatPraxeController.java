/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import praxe.Practice;

/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLAdminVyhledatPraxeController implements Initializable {

    @FXML
    private Button ButtonSpatky;
    
    @FXML
    private TableView<Practice> TableView;
    
    @FXML
    private Button ButtonSchvalit;
    
    @FXML
    private Button ButtonEditovat;
    
    @FXML
    private Button ButtonPriradit;
    
    @FXML
    private Button ButtonVymazat;
    
    @FXML
    private ListView<String> ListViewPraxe;

    @FXML
    private TableColumn<Practice, String> MistoColumn;

    @FXML
    private TableColumn<Practice, String> PozadavkyColumn;

    @FXML
    private TableColumn<Practice, String> TemaColumn;

    @FXML
    private TableColumn<Practice, String> ZamereniColumn;

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
        
        
        try {
            pr = FXCollections.observableArrayList(dao.findAll());
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
            ButtonSchvalit.setDisable(true);
            ButtonPriradit.setDisable(true);
            ButtonVymazat.setDisable(true);
            ButtonEditovat.setDisable(true);
            ListViewPraxe.getItems().clear();
            
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
            
            if(selectedPractice.getState() == 0){
                ButtonSchvalit.setDisable(false);
            }
            if(selectedPractice.getState() == 1){
                ButtonPriradit.setDisable(false);
            }
            if(TableView.getSelectionModel() != null){
                ButtonVymazat.setDisable(false);
                ButtonEditovat.setDisable(false);
            }
        });
        
        ButtonSchvalit.setOnAction(event ->{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLAdminSchvalitPraxe.fxml"));
            
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
                pr2 = FXCollections.observableArrayList(dao.findAll());
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
        
        ButtonEditovat.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLAdminEditovatPraxe.fxml"));
            
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
                pr2 = FXCollections.observableArrayList(dao.findAll());
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
        
        ButtonPriradit.setOnAction(event ->{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLAdminPriraditPraxe.fxml"));
            
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
                pr2 = FXCollections.observableArrayList(dao.findAll());
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
        
        ButtonVymazat.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLAdminVymazatPraxePopUp.fxml"));
            
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
                pr2 = FXCollections.observableArrayList(dao.findAll());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLFirmaVyhledatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
            }


            PozadavkyColumn.setCellValueFactory(new PropertyValueFactory<>("requirement"));
            TemaColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
            ZamereniColumn.setCellValueFactory(new PropertyValueFactory<>("orientation"));
            MistoColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            stavColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

            TableView.setItems(pr2);
            
            ButtonSchvalit.setDisable(true);
            ButtonPriradit.setDisable(true);
            ButtonVymazat.setDisable(true);
            ButtonEditovat.setDisable(true);
            
        });
        
        ButtonSpatky.setOnAction(event ->{
            ButtonSpatky.getScene().getWindow().hide();
            
        });
    }    
    
}
