/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Пользователь
 */
public class FXMLUzivatelStrankaController implements Initializable {

    @FXML
    private Button ButtonVsechnyPraxeStrankaUzivatel;
    @FXML
    private Button ButtonOdhlasitSeStrankaUzivatel;
    @FXML
    private Button ButtonMojePraxeStrankaUzivatel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ButtonOdhlasitSeStrankaUzivatel.setOnAction(event ->{
            ButtonOdhlasitSeStrankaUzivatel.getScene().getWindow().hide();
            
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
        //Доделать
        ButtonVsechnyPraxeStrankaUzivatel.setOnAction(event ->{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLUzivatelVyhledatPraxe.fxml"));
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
        
        ButtonMojePraxeStrankaUzivatel.setOnAction(event ->{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/praxefx/FXMLUzivatelMojePraxe.fxml"));
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
