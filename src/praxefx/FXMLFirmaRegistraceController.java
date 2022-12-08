package praxefx;

import praxe.Firms;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import praxe.ValidMail;

/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLFirmaRegistraceController implements Initializable {

    @FXML
    private Button buttonRegistraceFirma;
    @FXML
    private Button buttonZpetRegistraceFirma;
    @FXML
    private TextField nazevFirmyRegistraceFirma;
    @FXML
    private TextField jmenoRegistraceFirma;
    @FXML
    private TextField mestoRegistraceFirma;
    @FXML
    private TextField prijmeniRegistraceFirma;
    @FXML
    private TextField emailRegistraceFirma;
    @FXML
    private PasswordField hesloRegistraceFirma;
    @FXML
    private CheckBox chekboxPobockaRegistraceFirma;
    @FXML
    private TextField pobockaRegistraceFirma;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonRegistraceFirma.setOnAction(event -> {
            nazevFirmyRegistraceFirma.setStyle("-fx-border-color:silver");
            jmenoRegistraceFirma.setStyle("-fx-border-color:silver");
            prijmeniRegistraceFirma.setStyle("-fx-border-color:silver");
            mestoRegistraceFirma.setStyle("-fx-border-color:silver");
            hesloRegistraceFirma.setStyle("-fx-border-color:silver");
            emailRegistraceFirma.setStyle("-fx-border-color:silver");
            
            if(nazevFirmyRegistraceFirma.getText().length() < 1){
                nazevFirmyRegistraceFirma.setStyle("-fx-border-color:red");
            }
            if(jmenoRegistraceFirma.getText().length() < 1){
                jmenoRegistraceFirma.setStyle("-fx-border-color:red");
            }
            if(prijmeniRegistraceFirma.getText().length() < 1){
                prijmeniRegistraceFirma.setStyle("-fx-border-color:red");
            }
            if(mestoRegistraceFirma.getText().length() < 1){
                mestoRegistraceFirma.setStyle("-fx-border-color:red");
            }
            if(hesloRegistraceFirma.getText().length() < 1){
                hesloRegistraceFirma.setStyle("-fx-border-color:red");
            }
            if(emailRegistraceFirma.getText().length() < 1){
                emailRegistraceFirma.setStyle("-fx-border-color:red");
            }
            
            
            
            
            if((nazevFirmyRegistraceFirma.getText().length() > 0) && (jmenoRegistraceFirma.getText().length() > 0)
                    &&(prijmeniRegistraceFirma.getText().length() > 0) &&(mestoRegistraceFirma.getText().length() > 0)
                    &&(hesloRegistraceFirma.getText().length() > 0) && (emailRegistraceFirma.getText().length() > 0)){
                
                if(ValidMail.validate(emailRegistraceFirma.getText()) == true){
                    if(pobockaRegistraceFirma.getText().length() < 1){
                        pobockaRegistraceFirma.setText(null);
                    }
                    
                    System.out.println(hesloRegistraceFirma.getText());
                    System.out.println(emailRegistraceFirma.getText());
                    FirmsDataAccessor dao = new FirmsDataAccessor();
                    Firms f = new Firms();
                    f.setName(nazevFirmyRegistraceFirma.getText());
                    f.setBranch_office(pobockaRegistraceFirma.getText());
                    f.setFirst_name_cp(jmenoRegistraceFirma.getText());
                    f.setLast_name_cp(prijmeniRegistraceFirma.getText());
                    f.setEmail_cp(emailRegistraceFirma.getText());
                    f.setCity(mestoRegistraceFirma.getText());
                    f.setPassword_cp(hesloRegistraceFirma.getText());

                    try {
                        Firms newFirms = dao.save(f);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLFirmaRegistraceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    buttonRegistraceFirma.getScene().getWindow().hide();
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
                    emailRegistraceFirma.setStyle("-fx-border-color:red");
                }
            }
        });
        
        buttonZpetRegistraceFirma.setOnAction(event -> {
            buttonZpetRegistraceFirma.getScene().getWindow().hide();

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

        chekboxPobockaRegistraceFirma.setOnAction(event -> {
            if(chekboxPobockaRegistraceFirma.isSelected()){
                pobockaRegistraceFirma.setDisable(false);
            }
            if(!chekboxPobockaRegistraceFirma.isSelected()){
                pobockaRegistraceFirma.setDisable(true);
            }
        });
    }

}
