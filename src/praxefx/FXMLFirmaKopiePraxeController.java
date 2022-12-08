/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxefx;

import DBase2.KeyWordsDataAccessor;
import DBase2.PracticeDataAccessor;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import praxe.Firms;
import praxe.KeyWords;
import praxe.Practice;
import praxe.ValidMail;

/**
 * FXML Controller class
 *
 * @author Пользователь
 */
public class FXMLFirmaKopiePraxeController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonSpatky;

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
    private Button buttonUlozitKopiePraxe;

    @FXML
    private TextField emailKONovaPraxe;

    @FXML
    private TextField jmenoKONovaPraxe;

    @FXML
    private TextField klicovaSlovaNovaPraxe;

    @FXML
    private TextField mistoVykonuNovaPraxe;

    @FXML
    private TextArea popisNovaPraxe;

    @FXML
    private TextArea pozadavkyNovaPraxe;

    @FXML
    private TextField prijmeniKONovaPraxe;

    @FXML
    private TextField temaNovaPraxe;
    
    private List<KeyWords> keysList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Practice practice = FXMLFirmaVyhledatPraxeController.getPractice_();
        emailKONovaPraxe.setText(practice.getConsult_email());
        jmenoKONovaPraxe.setText(practice.getConsult_first_name());
        prijmeniKONovaPraxe.setText(practice.getConsult_last_name());
        popisNovaPraxe.setText(practice.getDescription());
        mistoVykonuNovaPraxe.setText(practice.getCity());
        pozadavkyNovaPraxe.setText(practice.getRequirement());
        temaNovaPraxe.setText(practice.getTopic()+" Kopie");
        
        KeyWordsDataAccessor daow = new KeyWordsDataAccessor();
        PracticeDataAccessor dao = new PracticeDataAccessor();
        
        String klice = "";
        try {
            keysList = daow.findAllFromPractice(practice);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAdminSchvalitPraxeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < keysList.size(); i++){
            klice += keysList.get(i).getWord() + ", ";
        }
        if (klice.length() > 0) {
                klice = klice.substring(0, klice.length() - 2);
        }
        klicovaSlovaNovaPraxe.setText(klice);
        
        String[] poleZamereni = practice.getOrientation().split(",");
        for(int i = 0; i < poleZamereni.length; i++){
            poleZamereni[i] = poleZamereni[i].trim();
            if(poleZamereni[i].equals(Check1.getText())){
                Check1.setSelected(true);
            }
            if(poleZamereni[i].equals(Check2.getText())){
                Check2.setSelected(true);
            }
            if(poleZamereni[i].equals(Check3.getText())){
                Check3.setSelected(true);
            }
            if(poleZamereni[i].equals(Check4.getText())){
                Check4.setSelected(true);
            }
            if(poleZamereni[i].equals(Check5.getText())){
                Check5.setSelected(true);
            }
            if(poleZamereni[i].equals(Check6.getText())){
                Check6.setSelected(true);
            }
        }
        buttonUlozitKopiePraxe.setOnAction(event ->{
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

            if((emailKONovaPraxe.getText().length() > 0)&&(jmenoKONovaPraxe.getText().length() > 0)
                    &&(mistoVykonuNovaPraxe.getText().length() > 0) && (prijmeniKONovaPraxe.getText().length() > 0)
                    &&(pozadavkyNovaPraxe.getText().length() > 0) &&(temaNovaPraxe.getText().length() > 0)
                    &&(popisNovaPraxe.getText().length() > 0) && (klicovaSlovaNovaPraxe.getText().length() > 0) 
                    &&(ZamereniStr.length() > 0)){


                if((ValidMail.validate(emailKONovaPraxe.getText()) == true)){
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
                    s.setFirm_name(practice.getFirm_name());
                    s.setYear(Year.now().getValue());
                    try {
                        dao.saveNewP(s);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLUzivatelRegistraceController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String[] kliceArr = klicovaSlovaNovaPraxe.getText().split(", ");
                    KeyWords w = new KeyWords();
                    KeyWordsDataAccessor dao2 = new KeyWordsDataAccessor();

                    for (String kliceArr1 : kliceArr) {
                        w.setWord(kliceArr1);
                        w.setTopic(s.getTopic());
                        w.setRok(s.getYear());
                        try {
                            dao2.saveP(w);
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLFirmaNovaPraxeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    buttonUlozitKopiePraxe.getScene().getWindow().hide();
                }else{
                    emailKONovaPraxe.setStyle("-fx-border-color:red");
                }
            }
        });
    }    
    
}
