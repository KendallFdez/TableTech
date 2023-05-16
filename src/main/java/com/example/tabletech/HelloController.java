package com.example.tabletech;

import BinarySearchTree.BinaryTree;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;
import Classes.Server;
import Classes.User;
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

public class HelloController implements Initializable {

    @FXML
    private TextField password;

    @FXML
    private AnchorPane serverApp;

    @FXML
    private TextField username;

    private Server server;

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
        //server.recieveUsername(username);
        server.recievePassword(password);
        if (arbolAdmin.contains(password.getText())){
            System.out.println("holis polis");
            //server.sendMessageToClient("admin");
            username.clear();
            password.clear();
        }
    }
    public static void addLabel (String messageFromClient, TextField textField){
        Text text = new Text(messageFromClient);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textField.setText(String.valueOf(text));
            }
        });
    }
}
