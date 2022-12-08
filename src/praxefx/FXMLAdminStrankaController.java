package praxefx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zakhar Fedorov
 */
public class FXMLAdminStrankaController implements Initializable {

    @FXML
    private Button ButtonOdhlasitSeStrankaAdmin;
    @FXML
    private Button ButtonVyhledatPraxe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ButtonVyhledatPraxe.setOnAction(event ->{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLAdminVyhledatPraxe.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLUzivatelVstupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        
        ButtonOdhlasitSeStrankaAdmin.setOnAction(event ->{
            ButtonOdhlasitSeStrankaAdmin.getScene().getWindow().hide();
            
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
            stage.showAndWait();
        });
    }    
    
}
