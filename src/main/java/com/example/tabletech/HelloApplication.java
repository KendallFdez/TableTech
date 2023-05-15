package com.example.tabletech;

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

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("ServerApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
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
        }launch();
    }
}