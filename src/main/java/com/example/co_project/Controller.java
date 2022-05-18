package com.example.co_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button info_button;
    @FXML
    private Button ram_button;
    @FXML
    private Button cpu_button;
    @FXML
    private ImageView myImageView;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    private AnchorPane scene_01;

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("src/Images/MonalisaImage.jpg");
        Image myImage = new Image(backgroundFile.toURI().toString());
        myImageView.setImage(myImage);
    }


    public void switchToInfoScene(ActionEvent event) throws IOException{

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InfoScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCPUScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CPUScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}