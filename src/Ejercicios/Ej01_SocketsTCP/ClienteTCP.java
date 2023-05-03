package Ejercicios.Ej01_SocketsTCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;//puerto remoto

        // ABRIR SOCKET
        Socket cliente = new Socket(host, puerto);//conecta

        InetAddress i = cliente.getInetAddress ();
        System.out.println ("Puerto local: " + cliente.getLocalPort());
        System.out.println ("Puerto Remoto: " + cliente.getPort());
        System.out.println ("Nombre Host/IP: " + cliente.getInetAddress());
        System.out.println ("Host Remoto: " + i.getHostName());
        System.out.println ("IP Host Remoto: " + i.getHostAddress());

        cliente.close();// Cierra el socket
    }
}
