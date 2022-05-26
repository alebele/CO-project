package com.example.conew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class VisualController implements Initializable {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private Label cpuScoreLabel;

    @FXML
    private Label ramScoreLabel;

    @FXML
    private ImageView thisImageView;

    public void initialize(URL URL, ResourceBundle resourceBundle){
        Image myImage=new Image(getClass().getResourceAsStream("testFinal.png"));
        thisImageView.setImage(myImage);
        cpuScoreLabel.setText(""+ResultCPUScene.displayScore());
        ramScoreLabel.setText(""+ResultRAMScene.getRamScore());
    }

    public void switchToMainScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
