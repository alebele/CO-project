module com.example.co_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;

    opens com.example.co_project to javafx.fxml;
    exports com.example.co_project;
}