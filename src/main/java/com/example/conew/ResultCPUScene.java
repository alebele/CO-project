package com.example.conew;

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
import javafx.scene.control.TextArea;
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

   /* @FXML
    private TextArea cpuTextArea;*/

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
    private static double cycles;
    private static double runtime;

    public void displayFib(int no,int checkTime){
        cycles = no;
        IBenchmark bench = new CPUBenchmark();
        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.MILI;
        bench.initialize(no);
        bench.warmUp();
        timer.start();
        bench.run(checkTime);
        long time = timer.stop();
        runtime = time;
        String timeMessage = logger.writeTime(time, timeUnit);
        String result = bench.getResult();
        fibLabel.setText(result);
        execLabel.setText(timeMessage);
    }

    public static double displayScore(){
        return cycles/runtime;
    }

    public void initialize(URL URL, ResourceBundle resourceBundle){
        Image myImage=new Image(getClass().getResourceAsStream("ResultImage.jpg"));
        ResultImageView.setImage(myImage);
    }

    public void switchToMainScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchScoreScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("visual.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
