package Ejercicios.Ej02_Minuscula;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /*
     * Realiza un programa servidor TCP que acepte 3 clientes
     * Para cada cliente, mostrar los puertos local y remotos.
     *
     * Se deberá implementar el programa cliente que se conecea dicho servidor.
     * Mostrar los puertos locales y remotos a los que está conectado su socket,
     * y la dirección IP de la máquina remota a la que se conecta.
     */

    public static void main(String[] args) {
        int puerto = 6000;// Puerto
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("[Servidor] Escuchando en " + servidor.getLocalPort());
            Socket cliente = servidor.accept(); //esperando a un cliente

            //realizar acciones con cliente
            String mensaje = "MENSAJE MAYÚSCULAS";
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Enviando: " + mensaje);
            dos.writeUTF(mensaje);

            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            System.out.println("ECHO => " + dis.readUTF());

            //Cerrar recursos
            servidor.close(); //cierro socket servidor
            dis.close();
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
