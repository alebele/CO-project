package com.example.conew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CPUScene implements Initializable {

    @FXML
    public ImageView ImageViewCPU;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private Button startButton;

    @FXML
    private TextField inputTextFiled;

    private int no;

    public void initialize(URL URL, ResourceBundle resourceBundle){
        Image myImage=new Image(getClass().getResourceAsStream("EnterNumber.jpg"));
        ImageViewCPU.setImage(myImage);
    }

    public void switchToMainScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTheNextScene(ActionEvent event) throws IOException{

        try{
            no = Integer.parseInt(inputTextFiled.getText());

            if(no>=0){
                FXMLLoader loader=new FXMLLoader(getClass().getResource("ResultCPUScene.fxml"));
                root=loader.load();

                ResultCPUScene scene2=loader.getController();
                scene2.displayFib(no);
                //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResultCPUScene.fxml")));
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WrongInputCPUScene.fxml")));
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
            }
        }catch (NumberFormatException e){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WrongInputCPUScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
    }

}
