package boletin1.Ej04_ContarChars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String Host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        DataInputStream dis;
        DataOutputStream dos;

        String cadena;
        Scanner sc = new Scanner(System.in);

        try {
                //ABRIR SOCKET
                cliente = new Socket(Host, puerto);

                dis = new DataInputStream(cliente.getInputStream());

                dos = new DataOutputStream(cliente.getOutputStream());

                do {
                    System.out.println("Introduzca un texto por teclado, * para salir");
                    cadena = sc.nextLine();
                    dos.writeUTF(cadena);

                    System.out.println(dis.readUTF());

                } while (!cadena.equals("*"));

            //Cerrar recursos
            cliente.close(); //Cierra el socket
            dis.close();
            dos.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
