package com.example.tabletech;

import BinarySearchTree.BinaryTree;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;
import Classes.Server;
import Classes.User;
import LinkedList.ListaEnlazada;
import LinkedList.Nodo;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Esta clase es el controlador de la aplicacion
 */
public class HelloController implements Initializable {

    @FXML
    private TextField password;

    @FXML
    private AnchorPane serverApp;

    @FXML
    private Button loginbtn;

    @FXML
    private TextField username;

    private Server server;

    /**
     * Metodo que inicia la logica del controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            server = new Server(new ServerSocket(1234));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error creando el servidor");
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        BinaryTree arbolAdmin = new BinaryTree();
        BinaryTree arbolClient = new BinaryTree();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("C:\\Users\\jbarr\\OneDrive\\Documentos\\TEC\\Semestre I 2023\\Algoritmos I\\Proyectos Java\\TableTech\\src\\main\\resources\\com\\example\\tabletech\\admins.xml"));
            doc.getDocumentElement().normalize();
            NodeList userList = doc.getElementsByTagName("Username");
            for (int i = 0; i < userList.getLength(); i++){
                Node user = userList.item(i);
                if (user.getNodeType() == Node.ELEMENT_NODE){
                    Element userElement = (Element) user;
                    System.out.println("Username: " + userElement.getAttribute("user"));

                    NodeList userDetails = user.getChildNodes();
                    for(int j = 0; j < userDetails.getLength(); j++){
                        Node detail = userDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE){
                            Element detailElement = (Element) detail;
                            System.out.println("    " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                            arbolAdmin.insert(detailElement.getAttribute("value"));
                            arbolAdmin.insert(userElement.getAttribute("user"));
                        }
                    }
                }
            }
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("C:\\Users\\jbarr\\OneDrive\\Documentos\\TEC\\Semestre I 2023\\Algoritmos I\\Proyectos Java\\TableTech\\src\\main\\resources\\com\\example\\tabletech\\clients.xml"));
            doc.getDocumentElement().normalize();
            NodeList userList = doc.getElementsByTagName("Username");
            for (int i = 0; i < userList.getLength(); i++){
                Node user = userList.item(i);
                if (user.getNodeType() == Node.ELEMENT_NODE){
                    Element userElement = (Element) user;
                    System.out.println("Username: " + userElement.getAttribute("user"));
                    NodeList userDetails = user.getChildNodes();
                    for(int j = 0; j < userDetails.getLength(); j++){
                        Node detail = userDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE){
                            Element detailElement = (Element) detail;
                            System.out.println("    " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                            arbolClient.insert(detailElement.getAttribute("value"));
                            arbolClient.insert(userElement.getAttribute("user"));
                        }
                    }
                }
            }
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        server.recieveMessageFromClient(username, password);

        loginbtn.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Metodo que permite enviar un mensaje al cliente
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                if (arbolAdmin.contains(username.getText()) && arbolAdmin.contains(password.getText())){
                    server.sendMessageToClient("admin");
                } else if (arbolClient.contains(username.getText()) && arbolClient.contains(password.getText())) {
                    server.sendMessageToClient("client");
                } else{
                    System.out.println("Contraseña o usuario equivocados");
                }
            }
        });

    }

    /**
     * Este metodo recibe el usuario y contraseña del cliente
     * @param messageFromClient
     * @param textField
     */
    public static void addLabel (String messageFromClient, TextField textField){
        Platform.runLater(new Runnable() {
            /**
             * Este metodo actualiza los textfield con la informacion requerida
             */
            @Override
            public void run() {
                textField.setText(messageFromClient);
            }
        });
    }
}
