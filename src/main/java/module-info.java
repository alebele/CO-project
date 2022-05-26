module com.example.conew {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.oshi;


    opens com.example.conew to javafx.fxml;
    exports com.example.conew;
}