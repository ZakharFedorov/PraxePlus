/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxefx;

import praxe.User;
import DBase.UserDataAccessor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import praxe.ValidMail;

/**
 * FXML Controller class
 *
 * @author Zakhar Fedorov
 */
public class FXMLUzivatelRegistraceController implements Initializable {

    @FXML
    private Button buttonRegistraceUzivatel;
    @FXML
    private TextField FakultaRegistraceUzivatel;
    @FXML
    private TextField jmenoRegistraceUzivatel;
    @FXML
    private TextField prijmeniRegistraceUzivatel;
    @FXML
    private TextField emailRegistraceUzivatel;
    @FXML
    private PasswordField hesloRegistraceUzivatel;
    @FXML
    private ChoiceBox<String> ChoiceBoxRoleRegistraceUzivatel;
    private String[] role = {"ucitel", "student"};
    @FXML
    private ChoiceBox<String> ChoiceBoxRocnikRegistraceUzivatel;
    private String[] rocnik = {"1","2","3"};
    @FXML
    private Button buttonZpetRegistraceUzivatel1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceBoxRoleRegistraceUzivatel.getItems().addAll(role);
        ChoiceBoxRocnikRegistraceUzivatel.getItems().addAll(rocnik);
        
        buttonZpetRegistraceUzivatel1.setOnAction(event ->{
            buttonZpetRegistraceUzivatel1.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLUzivatelVstup.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLUzivatelVstupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        
        buttonRegistraceUzivatel.setOnAction(event ->{
            
            FakultaRegistraceUzivatel.setStyle("-fx-border-color:silver");
            jmenoRegistraceUzivatel.setStyle("-fx-border-color:silver");
            prijmeniRegistraceUzivatel.setStyle("-fx-border-color:silver");
            emailRegistraceUzivatel.setStyle("-fx-border-color:silver");
            hesloRegistraceUzivatel.setStyle("-fx-border-color:silver");
            ChoiceBoxRoleRegistraceUzivatel.setStyle("-fx-border-color:silver");
            ChoiceBoxRocnikRegistraceUzivatel.setStyle("-fx-border-color:silver");
            
            if(FakultaRegistraceUzivatel.getText().length() < 1){
                FakultaRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            if(jmenoRegistraceUzivatel.getText().length() < 1){
                jmenoRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            if(prijmeniRegistraceUzivatel.getText().length() < 1){
                prijmeniRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            if(emailRegistraceUzivatel.getText().length() < 1){
                emailRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            if(hesloRegistraceUzivatel.getText().length() < 1){
                hesloRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            if(ChoiceBoxRoleRegistraceUzivatel.getSelectionModel().getSelectedItem() == null){
                ChoiceBoxRoleRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            if(ChoiceBoxRocnikRegistraceUzivatel.getSelectionModel().getSelectedItem() == null){
                ChoiceBoxRocnikRegistraceUzivatel.setStyle("-fx-border-color:red");
            }
            
            if((FakultaRegistraceUzivatel.getText().length() > 0)&&(jmenoRegistraceUzivatel.getText().length() > 0)
                    &&(prijmeniRegistraceUzivatel.getText().length() > 0)&&(emailRegistraceUzivatel.getText().length() > 0)
                    &&(hesloRegistraceUzivatel.getText().length() > 0)
                    &&(ChoiceBoxRoleRegistraceUzivatel.getSelectionModel().getSelectedItem()!= null)
                    &&(ChoiceBoxRocnikRegistraceUzivatel.getSelectionModel().getSelectedItem()!= null)){
                
                if(ValidMail.validate(emailRegistraceUzivatel.getText()) == true){
                    UserDataAccessor dao = new UserDataAccessor();
                    User s = new User();
                    s.setFirstName(jmenoRegistraceUzivatel.getText());
                    s.setLastName(prijmeniRegistraceUzivatel.getText());
                    s.setYear_of_study(Integer.parseInt(ChoiceBoxRocnikRegistraceUzivatel.getSelectionModel().getSelectedItem()));
                    s.setFaculty(FakultaRegistraceUzivatel.getText());
                    s.setEmail(emailRegistraceUzivatel.getText());
                    s.setRole(ChoiceBoxRoleRegistraceUzivatel.getSelectionModel().getSelectedItem());
                    s.setHeslo(hesloRegistraceUzivatel.getText());
                    System.out.println(s.getHeslo());

                    try {
                        User newUser = dao.save(s);
                        System.out.println(newUser);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLUzivatelRegistraceController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    buttonRegistraceUzivatel.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/praxefx/FXMLUzivatelVstup.fxml"));

                    try {
                        loader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLUzivatelVstupController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    }else{
                        emailRegistraceUzivatel.setStyle("-fx-border-color:red");
                    }
            }
        });
    }    
    
}
