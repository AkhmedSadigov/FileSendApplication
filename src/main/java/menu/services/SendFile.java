package menu.services;

import connection.TCPClient;
import menu.services.interfaces.SendFileInterface;

public class SendFile implements SendFileInterface {

    @Override
    public void proccess() {
        try {
            TCPClient.connectServer();
        } catch (Exception ex) {
            String errorMessage = "The entered information is incorrect. Please try again!";
            System.out.println(errorMessage);
        }
    }

}
