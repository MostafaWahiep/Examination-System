package com.example.demo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class MainPageController implements Initializable {

    
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

        Main.us = 1;
    }
    @FXML
    void buttons(ActionEvent event) throws IOException {

        Main.us = 3;
        Parent root1 = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.setTitle(" ");
        appst.show();
    }
    @FXML
    void buttoni(ActionEvent event) throws IOException {

        Main.us = 2;
        Parent root1 = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.setTitle(" ");
        appst.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
