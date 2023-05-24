package Boletines.Boletin1.TCPDomi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    //recordemos que el primer paso tanto en el lado cliente como en el lado servidor es abrir un main
    public static void main(String[] args) {
        //recoredemos que el puerto en el que estará escuchando el servidor es el 6000 (lo establecimos así en el cliente)
        int port = 6000;
        //instanciamos el serverSocket
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Escuchando en el puerto 6000...");
            Socket clienteSocket1 = serverSocket.accept();
            System.out.println("Recibiendo conexión con cliente:");
            System.out.println("Puerto del cliente: "+clienteSocket1.getPort());
            System.out.println("Cliente conectado al puerto: "+clienteSocket1.getLocalPort());
            System.out.println("Conectado con un cliente. Cerrando conexión.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
