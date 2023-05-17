package Boletines.Boletin1.Ej04_ContarChars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        DataInputStream dis;
        DataOutputStream dos;

        String cadena;
        Scanner sc = new Scanner(System.in);

        try {
                //ABRIR SOCKET
                cliente = new Socket(host, puerto);

                dis = new DataInputStream(cliente.getInputStream());
                dos = new DataOutputStream(cliente.getOutputStream());

                do {
                    System.out.println("Introduzca un texto por teclado, * para salir");
                    cadena = sc.nextLine();
                    dos.writeUTF(cadena);

                    System.out.println(dis.readUTF());

                } while (!cadena.equals("*"));

            //Cerrar recursos
            dis.close();
            dos.close();
            cliente.close(); //Cierra el socket

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
