package Boletin2.Ej01_Profesor;

import Boletin2.Ej01_Profesor.model.Profesor;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String Host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        try {
            String cadena;
            do {
                System.out.println("Introduzca el id del profesor a consultar, * para salir.");
                cadena = new Scanner(System.in).nextLine();

                //ABRIR SOCKET
                cliente = new Socket(Host, puerto);

                ObjectInputStream dis = new ObjectInputStream(cliente.getInputStream());
                DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

                dos.writeUTF(cadena);

                try {
                    Profesor profesor = (Profesor) dis.readObject();
                    System.out.println(profesor.toString());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


                //Cerrar recursos
                cliente.close(); //Cierra el socket
                dis.close();
                dos.close();
            } while (!cadena.equals("*"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
