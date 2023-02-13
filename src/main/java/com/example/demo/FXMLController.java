package com.example.demo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author nourn
 */
public class FXMLController implements Initializable {

    
       @FXML
    private Button admin;

    @FXML
    private ImageView adminss;

    @FXML
    private ImageView inss;

    @FXML
    private Button inst;

    @FXML
    private ImageView stude;

    @FXML
    private Button student;
     
    @FXML
    void buttona(ActionEvent event) throws IOException {
                System.out.println("ss");
        HelloApplication.us = 1;
    }
    @FXML
    void buttons(ActionEvent event) throws IOException {
        System.out.println("ss");
        HelloApplication.us = 3;
        Parent root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
    @FXML
    void buttoni(ActionEvent event) throws IOException {
        System.out.println("ss");
        HelloApplication.us = 2;
        Parent root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
