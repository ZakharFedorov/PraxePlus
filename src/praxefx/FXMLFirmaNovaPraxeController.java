/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxefx;

import DBase2.KeyWordsDataAccessor;
import DBase2.PracticeDataAccessor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import praxe.Firms;
import praxe.KeyWords;
import praxe.Practice;
import praxe.ValidMail;

/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLFirmaNovaPraxeController implements Initializable {

    @FXML
    private Button buttonUlozitNovaPraxe;
    @FXML
    private TextField emailKONovaPraxe;
    @FXML
    private TextField jmenoKONovaPraxe;
    @FXML
    private TextField mistoVykonuNovaPraxe;
    @FXML
    private TextField prijmeniKONovaPraxe;
    @FXML
    private TextArea pozadavkyNovaPraxe;
    @FXML
    private TextField temaNovaPraxe;
    @FXML
    private TextArea popisNovaPraxe;
    @FXML
    private TextField klicovaSlovaNovaPraxe;
    @FXML
    private CheckMenuItem Check1;
    @FXML
    private CheckMenuItem Check2;
    @FXML
    private CheckMenuItem Check3;
    @FXML
    private CheckMenuItem Check4;
    @FXML
    private CheckMenuItem Check5;
    @FXML
    private CheckMenuItem Check6;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private Menu ZamereniMenu;
    @FXML
    private Button ButtonSpatky;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
//        ChoiceBoxZamereniNovaPraxe.getItems().addAll(zamereni);
//        ChoiceBoxZamereniNovaPraxe.getSelectionModel()
        
        ButtonSpatky.setOnAction(event ->{
            ButtonSpatky.getScene().getWindow().hide();
        });
        
        buttonUlozitNovaPraxe.setOnAction(event ->{
            String ZamereniStr = "";
            
            if(Check1.isSelected()){
                ZamereniStr += Check1.getText()+", ";
            }
            if(Check2.isSelected()){
                ZamereniStr += Check2.getText()+", ";
            }
            if(Check3.isSelected()){
                ZamereniStr += Check3.getText()+", ";
            }
            if(Check4.isSelected()){
                ZamereniStr += Check4.getText()+", ";
            }
            if(Check5.isSelected()){
                ZamereniStr += Check5.getText()+", ";
            }
            if(Check6.isSelected()){
                ZamereniStr += Check6.getText()+", ";
            }
            
            if (ZamereniStr.length() > 0) {
                ZamereniStr = ZamereniStr.substring(0, ZamereniStr.length() - 2);
            }
            
            emailKONovaPraxe.setStyle("-fx-border-color:silver");
            jmenoKONovaPraxe.setStyle("-fx-border-color:silver");
            mistoVykonuNovaPraxe.setStyle("-fx-border-color:silver");
            prijmeniKONovaPraxe.setStyle("-fx-border-color:silver");
            pozadavkyNovaPraxe.setStyle("-fx-border-color:silver");
            temaNovaPraxe.setStyle("-fx-border-color:silver");
            popisNovaPraxe.setStyle("-fx-border-color:silver");
            klicovaSlovaNovaPraxe.setStyle("-fx-border-color:silver");
            MenuBar.setStyle("-fx-border-color:silver");

            if(emailKONovaPraxe.getText().length() < 1){
                emailKONovaPraxe.setStyle("-fx-border-color:red");
            }
            if(jmenoKONovaPraxe.getText().length() < 1){
                jmenoKONovaPraxe.setStyle("-fx-border-color:red");
            }
            if(mistoVykonuNovaPraxe.getText().length()< 1){
                mistoVykonuNovaPraxe.setStyle("-fx-border-color:red");
            }
            if(prijmeniKONovaPraxe.getText().length() < 1){
                prijmeniKONovaPraxe.setStyle("-fx-border-color:red");
            }
            if(pozadavkyNovaPraxe.getText().length() < 1){
                pozadavkyNovaPraxe.setStyle("-fx-border-color:red");
            }
            if(temaNovaPraxe.getText().length() < 1){
                temaNovaPraxe.setStyle("-fx-border-color:red");
            }
            if(popisNovaPraxe.getText().length() < 1){
                popisNovaPraxe.setStyle("-fx-border-color:red");
            }
            if(klicovaSlovaNovaPraxe.getText().length() < 1){
                klicovaSlovaNovaPraxe.setStyle("-fx-border-color:red");
            }
            if(ZamereniStr.length() < 1){
                MenuBar.setStyle("-fx-border-color:red");
            }
            
            
            if((emailKONovaPraxe.getText().length() > 0) &&(jmenoKONovaPraxe.getText().length() > 0)
                    &&(mistoVykonuNovaPraxe.getText().length() > 0) && (prijmeniKONovaPraxe.getText().length() > 0)
                    &&(pozadavkyNovaPraxe.getText().length() > 0) &&(temaNovaPraxe.getText().length() > 0)
                    &&(popisNovaPraxe.getText().length() > 0) && (klicovaSlovaNovaPraxe.getText().length() > 0) 
                    &&(ZamereniStr.length() > 0)){
                
                if((ValidMail.validate(emailKONovaPraxe.getText()) == true)){
                    String[] klice = klicovaSlovaNovaPraxe.getText().split(", ");
                    Firms f = new Firms();
                    f = FXMLFirmaVstupController.getNewFirms();
                    PracticeDataAccessor dao = new PracticeDataAccessor();

                    Practice s = new Practice();
                    s.setTopic(temaNovaPraxe.getText());
                    s.setDescription(popisNovaPraxe.getText());
                    s.setRequirement(pozadavkyNovaPraxe.getText());
                    s.setCity(mistoVykonuNovaPraxe.getText());
                    s.setOrientation(ZamereniStr);
                    s.setState(0);
                    s.setConsult_first_name(jmenoKONovaPraxe.getText());
                    s.setConsult_last_name(prijmeniKONovaPraxe.getText());
                    s.setConsult_email(emailKONovaPraxe.getText());
                    s.setCity(mistoVykonuNovaPraxe.getText());
                    s.setFirm_name(f.getName());
                    s.setYear(Year.now().getValue());

                    try {
                        dao.saveNewP(s);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLUzivatelRegistraceController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    KeyWords w = new KeyWords();
                    KeyWordsDataAccessor dao2 = new KeyWordsDataAccessor();

                    for (String klice1 : klice) {
                        w.setWord(klice1);
                        w.setTopic(s.getTopic());
                        w.setRok(s.getYear());
                        try {
                            dao2.saveP(w);
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLFirmaNovaPraxeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    buttonUlozitNovaPraxe.getScene().getWindow().hide();
                }else{
                    emailKONovaPraxe.setStyle("-fx-border-color:red");
                }
            }
        });
    }
}
