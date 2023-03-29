package Ejercicios.Ej_Minuscula;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;

public class Cliente {
    public static void main(String[] args) {
        String Host = "localhost";
        int Puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        try {
            //ABRIR SOCKET
            cliente = new Socket(Host, Puerto);
            InetAddress i = cliente.getInetAddress();
            //System.out.println("[Cliente] conectado");
            //System.out.println("[Cliente] Puerto local: " + Cliente.getLocalPort());
            //System.out.println("[Cliente] Puerto Remoto: " + Cliente.getPort());
            //System.out.println("[Cliente] Host Remoto: " + i.getHostName());
            //System.out.println("Cliente] IP Host Remoto: " + i.getHostAddress());

            DataInputStream dis = new DataInputStream(cliente.getInputStream());

            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

            dos.writeUTF(dis.readUTF().toLowerCase(Locale.ROOT));

            cliente.close(); //Cierra el socket
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
