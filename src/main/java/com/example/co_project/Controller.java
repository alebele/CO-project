package com.example.co_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private AnchorPane scene_01;

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("src/Images/MonalisaImage.jpg");

        Image myImage = new Image(backgroundFile.toURI().toString());
        myImageView.setImage(myImage);
    }

    @FXML
    private void openSecondScene(ActionEvent event) throws IOException {
        AnchorPane scene_02= FXMLLoader.load(getClass().getResource("SecondScene.fxml"));
        scene_01.getChildren().removeAll();
        scene_01.getChildren().setAll(scene_02);
    }
}