/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxefx;

import DBase.PracticeDataAccessor;
import DBase.UserDataAccessor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import praxe.Practice;
import praxe.User;

/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLAdminPriraditPraxeController implements Initializable {

    @FXML
    private Button ButtonPriradit;

    @FXML
    private Button ButtonSpatky;

    @FXML
    private Label LabelPraxe;

    @FXML
    private TableColumn<User, String> SFakultaColumn;

    @FXML
    private TableColumn<User, String> SJmenoColumn;

    @FXML
    private TableColumn<User, String> SPrijmeniColumn;

    @FXML
    private TableColumn<User, Integer> SRocnikColumn;

    @FXML
    private TableView<User> TableView;

    @FXML
    private TableView<User> TableView1;

    @FXML
    private TableColumn<?, ?> StudentColumn;

    @FXML
    private TableColumn<?, ?> UcitelColumn;

    @FXML
    private TableColumn<User, String> UFakultaColumn;

    @FXML
    private TableColumn<User, String> UJmenoColumn;

    @FXML
    private TableColumn<User, String> UPrijmeniColumn;
    
    private User selectedUserStudent;
    private User selectedUserTeacher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Practice practice = FXMLAdminVyhledatPraxeController.getPractice_();
        UserDataAccessor dao = new UserDataAccessor();
        PracticeDataAccessor dao2 = new PracticeDataAccessor();
        ObservableList<User> pr = null;
        try {
            pr = FXCollections.observableArrayList(dao.findAllStudents());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLFirmaVyhledatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SJmenoColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        SPrijmeniColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        SFakultaColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        SRocnikColumn.setCellValueFactory(new PropertyValueFactory<>("year_of_study"));
        
        TableView.setItems(pr);
        
        ObservableList<User> pr2 = null;
        
        try {
            pr2 = FXCollections.observableArrayList(dao.findAllTeachers());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLFirmaVyhledatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UJmenoColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        UPrijmeniColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        UFakultaColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        
        TableView1.setItems(pr2);
        
        LabelPraxe.setText(practice.getTopic());
        
        TableView.setOnMouseClicked(event ->{
            selectedUserStudent = TableView.getSelectionModel().getSelectedItem();
            
        });
        
        TableView1.setOnMouseClicked(event ->{
            selectedUserTeacher = TableView1.getSelectionModel().getSelectedItem();
            
        });
        
        ButtonPriradit.setOnAction(event ->{
            System.out.println(selectedUserStudent);
            System.out.println(selectedUserTeacher);
            try {
                dao2.update2(practice, selectedUserStudent, selectedUserTeacher);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAdminPriraditPraxeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ButtonPriradit.getScene().getWindow().hide();
            
        });
        
        ButtonSpatky.setOnAction(event ->{
            ButtonSpatky.getScene().getWindow().hide();
            
        });
    }    
    
}
