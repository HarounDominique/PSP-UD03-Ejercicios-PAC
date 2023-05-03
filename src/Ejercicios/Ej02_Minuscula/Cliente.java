package Ejercicios.Ej02_Minuscula;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        try {
            //ABRIR SOCKET
            cliente = new Socket(host, puerto);
            InetAddress i = cliente.getInetAddress();

            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

            dos.writeUTF(dis.readUTF().toLowerCase(Locale.ROOT));

            //Cerrar recursos
            dis.close();
            dos.close();
            cliente.close(); //Cierra el socket

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
