/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxefx;

import DBase2.PracticeDataAccessor;
import DBase2.RateDataAccessor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import praxe.Practice;
import praxe.Rate;

/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLFirmaHodnoceniPraxeController implements Initializable {

    @FXML
    private ChoiceBox<String> ChoiceBoxKvalitaHodnoceni;
    @FXML
    private ChoiceBox<String> ChoiceBoxSplneniHodnoceni;
    @FXML
    private ChoiceBox<String> ChoiceBoxSpokojenostHodnoceni;
    private String[] splneni = {"ano", "spíše ano", "spíše ne", "ne"};
    @FXML
    private Button ButtonPotvrditHodnoceni;
    @FXML
    private TextArea TextAreaHodnoceni;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Practice practice = FXMLFirmaVyhledatPraxeController.getPractice_();
        RateDataAccessor dao = new RateDataAccessor();
        PracticeDataAccessor daop = new PracticeDataAccessor();
        ChoiceBoxKvalitaHodnoceni.getItems().addAll(splneni);
        ChoiceBoxSplneniHodnoceni.getItems().addAll(splneni);
        ChoiceBoxSpokojenostHodnoceni.getItems().addAll(splneni);
        
        ButtonPotvrditHodnoceni.setOnAction(event ->{
            ChoiceBoxKvalitaHodnoceni.setStyle("-fx-border-color:silver");
            ChoiceBoxSplneniHodnoceni.setStyle("-fx-border-color:silver");
            ChoiceBoxSplneniHodnoceni.setStyle("-fx-border-color:silver");
            if(ChoiceBoxKvalitaHodnoceni.getSelectionModel().getSelectedItem() == null){
                ChoiceBoxKvalitaHodnoceni.setStyle("-fx-border-color:red");
            }
            if(ChoiceBoxSplneniHodnoceni.getSelectionModel().getSelectedItem() == null){
                ChoiceBoxSplneniHodnoceni.setStyle("-fx-border-color:red");
            }
            if(ChoiceBoxSpokojenostHodnoceni.getSelectionModel().getSelectedItem() == null){
                ChoiceBoxSpokojenostHodnoceni.setStyle("-fx-border-color:red");
            }
                
            if((ChoiceBoxKvalitaHodnoceni.getSelectionModel().getSelectedItem()!= null)
                    && (ChoiceBoxSplneniHodnoceni.getSelectionModel().getSelectedItem()!= null)
                    && (ChoiceBoxSpokojenostHodnoceni.getSelectionModel().getSelectedItem()!= null)){
                
                Rate r = new Rate();
                r.setTema(practice.getTopic());
                r.setSpleni(ChoiceBoxSplneniHodnoceni.getSelectionModel().getSelectedItem());
                r.setKvalita(ChoiceBoxKvalitaHodnoceni.getSelectionModel().getSelectedItem());
                r.setSpokojenost_s_pristupem(ChoiceBoxSpokojenostHodnoceni.getSelectionModel().getSelectedItem());
                r.setRok(practice.getYear());
                if(TextAreaHodnoceni.getText().length()>0){
                    r.setSlovni_hodnoceni(TextAreaHodnoceni.getText());
                }
                try {
                    dao.saveP(r);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLUzivatelRegistraceController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    daop.update3(practice);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLFirmaHodnoceniPraxeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ButtonPotvrditHodnoceni.getScene().getWindow().hide();
            }
        });
    }    
    
}
