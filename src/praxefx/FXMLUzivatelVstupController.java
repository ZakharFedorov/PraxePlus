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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import praxe.ValidMail;


/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLUzivatelVstupController  implements Initializable  {

    @FXML
    private TextField loginAutorizace;
    @FXML
    private PasswordField passwordAutorizace;
    @FXML
    private Button buttonAutorizace;
    @FXML
    private Button buttonRegistraceAutorizace;
    
    @FXML
    private Button buttonAutorizaceAdmin;
    @FXML
    private Button buttonAutorizaceFirma;
    
    private static User newUs;
    
    public static User getNewUser(){
        return newUs;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonRegistraceAutorizace.setOnAction(event ->{
            buttonRegistraceAutorizace.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLRegistraceFirmaORUzivatel.fxml"));
            
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
        
        buttonAutorizace.setOnAction (event ->{
            loginAutorizace.setStyle("-fx-border-color:silver");
            UserDataAccessor dao = new UserDataAccessor();
            if((ValidMail.validate(loginAutorizace.getText()) == true)){
                String mail = loginAutorizace.getText();
                String pas = passwordAutorizace.getText();
                User person = null;
                try {
                    person = dao.findByEmailAndPass(mail, pas);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLUzivatelVstupController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(person);
                if(person != null){

                    newUs = person;
                    buttonAutorizace.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/praxefx/FXMLUzivatelStranka.fxml"));

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
                    loginAutorizace.setStyle("-fx-border-color:red");
                    passwordAutorizace.setStyle("-fx-border-color:red");
                }
            }else{
                loginAutorizace.setStyle("-fx-border-color:red");
            }
            
            
            
        });
        buttonAutorizaceAdmin.setOnAction(event ->{
            buttonAutorizace.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLAdminStranka.fxml"));
            
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
        buttonAutorizaceFirma.setOnAction(event ->{
            buttonAutorizace.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLFirmaVstup.fxml"));
            
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
    }
    
}
