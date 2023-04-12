package Ejercicios.Ej03_Cuadrado;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String Host = "localhost";
        int Puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        try {
            //Abrir socket
            cliente = new Socket(Host, Puerto);
            InetAddress i = cliente.getInetAddress();
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

            double cuadrado = Math.pow(Integer.parseInt(dis.readUTF()), 2);
            dos.writeUTF(Double.toString(cuadrado));

            //Cerrar recursos
            cliente.close(); //Cierra el socket
            dis.close();
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
