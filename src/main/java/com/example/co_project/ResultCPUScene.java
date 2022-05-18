package com.example.co_project;

import benchmark.bench.CPUBenchmark;
import benchmark.bench.IBenchmark;
import benchmark.logging.ConsoleLogger;
import benchmark.logging.ILogger;
import benchmark.logging.TimeUnit;
import benchmark.timing.ITimer;
import benchmark.timing.Timer;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ResultCPUScene implements Initializable {

    @FXML
    private Label fibLabel;

    @FXML
    private Label execLabel;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private ImageView ResultImageView;

    public void displayFib(int no){
        IBenchmark bench = new CPUBenchmark();
        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.MILI;
        bench.initialize(no);
        bench.warmUp();
        timer.start();
        bench.run();
        long time = timer.stop();
        String timeMessage = logger.writeTime(time, timeUnit);
        String result = bench.getResult();
        fibLabel.setText(result);
        execLabel.setText(timeMessage);
    }

    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("src/Images/ResultImage.jpg");
        Image myImage = new Image(backgroundFile.toURI().toString());
        ResultImageView.setImage(myImage);
    }

    public void switchToMainScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
