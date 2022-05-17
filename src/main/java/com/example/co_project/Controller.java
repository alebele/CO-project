package com.example.co_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import java.io.File;
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

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("src/Images/MonalisaImage.jpg");

        Image myImage = new Image(backgroundFile.toURI().toString());
        myImageView.setImage(myImage);
    }

}