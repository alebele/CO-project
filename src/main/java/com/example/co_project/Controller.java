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
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public Button info_button;
    public Button ram_button;
    public Button cpu_button;

    /*
    public ImageView myImageView;
    public Image myImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/MonalisaImage.jpg")));

    public void display(){
        myImageView.setImage(myImage);
    }
     */


    @FXML
    private ImageView myImageView;

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("/Images/MonalisaImage.jpg");
        Image myImage = new Image(backgroundFile.toURI().toString());
        myImageView.setImage(myImage);
    }

}