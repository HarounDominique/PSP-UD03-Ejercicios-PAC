package Boletin2.Ej01_Profesor;

import Boletin2.Ej01_Profesor.model.Profesor;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente; //conecta

        //Abrir socket
        cliente = new Socket(host, puerto);

        ObjectInputStream dis = new ObjectInputStream(cliente.getInputStream());
        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

        String cadena;
        do {
            System.out.println("Introduzca el id del profesor a consultar, * para salir.");
            cadena = new Scanner(System.in).nextLine();

            dos.writeUTF(cadena);

            Profesor profesor = (Profesor) dis.readObject();
            System.out.println(profesor.toString());

        } while (!cadena.equals("*"));

        //Cerrar recursos
        dis.close();
        dos.close();
        cliente.close(); //Cierra el socket

    }
}
