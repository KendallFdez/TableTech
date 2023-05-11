module com.example.tabletech {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens com.example.tabletech to javafx.fxml;
    exports com.example.tabletech;
}