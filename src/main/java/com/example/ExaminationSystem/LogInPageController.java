package com.example.ExaminationSystem;

import com.example.ExaminationSystem.Models.TestLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInPageController {

  //  private JFXButton d;

    @FXML
    private Label Wrong_Login;

    @FXML
    private TextField textpass;

    @FXML
    private TextField textuser;

    @FXML
    private Label username1;

    @FXML
    void back(ActionEvent event) throws IOException {
        Main.UserType = 0;
        Parent root1 = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();

        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);

        appst.show();
    }
    @FXML
    void btnlogin(ActionEvent event) throws IOException {
        TestLogin tt = new TestLogin(textuser.getText(),textpass.getText());
        Parent root1 = null;
        if(Main.UserType == 3)
        {
            if(Main.stlogin(tt)!=null) {
                Main.CurrentUser = Main.stlogin(tt);
                root1 = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
                Scene scene1 = new Scene(root1);
                appst.setScene(scene1);
                appst.show();
            }
            else
                Wrong_Login.setText("invalid username or password");
        }
        else if(Main.UserType == 2)
        {
            if(Main.inlogin(tt)!=null) {
                Main.CurrentUser = Main.inlogin(tt);
                root1 = FXMLLoader.load(getClass().getResource("InstructorMainPage.fxml"));
                Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
                Scene scene1 = new Scene(root1);
                appst.setScene(scene1);
                appst.show();
            }
            else
                Wrong_Login.setText("invalid username or password");

        }

    }
    @FXML
    void btnreg(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
}
