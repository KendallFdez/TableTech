package Classes;

import com.example.tabletech.HelloApplication;
import com.example.tabletech.HelloController;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket){
        try{
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch(IOException e){
            System.out.println("Error creando servidor");
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(String messageToClient){
        try{
            bufferedWriter.write(messageToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error enviando mensaje al cliente");
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    public void recieveUsername(TextField userfld){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String username = bufferedReader.readLine();
                        System.out.println(username);
                    }catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Error reciviendo username del cliente");
                        closeAll(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void recievePassword(TextField passwordfld){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String password = bufferedReader.readLine();
                        HelloController.addLabel(password, passwordfld);
                        System.out.println("olis");
                    }catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Error reciviendo password del cliente");
                        closeAll(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
