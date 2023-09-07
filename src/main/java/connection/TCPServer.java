package connection;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import util.FileUtility;

public class TCPServer {

    public static void main(String[] args) throws Exception {
        openServer();
    }

    public static void openServer() throws Exception {
        try (ServerSocket server = new ServerSocket(5678);) {

            while (true) {
                try {
                    System.out.println("Waiting for connection...");
                    Socket socket = server.accept();

                    System.out.println("Client is connected to server");
                    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                    byte[] bytes = FileUtility.readBytesFromStream(dataInputStream);

                    System.out.println("File sent by client!");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter path where will file save: ");
                    String fileName = sc.nextLine();

                    FileUtility.writeBytes(fileName, bytes);
                    System.out.println("File saved on system!");
                } catch (Exception ex) {
                    System.out.println("Error!!!\nClient entered some invalid information");
                }
            }
        }
    }
}
