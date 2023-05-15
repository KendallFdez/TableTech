module com.example.tabletech {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
    requires lombok;
    requires java.xml;

    opens com.example.tabletech to javafx.fxml;
    exports com.example.tabletech;
}