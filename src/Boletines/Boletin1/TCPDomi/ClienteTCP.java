package Boletines.Boletin1.TCPDomi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    private static int port;

    //lo primero será crear un main, recordemos que tanto cliente como servidor deben poder iniciarse
    public static void main(String[] args) {
        //para crear un socket cliente que apunte a un cliente servidor, lo primero que necesito es el
        // host y el puerto del recurso remoto (servidor):
        String host = "localhost";
        int port = 6000;

        //instancio el socket cliente en un try with resources
        try( Socket clientSocket = new Socket(host, port)){
            InetAddress i = clientSocket.getInetAddress();

            System.out.println("Puerto remoto: "+clientSocket.getPort());
            System.out.println("Host remoto: "+i.getHostAddress());
            System.out.println("Puerto local: "+clientSocket.getLocalPort());
            System.out.printf("Host local: "+clientSocket.getInetAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
