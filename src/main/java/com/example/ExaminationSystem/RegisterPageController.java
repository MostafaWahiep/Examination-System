package com.example.ExaminationSystem;

import com.example.ExaminationSystem.Models.Instructor;
import com.example.ExaminationSystem.Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterPageController{
    @FXML
    private TextField EmailAddressTextField;

    @FXML
    private TextField IDField;

    @FXML
    private TextField MobileNumberTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private TextField UsernameTextField;


    @FXML
    void btnreg(ActionEvent event) throws IOException {
        if(Main.UserType==2){//instructor

            Instructor i=new Instructor(UsernameTextField.getText(),PasswordTextField.getText(),NameTextField.getText(),MobileNumberTextField.getText(),EmailAddressTextField.getText(),50);
            Main.instructors.add(i);
        } else{//student
            Student s=new Student(UsernameTextField.getText(),PasswordTextField.getText(),NameTextField.getText(),IDField.getText(),MobileNumberTextField.getText(),EmailAddressTextField.getText());
            Main.students.add(s);
        }
        Parent root1 = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
}
