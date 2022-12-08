package praxefx;

import DBase2.FirmsDataAccessor;
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
import praxe.Firms;
import praxe.User;
import praxe.ValidMail;
    
public class FXMLFirmaVstupController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAutorizace;

    @FXML
    private Button buttonAutorizaceAdmin;

    @FXML
    private Button buttonAutorizaceUser;

    @FXML
    private Button buttonRegistraceAutorizace;

    @FXML
    private TextField loginAutorizace;

    @FXML
    private PasswordField passwordAutorizace;
    
    private static Firms newFirms;
    
    public static Firms getNewFirms(){
        return newFirms;
    }
    
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
        buttonAutorizaceUser.setOnAction(event ->{
            buttonAutorizaceUser.getScene().getWindow().hide();
            
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
        
        buttonAutorizace.setOnAction (event ->{
            loginAutorizace.setStyle("-fx-border-color:silver");
            passwordAutorizace.setStyle("-fx-border-color:silver");
            
            FirmsDataAccessor dao = new FirmsDataAccessor();
            if((ValidMail.validate(loginAutorizace.getText()) == true)){
                String a = loginAutorizace.getText();
                String b = passwordAutorizace.getText();
                Firms firma = null;
                try {
                    firma = dao.findByEmailAndPass(a, b);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLFirmaVstupController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(firma);
                if(firma != null){

                    newFirms = firma;
                    buttonAutorizace.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/praxefx/FXMLFirmaStranka.fxml"));

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
        
    }    
    
}
