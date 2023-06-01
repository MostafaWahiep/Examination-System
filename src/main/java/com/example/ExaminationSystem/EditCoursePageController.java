package com.example.ExaminationSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.File;
import javafx.stage.FileChooser;
import java.awt.Desktop;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;



public class EditCoursePageController {


    private int index = -1;

    @FXML
    private ListView<String> filesListView;

    @FXML
    private Label errorLabel;

    @FXML
    private Button addFileButton;

    @FXML
    private TextArea  contentTextArea;

    @FXML
    private ComboBox<String> List;

    @FXML
    void return_event(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource("InstructorMainPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    public void initialize(){
        //looping on number of courses and adding them
        for(int i=0;i<Main.courses.size();i++){
            List.getItems().add(Main.courses.get(i).getName());
        }
    }

    @FXML
    public void updateCourseContent(ActionEvent event) {
        //switch to the update course content page
        if(List.getValue() != null){
            int index = 0;
            for (; index < Main.courses.size(); index++) {
                if (Main.courses.get(index).getName().equals(List.getValue())) {
                    break;
                }
            }
            Main.courses.get(index).setCourse_content(contentTextArea.getText());
        }
        else{
            displayErrorMessage("Please select a course");
        }


    }

    @FXML
    public void addFile(ActionEvent event) {
        //switch to the add file page
    }

    public void displayErrorMessage(String errorMessage) {
        errorLabel.setText(errorMessage);
    }

    @FXML
    void select_course(ActionEvent event) {
        course_selected();
    }

    public void course_selected(){
        displayErrorMessage("");
        if(List.getValue() != null){
            for (index = 0; index < Main.courses.size(); index++) {
                if (Main.courses.get(index).getName().equals(List.getValue())) {
                    break;
                }
            }
            contentTextArea.setText(Main.courses.get(index).getCourse_content());

            String directoryPath = System.getProperty("user.dir")+ "/Content/" + Main.courses.get(index).getName(); // Specify the directory path here
            File directory = new File(directoryPath);

            ObservableList<String> fileList = FXCollections.observableArrayList();
            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            fileList.add(file.getName());
                        }
                    }
                }
            }
            filesListView.setItems(fileList);
        }
    }
    @FXML
    void openFile(MouseEvent event) {
        if (event.getClickCount() == 2 && List.getValue() != null) {
            String directoryPath = System.getProperty("user.dir")+ "/Content/" + Main.courses.get(index).getName() + "/";
            String selectedFileName = filesListView.getSelectionModel().getSelectedItem();
            String filePath = directoryPath + selectedFileName; // Specify the directory path here
            File file = new File(filePath);

            if (file.exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML
    private void deleteFileButton() {
        if (List.getValue() == null) {
            displayErrorMessage("Please select a course");
            return;
        }
        if(filesListView.getSelectionModel().getSelectedItem() == null){
            displayErrorMessage("Please select a file");
            return;
        }
        String directoryPath = System.getProperty("user.dir")+ "/Content/" + Main.courses.get(index).getName() + "/";
        String selectedFileName = filesListView.getSelectionModel().getSelectedItem();
        String filePath = directoryPath + selectedFileName; // Specify the directory path here

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        course_selected();
    }

    @FXML
    private void addFileButton() {
        if (List.getValue() == null) {
            displayErrorMessage("Please select a course");
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");

        // Set the initial directory (optional)
        File initialDirectory = new File("C:");
        fileChooser.setInitialDirectory(initialDirectory);


        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            // Handle the selected file
            System.out.println("Selected File: " + selectedFile.getAbsolutePath());
            // copy the selectedFile to the course directory
            String directoryPath = System.getProperty("user.dir") + "/Content/" + Main.courses.get(index).getName() + "/";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File sourceFile = new File(selectedFile.getAbsolutePath());
            File destinationFile = new File(directoryPath + selectedFile.getName());
            try {
                copyFile(sourceFile.toPath(), destinationFile.toPath());
                course_selected();
                System.out.println("File copied successfully!");
            } catch (IOException e) {
                System.out.println("Error occurred while copying the file: " + e.getMessage());
            }
        }
    }
    private static void copyFile(Path sourcePath, Path destinationPath) throws IOException {
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
}