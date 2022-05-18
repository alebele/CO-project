package com.example.co_project;

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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.GlobalMemory;


public class InfoScene implements Initializable {

    @FXML
    private ImageView ImageViewINFO;

    @FXML
    private Label cpuType;

    @FXML
    private Label ramType;

    @FXML
    private Label osType;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    public void displayOS(){

        SystemInfo os = new SystemInfo();
        OperatingSystem operatingSystem = os.getOperatingSystem();
        String str = "      Operating System:" + "\n    " + operatingSystem.toString();
        osType.setText(str);
    }

    public void displayCPU(){
        SystemInfo cpu = new SystemInfo();
        HardwareAbstractionLayer hardware = cpu.getHardware();
        CentralProcessor processor = hardware.getProcessor();

        CentralProcessor.ProcessorIdentifier processorIdentifier = processor.getProcessorIdentifier();

        String str = "      Control Process Unit "+ "\n";
        str += "    Processor Vendor: " + processorIdentifier.getVendor() + "\n";
        str += "    Processor Name: " + processorIdentifier.getName() + "\n";
        str += "    Frequency (Ghz): " + processorIdentifier.getVendorFreq() / 1000000000.0 + "\n";
        str += "    Number of physical CPUs: " + processor.getPhysicalProcessorCount() + "\n";
        str += "    Number of logical CPUs: " + processor.getLogicalProcessorCount() + "\n";
        cpuType.setText(str);
    }

    public void displayRAM(){
        SystemInfo ram = new SystemInfo();
        HardwareAbstractionLayer hardware = ram.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();
        String str = "      Random Access Memory: " + "\n   " + globalMemory.toString();
        ramType.setText(str);
    }


    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("src/Images/InfoImage.jpg");
        Image myImage = new Image(backgroundFile.toURI().toString());
        ImageViewINFO.setImage(myImage);
        displayOS();
        displayRAM();
        displayCPU();
    }

    public void switchToMainScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
