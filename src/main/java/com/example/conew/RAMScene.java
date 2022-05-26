package com.example.conew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RAMScene implements Initializable {

    @FXML
    public TextField inputTextFiled;

    @FXML
    private ImageView RAMImageView;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField secondsTextField;

    @FXML
    private TextField cellsTextField;

    public void initialize(URL URL, ResourceBundle resourceBundle){
        Image myImage=new Image(Objects.requireNonNull(getClass().getResourceAsStream("RAMImage.jpg")));
        RAMImageView.setImage(myImage);
    }

    private int no;
    public void switchToMainScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private int cells;
    private int checkTime;

    public void switchToTheNextScene(ActionEvent event) throws IOException{

        try{
            no = Integer.parseInt(inputTextField.getText());
            cells = Integer.parseInt(cellsTextField.getText());
            checkTime = Integer.parseInt(secondsTextField.getText());
            if(no>=0){
                FXMLLoader loader=new FXMLLoader(getClass().getResource("ResultRAMScene.fxml"));
                root=loader.load();

                ResultRAMScene scene2=loader.getController();
                scene2.displayRAM(no,cells,checkTime);

                //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResultRAMScene.fxml")));
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WrongInputRAMScene.fxml")));
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
            }
        }catch (NumberFormatException e){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WrongInputRAMScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
    }
}
