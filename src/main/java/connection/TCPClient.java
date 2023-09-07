package connection;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import util.FileUtility;
import util.MenuUtil;

public class TCPClient {

    public static void connectServer() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ip address and port:");
        String address = sc.nextLine();

        String[] arr = address.split(":");
        String ip = arr[0].trim();
        int port = Integer.parseInt(arr[1].trim());

        try (Socket socket = new Socket(ip, port);) {

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter the path of file that want to send:");
            String filePath = sc2.nextLine();

            byte[] bytes = FileUtility.readBytesFromFile(filePath);

            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);

            System.out.println("File sent succesfully by " + MenuUtil.name + " " + MenuUtil.surname + "\nNow it should accept from server");
        }
    }
}
