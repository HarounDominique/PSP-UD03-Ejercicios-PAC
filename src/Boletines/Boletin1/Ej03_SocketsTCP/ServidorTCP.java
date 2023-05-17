package Boletines.Boletin1.Ej03_SocketsTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /*
     * Realiza un programa servidor TCP que acepte 2 clientes.
     * Mostrar para cada cliente conectados sus puertos local y remoto.
     * Implementar también el programa cliente, donde se muestren los puertos locales
     * y remotos a los que se encuentre conectado, asi como la IP de la máquina remota a la que se conecta.
     */
    public static void main(String[] args) throws IOException {

        int puerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en " + servidor.getLocalPort());

        System.out.println("Esperando primer cliente");
        Socket cliente1= servidor.accept();//esperando a un cliente
        System.out.println("Primer cliente atendido");
        System.out.println("Puerto del cliente 1 getLocalPort(): " + cliente1.getLocalPort());
        System.out.println("Puerto del cliente 1 getPort(): " + cliente1.getPort() );

        System.out.println("Esperando segundo cliente");
        Socket cliente2 = servidor.accept();//esperando a otro cliente
        System.out.println("Segundo cliente atendido");
        System.out.println("Puerto del cliente 2 getLocalPort(): " + cliente2.getLocalPort());
        System.out.println("Puerto del cliente 2 getPort(): " + cliente2.getPort() );

        servidor.close();	//cierro socket servidor
    }
}
