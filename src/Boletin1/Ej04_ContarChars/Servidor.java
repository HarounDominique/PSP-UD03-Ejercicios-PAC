package Boletin1.Ej04_ContarChars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /*
     * Usando Sockets TCP realiza un programa cliente que introduzca cadenas por teclado
     * hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor.
     * El programa servidor aceptará la conexión de un único cliente
     * y por cada cadena recibida le devolverá al cliente el número de caracteres de la misma.
     * El programa servidor finalizará cuando reciba un asterisco como cadena.
     */
    public static void main(String[] args) {
        int puerto = 6000;// Puerto
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("[Servidor] Escuchando en " + servidor.getLocalPort());
            Socket cliente = servidor.accept(); //esperando a un cliente

            //realizar acciones con cliente
            String recibido;
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            DataInputStream dis = new DataInputStream(cliente.getInputStream());

            while (!(recibido = dis.readUTF()).equals("*")){
                System.out.println("Cadena recibida: " + recibido);
                dos.writeUTF("Recibidos " + recibido.length() + " caracteres");
            }

            //Cerrar recursos
            dis.close();
            dos.close();
            servidor.close(); //cierro socket servidor

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
