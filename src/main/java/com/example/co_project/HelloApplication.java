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

        //Stage stage = new Stage();
        //Group root = new Group(); //this is how we declare a root node
        Scene scene = new Scene(root, Color.rgb(232, 232, 232));  //adding the root to teh scene

        Image background = new Image("C:\\Univeristy\\demo\\co_project\\src\\Images\\backgroundImage.jpg");

        stage.setHeight(720);
        stage.setWidth(1080);
        stage.setResizable(false);



        stage.getIcons().add(background);
        stage.setTitle("Fibonacci Sequence");
        stage.setScene(scene);
        stage.show();
    }
}