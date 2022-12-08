package praxefx;

import DBase.KeyWordsDataAccessor;
import DBase.PracticeDataAccessor;
import DBase.RateDataAccessor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import praxe.Practice;

/**
 * FXML Controller class
 *
 * @author Zakhar Fedorov
 */
public class FXMLAdminVymazatPraxePopUpController implements Initializable {
    
    @FXML
    private Button ButtonNo;

    @FXML
    private Button ButtonYes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Practice practice = FXMLAdminVyhledatPraxeController.getPractice_();
        ButtonYes.setOnAction(event ->{
            PracticeDataAccessor dao = new PracticeDataAccessor();
            KeyWordsDataAccessor daow = new KeyWordsDataAccessor();
            RateDataAccessor daor = new RateDataAccessor();
            try {
                daow.deletePracticeP(practice);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAdminVymazatPraxePopUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(practice.getState() == 3){
                try {
                    daor.deletePracticeP(practice);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLAdminVymazatPraxePopUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                dao.deleteP(practice);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAdminEditovatPraxeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ButtonYes.getScene().getWindow().hide();
            
        });
        ButtonNo.setOnAction(event ->{
            ButtonNo.getScene().getWindow().hide();
            
        });
    }    
    
}
