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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Zakhar Fedorov
 */
public class FXMLRegistraceFirmaORUzivatelController implements Initializable {


    @FXML
    private Button buttonVyberRegistraceFirma;
    @FXML
    private Button buttonVyberRegistraceUzivatel;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonVyberRegistraceFirma.setOnAction(event ->{
            buttonVyberRegistraceFirma.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLFirmaRegistrace.fxml"));
            
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
        
        buttonVyberRegistraceUzivatel.setOnAction(event ->{
            buttonVyberRegistraceUzivatel.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLUzivatelRegistrace.fxml"));
            
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
