package com.example.tabletech;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;
import Classes.Server;
import javafx.scene.control.TextField;

public class HelloController implements Initializable {

    @FXML
    private TableColumn<?, ?> password;

    @FXML
    private TableColumn<?, ?> user;

    @FXML
    private TableView<?> userTable;

    @FXML
    private TableColumn<?, ?> userType;

    private Server server;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            server = new Server(new ServerSocket(1234));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error creando el servidor");
        }

        //server.recieveUsername(TextField userfld);
        //server.recievePassword();

    }
}
