package Ejercicios.Ej01_SocketsTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /*
     * Realiza un programa servidor TCP que acepte 3 clientes.
     * Para cada cliente, mostrar sus puertos local y remoto.
     * Se deberá implementar también el programa cliente que se conecte a dicho servidor.
     * Mostrar los puertos
     * locales y remotos a los que está conectado su socket, y la dirección IP de la máquina remota a la que se
     * conecta.
     *
     * */
    public static void main(String[] args) throws IOException {

        int puerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en " + servidor.getLocalPort());

        System.out.println("Esperando primer cliente");
        Socket cliente1= servidor.accept();//esperando a un cliente
        System.out.println("Primer cliente atendido");
        System.out.println("Puerto del cliente 1 getLocalPort(): " +cliente1.getLocalPort());
        System.out.println("Puerto del cliente 1 getPort(): " +cliente1.getPort() );

        System.out.println("Esperando segundo cliente");
        Socket cliente2 = servidor.accept();//esperando a otro cliente
        System.out.println("Segundo cliente atendido");
        System.out.println("Puerto del cliente 2 getLocalPort(): " +cliente2.getLocalPort());
        System.out.println("Puerto del cliente 2 getPort(): " +cliente2.getPort() );

        System.out.println("Esperando tercer cliente");
        Socket cliente3 = servidor.accept();//esperando a otro cliente
        System.out.println("Segundo cliente atendido");
        System.out.println("Puerto del cliente 3 getLocalPort(): " +cliente3.getLocalPort());
        System.out.println("Puerto del cliente 3 getPort(): " +cliente3.getPort() );

        //realizar acciones con cliente2
        servidor.close();	//cierro socket servido
    }
}
