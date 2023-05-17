package Classes;

import com.example.tabletech.HelloApplication;
import com.example.tabletech.HelloController;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase crea el server que sea utilizado
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    /**
     * Define las caracteristicas del server
     * @param serverSocket
     */
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

    /**
     * Este metodo envia un mensaje al cliente
     * @param messageToClient
     */
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

    /**
     * Este metodo recive un mensaje del cliente
     * @param userfld
     * @param passwordfld
     */
    public void recieveMessageFromClient(TextField userfld, TextField passwordfld){
        new Thread(new Runnable() {
            /**
             * Este metodo corre el metodo recieveMessageFromClient
             */
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String username = bufferedReader.readLine();
                        HelloController.addLabel(username, userfld);


                        String password = bufferedReader.readLine();
                        HelloController.addLabel(password, passwordfld);

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

    /**
     * Este metodo cierra todos los sockets y buffers
     * @param socket
     * @param bufferedReader
     * @param bufferedWriter
     */
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
