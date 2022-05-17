package com.example.co_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        Scene scene = new Scene(root, 1080, 720, Color.rgb(232, 232, 232));  //adding the root to teh scene

        //Image icon = new Image("src/Images/backgroundImage.jpg");

        stage.setHeight(720);
        stage.setWidth(1080);
        stage.setResizable(false);

        //stage.getIcons().add(icon);
        stage.setTitle("Fibonacci Sequence");
        stage.setScene(scene);
        stage.show();
    }
}