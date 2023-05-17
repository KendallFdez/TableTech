package com.example.tabletech;

import BinarySearchTree.BinaryTree;
import BinarySearchTree.Nodo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Esta clase inicia la app del server
 */
public class HelloApplication extends Application {
    /**
     * Este metodo inicia el fxml
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("ServerApp");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Este metodo inicia la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}