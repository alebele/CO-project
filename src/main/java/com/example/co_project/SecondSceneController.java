package com.example.co_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SecondSceneController {
    @FXML
    private AnchorPane scene_02;

    @FXML
    private void goBackScene(ActionEvent event) throws IOException {
        AnchorPane scene_01= FXMLLoader.load(getClass().getResource("FirstScene.fxml"));
        scene_02.getChildren().removeAll();
        scene_02.getChildren().setAll(scene_01);
    }
}
